package model.htmlfile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe di utility che raccoglie le operazioni atomiche che si possono effettuare
 * sui file .html.
 */
public class HTMLFile {
  private static final String HTML_FILE_EXTENSION = ".html";

  /**
   * Restituisce un elenco di stringhe che rappresentano i path dei file
   * contenuti nella cartella <i>htmlInputFolder</i>.
   *
   * @param htmlFolder
   * @return
   */
  public static List<String> getHTMLFile(String htmlFolder) {
    ArrayList<String> fileList = new ArrayList<String>();
    File folder = new File(htmlFolder);

    for (final File fileEntry : folder.listFiles()) {
      if(fileEntry.getName().endsWith(HTML_FILE_EXTENSION)) {
        fileList.add(fileEntry.getAbsolutePath());
      }
    }

    return fileList;
  }
}
