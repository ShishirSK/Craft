package edu.string.conversion;

import static org.junit.Assert.*;

import org.junit.Test;

public class ZigZagConversionTest {

	ZigZagConversion anInstance = new ZigZagConversion();
	
	@Test
	public void test() {
		assertEquals(anInstance.convert("PAYPALISHIRING", 3), "PAHNAPLSIIGYIR");
	}

	@Test
	public void test2() {
		assertEquals(anInstance.convert("A", 2), "A");
	}
	
	@Test
	public void test3() {
		assertEquals(anInstance.convert("ABCD", 2), "ACBD");
	}
	
	@Test
	public void test4() {
		assertEquals(anInstance.convert("ABC", 2), "ACB");
	}
}
