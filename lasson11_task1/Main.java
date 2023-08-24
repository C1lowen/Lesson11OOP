package lasson11_task1;

import java.io.File;
import java.io.IOException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        File file = new File("saveFile.txt");
        String url = "https://en.wikipedia.org/wiki/Java_(programming_language)";
        try {
            NetworkService.writeFile(url, file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}