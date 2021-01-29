package core.dssolutions;

import java.util.Arrays;

public class ZeroOneTwoArraySortt {

    public static void main(String[] args) {
    int[] arr = {0,0,1,2,1,1,2,2,1,1,1};
        int zeroIndex=0;
        int twoIndex=arr.length-1;
        int midIndex =0;

       while(midIndex<=twoIndex){
           switch (arr[midIndex]){
               case 0:
                   swap(arr,midIndex,zeroIndex);
                   zeroIndex++;
                   midIndex++;
                   break;
               case 1:
                   midIndex++;
                   break;
               case 2:
                   swap(arr,midIndex,twoIndex);
                   twoIndex--;
                   break;
           }
        }
        Arrays.stream(arr).forEach(System.out::println);
  }

  private static void swap(int[] arr,int i,int j){
        int temp= arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
  }
}
