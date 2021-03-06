package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams49 {
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> resultList = new ArrayList<List<String>>();

		Map<String, List<String>> hashMap = new HashMap<String, List<String>>();

		for (String current : strs) {
			char[] characters = current.toCharArray();
			Arrays.sort(characters);
			String sortedString = String.valueOf(characters);

			if (!hashMap.containsKey(sortedString)) {
				hashMap.put(sortedString, new ArrayList<String>());
			}

			hashMap.get(sortedString).add(current);
		}

		resultList.addAll(hashMap.values());

		return resultList;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
