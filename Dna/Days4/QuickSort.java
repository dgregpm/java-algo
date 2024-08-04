public class QuickSort {  

    public void sort(Integer[] arr){
        int lo = 0;
        int hi = arr.length - 1;
        qs(arr,lo,hi);
    }

    private int partition(Integer[] arr, int lo, int hi){
        int left = lo;
        int right = hi;
        int p = (lo + hi)/2;
        int pivot = arr[p];
        while(left <= right){
            if(arr[left] > pivot && arr[right] < pivot){
                swap(arr,left,right);
                left++;
                right--;
            }
            else if(arr[left] <= pivot)
                left++;
            else if(arr[right] >= pivot)
                right--;
        }
        if(p < right){
            swap(arr,p,right);
            p = right;
        } else if(p > left){
            swap(arr,p,left);
            p = left;
        }
        return p;
    }

    private void swap(Integer[] arr, int l, int r){
        Integer tmp = arr[l];
        arr[l] = arr[r];
        arr[r] = tmp;
    }

    private void qs(Integer[] arr, int lo, int hi){
        if(lo >= hi)
            return;

        int pivot = partition(arr,lo,hi);

        qs(arr,lo,pivot - 1);
        qs(arr,pivot + 1, hi);
    }

}
