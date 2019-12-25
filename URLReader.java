import java.net.*;
import java.io.*;

public class URLReader {
    public static void main(String[] args) throws Exception {

        URL oracle = new URL("https://www.hockey-reference.com/leagues/NHL_2020_skaters.html");
        BufferedReader in = new BufferedReader(new InputStreamReader(oracle.openStream()));

        String inputLine = in.readLine();
        while (inputLine != null){
          System.out.println(inputLine);
          inputLine = in.readLine();
        }
        in.close();
    }
}
