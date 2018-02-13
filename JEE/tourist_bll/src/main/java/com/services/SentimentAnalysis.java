package com.services;

import java.util.List;

import com.bo.WordPolarity;

public interface SentimentAnalysis {

	public double getTextPolarity(String tokens);
	
	public double getWordPolarity(String pword);
	
	public void destinationRating();
	
	public void addWord(WordPolarity pword);
}
