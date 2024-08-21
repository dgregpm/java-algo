import utils.ArrayListX;

public class InsertionSort {

    public void sort(ArrayListX<Integer> arr) {
        int idx = 0;
        for (int i = 1; i < arr.size(); i++) {
            int curr = arr.get(i);
            idx = i;
            for(int j = i-1;j>=0;j--){
                if(arr.get(j) >= curr)
                    idx = j;
            }
            if(idx != i)
                arr.insertAt(arr.removeAt(i),idx);
        }
    }

    public void sort2(int[] arr){
        int idx = 0;
        for (int i = 1; i < arr.length; i++) {
            idx = i;
            for (int j = i - 1; j >= 0; j--) {
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
            arr[i] = arr[i - 1];            
        }
    }
}
