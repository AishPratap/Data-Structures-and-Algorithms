import java.util.Scanner;

/**
 * Created by aishpratap on 3/29/17.
 */
public class CoinChange {

  public static void main(String[] args){
    Scanner s = new Scanner(System.in);

    int changeFor = s.nextInt();
    int denominations = s.nextInt();

    int[] coins = new int[denominations];

    for(int i = 0; i < denominations; i++){
      coins[i] = s.nextInt();
    }

    int changeCount = numberOfChanges(coins, changeFor);

    System.out.println(changeCount);
  }

  public static int numberOfChanges(int[] coins, int value){

    int length = coins.length;

    int[][] coinMatrix = new int[length +1][value + 1];

    for (int i = 0; i <= length; i ++){
      coinMatrix[i][0] = 1;
    }

    for (int i = 0; i <= value; i ++){
      coinMatrix[0][i] = 0;
    }

    for(int i = 1; i <= length; i++){
      for (int j = 1; j <= value; j++){

        if (coins[i-1] > j){
          coinMatrix[i][j] = coinMatrix[i-1][j];
        }else{
          coinMatrix[i][j] = coinMatrix[i-1][j] + coinMatrix[i][j-coins[i-1]];
        }
      }
    }

    return coinMatrix[length][value];
  }
}
