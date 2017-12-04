import javafx.geometry.Insets;

import javax.swing.*;

import java.util.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.sql.*;
public class registrar {
	public static final JFrame JF=new JFrame("Registration Management System");
	public static final JPanel JP=new JPanel(null);
	public static String A="",B="",P="";
	public static final String URL="jdbc:mysql://localhost:3306/rms";
	public static final String username="root";
	public static final String password="";
	public static final String[] Yr={"1","2","3","4"};
	public static final String[] Sm={"1","2"};
	public static  String[] list=new String[12];
	public static  String[] yrr=new String[12];
	public static  String[] smm=new String[12];
	registrar()
	{
		
		clear();
		JF.setSize(900,600);
		JF.setLocation(100, 100);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		JF.setLocation(dim.width/2-JF.getSize().width/2, dim.height/2-JF.getSize().height/2);
		JF.setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("icon/MIC.png")));
		JF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JP.setBackground(Color.white);
		JF.getContentPane().add(JP);
		JLabel L1=new JLabel("Start");
		L1.setBounds(0, 0, 900, 200);
		ImageIcon ic1=new ImageIcon(this.getClass().getResource("icon/L1.jpg"));
		L1.setIcon(ic1);
		JP.add(L1);
		int o=0,y=220,i=0;
		
		JLabel[] st=new JLabel[12];
		JLabel[] dp=new JLabel[12];
		JButton[] Ap=new JButton[12];
		try {
			Connection SqlCon=DriverManager.getConnection(URL,username,password);
			Statement SqlState=SqlCon.createStatement();
			ResultSet rs=SqlState.executeQuery("Select * from coursereg where chairman like'%Yes%' and provost like'%Yes%' and registrar like'%No%'");		
			while(rs.next())
			{
				
				P=rs.getString("dept");
				A=rs.getString("sid");
				st[i]=new JLabel(A);
				Ap[i]=new JButton("Approve");
				list[i]=A;
				yrr[i]=rs.getString("yr");
				smm[i]=rs.getString("sm");
				dp[i++]=new JLabel(P);
				
			}
		}
		catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		for(o=0;o<i;o++)
		{
			st[o].setBounds(0, y, 200, 20);
			dp[o].setBounds(220, y, 200, 20);
			Ap[o].setBounds(450, y, 100, 20);
			JP.add(st[o]);
			JP.add(dp[o]);
			JP.add(Ap[o]);
			final int j=o;
			Ap[o].addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					
					try {
						Connection SqlCon=DriverManager.getConnection(URL,username,password);
						Statement SqlState=SqlCon.createStatement();
						SqlState.executeUpdate("update  coursereg set registrar='Yes' where sid like'%"+list[j]+"%' and yr like '%"+yrr[j]+"%' and sm like '%"+smm[j]+"%' ");	
						SqlState.executeUpdate("update  coursereg set status='Yes' where sid like'%"+list[j]+"%' and yr like '%"+yrr[j]+"%' and sm like '%"+smm[j]+"%'");	

					}
					catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					chairman2 D=new chairman2(A);
							
							JF.dispose();
							D=null;

				}
			});
			y+=30;
		}
		JButton Back=new JButton("Back");
		Back.setBounds(460,500,100,30);
		Back.setBackground(Color.cyan);
		Back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		JP.add(Back);
		
		Back.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				
				
				
				Admins D=new Admins();
						
						JF.dispose();
						D=null;

			}
		});
		
		JF.setResizable(false);
		JF.setVisible(true);
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
