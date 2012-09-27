package com.longestwords;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class App {

	public static Set<String> findLongestWords(String sentence) {
		Set<String> result = new HashSet<String>();
		if (sentence == null || sentence.length() == 0)
			return result;

		String[] words = sentence.split("[\\s\\?\\.!,'\";:]+");

		TreeSet<String> set = new TreeSet<String>(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if (o1.length() < o2.length()) {
					return -1;
				} else if (o1.length() > o2.length()) {
					return 1;
				} else {
					return o1.compareToIgnoreCase(o2);
				}
			}
		});

		for (String word : words) {
			if (word.length() > 0)
				set.add(word);
		}

		int longestWord = 0;

		if (set.size() > 0) {
			Iterator<String> iterator = set.descendingIterator();
			String word;
			while(iterator.hasNext()) {
				word = iterator.next();
				if (longestWord == 0) {
					longestWord = word.length();
				} else if (word.length() < longestWord) {
					break;
				}
				result.add(word);
			}
		}

		return result;
	}
}
