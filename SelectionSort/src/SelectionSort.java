/**
 * Created by aishpratap on 9/27/16.
 */

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class SelectionSort {

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

            SelectionSort sSort = new SelectionSort();
            unsortedArray = sSort.selectionSort(unsortedArray);
            System.out.println(unsortedArray);
        }
    }

    //recursively iterate over each of the element in the array to find the index of the
    // minimum element and then swap.
    ArrayList<Integer> selectionSort(ArrayList<Integer> unsorted){

        for (int i = 0; i<unsorted.size(); i++){

            int lowestIndex = i;

            for (int j = i+1; j<unsorted.size(); j++){

                if (unsorted.get(j)<unsorted.get(lowestIndex)){
                    lowestIndex = j;
                }
            }

            int temp = unsorted.get(i);
            unsorted.set(i,unsorted.get(lowestIndex));
            unsorted.set(lowestIndex, temp);
        }

        return unsorted;
    }

}
