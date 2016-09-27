import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by aishpratap on 9/27/16.
 */
public class BubbleSort {
    public static void main(String args[]){
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int testCases = scanner.nextInt();

        for (int tests = 0; tests < testCases; tests++){

            System.out.println("To end the array of elements, enter '-1'");

            ArrayList<Integer> unsortedArray = new ArrayList();

            while (scanner.hasNextInt()){

                int value = scanner.nextInt();
                if (value<0){
                    break;
                }
                unsortedArray.add(value);

            }

            unsortedArray = bubbleSort(unsortedArray);
            System.out.println(unsortedArray);
        }
    }

    static ArrayList<Integer> bubbleSort(ArrayList<Integer> unsorted){

        boolean sortPerformed = true;

        while (sortPerformed){
            sortPerformed = false;

            for (int i = 0; i<unsorted.size()-1; i++){
                if (unsorted.get(i)>unsorted.get(i+1)){
                    int temp = unsorted.get(i);
                    unsorted.set(i,unsorted.get(i+1));
                    unsorted.set(i+1,temp);
                    sortPerformed = true;
                }
            }
        }

        return unsorted;
    }

}
