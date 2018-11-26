package API;

import java.io.IOException;
import java.util.ArrayList;

import javax.mail.MessagingException;
import javax.swing.DefaultListModel;

public class Message_Control {
	
	private ArrayList<API_Message> mess = new ArrayList<>() ;
	private DefaultListModel<String> sender;
	private DefaultListModel<String> message;
	private DefaultListModel<String> description;
	/**
	 * Classe de controlo de mensagens API 
	 */
	public Message_Control() {
		Facebook face = new Facebook();
		copylist(face.getMess());
		
		try {
			Mail mail = new Mail();
			copylist(mail.getMess());
		} catch (MessagingException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		TwitterMain twitter = new TwitterMain();
		copylist(twitter.getMess());
	}
	/***
	 * Void copyList, adiciona o conteudo da lista API a uma lista secund�ria
	 * @param api
	 */
	private void copylist (ArrayList<API_Message> api) {
		for(int i=0;i<api.size();i++) {
			mess.add(api.get(i));
			description.addElement(api.get(i).getDescription());
			message.addElement(api.get(i).getMessage());
			sender.addElement(api.get(i).getSender());
		
		
	}
}
}

