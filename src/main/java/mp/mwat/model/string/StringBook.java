package mp.mwat.model.string;

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
/**
 * Classe di utility che raccoglie operazioni atomiche sulle stringhe.
 */
public final class StringBook
{

    /**
     * Rimuove da <i>string</i> la stringa <i>toRemove</i>.<br>
     * Esempio:
     * <code>
     *   String dirty = "Hello kjbsWorld";
     *   String clean = StringBook.removeString(dirty, "kjbs");
     *   System.out.println(clean);
     * </code>
     * L'output sarà <i>Hello World!</i>.
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
