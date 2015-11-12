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
package mp.mwat.model.filesystem.file;

import java.io.File;
import java.io.FilenameFilter;

/**
 * Classe che estende FilenameFilter, specializzata nella ricerca di file data l'estensione.
 */
public class FileExtensionFilter implements FilenameFilter {
  private final String extension;

  /**
   * Il costruttore riceverà il nome dell'estensione e si preoccuperà di aggiungere
   * all'inizio della stringa il punto nel caso della sua assenza.
   *
   * @param extension
   */
  public FileExtensionFilter(String extension) {
    if (!extension.startsWith(".")) {
      this.extension = "." + extension;
    } else {
      this.extension = extension;
    }
  }

  /**
   * Filtra l'elenco dei file per estensione.
   *
   * @param dir  the directory in which the file was found.
   * @param name the name of the file.
   * @return <code>true</code> if and only if the name should be
   * included in the file list; <code>false</code> otherwise.
   */
  public boolean accept(File dir, String name) {
    String lowercaseName = name.toLowerCase();
    return lowercaseName.endsWith(extension);
  }
}
