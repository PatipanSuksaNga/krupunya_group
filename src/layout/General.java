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
import data.language;
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
	DefaultTableModel buybill_model = new DefaultTableModel();
	
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
	private final JLabel lblBuyBillDetail = new JLabel("Buy bill detail");
	private JTable buybill_table;
	private final JButton btnFetchData = new JButton("Fetch data");

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
		btnSellbilling.setBounds(190, 20, 140, 25);
		
		panel.add(btnSellbilling);
		btnOnspotsale.setBounds(340, 20, 140, 25);
		
		panel.add(btnOnspotsale);
		btnSizetable.setBounds(490, 20, 140, 25);
		
		panel.add(btnSizetable);
		btnConclusion.setBounds(640, 20, 140, 25);
		
		panel.add(btnConclusion);
		lbDate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbDate.setHorizontalAlignment(SwingConstants.CENTER);
		lbDate.setBounds(screenSize.width/2-250, screenSize.width*13/100, 500, 50);
		
		frame.getContentPane().add(lbDate);
		
		main_panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		main_panel.setPreferredSize(new Dimension(screenSize.width,screenSize.height*2));
		main_panel.setBounds(0,screenSize.height*4/10,screenSize.width,screenSize.height*2);
		scrollPane.setBounds(0,screenSize.height*3/10,screenSize.width,screenSize.height*7/10);
		scrollPane.setViewportView(main_panel);
		main_panel.setLayout(null);
		
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
		
		lblBuyBillDetail.setBounds(screenSize.width/2+50, 100, 100, 20);
		main_panel.add(lblBuyBillDetail);
		
		buybill_table = new JTable();
		buybill_table.setBorder(new LineBorder(new Color(0, 0, 0)));
		buybill_table.setPreferredScrollableViewportSize(new Dimension(screenSize.width/2-400,300));
		buybill_table.setBounds(screenSize.width/2+50, 150, screenSize.width/2-400, 300);
		buybill_table.setModel(buybill_model);
		buybill_model.addColumn("name");
		buybill_model.addColumn("price");
		buybill_model.addColumn("status");
		
		JScrollPane buybill_table_sp = new JScrollPane(buybill_table,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		buybill_table_sp.setBounds(screenSize.width/2+50, 150, screenSize.width/2-400, 300);
		buybill_table_sp.setVisible(true);
		main_panel.add(buybill_table_sp);
		
		btnFetchData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				for(int i=0;i<buybill_model.getRowCount();i++)
					buybill_model.removeRow(i);
				
				for(int i=0;i<BillCollections.buybill.size();i++) { 
					String 	name = BillCollections.buybill.get(i).name,
							status = null;
					double 	price = 0.0;
					if(BillCollections.buybill.get(i).status)
						status = "paid";
					else
						status = "pending";
					for(int p=0;p<BillCollections.buybill.get(i).product.size();p++)
						price += BillCollections.buybill.get(i).product.get(p).price * BillCollections.buybill.get(i).product.get(p).weight;
					buybill_model.addRow(new Object[] {name,price,status});
				}
				
			}
		});
		btnFetchData.setBounds(1100, 100, 100, 25);
		
		main_panel.add(btnFetchData);
		
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		frame.getContentPane().add(scrollPane);
		

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
}
