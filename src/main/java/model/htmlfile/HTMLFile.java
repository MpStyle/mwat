package model.htmlfile;

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
 * Incampsula le proprietà dei file HTML da tradurre.<br />
 * Le proprietà sono:
 * <ul>
 * <li>Il nome del file senza path</li>
 * <li>La path assoluta senza nome del file</li>
 * <li>La path relativa senza nome del file</li>
 * </ul>
 */
public class HTMLFile {
  private String fileName;
  private String relativeFolderPath;
  private String absoluteFolderPath;

  /**
   * Restituisce il nome del file senza la path.
   *
   * @return Nome del file senza la path.
   */
  public String getFileName() {
    return fileName;
  }

  /**
   * Setta il nome del file. Non dovrà contenere la path.
   *
   * @param fileName
   */
  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  /**
   * Restituisce la path relativa del file senza nome.
   *
   * @return Path relativa del file senza nome.
   */
  public String getRelativeFolderPath() {
    return relativeFolderPath;
  }

  /**
   * Setta la path relativa del file. Non dovrà contenere il nome del file.
   *
   * @param relativeFolderPath Path relativa del file. Non dovrà contenere il nome del file.
   */
  public void setRelativeFolderPath(String relativeFolderPath) {
    this.relativeFolderPath = relativeFolderPath;
  }

  /**
   * Restituisce la path assoluta del file senza nome.
   *
   * @return Path assoluta del file senza nome.
   */
  public String getAbsoluteFolderPath() {
    return absoluteFolderPath;
  }

  /**
   * Setta la path assoluta del file. Non dovrà contenere il nome del file.
   *
   * @param absoluteFolderPath Path assoluta del file. Non dovrà contenere il nome del file.
   */
  public void setAbsoluteFolderPath(String absoluteFolderPath) {
    this.absoluteFolderPath = absoluteFolderPath;
  }

  /**
   * Restituisce la path assoluta del file.
   *
   * @return Path assoluta del file.
   */
  public String getAbsoluteFilePath(){
    return getAbsoluteFolderPath()+ File.separator+getFileName();
  }

  /**
   * Restituisce la path relativa del file.
   *
   * @return Path relativa del file.
   */
  public String getRelativeFilePath(){
    return getRelativeFolderPath()+ File.separator+getFileName();
  }
}
