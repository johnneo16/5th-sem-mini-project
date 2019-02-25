import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class homepage {
	static String u1;
	public homepage(String id){
		u1=id;
		JFrame frame = new JFrame("Base");
		try{
			frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("E:\\Project\\wallpaper2you_340866.jpg")))));
		}
		catch (Exception e)
		{
			
		}
		
		
		
		Color on= new Color(232,60,10);
		Color oh= new Color(154,67,15);
		Color gn=new Color(0,200,0);
		Color gh=new Color(0,150,0);
		
		JLabel img = new JLabel();
		JLabel tf1 = new JLabel("Name:");
		JLabel tf1_text = new JLabel();
		JLabel tf2 = new JLabel("Service No.:");
		JLabel tf2_text = new JLabel();
		JLabel tf3 = new JLabel("Rank:");
		JLabel tf3_text = new JLabel();
		JLabel tf4 = new JLabel("Age:");
		JLabel tf4_text = new JLabel();
		
		
		
		JLabel bt2 = new JLabel("Enter to the Database");
		JLabel bt1 = new JLabel("Log Out");
		
		frame.add(img);
		img.setBounds(20, 20, 150, 150);
		
		frame.add(tf1);
		tf1.setBounds(455,30,200,25);
		tf1_text.setFont(new Font("Sans-serif",Font.BOLD,20));
		tf1.setFont(new Font("Sans-serif",Font.BOLD,25));
		
		frame.add(tf2);
		tf2.setBounds(455,150,200,25);
		tf2.setFont(new Font("Sans-serif",Font.BOLD,25));
		tf2.setForeground(Color.WHITE);
		
		frame.add(tf3);
		tf3.setBounds(200,30,200,25);
		tf3.setFont(new Font("Sans-serif",Font.BOLD,25));
		
		frame.add(tf4);
		tf4.setBounds(200,150,200,25);
		tf4.setFont(new Font("Sans-serif",Font.BOLD,25));
		tf4.setForeground(Color.WHITE);
		
		frame.add(tf1_text);
		tf1_text.setBounds(455,70,220,25);
		tf1_text.setForeground(Color.black);
		tf1_text.setFont(new Font("Sans-serif",Font.BOLD,20));
		//tf1_text.setOpaque(true);
		
		frame.add(tf2_text);
		tf2_text.setBounds(455,190,220,25);
		tf2_text.setForeground(Color.white);
		tf2_text.setFont(new Font("Sans-serif",Font.BOLD,20));
		//tf2_text.setOpaque(true);
		
		frame.add(tf3_text);
		tf3_text.setBounds(200,70,220,25);
		tf3_text.setForeground(Color.black);
		tf3_text.setFont(new Font("Sans-serif",Font.BOLD,20));
		//tf3_text.setOpaque(true);
		
		frame.add(tf4_text);
		tf4_text.setBounds(200,190,220,25);
		tf4_text.setForeground(Color.white);
		tf4_text.setFont(new Font("Sans-serif",Font.BOLD,20));
		//tf4_text.setOpaque(true);
	
	
	
	frame.add(bt2);
	bt2.setHorizontalAlignment(SwingConstants.CENTER);
	bt2.setBounds(210,270,300,80);
	bt2.setBackground(on);
	bt2.setOpaque(true);
	bt2.setFont(new Font("Sans-serif",Font.BOLD,20));
	bt2.setForeground(Color.WHITE);
	bt2.addMouseListener(new MouseListener(){

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			new TabbedPane();
			frame.dispose();
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			bt2.setBackground(oh);
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			bt2.setBackground(on);
			
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
	
	frame.add(bt1);
	bt1.setHorizontalAlignment(SwingConstants.CENTER);
	bt1.setBounds(50,300,100,30);
	bt1.setBackground(gn);
	bt1.setOpaque(true);
	bt1.setFont(new Font("Sans-serif",Font.BOLD,20));
	bt1.setForeground(Color.WHITE);
	bt1.addMouseListener(new MouseListener(){

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			new Login();
			frame.dispose();
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			bt1.setBackground(gh);
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			bt1.setBackground(gn);
			
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
	
	try
	{
		connect con = new connect();
		Statement st = con.con();
		String sql = "select * from soldier where service_no='"+u1+"';";
		ResultSet rs = st.executeQuery(sql);
		
		if(rs.next())
		{
			String s1=rs.getString(1);
			String s2=rs.getString(2);
			String s3=rs.getString(3);
			String s4=rs.getString(4);
			String s5=rs.getString(6);
			tf1_text.setText(s1);
			tf2_text.setText(s2);
			tf3_text.setText(s3);
			tf4_text.setText(s4);
			ImageIcon dp = new ImageIcon(new ImageIcon(s5).getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH));
			img.setIcon(dp);
		}
	}
	catch(SQLException ex)
	{
		ex.printStackTrace();
	}
	
	
	frame.setVisible(true);
	frame.pack();
	frame.setResizable(false);
	frame.setLocationRelativeTo(null);
	}
}
