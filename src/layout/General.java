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

public class General {

	public JFrame frame;
	JMenuBar menuBar = new JMenuBar();
	JMenu mnLanguage = new JMenu(language.mnLanguage);
	JMenuItem mntmEnglish = new JMenuItem(language.mntmEnglish);
	JMenuItem mntmThai = new JMenuItem(language.mntmThai);
	static DefaultTableModel buybill_model = new DefaultTableModel();
	static DefaultTableModel pending_buybill_model = new DefaultTableModel();
	static DefaultTableModel pay_pending_buybill_model = new DefaultTableModel();
	static DefaultTableModel sellbill_model = new DefaultTableModel();
	static DefaultTableModel pending_sellbill_model = new DefaultTableModel();
	static DefaultTableModel get_pending_sellbill_model = new DefaultTableModel();
	
	private final JPanel panel = new JPanel();
	private final JButton btnBuybilling = new JButton("Buy Billing");
	private final JButton btnSellbilling = new JButton("Sell Billing");
	private final JButton btnOnspotsale = new JButton("On spot sale");
	private final JButton btnSizetable = new JButton("Size Table");
	private final JButton btnConclusion = new JButton("Conclusion");
	private final JScrollPane scrollPane = new JScrollPane();
	private final JPanel main_panel = new JPanel();
	private final JLabel lbMainpage = new JLabel("Main Page");
	private final JLabel lbDate = new JLabel("Date ");
	private final JButton btnFetchData = new JButton("Fetch data");
	private JTable buybill_table;
	private JTable pending_buybill_table;
	private JTable pay_pending_buybill_table;
	private JTable sellbill_table;
	private JTable pending_sellbill_table;
	private JTable get_pending_sellbill_table;
	private final JLabel lbSumBuyPrice = new JLabel("Sum buy price ");
	private final JLabel lbSumPendingPrice = new JLabel("Sum pending price ");
	private final JLabel lbSumPayPendingPrice = new JLabel("Sum pay pending price ");
	private final JLabel lbSumPaidAmount = new JLabel("Sum paid amount ");
	private static JLabel lbSumBuyPriceNUM = new JLabel("0.0");
	private static JLabel lbSumPendingPriceNUM = new JLabel("0.0");
	private static JLabel lbSumPayPendingPriceNUM = new JLabel("0.0");
	private static JLabel lbSumPaidAmountNUM = new JLabel("0.0");

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
		
		setText();
		//fetchData();
		
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
		lbMainpage.setBounds((screenSize.width/2)-150, screenSize.height*4/100, 300, 50);
		frame.getContentPane().add(lbMainpage);
		
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(screenSize.width/10, screenSize.height/10, screenSize.width*8/10, screenSize.height/10);
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
		
		btnOnspotsale.setBounds(340, 20, 140, 25);
		panel.add(btnOnspotsale);
		
