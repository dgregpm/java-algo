import utils.ArrayListX;

public class InsertionSort {

    public void sort(ArrayListX<Integer> arr) {
        for (int i = 1; i < arr.size(); i++) {
            int idx = i; 
            for (int j = i - 1; j >= 0 ; j--) {
                if(arr.get(j) > arr.get(i))
                    idx = j;
            }
            if(idx != i)
                arr.insertAt(arr.removeAt(i), idx);
        }

    }

}
