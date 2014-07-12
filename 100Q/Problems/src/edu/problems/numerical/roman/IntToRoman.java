package edu.problems.numerical.roman;

/**
 * Given an integer, convert it to a roman numeral. Input is guaranteed to be
 * within the range from 1 to 3999. #LeetCode
 * 
 * @author Shishir Kinkar
 * 
 */
public class IntToRoman {

	public enum ROMANS {
		I, II, III, IV, V, VI, VII, VIII, IX, X, XL, L, XC, C, CD, D, CM, M
	}

	public String intToRoman(int num) {

		int divisor = 1000;
		StringBuilder str = new StringBuilder();

		while (divisor > 0) {

			int quo = num / divisor;
			if (quo > 0 && quo > 5) {
				if (quo == 9) { // IMP - as 9 is special case
					str.append(getRoman(9, divisor));
				} else {
					// To get V, L or D
					str.append(getRoman(5, divisor));
					// To get 6s, 7s and 8s
					str.append(getRoman(quo - 5, divisor));
				}
			} else if (quo > 0 && quo <= 5) {
				// For 0 to 4
				str.append(getRoman(quo, divisor));
			}
			// Modify the number and divisor
			num = num - (quo * divisor);
			divisor /= 10;
		}
		return str.toString();
	}

	// Method to get the Roman representation of a number as a string
	private String getRoman(int num, int div) {

		StringBuilder numStr = new StringBuilder();

		switch (num) {
		// Consider special cases of Roman numerals
		// Div is the factor to decide which roman numeral applies
		case 4:
			if (div == 100) {
				numStr.append(ROMANS.CD);
			} else if (div == 10) {
				numStr.append(ROMANS.XL);
			} else if (div == 1) {
				numStr.append(ROMANS.IV);
			}
			break;
		case 9:
			if (div == 100) {
				numStr.append(ROMANS.CM);
			} else if (div == 10) {
				numStr.append(ROMANS.XC);
			} else if (div == 1) {
				numStr.append(ROMANS.IX);
			}
			break;
		case 5:
			if (div == 100) {
				numStr.append(ROMANS.D);
			} else if (div == 10) {
				numStr.append(ROMANS.L);
			} else if (div == 1) {
				numStr.append(ROMANS.V);
			}
			break;
		// For cases of 0,1,2,3,6,7,8
		default:
			for (int j = 0; j < num; j++) {
				if (div == 1000) {
					numStr.append(ROMANS.M);
				} else if (div == 100) {
					numStr.append(ROMANS.C);
				} else if (div == 10) {
					numStr.append(ROMANS.X);
				} else if (div == 1) {
					numStr.append(ROMANS.I);
				}
			}
			break;
		}

		return numStr.toString();
	}

}