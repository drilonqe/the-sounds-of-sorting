# CSC 207: The Sounds of Sorting

Author: Drilon Qerimi

## CHANGELOG
Grader comments:

You are on the right track! Your project does seem to run the sorting algorithms. However the animation is not present. In addition, when shuffling the bars through the Make Scale button, the images seem to stack instead of generate a new one each time.

For an E make sure you cover the requirements on the grading rubric above as well as:
- Run mvn checkstyle:check to get a list of all style violations. Aim for less than 3 for an E.
- Highlight the bar that is currently being swapped throughout the sorting algorithm.

CHANGES MADE
* Fixed images being stacked instead of generating new one each time.
* Fixed shuffling the bars with animation and highlighting the right bar
* Fixed all the style issues occuring in the first submission.
* Revamped mergeSort as per Prof. Osera's comments in Office Hours
* Fixed issues with CopyEvent.java


### New resources used:
* for super.paintcomponent, https://coderanch.com/t/722992/java/PaintComponent-method-added-JPanel-called
* Prof. Osera gave me a layout of what my Merge Sort should look like and adviced me to do it with a
scratch array.

## Resources

*   _(TODO: list your resources here!)_
* I used Java Version 23.0.2
* I used Visual Studio Code as an IDE
* I used the pages made by prof. Osera as reference
source: https://osera.cs.grinnell.edu/ttap/data-structures-labs/ 
source: https://osera.cs.grinnell.edu/ttap/data-structures
* https://docs.oracle.com/en/java/javase/23/docs/api/index.html referenced Graphics and Color.
* Forked repository from prof.Osera: https://github.com/psosera/the-sounds-of-sorting.git.
* For merge sort I based my code of of this:
https://www.geeksforgeeks.org/java-program-for-merge-sort/
* For quick sort I based my code of of this:
https://www.geeksforgeeks.org/java-program-for-quicksort/
* I found gnome sort in this wikipedia page:
https://en.wikipedia.org/wiki/Sorting_algorithm
* I implemented gnome sort based on this:
https://dickgrune.com/Programs/gnomesort.html -Dick Grune,
* Classmate Fui helped me in the file arrayPanel.java to figure out bar height and how to
set color to different, as well as for the use of fillRect.
* Classmate Fui advised me to clone notes and get string from sorts for ControlPanel.java
* For Sorts.java, I worked with classmate Nahom through merge sort in the lab before for this class.
* Used source: https://docs.oracle.com/en/java/javase/17/docs/api/java.desktop/java/awt/Component.html for
getHeight() and getWidth().
