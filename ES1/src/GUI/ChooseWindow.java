package GUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;

public class ChooseWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChooseWindow window = new ChooseWindow();
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
	public ChooseWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 210, 90);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnConfigxml = new JButton("Config.xml");
		btnConfigxml.setBounds(83, 34, 103, 29);
		frame.getContentPane().add(btnConfigxml);

		JButton btnStart = new JButton("Start");
		btnStart.setBounds(16, 34, 61, 29);
		frame.getContentPane().add(btnStart);
		btnStart.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainWindow window = new MainWindow();
				window.frame.setVisible(true);
			}
		});
			

		JLabel lblLoginEfectuadoCom = new JLabel("Login efectuado com sucesso!");
		lblLoginEfectuadoCom.setBounds(6, 6, 199, 16);
		frame.getContentPane().add(lblLoginEfectuadoCom);
	}

}
