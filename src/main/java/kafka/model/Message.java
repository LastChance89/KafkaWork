package main.java.kafka.model;

public class Message {

	private String message; 
	private int number;
	private String testMessage;
	
	public Message(String message) {
		this.message = message; 
	}
	public Message(String message, String testMessage) {
		this.message = message; 
		this.testMessage = testMessage;
	}
	public Message( int number) {
		this.number = number; 
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	} 

	@Override 
	public String toString() {
		return "TESTING :  " + message + " " + testMessage; 
	}
	
	
	
}
