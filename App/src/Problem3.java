import java.util.*;

public class Problem3 {

    // Merge Sort
    static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int mid = (l + r) / 2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid + 1, r);
            merge(arr, l, mid, r);
        }
    }

    static void merge(int[] arr, int l, int m, int r) {
        int[] temp = new int[r - l + 1];
        int i = l, j = m + 1, k = 0;

        while (i <= m && j <= r) {
            temp[k++] = (arr[i] <= arr[j]) ? arr[i++] : arr[j++];
        }

        while (i <= m) temp[k++] = arr[i++];
        while (j <= r) temp[k++] = arr[j++];

        for (i = l, k = 0; i <= r; i++, k++) {
            arr[i] = temp[k];
        }
    }

    // Quick Sort (descending)
    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] > pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    static int totalVolume(int[] arr) {
        int sum = 0;
        for (int v : arr) sum += v;
        return sum;
    }

    public static void main(String[] args) {
        int[] trades = {500, 100, 300};

        int[] mergeArr = trades.clone();
        mergeSort(mergeArr, 0, mergeArr.length - 1);
        System.out.println("Merge Sort: " + Arrays.toString(mergeArr));

        int[] quickArr = trades.clone();
        quickSort(quickArr, 0, quickArr.length - 1);
        System.out.println("Quick Sort Desc: " + Arrays.toString(quickArr));

        System.out.println("Total Volume: " + totalVolume(trades));
    }
}
