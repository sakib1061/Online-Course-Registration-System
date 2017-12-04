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
public class Admins {
	public static final JFrame JF=new JFrame("Admin Form");
	public static final JPanel JP=new JPanel(null);
	public static String A="",B="",P="";
	public static final String[] list={"CSTE","PHAM","ACCE","FIMS"};
Admins()
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
	final JLabel LU=new JLabel("USER NAME:");
	LU.setBounds(350, 240, 100, 20);
	JP.add(LU);
	final JTextField LUT=new JTextField("");
	LUT.setBounds(450, 240, 200, 20);
	JP.add(LUT);
	final JLabel LP=new JLabel("PASSWORD:");
	LP.setBounds(350, 270, 100, 20);
	JP.add(LP);
	final JPasswordField LPT=new JPasswordField("");
	LPT.setBounds(450, 270, 200, 20);
	JP.add(LPT);
	JButton Log=new JButton("Sign In");
	Log.setBounds(570,300,80,20);
	Log.setBackground(Color.cyan);
	Log.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	JP.add(Log);
	JButton Back=new JButton("Back");
	Back.setBounds(570,330,80,20);
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
			if(X.equals("chairman") && Y.equals("cste")){
			chairman D=new chairman("CSTE");
					
					JF.dispose();
					D=null;
			}
			if(X.equals("chairman") && Y.equals("acce")){
				chairman D=new chairman("ACCE");
						
						JF.dispose();
						D=null;
				}
			if(X.equals("chairman") && Y.equals("phms")){
				chairman D=new chairman("PHMS");
						
						JF.dispose();
						D=null;
				}
			if(X.equals("chairman") && Y.equals("fims")){
				chairman D=new chairman("FIMS");
						
						JF.dispose();
						D=null;
				}
			else if(X.equals("provost") && Y.equals("1234")){
				provost D=new provost();
				
				JF.dispose();
				D=null;
		}
			else if(X.equals("registrar") && Y.equals("1234")){
				registrar D=new registrar();
				
				JF.dispose();
				D=null;
		}
			else if(X.equals("econtroller") && Y.equals("1234")){
				ExamController D=new ExamController();
				
				JF.dispose();
				D=null;
		}
			else if(X.equals("dentry") && Y.equals("1234")){
				dataentry D=new dataentry();
				
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
			
			Login D=new Login();
			JF.dispose();
			D=null;
			

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
