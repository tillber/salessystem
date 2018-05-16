package se.kth.iv1350.salesystem.controller;

import se.kth.iv1350.salesystem.integration.AccountingSystem;
import se.kth.iv1350.salesystem.integration.DBConnectionException;
import se.kth.iv1350.salesystem.integration.InventorySystem;
import se.kth.iv1350.salesystem.integration.ItemNotFoundException;
import se.kth.iv1350.salesystem.model.Amount;
import se.kth.iv1350.salesystem.model.ItemDTO;
import se.kth.iv1350.salesystem.model.Quantity;
import se.kth.iv1350.salesystem.model.Sale;
import se.kth.iv1350.salesystem.model.SaleDTO;
import se.kth.iv1350.salesystem.model.TotalRevenue;
import se.kth.iv1350.salesystem.model.TotalRevenueObserver;

public class Controller {
	
	AccountingSystem accountingSystem;
	InventorySystem inventorySystem;
	Sale sale;
	TotalRevenue totalRevenue = TotalRevenue.getInstance();
	
	/**
	 * Creates a new instance of controller and the external systems.
	 */
	public Controller() {
		this.accountingSystem = new AccountingSystem();
		this.inventorySystem = new InventorySystem();
	}
	
	/**
	 * Add an observer that wants information about the total revenue.
	 * @param observer The observer to be added.
	 */
	public void addTotalRevenueObserver(TotalRevenueObserver observer) {
		totalRevenue.addTotalRevenueObserver(observer);
	}
	
	/**
	 * Creates a new instance of <code>Sale</code>.
	 * @param cashierID the ID of the cashier who starts the sale.
	 */
	public void startSale(int cashierID) {
		this.sale = new Sale(cashierID);
	}
	
	/**
	 * @return the current instance of <code>Sale</code>.
	 */
	public Sale getSale() {
		return sale;
	}
	
	/**
	 * Adds an item to the current <code>Sale</sale>.
	 * @param itemID the ID of the <code>ItemDTO</code>.
	 * @param quantity the <code>Quantity</code> of the item.
	 * @return the current sale.
	 */
	public SaleDTO addItem(int itemID, int quantity) throws ItemNotFoundException{
		sale.addItem(inventorySystem.getItem(itemID), new Quantity(quantity));
		return new SaleDTO(sale);
	}
	
	/**
	 * Calculates the change and stores the <code>Sale</code> in external systems.
	 * @param amount the amount of money that the customer is paying.
	 * @return the change to give back to the customer.
	 */
	public Amount pay(double amount) {
		accountingSystem.logSale(sale);
		inventorySystem.logSale(sale);
		return sale.calculateChange(new Amount(amount));
	}
	
	/**
	 * Calls the printer to print the receipt.
	 */
	public void printReceipt() {
		//Code to print the receipt.
	}
	
	/**
	 * Show the total revenue since the program started.
	 */
	public void showUpdatedTotalRevenue() {
		totalRevenue.updateTotalRevenue(sale.getTotal());
	}
	
	/**
	 * Indicates that all items have been registered and updates the total revenue.
	 */
	public void allItemsRegistered() {
		showUpdatedTotalRevenue();
	}
}
