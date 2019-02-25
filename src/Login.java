import java.awt.Color;
import java.awt.Font;
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
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class Login {
	static String id; 
	public Login()
	{
		JFrame frame = new JFrame("Login to Base");
		try{
			frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("E:\\Project\\Login - Copy.jpg")))));
		}
		catch (Exception e)
		{
			
		}
		Color on= new Color(255,165,0);
		Color oh= new Color(255,100,0);
		Color gn = new Color(0,200,0);
		Color gh = new Color(0,150,0);
		
		JLabel lb = new JLabel("LOGIN");
		JTextField tf1 = new JTextField("Enter Service No.");
		JTextField tf2 = new JPasswordField("Password");
		JLabel login = new JLabel("Next");
		JLabel signup = new JLabel("Sign Up");
		JLabel wc1 = new JLabel("Indian");
		JLabel wc2 = new JLabel("Air");
		JLabel wc3 = new JLabel("Force");
		
		frame.add(wc1);
		wc1.setBounds(220,10,600,30);
		wc1.setFont(new Font("Sans-serif",Font.BOLD,40));
		wc1.setForeground(Color.orange);
		
		frame.add(wc2);
		wc2.setBounds(340,10,600,30);
		wc2.setFont(new Font("Sans-serif",Font.BOLD,40));
		wc2.setForeground(Color.white);
		
		frame.add(wc3);
		wc3.setBounds(410,10,600,30);
		wc3.setFont(new Font("Sans-serif",Font.BOLD,40));
		wc3.setForeground(Color.green);
		
		
		
		frame.add(lb);
		lb.setBounds(85,30,150,100);
		lb.setFont(new Font("Sans-serif",Font.BOLD,32));
		
		frame.add(tf1);
		tf1.setBounds(35,120,200,25);
		tf1.addMouseListener(new MouseListener()
				{

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
		tf2.setBounds(35,165,200,25);
		tf2.addMouseListener(new MouseListener()
		{

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

		
		frame.add(login);
		login.setHorizontalAlignment(SwingConstants.CENTER);
		login.setBounds(85,220,100,30);
		login.setBackground(on);
		login.setOpaque(true);
		login.setFont(new Font("Sans-serif",Font.BOLD,20));
		login.addMouseListener(new MouseListener()
				{

					@Override
					public void mouseClicked(MouseEvent arg0) {
						String sn,pass;
						sn = tf1.getText().toString();
						pass = tf2.getText().toString();
						
						try{
							connect con = new connect();
							Statement st = con.con();
							String sql = "select * from soldier where service_no='"+sn+"'and s_pass='"+pass+"';";
							ResultSet rs = st.executeQuery(sql);
							
							if(rs.next())
							{
								JOptionPane.showMessageDialog(null, "W E L C O M E   T O   T H E   B A S E");
								frame.dispose();
								new homepage(sn);
							}
							else
							{
								JOptionPane.showMessageDialog(null, "U N A U T H O R I S E D    A C C E S S");
							}
						}
						
						catch(SQLException e1)
						{
							e1.printStackTrace();
						}
						
						
					}

					@Override
					public void mouseEntered(MouseEvent arg0) {
						login.setBackground(oh);
						
					}

					@Override
					public void mouseExited(MouseEvent arg0) {
						login.setBackground(on);
						
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
		signup.setBounds(85,280,100,30);
		signup.setBackground(gn);
		signup.setOpaque(true);
		signup.setFont(new Font("Sans-serif",Font.BOLD,20));
		signup.addMouseListener(new MouseListener()
		{

			@Override
			public void mouseClicked(MouseEvent arg0) {
				new sign_up1();
				frame.dispose();
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				signup.setBackground(gh);
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
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
		return;
	}
	public static void main(String[] args)
	{
		new Login();
	}
	

}
