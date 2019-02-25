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

public class Editop {
	String path;
	public Editop(){
		JFrame frame = new JFrame("Add Operation");
		try{
			frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("E:\\Project\\bg - Copy.jpg")))));
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
		
		JLabel lb2 = new JLabel("Enter Operation's Name:");
		JTextField lb2_txt = new JTextField();
		
		JLabel lb4 = new JLabel("Enter Operation's Type:");
		JTextField lb4_txt = new JTextField();
		
		JLabel lb6 = new JLabel("Enter Operation's Year:");
		JTextField lb6_txt = new JTextField();
		
		JFileChooser dp_chooser = new JFileChooser();
		JLabel dp = new JLabel();
		frame.add(dp);
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
				System.out.println(path);
				ImageIcon i = new ImageIcon(new ImageIcon(path).getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH));
				dp.setIcon(i);
				path = path.replace("\\", "/");
				System.out.println(path);
				try
				{
					Statement st = new connect().con();
					String q = "insert into ops_pic(op_im) values('"+path+"');";
					st.execute(q);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
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

		
		frame.add(ok);
		ok.setHorizontalAlignment(SwingConstants.CENTER);
		ok.setBounds(35,350,100,30);
		ok.setBackground(on);
		ok.setOpaque(true);
		ok.setFont(new Font("Sans-serif",Font.BOLD,20));
		ok.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				new TabbedPane();
				frame.dispose();
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
		
		frame.add(sr);
		sr.setHorizontalAlignment(SwingConstants.CENTER);
		sr.setBounds(255,110,100,30);
		sr.setBackground(gn);
		sr.setForeground(Color.WHITE);
		sr.setOpaque(true);
		sr.setFont(new Font("Sans-serif",Font.BOLD,20));
		sr.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				try
				{
					String name = lb2_txt.getText();
					Statement st = new connect().con();
					String query = "select * from operations where op_name = '"+name+"';";
					ResultSet rs = st.executeQuery(query);
					if(rs.next()){
						lb4_txt.setText(rs.getString(2));
						lb6_txt.setText(rs.getString(3));
					}
					else
					{
						String det, type, year;
			
						JOptionPane.showMessageDialog(frame, "You are entering a new Operation");
						JOptionPane.showMessageDialog(null, "Please enter details");
						type = JOptionPane.showInputDialog(frame, "Enter the type of operation");
						year = JOptionPane.showInputDialog(frame, "Enter the year of operation");
						det = JOptionPane.showInputDialog(frame, "Enter the details of operation");
						String q = "insert into operations(op_name, op_type, op_year, det) values('"+name+"', '"+type+"', '"+year+"', '"+det+"');";
						st.execute(q);
						System.out.println(det);
					}
				}
				catch(Exception e)
				{
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
		
		
		frame.add(lb2);
		lb2.setBounds(255,30,400,25);
		lb2.setFont(new Font("Sans-serif",Font.BOLD,25));
		lb2.setForeground(Color.black);
		frame.add(lb2_txt);
		lb2_txt.setBounds(255,70,400,25);
		lb2_txt.setOpaque(false);
		lb2_txt.setFont(new Font("Sans-serif",Font.BOLD,15));
		lb2_txt.setForeground(Color.DARK_GRAY);
		
		frame.add(lb4);
		lb4.setBounds(255,150,400,25);
		lb4.setFont(new Font("Sans-serif",Font.BOLD,25));
		lb4.setForeground(Color.black);
		frame.add(lb4_txt);
		lb4_txt.setBounds(255,190,400,25);
		lb4_txt.setOpaque(false);
		lb4_txt.setFont(new Font("Sans-serif",Font.BOLD,15));
		lb4_txt.setForeground(Color.DARK_GRAY);
		
		frame.add(lb6);
		lb6.setBounds(255,270,400,25);
		lb6.setFont(new Font("Sans-serif",Font.BOLD,25));
		lb6.setForeground(Color.black);
		frame.add(lb6_txt);
		lb6_txt.setBounds(255,310,400,25);
		lb6_txt.setOpaque(false);
		lb6_txt.setFont(new Font("Sans-serif",Font.BOLD,15));
		lb6_txt.setForeground(Color.DARK_GRAY);
		
		frame.setVisible(true);
		frame.pack();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		
	}



}
