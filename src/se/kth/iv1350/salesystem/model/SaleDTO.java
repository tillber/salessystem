package se.kth.iv1350.salesystem.model;

import java.time.LocalDateTime;
import java.util.HashMap;

public class SaleDTO {

	private HashMap<ItemDTO, Quantity> items = new HashMap<ItemDTO, Quantity>();
	private int noOfArticles = 0;
	private LocalDateTime timeOfSale = null;
	private Amount total = new Amount(0, "SEK");
	private Amount change = new Amount(0, "SEK");
	public static final double TAX_RATE = 0.12;
	private int cashierID;
	
	public SaleDTO(Sale sale) {
		this.cashierID = sale.getCashierID();
		this.items = sale.getItems();
		this.noOfArticles = sale.getNoOfArticles();
		this.timeOfSale = sale.getTimeOfSale();
		this.total = sale.getTotal();
		this.change = sale.getChange();
	}
	
	/**
	 * @return The number of articles in the sale (items times their respective quantity).
	 */
	public int getNoOfArticles() {
		return noOfArticles;
	}
	
	/**
	 * @return The items registered in the sale.
	 */
	public HashMap<ItemDTO, Quantity> getItems(){
		return items;
	}
	
	/**
	 * @return The time when the sale started.
	 */
	public LocalDateTime getTimeOfSale() {
		return timeOfSale;
	}
	
	/**
	 * @return The total price of all the items (incl. VAT)
	 */
	public Amount getTotal() {
		return total;
	}
	
	/**
	 * @return The change to give to the customer.
	 */
	public Amount getChange() {
		return change;
	}
	
	/**
	 * @return The cashier's ID (employee number).
	 */
	public int getCashierID() {
		return cashierID;
	}
}
