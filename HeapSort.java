public class HeapSort implements Sort {
    public void sort(int arr[]) {
        buildMaxHeapify(arr);
        int n = arr.length;
        for (int i = n - 1; i >= 0; i--) {
            Utilities.swap(arr, i, 0);
            maxHeapify(arr, i, 0);
        }
    }

    private void maxHeapify(int arr[], int size, int node) {
        int max = node;
        int left = 2 * node + 1;
        int right = 2 * node + 2;
        if (right < size && arr[right] > arr[max]) {
            max = right;
        }
        if (left < size && arr[left] > arr[max]) {
            max = left;
        }
        if (max != node) {
            Utilities.swap(arr, node, max);
            maxHeapify(arr, size, max);
        }
    }

    private void buildMaxHeapify(int arr[]) {
        int n = arr.length;
        for (int i = (n / 2) - 1; i >= 0; i--) {
            maxHeapify(arr, n, 0);
        }
    }
}
