import java.util.Scanner;

/**
 * Created by aishpratap on 10/9/16.
 */
public class MinDist {

    public static void main(String args[]){

        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        MinDist obj = new MinDist();

        for (int tests = 0; tests<testCases; tests++){

            String initialString = scanner.next();
            String targetString = scanner.next();

            int minDistance = obj.minDistance(initialString,targetString);
            System.out.println(minDistance);
        }
    }

    private int minDistance(String inputString, String targetString){

        int[][] minDistances = new int[inputString.length() +1][targetString.length()+1];

        for (int i=0; i<=inputString.length(); i++){
            minDistances[i][0] = i;
        }

        for (int j=0; j<=targetString.length(); j++){
            minDistances[0][j] = j;
        }

        for (int i=0; i<inputString.length(); i++){
            char input = inputString.charAt(i);
            for (int j=0; j<targetString.length(); j++){
                char target = targetString.charAt(j);

                if (input == target){
                    minDistances[i+1][j+1] = minDistances[i][j];
                }else {
                    int delCost = minDistances[i+1][j] + 1;
                    int addCost = minDistances[i][j+1] + 1;
                    int subCost = minDistances[i][j] + 1;

                    minDistances[i+1][j+1] = Math.min(Math.min(addCost,subCost),delCost);
                }

            }
        }
        return minDistances[inputString.length()][targetString.length()];
    }
}
