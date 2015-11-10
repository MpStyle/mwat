package model.jsonfile;

/**
 * Incampsula le proprietà dei file JSON che contengono le traduzioni delle stringhe.<br />
 * Le proprietà sono:
 * <ul>
 *   <li>Il nome della traduzione, per esempio: it, fr, etc...</li>
 *   <li>Il path del file.</li>
 * </ul>
 */
public class JSONFile {
  private String name;
  private String path;

  /**
   * Restituisce il nome, senza estensione del file JSON.
   * @return
   */
  public String getName() {
    return name;
  }

  /**
   * Setta il nome, dovrà essere senza estensione, del file JSON.
   *
   * @param name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Restituisce la path del file JSON delle traduzioni.
   *
   * @return
   */
  public String getPath() {
    return path;
  }

  /**
   * Setta la path del file JSON delle traduzioni.
   *
   * @param path
   */
  public void setPath(String path) {
    this.path = path;
  }

}
