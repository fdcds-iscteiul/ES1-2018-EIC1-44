package API;

import java.util.List;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;



public final class TwitterMain  {
	public TwitterMain() {
		

		// http://twitter4j.org
		// http://twitter4j.org/en/code-examples.html
		// https://www.youtube.com/watch?v=uYPmkzMpnxw
        try {
        	ConfigurationBuilder cb = new ConfigurationBuilder();
        	cb.setDebugEnabled(true)
        	  .setOAuthConsumerKey("NH3ohDmdbj3AAYtR8yPshwH1c")
        	  .setOAuthConsumerSecret("4ELUtYI0pL7XLX4Ju7mzUKKRXvJvviejwcAAkZsSgHIdQbd6P0")
        	  .setOAuthAccessToken("1055488325426073606-DlZjGTd95iW8HEEWoC2zX9Vt0ISis7")
        	  .setOAuthAccessTokenSecret("g9voSGZmJdxyGe9PhUcRJGSXV8J0WU4nwb6gkpNOft3rP");
        	TwitterFactory tf = new TwitterFactory(cb.build());
        	Twitter twitter = tf.getInstance();        		
            List<Status> statuses = twitter.getHomeTimeline();
            System.out.println("------------------------\n Showing home timeline \n------------------------");
    		int counter=0;
    		int counterTotal = 0;
            for (Status status : statuses) {
				// Filters only tweets from user "catarina"
				if (status.getUser().getName() != null ) {
					System.out.println(status.getUser().getName() + ":" + status.getText());
					counter++;
				}
				counterTotal++;
            }
    		System.out.println("-------------\nNº of Results: " + counter+"/"+counterTotal);
        } catch (Exception e) { System.out.println(e.getMessage()); }
     }
}
    
