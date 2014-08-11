package edu.problems.recursive.copylist;

import java.util.HashMap;

/**
 * A linked list is given such that each node contains an additional random
 * pointer which could point to any node in the list or null.
 * 
 * Return a deep copy of the list. #LeetCode
 * 
 * @author Shishir Kinkar
 * 
 */
public class DeepCopyList {

	public RandomListNode copyRandomList(RandomListNode head) {

		HashMap<RandomListNode, RandomListNode> nodeMap = new HashMap<RandomListNode, RandomListNode>();
		return randomListCopier(head, nodeMap);
	}

	// Recursively called function
	private RandomListNode randomListCopier(RandomListNode head,
			HashMap<RandomListNode, RandomListNode> nodeMap) {

		if (head == null) {
			return null;
		}

		if (nodeMap.containsKey(head)) {
			return nodeMap.get(head);
		}
		// New copy node
		RandomListNode ret = new RandomListNode(head.label);
		// Save original and new copy in a map
		nodeMap.put(head, ret);
		// Recursively copy all next nodes
		ret.next = randomListCopier(head.next, nodeMap);
		// Recursively link all random nodes
		ret.random = randomListCopier(head.random, nodeMap);

		// Return head node of the new list.
		return ret;
	}
}
