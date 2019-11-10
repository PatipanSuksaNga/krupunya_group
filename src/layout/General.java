package layout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.AbstractButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import data.*;
import process.*;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.Label;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class General {

	public JFrame frame;
	private JMenuBar menuBar = new JMenuBar();
	private JMenu mnLanguage = new JMenu(language.mnLanguage);
	private JMenuItem mntmEnglish = new JMenuItem(language.mntmEnglish);
	private JMenuItem mntmThai = new JMenuItem(language.mntmThai);

	private static DefaultTableModel buybill_model = new DefaultTableModel();
	private static DefaultTableModel pending_buybill_model = new DefaultTableModel();
	private static DefaultTableModel pay_pending_buybill_model = new DefaultTableModel();
	private static DefaultTableModel external_expenditure_model = new DefaultTableModel();

	private static DefaultTableModel sellbill_model = new DefaultTableModel();
	private static DefaultTableModel pending_sellbill_model = new DefaultTableModel();
	private static DefaultTableModel get_pending_sellbill_model = new DefaultTableModel();
	private static DefaultTableModel external_revenue_model = new DefaultTableModel();

	private JPanel panel = new JPanel();
	private JButton btnBuybilling = new JButton();
	private JButton btnSellbilling = new JButton();
	private JButton btnOnspotsale = new JButton();
	private JButton btnSizetable = new JButton();
	private JButton btnConclusion = new JButton();
	private JScrollPane scrollPane = new JScrollPane();
	private JPanel main_panel = new JPanel();
	private JLabel lbMainpage = new JLabel();
	private JLabel lbDate = new JLabel();

	private JLabel lbRevenue = new JLabel();
	private JLabel lbExpenditure = new JLabel();

	private JLabel lbTotalSellBill = new JLabel();
	private JLabel lbTotalBuyBill = new JLabel();
	private JLabel lbPendingSellBill = new JLabel();
	private JLabel lbPayPendingBuyBill = new JLabel();
	private JLabel lbPendingBuyBill = new JLabel();
	private JLabel lbGetPendingSellBill = new JLabel();
	private JLabel lbExternalRevenue = new JLabel();
	private JLabel lbExternalExpenditure = new JLabel();

	
	private JTable buybill_table;
	private JTable pending_buybill_table;
	private JTable pay_pending_buybill_table;
	private JTable external_expenditure_table;
	private JLabel lbListExp = new JLabel();
	private JLabel lbAmountExp = new JLabel();
	private Object[] ExtExpList = new Object[] { "a", "b", "c", "d", "other" };
	private JComboBox comboBox_ExtExpList = new JComboBox(ExtExpList);
	private JTextField textField_ExtExpList = new JTextField();
	private JTextField textField_ExtExpAmount;

	private JLabel lbSumSellPrice = new JLabel();
	private JLabel lbSumPendingSellPrice = new JLabel();
	private JLabel lbSumGetPendingPrice = new JLabel();
	private JLabel lbSumGetAmount = new JLabel();
	private static JLabel lbSumSellPriceNUM = new JLabel("0.0");
	private static JLabel lbSumPendingSellPriceNUM = new JLabel("0.0");
	private static JLabel lbSumGetPendingPriceNUM = new JLabel("0.0");
	private static JLabel lbSumGetAmountNUM = new JLabel("0.0");

	private JTable sellbill_table;
	private JTable pending_sellbill_table;
	private JTable get_pending_sellbill_table;
	private JTable external_revenue_table;
	private JLabel lbListRev = new JLabel();
	private JLabel lbAmountRev = new JLabel();
	private Object[] ExtRevList = new Object[] { "a", "b", "c", "d", "other" };
	private JComboBox comboBox_ExtRevList = new JComboBox(ExtRevList);
	private JTextField textField_ExtRevList = new JTextField();
	private JTextField textField_ExtRevAmount;

	private JLabel lbSumBuyPrice = new JLabel();
	private JLabel lbSumPendingBuyPrice = new JLabel();
	private JLabel lbSumPayPendingPrice = new JLabel();
	private JLabel lbSumPaidAmount = new JLabel();
	private static JLabel lbSumBuyPriceNUM = new JLabel("0.0");
	private static JLabel lbSumPendingBuyPriceNUM = new JLabel("0.0");
	private static JLabel lbSumPayPendingPriceNUM = new JLabel("0.0");
	private static JLabel lbSumPaidAmountNUM = new JLabel("0.0");

	private JButton btnFinishAll = new JButton();
	private JButton btnFetchData = new JButton("Fetch data");
	
	private void setText() {
		sellbill_table.getColumnModel().getColumn(0).setHeaderValue(language.tbhdID);
		sellbill_table.getColumnModel().getColumn(1).setHeaderValue(language.tbhdName);
		sellbill_table.getColumnModel().getColumn(2).setHeaderValue(language.tbhdPrice);
		sellbill_table.getColumnModel().getColumn(3).setHeaderValue(language.tbhdStatus);
		pending_sellbill_table.getColumnModel().getColumn(0).setHeaderValue(language.tbhdID);
		pending_sellbill_table.getColumnModel().getColumn(1).setHeaderValue(language.tbhdName);
		pending_sellbill_table.getColumnModel().getColumn(2).setHeaderValue(language.tbhdPrice);
		pending_sellbill_table.getColumnModel().getColumn(3).setHeaderValue(language.tbhdIssueDate);
		get_pending_sellbill_table.getColumnModel().getColumn(0).setHeaderValue(language.tbhdID);
		get_pending_sellbill_table.getColumnModel().getColumn(1).setHeaderValue(language.tbhdName);
		get_pending_sellbill_table.getColumnModel().getColumn(2).setHeaderValue(language.tbhdPrice);
		get_pending_sellbill_table.getColumnModel().getColumn(3).setHeaderValue(language.tbhdIssueDate);
		external_revenue_table.getColumnModel().getColumn(0).setHeaderValue(language.tbhdID);
		external_revenue_table.getColumnModel().getColumn(1).setHeaderValue(language.lbList);
		external_revenue_table.getColumnModel().getColumn(2).setHeaderValue(language.lbAmount);
		buybill_table.getColumnModel().getColumn(0).setHeaderValue(language.tbhdID);
		buybill_table.getColumnModel().getColumn(1).setHeaderValue(language.tbhdName);
		buybill_table.getColumnModel().getColumn(2).setHeaderValue(language.tbhdPrice);
		buybill_table.getColumnModel().getColumn(3).setHeaderValue(language.tbhdStatus);
		pending_buybill_table.getColumnModel().getColumn(0).setHeaderValue(language.tbhdID);
		pending_buybill_table.getColumnModel().getColumn(1).setHeaderValue(language.tbhdName);
		pending_buybill_table.getColumnModel().getColumn(2).setHeaderValue(language.tbhdPrice);
		pending_buybill_table.getColumnModel().getColumn(3).setHeaderValue(language.tbhdIssueDate);
		pay_pending_buybill_table.getColumnModel().getColumn(0).setHeaderValue(language.tbhdID);
		pay_pending_buybill_table.getColumnModel().getColumn(1).setHeaderValue(language.tbhdName);
		pay_pending_buybill_table.getColumnModel().getColumn(2).setHeaderValue(language.tbhdPrice);
		pay_pending_buybill_table.getColumnModel().getColumn(3).setHeaderValue(language.tbhdIssueDate);
		external_expenditure_table.getColumnModel().getColumn(0).setHeaderValue(language.tbhdID);
		external_expenditure_table.getColumnModel().getColumn(1).setHeaderValue(language.lbList);
		external_expenditure_table.getColumnModel().getColumn(2).setHeaderValue(language.lbAmount);
		mnLanguage.setText(language.mnLanguage);
		mntmEnglish.setText(language.mntmEnglish);
		mntmThai.setText(language.mntmThai);
		lbMainpage.setText(language.lbMainpage);
		lbDate.setText(language.lbdate);
		btnBuybilling.setText(language.btnBuybilling);
		btnSellbilling.setText(language.btnSellbilling);
		btnOnspotsale.setText(language.btnOnspotsale);
		btnSizetable.setText(language.btnSizetable);
		btnConclusion.setText(language.btnConclusion);
		btnFetchData.setText(language.btnFetchData);
		btnFinishAll.setText(language.btnFinishAll);
		lbRevenue.setText(language.lbRevenue);
		lbExpenditure.setText(language.lbExpenditure);
		lbTotalSellBill.setText(language.lbTotalSellBill);
		lbSumSellPrice.setText(language.lbSumSellPrice);
		lbSumPendingSellPrice.setText(language.lbSumPendingSellPrice);
		lbSumGetPendingPrice.setText(language.lbSumGetPendingPrice);
		lbSumGetAmount.setText(language.lbSumGetAmount);
		lbTotalBuyBill.setText(language.lbTotalBuyBill);
		lbSumBuyPrice.setText(language.lbSumBuyPrice);
		lbSumPendingBuyPrice.setText(language.lbSumPendingBuyPrice);
		lbSumPayPendingPrice.setText(language.lbSumPayPendingPrice);
		lbSumPaidAmount.setText(language.lbSumPaidAmount);
		lbPendingSellBill.setText(language.lbPendingSellBill);
		lbPendingBuyBill.setText(language.lbPendingBuyBill);
		lbGetPendingSellBill.setText(language.lbGetPendingSellBill);
		lbPayPendingBuyBill.setText(language.lbPayPendingBuyBill);
		lbExternalRevenue.setText(language.lbExternalRevenue);
		lbExternalExpenditure.setText(language.lbExternalExpenditure);
		lbListRev.setText(language.lbList);
		lbAmountRev.setText(language.lbAmount);
		lbListExp.setText(language.lbList);
		lbAmountExp.setText(language.lbAmount);
	
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					General general_window = new General();
					general_window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public General() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		frame = new JFrame("General List Account");
		frame.setSize(screenSize.width, screenSize.height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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

		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		lbMainpage.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbMainpage.setHorizontalAlignment(SwingConstants.CENTER);
		lbMainpage.setBounds((screenSize.width / 2) - 150, screenSize.height * 4 / 100, 300, 50);
		frame.getContentPane().add(lbMainpage);

		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(screenSize.width / 10, screenSize.height / 10, screenSize.width * 8 / 10,
				screenSize.height / 10);
		frame.getContentPane().add(panel);

		btnBuybilling.setBounds(40, 20, 140, 25);
		btnBuybilling.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BuyBilling buybilling_window = new BuyBilling();
				buybilling_window.frame.setVisible(true);
			}
		});
		panel.setLayout(null);
		panel.add(btnBuybilling);

		btnSellbilling.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SellBilling sellbilling_window = new SellBilling();
				sellbilling_window.frame.setVisible(true);
			}
		});
		btnSellbilling.setBounds(190, 20, 140, 25);
		panel.add(btnSellbilling);

		btnOnspotsale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OnSpotSale onspotsale_window = new OnSpotSale();
				onspotsale_window.frame.setVisible(true);
			}
		});
		btnOnspotsale.setBounds(340, 20, 140, 25);
		panel.add(btnOnspotsale);

		btnSizetable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SizeTable sizetable_window = new SizeTable();
				sizetable_window.frame.setVisible(true);
			}
		});
		btnSizetable.setBounds(490, 20, 140, 25);
		panel.add(btnSizetable);
		btnConclusion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});

		btnConclusion.setBounds(640, 20, 140, 25);
		panel.add(btnConclusion);
		
		JButton btnMembers = new JButton();
		btnMembers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnMembers.setText("Members");
		btnMembers.setBounds(40, 56, 140, 25);
		panel.add(btnMembers);

		lbDate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbDate.setHorizontalAlignment(SwingConstants.CENTER);
		lbDate.setBounds(708, 260, 500, 50);
		frame.getContentPane().add(lbDate);

		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		main_panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		main_panel.setPreferredSize(new Dimension(screenSize.width, screenSize.height * 2));
		main_panel.setBounds(0, screenSize.height * 4 / 10, screenSize.width, screenSize.height * 2);
		main_panel.setLayout(null);
		scrollPane.setBounds(0, screenSize.height * 3 / 10, screenSize.width, screenSize.height * 7 / 10);
		scrollPane.setViewportView(main_panel);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		frame.getContentPane().add(scrollPane);

		JSeparator separator = new JSeparator();
		separator.setBounds(screenSize.width / 2 - 1, 0, 2, 1500);
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setForeground(Color.WHITE);
		separator.setBackground(Color.BLACK);
		main_panel.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.WHITE);
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(0, 50, screenSize.width, 2);
		main_panel.add(separator_1);

		lbRevenue.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbRevenue.setHorizontalAlignment(SwingConstants.CENTER);
		lbRevenue.setBounds(screenSize.width / 4 - 100, 5, 200, 40);
		main_panel.add(lbRevenue);

		lbExpenditure.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbExpenditure.setHorizontalAlignment(SwingConstants.CENTER);
		lbExpenditure.setBounds(screenSize.width * 3 / 4 - 100, 5, 200, 40);
		main_panel.add(lbExpenditure);

		lbTotalBuyBill.setBounds(screenSize.width / 2 + 50, 100, 100, 25);
		main_panel.add(lbTotalBuyBill);

		lbPendingBuyBill.setBounds(screenSize.width / 2 + 50, 500, 100, 25);
		main_panel.add(lbPendingBuyBill);

		lbPayPendingBuyBill.setBounds(screenSize.width / 2 + 50, 800, 150, 25);
		main_panel.add(lbPayPendingBuyBill);

		buybill_table = new JTable();
		buybill_table.setBorder(new LineBorder(new Color(0, 0, 0)));
		buybill_table.setPreferredScrollableViewportSize(new Dimension(screenSize.width / 2 - 400, 300));
		buybill_table.setBounds(screenSize.width / 2 + 50, 150, screenSize.width / 2 - 400, 300);
		buybill_table.setModel(buybill_model);
		buybill_model.addColumn("ID");
		buybill_model.addColumn("name");
		buybill_model.addColumn("price");
		buybill_model.addColumn("status");
		JScrollPane buybill_table_sp = new JScrollPane(buybill_table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		buybill_table_sp.setBounds(screenSize.width / 2 + 50, 150, screenSize.width / 2 - 400, 300);
		buybill_table_sp.setVisible(true);
		main_panel.add(buybill_table_sp);

		pending_buybill_table = new JTable();
		pending_buybill_table.setBorder(new LineBorder(new Color(0, 0, 0)));
		pending_buybill_table.setPreferredScrollableViewportSize(new Dimension(screenSize.width / 2 - 400, 200));
		pending_buybill_table.setBounds(screenSize.width / 2 + 50, 550, screenSize.width / 2 - 400, 200);
		pending_buybill_table.setModel(pending_buybill_model);
			pending_buybill_model.addColumn("ID");
			pending_buybill_model.addColumn("name");
			pending_buybill_model.addColumn("price");
			pending_buybill_model.addColumn("issue date");
		JScrollPane pending_buybill_table_sp = new JScrollPane(pending_buybill_table,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		pending_buybill_table_sp.setBounds(screenSize.width / 2 + 50, 550, screenSize.width / 2 - 400, 200);
		pending_buybill_table_sp.setVisible(true);
		main_panel.add(pending_buybill_table_sp);

		JButton btnPayBill_buy = new JButton("Pay bill");
		btnPayBill_buy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int numRow = pending_buybill_table.getSelectedRow();
				String table_id = pending_buybill_table.getValueAt(numRow, 0).toString();

				for (int j = 0; j < BillCollections.pending_buybill.size(); j++) {
					Buybill b = BillCollections.pending_buybill.get(j);
					if ((b.id == table_id) && (b.issue_date.compareTo(dateIn.year + dateIn.month + dateIn.day) != 0)) {
						b.status = true;
						b.paid_date = dateIn.year + dateIn.month + dateIn.day;
						BillCollections.pending_buybill.remove(b);
						BillCollections.pay_pending_buybill.add(b);
						break;
					}
				}

				for (int j = 0; j < BillCollections.buybill.size(); j++) {
					if ((BillCollections.buybill.get(j).id == table_id) && (BillCollections.buybill.get(j).issue_date
							.compareTo(dateIn.year + dateIn.month + dateIn.day) == 0)) {
						for (Buybill b : BillCollections.pending_buybill) {
							if (b.id == table_id) {
								BillCollections.pending_buybill.remove(b);
								break;
							}
						}
						BillCollections.buybill.get(j).status = true;
						BillCollections.buybill.get(j).paid_date = dateIn.year + dateIn.month + dateIn.day;
						break;
					}
				}

				fetchData();
			}
		});
		btnPayBill_buy.setBounds(screenSize.width / 2 + 150, 500, 100, 25);
		main_panel.add(btnPayBill_buy);

		pay_pending_buybill_table = new JTable();
		pay_pending_buybill_table.setBorder(new LineBorder(new Color(0, 0, 0)));
		pay_pending_buybill_table.setPreferredScrollableViewportSize(new Dimension(screenSize.width / 2 - 400, 200));
		pay_pending_buybill_table.setBounds(screenSize.width / 2 + 50, 850, screenSize.width / 2 - 400, 100);
		pay_pending_buybill_table.setModel(pay_pending_buybill_model);
		pay_pending_buybill_model.addColumn("ID");
		pay_pending_buybill_model.addColumn("name");
		pay_pending_buybill_model.addColumn("price");
		pay_pending_buybill_model.addColumn("issued date");
		JScrollPane pay_pending_buybill_table_sp = new JScrollPane(pay_pending_buybill_table,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		pay_pending_buybill_table_sp.setBounds(screenSize.width / 2 + 50, 850, screenSize.width / 2 - 400, 100);
		pay_pending_buybill_table_sp.setVisible(true);
		main_panel.add(pay_pending_buybill_table_sp);

		lbExternalExpenditure.setBounds(screenSize.width / 2 + 50, 1000, 150, 25);
		main_panel.add(lbExternalExpenditure);

		JButton btnAddExtExp = new JButton("Add");
		btnAddExtExp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Expenditure exp = new Expenditure();
				exp.id = dateIn.year + dateIn.month + dateIn.day + "E" + Information.expenditure_number;
				Information.expenditure_number += 1;
				if (comboBox_ExtExpList.getSelectedItem().toString() == "other")
					exp.list = textField_ExtExpList.getText();
				else
					exp.list = comboBox_ExtExpList.getSelectedItem().toString();
				exp.amount = Integer.parseInt(textField_ExtExpAmount.getText());
				exp.issue_date = dateIn.year + dateIn.month + dateIn.day;
				External.expenditure.add(exp);
				fetchData();
			}
		});
		btnAddExtExp.setBounds(screenSize.width / 2 + 200, 1000, 100, 25);
		main_panel.add(btnAddExtExp);

		JButton btnDelExtExp = new JButton("Delete");
		btnDelExtExp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int numRows = external_expenditure_table.getSelectedRows().length;
				for (int i = 0; i < numRows; i++) {
					String id = external_expenditure_table.getValueAt(i, 0).toString();
					for (Expenditure b : External.expenditure) {
						if (b.id == id) {
							External.expenditure.remove(b);
							break;
						}
					}
				}
				fetchData();
			}
		});
		btnDelExtExp.setBounds(screenSize.width / 2 + 325, 1000, 100, 25);
		main_panel.add(btnDelExtExp);

		lbListExp.setBounds(screenSize.width / 2 + 50, 1050, 50, 25);
		main_panel.add(lbListExp);
		comboBox_ExtExpList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox_ExtExpList.getSelectedItem().toString() == "other")
					textField_ExtExpList.setVisible(true);
				else
					textField_ExtExpList.setVisible(false);
			}
		});

		comboBox_ExtExpList.setBounds(screenSize.width / 2 + 100, 1050, 150, 25);
		main_panel.add(comboBox_ExtExpList);

		textField_ExtExpList.setBounds(screenSize.width / 2 + 275, 1050, 150, 25);
		textField_ExtExpList.setColumns(10);
		textField_ExtExpList.setVisible(false);
		main_panel.add(textField_ExtExpList);

		lbAmountExp.setBounds(screenSize.width / 2 + 50, 1100, 50, 25);
		main_panel.add(lbAmountExp);

		textField_ExtExpAmount = new JTextField();
		textField_ExtExpAmount.setBounds(screenSize.width / 2 + 100, 1100, 150, 25);
		main_panel.add(textField_ExtExpAmount);
		textField_ExtExpAmount.setColumns(10);

		external_expenditure_table = new JTable();
		external_expenditure_table.setBorder(new LineBorder(new Color(0, 0, 0)));
		external_expenditure_table.setPreferredScrollableViewportSize(new Dimension(screenSize.width / 2 - 400, 200));
		external_expenditure_table.setBounds(screenSize.width / 2 + 50, 1150, screenSize.width / 2 - 400, 100);
		external_expenditure_table.setModel(external_expenditure_model);
		external_expenditure_model.addColumn("ID");
		external_expenditure_model.addColumn("List");
		external_expenditure_model.addColumn("Amount");
		JScrollPane external_expenditure_table_sp = new JScrollPane(external_expenditure_table,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		external_expenditure_table_sp.setBounds(screenSize.width / 2 + 50, 1150, screenSize.width / 2 - 400, 100);
		external_expenditure_table_sp.setVisible(true);
		main_panel.add(external_expenditure_table_sp);

		lbSumBuyPrice.setHorizontalAlignment(SwingConstants.LEFT);
		lbSumBuyPrice.setBounds(screenSize.width * 82 / 100, 150, screenSize.width * 8 / 100, 25);
		main_panel.add(lbSumBuyPrice);

		lbSumPendingBuyPrice.setHorizontalAlignment(SwingConstants.LEFT);
		lbSumPendingBuyPrice.setBounds(screenSize.width * 82 / 100, 200, screenSize.width * 8 / 100, 25);
		main_panel.add(lbSumPendingBuyPrice);

		lbSumPayPendingPrice.setHorizontalAlignment(SwingConstants.LEFT);
		lbSumPayPendingPrice.setBounds(screenSize.width * 82 / 100, 250, screenSize.width * 8 / 100, 25);
		main_panel.add(lbSumPayPendingPrice);

		lbSumPaidAmount.setHorizontalAlignment(SwingConstants.LEFT);
		lbSumPaidAmount.setBounds(screenSize.width * 82 / 100, 300, screenSize.width * 8 / 100, 25);
		main_panel.add(lbSumPaidAmount);

		lbSumBuyPriceNUM.setBounds(screenSize.width * 91 / 100, 150, 150, 25);
		main_panel.add(lbSumBuyPriceNUM);

		lbSumPendingBuyPriceNUM.setBounds(screenSize.width * 91 / 100, 200, 150, 25);
		main_panel.add(lbSumPendingBuyPriceNUM);

		lbSumPayPendingPriceNUM.setBounds(screenSize.width * 91 / 100, 250, 150, 25);
		main_panel.add(lbSumPayPendingPriceNUM);

		lbSumPaidAmountNUM.setBounds(screenSize.width * 91 / 100, 300, 150, 25);
		main_panel.add(lbSumPaidAmountNUM);

		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		lbTotalSellBill.setBounds(screenSize.width / 2 - (screenSize.width / 2 - 400) - 50, 100, 100, 25);
		main_panel.add(lbTotalSellBill);

		lbPendingSellBill.setBounds(screenSize.width / 2 - (screenSize.width / 2 - 400) - 50, 500, 100, 25);
		main_panel.add(lbPendingSellBill);

		lbGetPendingSellBill.setBounds(screenSize.width / 2 - (screenSize.width / 2 - 400) - 50, 800, 150, 25);
		main_panel.add(lbGetPendingSellBill);

		sellbill_table = new JTable();
		sellbill_table.setBorder(new LineBorder(new Color(0, 0, 0)));
		sellbill_table.setPreferredScrollableViewportSize(new Dimension(screenSize.width / 2 - 400, 300));
		sellbill_table.setBounds(screenSize.width / 2 - (screenSize.width / 2 - 400) - 50, 150,
				screenSize.width / 2 - 400, 300);
		sellbill_table.setModel(sellbill_model);
		sellbill_model.addColumn("ID");
		sellbill_model.addColumn("name");
		sellbill_model.addColumn("price");
		sellbill_model.addColumn("status");
		JScrollPane sellbill_table_sp = new JScrollPane(sellbill_table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		sellbill_table_sp.setBounds(screenSize.width / 2 - (screenSize.width / 2 - 400) - 50, 150,
				screenSize.width / 2 - 400, 300);
		sellbill_table_sp.setVisible(true);
		main_panel.add(sellbill_table_sp);

		pending_sellbill_table = new JTable();
		pending_sellbill_table.setBorder(new LineBorder(new Color(0, 0, 0)));
		pending_sellbill_table.setPreferredScrollableViewportSize(new Dimension(screenSize.width / 2 - 400, 200));
		pending_sellbill_table.setBounds(screenSize.width / 2 - (screenSize.width / 2 - 400) - 50, 550,
				screenSize.width / 2 - 400, 200);
		pending_sellbill_table.setModel(pending_sellbill_model);
		pending_sellbill_model.addColumn("ID");
		pending_sellbill_model.addColumn("name");
		pending_sellbill_model.addColumn("price");
		pending_sellbill_model.addColumn("issue date");
		JScrollPane pending_sellbill_table_sp = new JScrollPane(pending_sellbill_table,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		pending_sellbill_table_sp.setBounds(screenSize.width / 2 - (screenSize.width / 2 - 400) - 50, 550,
				screenSize.width / 2 - 400, 200);
		pending_sellbill_table_sp.setVisible(true);
		main_panel.add(pending_sellbill_table_sp);

		JButton btnPayBill_sell = new JButton("Get sell bill");
		btnPayBill_sell.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int numRows = pending_sellbill_table.getSelectedRows().length;
				for (int i = 0; i < numRows; i++) {
					String id = pending_sellbill_table.getValueAt(i, 0).toString();
					for (Sellbill b : BillCollections.pending_sellbill) {
						if (b.id == id) {
							BillCollections.pending_sellbill.remove(b);
							b.status = true;
							b.paid_date = dateIn.year + dateIn.month + dateIn.day;
							BillCollections.get_pending_sellbill.add(b);
							break;
						}
					}
					for (Sellbill b : BillCollections.sellbill) {
						if (b.id == id) {
							BillCollections.sellbill.remove(b);
							b.status = true;
							b.paid_date = dateIn.year + dateIn.month + dateIn.day;
							BillCollections.sellbill.add(b);
							break;
						}
					}
				}
				fetchData();
			}
		});
		btnPayBill_sell.setBounds(screenSize.width / 2 - (screenSize.width / 2 - 400) - 50 + 100, 500, 100, 25);
		main_panel.add(btnPayBill_sell);

		get_pending_sellbill_table = new JTable();
		get_pending_sellbill_table.setBorder(new LineBorder(new Color(0, 0, 0)));
		get_pending_sellbill_table.setPreferredScrollableViewportSize(new Dimension(screenSize.width / 2 - 400, 200));
		get_pending_sellbill_table.setBounds(screenSize.width / 2 - (screenSize.width / 2 - 400) - 50, 850,
				screenSize.width / 2 - 400, 100);
		get_pending_sellbill_table.setModel(get_pending_sellbill_model);
		get_pending_sellbill_model.addColumn("ID");
		get_pending_sellbill_model.addColumn("name");
		get_pending_sellbill_model.addColumn("price");
		get_pending_sellbill_model.addColumn("issued date");
		JScrollPane get_pending_sellbill_table_sp = new JScrollPane(get_pending_sellbill_table,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		get_pending_sellbill_table_sp.setBounds(screenSize.width / 2 - (screenSize.width / 2 - 400) - 50, 850,
				screenSize.width / 2 - 400, 100);
		get_pending_sellbill_table_sp.setVisible(true);
		main_panel.add(get_pending_sellbill_table_sp);

		lbExternalRevenue.setBounds(screenSize.width / 2 - (screenSize.width / 2 - 400) - 50, 1000, 150, 25);
		main_panel.add(lbExternalRevenue);

		JButton btnAddExtRev = new JButton("Add");
		btnAddExtRev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Revenue rev = new Revenue();
				rev.id = dateIn.year + dateIn.month + dateIn.day + "R" + Information.revenue_number;
				Information.revenue_number += 1;
				if (comboBox_ExtRevList.getSelectedItem().toString() == "other")
					rev.list = textField_ExtRevList.getText();
				else
					rev.list = comboBox_ExtRevList.getSelectedItem().toString();
				rev.amount = Integer.parseInt(textField_ExtRevAmount.getText());
				rev.issue_date = dateIn.year + dateIn.month + dateIn.day;
				External.revenue.add(rev);
				fetchData();
			}
		});
		btnAddExtRev.setBounds(screenSize.width / 2 - (screenSize.width / 2 - 400) - 50 + 150, 1000, 100, 25);
		main_panel.add(btnAddExtRev);

		JButton btnDelExtRev = new JButton("Delete");
		btnDelExtRev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int numRows = external_revenue_table.getSelectedRows().length;
				for (int i = 0; i < numRows; i++) {
					String id = external_revenue_table.getValueAt(i, 0).toString();
					for (Revenue b : External.revenue) {
						if (b.id == id) {
							External.revenue.remove(b);
							break;
						}
					}
				}
				fetchData();
			}
		});
		btnDelExtRev.setBounds(screenSize.width / 2 - (screenSize.width / 2 - 400) - 50 + 270, 1000, 100, 25);
		main_panel.add(btnDelExtRev);

		lbListRev.setBounds(screenSize.width / 2 - (screenSize.width / 2 - 400) - 50, 1050, 50, 25);
		main_panel.add(lbListRev);
		comboBox_ExtRevList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox_ExtRevList.getSelectedItem().toString() == "other")
					textField_ExtRevList.setVisible(true);
				else
					textField_ExtRevList.setVisible(false);
			}
		});

		comboBox_ExtRevList.setBounds(screenSize.width / 2 - (screenSize.width / 2 - 400) - 50 + 50, 1050, 150, 25);
		main_panel.add(comboBox_ExtRevList);

		textField_ExtRevList.setBounds(screenSize.width / 2 - (screenSize.width / 2 - 400) - 50 + 225, 1050, 150, 25);
		textField_ExtRevList.setColumns(10);
		textField_ExtRevList.setVisible(false);
		main_panel.add(textField_ExtRevList);

		lbAmountRev.setBounds(screenSize.width / 2 - (screenSize.width / 2 - 400) - 50, 1100, 50, 25);
		main_panel.add(lbAmountRev);

		textField_ExtRevAmount = new JTextField();
		textField_ExtRevAmount.setBounds(screenSize.width / 2 - (screenSize.width / 2 - 400) - 50 + 50, 1100, 150, 25);
		main_panel.add(textField_ExtRevAmount);
		textField_ExtRevAmount.setColumns(10);

		external_revenue_table = new JTable();
		external_revenue_table.setBorder(new LineBorder(new Color(0, 0, 0)));
		external_revenue_table.setPreferredScrollableViewportSize(new Dimension(screenSize.width / 2 - 400, 200));
		external_revenue_table.setBounds(screenSize.width / 2 - (screenSize.width / 2 - 400) - 50, 1150,
				screenSize.width / 2 - 400, 100);
		external_revenue_table.setModel(external_revenue_model);
		external_revenue_model.addColumn("ID");
		external_revenue_model.addColumn("List");
		external_revenue_model.addColumn("Amount");
		JScrollPane external_revenue_table_sp = new JScrollPane(external_revenue_table,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		external_revenue_table_sp.setBounds(screenSize.width / 2 - (screenSize.width / 2 - 400) - 50, 1150,
				screenSize.width / 2 - 400, 100);
		external_revenue_table_sp.setVisible(true);
		main_panel.add(external_revenue_table_sp);

		lbSumSellPrice.setHorizontalAlignment(SwingConstants.LEFT);
		lbSumSellPrice.setBounds(screenSize.width * 2 / 100, 150, screenSize.width * 8 / 100, 25);
		main_panel.add(lbSumSellPrice);

		lbSumPendingSellPrice.setHorizontalAlignment(SwingConstants.LEFT);
		lbSumPendingSellPrice.setBounds(screenSize.width * 2 / 100, 200, screenSize.width * 8 / 100, 25);
		main_panel.add(lbSumPendingSellPrice);

		lbSumGetPendingPrice.setHorizontalAlignment(SwingConstants.LEFT);
		lbSumGetPendingPrice.setBounds(screenSize.width * 2 / 100, 250, screenSize.width * 8 / 100, 25);
		main_panel.add(lbSumGetPendingPrice);

		lbSumGetAmount.setHorizontalAlignment(SwingConstants.LEFT);
		lbSumGetAmount.setBounds(screenSize.width * 2 / 100, 300, screenSize.width * 8 / 100, 25);
		main_panel.add(lbSumGetAmount);

		lbSumSellPriceNUM.setBounds(screenSize.width * 11 / 100, 150, 150, 25);
		main_panel.add(lbSumSellPriceNUM);

		lbSumPendingSellPriceNUM.setBounds(screenSize.width * 11 / 100, 200, 150, 25);
		main_panel.add(lbSumPendingSellPriceNUM);

		lbSumGetPendingPriceNUM.setBounds(screenSize.width * 11 / 100, 250, 150, 25);
		main_panel.add(lbSumGetPendingPriceNUM);

		lbSumGetAmountNUM.setBounds(screenSize.width * 11 / 100, 300, 150, 25);
		main_panel.add(lbSumGetAmountNUM);

		btnFinishAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DatabaseHandler.PushData();
				fetchData();
			}
		});
		btnFinishAll.setBounds(1761, 108, 120, 120);
		frame.getContentPane().add(btnFinishAll);
		btnFetchData.setBounds(1761, 41, 120, 50);
		frame.getContentPane().add(btnFetchData);
		btnFetchData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fetchData();
			}
		});

		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		fetchData();
		setText();

	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static void fetchData() {

		Information.total_buy = 0.0;
		Information.credit_buy = 0.0;
		Information.recredit_buy = 0.0;
		Information.external_expenditure = 0;

		for (int i = buybill_model.getRowCount() - 1; i > -1; i--)
			buybill_model.removeRow(i);
		for (int i = 0; i < BillCollections.buybill.size(); i++) {
			String name = BillCollections.buybill.get(i).name, status = "paid", id = BillCollections.buybill.get(i).id;
			double price = 0.0;
			if (!BillCollections.buybill.get(i).status)
				status = "pending";
			for (int p = 0; p < BillCollections.buybill.get(i).product.size(); p++)
				price += BillCollections.buybill.get(i).product.get(p).price
						* BillCollections.buybill.get(i).product.get(p).weight;
			buybill_model.addRow(new Object[] { id, name, price, status });
			Information.total_buy += price;
		}
		lbSumBuyPriceNUM.setText(Information.total_buy + "");

		for (int i = pending_buybill_model.getRowCount() - 1; i > -1; i--)
			pending_buybill_model.removeRow(i);
		for (int i = 0; i < BillCollections.pending_buybill.size(); i++) {
			String name = BillCollections.pending_buybill.get(i).name,
					issue_date = BillCollections.pending_buybill.get(i).issue_date,
					id = BillCollections.pending_buybill.get(i).id;
			double price = 0.0;
			for (int p = 0; p < BillCollections.pending_buybill.get(i).product.size(); p++)
				price += BillCollections.pending_buybill.get(i).product.get(p).price
						* BillCollections.pending_buybill.get(i).product.get(p).weight;
			pending_buybill_model.addRow(new Object[] { id, name, price, issue_date });
			Information.credit_buy += price;
		}

		/*
		 * for(int i=buybill_model.getRowCount()-1;i>-1;i--) {
		 * if(buybill_model.getValueAt(i, 3) == "pending") Information.credit_buy +=
		 * Double.parseDouble(buybill_model.getValueAt(i, 2).toString()); }
		 */
		lbSumPendingBuyPriceNUM.setText(Information.credit_buy + "");

		for (int i = pay_pending_buybill_model.getRowCount() - 1; i > -1; i--)
			pay_pending_buybill_model.removeRow(i);
		for (int i = 0; i < BillCollections.pay_pending_buybill.size(); i++) {
			String name = BillCollections.pay_pending_buybill.get(i).name,
					issue_date = BillCollections.pay_pending_buybill.get(i).issue_date,
					id = BillCollections.pay_pending_buybill.get(i).id;
			double price = 0.0;
			for (int p = 0; p < BillCollections.pay_pending_buybill.get(i).product.size(); p++)
				price += BillCollections.pay_pending_buybill.get(i).product.get(p).price
						* BillCollections.pay_pending_buybill.get(i).product.get(p).weight;
			pay_pending_buybill_model.addRow(new Object[] { id, name, price, issue_date });
			Information.recredit_buy += price;
		}
		lbSumPayPendingPriceNUM.setText(Information.recredit_buy + "");

		lbSumPaidAmountNUM.setText((Information.total_buy - Information.credit_buy) + "");

		for (int i = external_expenditure_model.getRowCount() - 1; i > -1; i--)
			external_expenditure_model.removeRow(i);
		for (int i = 0; i < External.expenditure.size(); i++) {
			String list = External.expenditure.get(i).list, id = External.expenditure.get(i).id;
			int amount = External.expenditure.get(i).amount;
			external_expenditure_model.addRow(new Object[] { id, list, amount });
			Information.external_expenditure += amount;
		}

		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		Information.total_sell = 0.0;
		Information.credit_sell = 0.0;
		Information.recredit_sell = 0.0;

		for (int i = sellbill_model.getRowCount() - 1; i > -1; i--)
			sellbill_model.removeRow(i);
		for (int i = 0; i < BillCollections.sellbill.size(); i++) {
			String name = BillCollections.sellbill.get(i).name, status = "paid",
					id = BillCollections.sellbill.get(i).id;
			double price = 0.0;
			if (!BillCollections.sellbill.get(i).status)
				status = "pending";
			for (int p = 0; p < BillCollections.sellbill.get(i).product.size(); p++)
				price += BillCollections.sellbill.get(i).product.get(p).price
						* BillCollections.sellbill.get(i).product.get(p).weight;
			sellbill_model.addRow(new Object[] { id, name, price, status });
			Information.total_sell += price;
		}
		lbSumSellPriceNUM.setText(Information.total_sell + "");

		for (int i = pending_sellbill_model.getRowCount() - 1; i > -1; i--)
			pending_sellbill_model.removeRow(i);
		for (int i = 0; i < BillCollections.pending_sellbill.size(); i++) {
			String name = BillCollections.pending_sellbill.get(i).name,
					issue_date = BillCollections.pending_sellbill.get(i).issue_date,
					id = BillCollections.pending_sellbill.get(i).id;
			double price = 0.0;
			for (int p = 0; p < BillCollections.pending_sellbill.get(i).product.size(); p++)
				price += BillCollections.pending_sellbill.get(i).product.get(p).price
						* BillCollections.pending_sellbill.get(i).product.get(p).weight;
			pending_sellbill_model.addRow(new Object[] { id, name, price, issue_date });
		}

		for (int i = sellbill_model.getRowCount() - 1; i > -1; i--) {
			if (sellbill_model.getValueAt(i, 3) == "pending")
				Information.credit_sell += Double.parseDouble(sellbill_model.getValueAt(i, 2).toString());
		}
		lbSumPendingSellPriceNUM.setText(Information.credit_sell + "");

		for (int i = get_pending_sellbill_model.getRowCount() - 1; i > -1; i--)
			get_pending_sellbill_model.removeRow(i);
		for (int i = 0; i < BillCollections.get_pending_sellbill.size(); i++) {
			String name = BillCollections.get_pending_sellbill.get(i).name,
					issue_date = BillCollections.get_pending_sellbill.get(i).issue_date,
					id = BillCollections.get_pending_sellbill.get(i).id;
			double price = 0.0;
			for (int p = 0; p < BillCollections.get_pending_sellbill.get(i).product.size(); p++)
				price += BillCollections.get_pending_sellbill.get(i).product.get(p).price
						* BillCollections.get_pending_sellbill.get(i).product.get(p).weight;
			get_pending_sellbill_model.addRow(new Object[] { id, name, price, issue_date });
			Information.recredit_sell += price;
		}
		lbSumGetPendingPriceNUM.setText(Information.recredit_sell + "");

		lbSumGetAmountNUM.setText((Information.total_sell - Information.credit_sell) + "");

		for (int i = external_revenue_model.getRowCount() - 1; i > -1; i--)
			external_revenue_model.removeRow(i);
		for (int i = 0; i < External.revenue.size(); i++) {
			String list = External.revenue.get(i).list, id = External.revenue.get(i).id;
			int amount = External.revenue.get(i).amount;
			external_revenue_model.addRow(new Object[] { id, list, amount });
			Information.external_revenue += amount;
		}

		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		Information.total_expenditure = (Information.total_buy - Information.credit_buy)
				+ Information.external_expenditure;
		Information.total_revenue = (Information.total_sell - Information.credit_sell) + Information.external_revenue;
		Information.balance = Information.total_revenue - Information.total_expenditure;
	}
}
