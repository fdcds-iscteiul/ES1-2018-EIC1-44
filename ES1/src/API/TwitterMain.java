package API;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;



public final class TwitterMain  {
	private Twitter twitter;
	private ArrayList<API_Message> api_message = new ArrayList<API_Message>();
	public TwitterMain() {
		

        try {
        	ConfigurationBuilder cb = new ConfigurationBuilder();
        	cb.setDebugEnabled(true)
        	  .setOAuthConsumerKey("okgos8Ccxc92AXhHrYPuM2yVt")
        	  .setOAuthConsumerSecret("pCG9PnI57rmA0uit6YyXIm4YWX69C3qARO7WXbVOyND1LQ2D6M")
        	  .setOAuthAccessToken("1055488325426073606-0ZUoyoMbAhiOKiuHT05FlrxXq5NJ2G")
        	  .setOAuthAccessTokenSecret("lBczHKjIw5XBPv7JPpa2e4swqsr2BmrkrMbjABuEXI6SK");
        	TwitterFactory tf = new TwitterFactory(cb.build());
        	twitter = tf.getInstance();
        	
            List<Status> statuses = twitter.getHomeTimeline();
            System.out.println("------------------------\n Showing home timeline \n------------------------");
    		int counter=0;
    		int counterTotal = 0;
            for (Status status : statuses) {
				// Filters only tweets from user "catarina"
				if (status.getUser().getName() != null ) {
					System.out.println(status.getUser().getName() + ":" + status.getText());
					api_message.add(new API_Message(status.getUser().getName(), status.getText()));
					counter++;
				}
				counterTotal++;
            }
    		System.out.println("-------------\nNº of Results: " + counter+"/"+counterTotal);
        } catch (Exception e) { System.out.println(e.getMessage()); }
     }
	
	public void Post(String mensagem) {
		try {
			twitter.updateStatus(mensagem);
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
    
