
import javafx.geometry.Insets;

import javax.swing.*;

import java.util.*;
import java.awt.BorderLayout;
import java.awt.Checkbox;
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
public class CourseReg2 {
	public static final JFrame JF=new JFrame("Registration Management System");
	public static final JPanel JP=new JPanel(null);
	public static final String URL="jdbc:mysql://localhost:3306/rms";
	public static final String username="root";
	public static final String password="";
	public static String A="",B="",P="",Y="",S="",C="",D;
	String[] list=new String[12];
	String[] credit=new String[12];
	String[] full=new String[12];
	CourseReg2(String id,int yr, int sm)
	{
		clear();
		A=id;
		JF.setSize(900,600);
		JF.setLocation(100, 100);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		JF.setLocation(dim.width/2-JF.getSize().width/2, dim.height/2-JF.getSize().height/2);
		JF.setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("icon/MIC.png")));
		JF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Y=yr+"";
		S=sm+"";
		int o=0;
		try {
			Connection SqlCon=DriverManager.getConnection(URL,username,password);
			Statement SqlState=SqlCon.createStatement();
			ResultSet rs=SqlState.executeQuery("Select * from student where id like'%"+A+"%' ");		
			while(rs.next())
			{
				P=rs.getString("dept");
			}
			D=P;
			rs=SqlState.executeQuery("Select * from course where dept like'%"+P+"%' and yr like'%"+Y+"%'and sem like'%"+S+"%' ");
			 o=0;
			 
			while(rs.next())
			{
				B=rs.getString("id");
				P=rs.getString("fullform");
				C=rs.getString("credit");
				list[o]=B;
				full[o]=P;
				credit[o++]=C;
				System.out.println(C);
			}
		}
		catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		JP.setBackground(Color.white);
		JF.getContentPane().add(JP);
		JLabel L1=new JLabel("Start");
		L1.setBounds(0, 0, 900, 200);
		ImageIcon ic1=new ImageIcon(this.getClass().getResource("icon/L1.jpg"));
		L1.setIcon(ic1);
		JP.add(L1);
		final JCheckBox[] checkBoxes = new JCheckBox[12];
		JLabel C1=new JLabel("COURSE");
		C1.setBounds(60, 220, 70, 20);
		JP.add(C1);
		JLabel C2=new JLabel("COURSE NAME");
		C2.setBounds(200, 220, 230, 20);
		JP.add(C2);
		JLabel C3=new JLabel("CREDIT");
		C3.setBounds(380, 220, 70, 20);
		JP.add(C3);
		int y=250;
		for(int i=0;i<6;i++){
			checkBoxes[i]=new JCheckBox(list[i]);
			checkBoxes[i].setBounds(10,y,100,20);
			checkBoxes[i].setBackground(Color.white);
			checkBoxes[i].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			JP.add(checkBoxes[i]);
			y+=30;
		}
		JLabel C4=new JLabel("COURSE");
		C4.setBounds(510, 220, 70, 20);
		JP.add(C4);
		JLabel C5=new JLabel("COURSE NAME");
		C5.setBounds(650, 220, 230, 20);
		JP.add(C5);
		JLabel C6=new JLabel("CREDIT");
		C6.setBounds(830, 220, 70, 20);
		JP.add(C6);
		y=250;
		for(int i=6;i<12;i++){
			checkBoxes[i]=new JCheckBox(""+i);
			checkBoxes[i].setBounds(460,y,100,20);
			checkBoxes[i].setBackground(Color.white);
			checkBoxes[i].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			JP.add(checkBoxes[i]);
			y+=30;
		}
		for(int i=o;i<12;i++)
		{
			checkBoxes[i].setVisible(false);
		}
		if(o/6<=0)
		{
			C4.setVisible(false);C5.setVisible(false);C6.setVisible(false);
		}
		JButton JB=new JButton("Proceed");
		JB.setBounds(500,500,100,30);
		JB.setBackground(Color.cyan);
		JB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		JP.add(JB);
		JButton BC=new JButton("Back");
		BC.setBounds(400,500,100,30);
		BC.setBackground(Color.cyan);
		BC.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		JP.add(BC);
		final int x=o;
		final int yr1=yr;
		final int sm1=sm;
		JB.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				double tc=0.0;
				try {
					Connection SqlCon=DriverManager.getConnection(URL,username,password);
					Statement SqlState=SqlCon.createStatement();
					PreparedStatement ps=SqlCon.prepareStatement("insert into coursereg(sid,yr,sm,1st,2nd,3rd,4th,5th,6th,7th,8th,9th,10th,11th,12th,dept,chairman,provost,registrar,status,tcredit) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
					ps.setString(1, A);
					ps.setString(2, Y);
					ps.setString(3, S);
					
					for(int i=4;i<16;i++)
					{
						if(checkBoxes[i-4].isSelected()){
						ps.setString(i, list[i-4]);
						tc+=Double.parseDouble(credit[i-4]);
						}
						else
							ps.setString(i, "N/A");
					}
					ps.setString(16, D);
					ps.setString(17, "No");
					ps.setString(18, "No");
					ps.setString(19, "No");
					ps.setString(20, "No");
					ps.setString(21, tc+"");
					ps.execute();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				for(int i=0;i<12;i++)
				{
					checkBoxes[i].setSelected(false);
				}
				CourseReg3 D=new CourseReg3(A,yr1,sm1,"No");
				
				JF.dispose();
				D=null;

			}
		});
		BC.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				for(int i=0;i<12;i++)
				{
					checkBoxes[i].setSelected(false);
				}
				CourseReg1 D=new CourseReg1(A);
				
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
