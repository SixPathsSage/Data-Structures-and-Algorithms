package algorithms;

public class MergeSort {
    /*
    * Time Complexity: O(nlogn)
    * Space Complexity: O(n)
    * */

    public void sort(int[] array) {
        sortHelper(array, 0, array.length);
    }

    private void sortHelper(int[] array, int left, int right) {
        if(array.length <= 1) { return; }

        int mid = left + (right-left)/2;

        int[] leftArray = new int[mid];
        for(int i = 0; i < mid; i ++) {
            leftArray[i] = array[i];
        }
        int[] rightArray = new int[right-mid];
        for(int i = 0; i < (right-mid); i ++) {
            rightArray[i] = array[mid+i];
        }

        sortHelper(leftArray, 0, mid);
        sortHelper(rightArray, 0, right-mid);
        merge(leftArray, rightArray, array);
    }

    private void merge(int[] left, int[] right, int[] array) {
        int leftIndex = 0;
        int rightIndex = 0;

        int index = 0;
        while(leftIndex < left.length && rightIndex < right.length) {
            if(left[leftIndex] < right[rightIndex]) {
                array[index] = left[leftIndex];
                leftIndex ++;
            }
            else {
                array[index] = right[rightIndex];
                rightIndex ++;
            }
            index ++;
        }

        while(leftIndex < left.length && rightIndex == right.length) {
            array[index] = left[leftIndex];
            leftIndex ++;
            index ++;
        }

        while(leftIndex == left.length && rightIndex < right.length) {
            array[index] = right[rightIndex];
            rightIndex ++;
            index ++;
        }
    }
}
