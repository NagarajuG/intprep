package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate 
 * numbers sums to target.

  	Each number in candidates may only be used once in the combination.

	Note:

	All numbers (including target) will be positive integers.
	The solution set must not contain duplicate combinations.
	
	Example 1:
	
		Input: candidates = [10,1,2,7,6,1,5], target = 8,
		A solution set is:
		[
		  [1, 7],
		  [1, 2, 5],
		  [2, 6],
		  [1, 1, 6]
		]
	
	
	Example 2:
	
		Input: candidates = [2,5,2,1,2], target = 5,
		A solution set is:
		[
		  [1,2,2],
		  [5]
		]
 * */
public class CombinationSum40 {

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> resultList = new ArrayList<List<Integer>>();
		Arrays.sort(candidates);

		combinationSum2Util(candidates, target, resultList, 0, new ArrayList<Integer>());

		return resultList;

	}

	public void combinationSum2Util(int[] candidates, int target, List<List<Integer>> resultList, int index,
			ArrayList<Integer> current) {
		if (0 == target) {
			resultList.add(new ArrayList<>(current));
			return;
		}

		if (target < 0)
			return;

		for (int i = index; i < candidates.length; i++) {
			if (i == index || candidates[i] != candidates[i - 1]) {
				current.add(candidates[i]);
				combinationSum2Util(candidates, target - candidates[i], resultList, i + 1, current);
				current.remove(current.size() - 1);

			}

		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
