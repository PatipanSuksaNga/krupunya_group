package layout;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;

import data.BillCollections;
import data.Buybill;
import data.Information;
import data.Product;
import data.dateIn;
import data.language;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JTable;
import java.awt.Font;

public class Members {

	private JFrame frame;
	
	JMenuBar menuBar = new JMenuBar();
	JMenu mnLanguage = new JMenu(language.mnLanguage);
	JMenuItem mntmEnglish = new JMenuItem(language.mntmEnglish);
	JMenuItem mntmThai = new JMenuItem(language.mntmThai);
	private JTextField textField_Name;
	private JTextField textField_Address;
	private JTextField textField_Phone_number;
	private JTable table;
	DefaultTableModel model = new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Members window = new Members();
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
	public Members() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		frame = new JFrame();
		frame.setBounds(0, 0, 970, 950);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Dimension windowSize = frame.getSize();
		
		setText();
		menuBar.setBounds(0, 0, windowSize.width, 30);
		menuBar.add(mnLanguage);
		mnLanguage.add(mntmEnglish);
		mntmEnglish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				language.getEng();
				setText();
			}
		});
		mnLanguage.add(mntmThai);
		mntmThai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				language.getThai();
				setText();
			}
		});
		
		frame.getContentPane().add(menuBar);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 31, windowSize.width-20, 1500);
		panel.setPreferredSize(new Dimension(windowSize.width-20,1500));
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		JLabel lbMember = new JLabel("Member management");
		lbMember.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lbMember.setHorizontalAlignment(SwingConstants.CENTER);
		lbMember.setBounds(windowSize.width/2-100, 75, 200, 30);
		panel.add(lbMember);
		
		JLabel lbID = new JLabel("ID");
		lbID.setHorizontalAlignment(SwingConstants.CENTER);
		lbID.setBounds(50, 200, 100, 30);
		panel.add(lbID);
		
		JLabel lbIDMember = new JLabel("-");
		lbIDMember.setHorizontalAlignment(SwingConstants.CENTER);
		lbIDMember.setBounds(110, 200, 100, 30);
		panel.add(lbIDMember);
		
		JLabel lbName = new JLabel("Name");
		lbName.setHorizontalAlignment(SwingConstants.CENTER);
		lbName.setBounds(50, 250, 100, 30);
		panel.add(lbName);
		
		JLabel lbAddress = new JLabel("Address");
		lbAddress.setHorizontalAlignment(SwingConstants.CENTER);
		lbAddress.setBounds(50, 300, 100, 30);
		panel.add(lbAddress);
		
		JLabel lbPhone_number = new JLabel("Phone number");
		lbPhone_number.setHorizontalAlignment(SwingConstants.CENTER);
		lbPhone_number.setBounds(50, 350, 100, 30);
		panel.add(lbPhone_number);
		
		textField_Name = new JTextField();
		textField_Name.setHorizontalAlignment(SwingConstants.CENTER);
		textField_Name.setBounds(160, 255, 200, 20);
		panel.add(textField_Name);
		textField_Name.setColumns(10);

		textField_Address = new JTextField();
		textField_Address.setHorizontalAlignment(SwingConstants.CENTER);
		textField_Address.setBounds(160, 305, 200, 20);
		panel.add(textField_Address);
		textField_Address.setColumns(10);
		
		textField_Phone_number = new JTextField();
		textField_Phone_number.setHorizontalAlignment(SwingConstants.CENTER);
		textField_Phone_number.setBounds(160, 355, 200, 20);
		panel.add(textField_Phone_number);
		textField_Phone_number.setColumns(10);
		
		table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setPreferredScrollableViewportSize(new Dimension(850,400));
		table.setBounds(50, 450, 850, 400);
		table.setModel(model);
        model.addColumn("ID");
        model.addColumn("Name");
        model.addColumn("Address");
        model.addColumn("Phone number");
        JScrollPane table_sp = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        table_sp.setBounds(50, 450, 850, 400);
        table_sp.setVisible(true);
		panel.add(table_sp);
		
		scrollPane.setBounds(0, 31, windowSize.width-20, windowSize.height-70);
		frame.getContentPane().add(scrollPane);
	}
	
	private void setText() {
		mnLanguage.setText(language.mnLanguage);
		mntmEnglish.setText(language.mntmEnglish);
		mntmThai.setText(language.mntmThai);
		
	}

}
