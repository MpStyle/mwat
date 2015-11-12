package mp.mwat.model.filesystem.folder;

import java.io.File;
import org.apache.log4j.Logger;

public class FolderBook
{

    private static final Logger LOGGER = Logger.getLogger(FolderBook.class);

    /**
     * Crea una cartella/directory.<br>
     * Non la crea se esiste già.<br>
     * Lancia un'eccezione se non ci riesce.
     *
     * @param folder
     *
     * @throws Exception
     */
    public static void createFolder(File folder) throws Exception
    {
        if (folder.exists())
        {
            LOGGER.info("The output folder already exists.");
            return;
        }
        if (!folder.mkdir())
        {
            LOGGER.error("It's impossible to create the output folder");
            throw new Exception("It's impossible to create the output folder");
        }
    }

    /**
     * Overriding del metodo {@link #deleteFolder(File) deleteFolder(File)}
     *
     * @param folder
     *
     * @throws Exception
     */
    public static void deleteFolder(String folder) throws Exception
    {
        deleteFolder(new File(folder));
    }

    /**
     * Cancella ricorsivamente il contenuto di <i>folder</i>.
     *
     * @param folder
     *
     * @throws Exception
     */
    public static void deleteFolder(File folder) throws Exception
    {
        File[] files = folder.listFiles();
        if (files != null)
        {
            for (File f : files)
            {
                if (f.isDirectory())
                {
                    deleteFolder(f);
                }
                else
                {
                    if (!f.delete())
                    {
                        throw new Exception(String.format("Impossible to delete the folder %s", f.getAbsolutePath()));
                    }
                }
            }
        }
        if (!folder.delete())
        {
            throw new Exception(String.format("Impossible to delete the folder %s", folder.getAbsolutePath()));
        }
    }

}
