package me.examples;

import java.io.IOException;
import java.util.function.Consumer;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class XmlDomExample {
    public static void main(String[] args) {
        var factory = DocumentBuilderFactory.newInstance();
        try {
            var builder = factory.newDocumentBuilder();
            var document = builder.parse("https://www.publickey1.jp/atom.xml");

            traverse(
                document,
                node -> System.out.println(node.getNodeName() + " - " + node.getNodeValue()));

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void traverse(Node node, Consumer<Node> action) {
        action.accept(node);

        var childNodes = node.getChildNodes();
        var length = childNodes.getLength();

        if (length == 0) {
            return;
        }

        for (int i = 0; i < length; i++) {
            traverse(childNodes.item(i), action);
        }
    }
}