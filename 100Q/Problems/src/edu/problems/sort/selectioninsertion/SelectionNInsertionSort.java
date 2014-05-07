package edu.problems.sort.selectioninsertion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Implementation of Selection and Insertion Sorts - A single program to sort
 * input as per the selected sorting algorithm.
 * 
 * @author Shishir Kinkar
 * 
 */
public class SelectionNInsertionSort {

	public static void main(String[] args) throws IOException {

		SelectionNInsertionSort currentSet = new SelectionNInsertionSort();
		currentSet.menu();

	}

	/*
	 * Method to display the menu
	 * 
	 * @param - none
	 * 
	 * @return - void
	 */

	void menu() throws NumberFormatException, IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		System.out.print("Enter the size of the number set: ");
		int nums = Integer.parseInt(reader.readLine());

		int[] numbers = new int[nums];

		for (int i = 1; i <= nums; i++) {
			System.out.print("Enter number " + i + ": ");
			numbers[i - 1] = Integer.parseInt(reader.readLine());
			System.out.println();
		}

		System.out.println("Sorting options are:");
		System.out.println("1. Insertion sort");
		System.out.println("2. Selection sort");
		System.out.print("Choose the sort to implement: ");
		int choice = Integer.parseInt(reader.readLine());

		switch (choice) {
		case 1:
			insertionSort(numbers);
			break;
		case 2:
			selectionSort(numbers);
			break;
		default:
			System.out.println("Invalid option");
			break;
		}
	}

	/*
	 * Implementation of Insertion Sort
	 * 
	 * @param - interger array
	 * 
	 * @return - void
	 */

	void insertionSort(int[] numbersToSort) {

		for (int i = 1; i < numbersToSort.length; i++) {

			int key = numbersToSort[i];
			int j = i - 1;

			while (j >= 0) {

				if (numbersToSort[j] > key) {
					numbersToSort[j + 1] = numbersToSort[j];
				} else {
					break;
				}
				j--;
			}
			numbersToSort[j + 1] = key;

		}
		showResult(numbersToSort);
	}

	/*
	 * Implementation of Selection Sort
	 * 
	 * @param - interger array
	 * 
	 * @return - void
	 */

	void selectionSort(int[] numbersToSort) {

		int swapInt = 0;
		for (int i = 0; i < numbersToSort.length; i++) {

			for (int j = i + 1; j < numbersToSort.length; j++) {

				if (numbersToSort[j] < numbersToSort[i]) {
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
	 * 
	 * @param - interger array
	 * 
	 * @return - void
	 */

	void showResult(int[] sortedNumbers) {

		System.out.println("Sorted numbers are: ");
		for (int k = 0; k < sortedNumbers.length; k++) {
			System.out.print(sortedNumbers[k] + " ");
		}
		System.out.println();

	}
}