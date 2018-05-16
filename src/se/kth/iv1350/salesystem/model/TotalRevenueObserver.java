package se.kth.iv1350.salesystem.model;

/**
 * Notified when the current sale ({@link SaleDTO}) is updated.
 * @author tillber
 */
public interface TotalRevenueObserver {
	/**
	 * Called when the sale is updated.
	 * @param sale The updated sale.
	 */
	void totalRevenueUpdated(Amount totalRevenue);
}
