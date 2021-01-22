package me.examples;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import lombok.Data;

public class AtomReadExample {
    public static void main(String[] args) {
        try {
            var builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            var document = builder.parse("https://www.publickey1.jp/atom.xml");

            // Build atom entry list from XML DOM.
            var entryNodes = document.getElementsByTagName("entry");
            var length = entryNodes.getLength();
            var atomEntries = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                var entryNode = (Element) entryNodes.item(i);
                var title = (Element) entryNode.getElementsByTagName("title").item(0);
                var link = (Element) entryNode.getElementsByTagName("link").item(0);
                var id = (Element) entryNode.getElementsByTagName("id").item(0);
                var updated = (Element) entryNode.getElementsByTagName("updated").item(0);

                var atomEntry = new AtomEntry();
                atomEntry.setTitle(title.getTextContent());
                atomEntry.setHref(link.getAttribute("href"));
                atomEntry.setId(id.getTextContent());
                atomEntry.setUpdated(updated.getTextContent());
                atomEntries.add(atomEntry);
            }

            atomEntries.forEach(System.out::println);

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Data
    public static class AtomEntry {
        private String title;
        private String href;
        private String id;
        private String updated;
    }

}
