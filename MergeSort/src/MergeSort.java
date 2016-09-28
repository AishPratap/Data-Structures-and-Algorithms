/**
 * Created by aishpratap on 9/27/16.
 */

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {

    private Integer[] numbers;
    private Integer[] helper;
    private int length;

    public static void main(String args[]){

        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int testCases = scanner.nextInt();

        for (int tests = 0; tests < testCases; tests++){

            System.out.println("To end the array of elements, enter '-1'");

            ArrayList<Integer> unsortedArray = new ArrayList<>();

            while (scanner.hasNextInt()){

                int value = scanner.nextInt();
                if (value<0){
                    break;
                }
                unsortedArray.add(value);
            }

            MergeSort mSort = new MergeSort();
            mSort.sort(unsortedArray);
        }
    }

    private void sort(ArrayList<Integer> unsorted){
        this.numbers = unsorted.toArray(new Integer[unsorted.size()]);
        this.length = numbers.length;
        this.helper = new Integer[this.length];

        this.doMerge(0,length-1);
        System.out.println(Arrays.toString(this.numbers));
    }

    private void doMerge(int lowerLimit, int upperLimit){

        if (lowerLimit<upperLimit){
            int middle = (lowerLimit + upperLimit)/2;
            this.doMerge(lowerLimit, middle);
            this.doMerge(middle + 1, upperLimit);
            this.merge(lowerLimit, middle, upperLimit);

        }
    }

    private void merge(int lowerLimit, int middle, int upperLimit){

        for (int  i = lowerLimit; i<=upperLimit; i++){
            this.helper[i] = this.numbers[i];
        }

        int firstArrayPointer = lowerLimit;
        int secondArrayPointer = middle+1;
        int mergePointer = lowerLimit;

        while (firstArrayPointer<=middle && secondArrayPointer<=upperLimit){
            if (this.helper[firstArrayPointer]<=this.helper[secondArrayPointer]){
                this.numbers[mergePointer] = this.helper[firstArrayPointer];
                firstArrayPointer ++;
            }else {
                this.numbers[mergePointer] = this.helper[secondArrayPointer];
                secondArrayPointer ++;
            }
            mergePointer ++;
        }

        while (firstArrayPointer<=middle){
            numbers[mergePointer] = helper[firstArrayPointer];
            firstArrayPointer++;
            mergePointer++;
        }
    }
}
