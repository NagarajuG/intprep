package PreviousQuestions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;

/* This program to find the most common word in the given sentence excluding the words from banned list*/

public class MostCommonWord {

	static String mostFreqWord(String str, String[] banned) {

		HashSet<String> bannedWords = new HashSet<String>();
		HashMap<String, Integer> counts = new HashMap<String, Integer>();

		for (String word : banned) {
			bannedWords.add(word);
		}

		for (String s1 : str.replaceAll("[^a-zA-Z]", " ").toLowerCase().split(" ")) {
			if (!bannedWords.contains(s1)) {
				counts.put(s1, counts.getOrDefault(s1, 0) + 1);
			}
		}

		String result = "";

		for (String key : counts.keySet()) {
			if (result.equals("") || counts.get(key) > counts.get(result))
				result = key;

		}

		return result;

	}

	public static void main(String[] args) throws IOException {
		InputStreamReader i = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(i);
		String[] banned = new String[] { "hi", "hello", "hit" };

		String str = br.readLine();

		String result = mostFreqWord(str, banned);

		System.out.println("The result is .... " + result);
	}

}
