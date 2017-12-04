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
public class Payment2 {
	public static final JFrame JF=new JFrame("Admin Form");
	public static final JPanel JP=new JPanel(null);
	public static String A="",B="",P="",X="",Y="",Z="";
	public static int tt=0;
	public static final String URL="jdbc:mysql://localhost:3306/rms";
	public static final String username="root";
	public static final String password="";
	public static final String[] list={"CSTE","PHAM","ACCE","FIMS"};
	Payment2(String id,int i,int j,String De,String type,double tc)
{
		clear();
		A=id;
		tt=(int) (tc*50);
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
	JLabel LU=new JLabel("Transaction ID:");
	LU.setBounds(350, 240, 100, 20);
	JP.add(LU);
	JLabel ST=new JLabel("Bkash "+tt+" Taka to 01878045949");
	ST.setBounds(50, 240, 200, 20);
	JP.add(ST);
	final JTextField LUT=new JTextField("");
	LUT.setBounds(450, 240, 200, 20);
	JP.add(LUT);
	final JButton Log=new JButton("Proceed");
	Log.setBounds(550,300,100,20);
	Log.setBackground(Color.cyan);
	Log.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	JP.add(Log);
	JButton Back=new JButton("Back");
	Back.setBounds(550,330,100,20);
	Back.setBackground(Color.cyan);
	Back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	JP.add(Back);
	final int y=i;final int s=j;
	X=De;Y=type;
	Log.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent e)
		{
			
			Z=LUT.getText();
			if(Z.length()==0)
			{
				
					JOptionPane.showMessageDialog(new JFrame(), "Cant Be Empty", "Dialog",
					        JOptionPane.ERROR_MESSAGE);
				
			}
			else{
				try {
					Connection SqlCon=DriverManager.getConnection(URL,username,password);
					Statement SqlState=SqlCon.createStatement();
					PreparedStatement ps=SqlCon.prepareStatement("insert into payments(sid,yr,sm,dept,type,status,token,fee) values(?,?,?,?,?,?,?,?)");
					ps.setString(1, A);
					ps.setString(2, y+"");
					ps.setString(3, s+"");
					ps.setString(4, X);
					ps.setString(5, Y);
					ps.setString(6, "No");
					ps.setString(7, Z);
					ps.setString(8, tt+"");
					ps.execute();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			Payment3 D=new Payment3(A,"No");
					
					JF.dispose();
					D=null;
			}
				
					
			
					
				
			
//				Log.removeActionListener(this);

		}
	});
	Back.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent e)
		{
			
			
			
			Payment1 D=new Payment1(A);
					
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
