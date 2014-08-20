package edu.problems.interval;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of non-overlapping intervals, insert a new interval into the
 * intervals (merge if necessary).
 * 
 * You may assume that the intervals were initially sorted according to their
 * start times.
 * 
 * Example 1: Given intervals [1,3],[6,9], insert and merge [2,5] in as
 * [1,5],[6,9].
 * 
 * Example 2: Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in
 * as [1,2],[3,10],[12,16]. This is because the new interval [4,9] overlaps with
 * [3,5],[6,7],[8,10].
 * 
 * #LeetCode
 * 
 * @author Shishir Kinkar
 * 
 */
public class InsertInterval {

	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {

		List<Interval> result = new ArrayList<Interval>();

		// Iterate over the list
		for (Interval interval : intervals) {

			// Current interval smaller then the new one
			if (interval.end < newInterval.start) {
				result.add(interval);
			}
			// New interval smaller then the current interval
			else if (interval.start > newInterval.end) {
				result.add(newInterval);
				newInterval = interval;
			}
			// Current interval and new interval overlap
			else if (interval.end >= newInterval.start || interval.start <= newInterval.end){
				newInterval = new Interval(Math.min(interval.start, newInterval.start), 
						Math.max(interval.end, newInterval.end));
			}
		}

		// Add the last interval
		result.add(newInterval);

		// Return result list
		return result;
	}
}
