package lesson11_task2;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class SiteCheckout {

    public static void checkout(File file)throws IOException{
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            while(br.ready()){
                String url = br.readLine();
                boolean result = connected(url, "UTF-8");
                if(result){
                    System.out.println("Сайт " + url + " работает");
                }else{
                    System.out.println("Сайт " + url + " не работает");
                }
            }

        }
    }

    private static boolean connected(String urlSite, String code) throws IOException{
        URL url = new URL(urlSite);
        URLConnection connection = url.openConnection();
        return connection.getHeaderFields().keySet().size() == 0 ? false : true;
    }
}
