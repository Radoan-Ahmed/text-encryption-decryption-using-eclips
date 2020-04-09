import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Delete extends JFrame {
	
	Connection con = null;
	PreparedStatement pst = null;

	private JPanel contentPane;
	private JTextField textUserName;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JPasswordField oldPass;
	private JPasswordField newPass;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Delete frame = new Delete();
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
	public Delete() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 356, 319);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textUserName = new JTextField();
		textUserName.setBounds(129, 79, 175, 20);
		contentPane.add(textUserName);
		textUserName.setColumns(10);
		
		JButton btnNewButton = new JButton("Done");
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				
            try {
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
					Statement stmt = con.createStatement();
				//	@SuppressWarnings("deprecation")
					String sql = "Select * from tblogin where  Password = '"+oldPass.getText().toString()+"'";
					ResultSet rs = stmt.executeQuery(sql);
					if(rs.next()) {
						
						//JOptionPane.showMessageDialog(null,"Login Sucessfully...");
						
						
						 try {
						    //	Class.forName("com.mysql.jdbc.Driver");
						    	String quary = "UPDATE `tblogin` SET `UserName`=?,`Password`=? WHERE 1";
								//Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
								PreparedStatement pst = con.prepareStatement(quary);
								pst.setString(1, textUserName.getText());
								pst.setString(2, newPass.getText());
							    pst.executeUpdate();
								JOptionPane.showMessageDialog(null, "Registration complete");
								
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						
						
						
						
						}
					else {
						JOptionPane.showMessageDialog(null,"Incorrect username and Password...");
						}
					con.close();
						
				}catch(Exception e1) {
					System.out.print(e1);
				}
				
				   
				
			}
		});
		btnNewButton.setBounds(154, 195, 89, 23);
		contentPane.add(btnNewButton);
		
		lblNewLabel = new JLabel("Old Password:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(20, 24, 99, 14);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("UserName:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(20, 81, 99, 14);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("New Password:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(20, 146, 99, 14);
		contentPane.add(lblNewLabel_2);
		
		oldPass = new JPasswordField();
		oldPass.setBounds(129, 22, 175, 20);
		contentPane.add(oldPass);
		
		newPass = new JPasswordField();
		newPass.setBounds(129, 144, 175, 20);
		contentPane.add(newPass);
		
		btnNewButton_1 = new JButton("Click");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				 MySQL logg = new MySQL();
				logg.setVisible(true);
				
			}
		});
		btnNewButton_1.setBounds(212, 245, 89, 23);
		contentPane.add(btnNewButton_1);
		
		lblNewLabel_3 = new JLabel("Click Here for Login");
		lblNewLabel_3.setForeground(new Color(0, 102, 255));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(20, 245, 146, 20);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon(Delete.class.getResource("back.png")));
		lblNewLabel_4.setBounds(0, 0, 340, 280);
		contentPane.add(lblNewLabel_4);
	}

}
