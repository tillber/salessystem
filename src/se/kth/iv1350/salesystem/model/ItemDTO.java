package se.kth.iv1350.salesystem.model;

public class ItemDTO {
	
	private Amount price = new Amount(0);
	private int identifier;
	private String name;
	
	/**
	 * Creates an <code>ItemDTO</code> with the given price, identifier and name.
	 * @param price the price of the item
	 * @param identifier the identifier of the item
	 * @param name the name of the item
	 */
	public ItemDTO(Amount price, int identifier, String name) {
		this.price = price;
		this.identifier = identifier;
		this.name = name;
	}
	
	/**
	 * Creates an <code>ItemDTO</code> with the given price and identifier.
	 * @param price the price of the item
	 * @param identifier the identifier of the item
	 */
	public ItemDTO(Amount price, int identifier) {
		this.price = price;
		this.identifier = identifier;
	}
	
	/**
	 * Creates an <code>ItemDTO</code> with the given identifier.
	 * @param identifier the identifier of the item
	 */
	public ItemDTO(int identifier) {
		this.identifier = identifier;
	}	
	
	/**
	 * Generates a hashcode for any instance of <code>Amount</code>.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + identifier;
		return result;
	}
	
	/**
	 * Compares an instance of <code>Amount</code> with another <code>Object</code>.
	 */
	@Override
	public boolean equals(Object obj) {
		try {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			ItemDTO other = (ItemDTO) obj;
			if (identifier != other.identifier)
				return false;
			return true;
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * @return the price of the <code>ItemDTO</code>
	 */
	public Amount getPrice() {
		return this.price;
	}
	
	/**
	 * @return the identifier of the <code>ItemDTO</code>
	 */
	public int getIdentifier() {
		return identifier;
	}

	/**
	 * @return the name of the <code>ItemDTO</code>
	 */
	public String getName() {
		return name;
	}

}
