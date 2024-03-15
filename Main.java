import java.util.Random;
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        int[] mergeTest = createArray();
        int[] insertionTest = cloneArray(mergeTest);
        int[] hybridMergeTest = cloneArray(mergeTest);

        long startTime = System.currentTimeMillis();
        mergeSort(mergeTest, 0, mergeTest.length - 1);
        long endTime = System.currentTimeMillis();
        System.out.println("Merge Sort time in ms: " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        insertionSort(insertionTest);
        endTime = System.currentTimeMillis();
        System.out.println("Insertion Sort time in ms: " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        mergeSort(hybridMergeTest, 0, mergeTest.length - 1, 100);
        endTime = System.currentTimeMillis();
        System.out.println("Hybrid Merge Sort time in ms: " + (endTime - startTime));

    }
    public static void mergeSort(int[] arr, int first, int last){
        if(first < last){
            int mid = (first + last) / 2;
            mergeSort(arr, first, mid);
            mergeSort(arr, mid + 1, last);
            merge(arr, first, mid, last);
        }
    }
    // Hybrid
    public static void mergeSort(int[] arr, int first, int last, int THRESHOLD){
        if(first < last){
            if(last - first < THRESHOLD){
                insertionSort(arr, first, last);
            } else{
                int mid = (first + last) / 2;
                mergeSort(arr, first, mid);
                mergeSort(arr, mid + 1, last);
                merge(arr, first, mid, last);
            }

        }
    }
    public static void merge(int[] arr, int left, int mid, int right){
        int leftSize = (mid - left) + 1;
        int rightSize = right - mid;
        int[] leftArr = new int[leftSize];
        int[] rightArr = new int[rightSize];

        for(int i = 0; i < leftSize; i++) leftArr[i] = arr[left + i];
        for(int j = 0; j < rightSize; j++) rightArr[j] = arr[mid + j + 1];

        int i = 0, j = 0, k = left;

        while(i < leftSize && j < rightSize){
            if(leftArr[i] <= rightArr[j]){
                arr[k] = leftArr[i];
                i++;

            }
            else {

                arr[k] = rightArr[j];
                j++;

            }

            k++;
        }
        // copy the elements of the array that hasn't ended yet
        while(i < leftSize){
            arr[k] = leftArr[i];
            i++;
            k++;
        }
        while(j < rightSize){
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }

    public static int[] createArray(){
        Random random = new Random();
        // Create an array of random size between 50 and 99

        int size = random.nextInt(20) + 50000;
        int[] arr = new int[size];
        for(int i = 0; i < size; i++){
            arr[i] = random.nextInt(100);
        }
        return arr;
    }

    public static int[] cloneArray(int[] source){
        int[] copy = new int[source.length];
        for(int i = 0; i < source.length; i++){
            copy[i] = source[i];
        }
        return copy;
    }
    public static void insertionSort(int[] arr){
        insertionSort(arr, 0, arr.length - 1);
    }
    private static void insertionSort(int[] arr, int low, int high){
        for(int i = low + 1; i < high; i++){
            int key = arr[i];
            int j = i;
            while(j > 0 && arr[j-1] > key){
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = key;
        }
    }

}