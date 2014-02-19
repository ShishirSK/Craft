/*
 * Implmentation of Various Sorts - A single interface to take several numbers and sort them 
 * as per the selected sorting algorithm.
 * @author  - Shishir Kinkar
 * @version - 1.0 Initial program + Insertion sort
 *			- 1.1 Selection sort
 *			- 1.2 Modularize the code
 */


import java.io.Console;
import java.util.Arrays;
import java.io.IOException;

public class Sorts{
	
	public static void main(String[] args) throws IOException {

		Sorts currentSet = new Sorts();
		currentSet.menu();

	}

/*
 * Method to display the menu
 * @param  - none
 * @return - void
 */

 	void menu(){

 		Console c = System.console();

		if (c == null){
            System.err.println("No console.");
            System.exit(1);
        }

// Replace console read by bufferedReader?        
        String nums = c.readLine("Enter the size of the number set: ");
        
        int arrayLength = Integer.parseInt(nums);       
        int[] numbers = new int[arrayLength];
        int[] sortedNumbers = new int[arrayLength];
        
        for (int i = 1; i <= arrayLength; i++) {
        	numbers[i - 1] = Integer.parseInt(c.readLine("Enter number " + i + ": "));
        }        

        System.out.println("Sorting options are:");
        System.out.println("1. Insertion sort");
        System.out.println("2. Selection sort");
        String choice = c.readLine("Choose the sort to implement: ");

        switch (choice){
        	case "1": insertionSort(numbers);
        			break;
        	case "2": selectionSort(numbers);
        			break;
        	default: System.out.println("Invalid option");
        			break;
        }
 	}


/*
 * Implmentation of Insertion Sort
 * @param  - interger array
 * @return - void
 */

	void insertionSort(int[] numbersToSort){

		for (int i = 1; i < numbersToSort.length; i++){

			int key = numbersToSort[i];
			int j   = i - 1;

			while (j >= 0){

				if (numbersToSort[j] > key){
					numbersToSort[j + 1] = numbersToSort[j];
				}
				else{
					break;
				}
				j--;
			}
			numbersToSort[j + 1] = key;

		}
		showResult(numbersToSort);
	}


/*
 * Implmentation of Selection Sort
 * @param  - interger array
 * @return - void
 */

	void selectionSort(int[] numbersToSort){

		int swapInt = 0;
		for (int i = 0; i < numbersToSort.length; i++){

			for (int j = i + 1; j < numbersToSort.length; j++) {

				if (numbersToSort[j] < numbersToSort[i]){
					swapInt = numbersToSort[i];
					numbersToSort[i] = numbersToSort[j];
					numbersToSort[j] = swapInt;
				}
			}
		}
		showResult(numbersToSort);
	}

/*
 * Method to print out the sorted results 
 * @param  - interger array
 * @return - void
 */

	void showResult(int[] sortedNumbers){

		System.out.println("Sorted numbers are: "); 
        for (int k = 0; k < sortedNumbers.length; k++){
        	System.out.print(sortedNumbers[k] + " ");
        }
		System.out.println();

	}


}