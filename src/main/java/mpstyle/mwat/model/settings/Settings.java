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
package mpstyle.mwat.model.settings;

/**
 * The class contains the data to pass to the mwat engine.<br>
 * It contains the folder of input of HTML files to parse, the JSON files of the translations,
 * the folder of output where the translated HTML files will be write and other settings.<br>
 * Fluent implementation.
 */
public class Settings
{

    public final static String CURRENT_VERSION = "1.0-SNAPSHOT";
    public final static String DEFAULT_FILE_ENCODE = "UTF-8";
    public final static String DEFAULT_TRANSLATION_PROPERTY = "tr";

    private String translationProperty = DEFAULT_TRANSLATION_PROPERTY;
    private String htmlInputPath, jsonLanguagesInput, htmlOutputPath, fileEncode = DEFAULT_FILE_ENCODE;
    private boolean emptyOutputFolder = false;

    private Settings(){}

    /**
     * Returns if it is necessary to remove all files in the output folder before
     * write the translated HTML file.
     *
     * @return If it is necessary to remove all files in the output folder before
     * write the translated HTML file.
     */
    public boolean isEmptyOutputFolder()
    {
        return emptyOutputFolder;
    }

    /**
     * Sets if it is necessary to remove all files in the output folder before
     * write the translated HTML file.
     *
     * @param emptyOutputFolder
     * @return
     */
    public Settings setEmptyOutputFolder(boolean emptyOutputFolder)
    {
        this.emptyOutputFolder = emptyOutputFolder;
        return this;
    }

    /**
     * Returns a new instance of Settings.
     *
     * @return New instance of Settings.
     */
    public static Settings getSettings()
    {
        return new Settings();
    }

    /**
     * Returns the property of the tag HTML indicating which is the translation to write in the tag.
     *
     * @return Property of the tag HTML indicating which is the translation to write in the tag.
     */
    public String getTranslationProperty()
    {
        return translationProperty;
    }

    /**
     * Sets the property of the tag HTML indicating which is the translation to write in the tag.
     *
     * @param translationProperty Property of the tag HTML indicating which is the translation to write in the tag.
     * @return
     */
    public Settings setTranslationProperty(String translationProperty)
    {
        this.translationProperty = translationProperty;
        return this;
    }

    /**
     * Returns the input folder of the HTML files to translate.
     *
     * @return Input folder of the HTML files to translate.
     */
    public String getHtmlInputPath()
    {
        return htmlInputPath;
    }

    /**
     * Sets the input folder of the HTML files to translate.
     *
     * @param htmlInputPath Input folder of the HTML files to translate.
     * @return
     */
    public Settings setHtmlInputPath(String htmlInputPath)
    {
        this.htmlInputPath = htmlInputPath;
        return this;
    }

    /**
     * Returns the folder of the JSON translation files to translate.
     *
     * @return Folder of the JSON translation files to translate
     */
    public String getJsonLanguagesInput()
    {
        return jsonLanguagesInput;
    }

    /**
     * Sets the folder of the JSON translation files to translate.
     *
     * @param jsonLanguagesInput
     * @return
     */
    public Settings setJsonLanguagesInput(String jsonLanguagesInput)
    {
        this.jsonLanguagesInput = jsonLanguagesInput;
        return this;
    }

    /**
     * Returns the output folder where the translated HTML files will be saved.
     *
     * @return Output folder where the translated HTML files will be saved.
     */
    public String getHtmlOutputPath()
    {
        return htmlOutputPath;
    }

    /**
     * Sets the output folder where the translated HTML files will be saved.
     *
     * @param htmlOutputPath
     * @return
     */
    public Settings setHtmlOutputPath(String htmlOutputPath)
    {
        this.htmlOutputPath = htmlOutputPath;
        return this;
    }

    /**
     * Returns the encode used to read the HTML input file. and write the translated HTML files.
     *
     * @return The encode used to read the HTML input file. and write the translated HTML files.
     */
    public String getFileEncode()
    {
        return fileEncode;
    }

    /**
     * Sets the encode used to read the HTML input file. and write the translated HTML files.
     * @param fileEncode
     * @return
     */
    public Settings setFileEncode(String fileEncode)
    {
        this.fileEncode = fileEncode;
        return this;
    }
}
