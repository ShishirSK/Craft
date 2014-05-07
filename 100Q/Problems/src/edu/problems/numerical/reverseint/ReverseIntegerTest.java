package edu.problems.numerical.reverseint;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReverseIntegerTest {

	ReverseInteger revInt = new ReverseInteger();
	int returnedNum = 0;
	
	@Test
	public void smallPositiveNumber(){
		returnedNum = revInt.reverse(1);
		assertEquals(returnedNum, 1);
	}
	
	@Test
	public void positiveNumber() {
		returnedNum = revInt.reverse(123);
		assertEquals(returnedNum, 321);
	}

	@Test
	public void largePositiveNumber(){
		returnedNum = revInt.reverse(32123);
		assertEquals(returnedNum, 32123);
	}
	
	@Test
	public void negativeNumber(){
		returnedNum = revInt.reverse(-123);
		assertEquals(returnedNum, -321);
	}
	
	@Test
	public void numberWithMultipleZerosAtTheEnd(){
		returnedNum = revInt.reverse(10000);
		assertEquals(returnedNum, 1);
	}
}
