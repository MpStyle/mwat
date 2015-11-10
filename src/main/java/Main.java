import controller.MWAT;
import model.input.Input;
import model.input.InputValidationBook;
import model.settings.Settings;
import org.apache.log4j.Logger;

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

public class Main {
  private final static Logger LOGGER = Logger.getLogger(Main.class);

  /**
   * args può gestire i seguenti parametri:
   * <ul>
   * <li>-i   HTMLs input folder container</li>
   * <li>-l   JSONs of languages folder containers</li>
   * <li>-o   HTMLs output folder containers</li>
   * </ul>
   *
   * @param args
   */
  public static void main(String[] args) {
    String htmlInputPath = null, jsonLanguagesInput = null, htmlOutputPath = null;
    int i = 0;

    for (String arg : args) {
      Input input = parseInput(arg);

      switch (input) {
      case HTML_INPUT_FOLDER:
        htmlInputPath = args[i + 1];
        break;
      case HTML_OUTPUT_FOLDER:
        htmlOutputPath = args[i + 1];
        break;
      case JSON_LANGUAGE_INPUT_FOLDER:
        jsonLanguagesInput = args[i + 1];
        break;
      }

      i++;
    }

    switch (InputValidationBook.validateHTMLInputFolder(htmlInputPath)) {
    case ERROR_HTML_INPUT_FOLDER_IS_INVALID_PATH:
      LOGGER.error("-i HTML input folder must be a valid path.");
      return;
    case ERROR_HTML_INPUT_FOLDER_IS_MANDATORY:
      LOGGER.error("-i is a mandatory parameter.");
      return;
    case ERROR_HTML_INPUT_FOLDER_MUST_BE_A_FOLDER:
      LOGGER.error("-i HTML input folder must be a folder.");
      return;
    }

    switch (InputValidationBook.validateHTMLOutputFolder(htmlOutputPath)) {
    case ERROR_HTML_OUTPUT_FOLDER_IS_INVALID_PATH:
      LOGGER.error("-h HTML output folder must be a valid path.");
      return;
    case ERROR_HTML_OUTPUT_FOLDER_IS_MANDATORY:
      LOGGER.error("-h is a mandatory parameter.");
      return;
    case ERROR_HTML_OUTPUT_FOLDER_MUST_BE_A_FOLDER:
      LOGGER.error("-h HTML output folder must be a folder.");
      return;
    }
    switch (InputValidationBook
        .validateJSONLanguageFolder(jsonLanguagesInput)) {
    case ERROR_JSON_LANGUAGE_INPUT_FOLDER_IS_INVALID_PATH:
      LOGGER.error("-l JSON language folder must be a valid path.");
      return;
    case ERROR_JSON_LANGUAGE_INPUT_FOLDER_IS_MANDATORY:
      LOGGER.error("-l is a mandatory parameter.");
      return;
    case ERROR_JSON_LANGUAGE_INPUT_FOLDER_MUST_BE_A_FOLDER:
      LOGGER.error("-l JSON language folder must be a folder.");
      return;
    }

    Settings settings = Settings.getSettings().setHtmlInputPath(htmlInputPath)
        .setJsonLanguagesInput(jsonLanguagesInput)
        .setHtmlOutputPath(htmlOutputPath);
    MWAT m = new MWAT(settings);
    m.start();
  }

  public static Input parseInput(String arg) {
    try {
      return Input.valueOf(arg);
    } catch (Exception ex) {
    }

    return null;
  }
}
