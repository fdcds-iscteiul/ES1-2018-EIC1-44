package API;


import javax.swing.DefaultListModel;

import GUI.EmailGUI;
import GUI.LoginWindow;
import GUI.MainWindow;



public class Main {

	public static void main(String[] args) {
        Message_Control control=  new Message_Control();
        new LoginWindow(control);
	}
}
