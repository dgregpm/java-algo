public class QuickSort {  
    public void sort(Integer[] arr){
        int lo = 0;
        int hi = arr.length - 1;
        this.quickSort(arr,lo,hi);
    }

    private void quickSort(Integer[] arr, int lo, int hi){
        if(lo >= hi){
            return;
        }
        int pivotIdx = this.partition(arr, lo, hi);

        this.quickSort(arr, lo, pivotIdx - 1);
        this.quickSort(arr, pivotIdx + 1, hi);
    }
    
    private int partition(Integer[] arr, int lo, int hi){
        int pivot = arr[hi];
        int idx = lo - 1;
        for (int i = lo; i < hi; i++) {
            if(arr[i] <= pivot){
                idx++;
                int tmp = arr[i];
                arr[i] = arr[idx];
                arr[idx] = tmp;                
            }
        }
        idx++;
        arr[hi] = arr[idx];
        arr[idx] = pivot; 
        return idx;
    }
}
