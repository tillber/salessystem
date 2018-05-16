package se.kth.iv1350.salesystem.integration;

import java.util.Date;

public class DBConnectionException extends RuntimeException {
	/**
	 * Creates an instance, and sends information up to the superclass (in this case {@link RuntimeException}).
	 */
	public DBConnectionException() {
		super("Could not establish connection to database! Please verify your network connection, database credentials and contact support.");
	}
	
	/**
	 * Returns a messages that is supposed to be written in a log file.
	 * @return The message for the log.
	 */
	public String getLogMessage() {
		StringBuilder logOutput = new StringBuilder();
		logOutput.append(new Date().toString() + " DBConnectionException was thrown: ");
		return logOutput.toString();
	}
}
