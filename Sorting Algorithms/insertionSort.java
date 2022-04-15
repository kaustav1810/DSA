/* 
    STEPS:
        -> while current element > previous,shift all previous elements
        by 1 index to right
        -> insert current element at correct position
        -> repeat above steps for all array elements

    T.C(Worst Case): O(n^2) nested loops 
    T.C(Best Case): O(n) if array is already sorted
     
    S.C: O(1)

    Stable: Yes
    In-Place: Yes

    **NOTE: insertion sort can be optimized by using binary search to find
        correct index to insert element which will take O(logn) time instead
        of O(n). Overall T.C still remains O(n^2) due to swap() operations.
*/

public static void insertionSort(int[] arr,int n){

    for(int i=1;i<n;i++){
        int j = i;

        int current_item = arr[i];

        // while arr[i]>arr[j] shift all previous elements by 1 index to right
        while(j>0 && arr[j-1]>current_item){
            arr[j] = arr[j-1];

            j--;
        }

        // insert current element at correct position
        arr[j] = current_item;

    }
}


public static void main(String[] args){
    int[] arr = {3,4,4,2,1,65,4}

    insertionSort(arr,7);
}