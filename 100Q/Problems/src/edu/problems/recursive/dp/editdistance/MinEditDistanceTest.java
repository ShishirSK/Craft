package edu.problems.recursive.dp.editdistance;

import static org.junit.Assert.*;

import org.junit.Test;

public class MinEditDistanceTest {

	MinEditDistance anInstance = new MinEditDistance();
	
	@Test
	public void test() {
		String s1 = "INTENTION";
		String s2 = "EXECUTION";
		
		assertEquals(anInstance.minDistance(s1, s2), 5);
	}

}
