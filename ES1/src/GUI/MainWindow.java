package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindow {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * List=sender
	 * List1=subject
	 * List2=Content Preview 
	 * 
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JList list = new JList();
		list.setBounds(18, 40, 93, 190);
		frame.getContentPane().add(list);

		JList list_1 = new JList();
		list_1.setBounds(120, 40, 93, 190);
		frame.getContentPane().add(list_1);

		JList list_2 = new JList();
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

		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(354, 243, 75, 29);
		frame.getContentPane().add(btnExit);
		btnExit.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
	}
}
