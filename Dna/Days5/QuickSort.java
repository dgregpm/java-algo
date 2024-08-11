public class QuickSort {  

    public void sort(Integer[] arr){
        int lo = 0;
        int hi = arr.length - 1;
        qs(arr,lo,hi);
    } 

    private int partition(Integer[] arr, int lo, int hi){
        int idx = (lo + hi)/2;
        int pivot = arr[idx];

        while(lo <= hi){
            if(arr[lo] > pivot && arr[hi] < pivot){
                swap(arr,lo,hi);
                lo++;
                hi--;
            } else if(arr[lo] <= pivot)
                lo++;
            else if(arr[hi] >= pivot)
                hi--;
        }
        if(lo < idx){
            swap(arr,lo,idx);
            idx = lo;
        } else if(hi > idx){
            swap(arr,hi,idx);
            idx = hi;
        }
        return idx;
    }

    private void swap(Integer[] arr, int x, int y){
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }

    private void qs(Integer[] arr, int lo, int hi){
        if(lo >= hi)
            return;

        int pivot = partition(arr,lo,hi);

        qs(arr, lo, pivot - 1);
        qs(arr, pivot + 1, hi);
    }
}
