package se.kth.iv1350.salesystem.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Acts as a counter which keeps track of the total revenue.
 * @author tillber
 *
 */
public class TotalRevenue {
	private Amount currentTotalRevenue= new Amount(0);
	private List<TotalRevenueObserver> totalRevenueObservers = new ArrayList<>();
	private static final TotalRevenue TOTAL_REVENUE = new TotalRevenue();
	
	private TotalRevenue() {}
	
	/**
	 * Returns the only instance of this singleton class.
	 * @return The instance of TotalRevenue.
	 */
	public static TotalRevenue getInstance() {
		return TOTAL_REVENUE;
	}
	
	/**
	 * Returns the total revenue since the program started.
	 * @return Amount The total revenue.
	 */
	public Amount getTotalRevenue() {
		return currentTotalRevenue;
	}
	
	/**
	 * The specified observer will be notified whenever the total revenue is updated.
	 * @param observer The observer to notify when the total revenue is updated.
	 */
	public void addTotalRevenueObserver(TotalRevenueObserver observer) {
		totalRevenueObservers.add(observer);
	}
	
	/**
	 * The total revenue is updated and all observers are notified.
	 * @param total The total from the last sale to increase the current total revenue with.
	 */
	public void updateTotalRevenue(Amount total) {
		currentTotalRevenue = new Amount(currentTotalRevenue.getAmount() + total.getAmount());
		notifyObservers();
	}
	
	private void notifyObservers() {
		for(TotalRevenueObserver observer : totalRevenueObservers) {
			observer.totalRevenueUpdated(currentTotalRevenue);
		}
	}
}
