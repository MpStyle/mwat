package model.input;

/**
 * Enum che raccoglie i possibili input che il programa può ricevere da linea di
 * comando.
 */
public enum Input {
  HTML_INPUT_FOLDER("-i"),
  HTML_OUTPUT_FOLDER("-o"),
  JSON_LANGUAGE_INPUT_FOLDER("-l");

  private final String text;

  /**
   * @param text
   */
  private Input(final String text) {
    this.text = text;
  }

  /* (non-Javadoc)
   * @see java.lang.Enum#toString()
   */
  @Override
  public String toString() {
    return text;
  }
}
