package edu.grinnell.csc207.soundsofsorting.sorts;

import java.util.ArrayList;
import java.util.List;

import edu.grinnell.csc207.soundsofsorting.sortevents.CompareEvent;
import edu.grinnell.csc207.soundsofsorting.sortevents.CopyEvent;
import edu.grinnell.csc207.soundsofsorting.sortevents.SortEvent;
import edu.grinnell.csc207.soundsofsorting.sortevents.SwapEvent;

/**
 * A collection of sorting algorithms.
 */
public class Sorts {
    /**
     * Swaps indices <code>i</code> and <code>j</code> of array <code>arr</code>.
     * 
     * @param <T> the carrier type of the array
     * @param arr the array to swap
     * @param i   the first index to swap
     * @param j   the second index to swap
     */
    public static <T> void swap(T[] arr, int i, int j) {
        T tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * Sorts the array according to the bubble sort algorithm:
     * 
     * <pre>
     * [ unprocessed | i largest elements in order ]
     * </pre>
     * 
     * @param <T> the carrier type of the array
     * @param arr the array to sort
     * @return the sort events generated by this sort
     */
    public static <T extends Comparable<? super T>> List<SortEvent<Integer>> bubbleSort(T[] arr) {
        List<SortEvent<Integer>> event = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                // compare event
                event.add(new CompareEvent<Integer>(j, j + 1));

                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    // swap event
                    event.add(new SwapEvent<Integer>(j, j + 1));
                    swap(arr, j, j + 1);
                }
            }
        }
        return event;
    }

    /**
     * Sorts the array according to the selection sort algorithm:
     * 
     * <pre>
     * [ i smallest elements in order | unprocessed ]
     * </pre>
     * 
     * @param <T> the carrier type of the array
     * @param arr the array to sort
     * @return the sort events generated by this sort
     */
    public static <T extends Comparable<? super T>> List<SortEvent<Integer>> selectionSort(
            T[] arr) {
        List<SortEvent<Integer>> event = new ArrayList<>();
        for (int i = 0; i < arr.length - 1; i++) {
            int lowestIdx = i;
            for (int j = i; j < arr.length; j++) {
                // compare event
                event.add(new CompareEvent<Integer>(j, lowestIdx));
                if (arr[j].compareTo(arr[lowestIdx]) < 0) {
                    lowestIdx = j;
                }
            }
            // swap event
            event.add(new SwapEvent<Integer>(i, lowestIdx));
            swap(arr, i, lowestIdx);
        }
        return event;
    }

    /**
     * Sorts the array according to the insertion sort algorithm:
     * 
     * <pre>
     * [ i elements in order | unprocessed ]
     * </pre>
     * 
     * @param <T> the carrier type of the array
     * @param arr the array to sort
     * @return the sort events generated by this sort
     */
    public static <T extends Comparable<? super T>> List<SortEvent<Integer>> insertionSort(
            T[] arr) {
        List<SortEvent<T>> event = new ArrayList<>();
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                // compare event
                event.add(new CompareEvent<Integer>(j, j - 1));
                if (arr[j].compareTo(arr[j - 1]) < 0) {
                    // swap event
                    event.add(new SwapEvent<Integer>(j, j - 1));
                    swap(arr, j, j - 1);
                }
            }
        }
    }

    /**
     * Sorts the array according to the merge sort algorithm.
     * 
     * @param <T> the carrier type of the array
     * @param arr the array to sort
     * @return the sort events generated by this sort
     */
    public static <T extends Comparable<? super T>> List<SortEvent<Integer>> mergeSort(
            T[] arr) {
        List<SortEvent<Integer>> event = new ArrayList<>();
        mergeSort(arr, 0, arr.length - 1, event);
        return event;

    }

    /*
     * Code adapted from https://www.geeksforgeeks.org/java-program-for-merge-sort/
     */
    public static <T extends Comparable<? super T>> void mergeSort(
            T[] arr, int left, int right, List<SortEvent<Integer>> event) {
        if (left < right) {
            int mid = left + (right - left) / 2; // similar to what we did in binary search
            mergeSort(arr, left, mid, event);
            mergeSort(arr, mid + 1, right, event);
            mergeHelper(arr, left, mid, right, event);

        }
    }

    /*
     * Code adapted from https://www.geeksforgeeks.org/java-program-for-merge-sort/
     */
    private static <T extends Comparable<? super T>> void mergeHelper(T[] arr, int left, int right, int mid,
            List<SortEvent<Integer>> event) {
        // Create temporary arrays
        int n1 = mid - left + 1; // Size of left half
        int n2 = right - mid; // Size of right half

        T[] L = (T[]) new Comparable[n1];
        T[] R = (T[]) new Comparable[n2];

        // Copy the data to temporary arrays
        for (int i = 0; i < n1; i++) {
            L[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arr[mid + 1 + j];
        }

        // Merge the temporary arrays
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            // compare event
            event.add(new CompareEvent<Integer>(left + i, mid + 1 + j));
            if (L[i].compareTo(R[j]) <= 0) {
                // copy event
                event.add(new CopyEvent<>(k, left + i));
                arr[k++] = L[i++];
            } else {
                // copy event
                event.add(new CopyEvent<>(k, mid + 1 + j));
                arr[k++] = R[j++];
            }
        }

        while (i < n1) {
            event.add(new CopyEvent<>(k, left + i));
            arr[k++] = L[i++];
        }

        while (j < n2) {
            event.add(new CopyEvent<>(k, mid + 1 + j));
            arr[k++] = R[j++];
        }
    }

    /**
     * Sorts the array according to the quick sort algorithm.
     * 
     * @param <T> the carrier type of the array
     * @param arr the array to sort
     * @return the sort events generated by this sort
     */
    public static <T extends Comparable<? super T>> List<SortEvent<Integer>> quickSort(T[] arr) {
        // TODO: fill me in!
        return null;
    }
}
