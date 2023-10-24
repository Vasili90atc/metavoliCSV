package gr.atc.training;


public class CountryRate {
	private String country;
	private String year;
	private double rate;
	private double change;
	private boolean foundMetavoli;

	public CountryRate(String year, String country, double rate, double metavoli) {
		this.country = country;
		this.year = year;
		this.change = metavoli;
		this.rate = rate;
	}

	public CountryRate() {

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

	public double getMetavoli() {
		return change;
	}

	public void setMetavoli(double metavoli) {
		this.change = metavoli;
	}

	public boolean getfoundMetavoli() {
		return foundMetavoli;
	}

	public void setfoundMetavoli(boolean foundMetavoli) {
		this.foundMetavoli =foundMetavoli;
	}

	public String[] toCSVString() {
		if (foundMetavoli == true) {
			String line[] = { year, country, String.valueOf(rate), String.valueOf(change) };
			return line;
		} else {
			String line[] = { year, country, String.valueOf(rate) , ( "  ") };
			return line;
		}
	}
}