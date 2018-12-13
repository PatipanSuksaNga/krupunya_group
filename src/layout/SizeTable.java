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

public class SizeTable {

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
					SizeTable window = new SizeTable();
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
	public SizeTable() {
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
		
		JLabel lbSizeTable = new JLabel("Size Table of //");
		lbSizeTable.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbSizeTable.setHorizontalAlignment(SwingConstants.CENTER);
		lbSizeTable.setBounds((screenSize.width/2)-150, screenSize.height*4/100, 300, 50);
		frame.getContentPane().add(lbSizeTable);
		
		table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setPreferredScrollableViewportSize(new Dimension(screenSize.width, screenSize.height*3/4));
		table.setBounds(0, screenSize.height*1/10, screenSize.width, screenSize.height*3/4);
		table.setModel(table_model );
		String[] column_name = new String[] {"name","A","11","22","33","44","55","6","7","O","1","111","2","3","4","5","8","sumW","sumB"};
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
		Double 	TA=0.0,T11=0.0,T22=0.0,T33=0.0,T44=0.0,T55=0.0,T6=0.0,T7=0.0,TO=0.0,
				T1=0.0,T111=0.0,T2=0.0,T3=0.0,T4=0.0,T5=0.0,T8=0.0,TsumW=0.0,TsumB=0.0;
		for(Buybill B:BillCollections.buybill ) {
			String name=B.name;
			Double 	SA=0.0,S11=0.0,S22=0.0,S33=0.0,S44=0.0,S55=0.0,S6=0.0,S7=0.0,SO=0.0,
					S1=0.0,S111=0.0,S2=0.0,S3=0.0,S4=0.0,S5=0.0,S8=0.0,sumW=0.0,sumB=0.0;
			for(Product p:B.product) {
				sumB += p.price * p.weight; TsumB += sumB;
				sumW += p.weight; TsumW += sumW;
				//System.out.println(p.secret_number);
				if(p.secret_number.compareTo("A") == 0)
					{SA = p.weight; TA += SA;} 
				if(p.secret_number.compareTo("11") == 0)	
					{S11 = p.weight; T11 += S11; }
				if(p.secret_number.compareTo("22") == 0)
					{S22 = p.weight; T22 += S11;  }
				if(p.secret_number.compareTo("33") == 0)
					{S33 = p.weight; T33 += S33; }
				if(p.secret_number.compareTo("44") == 0)	
					{S44 = p.weight; T44 += S44; }
				if(p.secret_number.compareTo("55") == 0)	
					{S55 = p.weight; T55 += S55; }
				if(p.secret_number.compareTo("6") == 0)
					{S6 = p.weight; T6 += S6; }
				if(p.secret_number.compareTo("7") == 0)
					{S7 = p.weight; T7 += S7; }
				if(p.secret_number.compareTo("O") == 0)
					{SO = p.weight; TO += SO; }
				if(p.secret_number.compareTo("1") == 0)
					{S1 = p.weight; T1 += S1; }
				if(p.secret_number.compareTo("111") == 0)
					{S111 = p.weight; T111 += S111; }
				if(p.secret_number.compareTo("2") == 0)
					{S2 = p.weight; T2 += S2; }
				if(p.secret_number.compareTo("3") == 0)
					{S3 = p.weight; T3 += S3; }
				if(p.secret_number.compareTo("4") == 0)
					{S4 = p.weight; T4 += S4; }
				if(p.secret_number.compareTo("5") == 0)
					{S5 = p.weight; T5 += S5; }
				if(p.secret_number.compareTo("8") == 0)
					{S8 += p.weight; T8 += S8; }
				if(p.secret_number.compareTo("88") == 0)
					{S8 += p.weight; T8 += S8; }
				if(p.secret_number.compareTo("888") == 0)
					{S8 += p.weight; T8 += S8; }
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
		
		table_model.addRow(new Object[] {	
				"SUM TOTAL",
				TA,
				T11,
				T22,
				T33,
				T44,
				T55,
				T6,
				T7,
				TO,
				T1,
				T111,
				T2,
				T3,
				T4,
				T5,
				T8,
				TsumW,
				TsumB
				
				});
	}
}
