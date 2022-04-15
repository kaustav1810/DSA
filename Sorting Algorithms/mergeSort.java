/*  
    ** Divide and Conquer Algorithm **

    STEPS:
        -> calculate mid element of array
        -> call fn. for left half
        -> call fn. for right half
        -> merge elements of both halves in ascending order

    T.C.: O(nlogn)
    S.C: O(n) (extra 2 arrays needed for merging both halves)

    Stable: Yes
    In-Place: No

    **NOTE: Array elements are stored in sequential blocks of memory(like arr[0]:8081,arr[1]:8082,arr[2]:8083,...)
    so accessing any random array element takes constant time which is not
    the case for linked lists where elements may not be stored in sequence.

    So in case of arrays quick sort is preferred over merge sort since in quick
    sort access of random elements are more frequent compared to merge sort which
    is again preferred over quick sort for linked lists.

 */

public static void merge(int[] arr,int l,int r){
    int mid = (l+r)/2;

    // we take two arrays to store elements for left & right halves
    int n1 = mid+1-l,n2 = r-mid;

    int[] first = new int[n1];
    int[] second = new int[n2];

    int k = l;

    // storing elements of left half in first array
    for(int i=0;i<n1;i++){
        first[i] = arr[k++];
    }

    k = mid+1;


    // storing elements of right half in second array
    for(int i=0;i<n2;i++){
        second[i] = arr[k++];
    }

    int ptr1 = 0,ptr2 = 0;

    k = l;

    // merge elements of 1st & 2nd array in sorted manner
    while(ptr1<n1 && ptr2<n2){
        
        if(first[ptr1]<=second[ptr2]) arr[k++] = first[ptr1++];

        else arr[k++] = second[ptr2]++;

    }

    while(ptr1<n1) arr[k++] = first[ptr1++];

    while(ptr2<n2) arr[k++] = second[ptr2++];

}

public static void mergeSort(int[] arr,int l,int r){

    if(l>=r) return;

        int mid = (l+r)/2;

        // Call for left half of array
        mergeSort(arr,l,mid);

        // Call for right half of array
        mergeSort(arr,mid+1,r);

        // merge left & right halves
        merge(arr,l,r);
}
public static void main(String[] args){
    int[] arr = {3,4,4,2,1,65,4}

    mergeSort(arr,0,6);
}