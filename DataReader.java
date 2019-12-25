import java.net.*;
import java.io.*;

public class DataReader{
  public static void main(String[] args) throws Exception{

    String[] idList = new String[1000];

    URL playerList = new URL("https://www.hockey-reference.com/leagues/NHL_2020_skaters.html");
    BufferedReader in = new BufferedReader(new InputStreamReader(playerList.openStream()));

    String inputLine = in.readLine();
    int count = 1;
    while(inputLine != null){
      String locater = "csk=\"" + count + "\"";
      if(inputLine.indexOf(locater) >= 0){
        int beginIndex = inputLine.indexOf("data-append-csv") + 17;
        int endIndex = inputLine.indexOf("data-stat=\"player\"")-2;
        String currentID = inputLine.substring(beginIndex, endIndex);
        System.out.println(currentID);
        count++;
      }
      inputLine = in.readLine();
    }
    System.out.println(count-1);
  }
}
