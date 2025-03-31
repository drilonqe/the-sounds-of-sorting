package edu.grinnell.csc207.soundsofsorting;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;  
import javax.swing.JPanel;

/**
 * A drawing panel for visualizing the contents of a @NoteIndices object.
 */
public class ArrayPanel extends JPanel {
    @SuppressWarnings("unused")
    private NoteIndices notes;
   
    /**
     * Create a new <code>ArrayPanel</code> with the given notes and dimensions.
     * @param notes the note indices 
     * @param width the width of the panel
     * @param height the height of the panel
     * citation: classmate Fui advised me to use g.SetColor() to change the color
     */
    public ArrayPanel(NoteIndices notes, int width, int height) {
        this.notes = notes;
        this.setPreferredSize(new Dimension(width, height));
    }

    /*
     * Render each element of the indices array, and makes colored bars based on height of bar
     * @param g 
     * citation : https://docs.oracle.com/en/java/javase/17/docs/api/java.desktop/java/awt/Component.html
     */
    @Override
    public void paintComponent(Graphics g) {
        Integer[] indices = notes.getNotes();
        int width = getWidth(); // screen width
        int height = getHeight(); // screen height
        int barWidth = width / indices.length;
        for (int i = 0; i < indices.length; i++){
            int barHeight = (int)(1.0 * indices[i] / indices.length * height);
            /* my formula for gradient. I tried a couple of values but this one looked
            the best. */
            int blue = (255 * indices[i]) / indices.length;  // Taller bars are more blue
            int green = (int) (255 - (blue * 0.5));          // Taller bars are less green
            
            g.setColor(new Color(0, green, blue));
            g.fillRect(i * barWidth, height - barHeight, barWidth, barHeight);
        }

    }
}