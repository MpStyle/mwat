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

public class HTMLFile {
  private String fileName;
  private String relativeFolderPath;
  private String absoluteFolderPath;

  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  public String getRelativeFolderPath() {
    return relativeFolderPath;
  }

  public void setRelativeFolderPath(String relativeFolderPath) {
    this.relativeFolderPath = relativeFolderPath;
  }

  public String getAbsoluteFolderPath() {
    return absoluteFolderPath;
  }

  public void setAbsoluteFolderPath(String absoluteFolderPath) {
    this.absoluteFolderPath = absoluteFolderPath;
  }

  public String getAbsoluteFilePath(){
    return getAbsoluteFolderPath()+ File.separator+getFileName();
  }

  public String getRelativeFilePath(){
    return getRelativeFolderPath()+ File.separator+getFileName();
  }
}
