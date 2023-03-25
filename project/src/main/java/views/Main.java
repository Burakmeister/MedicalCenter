package views;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main extends JFrame{
	public Main() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		setUndecorated(true);
		this.getContentPane().add(new LoginPanel());
		setVisible(true);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
	        @Override
	        public void run() {
	        	Main mf = new Main();
	        }
	    });
	}
}

