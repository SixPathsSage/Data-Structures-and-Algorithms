package algorithms;

public class QuickSort {
    public void sort(int[] array) {
        sort(array, 0, array.length-1);
    }

    private void sort(int[] arr, int left, int right) {
        if(left >= right) { return; }

        int pivot = pivot(arr, left, right);
        sort(arr, left, pivot-1);
        sort(arr, pivot+1, right);

    }

    private int pivot(int[] array, int left, int right) {
        int pivot = right;

        int i = left-1;
        for(int j = left; j < right; j ++) {
            if(array[j] < array[pivot]) {
                i++;
                swap(array,i, j);
            }
        }
        i++;
        swap(array, i, pivot);

        return i;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
