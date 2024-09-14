public class BubbleSort {
    public static void sort(int[] arr){
        boolean sorted = false;
        for (int i = 0; i < arr.length; i++) {
            sorted = true;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if(arr[j] > arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                    sorted = false;
                }
            }
            if(sorted)
                break;
        }
    }
}
