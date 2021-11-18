import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.awt.event.ActionEvent;

public class Scoreboard extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JTable table;
	private JButton btnNewButton;
	private JTable table_1;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
					Scoreboard frame = new Scoreboard();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws FileNotFoundException 
	 */
	public Scoreboard() throws FileNotFoundException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 607, 339);
		contentPane = new JPanel();
		//contentPane.setBackground(new Color(95, 158, 160));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Scoreboard");
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 25));
		
		panel = new JPanel();
		
		btnNewButton = new JButton("Play Again!");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				DetailsScreen frame = new DetailsScreen();
				frame.setVisible(true);
				
			}
		});
		btnNewButton.setBackground(new Color(204, 0, 0));
		btnNewButton.setFont(new Font("SansSerif", Font.BOLD, 14));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(48, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 501, GroupLayout.PREFERRED_SIZE)
							.addGap(32))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
							.addGap(89)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 501, 166);
		panel.add(scrollPane);
		
		
		HashMap <String , Integer> hm = showdata();
		
		
		table_1 = new JTable(toTableModel(hm));
		scrollPane.setViewportView(table_1);
		contentPane.setLayout(gl_contentPane);
		
		
	}
	
	

	 public static TableModel toTableModel(HashMap map) {
	     DefaultTableModel model = new DefaultTableModel (
	   new Object[] { "Name", "Score" }, 0
	  );
	  for (Iterator it = map.entrySet().iterator(); it.hasNext();) {
	   HashMap.Entry entry = (HashMap.Entry)it.next();
	   model.addRow(new Object[] { entry.getKey(), entry.getValue() });
	  }
	  return model;
	 }
	
	
	
	

	
	public HashMap <String , Integer> showdata() throws FileNotFoundException {
		HashMap <String , Integer> map = new HashMap <>();
		
		FileReader reader = new FileReader("data.txt");
		Scanner scan = new Scanner(reader);
		
		while(scan.hasNext()) {
			
			String line  = scan.nextLine();
			String data[]  = line.split("\\s+");
			
			map.put(data[0], Integer.parseInt(data[1]));
			

		}
		
		return map;
		
	}
	
	
}
