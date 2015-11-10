package model.string;

/**
 * Classe di utility che raccoglie operazioni atomiche sulle stringhe.
 */
public final class StringBook {
  /**
   * Rimuove da <i>string</i> la stringa <i>toRemove</i>.<br />
   * Esempio:
   * <code>
   *   String dirty = "Hello kjbsWorld";
   *   String clean = StringBook.removeString(dirty, "kjbs");
   *   System.out.println(clean);
   * </code>
   * L'output sarà <i>Hello World!</i>.
   *
   * @param string
   * @param toRemove
   * @return
   */
  public static final String removeString(String string, String toRemove) {
    if (string == null) {
      return string;
    }

    return string.replace(toRemove, "");
  }
}
