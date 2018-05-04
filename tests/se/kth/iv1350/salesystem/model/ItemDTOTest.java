package se.kth.iv1350.salesystem.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

public class ItemDTOTest {
	private ItemDTO item;
	
	@Before
	public void prepareTest() {
		item = new ItemDTO(new Amount(28.75), 1337, "Tuggummi");
	}
	
	@Test
	public void equalsTest() {
		assertEquals(item, new ItemDTO(new Amount(28.75), 1337, "Tuggummi"));
	}
	
	@Test
	public void notEqualsTest() {
		assertNotEquals(item, new ItemDTO(new Amount(15.90), 1335, "Filmjölk"));
	}
	
	@Test
	public void equalsNullTest() {
		ItemDTO nullItem = null;
		boolean equals = item.equals(nullItem);
		assertEquals(false, equals);
	}
	
	@Test
	public void equalsObjectTest() {
		Object object = new Object();
		boolean equals = item.equals(object);
		assertEquals(false, equals);
	}
}
