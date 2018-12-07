package GUI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import API.Message_Control;



public class postwindow {



private JFrame frame;

public postwindow(Message_Control messages) {
	begin(messages);
}

private void begin(Message_Control control){
	frame= new JFrame();
	JPanel p = new JPanel(new BorderLayout());
	
	JTextArea a = new JTextArea();
	JTextArea top = new JTextArea();
	JButton face = new JButton("send_to_face");
	JButton twitter = new JButton("send_to_twitter");
	JButton mail = new JButton("send_to_mail");
face.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
		control.postface(a.getText() , top.getText());
			
		}
	});
twitter.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
	control.posttw(a.getText() , top.getText());
		
	}
});
mail.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
	control.postmail(a.getText() , top.getText());
		
	}
});
	p.add(top, BorderLayout.NORTH);
	p.add(a, BorderLayout.CENTER);
	p.add(face, BorderLayout.SOUTH);
	p.add(mail, BorderLayout.WEST);
	p.add(twitter, BorderLayout.EAST);
	frame.setSize(200, 200);
	frame.add(p);
	frame.setVisible(true);
}
}