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
		connect();
		getmessages();
 }
	
	
	
	private void connect(){
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
		  .setOAuthConsumerKey("71cQL8CmbvYdndp0533asHeTk")
		  .setOAuthConsumerSecret("Xg2dLgriwdJHKzighsH8aU0scMl5fflayJcgRmvIbAWCoEAS92 ")
		  .setOAuthAccessToken("1055488325426073606-XQrSY0vZNltI7Yv4u1uR4nThIdT49v")
		  .setOAuthAccessTokenSecret("25lpGkUEAZXDoApn2MeLCCRqRfUf6KeAoSYgFCqFL9rVm");
		TwitterFactory tf = new TwitterFactory(cb.build());
		twitter = tf.getInstance();
		
	}
	
	
	private void getmessages() {
		

        try {
        	
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
    
