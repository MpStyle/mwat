package model.htmlfile;

import java.io.File;

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
