package model.jsonfile;

import model.string.StringBook;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Incampsula le proprietà dei file JSON che contengono le traduzioni delle stringhe.<br />
 * Le proprietà sono:
 * <ul>
 *   <li>Il nome della traduzione, per esempio: it, fr, etc...</li>
 *   <li>Il path del file.</li>
 * </ul>
 */
public class JSONFile {
  public static final String JSON_FILE_EXTENSION = ".json";
  private String name;
  private String path;

  /**
   * Restituisce il nome, senza estensione del file JSON.
   * @return
   */
  public String getName() {
    return name;
  }

  /**
   * Setta il nome, dovrà essere senza estensione, del file JSON.
   *
   * @param name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Restituisce la path del file JSON delle traduzioni.
   *
   * @return
   */
  public String getPath() {
    return path;
  }

  /**
   * Setta la path del file JSON delle traduzioni.
   *
   * @param path
   */
  public void setPath(String path) {
    this.path = path;
  }

  /**
   * Restituisce un elenco di File che sono contenuti della cartella <i>htmlInputFolder</i>.
   *
   * @param jsonFolder
   * @return
   */
  public static List<JSONFile> getJSONFile(String jsonFolder) {
    ArrayList<JSONFile> fileList = new ArrayList<JSONFile>();
    File folder = new File(jsonFolder);

    for (final File fileEntry : folder.listFiles()) {
      if (fileEntry.getName().endsWith(JSON_FILE_EXTENSION)) {
        JSONFile jf = new JSONFile();
        jf.setName(
            StringBook.removeString(fileEntry.getName(), JSON_FILE_EXTENSION));
        jf.setPath(fileEntry.getAbsolutePath());

        fileList.add(jf);
      }
    }

    return fileList;
  }
}
