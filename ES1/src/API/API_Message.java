package API;

/**
 * 
 * @author Fabio
 *
 *Class formato das mensagens recebidas atraves das aplicações
 *com dois tipos de construtores para mensagens com e sem descriçao  
 */

public class API_Message {

	public String getDescription() {
		return description;
	}
	private String sender;
	private String message;
	private String description;
	
	public API_Message(String sender, String message ) {
		this.sender=sender;
		this.message=message;
	}
	
	
	
	
	public API_Message(String sender, String description, String message) {
this.sender=sender;
this.description=description;
this.message=message;
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
