package edu.problems.numerical.roman;

import static org.junit.Assert.*;

import org.junit.Test;

public class IntToRomanTest {

	IntToRoman anInt = new IntToRoman();
	@Test
	public void testTheFirsts() {
		assertEquals(anInt.intToRoman(1), "I");
		assertEquals(anInt.intToRoman(2), "II");
		assertEquals(anInt.intToRoman(3), "III");
		assertEquals(anInt.intToRoman(4), "IV");
		assertEquals(anInt.intToRoman(5), "V");
		assertEquals(anInt.intToRoman(6), "VI");
		assertEquals(anInt.intToRoman(7), "VII");
		assertEquals(anInt.intToRoman(8), "VIII");
		assertEquals(anInt.intToRoman(9), "IX");
		assertEquals(anInt.intToRoman(10), "X");
	}

	@Test
	public void testTheTeens(){
		assertEquals(anInt.intToRoman(11), "XI");
		assertEquals(anInt.intToRoman(12), "XII");
		assertEquals(anInt.intToRoman(13), "XIII");
		assertEquals(anInt.intToRoman(14), "XIV");
		assertEquals(anInt.intToRoman(15), "XV");
		assertEquals(anInt.intToRoman(16), "XVI");
		assertEquals(anInt.intToRoman(17), "XVII");
		assertEquals(anInt.intToRoman(18), "XVIII");
		assertEquals(anInt.intToRoman(19), "XIX");
		assertEquals(anInt.intToRoman(20), "XX");
	}
	
	@Test
	public void testTheTens(){
		assertEquals(anInt.intToRoman(10), "X");
		assertEquals(anInt.intToRoman(20), "XX");
		assertEquals(anInt.intToRoman(30), "XXX");
		assertEquals(anInt.intToRoman(40), "XL");
		assertEquals(anInt.intToRoman(50), "L");
		assertEquals(anInt.intToRoman(60), "LX");
		assertEquals(anInt.intToRoman(70), "LXX");
		assertEquals(anInt.intToRoman(80), "LXXX");
		assertEquals(anInt.intToRoman(90), "XC");
		assertEquals(anInt.intToRoman(100), "C");
	}
}
