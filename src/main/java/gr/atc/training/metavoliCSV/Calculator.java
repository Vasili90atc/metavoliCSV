package gr.atc.training.metavoliCSV;

import java.util.ArrayList;

public class Calculator {
	private String country;
	private String year;
	private double rate;

	public Calculator(String year, String country, double rate) {
		this.country = country;
		this.year = year;
		this.rate = rate;
	}

	public Calculator() {

	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public void readFile(String path, ArrayList<Calculator> lista) {
		// TODO Auto-generated method stub

	}

	public Calculator getCalculator(String year2, String country2, ArrayList<Calculator> lista) {
		// TODO Auto-generated method stub
		return null;
	}
}
