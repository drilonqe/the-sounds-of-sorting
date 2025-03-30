package edu.grinnell.csc207.soundsofsorting;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.function.Consumer;

import org.junit.jupiter.api.Test;

import edu.grinnell.csc207.soundsofsorting.sorts.Sorts;

public class SortsTests {
    /**
     * @param <T> the carrier type of the array
     * @param arr the array to check
     * @return true iff <code>arr</code> is sorted.
     */
    public static <T extends Comparable<? super T>> boolean sorted(T[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].compareTo(arr[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

    public static Integer[] makeTestArray() {
        return new Integer[] {
            3, 7, 9, 1, 2,
            18, 16, 15, 19, 8,
            14, 12, 5, 13, 4,
            6, 0, 17, 11, 10
        };
    }

    public void testSort(Consumer<Integer[]> func) {
        Integer[] arr = makeTestArray();
        func.accept(arr);
        assertTrue(sorted(arr));
    }

    @Test
    public void testBubbleSort() {
        testSort(Sorts::bubbleSort);

        Integer[] arr1 = {1, 2, 3, 4, 5};
        Sorts.bubbleSort(arr1);
        assertTrue(sorted(arr1));

        Integer[] arr2 = {1, 7, 3, 4, 15, 0, 9, 2};
        Sorts.bubbleSort(arr2);
        assertTrue(sorted(arr2));

        Integer[] arr3 = {1, 2, 1, 3, 3, 6, 7, 2, 10};
        Sorts.bubbleSort(arr3);
        assertTrue(sorted(arr3));
    }
    
    @Test
    public void testInsertionSort() {
        testSort(Sorts::insertionSort);

        Integer[] arr1 = {5, 4, 3, 2, 1};
        Sorts.insertionSort(arr1);
        assertTrue(sorted(arr1));

        Integer[] arr2 = {1, 7, 3, 7, 5, 4, 4, 15, 0, 9, 2};
        Sorts.insertionSort(arr2);
        assertTrue(sorted(arr2));

        Integer[] arr3 = {1};
        Sorts.insertionSort(arr3);
        assertTrue(sorted(arr3));
    }
    
    @Test
    public void testSelectionSort() {
        testSort(Sorts::selectionSort);
        Integer[] arr1 = {-1, -2, -3, -4, -5};
        Sorts.selectionSort(arr1);
        assertTrue(sorted(arr1));

        Integer[] arr2 = {1,3,5,4,2};
        Sorts.selectionSort(arr2);
        assertTrue(sorted(arr2));

        Integer[] arr3 = {1, 1,2,2,2};
        Sorts.selectionSort(arr3);
        assertTrue(sorted(arr3));
    }

    @Test
    public void testMergeSort() {
        testSort(Sorts::mergeSort);
        Integer[] arr1 = {7,6,5,-2,-1,-3};
        Sorts.mergeSort(arr1);
        assertTrue(sorted(arr1));

        Integer[] arr2 = {};
        Sorts.mergeSort(arr2);
        assertTrue(sorted(arr2));

        Integer[] arr3 = {9,8,7,6,5,1,2,3,4};
        Sorts.mergeSort(arr3);
        assertTrue(sorted(arr3));
    }
    
    @Test
    public void testQuickSort() {
        testSort(Sorts::quickSort);
        Integer[] arr1 = {1, 2, 3, 4, 5};
        Sorts.quickSort(arr1);
        assertTrue(sorted(arr1));

        Integer[] arr2 = {0,0,0,0};
        Sorts.quickSort(arr2);
        assertTrue(sorted(arr2));

        Integer[] arr3 = {3,3,5,5,6,6,7,8,9,5,4,3,2};
        Sorts.quickSort(arr3);
        assertTrue(sorted(arr3));
    }

    @Test
    public void testgnomeSort() {
        Integer[] arr1 = {1, 2, 3, 4, 5};
        Sorts.gnomeSort(arr1);
        assertTrue(sorted(arr1));

        Integer[] arr2 = {2,5,3,4,7,1};
        Sorts.gnomeSort(arr2);
        assertTrue(sorted(arr2));

        Integer[] arr3 = {3,3,5,5,6,6,7,8,9,5,4,3,2};
        Sorts.gnomeSort(arr3);
        assertTrue(sorted(arr3));
    }

}