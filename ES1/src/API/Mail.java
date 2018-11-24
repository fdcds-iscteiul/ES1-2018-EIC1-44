package API;


import java.io.*;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.jsoup.Jsoup;

import com.sun.mail.smtp.SMTPTransport;


public class Mail {

public Mail() throws MessagingException, IOException {
	doit();
}
 
private ArrayList<API_Message> mess = new ArrayList<>() ;


  public void doit() throws MessagingException, IOException {
    Folder folder = null;
    Store store = null ;
    try {
      Properties props = System.getProperties();
      props.setProperty("mail.store.protocol", "imaps");
      props.setProperty("mail.store.port", "993");
      Session session = Session.getDefaultInstance(props, null);
//       session.setDebug(true);
      store = session.getStore("imaps");
      store.connect("imap.gmail.com","es1.2018.eic1.44@gmail.com", "262577136d");
      
      folder = store.getFolder("Inbox");
      
      folder.open(Folder.READ_WRITE);
      Message messages[] = folder.getMessages();
      System.out.println("No of Messages : " + folder.getMessageCount());
      System.out.println("No of Unread Messages : " + folder.getUnreadMessageCount());
      for (int i=0; i < messages.length; ++i) {
        Message msg = messages[i];
        mess.add(new API_Message(msg.getFrom()[0].toString(), msg.getSubject() , msg.getContent().toString()));
      
      
        try {
			System.out.println(getTextFromMessage( msg));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        String from = "unknown";
        if (msg.getReplyTo().length >= 1) {
          from = msg.getReplyTo()[0].toString();
        }
        else if (msg.getFrom().length >= 1) {
          from = msg.getFrom()[0].toString();
        }
//          String filename = "c:/temp/" +  subject;
        msg.setFlag(Flags.Flag.SEEN,true);
      }
    }
    finally {
      if (folder != null) { folder.close(true); }
      if (store != null) { store.close(); }
    }
  }

public void send_message(String conteudo, String sender_email, String header , String subject ) throws MessagingException {
	Properties props = System.getProperties();
    props.put("mail.smtps.host","smtp.gmail.com");
    props.put("mail.smtps.auth","true");
    Session session = Session.getInstance(props, null);
    Message msg = new MimeMessage(session);
    msg.setFrom(new InternetAddress("es1.2018.eic1.44@gmail.com"));;
    msg.setRecipients(Message.RecipientType.TO,
    InternetAddress.parse(sender_email, false));
    msg.setSubject("Heisann "+System.currentTimeMillis());
    msg.setText(conteudo);
    msg.setHeader("X-Mailer", subject);
    msg.setSentDate(new Date());
    SMTPTransport t =
        (SMTPTransport)session.getTransport("smtps");
    t.connect("smtp.gmail.com", "es1.2018.eic1.44@gmail.com", "262577136d");
    t.sendMessage(msg, msg.getAllRecipients());
    System.out.println("Response: " + t.getLastServerResponse());
    t.close();
}


private String getTextFromMessage(Message message) throws Exception {
    if (message.isMimeType("text/plain")){
        return message.getContent().toString();
    }else if (message.isMimeType("multipart/*")) {
        String result = "";
        MimeMultipart mimeMultipart = (MimeMultipart)message.getContent();
        int count = mimeMultipart.getCount();
        for (int i = 0; i < count; i ++){
            BodyPart bodyPart = mimeMultipart.getBodyPart(i);
            if (bodyPart.isMimeType("text/plain")){
                result = result + "\n" + bodyPart.getContent();
                break;  //without break same text appears twice in my tests
            } else if (bodyPart.isMimeType("text/html")){
                String html = (String) bodyPart.getContent();
                result = result + "\n" + Jsoup.parse(html).text();

            }
        }
        return result;
    }
    return "";
}
}