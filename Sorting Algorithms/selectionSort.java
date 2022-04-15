/* 
    STEPS
        -> find current minimum element at each iteration
        -> swap current minimum element with ith index
        -> repeat above steps for all array elements

    T.C.: O(n^2)
    S.C: O(1);

    Stable: No (Can be made stable by shifting elements 
    and placing min element at it's correct index instead of swapping)
    In-Place: Yes
*/

public static void selectionSort(int[] arr,int n){
    
    int min_index = 0,min_element = Integer.MAX_VALUE;

    for(int i=0;i<n-1;i++){
        for(int j=i+1;j<n;j++){
            if(min_element>arr[j]){
                min_index = j;
                min_element = arr[j];
            }
        }

        swap(arr,i,min_index);
    }
}

public static void main(String[] args){
    int[] arr = {3,4,4,2,1,65,4}

    selectionSort(arr,7);
}