package lesson11_task2;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            SiteCheckout.checkout(new File("FileProject.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
