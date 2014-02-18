/*
 * Implmentation of Various Sorts - A single interface to take several numbers and sort them 
 * as per the selected sorting algorithm.
 * @author  - Shishir Kinkar
 * @version - 1.0 Initial program + Insertion sort
 *			- 1.1 Selection sort
 */


import java.io.Console;
import java.util.Arrays;
import java.io.IOException;

public class Sorts{
	
	public static void main(String[] args) throws IOException {

		Sorts currentSet = new Sorts();
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
        	case "1": sortedNumbers = currentSet.insertionSort(numbers);
        			break;
        	case "2": sortedNumbers = currentSet.selectionSort(numbers);
        			break;
        	default: System.out.println("Invalid option");
        			break;
        }

        System.out.println("Sorted numbers are: "); 
        for (int k = 0; k < arrayLength; k++){
        	System.out.print(sortedNumbers[k] + " ");
        }
		System.out.println();
	}

/*
 * Implmentation of Insertion Sort
 * @param  - interger array
 * @return - integer array
 */

	int[] insertionSort(int[] numbersToSort){

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
		
		return numbersToSort;
	}


/*
 * Implmentation of Selection Sort
 * @param  - interger array
 * @return - integer array
 */

	int[] selectionSort(int[] numbersToSort){

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
		return numbersToSort;
	}
}