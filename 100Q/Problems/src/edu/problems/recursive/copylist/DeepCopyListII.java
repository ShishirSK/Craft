package edu.problems.recursive.copylist;

import java.util.HashMap;

/**
 * Smae problem as DeepCopyList. This one uses a global map instead of passing
 * it with each recursive call. #LeetCode.
 * 
 * @author Shishir
 * 
 */
public class DeepCopyListII {

	HashMap<RandomListNode, RandomListNode> nodeMap;

	public RandomListNode copyRandomList(RandomListNode head) {

		nodeMap = new HashMap<RandomListNode, RandomListNode>();
		return randomListCopier(head);
	}

	private RandomListNode randomListCopier(RandomListNode head) {

		if (head == null) {
			return null;
		}

		if (nodeMap.containsKey(head)) {
			return nodeMap.get(head);
		}
		RandomListNode ret = new RandomListNode(head.label);
		nodeMap.put(head, ret);
		ret.next = randomListCopier(head.next);
		ret.random = randomListCopier(head.random);
		return ret;
	}
}
