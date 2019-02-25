
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class regcm {
	public regcm(){
		JFrame frame = new JFrame();
		try{
			frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("E:\\Project\\wallpaper2you_340836.jpg")))));
	}
		catch (Exception e)
		{
			
		}
		Color on= new Color(255,165,0);
		Color oh= new Color(255,100,0);
		
		JLabel rc = new JLabel("!!!REGISTRATION COMPLETE!!!");
		JLabel ok = new JLabel("OK");
		
		frame.add(rc);
		rc.setBounds(0,130,700,100);
		rc.setHorizontalAlignment(SwingConstants.CENTER);
		rc.setForeground(Color.BLACK);
		rc.setFont(new Font("Sans-serif",Font.BOLD,32));
		rc.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				new Login();
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
		
		frame.add(ok);
		ok.setHorizontalAlignment(SwingConstants.CENTER);
		ok.setBounds(300,250,100,30);
		ok.setBackground(on);
		ok.setOpaque(true);
		ok.setFont(new Font("Sans-serif",Font.BOLD,20));
		ok.addMouseListener(new MouseListener()
				{

					@Override
					public void mouseClicked(MouseEvent arg0) {
						new Login();
						frame.dispose();
						
					}

					@Override
					public void mouseEntered(MouseEvent arg0) {
						ok.setBackground(oh);
						
					}

					@Override
					public void mouseExited(MouseEvent arg0) {
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
		
		
		frame.setVisible(true);
		frame.pack();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
	}

	

}