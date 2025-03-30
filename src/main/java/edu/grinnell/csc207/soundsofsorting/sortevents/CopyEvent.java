package edu.grinnell.csc207.soundsofsorting.sortevents;

import java.util.ArrayList;
import java.util.List;

/**
 * A <code>CopyEvent</code> logs a copy of a value into an index of the array.
 */
public class CopyEvent<T> implements SortEvent<T> {
private int dest; 
private int src;

public CopyEvent(int dest, int src) {
    this.dest = dest;
    this.src = src;
   
}
 public void apply(T[] arr) {
    arr[dest] = arr[src]; // copy value at the index of destination
    }

    public List<Integer> getAffectedIndices() {
        List<Integer> index = new ArrayList<>();
        index.add(dest); // only index of destination is affected
        return index;
    }

    public boolean isEmphasized() {
        return true; 
    }
}
