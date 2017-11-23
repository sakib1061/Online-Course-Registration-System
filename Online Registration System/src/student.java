import javax.swing.*;

import java.util.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
public class student {
	public static final JFrame JF=new JFrame("Online Reg Syestem");
	public static final JPanel JP=new JPanel(null);
	public static String A="",B="",P="";
	public static final String URL="jdbc:mysql://localhost:3306/ors";
	public static final String username="root";
	public static final String password="";
	public static  String user="";
	student(String A,String B,String C)
	{
		user=C;
		ini(A,B);
	}
	public static void ini(String A,String B)
	{
		clear();
		JF.setSize(900, 600);
		JF.setTitle("ADMIN");
		JF.setLocation(200, 100);
		JF.setIconImage(Toolkit.getDefaultToolkit().getImage(new LogIn().getClass().getResource("pic/ic.png")));
		JF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JP.setBackground(Color.white);
		JF.getContentPane().add(JP);
		JF.setResizable(false);
		JF.setVisible(true);
		JButton AD1=new JButton("Manage Student");
		AD1.setBounds(50, 200, 250, 150);
		ImageIcon ic1=new ImageIcon(new LogIn().getClass().getResource("pic/AD1.jpg"));
		AD1.setIcon(ic1);
		JP.add(AD1);
		JButton AD2=new JButton("Manage Student");
		AD2.setBounds(320, 200, 250, 150);
		ImageIcon ic2=new ImageIcon(new LogIn().getClass().getResource("pic/AD2.jpg"));
		AD2.setIcon(ic2);
		JP.add(AD2);
		JButton AD3=new JButton("Manage Student");
		AD3.setBounds(590, 200, 250, 150);
		ImageIcon ic3=new ImageIcon(new LogIn().getClass().getResource("pic/AD3.jpg"));
		AD3.setIcon(ic3);
		JP.add(AD3);
		JButton AD4=new JButton("Manage Student");
		AD4.setBounds(320, 380, 250, 150);
		ImageIcon ic4=new ImageIcon(new LogIn().getClass().getResource("pic/AD4.jpg"));
		AD4.setIcon(ic4);
		JP.add(AD4);
		JLabel ors=new JLabel("ORS");
		ors.setBounds(50, 30, 100, 100);
		ImageIcon ic=new ImageIcon(new LogIn().getClass().getResource("pic/MIC.jpg"));
		ors.setIcon(ic);
		JP.add(ors);
		JLabel name=new JLabel(A+" "+B);
		name.setBounds(550, 30, 200, 100);
		name.setForeground(Color.decode("#006DB6"));
		name.setFont(new Font("Nyala",Font.BOLD,25));
		JP.add(name);
		final JButton Log=new JButton("Logout");
		Log.setBounds(750, 60, 80, 50);
		ImageIcon LG=new ImageIcon(new LogIn().getClass().getResource("pic/LOGOUT.jpg"));
		Log.setIcon(LG);
		JP.add(Log);
		Log.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				
				
					
					
					
						
				LogIn T=new LogIn(new JFrame("Log In"), 900,600, new JPanel(null));
						
						JF.dispose();
						T=null;
						
					
				
//					Log.removeActionListener(this);

			}
		});
	}
	static void clear()
    {
    	JF.getContentPane().removeAll();
		JP.removeAll();
		JF.getContentPane().add(JP);
		JF.getContentPane().revalidate();
		JP.repaint();
		JP.setBackground(Color.white);
    }
}
