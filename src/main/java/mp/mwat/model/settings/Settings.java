package mp.mwat.model.settings;

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

public class Settings {
  public final static String CURRENT_VERSION = "1.0-SNAPSHOT";
  public final static String DEFAULT_FILE_ENCODE = "UTF-8";
  public final static String DEFAULT_TRANSLATION_PROPERTY = "tr";

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
