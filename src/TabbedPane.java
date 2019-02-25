
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;


public class TabbedPane {
	
	
	public TabbedPane(){
		JFrame frame = new JFrame("Personnel Database");
		
		try{
			frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("E:\\Project\\bg.jpg")))));
		}
		catch (Exception e)
		{
			
		}
		
		
		JButton oa = new JButton("Add Operation");
		
		JButton are = new JButton("Edit Armory");
		
		JButton ae = new JButton("Edit Aircrafts");
		
		JButton se = new JButton("Edit Details");
		 
		
		JPanel pan1 = new JPanel();
		pan1.setLayout(new BoxLayout(pan1,BoxLayout.Y_AXIS));
		
		JPanel pan2 = new JPanel();
		pan2.setLayout(new BoxLayout(pan2,BoxLayout.Y_AXIS));
		
		JPanel pan3 = new JPanel();
		pan3.setLayout(new BoxLayout(pan3,BoxLayout.Y_AXIS));
		
		JPanel pan4 = new JPanel();
		pan4.setLayout(new BoxLayout(pan4,BoxLayout.Y_AXIS));
		
		JPanel pan5 = new JPanel();
		pan5.setLayout(new BoxLayout(pan5,BoxLayout.Y_AXIS));
		
		JScrollPane jsp1 = new JScrollPane();
		jsp1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		JScrollPane jsp2 = new JScrollPane();
		jsp2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		JScrollPane jsp3 = new JScrollPane();
		jsp3.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		JScrollPane jsp4 = new JScrollPane();
		jsp4.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		JScrollPane jsp5 = new JScrollPane();
		jsp5.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		
		JTabbedPane tp = new JTabbedPane();
		
		
		try
		{
			Statement st1 = new connect().con();
			Statement st2 = new connect().con();
			String query1 = "select * from operations;";
			String query2 ="select * from ops_pic;";
			ResultSet rs = st1.executeQuery(query1);
			ResultSet rs1 = st2.executeQuery(query2);
			
			while(rs.next())
			{
				rs1.next();
				String op_name = rs.getString(1);
				String op_type = rs.getString(2);
				String op_det = rs.getString(4);
				String op_year = rs.getString(3);
				
				
				JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
				JLabel label = new JLabel();
				TitledBorder title = BorderFactory.createTitledBorder(op_name);
				title.setTitleFont(new Font("Sans-serif", Font.BOLD, 20));
				panel.setBorder(title);
				

				//JLabel lab1 = new JLabel("Place:");
				JLabel lab2 = new JLabel("Year:");
				JLabel lab3 = new JLabel("Type:");
				JLabel lab4 = new JLabel("Det:");
				
				//lab2.setForeground(Color.RED);
				lab2.setForeground(Color.RED);
				lab3.setForeground(Color.RED);
				lab4.setForeground(Color.RED);
				
				lab2.setFont(new Font("Sans-serif",Font.BOLD,20));
				lab3.setFont(new Font("Sans-serif",Font.BOLD,20));
				lab4.setFont(new Font("Sans-serif",Font.BOLD,20));
				
				//JLabel lab1_cont = new JLabel();
				JLabel lab2_cont = new JLabel(op_year);
				JLabel lab3_cont = new JLabel(op_type);
				JLabel lab4_cont = new JLabel(op_det);
				
				lab2_cont.setFont(new Font("Sans-serif",Font.ITALIC,20));
				lab3_cont.setFont(new Font("Sans-serif",Font.ITALIC,20));
				lab4_cont.setFont(new Font("Sans-serif",Font.ITALIC,20));
				
				panel.add(label);
				panel.add(lab2);
				panel.add(lab2_cont);
				panel.add(lab3);
				panel.add(lab3_cont);
				panel.add(lab4);
				panel.add(lab4_cont);
			
				ImageIcon im = new ImageIcon(new ImageIcon(rs1.getString(2)).getImage().getScaledInstance(200, 100, Image.SCALE_SMOOTH));
				label.setIcon(im);
			
				
				
				pan2.add(panel);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		pan2.add(oa);
		oa.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				new Editop();
				frame.dispose();
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
		jsp1.setViewportView(pan2);
		
		try
		{
			Statement st1 = new connect().con();
			Statement st2 = new connect().con();
			String query1 = "select * from armory;";
			String query2 ="select * from ar_pic;";
			ResultSet rs = st1.executeQuery(query1);
			ResultSet rs1 = st2.executeQuery(query2);
			
			while(rs.next())
			{
				rs1.next();
				String ar_name = rs.getString(1);
				String ar_type = rs.getString(2);
				String ar_stock = rs.getString(3);
				
				
				JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
				JLabel label = new JLabel();
				TitledBorder title = BorderFactory.createTitledBorder(ar_name);
				title.setTitleFont(new Font("Sans-serif", Font.BOLD, 20));
				panel.setBorder(title);
				
				JLabel lab3 = new JLabel("Type:");
				JLabel lab4 = new JLabel("Stock:");
				
				lab3.setForeground(Color.RED);
				lab4.setForeground(Color.RED);
				
				
				lab3.setFont(new Font("Sans-serif",Font.BOLD,20));
				lab4.setFont(new Font("Sans-serif",Font.BOLD,20));
				
				
				JLabel lab3_cont = new JLabel(ar_type);
				JLabel lab4_cont = new JLabel(ar_stock);
				
				lab3_cont.setFont(new Font("Sans-serif",Font.ITALIC,20));
				lab4_cont.setFont(new Font("Sans-serif",Font.ITALIC,20));
				
				panel.add(label);
				panel.add(lab3);
				panel.add(lab3_cont);
				panel.add(lab4);
				panel.add(lab4_cont);
			
				ImageIcon im = new ImageIcon(new ImageIcon(rs1.getString(2)).getImage().getScaledInstance(200, 100, Image.SCALE_SMOOTH));
				label.setIcon(im);
			
				
				
				pan1.add(panel);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		pan1.add(are);
		are.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				new Edits();
				frame.dispose();
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
		jsp2.setViewportView(pan1);
		
		
		try
		{
			Statement st1 = new connect().con();
			Statement st2 = new connect().con();
			String query1 = "select * from aircrafts;";
			String query2 ="select * from ac_pic;";
			ResultSet rs = st1.executeQuery(query1);
			ResultSet rs1 = st2.executeQuery(query2);
			
			while(rs.next())
			{
				rs1.next();
				String ac_name = rs.getString(1);
				String ac_type = rs.getString(2);
				String ac_stock = rs.getString(3);
				//String ac_id = rs.getString(4);
				
				
				JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
				JLabel label = new JLabel();
				TitledBorder title = BorderFactory.createTitledBorder(ac_name);
				title.setTitleFont(new Font("Sans-serif", Font.BOLD, 20));
				panel.setBorder(title);
				
				JLabel lab2 = new JLabel("Type:");
				JLabel lab3 = new JLabel("Stock:");
				
				lab2.setForeground(Color.RED);
				lab3.setForeground(Color.RED);
				
				lab3.setFont(new Font("Sans-serif",Font.BOLD,20));
				lab2.setFont(new Font("Sans-serif",Font.BOLD,20));
								
				JLabel lab2_cont = new JLabel(ac_type);
				JLabel lab3_cont = new JLabel(ac_stock);
				
				lab3_cont.setFont(new Font("Sans-serif",Font.ITALIC,20));
				lab2_cont.setFont(new Font("Sans-serif",Font.ITALIC,20));
				
				panel.add(label);
				panel.add(lab2);
				panel.add(lab2_cont);
				panel.add(lab3);
				panel.add(lab3_cont);
			
				ImageIcon im = new ImageIcon(new ImageIcon(rs1.getString(2)).getImage().getScaledInstance(200, 100, Image.SCALE_SMOOTH));
				label.setIcon(im);
			
				
				
				pan3.add(panel);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		pan3.add(ae);
		ae.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				new Editar();
				frame.dispose();
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
		jsp3.setViewportView(pan3);
		
		try
		{
			Statement st1 = new connect().con();
			String query1 = "select * from soldier;";
			ResultSet rs = st1.executeQuery(query1);
			
			while(rs.next())
			{
				String sol_name = rs.getString(1);
				String ser_no = rs.getString(2);
				String rank = rs.getString(3);
				String pic = rs.getString(6);
				String age = rs.getString(4);
				
				JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
				TitledBorder title = BorderFactory.createTitledBorder(sol_name);
				title.setTitleFont(new Font("Sans-serif", Font.BOLD, 20));
				panel.setBorder(title);
			

				JLabel lab1 = new JLabel("Service No:");
				JLabel lab2 = new JLabel("Rank:");
				JLabel lab3 = new JLabel("Age:");
				
				lab1.setForeground(Color.RED);
				lab2.setForeground(Color.RED);
				lab3.setForeground(Color.RED);
				
				lab1.setFont(new Font("Sans-serif",Font.BOLD,20));
				lab3.setFont(new Font("Sans-serif",Font.BOLD,20));
				lab2.setFont(new Font("Sans-serif",Font.BOLD,20));
				
				JLabel label = new JLabel();
				JLabel lab1_cont = new JLabel(ser_no);
				JLabel lab2_cont = new JLabel(rank);
				JLabel lab3_cont = new JLabel(age);
				
				lab1_cont.setFont(new Font("Sans-serif",Font.ITALIC,20));				
				lab3_cont.setFont(new Font("Sans-serif",Font.ITALIC,20));
				lab2_cont.setFont(new Font("Sans-serif",Font.ITALIC,20));
				
				
				ImageIcon im = new ImageIcon(new ImageIcon(pic).getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH));
				label.setIcon(im);
				
				panel.add(label);
				panel.add(lab1);
				panel.add(lab1_cont);
				panel.add(lab2);
				panel.add(lab2_cont);
				panel.add(lab3);
				panel.add(lab3_cont);
			
				pan4.add(panel);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		pan4.add(se);
		se.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				new Editsol();
				frame.dispose();
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

		jsp4.setViewportView(pan4);
		
		
		try
		{
			Statement st1 = new connect().con();
			String query1 = "select * from station;";
			ResultSet rs = st1.executeQuery(query1);
			
			while(rs.next())
			{
				String st_name = rs.getString(1);
				String st_type = rs.getString(2);
				String district = rs.getString(4);
				System.out.println(st_name);
				System.out.println(st_type);
				System.out.println(district);
				
				JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
				TitledBorder title = BorderFactory.createTitledBorder(st_name);
				title.setTitleFont(new Font("Sans-serif", Font.BOLD, 20));
				panel.setBorder(title);

			

				JLabel lab1 = new JLabel("Station Name:");
				JLabel lab2 = new JLabel("Station Type:");
				JLabel lab3 = new JLabel("District:");
				
				lab1.setFont(new Font("Sans-serif", Font.BOLD, 20));
				lab2.setFont(new Font("Sans-serif", Font.BOLD, 20));
				lab3.setFont(new Font("Sans-serif", Font.BOLD, 20));
				
				lab1.setForeground(Color.RED);
				lab2.setForeground(Color.RED);
				lab3.setForeground(Color.RED);
				
				JLabel lab1_cont = new JLabel();
				JLabel lab2_cont = new JLabel();
				JLabel lab3_cont = new JLabel();
				
				lab1_cont.setFont(new Font("Sans-serif", Font.ITALIC, 20));
				lab2_cont.setFont(new Font("Sans-serif", Font.ITALIC, 20));
				lab3_cont.setFont(new Font("Sans-serif", Font.ITALIC, 20));
		
				lab1_cont.setText(st_name);
				lab2_cont.setText(st_type);
				lab3_cont.setText(district);
				
				panel.add(lab1);
				panel.add(lab1_cont);
				panel.add(lab2);
				panel.add(lab2_cont);
				panel.add(lab3);
				panel.add(lab3_cont);
			
				pan5.add(panel);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		jsp5.setViewportView(pan5);
		
		
		tp.add("Operations",jsp1);
		tp.add("Armory",jsp2);
		tp.add("Aircrafts",jsp3);
		tp.addTab("Soldiers",jsp4);
		tp.addTab("Stations",jsp5);
		
		frame.add(tp);
		tp.setBounds(0, 0, 1000, 600);
		
		
		frame.setVisible(true);
		frame.pack();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		
	}
	

}
