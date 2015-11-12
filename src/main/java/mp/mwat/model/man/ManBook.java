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
