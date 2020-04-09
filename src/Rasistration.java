import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Rasistration extends JFrame {
	
	Connection con = null;
	PreparedStatement pst = null;
	

	private JPanel contentPane;
	private JTextField textUser;
	private JPasswordField passwordField;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Rasistration frame = new Rasistration();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Rasistration() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 373, 281);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textUser = new JTextField();
		textUser.setBounds(102, 57, 231, 20);
		contentPane.add(textUser);
		textUser.setColumns(10);
		
		JButton btnNewButton = new JButton("Done");
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					String quary = "INSERT INTO `tblogin`(`UserName`, `Password`) VALUES (?,?)";
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
					PreparedStatement pst = con.prepareStatement(quary);
					pst.setString(1, textUser.getText());
					pst.setString(2, passwordField.getText());
					pst.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "Registration complete");
					
					
					
					
				}catch(Exception ex) {
					
					JOptionPane.showMessageDialog(null, "ex");
					
				}
				
			}
		});
		btnNewButton.setBounds(135, 158, 89, 23);
		contentPane.add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(102, 108, 231, 20);
		contentPane.add(passwordField);
		
		lblNewLabel = new JLabel("UserName:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(28, 59, 86, 14);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(28, 110, 69, 14);
		contentPane.add(lblNewLabel_1);
		
		btnNewButton_1 = new JButton("Login");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				MySQL lo = new MySQL();
				lo.setVisible(true);
				
			}
		});
		btnNewButton_1.setBounds(244, 205, 89, 23);
		contentPane.add(btnNewButton_1);
		
		lblNewLabel_2 = new JLabel("Registar");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_2.setBounds(135, 11, 169, 28);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Click Login Button for Loggin");
		lblNewLabel_3.setForeground(Color.GREEN);
		lblNewLabel_3.setBackground(Color.GREEN);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(28, 205, 169, 20);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon(Rasistration.class.getResource("back.png")));
		lblNewLabel_4.setBounds(0, 0, 357, 242);
		contentPane.add(lblNewLabel_4);
	}

}
