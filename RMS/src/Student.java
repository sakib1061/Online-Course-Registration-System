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
public class Student {
	public static final JFrame JF=new JFrame("Student Form");
	public static final JPanel JP=new JPanel(null);
	public static String A="",B="",P="",Q="",F="",L="",D="";
	public static final String URL="jdbc:mysql://localhost:3306/rms";
	public static final String username="root";
	public static final String password="";
	public static final String[] list={"CSTE","PHMS","ACCE","FIMS"};
Student()
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
	JF.setResizable(false);
	JF.setVisible(true);
	JLabel LU=new JLabel("USER NAME:");
	LU.setBounds(50, 240, 100, 20);
	JP.add(LU);
	final JTextField LUT=new JTextField("");
	LUT.setBounds(150, 240, 200, 20);
	JP.add(LUT);
	JLabel LP=new JLabel("PASSWORD:");
	LP.setBounds(50, 270, 100, 20);
	JP.add(LP);
	final JPasswordField LPT=new JPasswordField("");
	LPT.setBounds(150, 270, 200, 20);
	JP.add(LPT);
	JButton Log=new JButton("Sign In");
	Log.setBounds(270,300,80,20);
	Log.setBackground(Color.cyan);
	Log.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	JP.add(Log);
	JLabel SU=new JLabel("USER NAME:");
	SU.setBounds(550, 240, 100, 20);
	JP.add(SU);
	final JTextField SUT=new JTextField("");
	SUT.setBounds(650, 240, 200, 20);
	JP.add(SUT);
	JLabel SF=new JLabel("FIRST NAME:");
	SF.setBounds(550, 270, 100, 20);
	JP.add(SF);
	final JTextField SFT=new JTextField("");
	SFT.setBounds(650, 270, 200, 20);
	JP.add(SFT);
	JLabel SL=new JLabel("LAST NAME:");
	SL.setBounds(550, 300, 100, 20);
	JP.add(SL);
	final JTextField SLT=new JTextField("");
	SLT.setBounds(650, 300, 200, 20);
	JP.add(SLT);
	JLabel SD=new JLabel("DEPARTMENT:");
	SD.setBounds(550, 330, 100, 20);
	JP.add(SD);
	final JComboBox SDL=new JComboBox(list);
	SDL.setBounds(650, 330, 200, 20);
	JP.add(SDL);
	JLabel SP=new JLabel("PASSWORD:");
	SP.setBounds(550, 360, 100, 20);
	JP.add(SP);
	final JPasswordField SPT=new JPasswordField("");
	SPT.setBounds(650, 360, 200, 20);
	JP.add(SPT);
	JButton Sign=new JButton("Sign Up");
	Sign.setBounds(770,390,80,20);
	Sign.setBackground(Color.cyan);
	Sign.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	JP.add(Sign);
	JButton Back=new JButton("Back");
	Back.setBounds(400,500,80,20);
	Back.setBackground(Color.cyan);
	Back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	JP.add(Back);
	Log.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent e)
		{
			
			
			A="";B="";P="";Q="";
			B=LPT.getText();
			A=LUT.getText();
			if(B.length()==0 || A.length()==0)
			{
				
				JOptionPane.showMessageDialog(new JFrame(), "Cant Be Empty", "Dialog",
				        JOptionPane.ERROR_MESSAGE);
				LUT.setText("");
				 LPT.setText("");
			}
			else {
				try {
					Connection SqlCon=DriverManager.getConnection(URL,username,password);
					Statement SqlState=SqlCon.createStatement();
					ResultSet rs=SqlState.executeQuery("Select * from student where id like'%"+A+"%' and pass like '%"+B+"%'");		
					while(rs.next())
					{
						P=rs.getString("firstname");
						Q=rs.getString("lastname");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(P.length()==0 )
				{
					 JOptionPane.showMessageDialog(new JFrame(), "Incorrect Username and Password", "Dialog",
						        JOptionPane.ERROR_MESSAGE);
					 LUT.setText("");
					 LPT.setText("");
					 
				}
				else
					
				{
					StudentFunction D=new StudentFunction(A);
					
					JF.dispose();
					D=null;
				
				}
			}
			
				
					
			
					
				
			
//				Log.removeActionListener(this);

		}
	});
	Sign.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent e)
		{
			
			
			A="";B="";P="";Q="";F="";L="";D="";
			B=SPT.getText();
			A=SUT.getText();
			F=SFT.getText();
			L=SLT.getText();
			D=list[SDL.getSelectedIndex()];
			if(B.length()==0 || A.length()==0 || F.length()==0 || L.length()==0)
			{
				
				JOptionPane.showMessageDialog(new JFrame(), "Cant Be Empty", "Dialog",
				        JOptionPane.ERROR_MESSAGE);
				LUT.setText("");
				 LPT.setText("");
			}
			else {
				try {
					Connection SqlCon=DriverManager.getConnection(URL,username,password);
					Statement SqlState=SqlCon.createStatement();
					ResultSet rs=SqlState.executeQuery("Select * from student where id like'%"+A+"%' ");		
					while(rs.next())
					{
						P=rs.getString("firstname");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(P.length()>0 )
				{
					 JOptionPane.showMessageDialog(new JFrame(), "username already registered", "Dialog",
						        JOptionPane.ERROR_MESSAGE);
					 LUT.setText("");
					 LPT.setText("");
					 
				}
				else
					
				{
					try {
						Connection SqlCon=DriverManager.getConnection(URL,username,password);
						Statement SqlState=SqlCon.createStatement();
						PreparedStatement ps=SqlCon.prepareStatement("insert into student(id,firstname,lastname,dept,pass) values(?,?,?,?,?)");
						ps.setString(1, A);
						ps.setString(2, F);
						ps.setString(3, L);
						ps.setString(4, D);
						ps.setString(5, B);
						ps.execute();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					StudentFunction D=new StudentFunction(A);
					
					JF.dispose();
					D=null;
				
				}
			}
			
				
					
			
					
				
			
//				Log.removeActionListener(this);

		}
	});
	Back.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent e)
		{
			
			
			
			Login D=new Login();
					
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
