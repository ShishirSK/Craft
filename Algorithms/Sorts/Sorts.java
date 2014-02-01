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

        String nums = c.readLine("Enter the size of the number set: ");
        int arrayLength = Integer.parseInt(nums);
        int[] numbers = new int[arrayLength];
        int[] sortedNumbers = new int[arrayLength];
        
        for (int i = 1; i <= arrayLength; i++) {

        	numbers[i - 1] = Integer.parseInt(c.readLine("Enter number " + i + ": "));

        }

        

        System.out.println("Sorting options are:");
        System.out.println("1. Insertion sort");
        String choice = c.readLine("Choose the sort to implement: ");

        switch (choice){
        	case "1": sortedNumbers = currentSet.insertionSort(numbers);
        			break;
        	default: System.out.println("Invalid option");
        			break;
        }

        System.out.println("Sorted numbers are: "); 
        for (int k = 0; k < arrayLength; k++){
        	System.out.println(sortedNumbers[k]);
        }

	}



	int[] insertionSort(int[] numbersToSort){

		
		return numbersToSort;
	}

}