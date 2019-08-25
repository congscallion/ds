package io.ds.congscallion.array;

public class MaximumMinimumArrayDemo {


  public static  void print(int[] arr){
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;

    for (int number: arr){

      if(number > max){
        max = number;
      }else if(number < min){
        min = number;
      }
    }

    System.out.println("max: "+ max);
    System.out.println("min: "+ min);

  }


  public static void main(String[] args) {

    int[] arr = {1,23,4,5,6,83};
    print(arr);


  }

}
