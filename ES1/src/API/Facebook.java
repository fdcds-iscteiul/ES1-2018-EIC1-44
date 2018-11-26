package API;

import java.util.ArrayList;
import java.util.List;
import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
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
	FacebookClient fbClient2;
	private ArrayList<API_Message> mess = new ArrayList<API_Message>();
	
	public  Facebook() {
	
		
		String accessToken = "EAADoqB2UXrMBAMN6GkfvzLTgLEzdlNjLuid4tiV6dLZAlBD08mC7VmfXCw5GeQ83B0KZB0crp1iTXrFRQEqNT4AqilvkXJhm4IPKEEXQ2T4suKybuc4Pl8gouF5mcpoBKBHhA96g4BcJn9lCvkOaYXX4ZBXJrrxoXMZB3akZAgZAbtzb8Gh6DKhyrbIZCGfNh8FDrF820Ti0QZDZD";
		fbClient2 = new DefaultFacebookClient(accessToken);
		User me2 = fbClient2.fetchObject("me", User.class);
		System.out.println("Facebook:");
		System.out.println("Id: " + me2.getId());
		System.out.println("Name: " + me2.getName());
	
		Connection<Post> result = fbClient2.fetchConnection("me/feed",Post.class);
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

	public ArrayList<API_Message> getMess() {
		return mess;
	}


	

}