		btnSizetable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SizeTable sizetablw_window = new SizeTable();
				sizetablw_window.frame.setVisible(true);
			}
		});
		btnSizetable.setBounds(490, 20, 140, 25);
		panel.add(btnSizetable);
		
		btnConclusion.setBounds(640, 20, 140, 25);
		panel.add(btnConclusion);
		
		lbDate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbDate.setHorizontalAlignment(SwingConstants.CENTER);
		lbDate.setBounds(screenSize.width/2-250, screenSize.width*13/100, 500, 50);
		frame.getContentPane().add(lbDate);
		
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		main_panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		main_panel.setPreferredSize(new Dimension(screenSize.width,screenSize.height*2));
		main_panel.setBounds(0,screenSize.height*4/10,screenSize.width,screenSize.height*2);
		main_panel.setLayout(null);
		scrollPane.setBounds(0,screenSize.height*3/10,screenSize.width,screenSize.height*7/10);
		scrollPane.setViewportView(main_panel);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		frame.getContentPane().add(scrollPane);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(screenSize.width/2-1, 0, 2, screenSize.height*2);
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setForeground(Color.WHITE);
		separator.setBackground(Color.BLACK);
		main_panel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.WHITE);
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(0, 50, screenSize.width, 2);
		main_panel.add(separator_1);
		
		JLabel lbRevenue = new JLabel("Revenue");
		lbRevenue.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbRevenue.setHorizontalAlignment(SwingConstants.CENTER);
		lbRevenue.setBounds(screenSize.width/4-100, 5, 200, 40);
		main_panel.add(lbRevenue);
		
		JLabel lbExpenditure = new JLabel("Expenditure");
		lbExpenditure.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbExpenditure.setHorizontalAlignment(SwingConstants.CENTER);
		lbExpenditure.setBounds(screenSize.width*3/4-100, 5, 200, 40);
		main_panel.add(lbExpenditure);
		
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		JLabel lbTotalBuyBill = new JLabel("Total Buy bill");
		lbTotalBuyBill.setBounds(screenSize.width/2+50, 100, 100, 25);
		main_panel.add(lbTotalBuyBill);	
		
		JLabel lbPendingBuyBill = new JLabel("Pending buy bill");
		lbPendingBuyBill.setBounds(screenSize.width/2+50, 500, 100, 25);
		main_panel.add(lbPendingBuyBill);
		
		JLabel lbPayPendingBuyBill = new JLabel("Pay pending buy bill");
		lbPayPendingBuyBill.setBounds(screenSize.width/2+50, 800, 150, 25);
		main_panel.add(lbPayPendingBuyBill);
		
		btnFetchData.setBounds(screenSize.width/2+150, 100, 100, 25);
		btnFetchData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fetchData();
			}
		});
		main_panel.add(btnFetchData);
		
		buybill_table = new JTable();
		buybill_table.setBorder(new LineBorder(new Color(0, 0, 0)));
		buybill_table.setPreferredScrollableViewportSize(new Dimension(screenSize.width/2-400,300));
		buybill_table.setBounds(screenSize.width/2+50, 150, screenSize.width/2-400, 300);
		buybill_table.setModel(buybill_model);
		buybill_model.addColumn("ID");
		buybill_model.addColumn("name");
		buybill_model.addColumn("price");
		buybill_model.addColumn("status");
		JScrollPane buybill_table_sp = new JScrollPane(	buybill_table,
														JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
														JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		buybill_table_sp.setBounds(screenSize.width/2+50, 150, screenSize.width/2-400, 300);
		buybill_table_sp.setVisible(true);
		main_panel.add(buybill_table_sp);
		
		pending_buybill_table = new JTable();
		pending_buybill_table.setBorder(new LineBorder(new Color(0, 0, 0)));
		pending_buybill_table.setPreferredScrollableViewportSize(new Dimension(screenSize.width/2-400,200));
		pending_buybill_table.setBounds(screenSize.width/2+50, 550, screenSize.width/2-400, 200);
		pending_buybill_table.setModel(pending_buybill_model);
		pending_buybill_model.addColumn("ID");
		pending_buybill_model.addColumn("name");
		pending_buybill_model.addColumn("price");
		pending_buybill_model.addColumn("issue date");
		JScrollPane pending_buybill_table_sp = new JScrollPane(	pending_buybill_table,
																JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
																JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		pending_buybill_table_sp.setBounds(screenSize.width/2+50, 550, screenSize.width/2-400, 200);
		pending_buybill_table_sp.setVisible(true);
		main_panel.add(pending_buybill_table_sp);
		
		JButton btnPayBill = new JButton("Pay bill");
		btnPayBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int numRows = pending_buybill_table.getSelectedRows().length;
				for(int i=0; i<numRows ; i++ ) {
					String id = pending_buybill_table.getValueAt(i, 0).toString();
					for(Buybill b:BillCollections.pending_buybill) {
						if(b.id == id) {
							BillCollections.pending_buybill.remove(b);
							b.status = true;
							b.paid_date = dateIn.year + dateIn.month + dateIn.day;
							BillCollections.pay_pending_buybill.add(b);
							break;
						}
					}
				}
				fetchData();
			}
		});
		btnPayBill.setBounds(screenSize.width/2+150, 500, 100, 25);
		main_panel.add(btnPayBill);
		
		pay_pending_buybill_table = new JTable();
		pay_pending_buybill_table.setBorder(new LineBorder(new Color(0, 0, 0)));
		pay_pending_buybill_table.setPreferredScrollableViewportSize(new Dimension(screenSize.width/2-400,200));
		pay_pending_buybill_table.setBounds(screenSize.width/2+50, 850, screenSize.width/2-400, 100);
		pay_pending_buybill_table.setModel(pay_pending_buybill_model);
		pay_pending_buybill_model.addColumn("ID");
		pay_pending_buybill_model.addColumn("name");
		pay_pending_buybill_model.addColumn("price");
		pay_pending_buybill_model.addColumn("issued date");
		JScrollPane pay_pending_buybill_table_sp = new JScrollPane(	pay_pending_buybill_table,
																	JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
																	JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		pay_pending_buybill_table_sp.setBounds(screenSize.width/2+50, 850, screenSize.width/2-400, 100);
		pay_pending_buybill_table_sp.setVisible(true);
		main_panel.add(pay_pending_buybill_table_sp);
		
		lbSumBuyPrice.setHorizontalAlignment(SwingConstants.LEFT);
		lbSumBuyPrice.setBounds(screenSize.width*82/100, 150, screenSize.width*8/100, 25);
		main_panel.add(lbSumBuyPrice);
		
		lbSumPendingPrice.setHorizontalAlignment(SwingConstants.LEFT);
		lbSumPendingPrice.setBounds(screenSize.width*82/100, 200, screenSize.width*8/100, 25);
		main_panel.add(lbSumPendingPrice);
		
		lbSumPayPendingPrice.setHorizontalAlignment(SwingConstants.LEFT);
		lbSumPayPendingPrice.setBounds(screenSize.width*82/100, 250, screenSize.width*8/100, 25);
		main_panel.add(lbSumPayPendingPrice);
		
		lbSumPaidAmount.setHorizontalAlignment(SwingConstants.LEFT);
		lbSumPaidAmount.setBounds(screenSize.width*82/100, 300, screenSize.width*8/100, 25);
		main_panel.add(lbSumPaidAmount);
		
		lbSumBuyPriceNUM.setBounds(screenSize.width*91/100, 150, 150, 25);
		main_panel.add(lbSumBuyPriceNUM);
		
		lbSumPendingPriceNUM.setBounds(screenSize.width*91/100, 200, 150, 25);
		main_panel.add(lbSumPendingPriceNUM);
		
		lbSumPayPendingPriceNUM.setBounds(screenSize.width*91/100, 250, 150, 25);
		main_panel.add(lbSumPayPendingPriceNUM);
		
		lbSumPaidAmountNUM.setBounds(screenSize.width*91/100, 300, 150, 25);
		main_panel.add(lbSumPaidAmountNUM);
		
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		JLabel lbTotalSellBill = new JLabel("Total sell bill");
		lbTotalSellBill.setBounds(screenSize.width/2-(screenSize.width/2-400)-50, 100, 100, 25);
		main_panel.add(lbTotalSellBill);	
		
		JLabel lbPendingSellBill = new JLabel("Pending sell bill");
		lbPendingSellBill.setBounds(screenSize.width/2-(screenSize.width/2-400)-50, 500, 100, 25);
		main_panel.add(lbPendingSellBill);
		
		JLabel lbGetPendingSellBill = new JLabel("Get pending sell bill");
		lbGetPendingSellBill.setBounds(screenSize.width/2-(screenSize.width/2-400)-50, 800, 150, 25);
		main_panel.add(lbGetPendingSellBill);
		
		sellbill_table = new JTable();
		sellbill_table.setBorder(new LineBorder(new Color(0, 0, 0)));
		sellbill_table.setPreferredScrollableViewportSize(new Dimension(screenSize.width/2-400,300));
		sellbill_table.setBounds(screenSize.width/2-(screenSize.width/2-400)-50, 150, screenSize.width/2-400, 300);
		sellbill_table.setModel(sellbill_model);
		sellbill_model.addColumn("ID");
		sellbill_model.addColumn("name");
		sellbill_model.addColumn("price");
		sellbill_model.addColumn("status");
		JScrollPane sellbill_table_sp = new JScrollPane(	sellbill_table,
														JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
														JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		sellbill_table_sp.setBounds(screenSize.width/2-(screenSize.width/2-400)-50, 150, screenSize.width/2-400, 300);
		sellbill_table_sp.setVisible(true);
		main_panel.add(sellbill_table_sp);
		
		pending_sellbill_table = new JTable();
		pending_sellbill_table.setBorder(new LineBorder(new Color(0, 0, 0)));
		pending_sellbill_table.setPreferredScrollableViewportSize(new Dimension(screenSize.width/2-400,200));
		pending_sellbill_table.setBounds(screenSize.width/2-(screenSize.width/2-400)-50, 550, screenSize.width/2-400, 200);
		pending_sellbill_table.setModel(pending_sellbill_model);
		pending_sellbill_model.addColumn("ID");
		pending_sellbill_model.addColumn("name");
		pending_sellbill_model.addColumn("price");
		pending_sellbill_model.addColumn("issue date");
		JScrollPane pending_sellbill_table_sp = new JScrollPane(	pending_sellbill_table,
																JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
																JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		pending_sellbill_table_sp.setBounds(screenSize.width/2-(screenSize.width/2-400)-50, 550, screenSize.width/2-400, 200);
		pending_sellbill_table_sp.setVisible(true);
		main_panel.add(pending_sellbill_table_sp);
		
		JButton btnPayBill_sell = new JButton("Get sell bill");
		btnPayBill_sell.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int numRows = pending_sellbill_table.getSelectedRows().length;
				for(int i=0; i<numRows ; i++ ) {
					String id = pending_sellbill_table.getValueAt(i, 0).toString();
					for(Sellbill b:BillCollections.pending_sellbill) {
						if(b.id == id) {
							BillCollections.pending_sellbill.remove(b);
							b.status = true;
							b.paid_date = dateIn.year + dateIn.month + dateIn.day;
							BillCollections.pay_pending_sellbill.add(b);
							break;
						}
					}
				}
				fetchData();
			}
		});
		btnPayBill_sell.setBounds(screenSize.width/2-(screenSize.width/2-400)-50+150, 500, 100, 25);
		main_panel.add(btnPayBill_sell);
		
		get_pending_sellbill_table = new JTable();
		get_pending_sellbill_table.setBorder(new LineBorder(new Color(0, 0, 0)));
		get_pending_sellbill_table.setPreferredScrollableViewportSize(new Dimension(screenSize.width/2-400,200));
		get_pending_sellbill_table.setBounds(screenSize.width/2-(screenSize.width/2-400)-50, 850, screenSize.width/2-400, 100);
		get_pending_sellbill_table.setModel(get_pending_sellbill_model);
		get_pending_sellbill_model.addColumn("ID");
		get_pending_sellbill_model.addColumn("name");
		get_pending_sellbill_model.addColumn("price");
		get_pending_sellbill_model.addColumn("issued date");
		JScrollPane get_pending_sellbill_table_sp = new JScrollPane(	get_pending_sellbill_table,
																	JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
																	JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		get_pending_sellbill_table_sp.setBounds(screenSize.width/2-(screenSize.width/2-400)-50, 850, screenSize.width/2-400, 100);
		get_pending_sellbill_table_sp.setVisible(true);
		main_panel.add(get_pending_sellbill_table_sp);
		
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	}
	
	private void setText() {
		mnLanguage.setText(language.mnLanguage);
		mntmEnglish.setText(language.mntmEnglish);
		mntmThai.setText(language.mntmThai);
		lbMainpage.setText(language.lbMainpage);
		lbDate.setText(language.date);
		btnBuybilling.setText(language.btnBuybilling);
		btnSellbilling.setText(language.btnSellbilling);
		btnOnspotsale.setText(language.btnOnspotsale);
		btnSizetable.setText(language.btnSizetable);
		btnConclusion.setText(language.btnConclusion);
	}
	public static void fetchData() {
		
		Information.total_buy = 0.0;
		Information.credit_buy = 0.0;
		Information.recredit_buy = 0.0;
		
		for(int i=buybill_model.getRowCount()-1;i>-1;i--)
			buybill_model.removeRow(i);
		for(int i=0;i<BillCollections.buybill.size();i++) { 
			String 	name = BillCollections.buybill.get(i).name,
					status = "paid",
					id = BillCollections.buybill.get(i).id;
			double 	price = 0.0;
			if(!BillCollections.buybill.get(i).status)
				status = "pending";
			for(int p=0;p<BillCollections.buybill.get(i).product.size();p++)
				price += BillCollections.buybill.get(i).product.get(p).price 
						 * BillCollections.buybill.get(i).product.get(p).weight;
			buybill_model.addRow(new Object[] {id,name,price,status});
			Information.total_buy += price;
		}
		lbSumBuyPriceNUM.setText(Information.total_buy+"");
		
		for(int i=pending_buybill_model.getRowCount()-1;i>-1;i--)
			pending_buybill_model.removeRow(i);
		for(int i=0;i<BillCollections.pending_buybill.size();i++) { 
			String 	name = BillCollections.pending_buybill.get(i).name,
					issue_date = BillCollections.pending_buybill.get(i).issue_date,
					id = BillCollections.pending_buybill.get(i).id;
			double 	price = 0.0;
			for(int p=0;p<BillCollections.pending_buybill.get(i).product.size();p++)
				price += BillCollections.pending_buybill.get(i).product.get(p).price 
						 * BillCollections.pending_buybill.get(i).product.get(p).weight;
			pending_buybill_model.addRow(new Object[] {id,name,price,issue_date});
			//Information.credit_buy += price;
		}
		
		for(int i=buybill_model.getRowCount()-1;i>-1;i--) {
			if(buybill_model.getValueAt(i, 3) == "pending")
				Information.credit_buy += Double.parseDouble(buybill_model.getValueAt(i, 2).toString());
		}
		lbSumPendingPriceNUM.setText(Information.credit_buy+"");
		
		for(int i=pay_pending_buybill_model.getRowCount()-1;i>-1;i--)
			pay_pending_buybill_model.removeRow(i);
		for(int i=0;i<BillCollections.pay_pending_buybill.size();i++) { 
			String 	name = BillCollections.pay_pending_buybill.get(i).name,
					issue_date = BillCollections.pay_pending_buybill.get(i).issue_date,
					id = BillCollections.pay_pending_buybill.get(i).id;
			double 	price = 0.0;
			for(int p=0;p<BillCollections.pay_pending_buybill.get(i).product.size();p++)
				price += BillCollections.pay_pending_buybill.get(i).product.get(p).price 
						 * BillCollections.pay_pending_buybill.get(i).product.get(p).weight;
			pay_pending_buybill_model.addRow(new Object[] {id,name,price,issue_date});
			Information.recredit_buy += price;
		}
		lbSumPayPendingPriceNUM.setText(Information.recredit_buy+"");
		
		lbSumPaidAmountNUM.setText((Information.total_buy-Information.credit_buy)+"");
		
	}
}
