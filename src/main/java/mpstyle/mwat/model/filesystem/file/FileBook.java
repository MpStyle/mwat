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

/**
 * This class is a collector for the methods related with the file of the filesystem.
 */
public class FileBook
{

    private static final Logger LOGGER = Logger.getLogger(FileBook.class);

    /**
     * The method saves the <i>content</i> in a file with name <i>fileName</i>,
     * in the folder path <i>folderPath</i> using the encode <i>fileEncode</i>.<br>
     * If it is necessary, it creates the path.<br>
     * It returns <i>true</i> if the task is completed without errors, otherwise
     * <i>false</i>.
     *
     * @param content The content of the file.
     * @param fileName The name of the file to save.
     * @param folderPath The folder of the path where to save the file.
     * @param fileEncode The encode to use to save the file.
     * @return The result of the operation.
     *
     * @throws Exception
     */
    public static boolean saveFile(String content, String fileName, String folderPath, String fileEncode)
    {
        try {
            FolderBook.createFolder(new File(folderPath));
            final File f = new File(folderPath + File.separator + fileName);
            FileUtils.writeStringToFile(f, content, fileEncode);

            return true;
        } catch (Exception e) {
            LOGGER.debug(e);
        }

        return false;
    }

    /**
     * It returns the content of the file <i>path</i>.
     *
     * @param path The file to read.
     * @return The content of the file.
     */
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
            LOGGER.debug(e);
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
                LOGGER.debug(ex);
            }
        }
        return content;
    }

}
