package gr.atc.training.metavoliCSV;

public class CountryRate {

		private String country;
		private String year;
		private double rate;
		private double Change;
		private boolean foundMetavoli;

		public CountryRate(String year, String country, double rate, double metavoli) {
			this.country = country;
			this.year = year;
			this.Change = metavoli;
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
			return Change;
		}

		public void setMetavoli(double metavoli) {
			this.Change = metavoli;
		}

		public boolean getfoundMetavoli() {
			return foundMetavoli;
		}

		public void setfoundMetavoli(boolean foundMetavoli) {
			this.foundMetavoli =foundMetavoli;
		}

		public String[] toCSVString() {
			if (foundMetavoli == true) {
				String line[] = { year, country, String.valueOf(rate), String.valueOf(Change) };
				return line;
			} else {
				String line[] = { year, country, String.valueOf(rate), ("  ") };
				return line;
			}
		}

	}
}
