public class InsertionSort {

    public void sort(int[] arr) {
        for(int i=1;i<arr.length;i++){
            int idx = i;
            for (int j = i-1; j >= 0; j--) {
                if(arr[i] < arr[j])
                    idx = j;
            }
            if(idx != i){
                int tmp = arr[i];
                shift(arr,idx,i);
                arr[idx] = tmp;
            }
        }
    }

    private void shift(int[] arr, int a, int b){
        for (int i = b; i > a; i--) {
            arr[i] = arr[i-1];
        }
    }
}
