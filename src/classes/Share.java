package classes;

/**
 * This class allows the construction of the share object to be used in the program 
 * @author carlosgrivera
 *
 */
public class Share {
	
	private int shareholderId;
	private String companySymbol;
	private int amountOfShares;
	
	/**
	 * Constructor of the Share object
	 * @param shareholderId ID of shareholder
	 * @param companySymbol symbol of the company
	 * @param amountOfShares amount of shares 
	 */
	public Share(int shareholderId, String companySymbol, int amountOfShares) {
		super();
		this.shareholderId = shareholderId;
		this.companySymbol = companySymbol;
		this.amountOfShares = amountOfShares;
	}

	/**
	 * Gets the shareholder id
	 * @return shareholder id
	 */
	public int getShareholderId() {
		return shareholderId;
	}

	/**
	 * Get the company symbol from the share object
	 * @return company symbol
	 */
	public String getCompanySymbol() {
		return companySymbol;
	}

	/**
	 * Gets the amount of shares of the Share object 
	 * @return amount of shares
	 */
	public int getAmountOfShares() {
		return amountOfShares;
	}

	/**
	 * Adds shares to the Share object
	 * @param amountOfShares shares to be added
	 */
	public void addAmount(int amountOfShares) {
		this.amountOfShares += amountOfShares;
	}
	
	/**
	 * Subtracts share from the Share object
	 * @param amountOfShares amount of shares to be subtracted 
	 */
	public void substractAmount(int amountOfShares) {
		this.amountOfShares -= amountOfShares;
	}
	
	/**
	 * Doubles the amount of shares
	 */
	public void split(){
		amountOfShares = amountOfShares*2;
	}

}
