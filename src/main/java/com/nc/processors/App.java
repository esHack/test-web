package com.nc.processors;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

public class App {

	public static void main(String[] args) {

		DataProcessorImpl impl = new DataProcessorImpl();

		String fileName = "input.txt";
		URL resource = App.class.getResource(fileName);

		FileReader fr;
		try {
			fr = new FileReader(Paths.get(resource.toURI()).toFile());
			BufferedReader bufr = new BufferedReader(fr);
			String line;
			while ((line = bufr.readLine()) != null) {

				System.out.println("INPUT:" + line);

				/*if (impl.saveData(line)) {
					System.out.println("ADDED " +line);

				} else {
					System.out.println("DUPLICATE "+line);
				}*/
				impl.saveData(line);
				System.out.println("Total Duplicates so far..."+impl.countDuplicates());
				System.out.println("Total Unique so far..."+impl.countUniqueSets());
				System.out.println("List of Invalid Inputs..."+impl.listOfInvalidInputs());
				System.out.println("Total freq so far..."+impl.mostFrequentGroupsTillNow());

			}
			bufr.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

	}

}
