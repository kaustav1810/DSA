/* 
    STEPS:
        -> swap current element with previous until current element greater than previous
        -> Repeat above step for all array elements

    At ith iteration,bubble sort places ith largest element in (n-i-1)th position
    in array

    So in 1st iteration 1st largest element is placed at n-0-1 index
    So in 2nd iteration 2nd largest element is placed at n-1-1 index
    .
    .
    ... and so on

    T.C(Worst Case): O(n^2) nested loops 
    T.C(Best Case): O(n) if array is already sorted
     
    S.C: O(1)

    Stable: Yes
    In-Place: Yes
*/

public static void bubbleSort(int[] arr,int n){

    for(int i=0;i<n;i++){
        for(int j=i+1;j<n-i-1;j++){
            // if current element greater than previous one then swap
            if(arr[j-1]>arr[j]) swap(arr,j,j-1);
        }
    }
}

public static void main(String[] args){
    int[] arr = {3,4,4,2,1,65,4}

    bubbleSort(arr,7);
}