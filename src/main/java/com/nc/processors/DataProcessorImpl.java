package com.nc.processors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class DataProcessorImpl implements DataProcessor {

	private static final String VALID_INPUT_REGEX = "\\d+(?:,\\s*\\d+)*";
	private Map<String, Integer> map = new HashMap<String, Integer>();
	private List<String> list = new ArrayList<String>();

	@Override
	public boolean saveData(String line) {
		if (!validate(line)) {
			list.add(line);
			return false;
		}
		String sortedline = sortedLine(line);
		if (map.containsKey(sortedline)) {
			map.put(sortedline, map.get(sortedline) + 1);
			return false;
		} else {
			map.put(sortedline, 1);
			return true;
		}
	}

	@Override
	public int countDuplicates() {
		int count = 0;
		for (Entry<String, Integer> entry : map.entrySet()) {
			if (entry.getValue() > 1)
				count++;
		}
		return count;
	}

	@Override
	public List<String> mostFrequentGroupsTillNow() {

		List<String> listOfMostFreqGrps = new ArrayList<String>();
		int maxValueInMap = Collections.max(map.values());
		for (Entry<String, Integer> entry : map.entrySet()) {
			if (entry.getValue() == maxValueInMap)
				listOfMostFreqGrps.add(entry.getKey());
		}
		return listOfMostFreqGrps;
	}

	@Override
	public int countUniqueSets() {
		int count = 0;
		for (Entry<String, Integer> entry : map.entrySet()) {
			if (entry.getValue() == 1)
				count++;
		}
		return count;
	}

	@Override
	public List<String> listOfInvalidInputs() {
		return list;
	}

	private String sortedLine(String line) {
		String[] strArr = line.split(",\\s*");
		int[] array = Arrays.stream(strArr).mapToInt(Integer::parseInt).toArray();
		Arrays.sort(array);
		String element = (Arrays.toString(array));
		return element.substring(1, element.length() - 1);
	}

	public boolean validate(String line) {
		return line.matches(VALID_INPUT_REGEX);
	}

}
