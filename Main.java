public class Main {
    public static void main(String[] args) {
        int[] nums = Utilities.generateRandomArray(50000);

        Utilities.calculateTime(nums, new QuickSort(), "Quick sort");
        Utilities.calculateTime(nums, new HeapSort(), "Heap sort");
        Utilities.calculateTime(nums, new MergeSort(), "Merge sort");
        Utilities.calculateTime(nums, new HybridMergeSort(), "Hybrid merge sort");
        Utilities.calculateTime(nums, new SelectionSort(), "Selection sort");
        Utilities.calculateTime(nums, new InsertionSort(), "Insertion sort");
        // System.out.println(getKthLargestElement(numsForQuickSort, 3));
    }

    public static int getKthLargestElement(int[] array, int k) {
        new QuickSort().sort(array);
        return array[array.length - k];
    }
}
