import java.util.Random;

public class QuickSort {  

    public int partition(int[] arr, int lo, int hi){
        Random rand = new Random();
        int pIdx = lo + rand.nextInt((hi-lo)+1);

        //int pIdx = (lo + hi)/2;
        int pivot = arr[pIdx];

        while(lo <= hi){
            if(arr[lo] > pivot && arr[hi] < pivot){
                swap(arr,lo,hi);
                lo++;
                hi--;
            //} else if(arr[lo] == pivot && arr[hi] == pivot){
              //  lo++;
                //hi--;
            } else if(arr[lo] <= pivot){
                lo++;
            } else if(arr[hi] >= pivot){
                hi--;
            }
        }
        if(lo < pIdx){
            swap(arr,pIdx,lo);
            pIdx = lo;
        } else if(hi > pIdx){
            swap(arr,pIdx,hi);
            pIdx = hi;
        }

        return pIdx;
    }

    public void qs(int[] arr, int lo, int hi){
        if(lo >= hi)
            return;

        int pivot = partition(arr,lo,hi);

        qs(arr,lo,pivot - 1);
        qs(arr,pivot + 1, hi);
    }

    public void sort(int[] arr){
        int lo = 0;
        int hi = arr.length - 1;
        qs(arr,lo,hi);
    }

    private void swap(int[] arr, int a, int b){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
