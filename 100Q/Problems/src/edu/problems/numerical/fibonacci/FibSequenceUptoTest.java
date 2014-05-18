package edu.problems.numerical.fibonacci;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class FibSequenceUptoTest {

	FibSequenceUpto seq = new FibSequenceUpto();
	List<Integer> testList = new ArrayList<Integer>();

	@Before
	public void setList() {
		testList.add(0);
		testList.add(1);
		testList.add(1);
		testList.add(2);
		testList.add(3);
		testList.add(5);
		testList.add(8);
		testList.add(13);
	}

	@Test
	public void testUpto15() {
		assertEquals(seq.FibSeq(15), testList);
	}

	@Test
	public void testUpto6() {
		testList.remove(7);
		testList.remove(6);
		assertEquals(seq.FibSeq(6), testList);
	}
}
