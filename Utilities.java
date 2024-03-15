import java.util.*;

public class Utilities {
    public static void swap(int[] array , int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static int getRandom(int low, int high){
        Random randNum = new Random();
        return randNum.nextInt(high - low + 1) + low;
    }

    public static int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt();
        }

        return arr;
    }

    public static int[] generateAscendingArray(int size) {
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = i;
        }

        return arr;
    }

    public static int[] generateDescendingArray(int size) {
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = size - i;
        }

        return arr;
    }

    public static void printArray(int[] array){
        for(int num : array){
            System.out.print(num + " ");
        }
        System.out.println();
    }
}