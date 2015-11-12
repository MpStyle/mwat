package mp.mwat.model.input;

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
 * Enum che raccoglie i possibili input che il programa può ricevere da linea di
 * comando.
 */
public enum Input
{
    i("i"),
    o("o"),
    l("l"),
    e("e"),
    h("h"),
    c("c"),
    none("none");

    private final String text;

    /**
     * @param text
     */
    Input(final String text)
    {
        this.text = text;
    }

    /* (non-Javadoc)
   * @see java.lang.Enum#toString()
     */
    @Override
    public String toString()
    {
        return text;
    }
}
