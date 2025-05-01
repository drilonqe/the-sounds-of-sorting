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

    /**
     * Constructor for compare event.
     * 
     * @param id1 first index to compare
     * @param id2 second index to compare
     */
    public CompareEvent(int id1, int id2) {
        this.id1 = id1;
        this.id2 = id2;
    }

    /**
     * Comparing does not do anything to the array
     * so no apply is needed
     */
    public void apply(T[] arr) {

    }

    /**
     * Returns a list of two indices that are being compared.
     */
    public List<Integer> getAffectedIndices() {
        List<Integer> index = new ArrayList<>();
        index.add(id1);
        index.add(id2);
        return index;
    }

    /**
     * Not emphasized so no need to be hihglighted.
     */
    public boolean isEmphasized() {
        return false;
    }

}
