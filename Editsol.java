import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.sql.Statement;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Editsol {
	public Editsol(){
		JFrame frame = new JFrame("Add Operation");
		try{
			frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("E:\\Project\\wallpaper2you_340899.png")))));
		}
		catch (Exception e)
		{
			
		}	
		
		Color on= new Color(255,165,0);
		Color oh= new Color(255,100,0);
		
		
		JLabel ok = new JLabel("OK");
		
		JLabel lb2 = new JLabel("Enter Soldier's Name:");
		JTextField lb2_txt = new JTextField();
		
		JLabel lb4 = new JLabel("Enter Soldier's Service Number:");
		JTextField lb4_txt = new JTextField();
		
		JLabel lb6 = new JLabel("Enter Soldier's Rank:");
		JTextField lb6_txt = new JTextField();
		
		JLabel lb8 = new JLabel("Enter Soldier's Age:");
		JTextField lb8_txt = new JTextField();
		
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
				try{
					Statement st = new connect().con();
					String q = "insert into soldier(sol_pic) values('"+path+"');";
					st.execute(q);
					
				}
				catch(Exception e){
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
				// TODO Auto-generated method stub
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
		
	
		
		frame.add(lb2);
		lb2.setBounds(255,30,400,30);
		lb2.setFont(new Font("Sans-serif",Font.BOLD,25));
		lb2.setForeground(Color.black);
		frame.add(lb2_txt);
		lb2_txt.setBounds(255,70,400,30);
		lb2_txt.setOpaque(false);
		lb2_txt.setFont(new Font("Sans-serif",Font.BOLD,15));
		lb2_txt.setForeground(Color.DARK_GRAY);
		
		frame.add(lb4);
		lb4.setBounds(255,120,400,30);
		lb4.setFont(new Font("Sans-serif",Font.BOLD,25));
		lb4.setForeground(Color.black);
		frame.add(lb4_txt);
		lb4_txt.setBounds(255,160,400,30);
		lb4_txt.setOpaque(false);
		lb4_txt.setFont(new Font("Sans-serif",Font.BOLD,15));
		lb4_txt.setForeground(Color.DARK_GRAY);
		
		frame.add(lb6);
		lb6.setBounds(255,300,400,30);
		lb6.setFont(new Font("Sans-serif",Font.BOLD,25));
		lb6.setForeground(Color.black);
		frame.add(lb6_txt);
		lb6_txt.setBounds(255,340,400,30);
		lb6_txt.setOpaque(false);
		lb6_txt.setFont(new Font("Sans-serif",Font.BOLD,15));
		lb6_txt.setForeground(Color.DARK_GRAY);
		
		frame.add(lb8);
		lb8.setBounds(255,210,400,30);
		lb8.setFont(new Font("Sans-serif",Font.BOLD,25));
		lb8.setForeground(Color.black);
		frame.add(lb8_txt);
		lb8_txt.setBounds(255,250,400,30);
		lb8_txt.setOpaque(false);
		lb8_txt.setFont(new Font("Sans-serif",Font.BOLD,15));
		lb8_txt.setForeground(Color.DARK_GRAY);
		
		
		frame.setVisible(true);
		frame.pack();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		
	}

	

}
