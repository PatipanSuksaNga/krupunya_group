package layout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import data.language;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

public class login{
	
	public language lg = new language();
	
	private JFrame frame;
	private JPasswordField passwordField;
	private JTextField textField;
	
	JButton btnlogin = new JButton(lg.btnlogin);
	JLabel lbid = new JLabel(lg.lbid);
	JLabel lbpassword = new JLabel(lg.lbpassword);
	JMenuBar menuBar = new JMenuBar();
	JMenu mnLanguage = new JMenu(lg.mnLanguage);
	JMenuItem mntmEnglish = new JMenuItem(lg.mntmEnglish);
	JMenuItem mntmThai = new JMenuItem(lg.mntmThai);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login login_window = new login();
					login_window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 850, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		menuBar.setBounds(0, 0, 832, 30);
		frame.getContentPane().add(menuBar);
		
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
		
		btnlogin.setBounds(361, 240, 100, 30);
		btnlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					general general_window = new general();
					general_window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		passwordField = new JPasswordField();
		passwordField.setBounds(400, 195, 200, 30);
		
		textField = new JTextField();
		textField.setBounds(400, 150, 200, 30);
		textField.setColumns(10);
		
		lbid.setBounds(260, 150, 100, 30);
		lbid.setHorizontalAlignment(SwingConstants.RIGHT);
		
		lbpassword.setBounds(260, 195, 100, 30);
		lbpassword.setHorizontalAlignment(SwingConstants.RIGHT);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(lbid);
		frame.getContentPane().add(textField);
		frame.getContentPane().add(lbpassword);
		frame.getContentPane().add(passwordField);
		frame.getContentPane().add(btnlogin);
		
	}
	
	private void setText() {
		mnLanguage.setText(lg.mnLanguage);
		mntmEnglish.setText(lg.mntmEnglish);
		mntmThai.setText(lg.mntmThai);
		lbid.setText(lg.lbid);
		lbpassword.setText(lg.lbpassword);
		btnlogin.setText(lg.btnlogin);
		
	}
}
