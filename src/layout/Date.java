package layout;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.SpringLayout;
import net.miginfocom.swing.MigLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.border.LineBorder;

import data.dateIn;
import data.language;

import java.awt.Color;
import javax.swing.JSeparator;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Date {
	
	JFrame frame;
	private JTextField textFieldMonth;
	private JTextField textFieldDay;
	private JTextField textFieldYear;
	JMenuBar menuBar = new JMenuBar();
	JMenu mnLanguage = new JMenu(language.mnLanguage);
	JMenuItem mntmEnglish = new JMenuItem(language.mntmEnglish);
	JMenuItem mntmThai = new JMenuItem(language.mntmThai);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Date window = new Date();
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
	public Date() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		frame = new JFrame();
		frame.setBounds(100, 100,screenSize.width*5/10, screenSize.height*4/10);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		menuBar.setBounds(0, 0, screenSize.width, 30);
		frame.getContentPane().add(menuBar);
		
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
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(screenSize.width/10, screenSize.height/10, screenSize.width*3/10, screenSize.height/10);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		textFieldMonth = new JTextField();
		textFieldMonth.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldMonth.setBounds(screenSize.width*27/200, screenSize.width*4/100, 50, 22);
		panel.add(textFieldMonth);
		textFieldMonth.setColumns(10);
		
		textFieldDay = new JTextField();
		textFieldDay.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldDay.setColumns(10);
		textFieldDay.setBounds(screenSize.width*9/200, screenSize.width*4/100, 50, 22);
		panel.add(textFieldDay);
		
		textFieldYear = new JTextField();
		textFieldYear.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldYear.setColumns(10);
		textFieldYear.setBounds(screenSize.width*45/200, screenSize.width*4/100, 50, 22);
		panel.add(textFieldYear);
		
		JLabel lbDay = new JLabel("Day");
		lbDay.setHorizontalAlignment(SwingConstants.CENTER);
		lbDay.setBounds(screenSize.width*9/200, screenSize.width*2/100, 50, 16);
		panel.add(lbDay);
		
		JLabel lbMonth = new JLabel("Month");
		lbMonth.setHorizontalAlignment(SwingConstants.CENTER);
		lbMonth.setBounds(screenSize.width*27/200, screenSize.width*2/100, 50, 16);
		panel.add(lbMonth);
		
		JLabel lbYear = new JLabel("Year");
		lbYear.setHorizontalAlignment(SwingConstants.CENTER);
		lbYear.setBounds(screenSize.width*45/200, screenSize.width*2/100, 50, 16);
		panel.add(lbYear);
		
		JButton btnBegin = new JButton("Begin");
		btnBegin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fetchdate();
				General general_window = new General();
				general_window.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnBegin.setBounds(screenSize.width*22/100, screenSize.width*15/100, 100, 25);
		frame.getContentPane().add(btnBegin);
	}
	
	public void fetchdate() {
		dateIn.day = textFieldDay.getText();
		dateIn.month = textFieldMonth.getText();
		dateIn.year = textFieldYear.getText();
	}
	
	private void setText() {
		mnLanguage.setText(language.mnLanguage);
		mntmEnglish.setText(language.mntmEnglish);
		mntmThai.setText(language.mntmThai);
		
	}
}
