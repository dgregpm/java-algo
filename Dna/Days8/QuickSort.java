public class QuickSort {  

    public void sort(int[] arr){
        int lo = 0;
        int hi = arr.length - 1;
        qs(arr,lo,hi);
    }

    private int partition(int[] arr, int lo, int hi){
        int pIdx = (lo + hi)/2;
        int pivot = arr[pIdx];
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
        if(lo < pIdx){
            swap(arr,lo,pIdx);
            pIdx = lo;
        } else if(hi > pIdx){
            swap(arr,hi,pIdx);
            pIdx = hi;
        }
        return pIdx;
    }

    private void qs(int[] arr, int lo, int hi){
        if(lo >= hi)
            return;

        int pivot = partition(arr,lo,hi);

        qs(arr,lo,pivot - 1);
        qs(arr,pivot + 1, hi);
    }

    private void swap(int[] arr, int x, int y){
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }
}
