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

import mpstyle.mwat.model.jsonfile.JSONFileBook;
import mpstyle.mwat.model.string.StringBook;
import org.apache.log4j.Logger;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Classe di utility che raccoglie le operazioni atomiche che si possono
 * effettuare
 * sui file .html.
 */
public final class HTMLFileBook
{

    private static final Logger LOGGER = Logger.getLogger(HTMLFileBook.class);
    public static final String HTML_FILE_EXTENSION = ".html";

    /**
     * Restituisce un elenco di stringhe che rappresentano i path dei file
     * contenuti nella cartella <i>htmlInputFolder</i>.
     *
     * @param htmlFolder Cartella di input dei file HTML da tradurre.
     * @param rootFolder Cartella di input dei file HTML da tradurre.
     *
     * @return
     */
    public static List<HTMLFile> getHTMLFileList(String htmlFolder,
                                                 String rootFolder)
    {
        ArrayList<HTMLFile> fileList = new ArrayList<HTMLFile>();
        File folder = new File(htmlFolder);

        for (final File fileEntry : folder.listFiles())
        {
            if (fileEntry.isDirectory())
            {
                fileList.addAll(HTMLFileBook
                    .getHTMLFileList(fileEntry.getAbsolutePath(), rootFolder));
                continue;
            }

            if (!fileEntry.isFile() || !fileEntry.getName()
                .endsWith(HTML_FILE_EXTENSION))
            {
                continue;
            }

            HTMLFile file = new HTMLFile();
            file.setFileName(fileEntry.getName());
            file.setAbsoluteFolderPath(StringBook
                .removeString(fileEntry.getAbsolutePath(), fileEntry.getName()));
            file.setRelativeFolderPath(
                StringBook.removeString(file.getAbsoluteFolderPath(), rootFolder));

            fileList.add(file);
        }

        return fileList;
    }

    /**
     * Inserisce le traduzioni nel Document <i>doc</i> per gli Elements con
     * <i>translationProperty</i> valorizzata.
     *
     * @param doc                 Document da tradurre.
     * @param entries             Mappa chiave-valore delle traduzioni.
     * @param translationProperty Proprietà dei tag che indica dove inserire la
     *                            traduzione.
     * @param jsName              Nome della traduzione.
     *
     * @return
     */
    public static Document translateHtml(Document doc,
                                         HashMap<String, String> entries, String translationProperty,
                                         String jsName)
    {
        doc=translateContent(doc, entries, translationProperty, jsName);
        doc=translateAttribute(doc, entries, translationProperty, jsName);
        return doc;
    }

    private static Document translateAttribute(Document doc,
                                               HashMap<String, String> entries, String translationProperty,
                                               String jsName){
        Elements toTranslateList = doc.select("*");

        for (Element toTranslate : toTranslateList)
        {
            for (Attribute attribute:toTranslate.attributes()) {
                if( attribute.getKey().startsWith(translationProperty+"-") ){
                    String key = attribute.getValue();

                    if (!entries.containsKey(key))
                    {
                        LOGGER.warn(String
                                .format("No translation for key %s in %s%s file.", key, jsName,
                                        JSONFileBook.JSON_FILE_EXTENSION));
                        continue;
                    }

                    String translation = entries.get(key);

                    toTranslate.attr(attribute.getKey().replaceAll(translationProperty+"-", ""),translation);

                    toTranslate.attributes().remove(attribute.getKey());
                }
            }
        }

        return doc;
    }

    private static Document translateContent(Document doc,
                                               HashMap<String, String> entries, String translationProperty,
                                               String jsName){
        Elements toTranslateList = doc.select("[" + translationProperty + "]");

        for (Element toTranslate : toTranslateList)
        {
            String key = toTranslate.attr(translationProperty);

            if (!entries.containsKey(key))
            {
                LOGGER.warn(String
                        .format("No translation for key %s in %s%s file.", key, jsName,
                                JSONFileBook.JSON_FILE_EXTENSION));
                continue;
            }

            String translation = entries.get(key);
            toTranslate.prependText(translation);

            toTranslate.attributes().remove(translationProperty);
        }

        return doc;
    }
}
