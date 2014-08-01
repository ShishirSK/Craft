package edu.problems.numerical.readout;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReadoutNumberTest {

	ReadoutNumber num = new ReadoutNumber();
	
	@Test
	public void test() {
		assertEquals(num.countAndSay(1),"11");
	}

	@Test
	public void test2() {
		assertEquals(num.countAndSay(11),"21");
	}
	
	@Test
	public void test3() {
		assertEquals(num.countAndSay(111),"31");
	}
	
	@Test
	public void test4() {
		assertEquals(num.countAndSay(1111),"41");
	}
	
	@Test
	public void test5() {
		assertEquals(num.countAndSay(21),"1211");
	}
}
