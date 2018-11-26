package API;

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
	public  Facebook() {
	
		
		String accessToken = "EAADoqB2UXrMBALiUSXd4BWHHgGDfgRJ5VCCBtvsw7LTwBn2sA05CwCgb8N9FdZBUVAyvet6NeCFjL43ZCLkBM4il5Mk5WpZCj8OPWarH6bZA7bZA0FLM9xQX3yknfxVYW8Od2H1LRwgtFGzvNZC8w2nAKSCNpLtAouBnaPse5WpTvWaanCy2hbohaSXvEAil8TCn3OxI4JjAZDZD";
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
					counter5++;
				}
				counterTotal++;
			}
		}
		System.out.println("-------------\nNº of Results: " + counter5+"/"+counterTotal);		
	}
	

}
