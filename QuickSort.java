public class QuickSort implements Sort {
    public void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private void sort(int[] arr, int first, int last) {
        if (last <= first) {
            return;
        }
        int pivotIndex = partition(arr, first, last);
        sort(arr, first, pivotIndex - 1);
        sort(arr, pivotIndex + 1, last);
    }

    private int partition(int[] arr, int first, int last) {
        int pivotIndex = Utilities.getRandom(first, last);
        int pivot = arr[pivotIndex];

        Utilities.swap(arr, pivotIndex, last);

        int i = first - 1;
        for (int j = first; j < last; j++) {
            if (arr[j] < pivot) {
                i++;
                Utilities.swap(arr, i, j);
            }
        }

        Utilities.swap(arr, i + 1, last);
        return i + 1;
    }
}
