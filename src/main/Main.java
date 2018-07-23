package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import View.Print;
import Controller.Algorithms;

/**
 * Main entry point of the program
 */
public class Main {

    /**
     * Main method
     * @param args not used
     */
    public static void main(String args[])
    {
        //Declarations
    	int selection = 0;
    	int length = 0;
        int[] list;
    	long startTime;
    	long endTime;

		Scanner input = new Scanner(System.in);
    	
    	// Prompt user for desired sorting method
    	System.out.println("Please select a sorting algorithm to use.");
    	System.out.println("Press 1 for Mergesort:");
    	System.out.println("Press 2 for Quicksort:");
    	System.out.println("Press 3 for Timsort:");
    	System.out.println("Press 4 for Bubblesort:");
    	System.out.println("Compare all of the above sorts");
    	
    	try
        {
    		selection = input.nextInt();
        }
        catch(Exception e)
        {
            System.out.println("only numbers are allowed");
            System.exit(0);
        }
    	
    	
    	// Prompt user for desired length of values to sort
    	System.out.println("How many values to do want to sort (2-1,000)?");
    	
    	try
        {
    		length = input.nextInt();
        }
        catch(Exception e)
        {
            System.out.println("only numbers are allowed");
            System.exit(0);
        }

    	// Error checking
    	if (length < 1 || length > 1000) {
    		System.out.println("Number of values must be between 2 and 1,000.");
    		System.exit(0);
    	}

    	list = new int[length];
    	
    	// Generate list of numbers based on user input.
    	for (int i = 0; i < length; i++) {
    		Random rand = new Random();
    		int number = rand.nextInt(1000);
            list[i] = number;
    	}
    	
        // Run the desired sorting algorithm
    	switch (selection) {
    		case 1:
    			System.out.println("Given Array");
    			Print.printList(list);
                startTime = System.nanoTime();
                Algorithms.mergeSort(list, 0, list.length-1);
                endTime = System.nanoTime();
                Print.printList(list);
                Print.printTime("MergeSort", endTime, startTime);
                break;
            case 2:
                System.out.println("Given Array");
                Print.printList(list);
                startTime = System.nanoTime();
                Algorithms.quickSort(list, 0, list.length-1);
                endTime = System.nanoTime();
                Print.printList(list);
                Print.printTime("QuickSort", endTime, startTime);
                break;
            case 3:
            	// Uses Collections.sort on array list
                ArrayList<Integer> tim = new ArrayList<>();
                for (int aList : list)
                    tim.add(aList);
                System.out.println("Given Array");
                Print.printList(list);
                startTime = System.nanoTime();
                Collections.sort(tim);
                endTime = System.nanoTime();
                for (int i = 0; i < tim.size(); i++)
                	list[i] = tim.get(i);
                System.out.println("Resulting Array");
                Print.printList(list);
                Print.printTime("TimSort", endTime, startTime);
                break;
            case 4:
                System.out.println("Given Array");
                Print.printList(list);
                startTime = System.nanoTime();
                Algorithms.bubbleSort(list);
                endTime = System.nanoTime();
                Print.printTime("Bubblesort", endTime, startTime);
                System.out.println("Resulting Array");
                Print.printList(list);
                break;

            case 5:
                System.out.println("The resulting times of each algorithm is: ");

            default:
                System.out.println("Invalid sort selection provided.");
                System.exit(0);
                break;
    	}
    }



}
