package ie.lyit.timeTable;

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
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.FocusAdapter;

public class Estates extends JFrame {

	private JPanel contentPane;
	private JTextField Amend_RoomNum;
	private JTextField CreateBooking_LectNameText;
	private JTextField CancelBooking_LectNameTXT;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Estates frame = new Estates();
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
	public Estates() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 380, 329);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		///////////////////////////////////////////////////////////////
		//  Main Menu												//
		/////////////////////////////////////////////////////////////
		
		JPanel Intro_Panel = new JPanel();
		contentPane.add(Intro_Panel, "Intro_Panel");
		Intro_Panel.setLayout(null);
		
		JPanel intro_msg_Panel = new JPanel();
		intro_msg_Panel.setLayout(null);
		intro_msg_Panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(192, 192, 192)));
		intro_msg_Panel.setBounds(10, 11, 334, 173);
		Intro_Panel.add(intro_msg_Panel);
	
		
		JLabel Intro_LBL = new JLabel("Welcome To The LYIT Estates Page");
		Intro_LBL.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 16));
		Intro_LBL.setBounds(51, 52, 300, 69);
		intro_msg_Panel.add(Intro_LBL);
		
		JPanel Intro_btnPanel = new JPanel();
		Intro_btnPanel.setLayout(null);
		Intro_btnPanel.setBorder(new LineBorder(Color.BLACK));
		Intro_btnPanel.setBounds(10, 195, 334, 80);
		Intro_Panel.add(Intro_btnPanel);
		
		JButton Intro_LogOut = new JButton("Log Out");
		Intro_LogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Intro_LogOut.setBounds(175, 45, 155, 23);
		Intro_btnPanel.add(Intro_LogOut);
		
		JButton intro_Amend = new JButton("Amend A Booking");
		intro_Amend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				((CardLayout)contentPane.getLayout()).show(contentPane, "Amend_Panel");
			}
		});
		intro_Amend.setBounds(10, 45, 155, 23);
		Intro_btnPanel.add(intro_Amend);
		
		JButton intro_bookRoom = new JButton("Book Room");
		intro_bookRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				((CardLayout)contentPane.getLayout()).show(contentPane, "Book_Panel");
			}
		});
		intro_bookRoom.setBounds(10, 11, 155, 23);
		Intro_btnPanel.add(intro_bookRoom);
		
		JButton intro_CancelRoom = new JButton("Cancel Booking ");
		intro_CancelRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				((CardLayout)contentPane.getLayout()).show(contentPane, "Cancel_Panel");
			}
		});
		intro_CancelRoom.setBounds(175, 11, 155, 23);
		Intro_btnPanel.add(intro_CancelRoom);
		
		
		///////////////////////////////////////////////////////////////
		//  Create Booking 											//
		/////////////////////////////////////////////////////////////
		
		
		JPanel Book_Panel = new JPanel();
		contentPane.add(Book_Panel, "Book_Panel");
		Book_Panel.setLayout(null);
		
		JPanel CreateBooking_ContentPanel = new JPanel();
		CreateBooking_ContentPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		CreateBooking_ContentPanel.setBounds(10, 11, 334, 174);
		Book_Panel.add(CreateBooking_ContentPanel);
		CreateBooking_ContentPanel.setLayout(null);
		
		JButton CreateBooking_Submit = new JButton("Submit");
		CreateBooking_Submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		CreateBooking_Submit.setBounds(10, 145, 314, 23);
		CreateBooking_ContentPanel.add(CreateBooking_Submit);
		
		JLabel lblCreateABooking = new JLabel("Create a Booking");
		lblCreateABooking.setBounds(114, 0, 106, 25);
		CreateBooking_ContentPanel.add(lblCreateABooking);
		
		JLabel CreateBooking_lblRoomType = new JLabel("Room Type");
		CreateBooking_lblRoomType.setBounds(33, 25, 82, 14);
		CreateBooking_ContentPanel.add(CreateBooking_lblRoomType);
		
		JLabel CreateBooking_lblRoomCapacity = new JLabel("Room Capacity");
		CreateBooking_lblRoomCapacity.setBounds(33, 50, 82, 14);
		CreateBooking_ContentPanel.add(CreateBooking_lblRoomCapacity);
		
		JLabel CreateBooking_lblLecturer = new JLabel("Lecturer Name\r\n");
		CreateBooking_lblLecturer.setBounds(33, 75, 82, 14);
		CreateBooking_ContentPanel.add(CreateBooking_lblLecturer);
		
		JLabel CreateBooking_lblTimeSlot = new JLabel("Time Slot");
		CreateBooking_lblTimeSlot.setBounds(33, 100, 82, 14);
		CreateBooking_ContentPanel.add(CreateBooking_lblTimeSlot);
		
		JLabel CreateBooking_lblDay = new JLabel("Day");
		CreateBooking_lblDay.setBounds(33, 120, 46, 14);
		CreateBooking_ContentPanel.add(CreateBooking_lblDay);
		
		JComboBox CreateBooking_RoomTypeComboBox = new JComboBox();
		CreateBooking_RoomTypeComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		CreateBooking_RoomTypeComboBox.setModel(new DefaultComboBoxModel(new String[] {"Lab", "Class", "Theatre"}));
		CreateBooking_RoomTypeComboBox.setBounds(173, 22, 134, 20);
		CreateBooking_ContentPanel.add(CreateBooking_RoomTypeComboBox);
		
		JRadioButton Booking_smallRadio = new JRadioButton("16");
		Booking_smallRadio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Booking_smallRadio.setBounds(183, 46, 37, 23);
		CreateBooking_ContentPanel.add(Booking_smallRadio);
		
		JRadioButton Booking_MedRadio = new JRadioButton("32");
		Booking_MedRadio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Booking_MedRadio.setBounds(224, 46, 37, 23);
		CreateBooking_ContentPanel.add(Booking_MedRadio);
		
		JRadioButton Booking_LrgRadio = new JRadioButton("64");
		Booking_LrgRadio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Booking_LrgRadio.setBounds(263, 46, 44, 23);
		CreateBooking_ContentPanel.add(Booking_LrgRadio);
		
		CreateBooking_LectNameText = new JTextField();
		CreateBooking_LectNameText.setForeground(Color.GRAY);
		CreateBooking_LectNameText.setText("John O' Raw");
		CreateBooking_LectNameText.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				CreateBooking_LectNameText.setText("");
			}
			public void focusLost(FocusEvent e) {
				CreateBooking_LectNameText.setText("John O' Raw");
			}
		});
		
		CreateBooking_LectNameText.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		CreateBooking_LectNameText.setBounds(173, 72, 134, 20);
		CreateBooking_ContentPanel.add(CreateBooking_LectNameText);
		CreateBooking_LectNameText.setColumns(10);
		
		JComboBox CreateBooking_TimeComboBox = new JComboBox(new String[]{"09.30-10.30", "10.30-11.30", "11.30-12.30", "12.30-13.30", "13.30-14.30", "14.30-15.30", "15.30-16.30", "16.30-17.30"});
		CreateBooking_TimeComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		CreateBooking_TimeComboBox.setBounds(173, 97, 134, 20);
		CreateBooking_ContentPanel.add(CreateBooking_TimeComboBox);
		
		JComboBox CreateBooking_DayComboBox = new JComboBox(new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"});
		CreateBooking_DayComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		CreateBooking_DayComboBox.setBounds(173, 120, 134, 20);
		CreateBooking_ContentPanel.add(CreateBooking_DayComboBox);
		
		JPanel CreateBooking_BTNPanel = new JPanel();
		CreateBooking_BTNPanel.setBorder(new LineBorder(Color.BLACK));
		CreateBooking_BTNPanel.setBounds(10, 196, 334, 73);
		Book_Panel.add(CreateBooking_BTNPanel);
		CreateBooking_BTNPanel.setLayout(null);
		
		JButton CreateBooking_LogOutButton = new JButton("Log Out");
		CreateBooking_LogOutButton.setBounds(175, 45, 155, 23);
		CreateBooking_BTNPanel.add(CreateBooking_LogOutButton);
		
		JButton CreateBooking_AmendBtn = new JButton("Amend A Booking");
		CreateBooking_AmendBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				((CardLayout)contentPane.getLayout()).show(contentPane, "Amend_Panel");
			}
		});
		CreateBooking_AmendBtn.setBounds(10, 45, 155, 23);
		CreateBooking_BTNPanel.add(CreateBooking_AmendBtn);
		
		JButton CreateBooking_ReturnToMenu = new JButton("Return To Main Menu");
		CreateBooking_ReturnToMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				((CardLayout)contentPane.getLayout()).show(contentPane, "Intro_Panel");
			}
		});
		CreateBooking_ReturnToMenu.setBounds(10, 11, 155, 23);
		CreateBooking_BTNPanel.add(CreateBooking_ReturnToMenu);
		
		JButton CreateBooking_CancelBooking = new JButton("Cancel Booking");
		CreateBooking_CancelBooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				((CardLayout)contentPane.getLayout()).show(contentPane, "Cancel_Panel");
			}
		});
		CreateBooking_CancelBooking.setBounds(175, 11, 155, 23);
		CreateBooking_BTNPanel.add(CreateBooking_CancelBooking);
		
		
		
		
		///////////////////////////////////////////////////////////////
		//  Cancel Booking 											//
		/////////////////////////////////////////////////////////////
		
		JPanel Cancel_Panel = new JPanel();
		contentPane.add(Cancel_Panel, "Cancel_Panel");
		Cancel_Panel.setLayout(null);
		
		JPanel CancelBooking_ContentPanel = new JPanel();
		CancelBooking_ContentPanel.setBounds(10, 11, 334, 174);
		CancelBooking_ContentPanel.setLayout(null);
		CancelBooking_ContentPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		Cancel_Panel.add(CancelBooking_ContentPanel);
		
		JButton button = new JButton("Submit");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setBounds(10, 145, 314, 23);
		CancelBooking_ContentPanel.add(button);
		
		JLabel lblCancelABooking = new JLabel("Cancel a Booking");
		lblCancelABooking.setBounds(113, 0, 99, 25);
		CancelBooking_ContentPanel.add(lblCancelABooking);
		
		JLabel CancelBooking_lblRoomNumber = new JLabel("Room Number");
		CancelBooking_lblRoomNumber.setBounds(33, 34, 82, 14);
		CancelBooking_ContentPanel.add(CancelBooking_lblRoomNumber);
		
		JLabel CancelBooking_LectName = new JLabel("Lecturer Name\r\n");
		CancelBooking_LectName.setBounds(33, 59, 82, 14);
		CancelBooking_ContentPanel.add(CancelBooking_LectName);
		
		JLabel CancelBooking_TimeLBL = new JLabel("Time Slot");
		CancelBooking_TimeLBL.setBounds(33, 84, 82, 14);
		CancelBooking_ContentPanel.add(CancelBooking_TimeLBL);
		
		JLabel CancelBooking_DayLBL = new JLabel("Day");
		CancelBooking_DayLBL.setBounds(33, 106, 46, 14);
		CancelBooking_ContentPanel.add(CancelBooking_DayLBL);
		
		JComboBox CancelBooking_RoomNocomboBox = new JComboBox();
		CancelBooking_RoomNocomboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		CancelBooking_RoomNocomboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
		CancelBooking_RoomNocomboBox.setBounds(173, 31, 134, 20);
		CancelBooking_ContentPanel.add(CancelBooking_RoomNocomboBox);
		
		CancelBooking_LectNameTXT = new JTextField();
		CancelBooking_LectNameTXT.setForeground(Color.GRAY);
		CancelBooking_LectNameTXT.setText("John O' Raw");
		CancelBooking_LectNameTXT.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				CreateBooking_LectNameText.setText("");
			}
			public void focusLost(FocusEvent e) {
				CreateBooking_LectNameText.setText("John O' Raw");
			}
		});
		CancelBooking_LectNameTXT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		CancelBooking_LectNameTXT.setColumns(10);
		CancelBooking_LectNameTXT.setBounds(173, 56, 134, 20);
		CancelBooking_ContentPanel.add(CancelBooking_LectNameTXT);
		
		JComboBox CancelBooking_TmeComboBox = new JComboBox(new String[]{"09.30-10.30", "10.30-11.30", "11.30-12.30", "12.30-13.30", "13.30-14.30", "14.30-15.30", "15.30-16.30", "16.30-17.30"});
		CancelBooking_TmeComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		CancelBooking_TmeComboBox.setBounds(173, 81, 134, 20);
		CancelBooking_ContentPanel.add(CancelBooking_TmeComboBox);
		
		JComboBox CancelBooking_DayCombo = new JComboBox(new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"});
		CancelBooking_DayCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		CancelBooking_DayCombo.setBounds(173, 106, 134, 20);
		CancelBooking_ContentPanel.add(CancelBooking_DayCombo);
		
		JPanel CancelBooking_BTNPanel = new JPanel();
		CancelBooking_BTNPanel.setLayout(null);
		CancelBooking_BTNPanel.setBorder(new LineBorder(Color.BLACK));
		CancelBooking_BTNPanel.setBounds(10, 196, 334, 73);
		Cancel_Panel.add(CancelBooking_BTNPanel);
		
		JButton CancelBooking_LogOut = new JButton("Log Out");
		CancelBooking_LogOut.setBounds(175, 45, 155, 23);
		CancelBooking_BTNPanel.add(CancelBooking_LogOut);
		
		JButton CancelBooking_AmendBTN = new JButton("Amend A Booking");
		CancelBooking_AmendBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				((CardLayout)contentPane.getLayout()).show(contentPane, "Amend_Panel");
			}
		});
		CancelBooking_AmendBTN.setBounds(10, 45, 155, 23);
		CancelBooking_BTNPanel.add(CancelBooking_AmendBTN);
		
		JButton CancelBooking_CreateBTN = new JButton("Book A Room");
		CancelBooking_CreateBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				((CardLayout)contentPane.getLayout()).show(contentPane, "Book_Panel");
			}
		});
		CancelBooking_CreateBTN.setBounds(10, 11, 155, 23);
		CancelBooking_BTNPanel.add(CancelBooking_CreateBTN);
		
		JButton CancelBooking_RtnToMain = new JButton("Return To Main Menu");
		CancelBooking_RtnToMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				((CardLayout)contentPane.getLayout()).show(contentPane, "Intro_Panel");
			}
		});
		CancelBooking_RtnToMain.setBounds(175, 11, 155, 23);
		CancelBooking_BTNPanel.add(CancelBooking_RtnToMain);
		
		///////////////////////////////////////////////////////////////
		//  Amend Booking 											//
		/////////////////////////////////////////////////////////////
		
		
		JPanel Amend_Panel = new JPanel();
		contentPane.add(Amend_Panel, "Amend_Panel");
		Amend_Panel.setLayout(null);
		
		JPanel Amend_ContentPanel = new JPanel();
		Amend_ContentPanel.setLayout(null);
		Amend_ContentPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		Amend_ContentPanel.setBounds(10, 11, 334, 174);
		Amend_Panel.add(Amend_ContentPanel);
		
		JPanel Amend_ClassCapPanel = new JPanel();
		Amend_ClassCapPanel.setLayout(null);
		Amend_ClassCapPanel.setBorder(new TitledBorder(null, "Class Capacity", TitledBorder.LEADING, TitledBorder.TOP, null, Color.GRAY));
		Amend_ClassCapPanel.setBounds(10, 23, 143, 116);
		Amend_ContentPanel.add(Amend_ClassCapPanel);
		
		JRadioButton Amend_lrgRadio = new JRadioButton("64\r\n");
		Amend_lrgRadio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Amend_lrgRadio.setBounds(26, 66, 57, 23);
		Amend_ClassCapPanel.add(Amend_lrgRadio);
		
		JRadioButton Amend_medRadio = new JRadioButton("32");
		Amend_medRadio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Amend_medRadio.setBounds(26, 40, 57, 23);
		Amend_ClassCapPanel.add(Amend_medRadio);
		
		JRadioButton amend_smllRadio = new JRadioButton("16");
		amend_smllRadio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		amend_smllRadio.setBounds(26, 14, 57, 23);
		Amend_ClassCapPanel.add(amend_smllRadio);
		
		JPanel Amend_RoomDetailsPanel = new JPanel();
		Amend_RoomDetailsPanel.addFocusListener(new FocusAdapter() {
			
		});
		Amend_RoomDetailsPanel.setLayout(null);
		Amend_RoomDetailsPanel.setBorder(new TitledBorder(null, "Class Details", TitledBorder.LEADING, TitledBorder.TOP, null, Color.GRAY));
		Amend_RoomDetailsPanel.setBounds(166, 23, 158, 116);
		Amend_ContentPanel.add(Amend_RoomDetailsPanel);
		
		JComboBox Amend_RoomType = new JComboBox(new Object[]{});
		Amend_RoomType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Amend_RoomType.setBounds(20, 28, 107, 20);
		Amend_RoomDetailsPanel.add(Amend_RoomType);
		
		Amend_RoomNum = new JTextField("Room Number");
		Amend_RoomNum.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				CreateBooking_LectNameText.setText("");
			}
			public void focusLost(FocusEvent e) {
				CreateBooking_LectNameText.setText("Room Number");
			}
		});
		Amend_RoomNum.setForeground(Color.GRAY);
		Amend_RoomNum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Amend_RoomNum.setBounds(20, 69, 107, 20);
		Amend_RoomDetailsPanel.add(Amend_RoomNum);
		
		JButton Amend_SubmitBTN = new JButton("Submit");
		Amend_SubmitBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Amend_SubmitBTN.setBounds(10, 145, 314, 23);
		Amend_ContentPanel.add(Amend_SubmitBTN);
		
		JLabel Amend_TitleLBL = new JLabel("Amend a Booking");
		Amend_TitleLBL.setBounds(115, 0, 102, 25);
		Amend_ContentPanel.add(Amend_TitleLBL);
		
		JPanel Amend_BtnPanel = new JPanel();
		Amend_BtnPanel.setLayout(null);
		Amend_BtnPanel.setBorder(new LineBorder(Color.BLACK));
		Amend_BtnPanel.setBounds(10, 196, 334, 73);
		Amend_Panel.add(Amend_BtnPanel);
		
		JButton Amend_LogOut = new JButton("Log Out");
		Amend_LogOut.setBounds(175, 45, 155, 23);
		Amend_BtnPanel.add(Amend_LogOut);
		
		JButton Amend_rtnToMain = new JButton("Return To Main Menu");
		Amend_rtnToMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				((CardLayout)contentPane.getLayout()).show(contentPane, "Intro_Panel");
			}
		});
		Amend_rtnToMain.setBounds(10, 45, 155, 23);
		Amend_BtnPanel.add(Amend_rtnToMain);
		
		JButton Amend_BookRoom = new JButton("Book Room");
		Amend_BookRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				((CardLayout)contentPane.getLayout()).show(contentPane, "Book_Panel");
			}
		});
		Amend_BookRoom.setBounds(10, 11, 155, 23);
		Amend_BtnPanel.add(Amend_BookRoom);
		
		JButton Amend_CancelRoom = new JButton("Cancel Booking ");
		Amend_CancelRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				((CardLayout)contentPane.getLayout()).show(contentPane, "Cancel_Panel");
			}
		});
		Amend_CancelRoom.setBounds(175, 11, 155, 23);
		Amend_BtnPanel.add(Amend_CancelRoom);
	}
}
