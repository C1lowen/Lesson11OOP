package lasson11_task1;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class NetworkService {

    private static String getStringFromURL(String spec, String code) throws IOException {
        URL url = new URL(spec);
        URLConnection connection = url.openConnection();
        String result = "";

        try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), code))) {
            String temp = "";
            for (;;) {
                temp = br.readLine();
                if (temp == null) {
                    break;
                }
                result += temp + System.lineSeparator();
            }
            return result;
        }
    }

    public static void writeFile(String spec, File file) throws IOException {
        try (PrintWriter pr = new PrintWriter(file)){
            String html = getStringFromURL(spec, "UTF-8");
            String[] s = html.split("http");
            for (int i = 1; i < s.length; i++) {
                int index = 0;
                s[i] = "http" + s[i].replaceAll("\'", "\"");
                if (s[i].indexOf("\"") != -1) {
                    index = s[i].indexOf("\"");
                }
                pr.print(s[i].substring(0, index) + System.lineSeparator());
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
