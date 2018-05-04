package se.kth.iv1350.salesystem.view;

import se.kth.iv1350.salesystem.controller.Controller;
import se.kth.iv1350.salesystem.model.SaleDTO;

public class View {
	
	private Controller controller;
	private SaleDTO sale; //The sale whose information is displayed on POS (not taken care of)
	
	/**
	 * Creates a new instance of <code>View</code> with a given <code>Controller</code>.
	 * @param controller the given <code>Controller</code>.
	 */
	public View(Controller controller) {
		this.controller = controller;
	}
	
	/**
	 * Simulates a sale where the customer purchases three items.
	 */
	public void sampleExecution() {
		controller.startSale(313);
		
		sale = controller.addItem(111, 1);		
		sale = controller.addItem(297, 3);	
		sale = controller.addItem(302, 1);		
		controller.allItemsRegistered();
		
		controller.pay(140);		
		controller.printReceipt();
	}
}

