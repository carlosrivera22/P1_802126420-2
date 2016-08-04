package dataManager;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import classes.Company;
import classes.Share;
import classes.Shareholder;
import classes.Transaction;

/**
 * This class handles all the data input and output.
 * @author carlosgrivera
 *
 */
public class DataHandler {
	private static ArrayList<Company> companies = new ArrayList<Company>();
	private static ArrayList<Shareholder> shareholders = new ArrayList<Shareholder>();
	private static ArrayList<Share> shares = new ArrayList<Share>();
	private static ArrayList<Transaction> transactions = new ArrayList<Transaction>();
	public static final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	public static final DecimalFormat twoDecimals = new DecimalFormat("#,##0.00");
	/**
	 * Gets the Company objects list
	 * @return company object list
	 */
	public static ArrayList<Company> getCompanies() {
		return companies;
	}
	
	/**
	 * This method sets the companies list into the instance list to be handle.
	 * @param companies list of Company objects
	 */
	public static void setCompanies(ArrayList<Company> companies) {
		DataHandler.companies = companies;
	}
	
	/**
	 * This method adds a company into the list of Company objects
	 * @param c company to add to the list
	 */
	public static void addCompany(Company c){
		boolean duplicate = false;
		for(int i=0; i < companies.size(); i++){
			if(c.getCompanySymbol().equalsIgnoreCase(companies.get(i).getCompanySymbol())){
				duplicate = true;
				System.out.println("Can't add, company already exists.");
			}
			
		}
		if(!duplicate){
		companies.add(c);
		System.out.println("Company added successfully!");
		}

	}
	
	/**
	 * This method gets the list of Shareholder objects
	 * @return list of shareholders 
	 */
	public static ArrayList<Shareholder> getShareholders() {
		return shareholders;
	}
	
	/**
	 * This method adds a shareholder into the list of Shareholder objects
	 * @param shareholderName shareholder to add
	 * @return Shareholder id
	 */
	public static int addShareholder(String shareholderName){
		Shareholder s = new Shareholder(shareholders.size() + 1, shareholderName);
		shareholders.add(s);
		System.out.println("Shareholder added successfully!");
		System.out.println("Shareholder ID: " + s.getShareholderId());
		return s.getShareholderId();
	}
	
	/**
	 * This method sets the shareholder list into the instance of shareholder list of the class
	 * @param shareholders list of shareholders
	 */
	public static void setShareholders(ArrayList<Shareholder> shareholders) {
		DataHandler.shareholders = shareholders;
	}
	
	/**
	 * This method adds shares to a particular company.
	 * @param companySymbol symbol of the company 
	 * @param amountOfShares amount of shares to add
	 */
	public static void addShareToCompany(String companySymbol, int amountOfShares) {
		boolean invalid = true;
		for(int i=0; i < companies.size(); i++){
			if(companySymbol.equalsIgnoreCase(companies.get(i).getCompanySymbol())){
				Company c = companies.get(i);
				c.addShares(amountOfShares);
				companies.set(i, c);
				System.out.println("Shares added successfully!");
				System.out.println("Company shares: " + c.getAmountOfShares()); 
				invalid = false;
			}
		}
		if(invalid){
			System.out.println("Company does not exist!");
		}
		
	}
	
	/**
	 * This method sets the shares list as the instance list of shares of the class
	 * @param shares list of shares
	 */
	public static void setShares(ArrayList<Share> shares) {
		DataHandler.shares = shares;
	}
	
	/**
	 * This method gets the list of Share objects 
	 * @return list of shares
	 */
	public static ArrayList<Share> getShares() {
		return shares;
	}
	
	/**
	 * This method sets the transactions list into the instance of transactions list of the class
	 * @param transactions transactions list
	 */
	public static void setTransactions(ArrayList<Transaction> transactions) {
		DataHandler.transactions = transactions;
	}
	
	/**
	 * This method get the list of Transaction objects
	 * @return transactions list
	 */
	public static ArrayList<Transaction> getTransactions() {
		return transactions;
	}
	
