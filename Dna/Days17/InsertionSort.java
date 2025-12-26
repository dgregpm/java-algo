public class InsertionSort {

    public void sort(int[] arr) {
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
}
