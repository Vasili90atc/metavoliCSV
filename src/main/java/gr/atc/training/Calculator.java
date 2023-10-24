package gr.atc.training;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class Calculator {
	

	public void readFile(File f, ArrayList<CountryRate> lista) {
		// mia methodos gia na diavasw to arxeio kai na prostetw
		// antikeimeno sto ArrayList

		// -------- Using CSVReader
		/*
		FileReader filereader = null;
		
		System.out.println(f);

		try {
			filereader = new FileReader(f);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		//CSVReader rdr = new CSVReader(filereader);
 */
		String line = "";// dilwsi metavlitwn 
		BufferedReader reader = null;// dilwsi eidikou tupou metavlitwn
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(f), "UTF-8"));// anoigei to arxeio
		
	
			line = reader.readLine();
			while ((line = reader.readLine()) != null) {

				String word[] = line.split(",");// spaw se kommatia me vasi to komma pou to exw onomasei word
				if (word.length < 3) { // elegxw an to plithos tou pinaka einai mikrotero apo 3
					continue;// sunexizei me tin epomeni epanalispi
				}

				CountryRate rc = new CountryRate();// dimiourgei ena antikeimeno tou tupou CountryRate
				rc.setCountry(word[1]);// tin xwra pou exei vrei tin vazei mesa sto antikeimeno
				rc.setYear(word[0].split("-")[0]);// tin imerominia pou exei vrei tin vazei mesa sto antikeimeno

				rc.setRate(Double.parseDouble(word[2]));
				if (lista.size() != 0) {
					CountryRate rc_before = lista.get(lista.size() - 1);

					if (rc_before.getCountry().equals(rc.getCountry())) {
						rc.setMetavoli(((rc.getRate() - rc_before.getRate())/rc_before.getRate())*100);
						
						rc.setfoundMetavoli(true);
					} else {
						rc.setfoundMetavoli(false);
					}
				} else {
					rc.setfoundMetavoli(false);
				}

				lista.add(rc);
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public CountryRate getCountryRate(String country,String year, ArrayList<CountryRate> lista) {
		for (int i = 0; i < lista.size(); i++) {
			CountryRate r = lista.get(i);
			if (r.getCountry().equals(country) && r.getYear().equals(year))
				return r;
		}
		return null;
	}

	public void printListaToCSV(ArrayList<CountryRate> lista, String path) {
		CSVWriter writer = null;
		try {
			writer =new CSVWriter(new FileWriter(new File(path)));
		} catch (IOException e) {
			e.printStackTrace();
		}

		String firstLine[] = { "Year", "Country", "Rate", "Change" };
		writer.writeNext(firstLine);

		for (int i = 0; i < lista.size(); i++) {
			writer.writeNext(lista.get(i).toCSVString());

		}
		try {
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
