package edu.grinnell.csc207.soundsofsorting.sortevents;

import java.util.ArrayList;
import java.util.List;

/**
 * A <code>CopyEvent</code> logs a copy of a value into an index of the array.
 */
public class CopyEvent<T> implements SortEvent<T> {
private int dest; 
private T value;

public CopyEvent(int dest, T value) {
    this.dest = dest;
    this.value = value;
   
}
 public void apply(T[] arr) {
    arr[dest] = value; // copy value at the index of destination
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
