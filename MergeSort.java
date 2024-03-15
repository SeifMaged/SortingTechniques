public class MergeSort implements Sort {
    public void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private void sort(int[] arr, int first, int last) {
        if (first < last) {
            int mid = (first + last) / 2;
            sort(arr, first, mid);
            sort(arr, mid + 1, last);
            merge(arr, first, mid, last);
        }
    }

    protected void merge(int[] arr, int left, int mid, int right) {
        int leftSize = (mid - left) + 1;
        int rightSize = right - mid;
        int[] leftArr = new int[leftSize];
        int[] rightArr = new int[rightSize];

        for (int i = 0; i < leftSize; i++)
            leftArr[i] = arr[left + i];
        for (int j = 0; j < rightSize; j++)
            rightArr[j] = arr[mid + j + 1];

        int i = 0, j = 0, k = left;

        while (i < leftSize && j < rightSize) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;

            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }
        // copy the elements of the array that hasn't ended yet
        while (i < leftSize) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }
        while (j < rightSize) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }
}
