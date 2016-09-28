/**
 * Created by aishpratap on 9/28/16.
 */

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class QuickSort {

    private Integer[] numbers;

    public static void main(String args[]){
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int testCases = scanner.nextInt();

        for (int tests = 0; tests<testCases; tests ++){

            System.out.println("To end the array of elements, enter '-1'");
            ArrayList<Integer> unsortedArray = new ArrayList<>();

            while (scanner.hasNextInt()){

                int value = scanner.nextInt();
                if (value<0){
                    break;
                }
                unsortedArray.add(value);
            }

            QuickSort qSort = new QuickSort();
            qSort.numbers = unsortedArray.toArray(new Integer[unsortedArray.size()]);
            qSort.sort(qSort.numbers, 0, qSort.numbers.length-1);
            System.out.println(Arrays.toString(qSort.numbers));
        }
    }

    private void sort(Integer[] array, int low, int high){

        if (low<high){
            int p = this.partition(array,low,high);
            this.sort(array,low,p);
            this.sort(array,p + 1, high);
        }

    }

    private int partition(Integer[] array, int low, int high){

        int pivot = array[high];

        for (int j = low; j<high-1; j++){
            if (array[j]<=pivot){
                int temp = array[low];
                array[low] = array[j];
                array[j] = temp;
                low ++;
            }
        }

        int temp = array[low];
        array[low] = array[high];
        array[high] = temp;

        return low;
    }

}
