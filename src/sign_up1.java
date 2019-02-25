import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.sql.SQLException;
import java.sql.Statement;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
public class sign_up1 {
	
	String path = "E:\\Project\\choose_dp.jpg";
	
	public sign_up1(){
		JFrame frame = new JFrame("Please Sign-up");
		try{
			frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("E:\\Project\\740982-air-force-day-2018bb-yadavdna.jpg")))));
		}
		catch (Exception e){
			
		}
		
		Color gn=new Color(0,200,0);
		Color gh=new Color(0,150,0);
		Color on= new Color(255,165,0);
		Color oh= new Color(255,100,0);
	
		JLabel lb = new JLabel("SIGN UP");
		JTextField tf1 = new JTextField("Enter Name");
		JTextField tf2 = new JTextField("Enter Serial Number");
		JTextField tf3 = new JTextField("Enter Password");
		JTextField tf4 = new JPasswordField("Confirm Password");
		JTextField tf5 = new JTextField("Enter Your Rank");
		JTextField tf6 = new JTextField("Enter Age");
		JLabel signup = new JLabel("Next");
		JLabel back = new JLabel("Back");
		
		frame.add(lb);
		lb.setBounds(35,25,200,25);
		lb.setFont(new Font("Sans-serif",Font.BOLD,30));
		
		tf1.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				tf1.setText(null);
				
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
		
		frame.add(tf1);
		tf1.setBounds(38,70,200,25);
		tf1.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				tf1.setText(null);
				
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
		
		
		frame.add(tf2);
		tf2.setBounds(38,115,200,25);
		tf2.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				tf2.setText(null);
				
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
		
		frame.add(tf3);
		tf3.setBounds(38,206,200,25);
		tf3.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				tf3.setText(null);
				
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
		
		frame.add(tf4);
		tf4.setBounds(38,250,200,25);
		tf4.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				tf4.setText(null);
				
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
		
		frame.add(tf5);
		tf5.setBounds(38,290,200,25);
		tf5.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				tf5.setText(null);
				
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
		frame.add(tf6);
		tf6.setBounds(38,160,200,25);
		tf6.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				tf6.setText(null);
				
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
		
		
		
		
		
        JFileChooser dp_chooser = new JFileChooser();
		JLabel dp = new JLabel();
		frame.add(dp);
		dp.setBounds(400, 60,150, 150);
		ImageIcon i = new ImageIcon(new ImageIcon(path).getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH));
		dp.setIcon(i);
		dp.addMouseListener(new MouseListener()
		{

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
					path = "E:\\Project\\choose_dp.jpg";
				}
				System.out.println(path);
				ImageIcon i = new ImageIcon(new ImageIcon(path).getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH));
				dp.setIcon(i);
				path = path.replace("\\", "/");
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

		
		frame.add(back);
		back.setHorizontalAlignment(SwingConstants.CENTER);
		back.setBounds(40,350,100,25);
		back.setBackground(on);
		back.setOpaque(true);
		back.setFont(new Font("Sans-serif",Font.BOLD,20));
		back.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				new Login();
				frame.dispose();
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				back.setBackground(oh);
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				back.setBackground(on);
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
		
		
		frame.add(signup);
		signup.setHorizontalAlignment(SwingConstants.CENTER);
		signup.setBounds(565,350,100,25);
		signup.setBackground(gn);
		signup.setOpaque(true);
		signup.setFont(new Font("Sans-serif",Font.BOLD,20));
		signup.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				if((tf3.getText().toString()).equals((tf4).getText()))
				{
					String name,sn,cnpass,rank,age;
					name = tf1.getText().toString();
					sn = tf2.getText().toString();
					cnpass = tf4.getText().toString();
					rank = tf5.getText().toString();
					age = tf6.getText().toString();
					
					try{
						path = path.replace("\\", "/");
						connect con = new connect();
						Statement st = con.con();
						String sql = "insert into soldier values ('"+name+"','"+sn+"','"+rank+"','"+age+"','"+cnpass+"', '"+path+"');";
						st.execute(sql);
						
						new regcm();
						frame.dispose();
					}
					catch(SQLException e1){
						e1.printStackTrace();
					}
				}
				
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				signup.setBackground(gh);
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				signup.setBackground(gn);
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
		
		
		frame.setVisible(true);
		frame.pack();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
	}
}



