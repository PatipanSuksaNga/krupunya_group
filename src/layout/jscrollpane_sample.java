package layout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;

public class jscrollpane_sample {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jscrollpane_sample window = new jscrollpane_sample();
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
	public jscrollpane_sample() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 904, 569);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(138, 98, 421, 277);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(204, 204, 0));
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setPreferredSize(new Dimension(700,700));                 //VERY IMPORTANT//
		panel_1.setBounds(0,0,700,700);
//		panel.add(panel_1);
		
		JScrollPane sp = new JScrollPane(panel_1,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
//		sp.setViewportView(panel);
		sp.setBounds(138, 98, 421, 277);
		sp.setVisible(true);
		frame.getContentPane().add(sp);
		
	}

}
