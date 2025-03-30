package edu.grinnell.csc207.soundsofsorting.sortevents;

import java.util.ArrayList;
import java.util.List;

/**
 * A <code>SwapEvent</code> logs a swap between two indices of the array.
 */
public class SwapEvent<T> {
    private int id1; // first index
    private int id2; // second index

    public SwapEvent(int id1, int id2) {
        this.id1 = id1;
        this.id2 = id2;
    }

    public void apply(T[] arr) {
        T tmp = arr[id1];
        arr[id1] = arr[id2];
        arr[id1] = tmp;
    }

    public List<Integer> getAffectedIndices() {
        List<Integer> index = new ArrayList<>();
        index.add(id1);
        index.add(id2);
        return index;
    }

    public boolean isEmphasized() {
        return true;
    }

}