	/**
	 * This method duplicates the number of shares that the company has, 
	 * assigns new value to each share equal to one half of the original value
	 * @param companySymbol symbol of the company to apply the split operation to
	 */
	public static void splitOperation(String companySymbol) {
		boolean invalid = true;
		for(int i=0; i < companies.size(); i++){
			if(companySymbol.equalsIgnoreCase(companies.get(i).getCompanySymbol())){
				Company c = companies.get(i);
				c.split();
				companies.set(i, c);
				System.out.println("Split Operation was successfull!");
				System.out.println("Company shares: " + c.getAmountOfShares()); 
				System.out.println("Company share value: " + c.getSharePrice());
				invalid = false;
			}
		}
		if(invalid){
			System.out.println("Company does not exist!");
		}
	}
	
	/**
	 * This method changes the share value of a certain company
	 * @param companySymbol Symbol of company 
	 * @param price New share value
	 */
	public static void updateShareValue(String companySymbol, double price) {
		boolean invalid = true;
		for(int i=0; i < companies.size(); i++){
			if(companySymbol.equalsIgnoreCase(companies.get(i).getCompanySymbol())){
				Company c = companies.get(i);
				c.setSharePrice(price);
				companies.set(i, c);
				invalid = false;
			}
		}
		if(invalid){
			System.out.println("Company does not exist!");
		}	
	}
	
	/**
	 * This method allows a certain shareholder to buy shares from a specific company
	 * @param shareholderId The ID of the shareholder to buy
	 * @param companySymbol Symbol of company to buy shares from
	 * @param amountOfShares The amount of shares to be bought
	 */
	public static void buyShares(int shareholderId, String companySymbol, int amountOfShares) {
		boolean validCompany = false;
		boolean validShareholder = false;
		for(int i=0; i < shareholders.size(); i++){
			if(shareholderId == (shareholders.get(i).getShareholderId()) && shareholders.get(i).isShareHolderActive()){
				validShareholder = true;
				for(int j=0; j < companies.size(); j++){
					if(companySymbol.equalsIgnoreCase(companies.get(j).getCompanySymbol())){
						validCompany = true;
						Shareholder s = shareholders.get(i);
						Company c = companies.get(j);
						Share share;
						if(amountOfShares > (c.getAmountOfShares() - c.getSharesSold())){
							System.out.println("Insufficient amount of shares. Transaction unsucessful.");
							return;
							}
					
							int shareIndex = searchShare(s.getShareholderId(), c.getCompanySymbol());
							if(shareIndex != -1){
							share = shares.get(shareIndex);
							share.addAmount(amountOfShares);
							shares.set(shareIndex, share);
							}
							else{
							share = new Share(shareholderId, companySymbol, amountOfShares);
							shares.add(share);
							}
					
							
						c.addSharesSold(amountOfShares);
						
						companies.set(j, c);
						transactions.add(new Transaction(Transaction.BUY, shareholderId, c.getCompanySymbol(), amountOfShares, c.getSharePrice(), new Date()));
						
						
						System.out.println("Transaction successful! \n" + s.getShareholderName() + " owns " + share.getAmountOfShares() + " shares from " + c.getCompanyName());
						
						
					}
				}
				if(!validCompany){
					System.out.println("Invalid Company.");
				}
				
			}
		}
		if(!validShareholder){
			System.out.println("Invalid Shareholder");
		}
		
		
		
	}
	
