import javax.swing.JFrame;
import javax.swing.JPanel;


public class Main {

	/**
	 * @param args
	 */
	
	public static final JFrame JF=new JFrame("Online Reg Syestem");
	public static final JPanel JP=new JPanel(null);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LogIn T=new LogIn(JF, 900,600, JP);
	}

}
