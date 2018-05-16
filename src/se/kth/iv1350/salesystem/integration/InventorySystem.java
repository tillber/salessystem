package se.kth.iv1350.salesystem.integration;

import java.util.ArrayList;
import java.util.List;

import se.kth.iv1350.salesystem.model.Amount;
import se.kth.iv1350.salesystem.model.ItemDTO;
import se.kth.iv1350.salesystem.model.Sale;

public class InventorySystem {
	private List<ItemDTO> items = new ArrayList<ItemDTO>();
	
	/**
	 * Creates a new instance of <code>InventorySystem</code> 
	 */
	public InventorySystem() {
		items.add(new ItemDTO(new Amount(5.00), 110, "Banan"));
		items.add(new ItemDTO(new Amount(7.00), 111, "Äpple"));
		items.add(new ItemDTO(new Amount(6.00), 112, "Päron"));
		items.add(new ItemDTO(new Amount(11.90), 281, "Mellanmjölk 1l"));
		items.add(new ItemDTO(new Amount(24.50), 294, "Margarin 500g"));
		items.add(new ItemDTO(new Amount(32.90), 297, "Mjöl 1kg"));
		items.add(new ItemDTO(new Amount(29.90), 302, "Spaghetti 500g"));
	}
	
	/**
	 * Checks if an item with the given ID is existing in the inventory.
	 * @param itemID the ID of the  {@link ItemDTO} to check existence of
	 * @return boolean
	 * @throws ItemNotFoundException
	 */
	public boolean itemExists(int itemID) {
		if(items.contains(new ItemDTO(itemID))){
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * Returns an item if it exists in the inventory.
	 * @param itemID the ID of the item to retrieve
	 * @return <code>ItemDTO</code> The item that is collected from the item registry.
	 * @throws ItemNotFoundException 
	 */
	public ItemDTO getItem(int itemID) throws ItemNotFoundException, DBConnectionException {
		if(new ItemDTO(itemID).equals(new ItemDTO(999))) {
			throw new DBConnectionException();
		}else {
			if(itemExists(itemID)) {
				return items.get(items.indexOf(new ItemDTO(itemID)));
			}else {
				throw new ItemNotFoundException(new ItemDTO(itemID));
			}
		}
	}
	
	/**
	 * Logs the sale/updates the inventory data.
	 * @param sale the sale to log
	 */
	public void logSale(Sale sale) {
		//Code to log completed sale to database.
	}
}
