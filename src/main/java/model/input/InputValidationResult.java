package model.input;

public enum InputValidationResult {
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
  ERROR_JSON_LANGUAGE_INPUT_FOLDER_IS_INVALID_PATH;
}
