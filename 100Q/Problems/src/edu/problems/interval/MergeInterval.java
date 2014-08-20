package edu.problems.interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 * 
 * For example, Given [1,3],[2,6],[8,10],[15,18], return [1,6],[8,10],[15,18].
 * #LeetCode
 * 
 * @author Shishir Kinkar
 * 
 */
public class MergeInterval {

	public List<Interval> merge(List<Interval> intervals) {

		// Base check
		if (intervals == null || intervals.size() == 0) {
			return intervals;
		}

		List<Interval> result = new ArrayList<Interval>();
		// Sort first using custom comparator
		Collections.sort(intervals, new IntervalComparator());

		// Get the first one
		Interval prev = intervals.get(0);
		// Loop through the rest of the intervals and compare current to the
		// previous one
		for (int i = 1; i < intervals.size(); i++) {
			Interval curr = intervals.get(i);

			// Overlapping condition - Merge
			if (prev.end >= curr.start) {
				Interval merged = new Interval(
						Math.min(prev.start, curr.start), Math.max(prev.end,
								curr.end));
				prev = merged;
			} else { // No overlap - add to result list
				result.add(prev);
				prev = curr;
			}
		}

		// Add the last interval
		result.add(prev);
		return result;
	}

	class IntervalComparator implements Comparator<Interval> {
		@Override
		public int compare(Interval i1, Interval i2) {
			return i1.start - i2.start;
		}
	}
}
