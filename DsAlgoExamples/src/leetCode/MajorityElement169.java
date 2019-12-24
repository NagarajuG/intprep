package leetCode;

import java.util.HashMap;
import java.util.Map;

/*
 * 
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

	You may assume that the array is non-empty and the majority element always exist in the array.
	
	Example 1:
	
		Input: [3,2,3]
		Output: 3
	Example 2:
	
		Input: [2,2,1,1,1,2,2]
		Output: 2
 */

public class MajorityElement169 {

	public int majorityElementWithMap(int[] nums) {
		int length = nums.length;
		Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
		for (int num : nums) {
			int count = hashMap.getOrDefault(num, 0) + 1;
			if (count > length / 2)
				return num;

			hashMap.put(num, count);

		}

		return -1;

	}

	public int majorityElement(int[] nums) {
		int count = 0;
		Integer candidate = null;

		for (int num : nums) {
			if (count == 0) {
				candidate = num;
			}
			count += (num == candidate) ? 1 : -1;
		}

		return candidate;
	}

	public static void main(String[] args) {

	}

}
