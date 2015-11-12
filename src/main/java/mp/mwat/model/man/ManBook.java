package mp.mwat.model.man;

import mp.mwat.model.input.Input;
import mp.mwat.model.input.InputBook;
import mp.mwat.model.settings.Settings;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ManBook {
  private static final String HELP_FILE_PATH = "help.txt";

  public static boolean isHelpRequest(String[] args) {
    if (args.length <= 0) {
      return false;
    }

    String firstArgument = args[0];

    return InputBook.parseInput(firstArgument) == Input.h;
  }

  /**
   * Stampa il file help.txt, sostituendo il segnaposto con il numero della versione.
   */
  public static void printHelp(Class mainClass) {
    BufferedReader br = null;
    ClassLoader classLoader = mainClass.getClassLoader();
    String helpFileUrl = "";

    try {
      helpFileUrl = classLoader.getResource(HELP_FILE_PATH).getFile();
    } catch (Exception ex) {
      return;
    }

    File file = new File(helpFileUrl);
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
