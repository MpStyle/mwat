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

/**
 * It collects all the possible input coming from the command line.
 */
public enum Input
{
    i("i"), // VIEWS_INPUT_FOLDER
    o("o"), // OUTPUT_FOLDER
    l("l"), // LANGUAGES_INPUT_FOLDER
    e("e"), // INPUT_FILES_ENCODING
    h("h"), // HELP
    c("c"), // CLEAR_OUTPUT_FOLDER
    t("t"), // TRANSLATION_HTML_PROPERTY
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
