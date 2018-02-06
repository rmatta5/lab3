import java.net.*;
import java.io.*;
import java.util.*;
public class WebScraper {
    public static void main(String[] unused) {
        String text = urlToString("http://erdani.com/tdpl/hamlet.txt");
        String[] words = text.split("[ ,.?]+");
        int count = 0;
        String lookFor = "prince";
        for (String word : words) {
            if (word.toLowerCase().equals(lookFor)) {
                count++;
            }
        }
        System.out.println(count);
    }

    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }
}

