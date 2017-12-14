package layout;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Toolkit;

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

public class Login{
	
	public language lg = new language();
	
	public JFrame frame;
	private JPasswordField passwordField;
	private JTextField textField;
	
	JButton btnlogin = new JButton(language.btnlogin);
	JLabel lbid = new JLabel(language.lbid);
	JLabel lbpassword = new JLabel(language.lbpassword);
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
					Login login_window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		frame = new JFrame();
		frame.setBounds(100, 100,screenSize.width*5/10, screenSize.height*5/10);
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
					Date date_window = new Date();
					date_window.frame.setVisible(true);
					frame.setVisible(false);
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
		mnLanguage.setText(language.mnLanguage);
		mntmEnglish.setText(language.mntmEnglish);
		mntmThai.setText(language.mntmThai);
		lbid.setText(language.lbid);
		lbpassword.setText(language.lbpassword);
		btnlogin.setText(language.btnlogin);
		
	}
}
