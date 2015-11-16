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
package mpstyle.mwat.model.string;

/**
 * This is an utilty class. It collects the methods for operations with the string.
 */
public final class StringBook
{

    /**
     * Remove from <i>string</i> the <i>toRemove</i> string.<br>
     * Example:
     * <code>
     *   String dirty = "Hello kjbsWorld";
     *   String clean = StringBook.removeString(dirty, "kjbs");
     *   System.out.println(clean);
     * </code>
     * The output will be <i>Hello World!</i>.
     *
     * @param string
     * @param toRemove
     *
     * @return
     */
    public static final String removeString(String string, String toRemove)
    {
        if (string == null)
        {
            return string;
        }

        return string.replace(toRemove, "");
    }
}
