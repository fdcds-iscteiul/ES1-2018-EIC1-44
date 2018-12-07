package GUI;

import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;

import API.Message_Control;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.util.LinkedHashSet;
import java.awt.event.ActionEvent;

public class MainWindow {

	JFrame frame;
	Message_Control messages;


	/**
	 * Create the application.
	 */
	public MainWindow(Message_Control messages) {
		this.messages=messages;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JList list = new JList(messages.getSender());
		list.setBounds(18, 40, 93, 190);
		frame.getContentPane().add(list);
		
		JList list_1 = new JList(messages.getDescription());
		list_1.setBounds(120, 40, 93, 190);
		frame.getContentPane().add(list_1);
		JList list_2 = new JList(messages.getMessage());
		list_2.setBounds(220, 40, 209, 190);
		frame.getContentPane().add(list_2);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(32, 19, 68, 16);
		frame.getContentPane().add(lblUsername);

		JLabel lblSubject = new JLabel("Subject");
		lblSubject.setBounds(141, 19, 61, 16);
		frame.getContentPane().add(lblSubject);

		JLabel lblContentPreview = new JLabel("Content Preview");
		lblContentPreview.setBounds(265, 19, 101, 16);
		frame.getContentPane().add(lblContentPreview);

		JButton fullmess = new JButton("Vizualizar");
		fullmess.setBounds(250, 243, 100, 29);
		frame.getContentPane().add(fullmess);
		fullmess.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int i = list_2.getSelectedIndex();
				if(i==-1) {
					new JOptionPane().showMessageDialog(new JFrame(), "Selecione um preview",null, JOptionPane.ERROR_MESSAGE);
				}
				else {
					EmailGUI fullview = new EmailGUI(messages.getSender().get(i), messages.getDescription().get(i),messages.getMess().get(i).getMessage()) ;
				}
					
				
			}
		});
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(354, 243, 75, 29);
		frame.getContentPane().add(btnExit);
		frame.validate();
		frame.setVisible(true);
		btnExit.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
	}
}
