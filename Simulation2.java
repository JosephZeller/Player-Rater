public class Simulation2{
  public static void main(String[] args){
    int[] wins = new int[11];
    int[] currentGame = new int[11];
    boolean flag = true;
    int die1 = 0;
    int die2 = 0;
    int roll = 0;
    int[] winning = {27, 50, 73, 96, 118, 140, 118, 96, 73, 50, 27};
      for(int i=0; i<110000; i++){
        while(flag){
          die1 = (int)(6*Math.random())+1;
          die2 = (int)(6*Math.random())+1;
          roll = die1+die2;
          currentGame[roll-2]++;
          if(currentGame[roll-2]>=winning[roll-2]){
            flag = false;
          }
        }
        wins[roll-2]++;
        flag = true;
        for(int j=0; j<currentGame.length; j++){
          currentGame[j] = 0;
        }
      }

    for(int i=0; i<wins.length; i++){
      System.out.println("Die roll: " + (i+2) + " Winning Condition: " + winning[i] + " Wins: " + wins[i] + " Probability: " + ((double) wins[i] / 110000));
    }
  }
}
