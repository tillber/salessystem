package se.kth.iv1350.salesystem.model;

public class Quantity {
	private int quantity;
	
	/**
	 * Creates a new instance of <code>Quantity</code> with a given integer.
	 * @param quantity the given integer.
	 */
	public Quantity(int quantity) {
		this.quantity = quantity;
	}
	
	/**
	 * Creates a new instance of <code>Quantity</code> with a given <code>Quantity</code>.
	 * @param quantity the given <code>Quantity</code>.
	 */
	public Quantity(Quantity quantity) {
		this.quantity = quantity.getQuantity();
	}
	
	/**
	 * Creates a new instance of <code>Quantity</code> and sets the <code>quantity</code> to zero.
	 */
	public Quantity() {
		quantity = 0;
	}
	
	/**
	 * Gets the current quantity.
	 * @return <code>quantity</code>
	 */
	public int getQuantity() {
		return quantity;
	}
	
	/**
	 * Sets the <code>quantity</code> to an integer.
	 * @param quantity The integer to set <code>quantity</code> to.
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	/**
	 * Increases <code>quantity</code> with an integer.
	 * @param quantity The integer to increase with.
	 */
	public void increaseQuantity(int quantity) {
		this.quantity += quantity;
	}
	
	/**
	 * Increases <code>quantity</code> with another Quantity.
	 * @param quantity The Quantity to increase with.
	 */
	public void increaseQuantity(Quantity quantity) {
		this.quantity += quantity.getQuantity();
	}
	
	/**
	 * Increases <code>quantity</code> by 1.
	 */
	public void increaseQuantity() {
		this.quantity++;
	}
	
	/**
	 * Adds two <code>Quantity</code> objects together.
	 * @param quantity the <code>Quantity</code> to increase with.
	 * @return the sum of the two <code>Quantity</code> objects.
	 */
	public Quantity add(Quantity quantity) {
		return new Quantity(this.quantity + quantity.getQuantity());
	}
	
	/**
	 * Generates a hashcode for any instance of <code>Quantity</code>.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + quantity;
		return result;
	}

	/**
	 * Compares an instance of <code>Quantity</code> with another <code>Object</code>.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Quantity other = (Quantity) obj;
		if (quantity != other.quantity)
			return false;
		return true;
	}
}
