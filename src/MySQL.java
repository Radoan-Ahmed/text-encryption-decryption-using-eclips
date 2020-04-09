import java.awt.BorderLayout;
import java.awt.EventQueue;

import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;

public class MySQL extends JFrame {

	private JPanel contentPane;
	private JTextField user;
	private JPasswordField pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MySQL frame = new MySQL();
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
	public MySQL() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 366, 225);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		user = new JTextField();
		user.setBounds(98, 38, 236, 23);
		contentPane.add(user);
		user.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBackground(Color.CYAN);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
					Statement stmt = con.createStatement();
					@SuppressWarnings("deprecation")
					String sql = "Select * from tblogin where UserName='"+user.getText()+"' and Password = '"+pass.getText().toString()+"'";
					ResultSet rs = stmt.executeQuery(sql);
					if(rs.next()) {
						dispose();
						EncryptDecrypt log = new EncryptDecrypt();
						log.setVisible(true);
						JOptionPane.showMessageDialog(null,"Login Sucessfully...");
						
						}
					else {
						JOptionPane.showMessageDialog(null,"Incorrect username and Password...");
						}
					con.close();
						
				}catch(Exception e) {
					System.out.print(e);
				}
				
			}
		});
		btnNewButton.setBounds(126, 129, 89, 32);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("UserName:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(20, 37, 73, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(20, 87, 73, 14);
		contentPane.add(lblNewLabel_1);
		
		pass = new JPasswordField();
		pass.setBounds(98, 84, 236, 23);
		contentPane.add(pass);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(MySQL.class.getResource("back.png")));
		lblNewLabel_2.setBounds(0, 0, 396, 291);
		contentPane.add(lblNewLabel_2);
	}
}
