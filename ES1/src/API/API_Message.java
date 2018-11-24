package API;

import javax.mail.Address;

public class API_Message {

	private String sender;
	private String message;
	
	public API_Message(String sender, String message ) {
		this.sender=sender;
		this.message=message;
	}
	
	
	
	
	public API_Message(String sender, String description, String message) {
		// TODO Auto-generated constructor stub
	}




	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
