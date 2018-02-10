package layout;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;

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

public class BuyBilling {

	private JFrame frame;
	
	JMenuBar menuBar = new JMenuBar();
	JMenu mnLanguage = new JMenu(language.mnLanguage);
	JMenuItem mntmEnglish = new JMenuItem(language.mntmEnglish);
	JMenuItem mntmThai = new JMenuItem(language.mntmThai);
	private JTextField textField_Name;
	private JTextField textField_Address;
	private JTextField textField_Importer;
	private JTextField textField_Evaluater;
	private JTextField textField_SecretNumber;
	private JTextField textField_Size;
	private JTextField textField_TotalWeight;
	private JTextField textField_Price;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuyBilling window = new BuyBilling();
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
	public BuyBilling() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		frame = new JFrame();
		frame.setBounds(50, 50, 970, 950);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		setText();
		menuBar.setBounds(0, 0, screenSize.width, 30);
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
		
		Dimension windowSize = frame.getSize();
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 31, windowSize.width-20, 1500);
		panel.setPreferredSize(new Dimension(windowSize.width-20,1500));
		
		JScrollPane scrollPane = new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		panel.setLayout(null);
		
		JLabel lbCustomerName = new JLabel("Name");
		lbCustomerName.setHorizontalAlignment(SwingConstants.CENTER);
		lbCustomerName.setBounds(50, 150, 100, 20);
		panel.add(lbCustomerName);
		
		textField_Name = new JTextField();
		textField_Name.setHorizontalAlignment(SwingConstants.CENTER);
		textField_Name.setBounds(150, 150, 100, 20);
		panel.add(textField_Name);
		textField_Name.setColumns(10);
		
		JLabel lbType = new JLabel("Type");
		lbType.setHorizontalAlignment(SwingConstants.CENTER);
		lbType.setBounds(300, 150, 100, 20);
		panel.add(lbType);
		
		textField_Address = new JTextField();
		textField_Address.setHorizontalAlignment(SwingConstants.CENTER);
		textField_Address.setBounds(150, 200, 100, 20);
		panel.add(textField_Address);
		textField_Address.setColumns(10);
		
		JLabel lbDate = new JLabel("Date");
		lbDate.setHorizontalAlignment(SwingConstants.CENTER);
		lbDate.setBounds(800, 20, 100, 20);
		panel.add(lbDate);
		
		JLabel BuyBilling = new JLabel("Buy Billing");
		BuyBilling.setHorizontalAlignment(SwingConstants.CENTER);
		BuyBilling.setBounds(435, 30, 100, 30);
		panel.add(BuyBilling);
		
		JComboBox comboBox_Type = new JComboBox();
		comboBox_Type.setBounds(400, 150, 100, 20);
		panel.add(comboBox_Type);
		
		JComboBox comboBox_Mumber = new JComboBox();
		comboBox_Mumber.setBounds(150, 100, 100, 20);
		panel.add(comboBox_Mumber);
		
		JLabel lbMember = new JLabel("Member");
		lbMember.setHorizontalAlignment(SwingConstants.CENTER);
		lbMember.setBounds(50, 100, 100, 20);
		panel.add(lbMember);
		
		JLabel lbAddress = new JLabel("Address");
		lbAddress.setHorizontalAlignment(SwingConstants.CENTER);
		lbAddress.setBounds(50, 200, 100, 20);
		panel.add(lbAddress);
		
		JLabel lbImporter = new JLabel("Importer");
		lbImporter.setHorizontalAlignment(SwingConstants.CENTER);
		lbImporter.setBounds(300, 200, 100, 20);
		panel.add(lbImporter);
		
		textField_Importer = new JTextField();
		textField_Importer.setHorizontalAlignment(SwingConstants.CENTER);
		textField_Importer.setBounds(400, 200, 100, 20);
		panel.add(textField_Importer);
		textField_Importer.setColumns(10);
		
		JLabel lbEvaluater = new JLabel("Evaluator");
		lbEvaluater.setHorizontalAlignment(SwingConstants.CENTER);
		lbEvaluater.setBounds(550, 200, 100, 20);
		panel.add(lbEvaluater);
		
		textField_Evaluater = new JTextField();
		textField_Evaluater.setHorizontalAlignment(SwingConstants.CENTER);
		textField_Evaluater.setBounds(650, 200, 100, 20);
		panel.add(textField_Evaluater);
		textField_Evaluater.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(50, 250, 850, 160);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		textField_SecretNumber = new JTextField();
		textField_SecretNumber.setHorizontalAlignment(SwingConstants.CENTER);
		textField_SecretNumber.setBounds(50, 75, 100, 20);
		panel_1.add(textField_SecretNumber);
		textField_SecretNumber.setColumns(10);
		
		textField_Size = new JTextField();
		textField_Size.setHorizontalAlignment(SwingConstants.CENTER);
		textField_Size.setBounds(200, 75, 100, 20);
		panel_1.add(textField_Size);
		textField_Size.setColumns(10);
		
		textField_TotalWeight = new JTextField();
		textField_TotalWeight.setHorizontalAlignment(SwingConstants.CENTER);
		textField_TotalWeight.setBounds(350, 75, 100, 20);
		panel_1.add(textField_TotalWeight);
		textField_TotalWeight.setColumns(10);
		
		textField_Price = new JTextField();
		textField_Price.setHorizontalAlignment(SwingConstants.CENTER);
		textField_Price.setBounds(500, 75, 100, 20);
		panel_1.add(textField_Price);
		textField_Price.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(700, 100, 100, 30);
		panel_1.add(btnSubmit);
		
		JLabel lbSecretNumber = new JLabel("Secret number");
		lbSecretNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lbSecretNumber.setBounds(50, 50, 100, 20);
		panel_1.add(lbSecretNumber);
		
		JLabel lbSize = new JLabel("Size");
		lbSize.setHorizontalAlignment(SwingConstants.CENTER);
		lbSize.setBounds(200, 50, 100, 20);
		panel_1.add(lbSize);
		
		JLabel lbTotalWeight = new JLabel("Total weight");
		lbTotalWeight.setHorizontalAlignment(SwingConstants.CENTER);
		lbTotalWeight.setBounds(350, 50, 100, 20);
		panel_1.add(lbTotalWeight);
		
		JLabel lbPrice = new JLabel("Price per kg");
		lbPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lbPrice.setBounds(500, 50, 100, 20);
		panel_1.add(lbPrice);
		
		table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setBounds(50, 450, 850, 400);
		/*DefaultTableModel model = new DefaultTableModel();
        table.setModel(new DefaultTableModel(
        	new Object[][] {
        		{null, null, null, null},
        		{null, null, null, null},
        		{null, null, null, null},
        		{null, null, null, null},
        		{null, null, null, null},
        		{null, null, null, null},
        		{null, null, null, null},
        		{null, null, null, null},
        		{null, null, null, null},
        		{null, null, null, null},
        		{null, null, null, null},
        	},
        	new String[] {
        		"a", "New column", "New column", "New column"
        	}
        ));*/
		DefaultTableModel model = new DefaultTableModel();
		table.setModel(model);
        model.addColumn("Secret number");
        model.addColumn("Size");
        model.addColumn("Total weight");
        model.addColumn("Price per kg");
        model.addRow(new Object[]{"Secret number","Size","Total weight","Price per kg"});
        model.addRow(new Object[]{"","","",""});
        model.addRow(new Object[]{"","","",""});
        model.addRow(new Object[]{"","","",""});
        model.addRow(new Object[]{"","","",""});
        model.addRow(new Object[]{"","","",""});
		
		panel.add(table);
		scrollPane.setBounds(0, 31, windowSize.width-20, windowSize.height-70);
		frame.getContentPane().add(scrollPane);
	}
	
	private void setText() {
		mnLanguage.setText(language.mnLanguage);
		mntmEnglish.setText(language.mntmEnglish);
		mntmThai.setText(language.mntmThai);
		
	}
}
