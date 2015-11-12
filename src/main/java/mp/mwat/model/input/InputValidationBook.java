package mp.mwat.model.input;

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
 * Classe di utility che raccoglie operazioni relative alla validazione degli
 * input
 * del programma, passati da riga di comando.
 */
public final class InputValidationBook
{

    /**
     * Effettua la validazione del parametro che indica la cartella contenente i
     * file
     * .html da tradurre.<br>
     * Controlla se
     * <ul>
     * <li>l'input è valorizzato: se è diverso da null e da stringa vuota</li>
     * <li>se il path esiste</li>
     * <li>se il path punta ad una cartella</li>
     * </ul>
     *
     * @param htmlInputFolder
     *
     * @return
     */
    public static InputValidationResult validateHTMLInputFolder(
        String htmlInputFolder)
    {
        if (htmlInputFolder == null || "".equals(htmlInputFolder))
        {
            return InputValidationResult.ERROR_HTML_INPUT_FOLDER_IS_MANDATORY;
        }

        File file = new File(htmlInputFolder);

        if (!file.exists())
        {
            return InputValidationResult.ERROR_HTML_INPUT_FOLDER_IS_INVALID_PATH;
        }

        if (!file.isDirectory())
        {
            return InputValidationResult.ERROR_HTML_INPUT_FOLDER_MUST_BE_A_FOLDER;
        }

        return InputValidationResult.OK;
    }

    /**
     * Effettua la validazione del parametro che indica la cartella contenente i
     * file .html tradotti.<br>
     * Controlla se
     * <ul>
     * <li>l'input è valorizzato: se è diverso da null e da stringa vuota</li>
     * <li>se il path esiste</li>
     * <li>se il path punta ad una cartella</li>
     * </ul>
     *
     * @param htmlOutputFolder
     *
     * @return
     */
    public static InputValidationResult validateHTMLOutputFolder(
        String htmlOutputFolder)
    {
        if (htmlOutputFolder == null || "".equals(htmlOutputFolder))
        {
            return InputValidationResult.ERROR_HTML_OUTPUT_FOLDER_IS_MANDATORY;
        }

        File file = new File(htmlOutputFolder);

        if (!file.exists())
        {
            return InputValidationResult.ERROR_HTML_OUTPUT_FOLDER_IS_INVALID_PATH;
        }

        if (!file.isDirectory())
        {
            return InputValidationResult.ERROR_HTML_OUTPUT_FOLDER_MUST_BE_A_FOLDER;
        }

        return InputValidationResult.OK;
    }

    /**
     * Effettua la validazione del parametro che indica la cartella contenente i
     * file
     * .json delle traduzioni.<br>
     * Controlla se
     * <ul>
     * <li>l'input è valorizzato: se è diverso da null e da stringa vuota</li>
     * <li>se il path esiste</li>
     * <li>se il path punta ad una cartella</li>
     * </ul>
     *
     * @param jsonInputFolder
     *
     * @return
     */
    public static InputValidationResult validateJSONLanguageFolder(
        String jsonInputFolder)
    {
        if (jsonInputFolder == null || "".equals(jsonInputFolder))
        {
            return InputValidationResult.ERROR_JSON_LANGUAGE_INPUT_FOLDER_IS_MANDATORY;
        }

        File file = new File(jsonInputFolder);

        if (!file.exists())
        {
            return InputValidationResult.ERROR_JSON_LANGUAGE_INPUT_FOLDER_IS_INVALID_PATH;
        }

        if (!file.isDirectory())
        {
            return InputValidationResult.ERROR_JSON_LANGUAGE_INPUT_FOLDER_MUST_BE_A_FOLDER;
        }

        return InputValidationResult.OK;
    }
}
