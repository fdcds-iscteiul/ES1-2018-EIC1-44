package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.TextField;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class EmailGUI {

	private String message;
	private String description;
	private String sender;
	private JFrame frame;

	public EmailGUI(String sender , String description , String message) {
		this.message=message;
		System.out.println(message);
		this.description=description;
		this.sender=sender;
		frame=new JFrame();
		run();
	}

	private void run() {
		frame.setSize(500, 500);
		JPanel panel = new JPanel(new BorderLayout());
		
		TextField a_sender= new TextField(sender);
		a_sender.setEditable(false);
		a_sender.setSize(100, 100);
		panel.add(a_sender, BorderLayout.NORTH);
		
		TextField a_description = new TextField(description);
		a_description.setEditable(false);
		a_description.setSize(100, 100);
		panel.add(a_description, BorderLayout.WEST);
		
		String a = message.trim();
		TextField a_message = new TextField(a);
		a_message.setEditable(false);
		a_message.setSize(50, 50);
		panel.add(a_message, BorderLayout.CENTER);
		
		
		
		frame.add(panel);
		frame.setVisible(true);
		frame.validate();

	}

}
