import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Window;

import javax.swing.ImageIcon;

public class Thre extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		
		Thre frame = new Thre();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			
			}
		});
		
		Thread.sleep(2000);
		
		frame.dispose();
		loging loggo = new loging();
		loggo.setVisible(true);
	}
	
	
	/**
	 * Create the frame.
	 */
	public Thre() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Prism");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 45));
		lblNewLabel_1.setBounds(146, 11, 150, 46);
		contentPane.add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 68, 345, 193);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Thre.class.getResource("pr.jpg")));
		lblNewLabel.setBounds(0, 0, 347, 193);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(Thre.class.getResource("back.png")));
		lblNewLabel_2.setBounds(0, 68, 434, 193);
		contentPane.add(lblNewLabel_2);
		
		
	}
}
