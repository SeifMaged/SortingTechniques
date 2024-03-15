import java.util.Arrays;

public class TestMain {
    public static void main(String[] args){
        int[] nums = Utilities.generateRandomArray(5);

        Utilities.printArray(nums);
        int[] numsForQuickSort = nums.clone();

        long startTime = System.currentTimeMillis();

        Sort sort = new QuickSort(numsForQuickSort);

        long endTime = System.currentTimeMillis();

        System.out.println(endTime - startTime);

        Utilities.printArray(numsForQuickSort);

        System.out.println(getKthLargestElement(numsForQuickSort, 3));
    }

    public static int getKthLargestElement(int[] array, int k){
        Sort sort = new QuickSort(array);
        return array[array.length - k];
    }
}
