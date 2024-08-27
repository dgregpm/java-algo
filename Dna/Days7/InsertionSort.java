import utils.ArrayListX;

public class InsertionSort {

    public void sort(ArrayListX<Integer> arr){

    }

    public void sort2(int[] arr) {
        int idx;
        for (int i = 0; i < arr.length; i++) {
            idx = i;
            for (int j = i; j >= 0; j--) {
                if(arr[i] < arr[j])
                    idx = j;
            }
            if(idx != i){
                int tmp = arr[i];
                for (int k = i; k > idx; k--) {
                    arr[k] = arr[k-1];
                }
                arr[idx] = tmp;
            }
        }
    }
}
