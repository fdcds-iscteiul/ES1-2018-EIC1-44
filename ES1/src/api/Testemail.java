package api;

import java.io.*;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class Testemail {

  public Testemail() {}

  //
  // inspired by :
  // http://www.mikedesjardins.net/content/2008/03/using-javamail-to-read-and-extract/
  //

  public static void doit() throws MessagingException, IOException {
    Folder folder = null;
    Store store = null;
    try {
      Properties props = System.getProperties();
      props.setProperty("mail.store.protocol", "imaps");
      props.setProperty("mail.store.port", "993");
      Session session = Session.getDefaultInstance(props, null);
//       session.setDebug(true);
      store = session.getStore("imaps");
      store.connect("imap.gmail.com","es1.2018.eic1.44@gmail.com", "262577136d");
      folder = store.getFolder("Inbox");
      /* Others GMail folders :
       * [Gmail]/All Mail   This folder contains all of your Gmail messages.
       * [Gmail]/Drafts     Your drafts.
       * [Gmail]/Sent Mail  Messages you sent to other people.
       * [Gmail]/Spam       Messages marked as spam.
       * [Gmail]/Starred    Starred messages.
       * [Gmail]/Trash      Messages deleted from Gmail.
       */
      folder.open(Folder.READ_WRITE);
      Message messages[] = folder.getMessages();
      System.out.println("No of Messages : " + folder.getMessageCount());
      System.out.println("No of Unread Messages : " + folder.getUnreadMessageCount());
      for (int i=0; i < messages.length; ++i) {
        System.out.println("MESSAGE #" + (i + 1) + ":");
        Message msg = messages[i];
        /*
          if we don''t want to fetch messages already processed
          if (!msg.isSet(Flags.Flag.SEEN)) {
             String from = "unknown";
             ...
          }
        */
        String from = "unknown";
        if (msg.getReplyTo().length >= 1) {
          from = msg.getReplyTo()[0].toString();
        }
        else if (msg.getFrom().length >= 1) {
          from = msg.getFrom()[0].toString();
        }
        String subject = msg.getSubject();
        System.out.println("Saving ... " + subject +" " + from);
        // you may want to replace the spaces with "_"
        // the TEMP directory is used to store the files
        String filename = "c:/temp/" +  subject;
        msg.setFlag(Flags.Flag.SEEN,true);
        // to delete the message
        // msg.setFlag(Flags.Flag.DELETED, true);
      }
    }
    finally {
      if (folder != null) { folder.close(true); }
      if (store != null) { store.close(); }
    }
  }

 

  public static void main(String args[]) throws Exception {
    Testemail.doit();
  }
}