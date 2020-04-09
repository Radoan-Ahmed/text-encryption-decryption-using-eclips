import java.awt.BorderLayout;
import java.awt.EventQueue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Choice;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;

public class EncryptDecrypt extends JFrame {
	
	public static void encryptDecrypt(String key, int cipherMode, File in,File out)
			throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException,
			IOException
			{
				FileInputStream fis = new FileInputStream(in);
				
			    FileOutputStream fos = new FileOutputStream(out);
				
				DESKeySpec desKeySpec = new DESKeySpec(key.getBytes());
				
				SecretKeyFactory skf = SecretKeyFactory.getInstance("DES");
				SecretKey secretKey = skf.generateSecret(desKeySpec);
				
				Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
				
				if(cipherMode == Cipher.ENCRYPT_MODE) {
					cipher.init(Cipher.ENCRYPT_MODE,secretKey,SecureRandom.getInstance("SHA1PRNG"));
					CipherInputStream cis = new CipherInputStream(fis, cipher);
					write(cis, fos);
				}
				else if(cipherMode == Cipher.DECRYPT_MODE) {
					cipher.init(Cipher.DECRYPT_MODE,secretKey, SecureRandom.getInstance("SHA1PRNG"));
					CipherOutputStream cos = new CipherOutputStream(fos, cipher);
					write(fis, cos);
				}
				
			}
			
			private static void write(InputStream in, OutputStream out) throws IOException {
				byte[] buffer = new byte[64];
				int numOfBytesRead;
				while((numOfBytesRead = in.read(buffer))!= -1) {
					out.write(buffer, 0, numOfBytesRead);
				}
				out.close();
				in.close();
			}
	

	private JPanel contentPane;
	private JTextField textField;
	private Choice choice;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EncryptDecrypt frame = new EncryptDecrypt();
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
	public EncryptDecrypt() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 418, 207);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(164, 22, 222, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		 choice = new Choice();
		 choice.setBounds(164, 74, 222, 20);
		 contentPane.add(choice);
		 choice.add("C:\\Users\\riyad\\OneDrive\\Desktop\\");
		 choice.add("F:\\");
		 choice.add("E:\\");
		 choice.add("G:\\");
		 choice.add("D:\\");
		 choice.add("C:\\");
		
		JButton btnNewButton = new JButton("Encryption");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String num = textField.getText();
				String num1 = choice.getSelectedItem();
				File plaintext = new File(num1+num);
				File encrypted = new File(num1+"encrypted.txt");
				
				
				try {
					encryptDecrypt("12345678", Cipher.ENCRYPT_MODE, plaintext,encrypted);
					JOptionPane.showMessageDialog(null,"Encryption complete");
					plaintext.delete();
					
				} catch (InvalidKeyException | NoSuchAlgorithmException | InvalidKeySpecException | NoSuchPaddingException
						| IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(10, 129, 119, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Decryption");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String num1 = choice.getSelectedItem();
				File encrypted = new File(num1+"encrypted.txt");
				File decrypted = new File(num1+"decrypted.txt");

				
				try {
					encryptDecrypt("12345678", Cipher.DECRYPT_MODE,encrypted, decrypted);
					JOptionPane.showMessageDialog(null,"Decryption complete");
				} catch (InvalidKeyException | NoSuchAlgorithmException | InvalidKeySpecException | NoSuchPaddingException
						| IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_1.setBounds(275, 129, 111, 23);
		contentPane.add(btnNewButton_1);
		
		lblNewLabel = new JLabel("Enter Your File Name:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 29, 160, 14);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Select File Location  :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(10, 74, 136, 14);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(EncryptDecrypt.class.getResource("back.png")));
		lblNewLabel_2.setBounds(0, 0, 402, 168);
		contentPane.add(lblNewLabel_2);
		
	}
}