	/**
	 * This method searches a specific shareholder 
	 * @param shareholderId ID of the shareholder
	 * @return shareholder id to search
	 */
	private static int searchShareholder(int shareholderId){
		for(int i=0; i < shareholders.size(); i++){
			if(shareholderId == shareholders.get(i).getShareholderId() && shareholders.get(i).isShareHolderActive()){
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * This method allows a shareholder to sell shares.
	 * @param shareholderId ID of the shareholder
	 * @param companySymbol Symbol of the company
	 * @param amountOfShares Amount of shares to sell
	 */
	public static void sellShare(int shareholderId, String companySymbol, int amountOfShares) 
	{
	int cIndex = searchCompany(companySymbol);
	int sIndex = searchShareholder(shareholderId);
	
	if(cIndex == -1){
		System.out.println("Invalid Company.");
		return;
	}
	
	if(sIndex == -1){
		System.out.println("Invalid Shareholder.");
		return;
	}
		
	
	Company c = companies.get(cIndex);
	Shareholder s = shareholders.get(sIndex);
	int shareIndex = searchShare(shareholderId, companySymbol);
	Share share = null;
	if(shareIndex != -1){
		share = shares.get(shareIndex);
	}else{
		System.out.println("Not enough shares for the shareholder to sell.");
		return;
	}
	if(shareIndex != -1){
	if(amountOfShares > share.getAmountOfShares()){
		System.out.println("Not enough shares for the shareholder to sell.");
		return;
	}
	
	
	ArrayList<Transaction> transactionList = getTransactions(shareholderId, companySymbol);
	LLQueue<SShare> sharesQueue = getSharesQueue(transactionList);
	
	int amountToSell = amountOfShares;
	double capitalGain = 0;
	
	while(amountToSell > 0){
		if(amountToSell > sharesQueue.front().amount){
			SShare shareDequeued = sharesQueue.dequeue();
			amountToSell -= shareDequeued.amount;
			capitalGain += shareDequeued.amount*(c.getSharePrice() - shareDequeued.price);
		} else {
			sharesQueue.front().subtractAmount(amountToSell);
			capitalGain += amountToSell*(c.getSharePrice() - sharesQueue.front().price);
			amountToSell = 0;
		}
	}

	c.subtractSharesSold(amountOfShares);
	share.substractAmount(amountOfShares);
	
	companies.set(cIndex, c);
	if(share.getAmountOfShares() > 0){
		shares.set(shareIndex, share);
	}
	else{
		shares.remove(shareIndex);
	}
	
	transactions.add(new Transaction(Transaction.SELL, shareholderId, c.getCompanySymbol(), amountOfShares, c.getSharePrice(), new Date()));
	twoDecimals.format(capitalGain);
	System.out.println("Transaction successful! \n" + s.getShareholderName() + " owns " + share.getAmountOfShares() + " shares from " + c.getCompanyName());
	}
  }
	
	/**
	 * This method searches for a specific share.
	 * @param shareholderID Shareholder ID
	 * @param companySymbol Symbol of the company
	 * @return share index to search in list
	 */
	private static int searchShare(int shareholderID, String companySymbol) {
		for(int i=0; i < shares.size(); i++){
			Share s = shares.get(i);
			if(s.getShareholderId() == shareholderID && s.getCompanySymbol().equalsIgnoreCase(companySymbol))
				return i;	
		}
		return -1;
	}
	
	/**
	 * This method searches for a certain company.
	 * @param companySymbol symbol of company to search
	 * @return index of company to search 
	 */
	private static int searchCompany(String companySymbol){
		for(int i=0; i < companies.size(); i++){
			if(companySymbol.equalsIgnoreCase(companies.get(i).getCompanySymbol())){
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * This method searches for the list of Transaction objects
	 * @param shareholderId ID of the shareholder
	 * @param companySymbol Symbol of the company 
	 * @return list of transactions
	 */
	private static ArrayList<Transaction> getTransactions(int shareholderId, String companySymbol){
		ArrayList<Transaction> list = new ArrayList<Transaction>();
		for(int i=0; i < transactions.size(); i++){
			Transaction t = transactions.get(i);
			if(t.getShareholderId() == shareholderId && t.getCompanySymbol().equalsIgnoreCase(companySymbol))
				list.add(t);
		}
		
		return list;
	}
	
	/**
	 * This method gets the queue of shares 
	 * @param transactionList List of Transaction objects
	 * @return queue of shares 
	 */
	private static LLQueue<SShare> getSharesQueue(ArrayList<Transaction> transactionList){
		LLQueue<SShare> sharesQueue = new LLQueue<SShare>();
		for(int i=0; i < transactionList.size(); i++){
			Transaction t = transactionList.get(i);
			if(t.getBuyOrSell() == Transaction.BUY){
				sharesQueue.enqueue(new SShare(t.getAmount(), t.getPrice()));
			} else {
				int tsamount = t.getAmount();
				while(tsamount > 0) {
					if(tsamount > sharesQueue.front().amount){
						tsamount -= sharesQueue.dequeue().amount;
					} else {
						sharesQueue.front().subtractAmount(tsamount);
						tsamount = 0;
					}
				}
			}
		}
		
		return sharesQueue;
	}
	
	/**
	 * This method allows the removal of a certain shareholder.
	 * @param shareholderId Shareholder identification number
	 */
	public static void removeShareholder(int shareholderId) {
		for(int i=0; i < shares.size(); i++){
			if(shareholderId == (shares.get(i).getShareholderId()) && (shares.get(i).getAmountOfShares()) != 0){
				System.out.println("Unsold Shares!");
				return;
			}
			
		}

		for(int i=0; i < shareholders.size(); i++){
			if(shareholderId == (shareholders.get(i).getShareholderId())){
				Shareholder s = shareholders.get(i);
				s.setInactive();
				shareholders.set(i, s);
				System.out.println("Shareholder removed!");
				return;
			}
		}
		System.out.println("Invalid Shareholder");
		return;
	}
	
	/**
	 * This method allows the removal of a certain company
	 * @param companySymbol Symbol of the company to remove.
	 */
	public static void removeCompany(String companySymbol) {
		for(int i=0; i < shares.size(); i++){
			if(companySymbol.equalsIgnoreCase(shares.get(i).getCompanySymbol())){
				System.out.println("Unsold shares!");
				return;
			}
				
		}

		for(int i=0; i < companies.size(); i++){
			if(companySymbol.equalsIgnoreCase(companies.get(i).getCompanySymbol())){
				companies.remove(i);
				System.out.println("Company removed!");
				return;
			}
		}
		System.out.println("Invalid Company");
		return;
		
	}

	/**
	 * This method shows the list of the company's shareholder, and number of shares that each owns
	 * @param companySymbol Company to show report of 
	 * @return Company report 
	 */
	public static String showReportOfCompany(String companySymbol){
		for(int i=0; i < companies.size(); i++){
			if(companySymbol.equalsIgnoreCase(companies.get(i).getCompanySymbol())){
				Company c = companies.get(i);
				String formattedPrice = String.format("%.02f", c.getSharePrice());
				String report = "Name: " + c.getCompanyName() + "\n" + "Symbol: " + c.getCompanySymbol() + "\n" +
								"Company has " + c.getAmountOfShares() + " shares at $" + formattedPrice + "\n" +
								  c.getSharesSold() + " sold shares.";
				return report;				
			}
		}
		return "Invalid Company";
	}
	/**
	 * This method show the list of its shareholder, and number of shares that each owns.
	 * @param shareholderId Shareholder to show report from
	 * @return Shareholder's portfolio 
	 */
	public static String showShareholderPortfolio(int shareholderId){
		for(int i=0; i < shareholders.size(); i++){
			if(shareholderId == (shareholders.get(i).getShareholderId()) && shareholders.get(i).isShareHolderActive()){
				Shareholder s = shareholders.get(i);
				
				String report = s.getShareholderId() + " - " + s.getShareholderName() + "\n" +
								"Shares owned: ";
				for(int j=0; j < shares.size(); j++){
					if(shareholderId == shares.get(j).getShareholderId()){
						Share share = shares.get(j);
						Company c = companies.get(searchCompany(share.getCompanySymbol()));
						String formattedPrice = String.format("%.02f", c.getSharePrice());
						report = report.concat(c.getCompanySymbol() + " - " + share.getAmountOfShares() + " at $" + formattedPrice + "\n");
					}
				}
				return report;
			}
		}
		return "Invalid Shareholder";
	}
	
	/**
	 * Class from which objects are stored in a queue to take out when a sell action is being performed
	 * @author carlosgrivera
	 *
	 */
	private static class SShare {
		int amount;
		double price;
		
		public SShare(int amount, double price) {
			super();
			this.amount = amount;
			this.price = price;
		}
		
		public void subtractAmount(int amount){
			this.amount -= amount;
		}
		
	}
	
	
}
	

