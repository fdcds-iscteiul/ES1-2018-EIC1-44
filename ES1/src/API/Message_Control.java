package API;

import java.io.IOException;
import java.util.ArrayList;

import javax.mail.MessagingException;

public class Message_Control {
	
	private ArrayList<API_Message> mess = new ArrayList<>() ;

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
	
	private void copylist (ArrayList<API_Message> api) {
		for(int i=0;i<api.size();i++) {
			mess.add(api.get(i));
		}
		
	}
}


