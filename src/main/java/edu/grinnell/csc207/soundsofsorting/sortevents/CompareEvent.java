package edu.grinnell.csc207.soundsofsorting.sortevents;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A <code>CompareEvent</code> logs a comparison a sort makes between two
 * indices in the array.
 */
public class CompareEvent<T> {
    private int i;
    private int j;
    public CompareEvent(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public void apply(T[] arr) {
        
    }

    public List<Integer> getAffectedIndices() {
        List<Integer> index = new ArrayList<>();
        index.add(i);
        index.add(j);
        return index;
    }

    public boolean isEmphasized() {
        return false;
    }
    
}
