package se.kth.iv1350.salesystem.model.util;

import se.kth.iv1350.salesystem.model.Amount;

public class Util {

	public static final String COMPANY_NAME = "Martins Supermarket";
	public static final int COMPANY_ID = 19981010;
	public static final String HORIZONTAL_LINE = "-------------------------------------------------------";
	
	public static double round(double value) {
		return Math.round(value * 100.00) / 100.00;
	}
	
	public static double round(Amount amount) {
		return Math.round(amount.getAmount() * 100.00) / 100.00;
	}
}
