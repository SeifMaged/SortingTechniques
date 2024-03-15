import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] nums = Utilities.generateRandomArray(100000);

        Utilities.calculateTime(nums, new QuickSort(), "Quick sort");
        Utilities.calculateTime(nums, new HeapSort(), "Heap sort");
        Utilities.calculateTime(nums, new MergeSort(), "Merge sort");
        Utilities.calculateTime(nums, new HybridMergeSort(), "Hybrid merge sort");
        Utilities.calculateTime(nums, new SelectionSort(), "Selection sort");
        Utilities.calculateTime(nums, new InsertionSort(), "Insertion sort");

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter k: (value between 0 and " + nums.length + ")");
        int k = nums.length - scan.nextInt();
        int KthLargest = new QuickSort().getKthSmallestElement(nums, 0, nums.length - 1, k);


        if(getKthLargestElement(nums, nums.length - k) == KthLargest){
            System.out.print("Correct ");
            System.out.println(KthLargest);
        }
        else{
            System.out.println("Incorrect");
        }
    }

    public static int getKthLargestElement(int[] array, int k) {
        new QuickSort().sort(array);
        return array[array.length - k];
    }
}
