public class InsertionSort {

    public void sort(int[] arr) {
       for (int i = 0; i < arr.length; i++) {
           int idx = i;
           for (int j = i; j < arr.length; j++) {
               if(arr[j] < arr[idx]){
                   idx = j;                   
               }
           }
           if(idx != i){
               int tmp = arr[idx];
               for (int k = idx; k > i; k--) {
                    arr[k] = arr[k-1];                         
               }
               arr[i] = tmp;
           }
       } 
    }
}
