import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class Edits {
	public Edits(){
		JFrame frame1 = new JFrame("Add Armory");
		
		
		try{
			frame1.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("E:\\Project\\thumb-1920-96814.jpg")))));
		}
		catch (Exception e)
		{
			
		}
		
		Color on= new Color(38,138,133);
		Color oh= new Color(255,100,0);
		Color gn = new Color(85,85,85);
		Color gh = new Color(0,0,0);
		
		JLabel sr = new JLabel("Search");
		JLabel ok = new JLabel("OK");
		
		JLabel lb1 = new JLabel("Enter Weapon's Name:");
		
		JTextField lb1_txt = new JTextField();
		
		
		JLabel lb3 = new JLabel("Enter Weapon's Type:");
		
		JTextField lb3_txt = new JTextField();
		
		
		JLabel lb5 = new JLabel("Enter Weapon's Stock:");
		
		JTextField lb5_txt = new JTextField();
		

        JFileChooser dp_chooser = new JFileChooser();
		JLabel dp = new JLabel();
		frame1.add(dp);
		dp.setBounds(35, 60,150, 150);
		String path = "E:\\Project\\choose_dp1.jpg";
		ImageIcon i = new ImageIcon(new ImageIcon(path).getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH));
		dp.setIcon(i);
		dp.addMouseListener(new MouseListener()
		{
			String path = "E:\\Project\\choose_dp1.jpg";

			@Override
			public void mouseClicked(MouseEvent arg0) {
				int a = dp_chooser.showOpenDialog(null);
				if (a == JFileChooser.APPROVE_OPTION)
				{                
		            File selectedFile = dp_chooser.getSelectedFile();
		            path = selectedFile.getAbsolutePath();
				}
				else
				{
					path = "E:\\Project\\choose_dp1.jpg";
				}
				path = path.replace("\\", "/");
				
				try
				{
					Statement st = new connect().con();
					System.out.println(path);
					String q = "insert into ar_pic(ar_pic) values('"+path+"');";
					st.execute(q);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
				System.out.println(path);
				ImageIcon i = new ImageIcon(new ImageIcon(path).getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH));
				dp.setIcon(i);
				System.out.println(path);
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
						
		});		

		
		frame1.add(ok);
		ok.setHorizontalAlignment(SwingConstants.CENTER);
		ok.setBounds(35,350,100,30);
		ok.setBackground(on);
		ok.setOpaque(true);
		ok.setFont(new Font("Sans-serif",Font.BOLD,20));
		ok.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				new TabbedPane();
				frame1.dispose();
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				ok.setBackground(oh);
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				ok.setBackground(on);
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		frame1.add(sr);
		sr.setHorizontalAlignment(SwingConstants.CENTER);
		sr.setBounds(255,110,100,30);
		sr.setBackground(gn);
		sr.setForeground(Color.WHITE);
		sr.setOpaque(true);
		sr.setFont(new Font("Sans-serif",Font.BOLD,20));
		sr.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				try{
					String name = lb1_txt.getText();
					Statement st = new connect().con();
					Statement st2 = new connect().con();
					String query = "select * from armory where ar_name = '"+name+"';";
					String q1 = "select * from ar_pic where ar_id = (select ar_id from armory where ar_name = '"+name+"');";
					ResultSet rs = st.executeQuery(query);
					if(rs.next()){
						lb3_txt.setText(rs.getString(2));
						lb5_txt.setText(rs.getString(3));
						ResultSet r = st2.executeQuery(q1);
						r.next();
						ImageIcon i = new ImageIcon(new ImageIcon(r.getString(2)).getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH));
						dp.setIcon(i);
					}
					else{
						String type,stock;
						
						JOptionPane.showMessageDialog(frame1,"You are entering a new Weapon");
						JOptionPane.showMessageDialog(null, "Please enter details");
						type = JOptionPane.showInputDialog(frame1, "Enter type");
						stock = JOptionPane.showInputDialog(frame1, "Enter stock");
						String q = "insert into armory(ar_name, ar_type, ar_stock) values('"+name+"','"+type+"','"+stock+"');";
						st.execute(q);
						System.out.println(stock);
						
					}
				}
				catch(Exception e){
					e.printStackTrace();
				}
				
				
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				sr.setBackground(gh);
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				sr.setBackground(gn);
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		
		
		frame1.add(lb1);
		lb1.setBounds(255,30,400,25);
		lb1.setFont(new Font("Sans-serif",Font.BOLD,25));
		lb1.setForeground(Color.black);		
		frame1.add(lb1_txt);
		lb1_txt.setBounds(255,75,400,25);
		//lb1_txt.setOpaque(true);
		lb1_txt.setFont(new Font("Sans-serif",Font.BOLD,20));
		lb1_txt.setForeground(Color.white);
		lb1_txt.setBackground(Color.black);
		
		
		frame1.add(lb3);
		lb3.setBounds(255,150,400,25);
		lb3.setFont(new Font("Sans-serif",Font.BOLD,20));
		lb3.setForeground(Color.black);
		frame1.add(lb3_txt);
		lb3_txt.setBounds(255,195,400,25);
		//lb3_txt.setOpaque(false);
		lb3_txt.setFont(new Font("Sans-serif",Font.BOLD,20));
		lb3_txt.setForeground(Color.white);
		lb3_txt.setBackground(Color.black);
		
		
		frame1.add(lb5);
		lb5.setBounds(255,270,400,25);
		lb5.setFont(new Font("Sans-serif",Font.BOLD,25));
		lb5.setForeground(Color.black);
		frame1.add(lb5_txt);
		lb5_txt.setBounds(255,315,400,25);
		//lb5_txt.setOpaque(false);
		lb5_txt.setFont(new Font("Sans-serif",Font.BOLD,25));
		lb5_txt.setForeground(Color.white);
		lb5_txt.setBackground(Color.black);
		
		
		frame1.setVisible(true);
		frame1.pack();
		frame1.setResizable(false);
		frame1.setLocationRelativeTo(null);
		
	
	}

}
