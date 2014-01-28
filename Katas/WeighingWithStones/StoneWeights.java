/**
 * 
 * author Shishir Kinkar
 * version 1.0 - Brute force solution to Weighing the Stones kata
 *
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
 *	return int[] An array of integers if combination found
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

			//All single stones
			weights.add(wts[0]);
			weights.add(wts[1]);
			weights.add(wts[2]);
			weights.add(wts[3]);

			//Stone 1 and 2 
			weights.add(wts[0] + wts[1]);
			weights.add(wts[0] - wts[1]);
			weights.add(wts[1] - wts[0]);

			//Stone 1 and 3 
			weights.add(wts[0] + wts[2]);
			weights.add(wts[0] - wts[2]);
			weights.add(wts[2] - wts[0]);

			//Stone 1 and 4 
			weights.add(wts[0] + wts[3]);
			weights.add(wts[0] - wts[3]);
			weights.add(wts[3] - wts[0]);

			//Stone 2 and 3 
			weights.add(wts[1] + wts[2]);
			weights.add(wts[1] - wts[2]);
			weights.add(wts[2] - wts[1]); 

			//Stone 2 and 4 
			weights.add(wts[1] + wts[3]);
			weights.add(wts[1] - wts[3]);
			weights.add(wts[3] - wts[1]); 

			//Stone 3 and 4 
			weights.add(wts[2] + wts[3]);
			weights.add(wts[2] - wts[3]);
			weights.add(wts[3] - wts[2]); 

			//Stones 1, 2 and 3
			weights.add(wts[0] + wts[1] + wts[2]);
			weights.add(wts[0] + wts[1] - wts[2]);
			weights.add(wts[0] - wts[1] + wts[2]);
			weights.add(wts[0] - wts[1] - wts[2]);
			weights.add(wts[1] + wts[2] - wts[0]);
			weights.add(wts[1] - wts[2] - wts[0]);
			weights.add(wts[2] - wts[0] - wts[1]);

			//Stones 1, 2 and 4
			weights.add(wts[0] + wts[1] + wts[3]);
			weights.add(wts[0] + wts[1] - wts[3]);
			weights.add(wts[0] - wts[1] + wts[3]);
			weights.add(wts[0] - wts[1] - wts[3]);
			weights.add(wts[1] + wts[3] - wts[0]);
			weights.add(wts[1] - wts[3] - wts[0]);
			weights.add(wts[3] - wts[0] - wts[1]);

			//Stones 1, 2 and 3
			weights.add(wts[0] + wts[2] + wts[3]);
			weights.add(wts[0] + wts[2] - wts[3]);
			weights.add(wts[0] - wts[2] + wts[3]);
			weights.add(wts[0] - wts[2] - wts[3]);
			weights.add(wts[2] + wts[3] - wts[0]);
			weights.add(wts[2] - wts[3] - wts[0]);
			weights.add(wts[3] - wts[0] - wts[2]);

			//Stones 2, 3 and 4
			weights.add(wts[1] + wts[2] + wts[3]);
			weights.add(wts[1] + wts[2] - wts[3]);
			weights.add(wts[1] - wts[2] + wts[3]);
			weights.add(wts[1] - wts[2] - wts[3]);
			weights.add(wts[2] + wts[3] - wts[1]);
			weights.add(wts[2] - wts[3] - wts[1]);
			weights.add(wts[3] - wts[1] - wts[2]);

			//All stones
			weights.add(wts[0] + wts[1] + wts[2] + wts[3]);
			weights.add(wts[0] + wts[1] + wts[2] - wts[3]);
			weights.add(wts[0] + wts[1] - wts[2] + wts[3]);
			weights.add(wts[0] - wts[1] + wts[2] + wts[3]);
			weights.add(wts[0] + wts[1] - wts[2] - wts[3]);
			weights.add(wts[0] - wts[1] + wts[2] - wts[3]);
			weights.add(wts[0] - wts[1] - wts[2] + wts[3]);
			weights.add(wts[0] - wts[1] - wts[2] - wts[3]);
			weights.add(wts[1] + wts[2] + wts[3] - wts[0]);
			weights.add(wts[1] + wts[2] - wts[0] - wts[3]);
			weights.add(wts[1] + wts[3] - wts[0] - wts[2]);
			weights.add(wts[2] + wts[3] - wts[0] - wts[1]);
			weights.add(wts[1] - wts[2] - wts[3] - wts[0]);
			weights.add(wts[2] - wts[0] - wts[1] - wts[3]);
			weights.add(wts[3] - wts[0] - wts[1] - wts[2]);
	

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