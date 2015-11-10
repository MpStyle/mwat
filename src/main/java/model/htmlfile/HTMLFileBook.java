package model.htmlfile;

import model.jsonfile.JSONFileBook;
import model.string.StringBook;
import org.apache.log4j.Logger;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Classe di utility che raccoglie le operazioni atomiche che si possono effettuare
 * sui file .html.
 */
public class HTMLFileBook {
  private static final Logger LOGGER = Logger.getLogger(HTMLFileBook.class);
  private static final String HTML_FILE_EXTENSION = ".html";

  /**
   * Restituisce un elenco di stringhe che rappresentano i path dei file
   * contenuti nella cartella <i>htmlInputFolder</i>.
   *
   * @param htmlFolder
   * @return
   */
  public static List<HTMLFile> getHTMLFileList(String htmlFolder,
      String rootFolder) {
    ArrayList<HTMLFile> fileList = new ArrayList<HTMLFile>();
    File folder = new File(htmlFolder);

    for (final File fileEntry : folder.listFiles()) {
      if (fileEntry.isDirectory()) {
        fileList.addAll(HTMLFileBook
            .getHTMLFileList(fileEntry.getAbsolutePath(), rootFolder));
        continue;
      }

      if (!fileEntry.isFile() || !fileEntry.getName()
          .endsWith(HTML_FILE_EXTENSION)) {
        continue;
      }

      HTMLFile file = new HTMLFile();
      file.setFileName(fileEntry.getName());
      file.setAbsoluteFolderPath(StringBook
          .removeString(fileEntry.getAbsolutePath(), fileEntry.getName()));
      file.setRelativeFolderPath(
          StringBook.removeString(file.getAbsoluteFolderPath(), rootFolder));

      fileList.add(file);
    }

    return fileList;
  }

  public static Document translateHtml(Document doc,
      HashMap<String, String> entries, String translationProperty,
      String jsName) {

    Elements toTranslateList = doc.select("[" + translationProperty + "]");

    for (Element toTranslate : toTranslateList) {
      String key = toTranslate.attr(translationProperty);

      if (!entries.containsKey(key)) {
        LOGGER.warn(String
            .format("No translation for key %s in %s%s file.", key, jsName,
                JSONFileBook.JSON_FILE_EXTENSION));
        continue;
      }

      String translation = entries.get(key);
      toTranslate.prependText(translation);
    }

    return doc;
  }
}
