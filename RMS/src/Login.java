import javafx.geometry.Insets;

import javax.swing.*;

import java.util.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.sql.*;
public class Login {
	public static final JFrame JF=new JFrame("Registration Management System");
	public static final JPanel JP=new JPanel(null);
	public static String A="",B="",P="";
	Login()
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
		JLabel L=new JLabel("SELECT ACCOUNT TYPE");
		L.setBounds(430, 220, 150, 40);
		JP.add(L);
		JButton L2=new JButton("Student");
		L2.setBounds(200, 300, 200, 200);
		L2.setBorderPainted(false);
        L2.setContentAreaFilled(false); 
        L2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ImageIcon ic2=new ImageIcon(this.getClass().getResource("icon/L2.jpg"));
		L2.setIcon(ic2);
		JP.add(L2);
		JLabel L3=new JLabel("|");
		L3.setBounds(400, 300, 200, 200);
		ImageIcon ic3=new ImageIcon(this.getClass().getResource("icon/L4.jpg"));
		L3.setIcon(ic3);
		JP.add(L3);
		JButton L4=new JButton("Admin");
		L4.setBounds(600, 300, 200, 200);
		L4.setBorderPainted(false);
		L4.setContentAreaFilled(false); 
		L4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ImageIcon ic4=new ImageIcon(this.getClass().getResource("icon/L3.jpg"));
		L4.setIcon(ic4);
		JP.add(L4);
		L2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				
				
				
				Student D=new Student();
						
						JF.dispose();
						D=null;
					
					
						
				
						
					
				
//					Log.removeActionListener(this);

			}
		});
		L4.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				
				
				
				Admins D=new Admins();
						
						JF.dispose();
						D=null;
					
					
						
				
						
					
				
//					Log.removeActionListener(this);

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
