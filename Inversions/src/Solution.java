import java.util.Arrays;

/**
 * Created by aishpratap on 1/16/17.
 */

  public class Solution {

    static int[] input;
    static int[] tempArray;
    static long inversions = 0;

    public static long countInversions(int[] arr){
      input = arr;
      sort(0,arr.length-1);
      System.out.println(Arrays.toString(input));
      return inversions;
    }

    public static void merge(int low, int mid, int high){

      for(int i = low; i<= high; i++){
        tempArray[i] = input[i];
      }

      int i = low;
      int j = mid + 1;
      int k = low;

      while(i<=mid && j<=high)
      {
        if(tempArray[i] <= tempArray[j]){
          input[k] = tempArray[i];

          i++;
        }else{
          input[k] = tempArray[j];
          inversions ++;
          j++;
        }
        k++;
      }
      while(i<=mid){
        input[k] = tempArray[i];
        i++;
        k++;
      }

    }

    public static void sort(int low, int high){

      if(low < high){
        int mid = (low + high)/2;
        sort(low,mid);
        sort(mid+1,high);
        merge(low,mid,high);
      }
    }

    public static void main(String[] args) {

        int arr[] = {2,1,3,1,2};
        tempArray = new int[arr.length];
        System.out.println("Heyo");
        System.out.println(countInversions(arr));

    }


  }


