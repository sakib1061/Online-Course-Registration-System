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
public class StudentFunction {
	public static final JFrame JF=new JFrame("Studnet Form");
	public static final JPanel JP=new JPanel(null);
	public static String A="",B="",P="";
	public static final String[] list={"CSTE","PHAM","ACCE","FIMS"};
	StudentFunction(String id)
{
		clear();
		A=id;
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
	ImageIcon ic=new ImageIcon(this.getClass().getResource("icon/L1.jpg"));
	L1.setIcon(ic);
	JP.add(L1);
	JF.setResizable(false);
	JF.setVisible(true);
	JLabel UN=new JLabel(A);
	UN.setBounds(50,220,100,20);
	JP.add(UN);
	JButton Logout=new JButton("Log out");
	Logout.setBounds(50,250,100,20);
	Logout.setBackground(Color.cyan);
	Logout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	JP.add(Logout);
	JButton S1=new JButton("Course Registration");
	S1.setBounds(380, 220, 400, 80);
	ImageIcon ic1=new ImageIcon(this.getClass().getResource("icon/S1.jpg"));
	S1.setBorderPainted(false);
	S1.setContentAreaFilled(false); 
	S1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	S1.setIcon(ic1);
	JP.add(S1);
	JButton S2=new JButton("Course Registration");
	S2.setBounds(380, 300, 400, 80);
	ImageIcon ic2=new ImageIcon(this.getClass().getResource("icon/S2.jpg"));
	S2.setBorderPainted(false);
	S2.setContentAreaFilled(false); 
	S2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	S2.setIcon(ic2);
	JP.add(S2);
	JButton S3=new JButton("Course Registration");
	S3.setBounds(380, 380, 400, 80);
	ImageIcon ic3=new ImageIcon(this.getClass().getResource("icon/S3.jpg"));
	S3.setBorderPainted(false);
	S3.setContentAreaFilled(false); 
	S3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	S3.setIcon(ic3);
	JP.add(S3);
	JLabel S4=new JLabel("|");
	S4.setBounds(300, 220, 5, 240);
	ImageIcon ic4=new ImageIcon(this.getClass().getResource("icon/S4.jpg"));
	S4.setIcon(ic4);
	JP.add(S4);
	S1.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent e)
		{
			
			
			
			CourseReg1 D=new CourseReg1(A);
					
					JF.dispose();
					D=null;
				
				
					
			
					
				
			
//				Log.removeActionListener(this);

		}
	});
	S2.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent e)
		{
			
			
			
			ExamReg1 D=new ExamReg1(A);
					
					JF.dispose();
					D=null;
				
				
					
			
					
				
			
//				Log.removeActionListener(this);

		}
	});
	S3.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent e)
		{
			
			
			
			Payment1 D=new Payment1(A);
					
					JF.dispose();
					D=null;
				
				
					
			
					
				
			
//				Log.removeActionListener(this);

		}
	});
	Logout.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent e)
		{
			
			
			
			Student D=new Student();
					
					JF.dispose();
					D=null;
				
				
					
			
					
				
			
//				Log.removeActionListener(this);

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
