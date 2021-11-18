import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.sql.*;
public class Sign_up extends JFrame {

	private JPanel contentPane;
	
	static String password;
	static String Name;
	static String Email;
	private JPasswordField Password;
	private JTextField txtname;
	private JTextField txtEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					
					
					
					UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
					Sign_up frame = new Sign_up();
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
	public Sign_up() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 465, 316);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 196, 222));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Admin Login");
		lblNewLabel.setFont(new Font("Open Sans", Font.PLAIN, 22));
		
		JLabel lblNewLabel_1 = new JLabel("Password: ");
		lblNewLabel_1.setFont(new Font("Open Sans", Font.PLAIN, 15));
		
		JButton btnNewButton = new JButton("Show ");
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Scoreboard s = null;
					Name = txtname.getText();
					password = Password.getText();
					Email = txtEmail.getText();
	                Class.forName("com.mysql.cj.jdbc.Driver");
	                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/akeel", "root", "");
	              //Statement st = con.createStatement();
	                    String query = "insert into user (Name,Password,Email) Values (?,?,?)";
	                    //ResultSet rs = st.executeQuery(query);
	                    PreparedStatement pst = con.prepareStatement(query);
                        pst.setString(1, Name);
                        pst.setString(2, password);
                        pst.setString(3, Email);
                        pst.executeUpdate();
                        JOptionPane.showMessageDialog(null, "New User Sucessfully Added!");
                        txtEmail.setText(null);
                        txtname.setText(null);
                        Password.setText(null);
                        txtname.requestFocus();
                        
                        s = new Scoreboard();
						s.setVisible(true);
						dispose();
                  
				
				/*if(password.equalsIgnoreCase("admin")) {
					dispose();
					Scoreboard s = null;
					try {
						s = new Scoreboard();
						s.setVisible(true);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				}else {
					
					JOptionPane.showMessageDialog(btnNewButton, "Incorrect Password!");
				}*/
			}catch(Exception e1) {
				JOptionPane.showMessageDialog(null, e1);
			}
			}
		});
		btnNewButton.setBackground(new Color(0, 128, 128));
		btnNewButton.setFont(new Font("SansSerif", Font.BOLD, 13));
		
		Password = new JPasswordField();
		
		txtname = new JTextField();
		txtname.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Name");
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Email");
		
		JButton btnNewButton_1 = new JButton("Clear");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtEmail.setText(null);
                txtname.setText(null);
                Password.setText(null);
                txtname.requestFocus();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(143, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
					.addGap(141))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(132)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
					.addGap(37)
					.addComponent(btnNewButton_1)
					.addContainerGap(96, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(40)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_2)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
							.addComponent(txtname)
							.addComponent(Password, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
						.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(65, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(36)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(txtname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(Password, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2_1)
						.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addGap(25))
		);
		contentPane.setLayout(gl_contentPane);
		
	}
}
