package team;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.JButton;

public class HeadOfDept extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JComboBox Current_time;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HeadOfDept frame = new HeadOfDept();
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
	public HeadOfDept() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 282, 482);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel CurrentDetails_Panel = new JPanel();
		CurrentDetails_Panel.setLayout(null);
		CurrentDetails_Panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		CurrentDetails_Panel.setBounds(10, 30, 246, 137);
		contentPane.add(CurrentDetails_Panel);

		JComboBox Current_Day = new JComboBox();
		Current_Day.setModel(new DefaultComboBoxModel(new String[] {"Monday", "Tuesday", "Wedneday", "Thursday", "Friday"}));
		Current_Day.setBounds(10, 44, 231, 20);
		CurrentDetails_Panel.add(Current_Day);

		textField = new JTextField();
		textField.setText("Room Number");
		textField.setForeground(Color.GRAY);
		textField.setColumns(10);
		textField.setBounds(10, 106, 231, 20);
		CurrentDetails_Panel.add(textField);

		JComboBox Current_week = new JComboBox();
		Current_week.setModel(new DefaultComboBoxModel(new String[] {"Week 1", "Week 2", "Week 3", "Week 4", "Week 5", "Week 6", "Week 7", "Week 8", "Week 9", "Week 10", "Week 11", "Week 12"}));
		Current_week.setBounds(10, 11, 231, 20);
		CurrentDetails_Panel.add(Current_week);

		Current_time = new JComboBox(new Object[]{});
		Current_time.setModel(new DefaultComboBoxModel(new String[] {"0930-1030", "1030-1130", "1130-1230", "1230-1330", "1330-1430", "1430-1530", "1530-1630", "1630-1730"}));
		Current_time.setBounds(10, 75, 231, 20);
		CurrentDetails_Panel.add(Current_time);

		JLabel lblCurrentRoom = new JLabel("Current Room");
		lblCurrentRoom.setBounds(96, 5, 88, 14);
		contentPane.add(lblCurrentRoom);

		JPanel SwapCap_Panel = new JPanel();
		SwapCap_Panel.setLayout(null);
		SwapCap_Panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		SwapCap_Panel.setBounds(10, 209, 113, 137);
		contentPane.add(SwapCap_Panel);

		JRadioButton Cap16_Radio = new JRadioButton("16");
		Cap16_Radio.setBounds(35, 32, 57, 23);
		SwapCap_Panel.add(Cap16_Radio);

		JRadioButton Cap32_Radio = new JRadioButton("32");
		Cap32_Radio.setBounds(35, 58, 57, 23);
		SwapCap_Panel.add(Cap32_Radio);

		JRadioButton Cap64_Radio = new JRadioButton("64\r\n");
		Cap64_Radio.setBounds(35, 84, 57, 23);
		SwapCap_Panel.add(Cap64_Radio);

		JLabel label = new JLabel("Room Capacity");
		label.setBounds(18, 11, 85, 14);
		SwapCap_Panel.add(label);

		JPanel SwapDetails_Panel = new JPanel();
		SwapDetails_Panel.setLayout(null);
		SwapDetails_Panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		SwapDetails_Panel.setBounds(133, 209, 123, 137);
		contentPane.add(SwapDetails_Panel);

		JComboBox swap_roomtype = new JComboBox(new Object[]{});
		swap_roomtype.setModel(new DefaultComboBoxModel(new String[] {"Lab", "Computer Room", "Class room", "Lecture hall", "Engineering Suite"}));
		swap_roomtype.setBounds(15, 42, 91, 20);
		SwapDetails_Panel.add(swap_roomtype);

		JComboBox swap_day = new JComboBox(new Object[]{});
		swap_day.setModel(new DefaultComboBoxModel(new String[] {"Monday", "Tuesday", "Wedneday", "Thursday", "Friday"}));
		swap_day.setBounds(15, 73, 91, 20);
		SwapDetails_Panel.add(swap_day);

		JComboBox swap_time = new JComboBox(new Object[]{});
		swap_time.setModel(new DefaultComboBoxModel(new String[] {"0930-1030", "1030-1130", "1130-1230", "1230-1330", "1330-1430", "1430-1530", "1530-1630", "1630-1730"}));
		swap_time.setBounds(15, 104, 91, 20);
		SwapDetails_Panel.add(swap_time);

		JComboBox Swap_week = new JComboBox();
		Swap_week.setModel(new DefaultComboBoxModel(new String[] {"Week 1", "Week 2", "Week 3", "Week 4", "Week 5", "Week 6", "Week 7", "Week 8", "Week 9", "Week 10", "Week 11", "Week 12"}));
		Swap_week.setBounds(15, 11, 91, 20);
		SwapDetails_Panel.add(Swap_week);

		JLabel lblSwap = new JLabel("Swap Room Details");
		lblSwap.setBounds(86, 178, 146, 27);
		contentPane.add(lblSwap);

		JPanel BtnPanel = new JPanel();
		BtnPanel.setBounds(10, 357, 246, 75);
		contentPane.add(BtnPanel);
		BtnPanel.setLayout(null);

		JButton SearchBtn = new JButton("Search");
		SearchBtn.setBounds(10, 11, 103, 23);
		BtnPanel.add(SearchBtn);

		JButton SwapBtn = new JButton("Swap Room");
		SwapBtn.setBounds(10, 45, 103, 23);
		BtnPanel.add(SwapBtn);

		JComboBox availableRooms = new JComboBox();
		availableRooms.setModel(new DefaultComboBoxModel(new String[] {"Available Rooms"}));
		availableRooms.setBounds(123, 12, 113, 20);
		BtnPanel.add(availableRooms);

		JButton LogOutBtn = new JButton("Log Out");
		LogOutBtn.setBounds(123, 43, 113, 23);
		BtnPanel.add(LogOutBtn);
	}
}
