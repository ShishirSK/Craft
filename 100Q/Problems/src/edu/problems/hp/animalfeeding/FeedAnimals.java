package edu.problems.hp.animalfeeding;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Shishir Kinkar
 * 
 */
public class FeedAnimals {

	private static List<Animal> animals = new ArrayList<Animal>();
	private static List<String> animalType = new ArrayList<String>();
	private static List<Integer> quantity = new ArrayList<Integer>();
	private static List<String> foodType = new ArrayList<String>();
	private static int foodQuantity = 0;

	public static void main(String[] args) throws Exception {

		options();
	}

	/**
	 * Method to take user input for desired action
	 */
	public static void options() throws Exception {

		int userChoice = 0;
		System.out.println("Choose option:");
		System.out.println("1. Enter Animal and Food quantity");
		System.out.println("2. Start Feeding");

		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		try {
			userChoice = Integer.parseInt(reader.readLine());
			switch (userChoice) {
			case 1:
				getAnimalAndFoodAndQuantity();
				break;
			case 2:
				feedAnimalsNow();
				break;
			}
		} catch (Exception e) {
			System.out.println("Errored! " + e);
			throw e;
		}

	}

	/**
	 * Method to get the Animal and food quantity to feed that animal
	 */
	public static void getAnimalAndFoodAndQuantity() {

		String userInput = null;
		System.out.println("Enter Animal and Food quantity:");

		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		try {
			userInput = reader.readLine();
			String[] animalFood = userInput.split(" ");
			getAnimal(animalFood);
			options();
		} catch (Exception e) {
			System.out.println("Errored! " + e.getMessage());
		}

	}

	/**
	 * Method to get the information about entered animal
	 * 
	 * @param animalAndFoodVal
	 */
	public static void getAnimal(String[] animalAndFoodVal) {

		switch (animalAndFoodVal[0]) {
		case "Rabbit":
			animals.add(new Rabbit());
			updateAnimalLists(animalAndFoodVal);
			break;
		case "Lion":
			animals.add((new Lion()));
			updateAnimalLists(animalAndFoodVal);
			break;
		case "Penguin":
			animals.add(new Penguin());
			updateAnimalLists(animalAndFoodVal);
			break;
		}
		return;
	}

	/**
	 * Method to update the lists of info about the animals
	 * 
	 * @param animalAndFood
	 */
	public static void updateAnimalLists(String[] animalAndFood) {

		int foodQty = 0;
		Animal currentAnimal;
		animalType.add(animalAndFood[0]);
		foodQty = Integer.parseInt(animalAndFood[1]);
		quantity.add(foodQty);
		currentAnimal = animals.get(animals.size() - 1);
		foodType.add(currentAnimal.getEats());
		foodQuantity += foodQty;

	}

	/**
	 * Method to start feeding the animals
	 */
	public static void feedAnimalsNow() {

		int foodVal = 0;
		String animalVal = null;
		for (int i = 0; i < animalType.size(); i++) {
			animalVal = animalType.get(i);
			foodVal = quantity.get(i);

			if (foodVal > 0) {
				feedOne(i, foodVal, animalVal);
				foodQuantity--;
			}
			if (foodQuantity > 0 && i == (animalType.size() - 1)) {
				i = -1;
			} else if (foodQuantity <= 0) {
				break;
			}
		}
	}

	/**
	 * Method to feed each animal once.
	 * 
	 * @param index
	 * @param currentFoodVal
	 * @param currentAnimalType
	 */
	private static void feedOne(int index, int currentFoodVal,
			String currentAnimalType) {

		String currentFoodType = null;
		currentFoodType = foodType.get(index);
		if (currentFoodVal > 0) {
			if (currentFoodType == "meat")
				System.out.println("Fed " + currentAnimalType + " some "
						+ currentFoodType);
			else
				System.out.println("Fed " + currentAnimalType + " a "
						+ currentFoodType);
		}
		currentFoodVal--;
		if (currentFoodVal == 0)
			System.out.println(currentAnimalType + " is full!");
		quantity.set(index, currentFoodVal);

	}

}
