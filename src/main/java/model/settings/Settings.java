package model.settings;

public class Settings {
  private final static String DEFAULT_FILE_ENCODE = "UTF-8";
  private final static String DEFAULT_TRANSLATION_PROPERTY = "tr";

  private String translationProperty = DEFAULT_TRANSLATION_PROPERTY;
  private String htmlInputPath, jsonLanguagesInput, htmlOutputPath, fileEncode = DEFAULT_FILE_ENCODE;
  private boolean emptyOutputFolder = false;

  public boolean isEmptyOutputFolder() {
    return emptyOutputFolder;
  }

  public Settings setEmptyOutputFolder(boolean emptyOutputFolder) {
    this.emptyOutputFolder = emptyOutputFolder;
    return this;
  }

  public static Settings getSettings() {
    return new Settings();
  }

  public static String getDefaultFileEncode() {
    return DEFAULT_FILE_ENCODE;
  }

  public static String getDefaultTranslationProperty() {
    return DEFAULT_TRANSLATION_PROPERTY;
  }

  public String getTranslationProperty() {
    return translationProperty;
  }

  public Settings setTranslationProperty(String translationProperty) {
    this.translationProperty = translationProperty;
    return this;
  }

  public String getHtmlInputPath() {
    return htmlInputPath;
  }

  public Settings setHtmlInputPath(String htmlInputPath) {
    this.htmlInputPath = htmlInputPath;
    return this;
  }

  public String getJsonLanguagesInput() {
    return jsonLanguagesInput;
  }

  public Settings setJsonLanguagesInput(String jsonLanguagesInput) {
    this.jsonLanguagesInput = jsonLanguagesInput;
    return this;
  }

  public String getHtmlOutputPath() {
    return htmlOutputPath;
  }

  public Settings setHtmlOutputPath(String htmlOutputPath) {
    this.htmlOutputPath = htmlOutputPath;
    return this;
  }

  public String getFileEncode() {
    return fileEncode;
  }

  public Settings setFileEncode(String fileEncode) {
    this.fileEncode = fileEncode;
    return this;
  }
}
