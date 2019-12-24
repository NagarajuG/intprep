package leetCode;

/*
 * 
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

	Example:
	
	Input: [-2,1,-3,4,-1,2,1,-5,4],
	Output: 6
	Explanation: [4,-1,2,1] has the largest sum = 6.
	Follow up:
	
	If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */
public class MaximumSubArray53 {
	public int maxSubArray(int[] nums) {
		int length = nums.length;
		int maxSum = nums[0], currSum = nums[0];

		for (int i = 1; i < length; i++) {
			currSum = Math.max(nums[i], currSum + nums[i]);
			maxSum = Math.max(maxSum, currSum);

		}

		return maxSum;

	}

	public static void main(String[] args) {

	}

}
