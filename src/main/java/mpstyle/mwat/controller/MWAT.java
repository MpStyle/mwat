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
package mpstyle.mwat.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import mpstyle.mwat.model.htmlfile.HTMLFile;
import mpstyle.mwat.model.htmlfile.HTMLFileBook;
import mpstyle.mwat.model.jsonfile.JSONFile;
import mpstyle.mwat.model.jsonfile.JSONFileBook;
import mpstyle.mwat.model.settings.Settings;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import mpstyle.mwat.model.filesystem.file.FileBook;
import mpstyle.mwat.model.filesystem.folder.FolderBook;
import mpstyle.mwat.model.operation.AbstractOperation;

/**
 * Questa classe implementa le operazioni da eseguire per tradurre le diverse
 * view.<br>
 * Per eseguire la traduzione avviare il metodo {@link #start() start}.<br>
 * Scorre tutti i file JSON delle traduzioni e tutti i file delle viste (HTML),
 * creando delle view (HTML) tradutti.<br>
 * Per ulteriori dettagli: {@link #run() run}
 */
public class MWAT extends AbstractOperation
{

    private final static Logger LOGGER = Logger.getLogger(MWAT.class);
    private final ObjectMapper JSON_MAPPER = new ObjectMapper();

    private final Settings settings;
    private List<JSONFile> jsList;
    private List<HTMLFile> htmlinputFileList;

    public MWAT(Settings settings)
    {
        this.settings = settings;
    }

    /**
     * Il metodo run scorre tutti i file <i>.json</i> presenti nella cartella
     * <i>jsonLanguagesInput</i>, scorre tutti i file <i>.html</i> presenti
     * nella cartella <i>htmlInputPath</i> e se in questi trova dei tag con
     * proprietà <i>tr</i> prepend la traduzione.<br>
     * Al termine salve un file <i>.html</i> di output.
     */
    protected void run()
    {
        try
        {
            jsList = JSONFileBook.getJSONFile(settings.getJsonLanguagesInput());
            htmlinputFileList = HTMLFileBook
                .getHTMLFileList(settings.getHtmlInputPath(),
                                 settings.getHtmlInputPath());

            if (jsList.size() <= 0)
            {
                LOGGER.info("Files of translations not found.");
                return;
            }

            if (htmlinputFileList.size() <= 0)
            {
                LOGGER.info("HTML input files not found.");
                return;
            }

            File output = new File(settings.getHtmlOutputPath());
            if (settings.isEmptyOutputFolder())
            {
                LOGGER.info("Empty output folder...");
                FolderBook.deleteFolder(output);
                LOGGER.info("Empty output folder completed.");
            }
            FolderBook.createFolder(output);

            parseTranslations();
        }
        catch (Exception ex)
        {
            LOGGER.debug(ex);
        }
    }

    /**
     * Scorre tutti i file .json delle traduzioni e per ogni file chiama il
     * metodo {@link #parseViews(HashMap, String) parseViews}.
     *
     * @throws IOException
     */
    private void parseTranslations() throws IOException {
        for (JSONFile js : jsList)
        {
            HashMap<String, String> entries;

            try {
                entries = JSON_MAPPER
                        .readValue(new File(js.getPath()), HashMap.class);
            }
            catch(Exception ex){
                LOGGER.info("Invalid json: " + js.getPath());
                throw ex;
            }

            parseViews(entries, js.getName());
        }
    }

    /**
     * Scorre tutte le view HTML che devono essere tradotte. Cercando la
     * proprietà
     * <i>segnaposto</i> che indicano quale traduzione utilizzare e prepend del
     * testo localizzato.
     *
     * @param entries Mappa chiave-valore delle traduzioni.
     * @param jsName  Identificativo della traduzione.
     */
    private void parseViews(HashMap<String, String> entries, String jsName)
    {
        try
        {
            for (HTMLFile htmlInputFile : htmlinputFileList)
            {
                File input = new File(htmlInputFile.getAbsoluteFilePath());
                Document doc = Jsoup.parse(input, settings.getFileEncode());

                doc = HTMLFileBook
                    .translateHtml(doc, entries, settings.getTranslationProperty(),
                                   jsName);
                if (doc == null)
                {
                    throw new Exception("Unknow error in the translation");
                }

                String outputPath
                       = settings.getHtmlOutputPath() + File.separator + jsName
                    + File.separator + htmlInputFile.getRelativeFolderPath();

                boolean result = FileBook
                    .saveFile(doc.outerHtml(), htmlInputFile.getFileName(), outputPath,
                              settings.getFileEncode());

                if(!result){
                    LOGGER.error(String.format("The translated view %s\\%s isn't savad correctly.", outputPath, htmlInputFile.getFileName()));
                }
            }
        }
        catch (Exception ex)
        {
            LOGGER.debug(ex);
        }
    }
}
