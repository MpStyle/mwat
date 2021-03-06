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
package mpstyle.mwat.model.htmlfile;

import mpstyle.mwat.model.filesystem.file.FileExtensionFilter;

/**
 * Specializzazione della classe FileExtensionFilter per filtrare i file con
 * estensione {@link HTMLFileBook#HTML_FILE_EXTENSION .html}
 */
public class FileHTMLFilter extends FileExtensionFilter
{

    public FileHTMLFilter()
    {
        super(HTMLFileBook.HTML_FILE_EXTENSION);
    }
}
