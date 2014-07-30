package edu.string.interleave;

/**
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * #LeetCode
 * 
 * @author Shishir Kinkar
 * 
 */
public class InterleavingStrings {
	public boolean isInterleave(String s1, String s2, String s3) {

		if (s1 == null || s1 == "") {
			if (s2.equals(s3))
				return true;
			else
				return false;
		} else if (s2 == null || s2 == "") {
			if (s1.equals(s3))
				return true;
			else
				return false;
		}

		// Make sure lenght is as needed.
		if (s3.length() != s1.length() + s2.length())
			return false;

		char[] str1 = s1.toCharArray();
		char[] str2 = s2.toCharArray();
		char[] str3 = s3.toCharArray();

		int i = 0, j = 0, k = 0;
		while (k < str3.length) {
			// Valid length + match? Increment
			if (i < str1.length && k < str3.length && str3[k] == str1[i]) {
				k++;
				i++;
				// If further characters match, keep incrementing
				while (i < str1.length && k < str3.length && str3[k] == str1[i]) {
					k++;
					i++;
				}
				// Valid length + match? Increment
			} else if (j < str2.length && k < str3.length && str3[k] == str2[j]) {
				k++;
				j++;
				// If further characters match, keep incrementing
				while (j < str2.length && k < str3.length && str3[k] == str2[j]) {
					k++;
					j++;
				}
				// No match? Return false
			} else {
				return false;
			}
		}

		return true;
	}
}