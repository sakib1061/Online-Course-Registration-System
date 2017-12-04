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
public class chairman {
	public static final JFrame JF=new JFrame("Registration Management System");
	public static final JPanel JP=new JPanel(null);
	public static String A="",B="",P="";
	public static final String[] Yr={"1","2","3","4"};
	public static final String[] Sm={"1","2"};

	chairman(String S)
	{
		clear();
		A=S;
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
		
		JButton CR=new JButton("Course Registration Approve");
		CR.setBounds(460,320,200,30);
		CR.setBackground(Color.cyan);
		CR.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		JP.add(CR);
		JButton ER=new JButton("Exam Registration Approve");
		ER.setBounds(460,360,200,30);
		ER.setBackground(Color.cyan);
		ER.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		JP.add(ER);
		JButton Back=new JButton("Logout");
		Back.setBounds(460,400,100,30);
		Back.setBackground(Color.cyan);
		Back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		JP.add(Back);
		CR.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				
				
				
				chairman2 D=new chairman2(A);
						
						JF.dispose();
						D=null;

			}
		});
		ER.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				
				
				
				chairman3 D=new chairman3(A);
						
						JF.dispose();
						D=null;

			}
		});
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
