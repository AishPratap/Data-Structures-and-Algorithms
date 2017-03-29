import java.util.HashMap;

public class Flavors {

  public static void main(String[] args) {

    int[][] sea = new int[][] {
        new int[] {0,  0,  0,  0,  0, 0, 1},
        new int[] {0,  0,  0,  1,  0, 0, 0},
        new int[] {1,  0,  0,  0,  0, 0, 0},
        new int[] {0,  0,  0,  0,  0, 1, 0},
        new int[] {0,  0,  0,  1,  0, 0, 0} };


    System.out.println(sea.length  + " " + sea[1].length);


    int numOfIslands = Flavors.countIslands(sea);
    System.out.println("Number of islands is "+numOfIslands);
  }

  public static int countIslands(int[][] sea) {
    boolean[][] checked = new boolean[sea.length][sea[1].length];
    for (int i = 0; i < sea.length; i++) {
      for (int j = 0; j < sea[1].length; j++) {
        checked[i][j] = false;
      }
    }
    return countIslands(sea, checked);
  }

  public static int countIslands(int[][] sea, boolean[][] checked) {
    int numOfIslands = 0;
    for (int i = 0; i < sea.length; i++) {
      for (int j = 0; j < sea[1].length; j++) {
        if (checked[i][j])
          continue;
        if (sea[i][j] == 0) {
          checked[i][j] = true;
          continue;
        }
        numOfIslands++;
        floodFill(i, j, sea, checked);
      }
    }
    return numOfIslands;
  }

  public static void floodFill(int row, int col, int[][] sea, boolean[][] checked) {
    if (sea[row][col] == 0 || checked[row][col]) return;
    checked[row][col] = true;
    if (col < sea.length - 1) floodFill(row, col+1, sea, checked);
    if (row < sea.length - 1) floodFill(row+1, col, sea, checked);
    if (col > 0) floodFill(row, col-1, sea, checked);
    if (row > 0) floodFill(row-1, col, sea, checked);
  }


//  public static void main (String[] args) throws java.lang.Exception
//  {
//    // your code goes here
//    Flavors obj = new Flavors();
//    int[] array1 = new int[]{2,3,4,5,6,7};
//    int[] array2 = new int[]{4,3,2,1,5,4,3};
//    System.out.println(obj.removeKdigits(10, array1, array2));
//
//  }
//
//  //746209249 5 = 0249
//
//  //64738929 0 =
//
//  public boolean removeKdigits(int num, int[] k, int[] j) {
//
//    HashMap<Integer, Integer> intMap = new HashMap<>();
//
//    for (int value:j){
//      intMap.put(new Integer(value),new Integer(1));
//    }
//
//
//    for (int value:k){
//      System.out.println(new Integer(num - value));
//      if(intMap.containsKey(new Integer(num - value))){
//        return true;
//      }
//    }
//
//    return false;



  }


}