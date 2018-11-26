package GUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class LoginWindow {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginWindow window = new LoginWindow();
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
	public LoginWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 250, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(60, 80, 117, 29);
		frame.getContentPane().add(btnLogin);
		btnLogin.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ChooseWindow window = new ChooseWindow();
				window.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		
		textField = new JTextField();
		textField.setBounds(100, 10, 130, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(100, 45, 130, 26);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(20, 15, 83, 16);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(20, 50, 72, 16);
		frame.getContentPane().add(lblPassword);
	}
}
