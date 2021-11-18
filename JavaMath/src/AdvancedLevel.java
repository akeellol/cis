import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import org.json.JSONException;
import org.json.JSONObject;

public class AdvancedLevel extends JFrame{
	
	Timer timer;
	static AdvancedLevel frame;
	JLabel secondsjl;
	String current_answer="";
	static int lvl2score = 0;
	int questionCount=0;
	String randindexes []= {"0123", "0132", "0213"
			, "0231", "0312", "0321", 
			"1023", "1032", "1203", "1230", "1302", "1320", 
			"2013", "2031", "2103", "2130", "2301", "2310", "3012", "3021", "3102", "3120", "3201",  "3210"};
	
	static String oparr[]= {"+","-","*","/"};
	boolean isSet[]= {false,false,false,false};
	static String time="";	
	boolean isFirstRun = true;
	static int total_score_prev=0;
	static String current_location="colombo";
	static String weather="";
	static String API_KEY="b67eb136af04c176073b5b29e4863277";
	
	public static void main(String args[]) {
		EventQueue.invokeLater(new Runnable() {
		//http://worldtimeapi.org/api/timezone/Asia/Karachi
			 
			public void run() {
				try {
					//https://api.openweathermap.org/data/2.5/weather?q=Islamabad&appid=b67eb136af04c176073b5b29e4863277
					JSONObject json = readJsonFromUrl("http://worldtimeapi.org/api/timezone/Asia/colombo");
				    time  = json.get("datetime").toString();
				    json = readJsonFromUrl("https://api.openweathermap.org/data/2.5/weather?q="+current_location+"&appid="+API_KEY);
				    JSONObject n=json.getJSONObject("main");
				    String kelvin = n.get("temp").toString();
				   weather = Double.toString( Double.parseDouble(kelvin) - 273.15F)+" °C";
				    
					UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
					 frame = new AdvancedLevel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
		
	public AdvancedLevel() {
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 673, 381);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 624, 53);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Time Reamining");
		lblNewLabel.setBounds(264, 36, 92, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("00");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel_1.setBounds(260, 0, 34, 42);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("sec.");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel_1_1.setBounds(296, 0, 55, 42);
		panel.add(lblNewLabel_1_1);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 75, 624, 199);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton randbtn3 = new JButton("Start");
		randbtn3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		randbtn3.setForeground(new Color(255, 255, 255));
		randbtn3.setBackground(new Color(0, 0, 205));
		randbtn3.setBounds(348, 151, 198, 38);
		panel_1.add(randbtn3);
		
		JLabel equationLbl = new JLabel("Equation");
		equationLbl.setHorizontalAlignment(SwingConstants.CENTER);
		equationLbl.setFont(new Font("Consolas", Font.BOLD, 70));
		equationLbl.setBounds(10, 11, 604, 82);
		panel_1.add(equationLbl);
		
		JButton randbtn1 = new JButton("New button");
		randbtn1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		randbtn1.setForeground(new Color(255, 255, 255));
		randbtn1.setBackground(new Color(0, 0, 205));
		randbtn1.setBounds(73, 102, 221, 41);
		randbtn1.setVisible(false);
		panel_1.add(randbtn1);
		
		JButton randbtn2 = new JButton("New button");
		randbtn2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		randbtn2.setForeground(new Color(255, 255, 255));
		randbtn2.setBackground(new Color(0, 0, 205));
		randbtn2.setBounds(73, 151, 220, 39);
		randbtn2.setVisible(false);
		panel_1.add(randbtn2);
		
		JButton randbtn4 = new JButton("New button");
		randbtn4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		randbtn4.setForeground(new Color(255, 255, 255));
		randbtn4.setBackground(new Color(0, 0, 205));
		randbtn4.setBounds(346, 103, 200, 38);
		randbtn4.setVisible(false);
		panel_1.add(randbtn4);
		
		JButton[] btns = new JButton[4];
		btns[0] = randbtn1;
		btns[1] = randbtn2;
		btns[2] = randbtn3;
		btns[3] = randbtn4;
		
		JLabel timelbl = new JLabel("New label");
		timelbl.setBounds(195, 285, 340, 14);
		getContentPane().add(timelbl);
		
		timelbl.setText(time);
		
		JLabel lblNewLabel_2 = new JLabel("TIME AND DATE STARTED (API)");
		lblNewLabel_2.setBounds(10, 285, 190, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel locationlbl = new JLabel("New label");
		locationlbl.setBounds(10, 310, 100, 14);
		getContentPane().add(locationlbl);
		
		JLabel weatherlbl = new JLabel("New label");
		weatherlbl.setBounds(110, 310, 161, 14);
		getContentPane().add(weatherlbl);
		
		
		locationlbl.setText(current_location);
		weatherlbl.setText(weather);
		
		randbtn1.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		//    	questionCount++;
		    	if(current_answer.equals(randbtn1.getText().toString())) {
		    		lvl2score++;
		    	}
		    	timer.cancel();
		    	try {
					setEquation(btns, equationLbl, lblNewLabel_1_1);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    	System.out.println("Score "+lvl2score);
		    }		   		   
		});
		
		randbtn2.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		//    	questionCount++;
		    	if(current_answer.equals(randbtn2.getText().toString())) {
		    		lvl2score++;
		    	}
		    	timer.cancel();
		    	try {
					setEquation(btns, equationLbl, lblNewLabel_1_1);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					Main.main(null);
				}
		    	System.out.println("Score "+lvl2score);
		    	
		    }
		});
		
