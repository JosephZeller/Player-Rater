import java.net.*;
import java.io.*;

public class DataReader{
  public static void main(String[] args)throws Exception{
    String[] idList = idListCreator("https://www.hockey-reference.com/leagues/NHL_2020_skaters.html");
    int count = 0;
    while(idList[count] != null){
      System.out.println(idList[count]);
      count++;
    }
  }

  public static String[] idListCreator(String website)throws Exception{
    String[] idList = new String[1000];
    URL playerList = new URL(website);
    BufferedReader in = new BufferedReader(new InputStreamReader(playerList.openStream()));
    String inputLine = in.readLine();
    int count = 1;
    while(inputLine != null){
      String locater = "csk=\"" + count + "\"";
      if(inputLine.indexOf(locater) >= 0){
        int beginIndex = inputLine.indexOf("data-append-csv") + 17;
        int endIndex = inputLine.indexOf("data-stat=\"player\"")-2;
        String currentID = inputLine.substring(beginIndex, endIndex);
        idList[count-1] = currentID;
        count++;
      }
      inputLine = in.readLine();
    }
    return idList;
  }

  public static Skater skaterCreator(String playerID){
    Skater currentPlayer = new Skater();
    currentPlayer.id = playerID;
    URL playerGameLog = new URL("https://www.hockey-reference.com/players/" + playerId.substring(0,1) + "/" + playerID + "/gamelog/2020/");
    URL playerPage = new URL("https://www.hockey-reference.com/players/" + playerId.substring(0,1) +"/" + playerID + ".html")
  }
}
