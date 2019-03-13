package ie.lyit.timeTable;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Menu extends JDialog{
	// Declare Components of JDialog...

	// It has a JPanel with two JLabels...
	private JPanel jpLabels;
	private JLabel jlblUserName, jlblPassword;

	// ...a JPanel with a JTextField and  JPasswordField...
	private JPanel jpTextFields;	
   private JTextField jtfUsername;
   private JPasswordField jtfPassword;

	// ...and a JPanel with two JButtons
	private JPanel jpButtons;	
   private JButton jbtOK, jbtCancel, jbtTable;

   private String userNameEntered, passwordEntered;
   private final String AdminUsername = "admin";
   private final String EstateUsername = "estate";
   private final String HoDUsername = "hod";
   private final String AdminPassword = "admin";
   private final String EstatePassword = "estate";
   private final String HoDPassword = "hod";
   

   public Menu()
   {
	   // Constructor - SetLayout & Add Components here...	
      // Panel 1 - Two JLabels
  		jpLabels = new JPanel(new GridLayout(2, 1));
    	jpLabels.add(jlblUserName=new JLabel("Username"));
		jpLabels.add(jlblPassword=new JLabel("Password"));

	   // Panel 2 - A JTextField and a JPasswordField
      jpTextFields = new JPanel(new GridLayout(2, 1));
      jpTextFields.add(jtfUsername = new JTextField(15));
      jpTextFields.add(jtfPassword= new JPasswordField(15));
		jtfPassword.setEchoChar('*');


	   // Panel4 - Three JButtons
      jpButtons = new JPanel();
      jpButtons.add(jbtOK = new JButton("OK"));
      jpButtons.add(jbtCancel = new JButton("Cancel"));

		// Set up the JFrame
      add(jpLabels, BorderLayout.WEST);
      add(jpTextFields, BorderLayout.CENTER);
      add(jpButtons, BorderLayout.SOUTH);

		// Add a LISTENER CLASS to jbtOK
      jbtOK.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
				// getText() in jtfUsername and jtfPassword
            userNameEntered = jtfUsername.getText();
            passwordEntered = new String(jtfPassword.getPassword());
				if(passwordEntered.equals(AdminPassword)&&userNameEntered.equals(AdminUsername)){
					try {
						Admin frame = new Admin();
						dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
						frame.setVisible(true);
						setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					} catch (Exception e1) 
					{
						e1.printStackTrace();
					}

				}
				
				if(passwordEntered.equals(EstatePassword)&&userNameEntered.equals(EstateUsername)){
					try {
						Estates frame = new Estates();
						dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
						frame.setVisible(true);
						setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					} 
					catch (Exception e1) {
						e1.printStackTrace();
					}

				}
				
				if(passwordEntered.equals(HoDPassword)&&userNameEntered.equals(HoDUsername)){
					try {
						HoD frame = new HoD();
						dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
						frame.setVisible(true);
						setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					} 
					catch (Exception e1) {
						e1.printStackTrace();
					}

				}
				else{
					JOptionPane.showMessageDialog(null,"Invalid Password Entered, Please try again",
															"PASSWORD ERROR",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
 

		// Add an ANONYMOUS LISTENER CLASS to jbtCancel
      jbtCancel.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
				System.out.println("CANCEL CLICKED!");				
			}
		});				
   }



   public static void main(String[] args){
		// CONSTRUCT a SecurityDialog object called dialog
      Menu dialog = new Menu();

		dialog.setTitle("Security Screen");
		dialog.pack();	
		// Add the DISPOSE_ON_CLOSE operation to dialog
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setLocationRelativeTo(null);
		dialog.setVisible(true);
  }
}