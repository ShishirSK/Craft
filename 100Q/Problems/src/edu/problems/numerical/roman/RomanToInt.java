package edu.problems.numerical.roman;

/**
 * Given a roman numeral, convert it to an integer. #LeetCode
 * Legend: 
 * 		M = 1000
 * 		D = 500
 * 		C = 100
 * 		L = 50
 * 		X = 10
 * 		V = 5
 * 		I = 1
 * 
 * @author Shishir Kinkar
 * 
 */
public class RomanToInt {

	public int romanToInt(String s) {

		char[] romanChars = s.toCharArray();
		int number = 0;
		int arraySize = romanChars.length;
		int validSize = arraySize - 1;

		for (int i = 0; i < arraySize; i++) {
			switch (romanChars[i]) {
			case 'M':
				number += 1000;
				break;
			case 'D':
				number += 500;
				break;
			case 'C':
				if (i < validSize && romanChars[i + 1] == 'D') {
					number += 400;
					i++;
				} else if (i < validSize && romanChars[i + 1] == 'M') {
					number += 900;
					i++;
				} else
					number += 100;
				break;
			case 'L':
				number += 50;
				break;
			case 'X':
				if (i < validSize && romanChars[i + 1] == 'L') {
					number += 40;
					i++;
				} else if (i < validSize && romanChars[i + 1] == 'C') {
					number += 90;
					i++;
				} else
					number += 10;
				break;
			case 'V':
				number += 5;
				break;
			case 'I':
				if (i < validSize && romanChars[i + 1] == 'V') {
					number += 4;
					i++;
				} else if (i < validSize && romanChars[i + 1] == 'X') {
					number += 9;
					i++;
				} else
					number += 1;
				break;
			}
		}
		return number;
	}
}