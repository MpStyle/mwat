package mp.mwat.model.jsonfile;

import mp.mwat.model.filesystem.FileExtensionFilter;

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
 * Specializzazione della classe FileExtensionFilter per filtrare i file con
 * estensione {@link JSONFileBook#JSON_FILE_EXTENSION .json}
 */
public class FileJSONFilter extends FileExtensionFilter
{

    public FileJSONFilter()
    {
        super(JSONFileBook.JSON_FILE_EXTENSION);
    }
}
