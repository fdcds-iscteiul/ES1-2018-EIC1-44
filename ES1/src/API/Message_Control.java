package API;

import java.io.IOException;
import java.util.ArrayList;

import javax.mail.MessagingException;
import javax.swing.DefaultListModel;

public class Message_Control {
	
	private ArrayList<API_Message> mess = new ArrayList<>() ;
	private DefaultListModel<String> sender= new DefaultListModel<>();
	private DefaultListModel<String> message= new DefaultListModel<>();
	private DefaultListModel<String> description= new DefaultListModel<>();

	

	public Message_Control() {
//		Facebook face = new Facebook();
//		copylist(face.getMess());
//		
		try {
			Mail mail = new Mail();
			copylist(mail.getMess());
		} catch (MessagingException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		
//		TwitterMain twitter = new TwitterMain();
//		copylist(twitter.getMess());
	}
	
	public ArrayList<API_Message> getMess() {
		return mess;
	}

	public DefaultListModel<String> getSender() {
		return sender;
	}

	public DefaultListModel<String> getMessage() {
		return message;
	}

	public DefaultListModel<String> getDescription() {
		return description;
	}
	
	private void copylist (ArrayList<API_Message> api) {
		for(int i=0;i<api.size();i++) {
			mess.add(api.get(i));
			description.addElement(api.get(i).getDescription());
			message.addElement(api.get(i).getMessage());
			sender.addElement(api.get(i).getSender());
		}
		
	}
}


