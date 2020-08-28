package algorithms;

public class BubbleSort {
    /*
    * Best Case O(n^2)
    * Worst Case O(n^2)
    * Average Case O(n^2)
    * */
    public void sort(int[] array) {
        for(int i = 0; i < array.length; i ++) {
            for(int j = 1; j < array.length; j ++) {
                if(array[j-1] > array[j]) {
                    swap(array, j-1, j);
                }
            }
        }
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
