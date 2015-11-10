import controller.MWAT;
import model.input.Input;
import model.input.InputValidation;
import org.apache.log4j.Logger;

public class Main {
  private final static Logger LOGGER=Logger.getLogger(Main.class);

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

    switch(InputValidation.validateHTMLInputFolder(htmlInputPath)){
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

    switch(InputValidation.validateHTMLOutputFolder(htmlOutputPath)){
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
    switch(InputValidation.validateJSONLanguageFolder(jsonLanguagesInput)){
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

    MWAT m=new MWAT(htmlInputPath, jsonLanguagesInput, htmlOutputPath);
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
