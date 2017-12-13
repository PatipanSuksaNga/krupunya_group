package layout;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.SpringLayout;
import net.miginfocom.swing.MigLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JSeparator;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JButton;

public class Date {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

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
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(screenSize.width/10, screenSize.height/10, screenSize.width*3/10, screenSize.height/10);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(227, 70, 50, 22);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setColumns(10);
		textField_1.setBounds(77, 70, 50, 22);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setColumns(10);
		textField_2.setBounds(377, 70, 50, 22);
		panel.add(textField_2);
		
		JLabel lblNewLabel = new JLabel("Day");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(77, 27, 50, 16);
		panel.add(lblNewLabel);
		
		JLabel lblMonth = new JLabel("Month");
		lblMonth.setHorizontalAlignment(SwingConstants.CENTER);
		lblMonth.setBounds(227, 27, 50, 16);
		panel.add(lblMonth);
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setHorizontalAlignment(SwingConstants.CENTER);
		lblYear.setBounds(377, 27, 50, 16);
		panel.add(lblYear);
		
		JButton btnNewButton = new JButton("Begin");
		btnNewButton.setBounds(369, 286, 97, 25);
		frame.getContentPane().add(btnNewButton);
	}
}
