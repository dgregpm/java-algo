public class InsertionSort {

    public void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int idx = i;
            for (int j = i-1; j >= 0; j--) {
                if(arr[j] > arr[i])
                    idx = j;
            }
            if(idx != i){
                int tmp = arr[i];
                for (int k = i; k > idx; k--)
                    arr[k] = arr[k-1];
                arr[idx] = tmp;
            }
        }
    }
}
