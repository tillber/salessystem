package se.kth.iv1350.salesystem.model;

import java.time.LocalDateTime;
import java.util.HashMap;

public class Sale {
	
	private HashMap<ItemDTO, Quantity> items = new HashMap<ItemDTO, Quantity>();
	private int noOfArticles = 0;
	private LocalDateTime timeOfSale = null;
	private Amount total = new Amount(0, "SEK");
	private Amount change = new Amount(0, "SEK");
	
	/**
	 * The tax rate that is used when calculating the VAT and gross total.
	 */
	public static final double TAX_RATE = 0.12;
	
	private int cashierID;
	
	/**
	 * Creates a new instance of <code>Sale</code> with a cashier's ID.
	 * @param cashierID the cashier's ID.
	 */
	public Sale(int cashierID) {
		this.cashierID = cashierID;
		storeTimeOfSale();
	}
	
	/**
	 * Creates a new instance of <code>Sale</code> with a cashier's ID, and adds an item to it.
	 * @param cashierID the cashier's ID.
	 * @param item the <code>ItemDTO</code> to add.
	 * @param quantity the <code>Quantity</code> of the <code>ItemDTO</code>.
	 */
	public Sale(int cashierID, ItemDTO item, Quantity quantity) {
		this.cashierID = cashierID;
		items.put(item, quantity);
		noOfArticles = quantity.getQuantity();
		storeTimeOfSale();
	}
	
	/** Adds an item to the sale's item list and updates the number of articles in the sale.
	 * If the list already contains the item, the quantity of the item will be increased.
	 * 
	 * @param item The <code>item</code> to be added to the sale's item list.
	 */
	public void addItem(ItemDTO item, Quantity quantity) {
		if(item != null) {
			if(items.containsKey(item)) {
				items.put(item, items.get(item).add(quantity));
			}else {
				items.put(item, quantity);
			}
			
			noOfArticles += quantity.getQuantity();
			total.setAmount(total.getAmount() + (item.getPrice().getAmount() * quantity.getQuantity()));
		}
	}
	
	/**
	 * Calculates the tax of the total using the <code>TAX_RATE</code>.
	 * @return the VAT (Value added tax) as <code>Amount</code>.
	 */
	public Amount getVAT() {
		return new Amount(TAX_RATE * total.getAmount());
	}
	
	/**
	 * Calculates the gross total.
	 * @return
	 */
	public Amount getGrossTotal() {
		return new Amount((1 - TAX_RATE) * total.getAmount());
	}
	
	/**
	 * @return The cashier's ID (employee number).
	 */
	public int getCashierID() {
		return cashierID;
	}
	
	/**
	 * @return The total price of all the items (incl. VAT)
	 */
	public Amount getTotal() {
		return total;
	}
	
	/**
	 * @return The time when the sale started.
	 */
	public LocalDateTime getTimeOfSale() {
		return timeOfSale;
	}
	
	/**
	 * @return The change to give to the customer.
	 */
	public Amount getChange() {
		return change;
	}
	
	/** 
	 * Stores the current time.
	 */
	public void storeTimeOfSale() {
		timeOfSale = LocalDateTime.now();
	}
	
	/**
	 * Calculates the change that is given back to the customer.
	 * @param amount the <code>Amount</code> of money that the customer paid.
	 * @return the <code>Amount</code> of change that is given back.
	 */
	public Amount calculateChange(Amount amount) {
		change = new Amount(amount.getAmount() - total.getAmount(), "SEK");
		return change;
	}
	
	/**
	 * Returns the total number of articles in the sale
	 * @return The number of articles
	 */
	public int getNoOfArticles() {
		return noOfArticles;
	}
	
	/**
	 * Returns the registered <code>items</code> and their respective quantities. 
	 * @return The items in the sale
	 */
	public HashMap<ItemDTO, Quantity> getItems(){
		return items;
	}
}
