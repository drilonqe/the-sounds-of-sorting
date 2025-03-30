package edu.grinnell.csc207.soundsofsorting.sortevents;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A <code>CompareEvent</code> logs a comparison a sort makes between two
 * indices in the array.
 */
public class CompareEvent<T> implements SortEvent<T> {
    private int id1;
    private int id2;

    public CompareEvent(int id1, int id2) {
        this.id1 = id1;
        this.id2 = id2;
    }

    public void apply(T[] arr) {

    }

    public List<Integer> getAffectedIndices() {
        List<Integer> index = new ArrayList<>();
        index.add(id1);
        index.add(id2);
        return index;
    }

    public boolean isEmphasized() {
        return false;
    }

}
