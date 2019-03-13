package team;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class Admin extends JFrame {

	private JPanel contentPane;
	private JTextField RoomField;
	private JTextField amdRoomNo;
	ClassroomDB database = new ClassroomDB();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin frame = new Admin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Admin() {
		setTitle("Administration");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 378, 315);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));

		JPanel MainPanel = new JPanel();
		contentPane.add(MainPanel, "name_75157894146767");
		MainPanel.setLayout(null);

		JPanel WelcomePnl = new JPanel();
		WelcomePnl.setBounds(10, 11, 334, 153);
		WelcomePnl.setLayout(null);
		WelcomePnl.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(192, 192, 192)));
		MainPanel.add(WelcomePnl);

		JLabel WelcomeLbl = new JLabel("Welcome To The LYIT Administration Page");
		WelcomeLbl.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 16));
		WelcomeLbl.setBounds(24, 51, 300, 69);
		WelcomePnl.add(WelcomeLbl);

		JPanel MainBtnPanel = new JPanel();
		MainBtnPanel.setBorder(new LineBorder(Color.BLACK));
		MainBtnPanel.setBounds(10, 175, 334, 80);
		MainPanel.add(MainBtnPanel);
		MainBtnPanel.setLayout(null);

		JButton MainLog = new JButton("Log Out");
		MainLog.setBounds(169, 46, 155, 23);
		MainBtnPanel.add(MainLog);

		JButton MainAmend = new JButton("Amend A Room");
		MainAmend.setBounds(4, 46, 155, 23);
		MainBtnPanel.add(MainAmend);

		JButton mainReg = new JButton("Register Room");
		mainReg.setBounds(4, 12, 155, 23);
		MainBtnPanel.add(mainReg);

		JButton MainDeco = new JButton("Decomission Room");
		MainDeco.setBounds(169, 12, 155, 23);
		MainBtnPanel.add(MainDeco);
		MainDeco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				((CardLayout) contentPane.getLayout()).show(contentPane, "name_75157967839818");
			}
		});
		mainReg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((CardLayout) contentPane.getLayout()).show(contentPane, "name_75157931211767");
			}
		});
		MainAmend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((CardLayout) contentPane.getLayout()).show(contentPane, "name_75158003890558");
			}
		});
		MainLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				//JFrame.dispatchEvent(new WindowEvent(JFrame, WindowEvent.WINDOW_CLOSING));
				Menu dialog = new Menu();
				dialog.setTitle("Security Screen");
				dialog.pack();
				// Add the DISPOSE_ON_CLOSE operation to dialog
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setLocationRelativeTo(null);
				dialog.setVisible(true);
				//dispatchEvent(new WindowEvent(panel, WindowEvent.WINDOW_CLOSING));

			}
		});

		JPanel RegPanel = new JPanel();
		contentPane.add(RegPanel, "name_75157931211767");
		RegPanel.setLayout(null);

		JPanel registerDetails = new JPanel();
		registerDetails.setBounds(10, 0, 334, 174);
		registerDetails.setLayout(null);
		registerDetails.setBorder(new LineBorder(new Color(0, 0, 0)));
		RegPanel.add(registerDetails);

		JPanel ClassCap = new JPanel();
		ClassCap.setLayout(null);
		ClassCap.setBorder(new TitledBorder(null, "Class Capacity", TitledBorder.LEADING, TitledBorder.TOP, null, Color.GRAY));
		ClassCap.setBounds(10, 23, 143, 116);
		registerDetails.add(ClassCap);

		JRadioButton radioButton = new JRadioButton("64\r\n");
		radioButton.setBounds(26, 66, 57, 23);
		ClassCap.add(radioButton);

		JRadioButton radioButton_1 = new JRadioButton("32");
		radioButton_1.setBounds(26, 40, 57, 23);
		ClassCap.add(radioButton_1);

		JRadioButton radioButton_2 = new JRadioButton("16");
		radioButton_2.setBounds(26, 14, 57, 23);
		ClassCap.add(radioButton_2);

		JPanel classDetails = new JPanel();
		classDetails.setLayout(null);
		classDetails.setBorder(new TitledBorder(null, "Class Details", TitledBorder.LEADING, TitledBorder.TOP, null, Color.GRAY));
		classDetails.setBounds(166, 23, 158, 116);
		registerDetails.add(classDetails);

		JComboBox typeCmb = new JComboBox(new String[]{"Lab", "Computer Room", "Class room", "Lecture hall", "Engineering Suite"});
		typeCmb.setBounds(20, 28, 107, 20);
		classDetails.add(typeCmb);

		RoomField = new JTextField("Room Number");
		RoomField.setBounds(20, 69, 107, 20);
		classDetails.add(RoomField);

		JButton SubmitBtn = new JButton("Submit");
        SubmitBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                //if(room no  is int)
                database.addRoom(roomNo, capacity, type)
                        // else give error
            }
        });
		SubmitBtn.setBounds(10, 140, 314, 23);
		registerDetails.add(SubmitBtn);

		JLabel lblRegisterRoom = new JLabel("Register Room");
		lblRegisterRoom.setBounds(122, 0, 82, 25);
		registerDetails.add(lblRegisterRoom);

		JButton btnReturnToMain = new JButton("Return to Main Menu");
		btnReturnToMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((CardLayout) contentPane.getLayout()).show(contentPane, "name_75157894146767");
			}
		});
		btnReturnToMain.setBounds(16, 192, 155, 23);
		RegPanel.add(btnReturnToMain);

		JButton RegDecom = new JButton("Decomission Room");
		RegDecom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				((CardLayout) contentPane.getLayout()).show(contentPane, "name_75157967839818");
			}
		});

		RegDecom.setBounds(172, 192, 155, 23);
		RegPanel.add(RegDecom);

		JButton regAmd = new JButton("Amend A Room");
		regAmd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((CardLayout) contentPane.getLayout()).show(contentPane, "name_75158003890558");
			}
		});
		regAmd.setBounds(16, 226, 155, 23);
		RegPanel.add(regAmd);

		JButton RegLog = new JButton("Log Out");
		RegLog.setBounds(172, 226, 155, 23);
		RegPanel.add(RegLog);

		JPanel RegBtnPan = new JPanel();
		RegBtnPan.setBounds(10, 185, 334, 75);
		RegBtnPan.setBorder(new LineBorder(Color.BLACK));
		RegPanel.add(RegBtnPan);

		JPanel DecomissionPan = new JPanel();
		contentPane.add(DecomissionPan, "name_75157967839818");
		DecomissionPan.setLayout(null);

		JPanel decomDets = new JPanel();
		decomDets.setBorder(new LineBorder(Color.BLACK));
		decomDets.setBounds(10, 0, 334, 174);
		DecomissionPan.add(decomDets);
		decomDets.setLayout(null);

		JComboBox roomNoDec = new JComboBox();
		roomNoDec.setBounds(40, 70, 253, 22);
		decomDets.add(roomNoDec);

		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(40, 116, 253, 23);
		decomDets.add(btnNewButton);

		JLabel lblDecommissionARoom = new JLabel("Decommission a Room");
		lblDecommissionARoom.setBounds(115, 30, 120, 14);
		decomDets.add(lblDecommissionARoom);

		JPanel DecomBtnPan = new JPanel();
		DecomBtnPan.setBorder(new LineBorder(Color.BLACK));
		DecomBtnPan.setBounds(10, 185, 334, 75);
		DecomissionPan.add(DecomBtnPan);
		DecomBtnPan.setLayout(null);

		JButton button_9 = new JButton("Register Room");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((CardLayout) contentPane.getLayout()).show(contentPane, "name_75157931211767");
			}
		});
		button_9.setBounds(10, 9, 155, 23);
		DecomBtnPan.add(button_9);

		JButton decomAmnd = new JButton("Amend A Room");
		decomAmnd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((CardLayout) contentPane.getLayout()).show(contentPane, "name_75158003890558");
			}
		});
		decomAmnd.setBounds(10, 41, 155, 23);
		DecomBtnPan.add(decomAmnd);

		JButton decomLog = new JButton("Log Out");
		decomLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		decomLog.setBounds(166, 41, 155, 23);
		DecomBtnPan.add(decomLog);

		JButton btnReturnToMain_1 = new JButton("Return to Main Menu");
		btnReturnToMain_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((CardLayout) contentPane.getLayout()).show(contentPane, "name_75157894146767");
			}
		});
		btnReturnToMain_1.setBounds(166, 9, 155, 23);
		DecomBtnPan.add(btnReturnToMain_1);

		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3, "name_75158003890558");
		panel_3.setLayout(null);

		JPanel panel_14 = new JPanel();
		panel_14.setLayout(null);
		panel_14.setBounds(0, 0, 352, 266);
		panel_3.add(panel_14);

		JPanel amdDetsPan = new JPanel();
		amdDetsPan.setLayout(null);
		amdDetsPan.setBorder(new LineBorder(new Color(0, 0, 0)));
		amdDetsPan.setBounds(10, 0, 334, 174);
		panel_14.add(amdDetsPan);

		JPanel panel_16 = new JPanel();
		panel_16.setLayout(null);
		panel_16.setBorder(new TitledBorder(null, "Class Capacity", TitledBorder.LEADING, TitledBorder.TOP, null, Color.GRAY));
		panel_16.setBounds(10, 23, 143, 116);
		amdDetsPan.add(panel_16);

		JRadioButton amdLrg = new JRadioButton("64\r\n");
		amdLrg.setBounds(6, 66, 57, 23);
		panel_16.add(amdLrg);

		JRadioButton amdMdm = new JRadioButton("32");
		amdMdm.setBounds(6, 40, 57, 23);
		panel_16.add(amdMdm);

		JRadioButton amdSml = new JRadioButton("16");
		amdSml.setBounds(6, 14, 57, 23);
		panel_16.add(amdSml);

		JPanel amdClassDetails = new JPanel();
		amdClassDetails.setLayout(null);
		amdClassDetails.setBorder(new TitledBorder(null, "Class Details", TitledBorder.LEADING, TitledBorder.TOP, null, Color.GRAY));
		amdClassDetails.setBounds(166, 23, 158, 116);
		amdDetsPan.add(amdClassDetails);

		JComboBox roomTypeAmnd = new JComboBox(new String[]{"Lab", "Computer Room", "Class room", "Lecture hall", "Engineering Suite"});
		roomTypeAmnd.setBounds(23, 31, 107, 20);
		amdClassDetails.add(roomTypeAmnd);

		amdRoomNo = new JTextField("Room Number");
		amdRoomNo.setBounds(23, 62, 107, 20);
		amdClassDetails.add(amdRoomNo);

		JButton amdSubmit = new JButton("Submit");
		amdSubmit.setBounds(10, 140, 314, 23);
		amdDetsPan.add(amdSubmit);

		JLabel lblAmendRoom = new JLabel("Amend Room");
		lblAmendRoom.setBounds(130, 0, 82, 25);
		amdDetsPan.add(lblAmendRoom);

		JButton amdReg = new JButton("Register Room");
		amdReg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				((CardLayout) contentPane.getLayout()).show(contentPane, "name_75157931211767");

			}
		});
		amdReg.setBounds(16, 192, 155, 23);
		panel_14.add(amdReg);

		JButton amdDecon = new JButton("Decomission Room");
		amdDecon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				((CardLayout) contentPane.getLayout()).show(contentPane, "name_75157967839818");
			}
		});
		amdDecon.setBounds(172, 192, 155, 23);
		panel_14.add(amdDecon);

		JButton btnReturnToMain_2 = new JButton("Return to Main Menu");
		btnReturnToMain_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((CardLayout) contentPane.getLayout()).show(contentPane, "name_75157894146767");
			}
		});
		btnReturnToMain_2.setBounds(16, 226, 155, 23);
		panel_14.add(btnReturnToMain_2);

		JButton amdLog = new JButton("Log Out");
		amdLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		amdLog.setBounds(172, 226, 155, 23);
		panel_14.add(amdLog);

		JPanel amdBtnPanel = new JPanel();
		amdBtnPanel.setBorder(new LineBorder(Color.BLACK));
		amdBtnPanel.setBounds(10, 185, 334, 75);
		panel_14.add(amdBtnPanel);
	}
}