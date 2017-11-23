import javax.swing.*;

import java.util.*;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
public class LogIn {

	/**
	 * @param args
	 */
	

		// TODO Auto-generated method stub
		public static String A="",B="",P="",Q="";
		public static final String URL="jdbc:mysql://localhost:3306/ors";
		public static final String username="root";
		public static final String password="";
		LogIn(){
			
		}
		LogIn(final JFrame JF,int a,int b,JPanel JP){
		JF.setSize(a, b);
		JF.setLocation(200, 100);
		JF.setIconImage(Toolkit.getDefaultToolkit().getImage(new LogIn().getClass().getResource("pic/ic.png")));
		JF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JP.setBackground(Color.white);
		JF.getContentPane().add(JP);
		JLabel Left=new JLabel("");
		Left.setBounds(0, 0, 300, 600);
		ImageIcon ic1=new ImageIcon(new LogIn().getClass().getResource("pic/PIC1.jpg"));
		Left.setIcon(ic1);
		JP.add(Left);
		JLabel txt=new JLabel("LogIn");
		txt.setBounds(100, 230, 100, 30);
		JP.add(txt);
		final JLabel jb=new JLabel("Username");
		jb.setBounds(380, 210, 100, 20);
		JP.add(jb);
		final JLabel jb1=new JLabel("Password");
		jb1.setBounds(380, 240, 100, 20);
		JP.add(jb1);
		final JTextField JT=new JTextField();
		JT.setBounds(480, 210, 200, 20);
		JT.setText("");
		JP.add(JT);
		final JPasswordField JT1=new JPasswordField();
		JT1.setBounds(480, 240, 200, 20);
		JT1.setText("");
		JP.add(JT1);
		final JButton Log=new JButton("Login");
		Log.setBounds(580, 270, 100, 20);
		Log.setBackground(Color.cyan);
		JP.add(Log);
		Log.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				A="";B="";P="";Q="";
				B=JT.getText();
				A=JT1.getText();
				if(B.length()==0 || A.length()==0)
				{
					
					JOptionPane.showMessageDialog(new JFrame(), "Cant Be Empty", "Dialog",
					        JOptionPane.ERROR_MESSAGE);
					JT.setText("");
					 JT1.setText("");
				}
				else {
					try {
						Connection SqlCon=DriverManager.getConnection(URL,username,password);
						Statement SqlState=SqlCon.createStatement();
						ResultSet rs=SqlState.executeQuery("Select * from user where username like'%"+B+"%' and pass like '%"+A+"%'");		
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
						 JT.setText("");
						 JT1.setText("");
						 
					}
					else
						
					{
						JOptionPane.showMessageDialog(new JFrame(), "Success", "Dialog",
						        JOptionPane.PLAIN_MESSAGE);
						if(B.equals("admin")){
						admin a=new admin(P,Q,B);
						A="";
						B="";
						JF.dispose();
						a=null;}
						else if((B.charAt(0)=='A' && B.charAt(1)=='S') || (B.charAt(0)=='B' && B.charAt(1)=='K'))
						{
							student a=new student(P,Q,B);
							A="";
							B="";
							JF.dispose();
							a=null;
						}
						else
						{
							
						}
						
					}
				}
//					Log.removeActionListener(this);

			}
		});
		JF.setResizable(false);
		JF.setVisible(true);
	
}

}

