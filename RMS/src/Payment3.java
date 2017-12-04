
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
public class Payment3 {
	public static final JFrame JF=new JFrame("Registration Management System");
	public static final JPanel JP=new JPanel(null);
	public static String A="",B="",P="";

	Payment3(String id,String St)
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
		ImageIcon ic1=new ImageIcon(this.getClass().getResource("icon/L1.jpg"));
		L1.setIcon(ic1);
		JP.add(L1);
		JLabel RG=new JLabel("Payment Status");
		RG.setBounds(300,300,200,20);
		JP.add(RG);
		JLabel ST=new JLabel("");
		ST.setBounds(500,300,100,20);
		JP.add(ST);
		if(St.equals("Yes"))
		{
			ST.setText("Approved");
			ST.setForeground(Color.green);
		}
		else 
		{
			ST.setText("Waiting");
			ST.setForeground(Color.red);
		}
		JButton Back=new JButton("Back");
		Back.setBounds(400,500,80,20);
		Back.setBackground(Color.cyan);
		Back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		JP.add(Back);
		Back.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				
				
				
				Payment1 D=new Payment1(A);
						
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
