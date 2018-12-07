package GUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import org.w3c.dom.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class SignUpWindow {

	private ArrayList<String> Username = new ArrayList<>();

	public JFrame getFrame() {
		return frame;
	}

	private ArrayList<String> Email = new ArrayList<>();
	private ArrayList<String> password = new ArrayList<>();
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private String role1 = null;

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
		frame = new JFrame();
		frame.setBounds(100, 100, 350, 240);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblName = new JLabel("Username");
		lblName.setBounds(70, 20, 60, 16);
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
		btnSignUp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Username.add(textField.getText());
				Email.add(textField_1.getText());
				password.add(textField_3.getText());
				writexml();
//				LoginWindow window = new LoginWindow();
//				window.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
	}

	private void writexml() {
		org.w3c.dom.Document dom = null;
		Element e = null;

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			dom = db.newDocument();
			Element rootEle = dom.createElement("dados");
			for (int i = 0; i < Username.size(); i++) {

				System.out.println(Username.get(i));
				e = dom.createElement(Username.get(i));
				e.appendChild(dom.createTextNode(Username.get(i)));
				rootEle.appendChild(e);

				e = dom.createElement(Username.get(i) + "_Email");
				e.appendChild(dom.createTextNode(Email.get(i)));
				rootEle.appendChild(e);

				e = dom.createElement(Username.get(i) + "_Password");
				e.appendChild(dom.createTextNode(password.get(i)));
				rootEle.appendChild(e);

				dom.appendChild(rootEle);
			}

			try {
				Transformer tr = TransformerFactory.newInstance().newTransformer();
				tr.setOutputProperty(OutputKeys.INDENT, "yes");
				tr.setOutputProperty(OutputKeys.METHOD, "xml");
				tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
				tr.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

				// send DOM to file
				tr.transform(new DOMSource(dom), new StreamResult(new FileOutputStream("config.xml")));

			} catch (TransformerException te) {
				System.out.println(te.getMessage());
			} catch (IOException ioe) {
				System.out.println(ioe.getMessage());
			}
		} catch (ParserConfigurationException pce) {
			System.out.println("UsersXML: Error trying to instantiate DocumentBuilder " + pce);
		}

	}

	private void readxml() {

	}
}
