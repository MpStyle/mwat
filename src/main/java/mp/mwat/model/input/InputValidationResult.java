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
package mp.mwat.model.input;

public enum InputValidationResult
{
    /**
     * Il valore è corretto.
     */
    OK,
    /**
     * La cartella contenente gli HTML da parsare non è stata definita.
     */
    ERROR_HTML_INPUT_FOLDER_IS_MANDATORY,
    /**
     * Il path non è una cartella.
     */
    ERROR_HTML_INPUT_FOLDER_MUST_BE_A_FOLDER,
    /**
     * La cartella di output degli HTML tradotti non è stata definita.
     */
    ERROR_HTML_OUTPUT_FOLDER_IS_MANDATORY,
    /**
     * Il path non è una cartella.
     */
    ERROR_HTML_OUTPUT_FOLDER_MUST_BE_A_FOLDER,
    /**
     * La cartella contenente le traduzioni JSON non è stata definita.
     */
    ERROR_JSON_LANGUAGE_INPUT_FOLDER_IS_MANDATORY,
    /**
     * Il path non è una cartella.
     */
    ERROR_JSON_LANGUAGE_INPUT_FOLDER_MUST_BE_A_FOLDER,
    /**
     * La cartella contenente gli HTML da parsare non è un path valido.
     */
    ERROR_HTML_INPUT_FOLDER_IS_INVALID_PATH,
    /**
     * La cartella di output degli HTML tradotti non è un path valido.
     */
    ERROR_HTML_OUTPUT_FOLDER_IS_INVALID_PATH,
    /**
     * La cartella contenente le traduzioni JSON non è un path valido.
     */
    ERROR_JSON_LANGUAGE_INPUT_FOLDER_IS_INVALID_PATH
}
