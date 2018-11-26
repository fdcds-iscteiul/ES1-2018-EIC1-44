package API;

import java.util.ArrayList;
import java.util.List;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 * 
 * @author Fabio
 *
 *Twitter api - Recebe mensagens do twitter,
 * transforma no modo api_message e guarda numa lista
 */


public final class TwitterMain  {
	private Twitter twitter;
	private ArrayList<API_Message> mess = new ArrayList<API_Message>();
	


	public TwitterMain() {
		

        try {
        	ConfigurationBuilder cb = new ConfigurationBuilder();
        	cb.setDebugEnabled(true)
        	  .setOAuthConsumerKey("D84ryBw4offC2D42qe8TRqYYc")
        	  .setOAuthConsumerSecret("1055488325426073606-BYZbbqAjRP2vadMBTRzRxhPySI8MBN")
        	  .setOAuthAccessToken("1055488325426073606-0ZUoyoMbAhiOKiuHT05FlrxXq5NJ2G")
        	  .setOAuthAccessTokenSecret("FWlCy2INzzYIm8OvepSHKrTomvy80wATbmnx5MdScD3ne ");
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
					mess.add(new API_Message(status.getUser().getName(), status.getText()));
					counter++;
				}
				counterTotal++;
            }
    		System.out.println("-------------\nNº of Results: " + counter+"/"+counterTotal);
        } catch (Exception e) { System.out.println(e.getMessage()); }
     }
	
	
/**
 * 
 * @param mensagem
 * Funçao para publicar uma mensagem 
 */
	public ArrayList<API_Message> getMess() {
		return mess;
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
    
