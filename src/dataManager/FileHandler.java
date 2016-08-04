package dataManager;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.ParseException;
import java.util.ArrayList;

import classes.Company;
import classes.Share;
import classes.Shareholder;
import classes.Transaction;

/**
 * This class handles all the files in the project
 * @author carlosgrivera
 *
 */
public class FileHandler {
	private static RandomAccessFile companies;
	private static RandomAccessFile shareholders;
	private static RandomAccessFile shares;
	private static RandomAccessFile transactions;
	
	/**
	 * This method writes the transactions file.
	 * @param out Random Access File
	 * @param list list of Transaction objects
	 * @throws IOException
	 */
	private static void writeTransactionsFile(RandomAccessFile out,
			ArrayList<Transaction> list) throws IOException {
		out.seek(0);
		for(int i=0; i < list.size(); i++){
			Transaction t = list.get(i);
			String formattedPrice = String.format("%.02f", t.getPrice());
			out.write((""+t.getBuyOrSell()+"\n").getBytes());
			out.write((""+t.getShareholderId()+"\n").getBytes());
			out.write((t.getCompanySymbol()+"\n").getBytes());
			out.write((""+t.getAmount()+"\n").getBytes());
			out.write((""+formattedPrice+"\n").getBytes());
			out.write((DataHandler.dateFormat.format(t.getDate())+"\n").getBytes());
		}
	}
	
	/**
	 * This method writes the data into the transactions file
	 * @throws IOException throws if file can't be accessed
	 */
	public static void writeTransactionData() throws IOException{
		transactions = new RandomAccessFile("transactions", "rw");
		writeTransactionsFile(transactions, DataHandler.getTransactions());
		transactions.close();
	}
	/**
	 * This method writes data into the shares file
	 * @throws IOException throws if file can't be accessed 
	 */
	public static void writeShareData() throws IOException{
		shares = new RandomAccessFile("shares", "rw");
		writeSharesFile(shares, DataHandler.getShares());
		shares.close();
	}
	
	/**
	 * This method writes the shares file
	 * @param out Random Access File
	 * @param list List of Share objects
	 * @throws IOException throws if file can't be accessed 
	 */
	private static void writeSharesFile(RandomAccessFile out,
			ArrayList<Share> list) throws IOException {
		out.seek(0);
		for(int i=0; i < list.size(); i++){
			Share s = list.get(i);
			
			out.write((""+s.getShareholderId()+"\n").getBytes());
			out.write((s.getCompanySymbol()+"\n").getBytes());
			out.write((""+s.getAmountOfShares()+"\n").getBytes());
		}	
	}
	
	/**
	 * This method writes data into the companies file
	 * @throws IOException throws if file can't be accessed 
	 */
	public static void writeCompanyData() throws IOException{
		companies = new RandomAccessFile("companies", "rw");
		
		writeCompaniesFile(companies, DataHandler.getCompanies());
		
		companies.close();
	}
	
	/**
	 * This method read all the files the project has created.
	 * @throws IOException throws if file can't be accessed
	 * @throws ClassNotFoundException throws if class is not found 
	 * @throws NumberFormatException throws if is an Exception that might be thrown 
	 * when you try to convert a String into a number, where that number might be an 
	 * int , a float , or any other Java numeric type.
	 * @throws ParseException throws whenever we try to handle an object 
	 * which no longer exists 
	 */
	public static void readAllData() throws IOException, ClassNotFoundException, NumberFormatException, ParseException{
		companies = new RandomAccessFile("companies", "rw");
		shareholders= new RandomAccessFile("shareholders", "rw");
		shares = new RandomAccessFile("shares", "rw");
		transactions = new RandomAccessFile("transactions", "rw");
		
		DataHandler.setCompanies(readCompaniesFile(companies));
		DataHandler.setShareholders(readShareholdersFile(shareholders));
		DataHandler.setShares(readSharesFile(shares));
		DataHandler.setTransactions(readTransactionsFile(transactions));
		
		closeAllFiles();
	}
	
	/**
	 * This method writes the companies file.
	 * @param out Random Access File
	 * @param list List of Company objects
	 * @throws IOException throws if file can't be accessed 
	 */
	private static void writeCompaniesFile(RandomAccessFile out,
			ArrayList<Company> list) throws IOException {
		out.seek(0);
		for(int i=0; i < list.size(); i++){
			Company c = list.get(i);
			String formattedPrice = String.format("%.02f", c.getSharePrice());
			out.write((c.getCompanyName()+"\n").getBytes());
			out.write((c.getCompanySymbol()+"\n").getBytes());
			out.write((""+c.getAmountOfShares()+"\n").getBytes());
			out.write((""+formattedPrice+"\n").getBytes());
			out.write((""+c.getSharesSold()+"\n").getBytes());
		}	
	}
	
	/**
	 * This method writes data into the shareholders file
	 * @throws IOException throws if file can't be accessed 
	 */
	public static void writeShareholderData() throws IOException{
		shareholders = new RandomAccessFile("shareholders", "rw");
		
		writeShareholdersFile(shareholders, DataHandler.getShareholders());
		
		shareholders.close();
	}
	
