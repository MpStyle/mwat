package mp.mwat.model.man;

import mp.mwat.model.input.Input;
import mp.mwat.model.input.InputBook;
import mp.mwat.model.settings.Settings;

import mp.mwat.model.filesystem.file.FileBook;
import org.apache.log4j.Logger;

public class ManBook
{
    
    private static final Logger LOGGER = Logger.getLogger(ManBook.class);
    
    private static final String HELP_FILE_PATH = "help.txt";
    
    public static boolean isHelpRequest(String[] args)
    {
        if (args.length <= 0)
        {
            return false;
        }
        
        String firstArgument = args[0];
        
        return InputBook.parseInput(firstArgument) == Input.h;
    }

    /**
     * Stampa il file help.txt, sostituendo il segnaposto con il numero della
     * versione.
     */
    public static void printHelp()
    {
        
        ClassLoader classLoader = ManBook.class.getClassLoader();
        String helpFileUrl;
        
        try
        {
            helpFileUrl = classLoader.getResource(HELP_FILE_PATH).getFile();
        }
        catch (Exception ex)
        {
            LOGGER.error(ex);
            return;
        }
        
        String helpContent = FileBook.getFileContent(helpFileUrl);
        
        System.out.println(String.format(helpContent, Settings.CURRENT_VERSION));
    }
}
