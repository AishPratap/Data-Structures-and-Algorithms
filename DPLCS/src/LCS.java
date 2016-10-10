import java.util.Scanner;

/**
 * Created by aishpratap on 10/10/16.
 */
public class LCS {

    public static void main(String args[]){

        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        String targetString = scanner.nextLine();

        LCS obj = new LCS();
        int length = obj.getLongestCommonSubsequenceLength(inputString,targetString);
        System.out.println(length);
    }

    private int getLongestCommonSubsequenceLength(String inputString, String targetString){

        int[][] longestCommonLength = new int[inputString.length()+1][targetString.length()+1];

        for (int i = 0; i <= inputString.length(); i++){
            longestCommonLength[i][0] = 0;
        }

        for (int j = 0; j <= targetString.length(); j++){
            longestCommonLength[0][j] = 0;
        }


        for (int i=0; i<inputString.length(); i++){

            char inputChar = inputString.charAt(i);
            for (int j=0; j<targetString.length(); j++){

                char targetChar = targetString.charAt(j);

                if (inputChar == targetChar){
                    longestCommonLength[i+1][j+1] = longestCommonLength[i][j] + 1;
                }else {
                    longestCommonLength[i+1][j+1] = Math.max(longestCommonLength[i][j+1],longestCommonLength[i+1][j]);
                }
            }
        }

        return longestCommonLength[inputString.length()][targetString.length()];
    }
}

