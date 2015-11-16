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
package mpstyle.mwat.model.input;

/**
 * The enum collects the values related to the validation of the input coming from the command line.
 */
public enum InputValidationResult
{
    /**
     * The values is correct.
     */
    OK,
    /**
     * The folder of the HTML file to parse isn't in the arguments.
     */
    ERROR_HTML_INPUT_FOLDER_IS_MANDATORY,
    /**
     * The folder of the HTML file to parse isn't a folder.
     */
    ERROR_HTML_INPUT_FOLDER_MUST_BE_A_FOLDER,
    /**
     * The folder of the translated HTML file is't in the arguments.
     */
    ERROR_HTML_OUTPUT_FOLDER_IS_MANDATORY,
    /**
     * The folder of the translated HTML file is't a folder.
     */
    ERROR_HTML_OUTPUT_FOLDER_MUST_BE_A_FOLDER,
    /**
     * The folder of the JSON file of translation is't in the arguments.
     */
    ERROR_JSON_LANGUAGE_INPUT_FOLDER_IS_MANDATORY,
    /**
     * The folder of the JSON file of translation is't a folder.
     */
    ERROR_JSON_LANGUAGE_INPUT_FOLDER_MUST_BE_A_FOLDER,
    /**
     * The folder of the HTML file to parse isn't valid.
     */
    ERROR_HTML_INPUT_FOLDER_IS_INVALID_PATH,
    /**
     * The folder of the translated HTML file is't valid.
     */
    ERROR_HTML_OUTPUT_FOLDER_IS_INVALID_PATH,
    /**
     * The folder of the JSON file of translation is't valid.
     */
    ERROR_JSON_LANGUAGE_INPUT_FOLDER_IS_INVALID_PATH
}
