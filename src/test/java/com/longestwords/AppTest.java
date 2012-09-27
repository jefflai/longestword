package com.longestwords;

import java.util.Set;

import junit.framework.Assert;

import org.junit.Test;

public class AppTest {

	@Test
	public void simpleSentence() {
		String sentence = "I am home.";
		Set<String> result = App.findLongestWords(sentence);
		Assert.assertEquals(1, result.size());
		Assert.assertTrue(result.contains("home"));
	}

	@Test
	public void longerSentence() {
		String sentence = "Asian shares rebounded on Thursday, buoyed by a sharp "
				+ "upturn in Chinese shares, but sentiment was vulnerable to uncertainty "
				+ "over a bailout for Spain and signs Europe is struggling to find a unified "
				+ "approach to the Greek debt crisis.";
		Set<String> result = App.findLongestWords(sentence);
		Assert.assertEquals(1, result.size());
		Assert.assertTrue(result.contains("uncertainty"));
	}

	@Test
	public void twoLongestWords() {
		String sentence = "I went home!";
		Set<String> result = App.findLongestWords(sentence);
		Assert.assertEquals(2, result.size());
		Assert.assertTrue(result.contains("went"));
		Assert.assertTrue(result.contains("home"));
	}

	@Test
	public void oneWordSentence() {
		String sentence = "Hey!";
		Set<String> result = App.findLongestWords(sentence);
		Assert.assertEquals(1, result.size());
		Assert.assertTrue(result.contains("Hey"));
	}

	@Test
	public void sameWordRepeated() {
		String sentence = "car car car car";
		Set<String> result = App.findLongestWords(sentence);
		Assert.assertEquals(1, result.size());
		Assert.assertTrue(result.contains("car"));
	}

	@Test
	public void nullSentence() {
		Set<String> result = App.findLongestWords(null);
		Assert.assertEquals(0, result.size());
	}

	@Test
	public void emptySentence() {
		Set<String> result = App.findLongestWords("");
		Assert.assertEquals(0, result.size());
	}

	@Test
	public void punctuationOnly() {
		String sentence = ". ?;:!,\"' .";
		Set<String> result = App.findLongestWords(sentence);
		Assert.assertEquals(0, result.size());
	}

}
