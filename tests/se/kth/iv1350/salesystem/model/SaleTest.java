package se.kth.iv1350.salesystem.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import se.kth.iv1350.salesystem.controller.Controller;

public class SaleTest {
	Controller controller;
	Amount total;
	Amount actualTotal;
	double actualVAT;
	
	@Before
	public void prepareTest() {
		controller = new Controller();
		controller.startSale(144);
		controller.addItem(111, 1);
		controller.addItem(302, 1);
		actualVAT = Sale.TAX_RATE * controller.getSale().getTotal().getAmount();
		
	}
	
	@Test
	public void totalTest() {
		total = controller.getSale().getTotal();
		assertEquals(total.getAmount(), 36.9, 0.0);
	}
	
	@Test
	public void vatTest() {
		assertEquals(actualVAT, 4.428, 0);
	}
	
	@Test
	public void addItemTest() {
		if(!controller.getSale().getItems().containsKey(new ItemDTO(112))) {
			controller.addItem(112, 1);
			assertTrue(controller.getSale().getItems().containsKey(new ItemDTO(112)));
		}
	}
	
	@Test
	public void calculateChangeTest() {
		Amount change = controller.getSale().calculateChange(new Amount(100, "SEK"));
		assertEquals(new Amount(100 - 36.9, "SEK"), change);
	}
}
