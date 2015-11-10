package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.dir.FileSystemBook;
import model.htmlfile.HTMLFile;
import model.jsonfile.JSONFile;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * Questa classe implementa le operazioni da eseguire per tradurre le diverse view.<br />
 * Per eseguire la traduzione avviare il metodo {@link #start() start}.<br />
 * Scorre tutti i file JSON delle traduzioni e tutti i file delle viste (HTML),
 * creando delle view (HTML) tradutti.<br />
 * Per ulteriori dettagli: {@link #run() run}
 */
public class MWAT {
  private final static Logger LOGGER = Logger.getLogger(MWAT.class);
  private final static String DEFAULT_FILE_ENCODE = "UTF-8";

  private final ObjectMapper JSON_MAPPER = new ObjectMapper();

  private String translationProperty = "tr";
  private String translationPropertyQuery = "[" + translationProperty + "]";
  private String htmlInputPath, jsonLanguagesInput, htmlOutputPath, fileEncode;
  private boolean emptyOutputFolder = false;
  private List<JSONFile> jsList;
  private List<String> htmlinputFileList;

  /**
   * Il costruttore riceve le cartelle di input delle traduzioni e delle view da tradurre e
   * la cartella di output delle view tradotte.<br />
   * L'encode dei file di input delle view da tradurre e dei file di output delle view
   * tradotte sarà di defaul UTF-8.
   *
   * @param htmlInputPath      Path della cartella di input delle view da tradurre.
   * @param jsonLanguagesInput Path della cartella di input delle traduzioni (file .json).
   * @param htmlOutputPath     Path della cartella di output delle view tradotte.
   */
  public MWAT(String htmlInputPath, String jsonLanguagesInput,
      String htmlOutputPath) {
    this(htmlInputPath, jsonLanguagesInput, htmlOutputPath,
        DEFAULT_FILE_ENCODE);
  }

  /**
   * Restituisce le proprietà che indica se svuotare la cartella di output prima di
   * creare le view tradotte.
   *
   * @return
   */
  public boolean isEmptyOutputFolder() {
    return emptyOutputFolder;
  }

  /**
   * Se impostato a true cancellerà il contenuto della cartella di destinazione
   * delle view tradotte.
   *
   * @param emptyOutputFolder
   */
  public void setEmptyOutputFolder(boolean emptyOutputFolder) {
    this.emptyOutputFolder = emptyOutputFolder;
  }

  /**
   * Il costruttore riceve le cartelle di input delle traduzioni e delle view da tradurre e
   * la cartella di output delle view tradotte.<br />
   * L'encode dei file di input delle view da tradurre e dei file di output delle view
   * tradotte sarà <i>fileEncode</i>.
   *
   * @param htmlInputPath      Path della cartella di input delle view da tradurre.
   * @param jsonLanguagesInput Path della cartella di input delle traduzioni (file .json).
   * @param htmlOutputPath     Path della cartella di output delle view tradotte.
   * @param fileEncode
   */
  public MWAT(String htmlInputPath, String jsonLanguagesInput,
      String htmlOutputPath, String fileEncode) {
    this.htmlInputPath = htmlInputPath;
    this.htmlOutputPath = htmlOutputPath;
    this.jsonLanguagesInput = jsonLanguagesInput;
    this.fileEncode = fileEncode;
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
  protected void run() throws IOException, Exception {
    jsList = JSONFile.getJSONFile(jsonLanguagesInput);
    htmlinputFileList = HTMLFile.getHTMLFile(htmlInputPath);

    if (jsList.size() <= 0) {
      LOGGER.info("Files of translations not found.");
      return;
    }

    if (htmlinputFileList.size() <= 0) {
      LOGGER.info("HTML input files not found.");
      return;
    }

    File output = new File(htmlOutputPath);
    if (emptyOutputFolder) {
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
      for (String htmlinputFile : htmlinputFileList) {
        File input = new File(htmlinputFile);
        Document doc = Jsoup.parse(input, fileEncode);

        Elements toTranslateList = doc.select(translationPropertyQuery);

        for (Element toTranslate : toTranslateList) {
          String key = toTranslate.attr(translationProperty);

          if (!entries.containsKey(key)) {
            LOGGER.warn(String
                .format("No translation for key %s in %s%s file.", key, jsName,
                    JSONFile.JSON_FILE_EXTENSION));
            continue;
          }

          String translation = entries.get(key);
          toTranslate.prependText(translation);
        }

        String outputFilePath = htmlOutputPath + File.separator + jsName;
        FileSystemBook.createFolder(new File(outputFilePath));
        final File f = new File(
            outputFilePath + File.separator + input.getName());
        FileUtils.writeStringToFile(f, doc.outerHtml(), fileEncode);
      }
    } catch (Exception ex) {
      LOGGER.error(ex);
    }
  }

  /**
   * @return
   */
  public String getTranslationProperty() {
    return translationProperty;
  }

  /**
   * Setta la proprietà dei tag HTML che indicano dove inserire il testo tradotto.
   *
   * @param translationProperty
   */
  public void setTranslationProperty(String translationProperty) {
    this.translationProperty = translationProperty;
    this.translationPropertyQuery = "[" + this.translationProperty + "]";
  }
}
