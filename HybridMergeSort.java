public class HybridMergeSort extends MergeSort {
    public void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static final InsertionSort insertionSort = new InsertionSort();
    private void sort(int[] arr, int first, int last) {
        if (first < last) {
            if (last - first <= Utilities.THRESHOLD) {
                insertionSort.sort(arr, first, last);
            } else {
                int mid = (first + last) / 2;
                this.sort(arr, first, mid);
                this.sort(arr, mid + 1, last);
                merge(arr, first, mid, last);
            }
        }
    }
}
