package team;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JTable;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.border.LineBorder;

public class HoD extends JFrame {

	private JFrame frame;
	private JTextField txtRoomNumber;
	private JTextField textField;
	private JTextField txtRoomNumber_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HoD frame = new HoD();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HoD() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setForeground(new Color(240, 230, 140));
		frame.getContentPane().setForeground(new Color(240, 230, 140));
		frame.setBounds(100, 100, 300, 471);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		///////////////////////////////////////////////////////////////
		//  Current Booking Details									//
		/////////////////////////////////////////////////////////////
		
		JLabel TitleLBL = new JLabel("Current Booking Details");
		TitleLBL.setBounds(87, 9, 146, 14);
		frame.getContentPane().add(TitleLBL);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(20, 34, 246, 137);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JComboBox CurDay = new JComboBox();
		CurDay.setBounds(10, 44, 231, 20);
		CurDay.setModel(new DefaultComboBoxModel(new String[] {"Monday", "Tuesday", "Wedneday", "Thursday", "Friday"}));
		panel_1.add(CurDay);
		
		JComboBox CurTime = new JComboBox(new String[]{"0930-1030", "1030-1130", "1130-1230", "1230-1330", "1330-1430", "1430-1530", "1530-1630", "1630-1730",});
		CurTime.setBounds(10, 75, 231, 20);
		panel_1.add(CurTime);
		
		txtRoomNumber_2 = new JTextField();
		txtRoomNumber_2.setBounds(10, 106, 231, 20);
		panel_1.add(txtRoomNumber_2);
		txtRoomNumber_2.setForeground(Color.GRAY);
		txtRoomNumber_2.setText("Room Number");
		txtRoomNumber_2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtRoomNumber_2.setText("");
			}
			@Override
			public void focusLost(FocusEvent e) {
				txtRoomNumber_2.setText("Room Number");
			}
		});
		txtRoomNumber_2.setColumns(10);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Week 1", "Week 2", "Week 3", "Week 4", "Week 5", "Week 6", "Week 7", "Week 8", "Week 9", "Week 10", "Week 11", "Week 12"}));
		comboBox_1.setBounds(10, 11, 231, 20);
		panel_1.add(comboBox_1);
		
		
		///////////////////////////////////////////////////////////////
		//  Swap Booking											//
		/////////////////////////////////////////////////////////////
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setLayout(null);
		panel_2.setBounds(20, 219, 113, 137);
		frame.getContentPane().add(panel_2);
		
		JRadioButton swpSmlCap = new JRadioButton("16");
		swpSmlCap.setBounds(35, 32, 57, 23);
		panel_2.add(swpSmlCap);
		
		JRadioButton mdmSwapCap = new JRadioButton("32");
		mdmSwapCap.setBounds(35, 58, 57, 23);
		panel_2.add(mdmSwapCap);
		
		JRadioButton lrgSwapCap = new JRadioButton("64\r\n");
		lrgSwapCap.setBounds(35, 84, 57, 23);
		panel_2.add(lrgSwapCap);
		
		JLabel lblNewLabel = new JLabel("Room Capacity");
		lblNewLabel.setBounds(21, 11, 82, 14);
		panel_2.add(lblNewLabel);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setLayout(null);
		panel_3.setBounds(143, 219, 123, 137);
		frame.getContentPane().add(panel_3);
		
		JComboBox SwapClass = new JComboBox((new String[] {"Lab", "Computer Room", "Class room", "Lecture hall", "Engineering Suite"}));
		SwapClass.setBounds(15, 42, 91, 20);
		panel_3.add(SwapClass);
		
		JComboBox SwapDay = new JComboBox((new String[] {"Monday", "Tuesday", "Wedneday", "Thursday", "Friday"}));
		SwapDay.setBounds(15, 73, 91, 20);
		panel_3.add(SwapDay);
		
		JComboBox SwapTime = new JComboBox(new String[]{"0930-1030", "1030-1130", "1130-1230", "1230-1330", "1330-1430", "1430-1530", "1530-1630", "1630-1730",});
		SwapTime.setBounds(15, 104, 91, 20);
		panel_3.add(SwapTime);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Week 1", "Week 2", "Week 3", "Week 4", "Week 5", "Week 6", "Week 7", "Week 8", "Week 9", "Week 10", "Week 11", "Week 12"}));
		comboBox_2.setBounds(15, 11, 91, 20);
		panel_3.add(comboBox_2);
		
		JLabel lblSwapRoomDetails = new JLabel("Swap Room Details");
		lblSwapRoomDetails.setBounds(97, 181, 146, 27);
		frame.getContentPane().add(lblSwapRoomDetails);
		
		JButton btnSwapRoom = new JButton("Swap Room");
		btnSwapRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{		

				
			}
		});
		btnSwapRoom.setBounds(20, 398, 113, 23);
		frame.getContentPane().add(btnSwapRoom);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.setBounds(143, 398, 123, 23);
		frame.getContentPane().add(btnLogOut);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Available Rooms", "1", "2", "3", "4", "5"}));
		comboBox.setBounds(143, 367, 123, 20);
		frame.getContentPane().add(comboBox);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(20, 364, 113, 23);
		frame.getContentPane().add(btnSearch);
		


		
		//frame.add(new JLabel(new ImageIcon("X:\\Sem 6\\Team Project\\GUI & SQL\\download.jpg")));
	}

	
	
}