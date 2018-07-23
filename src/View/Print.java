package View;

public class Print {
    
    /**
     * printList - displays the given array
     * @param list - The array to be displayed
     */
    public static void printList(int[] list)
    {
        int nl = 20;

        for (int aList : list) {
            if (nl == 0) {
                System.out.println();
                nl = 20;
            }
            System.out.print(aList + ", ");
            nl--;
        }
        System.out.println("\n");
    }
    
    /**
     * Prints the duration of the program run time
     * @param name - Name of the sort being utilized
     * @param end - The time at which the sorting ended
     * @param start - The time at which the sorting began
     */
    public static void printTime(String name, long end, long start)
    {
        System.out.println(name + " algorithm ran for " + (end - start) + " nanoseconds.");
    }

}