		randbtn4.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		//    	questionCount++;
		    	if(current_answer.equals(randbtn3.getText().toString())) {
		    		lvl2score++;
		    	}
		    	timer.cancel();
		    	try {
					setEquation(btns, equationLbl, lblNewLabel_1_1);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					Main.main(null);
				}
		    	System.out.println("Score "+lvl2score);
		    }
		});
		
		randbtn3.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    
		    	if(isFirstRun) {
		    		try {
						setEquation(btns, equationLbl, lblNewLabel_1_1);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						Main.main(null);
					}
		    		isFirstRun=false;
		    	}else {
		    		//questionCount++;
		    		timer.cancel();
		    		if(current_answer.equals(randbtn3.getText().toString())) {
		    			lvl2score++;
			    	}
		    		try {
						setEquation(btns, equationLbl, lblNewLabel_1_1);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						Main.main(null);
					}
		    		System.out.println("Score "+lvl2score);
		    	}
		    }
		});
			
	}
	
	public static Timer countdown(JLabel label) {
	
		Timer timer;
	
		    int delay = 1000;
		    int period = 1000;
		    timer = new Timer();
		    timer.scheduleAtFixedRate(new TimerTask() {
		    	int c= 60;
		        public void run() {
		        	 if (c == 1) {
		     	        timer.cancel();
		     	        frame.dispose();
		        	 }
		     	        c--;
		        	 label.setText(Integer.toString(c));
		        }
		    }, delay, period);
		return timer;
	}
	
	
	public static String getEquation(int count) {
	
	
		
		double ans=0 ;

		String eq="";
		
		int n1 = getRandomIndex(100,999);
		int n2 = getRandomIndex(100,999);
		int n3 = getRandomIndex(100,999);
		
	
		int rIndex = getRandomIndex(100,4);
	
		if(count<=10) {
			ans=getAnswer(rIndex,n1,n2);
			eq+=Integer.toString(n1);
			eq+=oparr[rIndex];
			eq+=Integer.toString(n2);
			rIndex = getRandomIndex(100,3);
			ans=getAnswer(rIndex,ans,n3);
			int ians = (int)ans;
			eq+=oparr[rIndex];
			eq+=Integer.toString(n3);		
			eq+=","+ians;
		}
		else if(count<=20) {
			ans=getAnswer(rIndex,n1,n2);
			int ians = (int)ans;
			eq+=Integer.toString(n1);
			eq+=" ? ";
			eq+=Integer.toString(n2);
			eq+="="+ians;
			eq+=","+oparr[rIndex];
		}else {
			
			int v_s=lvl2score+Game.score;
			
			JOptionPane.showMessageDialog(null, "Your Score is "+v_s+"/30","Results",JOptionPane.INFORMATION_MESSAGE);
			try {
			Game.StoreDataFile(Game.P_Name, v_s);
			}catch(Exception e) {e.printStackTrace();}
			//System.exit(0);
		}
		
		return eq;
		
	}
	public static int getRandomIndex(int mul,int limit) {
		
		double rand = Math.random() * mul;
		int n = (int) rand ;
		return n%limit;
	}
	public static double getAnswer(int rIndex,double n1,double n2) {
			
			if(rIndex==0) {
				return n1+n2;
			}else if (rIndex==1) {
				return n1-n2;
			}else if (rIndex==2) {
				return n1*n2;
			}else if (rIndex==3) {
				return n1/n2;
			}
			return 0;
		
		}
	
	public void setEquation(JButton[] btns ,JLabel equationLbl ,JLabel lblNewLabel_1) throws Exception {
		
		int x = getRandomIndex(100, 4); //ans index
		String s = getEquation(questionCount);
		equationLbl.setText((s.split(",")[0]));
		current_answer=s.split(",")[1];
	    timer=countdown(lblNewLabel_1);
	   
	    if(questionCount<=10) {
	    	
	    	 int tanss = getRandomIndex(1000, 999);
	    	 
	 	    btns[0].setText(Integer.toString(tanss));
	 	   tanss = getRandomIndex(100, 999);
	 	    btns[1].setText(Integer.toString(tanss));
	 	   tanss = getRandomIndex(100, 999);
	 	    btns[2].setText(Integer.toString(tanss));
	 	   tanss = getRandomIndex(100, 999);
	 	    btns[3].setText(Integer.toString(tanss));
	 	    
	 	    btns[x].setText(current_answer);
	    }else {
	    	
	    
  int y = getRandomIndex(100, 24); 
 char[] carr = randindexes[y].toCharArray();     
     btns[0].setText(oparr[Integer.parseInt(Character.toString(carr[0]))]);
     btns[1].setText(oparr[Integer.parseInt(Character.toString(carr[1]))]);
     btns[2].setText(oparr[Integer.parseInt(Character.toString(carr[2]))]);
     btns[3].setText(oparr[Integer.parseInt(Character.toString(carr[3]))]);
     
		/*
		 * y = getRandomIndex(100, 4); btns[1].setText(oparr[y]); y =
		 * getRandomIndex(100, 4); btns[2].setText(oparr[y]); y = getRandomIndex(100,
		 * 4); btns[3].setText(oparr[y]);
		 */
	    }

	    btns[0].setVisible(true);
	    btns[1].setVisible(true);
	    btns[2].setVisible(true);
	    btns[3].setVisible(true);
	    
	    
		/* btns[x].setText(current_answer); */
		System.out.println("current ans "+current_answer);
		questionCount++;
	}
	 private static String readAll(Reader rd) throws IOException {
		    StringBuilder sb = new StringBuilder();
		    int cp;
		    while ((cp = rd.read()) != -1) {
		      sb.append((char) cp);
		    }
		    return sb.toString();
		  }

		  public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
		    InputStream is = new URL(url).openStream();
		    try {
		      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
		      String jsonText = readAll(rd);
		      JSONObject json = new JSONObject(jsonText);
		      return json;
		    } finally {
		      is.close();
		    }
		  }
}

/*
 * 
 * 
 * if(isFirstRun) { String s = getEquation();
 * equationLbl.set.Text(s.split(",")[0]); current_answer=s.split(",")[1];
 * randbtn3.setText("Next"); isFirstRun=false; ansin.setEnabled(true);
 * timer=countdown(lblNewLabel_1); System.out.println("score "+lvl2score );
 * questionCount++; } else {
 * 
 * if(ansin.getText().toString()==null || ansin.getText().toString().equals(""))
 * { JOptionPane.showMessageDialog(null,"Enter Answer","ERROR!",JOptionPane.
 * ERROR_MESSAGE);
 * 
 * }else { timer.cancel();
 * 
 * if(current_answer.equals(ansin.getText().toString())) { lvl2score++; }
 * if(questionCount==4) {
 * 
 * }else { String s = getEquation(); equationLbl.setText(s.split(",")[0]);
 * current_answer=s.split(",")[1]; ansin.setText("");
 * timer=countdown(lblNewLabel_1); System.out.println("score "+lvl2score );
 * questionCount++; } } } System.out.println("Current "+current_answer); }
 * 
 * 
 */