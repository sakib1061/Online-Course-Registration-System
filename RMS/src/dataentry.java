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
public class dataentry {
	public static final JFrame JF=new JFrame("Admin Form");
	public static final JPanel JP=new JPanel(null);
	public static String A="",B="",P="";
	public static final String URL="jdbc:mysql://localhost:3306/rms";
	public static final String username="root";
	public static final String password="";
	public static final String[] list={"CSTE","PHAM","ACCE","FIMS"};
	dataentry()
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
	final JLabel LU=new JLabel("Amount");
	LU.setBounds(350, 240, 100, 20);
	JP.add(LU);
	final JTextField LUT=new JTextField("");
	LUT.setBounds(450, 240, 200, 20);
	JP.add(LUT);
	final JLabel LP=new JLabel("TXID");
	LP.setBounds(350, 270, 100, 20);
	JP.add(LP);
	final JTextField LPT=new JTextField("");
	LPT.setBounds(450, 270, 200, 20);
	JP.add(LPT);
	JButton Log=new JButton("Proceed");
	Log.setBounds(550,300,100,20);
	Log.setBackground(Color.cyan);
	Log.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	JP.add(Log);
	JButton Back=new JButton("Back");
	Back.setBounds(550,330,100,20);
	Back.setBackground(Color.cyan);
	Back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	JP.add(Back);
	Log.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent e)
		{
			
			
			String X="",Y="";
			X=LUT.getText();
			Y=LPT.getText();
			
			int taka=Integer.parseInt(X);
			int re=0;
			try {
				Connection SqlCon=DriverManager.getConnection(URL,username,password);
				Statement SqlState=SqlCon.createStatement();
				PreparedStatement ps=SqlCon.prepareStatement("insert into txids(id,fee) values(?,?)");
				ps.setString(1, Y);
				ps.setString(2, X+"");
				ps.execute();
				ResultSet rs=SqlState.executeQuery("Select * from payments where token like'%"+Y+"%' " );		
				while(rs.next())
				{
					re=Integer.parseInt(rs.getString("fee"));
					
				}
				if(taka>=re)
				{
					SqlState.executeUpdate("update  payments set  status='Yes' where token like'%"+Y+"%'");	

				}
				JOptionPane.showMessageDialog(new JFrame(), "Done", "Dialog",
				        JOptionPane.PLAIN_MESSAGE);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
					
				
			
//				Log.removeActionListener(this);

		}
	});
	Back.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent e)
		{
			
			
			Admins D=new Admins();
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
