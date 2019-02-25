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

public class Editar {
	public Editar(){
		JFrame frame2 = new JFrame("Add Aircraft");
		
		try{
			frame2.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("E:\\Project\\30592-wonjfcejez-1469640766.jpg")))));
		}
		catch (Exception e)
		{
			
		}
		
		Color on= new Color(255,165,0);
		Color oh= new Color(255,100,0);
		Color gn = new Color(0,200,0);
		Color gh = new Color(0,150,0);
		
		JLabel sr = new JLabel("Search");
		JLabel ok = new JLabel("OK");
		
		JLabel lb2 = new JLabel("Enter Aircraft's Name:");
		JTextField lb2_txt = new JTextField();
		
		JLabel lb4 = new JLabel("Enter Aircraft's Type:");
		JTextField lb4_txt = new JTextField();
		
		JLabel lb6 = new JLabel("Enter Aircraft's Stock:");
		JTextField lb6_txt = new JTextField();
		
		JFileChooser dp_chooser = new JFileChooser();
		JLabel dp = new JLabel();
		frame2.add(dp);
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
					String query = "insert into ac_pic(pic) values('"+path+"');";
					st.execute(query);
				}
				catch(Exception e)
				{
					
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

		
		frame2.add(ok);
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
				frame2.dispose();
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
		
		frame2.add(sr);
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
					String name = lb2_txt.getText();
					Statement st = new connect().con();
					Statement st2 = new connect().con();
					String query = "select * from aircrafts where ac_name = '"+name+"';";
					String q1 = "select * from ac_pic where ac_id = (select ac_id from aircrafts where ac_name = '"+name+"');";
					ResultSet rs = st.executeQuery(query);
					if(rs.next()){
						lb4_txt.setText(rs.getString(2));
						lb6_txt.setText(rs.getString(3));
						ResultSet r = st2.executeQuery(q1);
						r.next();
						ImageIcon i = new ImageIcon(new ImageIcon(r.getString(2)).getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH));
						dp.setIcon(i);
					}
					else{
						String type,stock;
						
						JOptionPane.showMessageDialog(frame2,"You are entering a new Aircraft");
						JOptionPane.showMessageDialog(null, "Please enter details");
						type = JOptionPane.showInputDialog(frame2, "Enter type");
						stock = JOptionPane.showInputDialog(frame2, "Enter stock");
						String q = "insert into aircrafts(ac_name, ac_type, ac_stock) values('"+name+"','"+type+"','"+stock+"');";
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
		
		
		frame2.add(lb2);
		lb2.setBounds(255,30,400,25);
		lb2.setFont(new Font("Sans-serif",Font.BOLD,25));
		lb2.setForeground(Color.black);
		frame2.add(lb2_txt);
		lb2_txt.setBounds(255,70,400,25);
		lb2_txt.setOpaque(false);
		lb2_txt.setFont(new Font("Sans-serif",Font.BOLD,20));
		lb2_txt.setForeground(Color.DARK_GRAY);
		
		frame2.add(lb4);
		lb4.setBounds(255,150,400,25);
		lb4.setFont(new Font("Sans-serif",Font.BOLD,25));
		lb4.setForeground(Color.black);
		frame2.add(lb4_txt);
		lb4_txt.setBounds(255,190,400,25);
		lb4_txt.setOpaque(false);
		lb4_txt.setFont(new Font("Sans-serif",Font.BOLD,20));
		lb4_txt.setForeground(Color.DARK_GRAY);
		
		frame2.add(lb6);
		lb6.setBounds(255,270,400,25);
		lb6.setFont(new Font("Sans-serif",Font.BOLD,25));
		lb6.setForeground(Color.black);
		frame2.add(lb6_txt);
		lb6_txt.setBounds(255,310,400,25);
		lb6_txt.setOpaque(false);
		lb6_txt.setFont(new Font("Sans-serif",Font.BOLD,20));
		lb6_txt.setForeground(Color.DARK_GRAY);
		
		frame2.setVisible(true);
		frame2.pack();
		frame2.setResizable(false);
		frame2.setLocationRelativeTo(null);
		
		
	}


}
