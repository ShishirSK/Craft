/**
 * 
 * @author Shishir Kinkar
 * @version 1.0 - Brute force solution to Weighing the Stones kata
 *			2.0 - Loops to repalce brute force to find the correct combination
 */


import java.util.*;

public class StoneWeights{
		
	public static void main(String[] args){

		int[] theFourStones;	
		
		StoneWeights stones = new StoneWeights();
		theFourStones = stones.getCombinations();

		if (theFourStones != null)
			System.out.println("The stones weigh: " + theFourStones[0] + ", " + theFourStones[1] + ", " 
													+ theFourStones[2] + ", " + theFourStones[3]);
		else
			System.out.println("No such combination found!");
		
	}

	
/**	
 *	This method finds all the possible combinations and returns the result or null
 *	@return int[] An array of integers if combination found
 *			null otherwise
 */
	int[] getCombinations(){

		boolean checkResult = false; 

		for(int stoneOne = 1; stoneOne < 40; stoneOne++){

			for(int stoneTwo = 1; stoneTwo < 40; stoneTwo++){

				for(int stoneThree = 1; stoneThree < 40; stoneThree++){

					for(int stoneFour = 1; stoneFour < 40; stoneFour++){

						if(stoneOne + stoneTwo + stoneThree + stoneFour == 40){

							int[] eachCombo = new int[4];

							eachCombo[0] = stoneOne;
							eachCombo[1] = stoneTwo;
							eachCombo[2] = stoneThree;
							eachCombo[3] = stoneFour;
							
							checkResult = checkCombination(eachCombo);
							if(checkResult == true){
								return eachCombo;						
							}

						}

					}
				}
			}
		}
		return null;

	}


/**	
 *	This method finds all the possible combinations and returns the result or null
 *	@return True if a valid combination is found 
 *			False otherwise
 */

			boolean checkCombination(int[] combo){

			int[] wts = combo;
			boolean weightsFound = true;
			List<Integer> weights = new ArrayList<Integer>();

			for (int m1 = -1; m1 <= 1 ; m1++) {
				
				for (int m2 = -1; m2 <= 1 ; m2++) {

					for (int m3 = -1; m3 <= 1 ; m3++) {

						for (int m4 = -1; m4 <= 1 ; m4++){

							weights.add(m1 * wts[0] + m2 * wts[1] + m3 * wts[2] + m4 * wts[3]);

						} 

					}

				}
				
			}
	

// Check if all the necessary weights are found
			for(int checkWeight = 1; checkWeight < 40; checkWeight++){
				if(!weights.contains(checkWeight))
					weightsFound = false;
			}	

			if (weightsFound == true)
				return true;		
			else
				return false;
		}


}