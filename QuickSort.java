public class QuickSort implements Sort{
    public QuickSort(int[] array){
        QuickSortAlgo(array, 0, array.length - 1);
    }
    private static void QuickSortAlgo(int[] array, int first, int last){
        if(last <= first){
            return;
        }
        int pivotIndex = partition(array, first, last);
        QuickSortAlgo(array, first, pivotIndex - 1);
        QuickSortAlgo(array, pivotIndex + 1, last);
    }

    private static int partition(int[] array, int first, int last){
        int pivotIndex = Utilities.getRandom(first, last);
        int pivot = array[pivotIndex];

        Utilities.swap(array, pivotIndex, last);

        int i = first - 1;
        for(int j = first ; j < last; j++){
            if (array[j] < pivot) {
                i++;
                Utilities.swap(array, i, j);
            }
        }

        Utilities.swap(array, i + 1, last);
        return i + 1;
    }
}
