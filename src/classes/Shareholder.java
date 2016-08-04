package classes;

/**
 * This class allows the creation of the Shareholder object to be used in the program 
 * @author carlosgrivera
 *
 */
public class Shareholder {
	private int shareholderId;
	private String shareholderName;
	private boolean shareHolderActive;
	
	/**
	 * Shareholder constructor
	 * @param shareholderId the shareholder's id
	 * @param shareholderName the shareholder's name
	 */
	public Shareholder(int shareholderId, String shareholderName) {
		super();
		this.shareholderId = shareholderId;
		this.shareholderName = shareholderName;
		this.shareHolderActive = true;
	}

	/**
	 * Shareholder Constructor
	 * @param shareholderId the shareholder's id
	 * @param shareholderName the shareholder's name
	 * @param shareHolderActive determines if the shareholder can be used in the program
	 */
	public Shareholder(int shareholderId, String shareholderName, boolean shareHolderActive) {
		super();
		this.shareholderId = shareholderId;
		this.shareholderName = shareholderName;
		this.shareHolderActive = shareHolderActive;
	}

	/**
	 * Gets the ID of the selected shareholder 
	 * @return shareholder id
	 */
	public int getShareholderId() {
		return shareholderId;
	}

	/**
	 * Gets the name of the selected shareholder
	 * @return shareholder's name
	 */
	public String getShareholderName() {
		return shareholderName;
	}

	/**
	 * Returns true if the shareholder exists or false if the shareholder does not exist 
	 * @return true if the shareholder exists or false if the shareholder does not exist 
	 */
	public boolean isShareHolderActive() {
		return shareHolderActive;
	}

	/**
	 * Removes the shareholder from the project 
	 */
	public void setInactive() {
		this.shareHolderActive = false;
	}

	
	
	
	
	
}
