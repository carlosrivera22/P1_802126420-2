package classes;



/**
 * This class allows the construction of Company objects used in the project
 * @author carlosgrivera
 *
 */
public class Company {
	
		private String companyName;
		private String companySymbol;
		private int amountOfShares;
		private double sharePrice;
		private int sharesSold;
		
		/**
		 * Constructor of Company object
		 * @param companyName  Name of company to be constructed
		 * @param companySymbol  Symbol of company to be constructed
		 * @param amountOfShares  Number of shares the company will have
		 * @param sharePrice  Price per share of the company
		 */
		public Company(String companyName, String companySymbol,
				int amountOfShares, double sharePrice) {
			super();
			this.companyName = companyName;
			this.companySymbol = companySymbol.toUpperCase();
			this.amountOfShares = amountOfShares;
			this.sharePrice = sharePrice;
			this.sharesSold = 0;
		}

		/**
		 * This method returns the name of the company
		 * @return name of company
		 */
		public String getCompanyName() {
			return companyName;
		}

		/**
		 * This method gets the symbol of the company
		 * @return symbol of the company
		 */
		public String getCompanySymbol() {
			return companySymbol;
		}

		/**
		 * This method gets the amount of shares the company has
		 * @return the amount of shares of the company
		 */
		public int getAmountOfShares() {
			return amountOfShares;
		}

		/**
		 * This method get the price per share of the company
		 * @return price per share of the company
		 */
		public double getSharePrice() {
			return sharePrice;
		}

		/**
		 * This method sets the price per share of the company
		 * @param sharePrice price per share to set to the company
		 */
		public void setSharePrice(double sharePrice) {
			this.sharePrice = sharePrice;
		}

		/**
		 * This method get the number of sold shares sold of the company 
		 * @return shares sold by the company
		 */
		public int getSharesSold() {
			return sharesSold;
		}

		/**
		 * This method add shares to the company
		 * @param amountOfShares amount of shares to be added
		 */
		public void addShares(int amountOfShares) {
			this.amountOfShares += amountOfShares;
		}
		
		/**
		 * This method add to the number of sold shares that the company has
		 * @param amountOfShares amount of shares to be added as sold
		 */
		public void addSharesSold(int amountOfShares){
			this.sharesSold += amountOfShares;
		}

		/**
		 * This method reduces the number of shares that has been sold
		 * @param amountOfShares amount of shares to be reduced from being sold
		 */
		public void subtractSharesSold(int amountOfShares) {
			this.sharesSold -= amountOfShares;
		}
		
		/**
		 * This method duplicates the number of shares that the company has, 
		 * assigns new value to each share equal to one half of the original value
		 */
		public void split(){
			amountOfShares = amountOfShares*2;
			sharePrice = sharePrice/2;
		}
		
		
		
}


