package edu.grinnell.csc207.soundsofsorting.sortevents;

import java.util.ArrayList;
import java.util.List;

/**
 * A <code>CopyEvent</code> logs a copy of a value into an index of the array.
 */
public class CopyEvent<T> {
private int dest; 
private T val;

public CopyEvent(int dest, T val) {
    this.dest = dest;
    this.val = val;
}
 public void apply(T[] arr) {
    arr[dest] = val; // copy value at the index of destination
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
