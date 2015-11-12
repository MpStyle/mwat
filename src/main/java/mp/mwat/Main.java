package mp.mwat;

import mp.mwat.controller.MWAT;
import mp.mwat.model.input.Input;
import mp.mwat.model.input.InputValidationBook;
import mp.mwat.model.settings.Settings;
import mp.mwat.model.string.StringBook;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

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

  private String htmlInputPath = null, jsonLanguagesInput = null, htmlOutputPath = null, fileEncode = Settings.DEFAULT_FILE_ENCODE;
  private boolean clearOutputFolder = false;

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
    Main m = new Main();

    int i = 0;

    if (isHelpRequest(args)) {
      m.printHelp();
      return;
    }

    for (String arg : args) {
      Input input = parseInput(arg);

      switch (input) {
      case i:
        m.setHtmlInputPath(args[i + 1]);
        break;
      case o:
        m.setHtmlOutputPath(args[i + 1]);
        break;
      case l:
        m.setJsonLanguagesInput(args[i + 1]);
        break;
      case c:
        m.setClearOutputFolder(true);
        break;
      case e:
        m.setFileEncode(args[i + 1]);
        break;
      }

      i++;
    }

    m.start();
  }

  private void start() {
    try {
      run();
    } catch (Exception ex) {
      LOGGER.error(ex);
    }
  }

  private void run() {
    if (!validateInput()) {
      return;
    }

    Settings settings = Settings.getSettings().setHtmlInputPath(htmlInputPath)
        .setJsonLanguagesInput(jsonLanguagesInput)
        .setHtmlOutputPath(htmlOutputPath)
        .setEmptyOutputFolder(clearOutputFolder).setFileEncode(fileEncode);
    MWAT m = new MWAT(settings);
    m.start();
  }

  private boolean validateInput() {
    switch (InputValidationBook.validateHTMLInputFolder(htmlInputPath)) {
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

    switch (InputValidationBook.validateHTMLOutputFolder(htmlOutputPath)) {
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
        .validateJSONLanguageFolder(jsonLanguagesInput)) {
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

  private static Input parseInput(String arg) {
    try {
      return Input.valueOf(StringBook.removeString(arg, "-"));
    } catch (Exception ex) {
      LOGGER.error(ex);
    }

    return Input.none;
  }

  private Main setHtmlInputPath(String htmlInputPath) {
    this.htmlInputPath = htmlInputPath;
    return this;
  }

  private Main setJsonLanguagesInput(String jsonLanguagesInput) {
    this.jsonLanguagesInput = jsonLanguagesInput;
    return this;
  }

  private Main setHtmlOutputPath(String htmlOutputPath) {
    this.htmlOutputPath = htmlOutputPath;
    return this;
  }

  private Main setFileEncode(String fileEncode) {
    this.fileEncode = fileEncode;
    return this;
  }

  private Main setClearOutputFolder(boolean clearOutputFolder) {
    this.clearOutputFolder = clearOutputFolder;
    return this;
  }

  private static boolean isHelpRequest(String[] args) {
    if (args.length <= 0) {
      return false;
    }

    String firstArgument = args[0];

    return Main.parseInput(firstArgument) == Input.h;
  }

  private void printHelp() {
    BufferedReader br = null;
    ClassLoader classLoader = getClass().getClassLoader();
    File file = new File(classLoader.getResource("help.txt").getFile());
    String helpContent = "";

    try {

      String sCurrentLine;

      br = new BufferedReader(new FileReader(file));

      while ((sCurrentLine = br.readLine()) != null) {
        helpContent += sCurrentLine + "\n";
      }

    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if (br != null)
          br.close();
      } catch (IOException ex) {
        ex.printStackTrace();
      }
    }

    System.out.println(String.format(helpContent, Settings.CURRENT_VERSION));
  }
}
