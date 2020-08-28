package algorithms;

public class InsertionSort {
    /*
    * Best Case O(n)
    * Worst Case O(n^2)
    * Average Case O(n^2)
    * */
    public void sort(int[] array) {
        if(array.length > 1) {
            for(int i = 1; i < array.length; i ++) {
                int key = array[i];
                int j = i-1;
                while(j >= 0) {
                    if(array[j] > key) {
                        array[j+1] = array[j];
                    }
                    else {
                        break;
                    }
                    j--;
                }
                array[j+1] = key;
            }
        }
    }
}
