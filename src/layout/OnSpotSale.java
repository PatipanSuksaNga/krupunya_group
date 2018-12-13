package layout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import data.*;
import data.language;
import javax.swing.JLabel;
import javax.swing.JTable;

public class OnSpotSale {

	JFrame frame;
	JMenuBar menuBar = new JMenuBar();
	JMenu mnLanguage = new JMenu(language.mnLanguage);
	JMenuItem mntmEnglish = new JMenuItem(language.mntmEnglish);
	JMenuItem mntmThai = new JMenuItem(language.mntmThai);
	DefaultTableModel table_model = new DefaultTableModel();
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OnSpotSale window = new OnSpotSale();
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
	public OnSpotSale() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		frame = new JFrame("Size Table");
		frame.setSize(screenSize.width, screenSize.height);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		
		JLabel lbSizeTable = new JLabel("On Spot Sale");
		lbSizeTable.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbSizeTable.setHorizontalAlignment(SwingConstants.CENTER);
		lbSizeTable.setBounds((screenSize.width/2)-150, screenSize.height*4/100, 300, 50);
		frame.getContentPane().add(lbSizeTable);
		
		table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setPreferredScrollableViewportSize(new Dimension(screenSize.width, screenSize.height*3/4));
		table.setBounds(0, screenSize.height*1/10, screenSize.width, screenSize.height*3/4);
		table.setModel(table_model );
		String[] column_name = new String[] {"name","A","11","22","33","44","55","6","7","O","1","111","2","3","4","5","8","sumW","sumS"};
		for (String i : column_name)
			table_model.addColumn(i);
		JScrollPane table_sp = new JScrollPane(	table,
												JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
												JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		table_sp.setBounds(0, screenSize.height*1/10, screenSize.width, screenSize.height*3/4);
		table_sp.setVisible(true);
		frame.getContentPane().add(table_sp);
		fetchData();
	}
	
	private void setText() {
		mnLanguage.setText(language.mnLanguage);
		mntmEnglish.setText(language.mntmEnglish);
		mntmThai.setText(language.mntmThai);
	}
	
	private void fetchData() {
		for(Sellbill s:BillCollections.sellbill ) {
			String name=s.name;
			Double 	SA=0.0,S11=0.0,S22=0.0,S33=0.0,S44=0.0,S55=0.0,S6=0.0,S7=0.0,SO=0.0,
					S1=0.0,S111=0.0,S2=0.0,S3=0.0,S4=0.0,S5=0.0,S8=0.0,sumW=0.0,sumB=0.0;
			for(Product p:s.product) {
				sumB += p.price * p.weight;
				sumW += p.weight;
				//System.out.println(p.secret_number);
				if(p.secret_number.compareTo("A") == 0)
					SA = p.weight;
				if(p.secret_number.compareTo("11") == 0)	
					S11 = p.weight;
				if(p.secret_number.compareTo("22") == 0)
					S22 = p.weight;
				if(p.secret_number.compareTo("33") == 0)
					S33 = p.weight;
				if(p.secret_number.compareTo("44") == 0)	
					S44 = p.weight;
				if(p.secret_number.compareTo("55") == 0)	
					S55 = p.weight;
				if(p.secret_number.compareTo("6") == 0)
					S6 = p.weight;
				if(p.secret_number.compareTo("7") == 0)
					S7 = p.weight;
				if(p.secret_number.compareTo("O") == 0)
					SO = p.weight;
				if(p.secret_number.compareTo("1") == 0)
					S1 = p.weight;
				if(p.secret_number.compareTo("111") == 0)
					S111 = p.weight;
				if(p.secret_number.compareTo("2") == 0)
					S2 = p.weight;
				if(p.secret_number.compareTo("3") == 0)
					S3 = p.weight;
				if(p.secret_number.compareTo("4") == 0)
					S4 = p.weight;
				if(p.secret_number.compareTo("5") == 0)
					S5 = p.weight;
				if(p.secret_number.compareTo("8") == 0)
					S8 += p.weight;
				if(p.secret_number.compareTo("88") == 0)
					S8 += p.weight;
				if(p.secret_number.compareTo("888") == 0)
					S8 += p.weight;
			}
			table_model.addRow(new Object[] {	
					name,
					SA,
					S11,
					S22,
					S33,
					S44,
					S55,
					S6,
					S7,
					SO,
					S1,
					S111,
					S2,
					S3,
					S4,
					S5,
					S8,
					sumW,
					sumB
					
					});
		}
	}
}
