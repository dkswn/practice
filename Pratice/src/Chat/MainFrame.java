package Chat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import Chat.ChatClientApp;

public class MainFrame extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JFrame f;
	private JButton btn5;
	
	public static String userId;

	public MainFrame() {
	}
	
	public void userMainFrame(String id) {
		id = "wnsvy";
		this.userId = id;
		f = new JFrame("Main From");
		f.setSize(490, 200);
		f.setLayout(null);
		f.setResizable(false);

		btn5 = new JButton("메신저");
		btn5.setBounds(355, 30 , 100, 50);
		

		f.add(btn5);
		
		f.setVisible(true);
		f.setLocationRelativeTo(null);
		btn5.addActionListener(this);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String [] args) {
		MainFrame mf = new MainFrame();
		mf.userMainFrame("guest");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btn5) {
			new ChatClientApp();
		}
	}
}
