package core.sorting;

import java.util.Arrays;

public class MergeSort {

    public static void merge(int[] merged,int[] arr1,int[] arr2){
        int ar1Len = arr1.length;
        int ar2Len = arr2.length;

        int i=0,j=0,k=0;

        while(i<ar1Len && j<ar2Len){
            if(arr1[i]<=arr2[j]){
                merged[k]=arr1[i];
                k++;
                i++;
            }else{
                merged[k]=arr2[j];
                j++;
                k++;
            }
        }

        while(i<ar1Len){
            merged[k]=arr1[i];
            i++;
            k++;
        }
        while(j<ar2Len){
            merged[k]=arr2[j];
            j++;
            k++;
        }
    }

    public static void mergeSort(int[] A){
        if(A.length<2) return;
        int mid = A.length/2;

        int[] left = new int[mid];
        int [] right = new int[A.length-mid];

        for(int i=0;i<mid;i++){
            left[i]=A[i];
        }

        for(int i=mid;i<A.length;i++){
            right[i-mid]=A[i];
        }

        mergeSort(left);
        mergeSort(right);
        merge(A,left,right);

    }

  public static void main(String[] args) {
      int [] testArray = {5,3,2,44,22,1,3,5,6};
      mergeSort(testArray);
      Arrays.stream(testArray).forEach(System.out::println);
  }

}
