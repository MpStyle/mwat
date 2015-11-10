package model.jsonfile;

import model.string.StringBook;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class JSONFileBook {
  public static final String JSON_FILE_EXTENSION = ".json";

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
