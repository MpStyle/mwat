package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.filesystem.FileSystemBook;
import model.htmlfile.HTMLFile;
import model.htmlfile.HTMLFileBook;
import model.jsonfile.JSONFile;
import model.jsonfile.JSONFileBook;
import model.settings.Settings;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/*
 * This file is part of mwat.
 *
 * mwat is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * mwat is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with mwat.  If not, see <http://www.gnu.org/licenses/>.
 */

/**
 * Questa classe implementa le operazioni da eseguire per tradurre le diverse view.<br />
 * Per eseguire la traduzione avviare il metodo {@link #start() start}.<br />
 * Scorre tutti i file JSON delle traduzioni e tutti i file delle viste (HTML),
 * creando delle view (HTML) tradutti.<br />
 * Per ulteriori dettagli: {@link #run() run}
 */
public class MWAT {
  private final static Logger LOGGER = Logger.getLogger(MWAT.class);
  private final ObjectMapper JSON_MAPPER = new ObjectMapper();

  private Settings settings;
  private List<JSONFile> jsList;
  private List<HTMLFile> htmlinputFileList;

  public MWAT(Settings settings) {
    this.settings = settings;
  }

  /**
   * Il metodo <i>start</i> ha il solo compito di incapsulare la chiamata al metodo {@link #run() run},
   * stampando le eventuali eccezioni provocate dalla sua esecuzione.
   */
  public void start() {
    try {
      run();
    } catch (Exception ex) {
      LOGGER.error(ex);
    }
  }

  /**
   * Il metodo run scorre tutti i file <i>.json</i> presenti nella cartella <i>jsonLanguagesInput</i>,
   * scorre tutti i file <i>.html</i> presenti nella cartella <i>htmlInputPath</i> e se in questi trova
   * dei tag con proprietà <i>tr</i> prepend la traduzione.<br />
   * Al termine salve un file <i>.html</i> di output.
   */
  protected void run() throws Exception {
    jsList = JSONFileBook.getJSONFile(settings.getJsonLanguagesInput());
    htmlinputFileList = HTMLFileBook
        .getHTMLFileList(settings.getHtmlInputPath(),
            settings.getHtmlInputPath());

    if (jsList.size() <= 0) {
      LOGGER.info("Files of translations not found.");
      return;
    }

    if (htmlinputFileList.size() <= 0) {
      LOGGER.info("HTML input files not found.");
      return;
    }

    File output = new File(settings.getHtmlOutputPath());
    if (settings.isEmptyOutputFolder()) {
      LOGGER.info("Empty output folder...");
      FileSystemBook.deleteFolder(output);
      LOGGER.info("Empty output folder completed.");
    }
    FileSystemBook.createFolder(output);

    parseTranslations();
  }

  /**
   * Scorre tutti i file .json delle traduzioni e per ogni file chiama il metodo
   * {@link #parseViews(HashMap, String) parseViews}.
   *
   * @throws IOException
   */
  private void parseTranslations() throws IOException {
    for (JSONFile js : jsList) {

      HashMap<String, String> entries = JSON_MAPPER
          .readValue(new File(js.getPath()), HashMap.class);

      parseViews(entries, js.getName());
    }
  }

  private void parseViews(HashMap<String, String> entries, String jsName) {
    try {
      for (HTMLFile htmlInputFile : htmlinputFileList) {
        File input = new File(htmlInputFile.getAbsoluteFilePath());
        Document doc = Jsoup.parse(input, settings.getFileEncode());

        doc = HTMLFileBook
            .translateHtml(doc, entries, settings.getTranslationProperty(),
                jsName);
        if (doc == null) {
          throw new Exception("Unknow error in the translation");
        }

        String outputPath =
            settings.getHtmlOutputPath() + File.separator + jsName
                + File.separator + htmlInputFile.getRelativeFolderPath();

        FileSystemBook
            .saveFile(doc.outerHtml(), htmlInputFile.getFileName(), outputPath,
                settings.getFileEncode());
      }
    } catch (Exception ex) {
      LOGGER.error(ex);
    }
  }
}
