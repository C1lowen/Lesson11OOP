package lesson11_task1_jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;


public class ParserSite {

    private static Document connecting(String url) throws IOException {
        Document document = Jsoup.parse(new URL(url), 3000);
        return document;
    }

    public static void readFromDocument(String url, File file) throws IOException {
        Document document = connecting(url);
        Elements readParagraph = document.select("p");
        Elements readLinks = readParagraph.select("a[href]");

        writeFile(readLinks, file);
    }

    private static void writeFile(Elements readLinks, File file) throws IOException{
        try (PrintWriter pw = new PrintWriter(file)){
            for (Element term : readLinks) {
                String link = term.attr("href");
                //Если считывать с википедии
                if (link.charAt(0) != '#') {
                    pw.println(link);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        File file = new File("fileSave.txt");
        readFromDocument("https://en.wikipedia.org/wiki/Java_(programming_language)", file);
    }
}
