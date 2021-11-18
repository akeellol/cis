import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

public class Game extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JLabel lblNumber;
	JButton btnOdd;
	JButton btnEven;
	JLabel jLabel1;
	JLabel lblScore;
	GroupLayout gl_contentPane;
	
	
	static String P_Name = DetailsScreen.playername;

	  static int score = 0; // score each corrent question add 1 
      static int count = 0; // number of  question out of 10
      
      //generate random number for each question(number)
      Random r = new Random();
      int randomNum;
      private JButton btnNewButton;
	static Game frame ;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
				frame = new Game();
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
	public Game() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 403, 335);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 245, 220));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		    lblNumber = new JLabel("83");
			lblNumber.setForeground(new Color(65, 105, 225));
			lblNumber.setFont(new Font("Tahoma", Font.BOLD, 43));
			
			btnOdd = new JButton("ODD");
			btnOdd.setFont(new Font("Tahoma", Font.BOLD, 26));
			btnOdd.setBackground(new Color(176, 196, 222));
			 
			
	        btnEven = new JButton("EVEN");
		    btnEven.setFont(new Font("Tahoma", Font.BOLD, 25));
			btnEven.setBackground(new Color(176, 196, 222));
			
			 jLabel1 = new JLabel("SCORE: ");
			 jLabel1.setForeground(new Color(0, 0, 0));
			jLabel1.setFont(new Font("Tahoma", Font.BOLD, 24));
			
			 lblScore = new JLabel("");
			 lblScore.setForeground(new Color(128, 0, 0));
			lblScore.setFont(new Font("Tahoma", Font.BOLD, 31));
			 
			 btnNewButton = new JButton("Scoreboard");
			 btnNewButton.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		
			 		dispose();
			 		AdminScreen as = new AdminScreen();
			 		as.setVisible(true);
			 		
			 	}
			 });
			 btnNewButton.setBackground(new Color(211, 211, 211));
			 btnNewButton.setFont(new Font("SansSerif", Font.PLAIN, 14));
			 gl_contentPane = new GroupLayout(contentPane);
			 gl_contentPane.setHorizontalGroup(
			 	gl_contentPane.createParallelGroup(Alignment.LEADING)
			 		.addGroup(gl_contentPane.createSequentialGroup()
			 			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
			 				.addGroup(gl_contentPane.createSequentialGroup()
			 					.addGap(46)
			 					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
			 						.addGroup(gl_contentPane.createSequentialGroup()
			 							.addGap(8)
			 							.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
			 							.addPreferredGap(ComponentPlacement.UNRELATED)
			 							.addComponent(lblScore, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
			 						.addGroup(gl_contentPane.createSequentialGroup()
			 							.addComponent(btnOdd, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
			 							.addGap(53)
			 							.addComponent(btnEven, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE))))
			 				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
			 					.addGap(153)
			 					.addComponent(lblNumber, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
			 					.addPreferredGap(ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
			 					.addComponent(btnNewButton)))
			 			.addContainerGap())
			 );
			 gl_contentPane.setVerticalGroup(
			 	gl_contentPane.createParallelGroup(Alignment.LEADING)
			 		.addGroup(gl_contentPane.createSequentialGroup()
			 			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
			 				.addGroup(gl_contentPane.createSequentialGroup()
			 					.addContainerGap()
			 					.addComponent(btnNewButton))
			 				.addGroup(gl_contentPane.createSequentialGroup()
			 					.addGap(33)
			 					.addComponent(lblNumber, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)))
			 			.addGap(27)
			 			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
			 				.addComponent(btnOdd, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
			 				.addComponent(btnEven, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
			 			.addPreferredGap(ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
			 			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
			 				.addComponent(lblScore, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
			 				.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
			 			.addGap(36))
			 );
			 
			 
			    randomNum = r.nextInt(100);
		        lblNumber.setText(String.valueOf(randomNum));
		 
		 
		        
		        
		        
		 btnOdd.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		
		 		
		 	// TODO add your handling code here:
		        //odd operation
		        count = count+1; //each button click count question add 1 out of 10
		        int num = Integer.parseInt(lblNumber.getText());  //lblnumber is random num and convert to int for odd even operation
		        if(count==10){
		            //when counter reach last question(number)
		            //than it calculate for last number 
		            if(num%2!=0){
		                // number corret add score 
		                score = score+1;
		                lblScore.setText(String.valueOf(score)); //set value of score when answer correct
		                randomNum = r.nextInt(100); // random number generate for next question number
		                
		            }else{
		                //if not odd number
		                randomNum = r.nextInt(100);
		                lblNumber.setText(String.valueOf(randomNum)); //set randomnumber
		                               
		            }
		            
		            //result display on 10th question
		            JOptionPane.showMessageDialog(btnOdd, "Your score is: "+score+"/10");
		            
		            int P_score = score;
		            try {
						StoreDataFile(P_Name , P_score);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		            
		            
		            //reset values after score
		            count=0;
		            score =0;
		            lblScore.setText("");
		            randomNum = r.nextInt(100);
		            lblNumber.setText(String.valueOf(randomNum));
		            
		        }else{
		            // if number not reach 10th qestion ( for 1 to 9 )
		            if(num%2!=0){
		                score = score+1;
		                lblScore.setText(String.valueOf(score)); //set score value
		                //generate random number for next question
		                randomNum = r.nextInt(100);
		                lblNumber.setText(String.valueOf(randomNum));
		            }else{
		                //if not odd than generate random for next
		                randomNum = r.nextInt(100);
		                lblNumber.setText(String.valueOf(randomNum));
		            }
		        }
		        
		 	
		 		
		 	}
		 });
		
		 btnEven.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		
		 		

		 		 // TODO add your handling code here:
		        // for even do opposite 
		        //paste here and change
		        
		        count = count+1; //each button click count question add 1 out of 10
		        int num = Integer.parseInt(lblNumber.getText());  //lblnumber is random num and convert to int for odd even operation
		        if(count==10){
		            //when counter reach last question(number)
		            //than it calculate for last number 
		            if(num%2==0){
		                // number corret add score 
		                score = score+1;
		                lblScore.setText(String.valueOf(score)); //set value of score when answer correct
		                randomNum = r.nextInt(100); // random number generate for next question number
		                
		            }else{
		                //if not odd number
		                randomNum = r.nextInt(100);
		                lblNumber.setText(String.valueOf(randomNum)); //set randomnumber
		                               
		            }
		            
		            //result display on 10th question
		           //JOptionPane.showMessageDialog(btnEven, "Your score is: "+score+"/10");
		           
		           int P_score = score;
		           
		           
						/*
						 * try { StoreDataFile(P_Name , P_score); } catch (IOException e1) { // TODO
						 * Auto-generated catch block e1.printStackTrace(); }
						 */
		            //reset values after score
		           
						/*
						 * count=0; score =0; lblScore.setText(""); randomNum = r.nextInt(100);
						 * lblNumber.setText(String.valueOf(randomNum));
						 */
		          
		          dispose();
		           
		           AdvancedLevel.main(null);
		           
		           
		           
		        }else{
		            // if number not reach 10th qestion ( for 1 to 9 )
		            if(num%2==0){
		                score = score+1;
		                lblScore.setText(String.valueOf(score)); //set score value
		                //generate random number for next question
		                randomNum = r.nextInt(100);
		                lblNumber.setText(String.valueOf(randomNum));
		            }else{
		                //if not odd than generate random for next
		                randomNum = r.nextInt(100);
		                lblNumber.setText(String.valueOf(randomNum));
		            }
		        }
		 		
		 		
		 	}
		 });
		contentPane.setLayout(gl_contentPane);
		
		
	
		
	}

	
	
	public static void StoreDataFile(String name , int score) throws IOException {
		FileWriter writer = new FileWriter("data.txt" , true);
		writer.write(name + " " + score +"\n");
		writer.close();
	}
}
