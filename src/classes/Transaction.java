package classes;



import java.util.Date;

import dataManager.DataHandler;

/**
 * This class allows the construction of the Transaction object
 * that will allow the user to see what type of transaction 
 * has been done, by whom, to what company, at which price and
 * what amount
 * @author carlosgrivera
 *
 */
public class Transaction {

	public static final int BUY = 1;
	public static final int SELL = -1;
	
	private int buyOrSell;
	private int shareholderId;
	private String companySymbol;
	private int amount;
	private double price;
	Date date;
	/**
	 * Transaction object Constructor
	 * @param buyOrSell option of buying or to selling 
	 * @param shareholderId shareholder that performed a transaction 
	 * @param companySymbol the symbol of the company involved in transaction 
	 * @param amount amount being sold or bought
	 * @param price price at which the shares were bought or sold
	 * @param date the date at which the transaction was done 
	 */
	public Transaction(int buyOrSell, int shareholderId, String companySymbol,
			int amount, double price, Date date) {
		super();
		this.buyOrSell = buyOrSell;
		this.shareholderId = shareholderId;
		this.companySymbol = companySymbol;
		this.amount = amount;
		this.price = price;
		this.date = date;
	}

	/**
	 * gets the type of transaction that was made
	 * @return type of transaction
	 */
	public int getBuyOrSell() {
		return buyOrSell;
	}

	/**
	 * gets the id of the shareholder involved in transaction
	 * @return shareholder id
	 */
	public int getShareholderId() {
		return shareholderId;
	}

	/**
	 * gets the symbol of the company involved in the transaction 
	 * @return company symbol
	 */
	public String getCompanySymbol() {
		return companySymbol;
	}

	/**
	 * get the amount of shares involved in the transaction
	 * @return amount of shares involved in the transaction
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * gets the price of the shares involved in the transaction 
	 * @return price of the shares involved in the transaction
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * gets the date at which the transaction was done
	 * @return date at which the transaction was done 
	 */
	public Date getDate() {
		return date;
	}
	
	/**
	 * duplicates the number of shares that the company has, assigns new value 
	 * to each share equal to one half of the original value
	 */
	public void split(){
		amount = amount*2;
		price = price/2;
	}
	

	@Override
	public String toString() {
		return "["+buyOrSell+","+shareholderId+","+companySymbol+","+amount+","+price+","+DataHandler.dateFormat.format(date)+"]";
	}
}
