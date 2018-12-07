package GUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class SignUpWindow {

	JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUpWindow window = new SignUpWindow();
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
	public SignUpWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		writexml();
		frame = new JFrame();
		frame.setBounds(100, 100, 350, 240);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(99, 20, 36, 16);
		frame.getContentPane().add(lblName);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(91, 50, 44, 16);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblConfirmEmail = new JLabel("Confirm E-mail");
		lblConfirmEmail.setBounds(38, 80, 97, 16);
		frame.getContentPane().add(lblConfirmEmail);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(76, 110, 59, 16);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setBounds(20, 140, 115, 16);
		frame.getContentPane().add(lblConfirmPassword);
		
		textField = new JTextField();
		textField.setBounds(150, 20, 185, 25);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(150, 50, 185, 25);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(150, 80, 185, 25);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(150, 110, 185, 25);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(150, 140, 185, 25);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.setBounds(125, 170, 100, 30);
		frame.getContentPane().add(btnSignUp);
		btnSignUp.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LoginWindow window = new LoginWindow();
				window.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
	}

	private void readxml() {
		try
        {
            FileReader fstream = new FileReader("logs.xml");
            BufferedReader out = new BufferedReader(fstream);
            String y="E-mail";
            while ((y=out.readLine()) != null)  {
                System.out.println(y);
            }
            //out.close();
        }catch(Exception e) {
            e.printStackTrace();
        }
	}
	
	private void writexml() {	
		try {
			boolean b = false;
			FileWriter fstream = new FileWriter("logs.xml");
			BufferedWriter write = new BufferedWriter(fstream);
			while(b==false) {
				if(write.equals(null)) {
			write.write("email");
			write.flush();
			write.close();
			
				}
				System.err.println("tou");
				write.newLine();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
