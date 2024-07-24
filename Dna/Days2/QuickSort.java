public class QuickSort {  

    public void sort(Integer[] arr){
        int lo = 0;
        int hi = arr.length - 1;
        qs(arr, lo, hi);
    }

    private int partition(Integer[] arr, int lo, int hi){
        int idx = lo - 1;
        int pivot = arr[hi];
        for (int i = lo; i < hi; i++) {
            if(arr[i] < pivot){
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

    private void qs(Integer[] arr, int lo, int hi){
        if(lo >= hi)
            return;

        int pivot = partition(arr, lo, hi);
        System.out.println("lo: " + lo + ", hi: " + hi);
        qs(arr, pivot + 1, hi);
        qs(arr, lo, pivot - 1);
    }

}
