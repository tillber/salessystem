package se.kth.iv1350.salesystem.view;

import java.io.PrintWriter;
import java.io.StringWriter;

import se.kth.iv1350.salesystem.controller.Controller;
import se.kth.iv1350.salesystem.integration.DBConnectionException;
import se.kth.iv1350.salesystem.integration.ItemNotFoundException;
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
	public void sampleExecution(){
		//Sale that will cause an ItemNotFoundException
		controller.startSale(313);
		System.out.println("A new sale started!");
		
		addItem(123123, 24); //Item that doesn't exist.		
		addItem(111,3);
		addItem(302,1);
		
		controller.allItemsRegistered();
		System.out.println("All items registered!");
		
		controller.pay(140);		
		controller.printReceipt();
		System.out.println("Receipt was printed.\n");
		
		//Sale that will cause an DBConnectionException
		controller.startSale(3);
		System.out.println("A new sale started!");
		
		addItem(111, 24);		
		addItem(999,3); //itemID #999 will cause an DBConnectionException to be thrown.
		addItem(302,1);
		
		controller.allItemsRegistered();
		System.out.println("All items registered!");
		
		controller.pay(140);	
		controller.printReceipt();
		System.out.println("Receipt was printed.\n");
	}
	
	//Just to eliminate code copying.
	private void addItem(int itemID, int quantity) {
		System.out.println("Scanned item #" + itemID);
		try {
			sale = controller.addItem(itemID, quantity);
			System.out.println("Added item #" + itemID + " to the sale.");
		} catch (ItemNotFoundException e) {
			printErrorMessages(e);
		} catch (DBConnectionException e) {
			printErrorMessages(e);
		}
	}
	
	private void printErrorMessages(DBConnectionException e) {
		System.out.println("[USER INTERFACE]: " + e.getMessage());
		System.out.println("[DEVLOG]: " + e.getLogMessage());
		
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		e.printStackTrace(pw);
		System.out.println(sw.toString());
	}
	
	private void printErrorMessages(ItemNotFoundException e) {
		System.out.println("[USER INTERFACE]: " + e.getMessage());
		System.out.println("[DEVLOG]: " + e.getLogMessage());
		
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		e.printStackTrace(pw);
		System.out.println(sw.toString());
	}
}

