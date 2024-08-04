import utils.ArrayListX;

public class InsertionSort {

    public void sort(ArrayListX<Integer> arr) {
        for (int i = 0; i < arr.size(); i++) {
            int pos = i;
            for (int j = i - 1; j >= 0; j--) {
                if(arr.get(i) < arr.get(j))
                    pos = j;
            }
            if(pos != i)
                arr.insertAt(arr.removeAt(i),pos);
        }
    }

}
