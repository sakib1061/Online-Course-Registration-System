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
public class ExamReg1 {
	public static final JFrame JF=new JFrame("Registration Management System");
	public static final JPanel JP=new JPanel(null);
	public static final String URL="jdbc:mysql://localhost:3306/rms";
	public static final String username="root";
	public static final String password="";
	public static String A="",B="",P="",U="",D="";
	public static final String[] Yr={"1","2","3","4"};
	public static final String[] Sm={"1","2"};

	ExamReg1(String id)
	{
		clear();
		U=id;
		try {
			Connection SqlCon=DriverManager.getConnection(URL,username,password);
			Statement SqlState=SqlCon.createStatement();
			ResultSet rs=SqlState.executeQuery("Select * from student where id like'%"+A+"%' ");		
			while(rs.next())
			{
				P=rs.getString("dept");
			}
			D=P;
		}
		catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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
		JLabel SS=new JLabel("Select Year and Semister");
		SS.setBounds(430, 220, 200, 20);
		SS.setFont(new Font("Nyala", Font.BOLD,18));
		JP.add(SS);
		JLabel Year=new JLabel("Year");
		Year.setBounds(350, 260, 100, 20);
		JP.add(Year);
		JLabel Semister=new JLabel("Semister");
		Semister.setBounds(350, 290, 100, 20);
		JP.add(Semister);
		final JComboBox Yr1=new JComboBox(Yr);
		Yr1.setBounds(460, 260, 200, 20);
		JP.add(Yr1);
		final JComboBox Sm1=new JComboBox(Sm);
		Sm1.setBounds(460, 290, 200, 20);
		JP.add(Sm1);
		JButton Proceed=new JButton("Proceed");
		Proceed.setBounds(560,320,100,30);
		Proceed.setBackground(Color.cyan);
		Proceed.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		JP.add(Proceed);
		JButton Back=new JButton("Back");
		Back.setBounds(460,320,100,30);
		Back.setBackground(Color.cyan);
		Back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		JP.add(Back);
		Back.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				
				StudentFunction D=new StudentFunction(U);
				
				JF.dispose();
				D=null;
			}
		});
		Proceed.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				
				
				
				P="";String Q="", X="",Y="";
				int i=Yr1.getSelectedIndex()+1;
				int j=Sm1.getSelectedIndex()+1;
				
				try {
					Connection SqlCon=DriverManager.getConnection(URL,username,password);
					Statement SqlState=SqlCon.createStatement();
					ResultSet rs=SqlState.executeQuery("Select * from examreg where sid like'%"+U+"%' and yr like'%"+i+"%' and sm like'%"+j+"%'" );		
					while(rs.next())
					{
						P=rs.getString("sid");
						Q=rs.getString("status");
					}
					rs=rs=SqlState.executeQuery("Select * from coursereg where sid like'%"+U+"%' and yr like'%"+i+"%' and sm like'%"+j+"%'" );	
					while(rs.next())
					{
						X=rs.getString("sid");
						Y=rs.getString("status");
					}
				}
				catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println(Y);
				if(P.length()>0)
				{
					if(X.length()>0 && Y.equals("Yes")){
					ExamReg2 D=new ExamReg2(U,Q);
					
					JF.dispose();
					D=null;
					}
					else
					{
						JOptionPane.showMessageDialog(new JFrame(), "Complete Your Course Registration On these Semister", "Dialog",
						        JOptionPane.ERROR_MESSAGE);
					}
					
				}
				else {
					if(X.length()>0 && Y.equals("Yes")){
					try {
						Connection SqlCon=DriverManager.getConnection(URL,username,password);
						Statement SqlState=SqlCon.createStatement();
						PreparedStatement ps=SqlCon.prepareStatement("insert into examreg(sid,yr,sm,dept,chairman,provost,examcontroller,status) values(?,?,?,?,?,?,?,?)");
						ps.setString(1, U);
						ps.setString(2, i+"");
						ps.setString(3, j+"");
						ps.setString(4, D);
						ps.setString(5, "No");
						ps.setString(6, "No");
						ps.setString(7, "No");
						ps.setString(8, "No");
						ps.execute();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				ExamReg2 D=new ExamReg2(U,"No");
						
						JF.dispose();
						D=null;
				}
					else
					{
						JOptionPane.showMessageDialog(new JFrame(), "Complete Your Course Registration On these Semister", "Dialog",
						        JOptionPane.ERROR_MESSAGE);
					}
				}
				
				

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
