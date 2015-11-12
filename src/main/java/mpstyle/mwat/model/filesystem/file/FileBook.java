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
package mpstyle.mwat.model.filesystem.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import mpstyle.mwat.model.filesystem.folder.FolderBook;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

public class FileBook
{

    private static final Logger LOGGER = Logger.getLogger(FileBook.class);

    /**
     * Se necessario crea la cartella di destinazione <i>folderPath</i> e salva
     * il file <i>fileName</i>
     * con contenuto <i>content</i> all'interno di essa.
     *
     * @param content
     * @param fileName
     * @param folderPath
     * @param fileEncode
     *
     * @throws Exception
     */
    public static void saveFile(String content, String fileName, String folderPath, String fileEncode) throws Exception
    {
        FolderBook.createFolder(new File(folderPath));
        final File f = new File(folderPath + File.separator + fileName);
        FileUtils.writeStringToFile(f, content, fileEncode);
    }

    public static String getFileContent(String path)
    {
        BufferedReader br = null;
        File file = new File(path);
        String content = "";
        try
        {
            String sCurrentLine;
            br = new BufferedReader(new FileReader(file));
            while ((sCurrentLine = br.readLine()) != null)
            {
                content += sCurrentLine + "\n";
            }
        }
        catch (IOException e)
        {
            LOGGER.error(e);
        }
        finally
        {
            try
            {
                if (br != null)
                {
                    br.close();
                }
            }
            catch (IOException ex)
            {
                LOGGER.error(ex);
            }
        }
        return content;
    }

}
