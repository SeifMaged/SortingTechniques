public class HybridMergeSort extends MergeSort {
    public void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private void sort(int[] arr, int first, int last) {
        if (first < last) {
            if (last - first < Utilities.THRESHOLD) {
                new InsertionSort().sort(arr, first, last);
            } else {
                int mid = (first + last) / 2;
                sort(arr, first, mid);
                sort(arr, mid + 1, last);
                merge(arr, first, mid, last);
            }
        }
    }
}