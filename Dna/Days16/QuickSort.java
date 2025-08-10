public class QuickSort {  

    public void sort(int[] arr){
        int lo = 0;
        int hi = arr.length - 1;
        qs(arr,lo,hi);
    }

    private int partition(int[] arr, int lo, int hi){
        int mid = (lo + hi)/2;
        int pivot = arr[mid];
        while(lo <= hi){
            if(arr[lo] > pivot && arr[hi] < pivot){
                int tmp = arr[lo];
                arr[lo++] = arr[hi];
                arr[hi--] = tmp;
            }else if(arr[lo] <= pivot){
                lo++;
            }else if(arr[hi] >= pivot){
                hi--;
            }
        }
        if(lo < mid){
            this.swap(arr,lo,mid);
            mid = lo;
        } else if(hi > mid){
            this.swap(arr,hi,mid);
            mid = hi;
        }
        return mid;
    }

    private void qs(int[] arr, int lo, int hi){
        if (lo >= hi) {
            return;
        }
        int pivot = this.partition(arr, lo, hi);

        qs(arr, lo, pivot - 1);
        qs(arr, pivot + 1, hi);
    }

    private void swap(int[] arr, int a, int b){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

}
