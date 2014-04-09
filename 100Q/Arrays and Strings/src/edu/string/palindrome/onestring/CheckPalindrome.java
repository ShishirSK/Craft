package edu.string.palindrome.onestring;

/**
 * @author Shishir Kinkar
 * 
 */
public class CheckPalindrome {

	public static void main(String[] args) {

		String inputString = null;
		CheckPalindrome checkString = new CheckPalindrome();
		boolean isPal = checkString.isPalindrome(inputString);

		if (isPal) {
			System.out.println("Yay");
		} else {
			System.out.println("Nope");
		}
	}

	/**
	 * @param ipString
	 *            - input string to check
	 * @return boolean
	 */
	public boolean isPalindrome(String ipString) {

			StringBuilder str = new StringBuilder();
			char c;
			// Construct lowercase string with only alphanumeric chars
			for (int i = 0; i < ipString.length(); i++) {
				c = ipString.charAt(i);
				if (Character.isLetterOrDigit(c)) {
					if (Character.isUpperCase(c))
						c = Character.toLowerCase(c);
					str.append(c);
				}
			}
			ipString = str.toString();

		// Compare the characters in forward and reverse order
		int j = 0, k = ipString.length() - 1;
		while (j <= k) {
			if (ipString.charAt(j++) != (ipString.charAt(k--))) {
				return false;
			}
		}
		return true;
	}

}
