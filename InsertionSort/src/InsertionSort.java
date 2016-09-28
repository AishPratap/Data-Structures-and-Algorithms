/**
 * Created by aishpratap on 9/27/16.
 */

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class InsertionSort {

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

            InsertionSort iSort = new InsertionSort();
            unsortedArray = iSort.insertionSort(unsortedArray);
            System.out.println(unsortedArray);
        }
    }

    //Compare elements next to each other and sort them. Repeat this till there is no need to swap again.
    ArrayList<Integer> insertionSort(ArrayList<Integer> unsorted){

        for (int i =1; i < unsorted.size(); i++){

            int key = unsorted.get(i);

            for (int j = i-1;j >= 0 && key<unsorted.get(j); j--){
                unsorted.set(j+1,unsorted.get(j));
                unsorted.set(j,key);
            }
        }

        return unsorted;
    }
}
