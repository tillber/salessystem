package se.kth.iv1350.salesystem.integration;

import java.util.Date;

import se.kth.iv1350.salesystem.model.ItemDTO;

public class ItemNotFoundException extends Exception{
	private ItemDTO itemThatCanNotBeFound;
	
	/**
	 * Creates a new instance with a message specifying for which item that could not be found.
	 * @param itemThatCanNotBeFound The item that could not be found.
	 */
	public ItemNotFoundException(ItemDTO itemThatCanNotBeFound) {
		super("Unable to find item #" + itemThatCanNotBeFound.getIdentifier() + ", in the item registry. Please check the condition of the barcode and try again!");
		this.itemThatCanNotBeFound = itemThatCanNotBeFound;
	}
	
	/**
	 * @return The item that could not be found.
	 */
	public int getIDOfItemThatCanNotBeFound() {
		return itemThatCanNotBeFound.getIdentifier();
	}
	
	/**
	 * Returns the correctly formatted log message, that should be printed to the development log.
	 * @return String The log message.
	 */
	public String getLogMessage() {
		StringBuilder logOutput = new StringBuilder();
		logOutput.append(new Date().toString() + " ItemNotFoundException was thrown: ");
		return logOutput.toString();
	}
}
