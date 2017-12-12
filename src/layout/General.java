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

public class General {

	public JFrame frame;
	
	public language lg = new language();
	
	JMenuBar menuBar = new JMenuBar();
	JMenu mnLanguage = new JMenu(lg.mnLanguage);
	JMenuItem mntmEnglish = new JMenuItem(lg.mntmEnglish);
	JMenuItem mntmThai = new JMenuItem(lg.mntmThai);
	private final JPanel panel = new JPanel();
	private final JButton btnBuybilling = new JButton("Buy Billing");
	private final JButton btnSellbilling = new JButton("Sell Billing");
	private final JButton btnOnspotsale = new JButton("On spot sale");
	private final JButton btnSizetable = new JButton("Size Table");
	private final JButton btnConclusion = new JButton("Conclusion");
	private final JScrollPane scrollPane = new JScrollPane();
	private final JPanel main_panel = new JPanel();

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
		
		menuBar.setBounds(0, 0, screenSize.width, 30);
		menuBar.add(mnLanguage);
		mnLanguage.add(mntmEnglish);
		mntmEnglish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lg.getEng();
				setText();
			}
		});
		mnLanguage.add(mntmThai);
		mntmThai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lg.getThai();
				setText();
			}
		});
		
		frame.getContentPane().add(menuBar);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(screenSize.width/10, screenSize.height/10, screenSize.width*8/10, screenSize.height/10);
		
		frame.getContentPane().add(panel);
		btnBuybilling.setBounds(40, 40, 110, 25);
		btnBuybilling.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.setLayout(null);
		
		panel.add(btnBuybilling);
		btnSellbilling.setBounds(190, 40, 110, 25);
		
		panel.add(btnSellbilling);
		btnOnspotsale.setBounds(340, 40, 110, 25);
		
		panel.add(btnOnspotsale);
		btnSizetable.setBounds(490, 40, 110, 25);
		
		panel.add(btnSizetable);
		btnConclusion.setBounds(640, 40, 110, 25);
		
		panel.add(btnConclusion);
		main_panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		main_panel.setPreferredSize(new Dimension(screenSize.width,screenSize.height*2));
		main_panel.setBounds(0,screenSize.height*4/10,screenSize.width,screenSize.height*2);
//		main_panel.add(panel);
//		main_panel.add(menuBar);
		scrollPane.setBounds(0,screenSize.height*3/10,screenSize.width,screenSize.height*7/10);
		scrollPane.setViewportView(main_panel);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		frame.getContentPane().add(scrollPane);
		

	}
	
	private void setText() {
		mnLanguage.setText(lg.mnLanguage);
		mntmEnglish.setText(lg.mntmEnglish);
		mntmThai.setText(lg.mntmThai);
	}
}
