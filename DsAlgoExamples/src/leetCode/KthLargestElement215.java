package leetCode;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * 
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

	Example 1:
	
		Input: [3,2,1,5,6,4] and k = 2
		Output: 5
	Example 2:
	
		Input: [3,2,3,1,2,4,5,5,6] and k = 4
		Output: 4
	Note:
		You may assume k is always valid, 1 ≤ k ≤ array's length.
 */

public class KthLargestElement215 {

	int max = 0;

	void swap(int nums[], int i, int j) {
		int t = nums[i];
		nums[i] = nums[j];
		nums[j] = t;
	}

	int partition(int nums[], int l, int h) {
		int p = nums[l];
		int i = l, j = h + 1;
		while (true) {
			do {
				i++;
			} while (i <= h && nums[i] < p);

			do {
				j--;
			} while (nums[j] > p && (j >= l));

			if (i < j) {
				swap(nums, i, j);
			} else {
				swap(nums, l, j);
				return j;

			}
		}

	}

	void Util1(int nums[], int l, int h, int index) {
		int j;
		if (l == h) {
			this.max = nums[l];
			return;
		}

		if (l <= h) {
			j = partition(nums, l, h);
			if (index == j) {
				this.max = nums[index];
				return;
			}
			if (index >= l && index <= j - 1)
				Util1(nums, l, j - 1, index);
			else
				Util1(nums, j + 1, h, index);
		}
	}

	public int findKthLargest(int[] nums, int k) {
		int low = 0, high = nums.length - 1;
		int index = nums.length - k;

		Util1(nums, low, high, index);

		return this.max;

	}

	public int findKthLargestWithHeap(int[] nums, int k) {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Comparator.reverseOrder());
		for (int num : nums) {
			maxHeap.offer(num);
			if (maxHeap.size() > k) {
				maxHeap.poll();
			}
		}

		return maxHeap.poll();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
