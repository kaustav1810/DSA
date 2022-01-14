/*

STEPS:
    -> Consider arr[0] as pivot element
    -> place pivot element at it's correct position
    -> place all arr[i] to left of pivot where i<pivotIndex & arr[i]<=pivot
    -> place all arr[j] to right of pivot where j>pivotIndex & arr[j]>=pivot

and then just like merge sort it divides the array into two halves & repeat
above steps

 pivot can be considered any of the following:
    - arr[0]
    - arr[n-1] (n: length of array)
    - arr[mid] (middle element)   

    T.C: O(nlogn) -> same as merge sort
    S.C: O(1) no extra space is needed

    Stable: No
    In-Place: Yes
*/

public static int partition(int[] arr,int l,int r){

    int pivot = arr[l];

    int count = 0;

    // get count of elements smaller than current pivot
    for(int i=l+1;i<=r;i++){
        if(arr[i]>= pivot) count++;
    }

    // pivot is shifted to current pivot position+count index
    // e.g. [3,4,5,2,1] considering pivot '3' two elements < pivot,
    // so two elements will come before pivot so pivotIndex = 0+2 = 2;

    int pivotIndex = l+count;

    swap(arr,l,pivotIndex);

    int i = 0,j=e;

    // swap until all elements left of pivot element are less than pivot and to the 
    // right of pivot greater than pivot

    while(i<pivotIndex && j>pivotIndex){
        while(arr[i]<pivot) i++;

        while(arr[j]>pivot) j--;

        // swap since element left of pivot arr[i]>pivot and element right
        // of pivot arr[j]<pivot

        swap(arr,i++,j--);
    }

    return pivotIndex;

}

public static void quickSort(int[] arr,int l,int r){

    while(l<r){
        int pivot_index = partition(arr,l,r);

        // call for left part of array
        quickSort(arr,l,pivot_index-1);

        // call for right part of array
        quickSort(arr,pivot_index+1,r);
    }
}

public static void main(String[] args){
    int[] arr = {3,4,4,2,1,65,4}

    quickSort(arr,0,6);
}