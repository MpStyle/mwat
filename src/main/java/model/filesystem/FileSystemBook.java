package model.filesystem;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import java.io.File;

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
 * Classe utility che raccoglie funzionalità atomiche riguardanti operazione da effettuare sul file system.
 */
public final class FileSystemBook {
  private static Logger LOGGER = Logger.getLogger(FileSystemBook.class);

  /**
   * Crea una cartella/directory.<br />
   * Non la crea se esiste già.<br />
   * Lancia un'eccezione se non ci riesce.
   *
   * @param folder
   * @throws Exception
   */
  public static void createFolder(File folder) throws Exception {
    if (folder.exists()) {
      LOGGER.info("The output folder already exists.");
      return;
    }

    if (!folder.mkdir()) {
      LOGGER.error("It's impossible to create the output folder");
      throw new Exception("It's impossible to create the output folder");
    }
  }

  /**
   * Overriding del metodo {@link #deleteFolder(File) deleteFolder(File)}
   *
   * @param folder
   * @throws Exception
   */
  public static void deleteFolder(String folder) throws Exception {
    FileSystemBook.deleteFolder(new File(folder));
  }

  /**
   * Cancella ricorsivamente il contenuto di <i>folder</i>.
   *
   * @param folder
   * @throws Exception
   */
  public static void deleteFolder(File folder) throws Exception {
    File[] files = folder.listFiles();
    if (files != null) {
      for (File f : files) {
        if (f.isDirectory()) {
          deleteFolder(f);
        } else {
          if (!f.delete()) {
            throw new Exception(String
                .format("Impossible to delete the folder %s",
                    f.getAbsolutePath()));
          }
        }
      }
    }

    if (!folder.delete()) {
      throw new Exception(String.format("Impossible to delete the folder %s",
          folder.getAbsolutePath()));
    }
  }

  /**
   * Se necessario crea la cartella di destinazione <i>folderPath</i> e salva il file <i>fileName</i>
   * con contenuto <i>content</i> all'interno di essa.
   *
   * @param content
   * @param fileName
   * @param folderPath
   * @throws Exception
   */
  public static void saveFile(String content, String fileName,
      String folderPath, String fileEncode) throws Exception {
    FileSystemBook.createFolder(new File(folderPath));
    final File f = new File(folderPath + File.separator + fileName);
    FileUtils.writeStringToFile(f, content, fileEncode);
  }
}
