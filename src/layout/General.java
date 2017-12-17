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

import data.language;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JSeparator;

public class General {

	public JFrame frame;
	JMenuBar menuBar = new JMenuBar();
	JMenu mnLanguage = new JMenu(language.mnLanguage);
	JMenuItem mntmEnglish = new JMenuItem(language.mntmEnglish);
	JMenuItem mntmThai = new JMenuItem(language.mntmThai);
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
		
		frame = new JFrame();
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
		
		lbMainpage.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbMainpage.setHorizontalAlignment(SwingConstants.CENTER);
		lbMainpage.setBounds((screenSize.width/2)-150, screenSize.height*4/100, 300, 50);
		frame.getContentPane().add(lbMainpage);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(screenSize.width/10, screenSize.height/10, screenSize.width*8/10, screenSize.height/10);
		
		frame.getContentPane().add(panel);
		btnBuybilling.setBounds(40, 20, 140, 25);
		btnBuybilling.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		lbDate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbDate.setHorizontalAlignment(SwingConstants.CENTER);
		lbDate.setBounds((screenSize.width/2)-250, screenSize.height*22/100, 500, 50);
		
		frame.getContentPane().add(lbDate);
		
		main_panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		main_panel.setPreferredSize(new Dimension(screenSize.width,screenSize.height*2));
		main_panel.setBounds(0,screenSize.height*4/10,screenSize.width,screenSize.height*2);
		scrollPane.setBounds(0,screenSize.height*3/10,screenSize.width,screenSize.height*7/10);
		scrollPane.setViewportView(main_panel);
		main_panel.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setForeground(Color.WHITE);
		separator.setBackground(Color.BLACK);
		separator.setBounds(screenSize.width/2-1, 0, 2, screenSize.height*2);
		main_panel.add(separator);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		frame.getContentPane().add(scrollPane);
		

	}
	
	private void setText() {
		mnLanguage.setText(language.mnLanguage);
		mntmEnglish.setText(language.mntmEnglish);
		mntmThai.setText(language.mntmThai);
		lbMainpage.setText(language.lbMainpage);
		btnBuybilling.setText(language.btnBuybilling);
		btnSellbilling.setText(language.btnSellbilling);
		btnOnspotsale.setText(language.btnOnspotsale);
		btnSizetable.setText(language.btnSizetable);
		btnConclusion.setText(language.btnConclusion);
	}
}
