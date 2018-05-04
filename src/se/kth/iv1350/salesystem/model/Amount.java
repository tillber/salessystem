package se.kth.iv1350.salesystem.model;

public class Amount {
	private String currency;
	private double amount;
	
	/**
	 * Creates a new instance of <code>Amount</code> with a given amount.
	 * @param amount the amount to store.
	 */
	public Amount(double amount) {
		this.amount = amount;
	}
	
	/**
	 * Creates a new instance of <code>Amount</code> with a given amount and currency.
	 * @param amount the amount to store.
	 * @param currency the currency of the amount.
	 */
	public Amount(double amount, String currency) {
		this.amount = amount;
		this.currency = currency;
	}
	
	/** Gets the amount.
	 * 
	 * @return Returns the <code>amount</code>.
	 */
	public double getAmount() {
		return this.amount;
	}
	
	/** Gets the currency.
	 * 
	 * @return Returns the <code>currency</code>.
	 */
	public String getCurrency() {
		return this.currency;
	}
	
	/** Sets the amount.
	 * 
	 * @param The new <code>amount</code> to be set.
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	/**
	 * 
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((currency == null) ? 0 : currency.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Amount other = (Amount) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (currency == null) {
			if (other.currency != null)
				return false;
		} else if (!currency.equals(other.currency))
			return false;
		return true;
	}

	/** Sets the currency.
	 * 
	 * @param The new <code>currency</code> to be set.
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	/**
	 * Format of <code>Amount</code> to string.
	 */
	public String toString() {
		return Double.toString(amount);
	}
}