	/**
	 * This method writes the shareholders file
	 * @param out Random Access File
	 * @param list List of Shareholder objects
	 * @throws IOException throws if file can't be accessed 
	 */
	private static void writeShareholdersFile(RandomAccessFile out,
			ArrayList<Shareholder> list) throws IOException {
		out.seek(0);
		for(int i=0; i < list.size(); i++){
			Shareholder s = list.get(i);
			out.write((""+s.getShareholderId()+"\n").getBytes());
			out.write((s.getShareholderName()+"\n").getBytes());
			out.write((""+s.isShareHolderActive()+"\n").getBytes());
		}
	}
	
	/**
	 * This method reads the shareholders file
	 * @param in  Random Access File
	 * @return list of shareholders
	 * @throws NumberFormatException is an Exception that might be thrown when you try to convert 
	 * a String into a number, where that number might be an int , a float , 
	 * or any other Java numeric type.
	 * @throws IOException throws if file can't be accessed  
	 */
	private static ArrayList<Shareholder> readShareholdersFile(
			RandomAccessFile in) throws NumberFormatException, IOException {
		ArrayList<Shareholder> list = new ArrayList<Shareholder>();
		in.seek(0);
		while(in.getFilePointer() < in.length()){
			list.add(
					new Shareholder(
							Integer.parseInt(in.readLine()), 
							in.readLine(),
							Boolean.parseBoolean(in.readLine())
							)
					);
		}
		return list;
	}
	
	/**
	 * This method reads the companies file
	 * @param in Random Access File
	 * @return list of company objects
	 * @throws NumberFormatException  is an Exception that might be thrown when you 
	 * try to convert a String into a number, where that number might be an int , a 
	 * float , or any other Java numeric type.
	 * @throws IOException throws if file can't be accessed
	 */
	private static ArrayList<Company> readCompaniesFile(
			RandomAccessFile in) throws NumberFormatException, IOException {
		ArrayList<Company> list = new ArrayList<Company>();
		in.seek(0);
		int i = 0;
		while(in.getFilePointer() < in.length()){
			list.add(
					new Company(
							in.readLine(), 
							in.readLine(), 
							Integer.parseInt(in.readLine()),
							Double.parseDouble(in.readLine())
							)
					);
			list.get(i).addSharesSold(Integer.parseInt(in.readLine()));
			i++;
		}
		return list;
	}
	
	/**
	 * This method reads the shares file
	 * @param in Random Access File
	 * @return list of Share objects
	 * @throws NumberFormatException  is an Exception that might be thrown when you try to 
	 * convert a String into a number, where that number might be an int , a float , 
	 * or any other Java numeric type.
	 * @throws IOException throws if file can't be accessed
	 */
	private static ArrayList<Share> readSharesFile(
			RandomAccessFile in) throws NumberFormatException, IOException {
		ArrayList<Share> list = new ArrayList<Share>();
		in.seek(0);
		while(in.getFilePointer() < in.length()){
			list.add(
					new Share(
							Integer.parseInt(in.readLine()), 
							in.readLine(),
							Integer.parseInt(in.readLine())
							)
					);
		}
		return list;
	}
	
	/**
	 * This method closes all the files created by the project.
	 * @throws IOException throws if file can't be accessed
	 */
	private static void closeAllFiles() throws IOException{
		companies.close();
		shareholders.close();
		shares.close();
		transactions.close();
	}
	
	/**
	 * This method reads the transactions file
	 * @param in Random Access File
	 * @return list of Transaction objects
	 * @throws IOException throws if file can't be accessed 
	 * @throws NumberFormatException  is an Exception that might be thrown when you 
	 * try to convert a String into a number, where that number might be an int , 
	 * a float , or any other Java numeric type.
	 * @throws ParseException throws whenever we try to handle an object 
	 * which no longer exists 
	 */
	private static ArrayList<Transaction> readTransactionsFile(
			RandomAccessFile in) throws IOException, NumberFormatException, ParseException {
		ArrayList<Transaction> list = new ArrayList<Transaction>();
		in.seek(0);
		while(in.getFilePointer() < in.length()){
			list.add(
					new Transaction(
							Integer.parseInt(in.readLine()), 
							Integer.parseInt(in.readLine()),
							in.readLine(),
							Integer.parseInt(in.readLine()),
							Double.parseDouble(in.readLine()),
							DataHandler.dateFormat.parse(in.readLine())
							)
					);
		}
		return list;
	}
	
	/**
	 * This method deletes the data from the shares file.
	 */
	public static void cleanSharesFile(){
		try {
			shares = new RandomAccessFile("shares", "rw");
			shares.setLength(0);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * This method deletes the data from the companies file
	 */
	public static void cleanCompanyFile(){
		try {
			companies = new RandomAccessFile("companies", "rw");
			companies.setLength(0);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

