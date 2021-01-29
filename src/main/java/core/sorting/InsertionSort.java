package core.sorting;

import java.util.Arrays;

public class InsertionSort {

    public static void sort(int[] A){
        int len = A.length;
        int i,j;
        int key;
        for(i=1;i<len;++i){
            key = A[i];
            j=i-1;
        while(j>=0 && A[j]>=key){
            A[j+1]=A[j];
            j--;
        }
        A[j+1]=key;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,3,5,6,8,9,4};
        sort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }
}
