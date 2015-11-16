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
package mpstyle.mwat.model.input;

import mpstyle.mwat.model.string.StringBook;
import org.apache.log4j.Logger;

/**
 * This is an utilty class. It collects the methods for operations with the input.
 */
public class InputBook
{

    private static final Logger LOGGER = Logger.getLogger(InputBook.class);

    /**
     * Parse the string (argument of the mail method) to a Input value.
     * @param arg
     * @return
     */
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
