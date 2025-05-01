package edu.grinnell.csc207.soundsofsorting.sortevents;

import java.util.ArrayList;
import java.util.List;

/**
 * A <code>SwapEvent</code> logs a swap between two indices of the array.
 */
public class SwapEvent<T> implements SortEvent<T> {
    private int id1; // first index
    private int id2; // second index

    /**
     * Constructor for swap event
     * 
     * @param id1 first index to swap
     * @param id2 second index to swap
     */
    public SwapEvent(int id1, int id2) {
        this.id1 = id1;
        this.id2 = id2;
    }

    /**
     * Swaps the values at indices id1 and id2.
     * 
     * @param arr the array to modify
     */
    public void apply(T[] arr) {
        T tmp = arr[id1];
        arr[id1] = arr[id2];
        arr[id2] = tmp;
    }

    /**
     * Returns the list of indices affected by this event.
     */
    public List<Integer> getAffectedIndices() {
        List<Integer> index = new ArrayList<>();
        index.add(id1);
        index.add(id2);
        return index;
    }

    /**
     * SwapEvents should be emphasized in the animation
     * so always return true.
     */
    public boolean isEmphasized() {
        return true;
    }

}
