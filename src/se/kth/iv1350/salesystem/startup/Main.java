package se.kth.iv1350.salesystem.startup;

import se.kth.iv1350.salesystem.controller.Controller;
import se.kth.iv1350.salesystem.view.TotalRevenueView;
import se.kth.iv1350.salesystem.view.View;

public class Main {
	
	/**
	 * Starts the application. 
	 * @param args The application does not take any command line parameters.
	 */
	public static void main(String[] args) {
		Controller controller = new Controller();
		controller.addTotalRevenueObserver(new TotalRevenueView());
		View view = new View(controller);
		
		view.sampleExecution();
	}
}
