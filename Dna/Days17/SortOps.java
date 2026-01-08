public class SortOps{   
    public static void bubbleSort(int[] arr){
        for(int i = 0; i<arr.length; i++){
            for(int j = 0; j<arr.length - 1;j++){
                if(arr[j] > arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        } 
    }

    public static void insertionSort(int[] arr) {
        int idx = 0;
        for(int i=0;i<arr.length;i++){
            idx = i;
            for(int j=i;j>=0;j--){
                if(arr[j] > arr[i])
                    idx = j;
            }
            if(idx != i){
                int tmp = arr[i];
                for(int k = i;k>idx;k--){
                    arr[k] = arr[k-1];
                }
                arr[idx] = tmp;
            }
        }
    }

    public static void quickSort(int[] arr){
        int lo = 0;
        int hi = arr.length - 1;
        qs(arr,lo,hi);
    }
        private static int partition(int[] arr, int lo, int hi){
            int pIdx = (lo + hi)/2;
            int pivot = arr[pIdx];
            while(lo <= hi){
                if(arr[lo] > pivot && arr[hi] < pivot){
                swap(arr,lo,hi);
                lo++;
                hi--;
                }else if(arr[lo] <= pivot){
                lo++;
                }else if(arr[hi] >= pivot)
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

        private static void qs(int[] arr, int lo, int hi){
            if(lo >= hi)
                return;

            int pivot = partition(arr,lo,hi);

            qs(arr, lo, pivot - 1);
            qs(arr, pivot + 1, hi);
        }

        private static void swap(int[] arr, int a, int b){
            int tmp = arr[a];
            arr[a] = arr[b];
            arr[b] = tmp;
        }

    public static void mergeSort(int[] arr){

    }
}
