package mp.mwat.model.input;

import mp.mwat.model.string.StringBook;
import org.apache.log4j.Logger;

public class InputBook
{

    private static final Logger LOGGER = Logger.getLogger(InputBook.class);

    public static Input parseInput(String arg)
    {
        try
        {
            return Input.valueOf(StringBook.removeString(arg, "-"));
        }
        catch (Exception ex)
        {
            LOGGER.error(ex);
        }

        return Input.none;
    }
}
