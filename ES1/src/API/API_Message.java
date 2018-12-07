package API;

/**
 * 
 * @author Fabio
 *
 *Class formato das mensgens recebidas atraves das aplica��es
 *com dois tipos de construtores para mensagens com e sem descri�ao  
 */

public class API_Message {

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

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
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
