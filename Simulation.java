public class Simulation{
  public static void main(String[] args){
    int[] wins = new int[11];
    int[] currentGame = new int[11];
    boolean flag = true;
    int die1 = 0;
    int die2 = 0;
    int roll = 0;
    int[] winning = {1,1,1,1,1,1,1,1,1,1,1};
    boolean balanced = false;
    while(!balanced){
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
      int max = 0;
      int maxIndex = 0;
      for(int k=0; k<wins.length-1; k++){
        if(wins[k]>max){
          max = wins[k];
          maxIndex = k;
        }
      }
        if(max>10100){
          winning[maxIndex]++;
          if(maxIndex != (winning.length-maxIndex-1)){
            winning[winning.length-1-maxIndex]++;
          }
        }else{
          balanced = true;
        }
        System.out.print("Current Status: ");
        for(int j=0; j<wins.length; j++){
          wins[j] = 0;
          System.out.print("Index " + j + ": " + winning[j] + ", ");
        }
        System.out.print("Outlier: " + max + " at " + maxIndex);
        System.out.print("\n");
      }
    }
//    for(int i=0; i<wins.length; i++){
//      System.out.println("Die roll: " + (i+2) + " Winning Condition: " + winning[i] + " Wins: " + wins[i] + " Probability: " + ((double) wins[i] / 110000));
//    }
  }
