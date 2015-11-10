package model.jsonfile;

import model.string.StringBook;

import java.io.File;
import java.util.ArrayList;
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
