package API;

import java.util.ArrayList;
import java.util.List;
import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.FacebookType;
import com.restfb.types.Post;
import com.restfb.types.User;

/**
 * 
 * @author Fabio
 *
 *Facebook api - Recebe mensagens do facebook,
 * transforma no modo api_message e guarda numa lista
 */
public class Facebook {
	FacebookClient fbClient;
	private ArrayList<API_Message> mess = new ArrayList<API_Message>();

	
	public  Facebook() {
		acess();
		getpost();
		}

	private void acess() {
		String accessToken = "EAADoqB2UXrMBAJnkrDZBAkJuU1hXQ9G4AqDZAXUxYBhPG5n8FpD8yUd2hDMJqJtQlnr1CtW7LOmAqozzPPhOK1FDSWTRL44a7pGzpGsETuAn9vVrFUN3g2dL3ZAZA4SwcuEEfw1zgnRNZBVALpoZAFDeq4vuDZBjLccG12HLjZBqAfZAA1gai7Dr14BGjenclWaaSk5ZARSZAKBVAZDZD";
		fbClient = new DefaultFacebookClient(accessToken);
		User me2 = fbClient.fetchObject("me", User.class);
		System.out.println("Facebook:");
		System.out.println("Id: " + me2.getId());
		System.out.println("Name: " + me2.getName());
	}
	
	private void getpost() {
		Connection<Post> result = fbClient.fetchConnection("me/feed",Post.class);
		System.out.println("\nPosts:");
		int counter5 = 0;
		int counterTotal = 0;
		for (List<Post> page : result) {
			for (Post aPost : page) {
				// Filters only posts that contain the word "Inform"
				if (aPost.getMessage() != null ) {
					System.out.println("---- Post "+ counter5 + " ----");
					System.out.println("Id: "+"fb.com/"+aPost.getId());
					System.out.println("Message: "+aPost.getMessage());
					System.out.println("Created: "+aPost.getCreatedTime());
					mess.add(new API_Message(aPost.getId(), aPost.getMessage()));
					counter5++;
				}
				counterTotal++;
			}
		}
		System.out.println("-------------\nNº of Results: " + counter5+"/"+counterTotal);			
	}
	
	public void send(String a , String b) {
		fbClient.publish("PAGE_NAME/feed", FacebookType.class, Parameter.with(a,b));
	}
	
	public ArrayList<API_Message> getMess() {
		return mess;
	}


	

}
