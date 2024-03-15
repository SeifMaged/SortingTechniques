public class SelectionSort implements Sort {
    public void sort(int arr[]) {
        int i, j, minIndex;
        int n = arr.length;
        for (i = 0; i < n; i++) {
            minIndex = i;
            for (j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            Utilities.swap(arr, minIndex, i);
        }
    }
}
