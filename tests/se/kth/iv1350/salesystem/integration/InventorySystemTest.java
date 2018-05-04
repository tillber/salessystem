package se.kth.iv1350.salesystem.integration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

import se.kth.iv1350.salesystem.model.Amount;
import se.kth.iv1350.salesystem.model.ItemDTO;

public class InventorySystemTest {
	private ItemDTO itemToFind;
	private InventorySystem inventorySystem;
	
	@Before
	public void prepareTest() {
		inventorySystem = new InventorySystem();
	}
	
	@Test
	public void getItemNonExistingTest() {
		itemToFind = new ItemDTO(new Amount(28.75), 1337, "GB Bigpack");
		ItemDTO itemToExpect = new ItemDTO(new Amount(28.75), 1337, "GB Bigpack");
		assertNotEquals(itemToExpect, inventorySystem.getItem(itemToFind.getIdentifier()));
	}
	
	@Test
	public void getItemExistingTest() {
		itemToFind = new ItemDTO(111);
		ItemDTO itemToExpect = new ItemDTO(new Amount(7.00), 111, "Äpple");
		assertEquals(itemToExpect, inventorySystem.getItem(itemToFind.getIdentifier()));
	}
	
	@Test
	public void itemExistsTest() {
		itemToFind = new ItemDTO(1337);
		assertEquals(false, inventorySystem.itemExists(itemToFind.getIdentifier()));
	}
}
