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
package mp.mwat.model.jsonfile;

/**
 * Incampsula le proprietà dei file JSON che contengono le traduzioni delle
 * stringhe.<br>
 * Le proprietà sono:
 * <ul>
 * <li>Il nome della traduzione, per esempio: it, fr, etc...</li>
 * <li>Il path del file.</li>
 * </ul>
 */
public class JSONFile
{

    private String name;
    private String path;

    /**
     * Restituisce il nome, senza estensione del file JSON.
     *
     * @return
     */
    public String getName()
    {
        return name;
    }

    /**
     * Setta il nome, dovrà essere senza estensione, del file JSON.
     *
     * @param name
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Restituisce la path del file JSON delle traduzioni.
     *
     * @return
     */
    public String getPath()
    {
        return path;
    }

    /**
     * Setta la path del file JSON delle traduzioni.
     *
     * @param path
     */
    public void setPath(String path)
    {
        this.path = path;
    }

}
