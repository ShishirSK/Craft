package edu.problems.recursive.combinations;

import java.util.List;

import org.junit.Test;

public class CombinationSumTest {

	CombinationSum anInstance = new CombinationSum();

	@Test
	public void test() {
		int[] candidates = { 2, 3, 6, 7 };
		int target = 7;
		List<List<Integer>> list = anInstance.combinationSum(candidates, target);
		
		System.out.println(list);
	}
}
