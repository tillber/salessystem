package se.kth.iv1350.salesystem.view;

import se.kth.iv1350.salesystem.model.Amount;
import se.kth.iv1350.salesystem.model.SaleDTO;
import se.kth.iv1350.salesystem.model.TotalRevenueObserver;

public class TotalRevenueView implements TotalRevenueObserver{
	
	/**
	 * Prints out the total revenue to the system console.
	 * @param totalRevenue
	 */
	public void printTotalRevenue(Amount totalRevenue) {
		System.out.println("\nTOTAL REVENUE: " + totalRevenue.toString() + "\n");
	}
	
	/**
	 * Indicates that the total revenue is updated and prints it out.
	 */
	@Override
	public void totalRevenueUpdated(Amount totalRevenue) {
		printTotalRevenue(totalRevenue);
	}
}
