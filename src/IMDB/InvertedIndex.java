package IMDB;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class InvertedIndex {

	public static void main(String[] args) {

		String csvFile = "src/IMDB/movie_metadata.csv";
		String line = "";
		String cvsSplit = ",";
		Map<String, List<Integer>> invertedList = new HashMap<String, List<Integer>>();
		int count = 0;
		HashLinear tab = new HashLinear(113);
	    
	    double item;

		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

			while ((line = br.readLine()) != null) {
				if (count > 0) {
					String[] coluns = line.split(cvsSplit);
					String[] keywords = coluns[16].split("( )|(\\|)");
					for (int i = 0; i < keywords.length; i++) {
						if (!keywords[i].isEmpty()) {
							if (invertedList.get(keywords[i]) != null) {
								 invertedList.get(keywords[i]).add(count);								
							} else {
								invertedList.put(keywords[i], new ArrayList<Integer>(Arrays.asList(count)));
							}
						}
					}
				}
				count++;
			}
			System.out.println(invertedList);

		} catch (IOException e) {
			e.printStackTrace();
		}
		
	    for (int i=0; i<invertedList.size(); i++){
		Object[] values = invertedList.keySet().toArray();
		int value = values[i].hashCode();
		if (value < 0) 
			value = value * -1;	
		tab.insere(value);
	    }
	    tab.imprime();
	    System.out.println("\n");

	}

}