package edu.grinnell.csc207.soundsofsorting;

import java.util.Arrays;
import java.util.Random;

/**
 * A collection of indices into a Scale object.
 * These indices are the subject of the various sorting algorithms
 * in the program.
 */
public class NoteIndices {
    private int[] indices; // array of indices
    private boolean[] hl; // tracks highlighted indices

    /**
     * @param n the size of the scale object that these indices map into
     */
    public NoteIndices(int n) {
        initializeAndShuffle(n);
    }

    /**
     * Reinitializes this collection of indices to map into a new scale object
     * of the given size. The collection is also shuffled to provide an
     * initial starting point for the sorting process.
     * 
     * @param n the size of the scale object that these indices map into
     */
    public void initializeAndShuffle(int n) {
        indices = new int[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        // Shuffle using Fisher-Yates shuffle (From Project 3)
        Random r = new Random();
        for (int i = n - 1; i > 0; i--) {
            int j = r.nextInt(i + 1); // Random index between 0 and i
            // Swap indices[i] and indices[j]
            int temp = indices[i];
            indices[i] = indices[j];
            indices[j] = temp;
        }
        hl = new boolean[n];

    }

    /** @return the indices of this NoteIndices object */
    public Integer[] getNotes() {
        // Convert int[] to Integer[]
        Integer[] itgIndices = new Integer[indices.length];
        for (int i = 0; i < indices.length; i++) {
            itgIndices[i] = indices[i];
        }
        return itgIndices;
    }

    /**
     * Highlights the given index of the note array
     * 
     * @param index the index to highlight
     */
    public void highlightNote(int index) {
        if (index >= 0 && index < hl.length) {
            hl[index] = true;
        }
    }

    /**
     * @param index the index to check
     * @return true if the given index is highlighted
     */
    public boolean isHighlighted(int index) {
        return hl[index];
    }

    /** Clears all highlighted indices from this collection */
    public void clearAllHighlighted() {
         Arrays.fill(hl, false);
    }
}
