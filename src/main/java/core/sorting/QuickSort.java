package core.sorting;

import java.util.Arrays;

public class QuickSort {

    public static int partition(int[] A,int start,int end){
        int pivot = A[end];
        int pIndex = start-1;

        int i;
        for( i=start;i<end;i++ ){
            if(A[i]<=pivot){
                pIndex++;
                swap(A,i,pIndex);
            }
        }
        swap(A,pIndex+1,i);

      return pIndex;
    }

    public static void swap(int[] A,int i,int j){
        int temp = A[i];
        A[i]=A[j];
        A[j]=temp;
    }

    public static void quickSort(int[] A,int start , int end){
        if(start<end){
            int pIndex = partition(A,start,end);
            quickSort(A,start,pIndex-1);
            quickSort(A,pIndex+1,end);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,3,5,6,8,9,4};
        quickSort(arr,0,arr.length);
        Arrays.stream(arr).forEach(System.out::println);
    }
}
