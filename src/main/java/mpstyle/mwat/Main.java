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
package mpstyle.mwat;

import mpstyle.mwat.controller.MWAT;
import mpstyle.mwat.model.input.Input;
import mpstyle.mwat.model.input.InputBook;
import mpstyle.mwat.model.input.InputValidationBook;
import mpstyle.mwat.model.man.ManBook;
import mpstyle.mwat.model.operation.AbstractOperation;
import mpstyle.mwat.model.settings.Settings;
import org.apache.log4j.Logger;

public class Main extends AbstractOperation
{

    private final Settings settings = Settings.getSettings();
    private final static Logger LOGGER = Logger.getLogger(Main.class);

    /**
     * args può gestire i seguenti parametri:
     * <ul>
     * <li>-i HTMLs input folder container</li>
     * <li>-l JSONs of languages folder containers</li>
     * <li>-o HTMLs output folder containers</li>
     * </ul>
     *
     * @param args I parametri passati da riga di comando
     */
    public static void main(String[] args)
    {
        Main m = new Main(args);
        m.start();
    }

    private Main(String[] args)
    {
        int i = 0;

        if (ManBook.isHelpRequest(args))
        {
            ManBook.printHelp();
            return;
        }

        for (String arg : args)
        {
            Input input = InputBook.parseInput(arg);

            switch (input)
            {
                case i:
                    settings.setHtmlInputPath(args[i + 1]);
                    break;
                case o:
                    settings.setHtmlOutputPath(args[i + 1]);
                    break;
                case l:
                    settings.setJsonLanguagesInput(args[i + 1]);
                    break;
                case c:
                    settings.setEmptyOutputFolder(true);
                    break;
                case e:
                    settings.setFileEncode(args[i + 1]);
                    break;
                case t:
                    settings.setTranslationProperty(args[i+1]);
                    break;
            }

            i++;
        }
    }

    protected void run()
    {
        if (!validateInput())
        {
            return;
        }

        MWAT m = new MWAT(settings);
        m.start();
    }

    private boolean validateInput()
    {
        switch (InputValidationBook.validateHTMLInputFolder(settings.getHtmlInputPath()))
        {
            case ERROR_HTML_INPUT_FOLDER_IS_INVALID_PATH:
                LOGGER.error("\"-i\" HTML input folder must be a valid path.");
                return false;
            case ERROR_HTML_INPUT_FOLDER_IS_MANDATORY:
                LOGGER.error("\"-i\" is a mandatory parameter.");
                return false;
            case ERROR_HTML_INPUT_FOLDER_MUST_BE_A_FOLDER:
                LOGGER.error("\"-i\" HTML input folder must be a folder.");
                return false;
        }

        switch (InputValidationBook.validateHTMLOutputFolder(settings.getHtmlOutputPath()))
        {
            case ERROR_HTML_OUTPUT_FOLDER_IS_INVALID_PATH:
                LOGGER.error("\"-h\" HTML output folder must be a valid path.");
                return false;
            case ERROR_HTML_OUTPUT_FOLDER_IS_MANDATORY:
                LOGGER.error("-h is a mandatory parameter.");
                return false;
            case ERROR_HTML_OUTPUT_FOLDER_MUST_BE_A_FOLDER:
                LOGGER.error("\"-h\" HTML output folder must be a folder.");
                return false;
        }
        switch (InputValidationBook
            .validateJSONLanguageFolder(settings.getJsonLanguagesInput()))
        {
            case ERROR_JSON_LANGUAGE_INPUT_FOLDER_IS_INVALID_PATH:
                LOGGER.error("\"-l\" JSON language folder must be a valid path.");
                return false;
            case ERROR_JSON_LANGUAGE_INPUT_FOLDER_IS_MANDATORY:
                LOGGER.error("\"-l\" is a mandatory parameter.");
                return false;
            case ERROR_JSON_LANGUAGE_INPUT_FOLDER_MUST_BE_A_FOLDER:
                LOGGER.error("\"-l\" JSON language folder must be a folder.");
                return false;
        }

        return true;
    }
}
