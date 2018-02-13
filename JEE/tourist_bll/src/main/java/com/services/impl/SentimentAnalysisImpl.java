package com.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bo.Commentaire;
import com.bo.Destination;
import com.bo.WordPolarity;
import com.dao.DestinationDao;
import com.dao.WordPolarityDao;
import com.services.SentimentAnalysis;

@Service
@Transactional
class SentimentAnalysisImpl implements SentimentAnalysis {

	@Autowired
	private WordPolarityDao wordPolarityDao;
	 
	@Autowired
	private DestinationDao destinationDao;
	
	@Scheduled(fixedRate = 10000)
	public void destinationRating()
	{
		System.out.println("destinationRating ....... ");
		// récupère les destiunations 
		List<Destination> destinations = destinationDao.getAll();
		
		double note =0.0;
		
		for(Destination it : destinations)
		{
			note =0.0;
			// récupère les commentaires de chaque destination
			List<Commentaire> comments = (List<Commentaire>) it.getComments();
			
			// on calsule la polarité de chaque commentaire
			for(Commentaire itc : comments)
			{
				note+= getTextPolarity(itc.getText());
			}
			if(comments.size() != 0)
			{
				it.setNote(note / comments.size());
			}
			destinationDao.update(it);
		}
	}
	
	public double getTextPolarity(String ptext) {
		
		//tokenize
		
		String[] tokens=ptext.split(" ");
		
		if(tokens.length == 0)
			return 0;
		
		double m = 0.0;
		
		for(String it : tokens) {
			m+=getWordPolarity(it);
		}
		return m / tokens.length;
	}

	
	public double getWordPolarity(String pword) {
		
		List<WordPolarity> words = wordPolarityDao.getAll();
		for(WordPolarity it : words)
		{
			if(it.getWord().equals(pword))
			{
				return it.getPolarity();
			}
			
		}
		return 0;
	}



	public void addWord(WordPolarity pword) {
		wordPolarityDao.create(pword);
	}

}
