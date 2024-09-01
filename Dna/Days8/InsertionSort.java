public class InsertionSort {

    public void sort(int[] arr) {
        int idx;
        for (int i = 0; i < arr.length; i++) {
            idx = i;
            for (int j = i; j >= 0; j--) {
                if(arr[j] > arr[i])
                    idx = j;
            }
            if(idx != i){
                int tmp = arr[i];
                shift(arr,i,idx);
                arr[idx] = tmp;
            }
        }
    }

    private void shift(int[] arr, int from, int to){
        for (int i = from; i > to; i--) {
            arr[i] = arr[i-1]; 
        }
    }
}
