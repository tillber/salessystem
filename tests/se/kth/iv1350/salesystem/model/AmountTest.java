package se.kth.iv1350.salesystem.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class AmountTest {
	
	private Amount amount;
	
	@Before
	public void prepareTest() {
		amount = new Amount(4.55, "SEK");
	}
	
	@Test
	public void amountValueTest() {
		double amountVar = amount.getAmount();
		assertEquals(4.55, amountVar, 0);
	}
	
	@Test
	public void amountCurrencyTest() {
		String currency = amount.getCurrency();
		assertEquals("SEK", currency);
	}
}
