import java.util.Arrays;

public class quickSort {
    public static void main(String[] args) {
            int[] arr = {4, 7, 100, 21, -3};
            QuickSort(arr, 0, arr.length - 1);
            System.out.println(Arrays.toString(arr));
    }

    public static void QuickSort(int[] arr, int start, int end) {
        int partition = partition(arr, start, end);

        if(partition - 1 > start){
            QuickSort(arr, start, partition - 1);
        }
        if(partition + 1 < end){
            QuickSort(arr, partition + 1, end);
        }
    }

    public static int partition(int[] arr, int start, int end){
        int pivot = arr[end];

        for(int i = start; i < end; i++){
            if(arr[i] < pivot){
                int temp = arr[start];
                arr[start] = arr[i];
                arr[i] = temp;
                start++;
            }
        }
        int temp = arr[start];
        arr[start] = pivot;
        arr[end] = temp;

        return start;
    }


}
