package com.nc.processors;

import java.util.List;

public interface DataProcessor {

	/*
	 * 
	 * @sav
	 * 
	 */
	boolean saveData(String line);
	
	int countDuplicates();
	
	int countUniqueSets();
	
	List<String> mostFrequentGroupsTillNow();
	
	List<String> listOfInvalidInputs();
	
	
}
