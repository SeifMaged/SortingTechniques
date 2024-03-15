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

    public int getKthSmallestElement(int[] array, int first, int last, int k){
        if(k >= 0 && k < last - first + 1){
            int posititon = partition(array, first, last);
            if(posititon - first == k){
                return array[posititon];
            }
            else if(posititon - first > k){
                return getKthSmallestElement(array, first, posititon - 1, k);
            }
            return getKthSmallestElement(array, posititon + 1, last,k - posititon + first - 1);
        }
        return 0;
    }
}
