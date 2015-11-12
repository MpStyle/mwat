package mp.mwat.model.filesystem.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import mp.mwat.model.filesystem.folder.FolderBook;
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
