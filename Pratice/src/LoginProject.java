import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginProject {

	JPanel cardPanel;
	LoginProject lp;
	CardLayout card;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LoginProject lp = new LoginProject();
		lp.setFrame(lp);
	}

	public void setFrame(LoginProject lpro) {

		JFrame jf = new JFrame();
		LoginPanel lp = new LoginPanel(lpro);
		signupPanel sp = new signupPanel(lpro);

		card = new CardLayout();

		cardPanel = new JPanel(card);
		cardPanel.add(lp.mainPanel, "Login");
		cardPanel.add(sp.mainPanel, "Register");
		
		jf.add(cardPanel);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setSize(500, 700);
		jf.setVisible(true);
	}

	public Connection getConnection() throws SQLException {
		Connection conn = null;
		return conn;
	}

}

class LoginPanel extends JPanel implements ActionListener {

	JPanel mainPanel;
	JTextField idTextField;
	JPasswordField passTextField;

	String userMode = "일반";
	LoginProject lp;
	Font font = new Font("회원가입", Font.BOLD, 40);
	String admin = "admin";

	public LoginPanel(LoginProject lp) {
		this.lp = lp;
		
		mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(5, 1));

		JPanel centerPanel = new JPanel();
		JLabel loginLabel = new JLabel("로그인 화면");
		loginLabel.setFont(font);
		centerPanel.add(loginLabel);

		JPanel userPanel = new JPanel();

		JPanel gridBagidInfo = new JPanel(new GridBagLayout());
		gridBagidInfo.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));
		GridBagConstraints c = new GridBagConstraints();

		JLabel idLabel = new JLabel(" 아이디 : ");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		gridBagidInfo.add(idLabel, c);

		idTextField = new JTextField(15);
		c.insets = new Insets(0, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 0;
		gridBagidInfo.add(idTextField, c);

		JLabel passLabel = new JLabel(" 비밀번호 : ");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		c.insets = new Insets(20, 0, 0, 0);
		gridBagidInfo.add(passLabel, c);

		passTextField = new JPasswordField(15);
		c.insets = new Insets(20, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 1;
		gridBagidInfo.add(passTextField, c);

		JPanel loginPanel = new JPanel();
		JButton loginButton = new JButton("로그인");
		loginPanel.add(loginButton);

		JPanel signupPanel = new JPanel();
		JButton signupButton = new JButton("회원가입");
		loginPanel.add(signupButton);

		mainPanel.add(centerPanel);
		mainPanel.add(userPanel);
		mainPanel.add(gridBagidInfo);
		mainPanel.add(loginPanel);
		mainPanel.add(signupPanel);


		loginButton.addActionListener(this);

		signupButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				lp.card.next(lp.cardPanel);
			}
		});

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		switch (e.getActionCommand()) {

		case "일반":
			userMode = "일반";
			break;

		case "관리자":
			userMode = "관리자";
			break;

		case "로그인":

			String id = idTextField.getText();
			String pass = passTextField.getText();

			try {

				String sql_query = String.format("SELECT password FROM user_info WHERE id = '%s' AND password ='%s'",
						id, pass);

				Connection conn = lp.getConnection();
				Statement stmt = conn.createStatement();

				ResultSet rset = stmt.executeQuery(sql_query);
				rset.next();

				if (pass.equals(rset.getString(1))) {
					JOptionPane.showMessageDialog(this, "Login Success", "로그인 성공", 1);
				
				} else
					JOptionPane.showMessageDialog(this, "Login Failed", "로그인 실패", 1);

			} catch (SQLException ex) {
				JOptionPane.showMessageDialog(this, "Login Failed", "로그인 실패", 1);
				System.out.println("SQLException" + ex);
			}

			break;

		}
	}

} // class LoginPanel

class signupPanel extends JPanel {

	JTextField idTf;
	JPasswordField passTf;
	JTextField nameTf;
	JTextField emailTf;
	JPanel mainPanel;
	JPanel subPanel;
	JButton registerButton;
	Font font = new Font("회원가입", Font.BOLD, 40);

	String email = "";
	String id = "", pass = "", name = "";
	LoginProject lp;

	public signupPanel(LoginProject lp) {

		this.lp = lp;
		subPanel = new JPanel();
		subPanel.setLayout(new GridBagLayout());
		subPanel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

		JLabel idLabel = new JLabel("아이디 : ");
		JLabel passLabel = new JLabel("비밀번호 : ");
		JLabel nameLabel = new JLabel("이름 : ");
		JLabel emailLabel = new JLabel("이메일 : ");

		idTf = new JTextField(15);
		passTf = new JPasswordField(15);
		nameTf = new JTextField(15);
		emailTf = new JTextField(15);

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(15, 5, 0, 0);

		c.gridx = 0;
		c.gridy = 0;
		subPanel.add(idLabel, c);

		c.gridx = 1;
		c.gridy = 0;
		subPanel.add(idTf, c); // 아이디

		c.gridx = 0;
		c.gridy = 1;
		subPanel.add(passLabel, c);

		c.gridx = 1;
		c.gridy = 1;
		subPanel.add(passTf, c); // pass
		
		c.gridx = 2;
		c.gridy = 1; 
		subPanel.add(new JLabel("특수문자 + 8자"),c); //보안설정

		c.gridx = 0;
		c.gridy = 3;
		subPanel.add(nameLabel, c);

		c.gridx = 1;
		c.gridy = 3;
		subPanel.add(nameTf, c); // 이름

		c.gridx = 0;
		c.gridy = 6;
		subPanel.add(emailLabel, c); //이메일
		
		c.gridx = 1;
		c.gridy = 6;
		subPanel.add(emailTf, c);

		mainPanel = new JPanel();
		mainPanel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		JLabel signupLabel = new JLabel("회원가입 화면 ");
		signupLabel.setFont(font);
		signupLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

		registerButton = new JButton("회원가입");
		registerButton.setAlignmentX(Component.CENTER_ALIGNMENT);

		mainPanel.add(signupLabel);
		mainPanel.add(subPanel);
		mainPanel.add(registerButton);


	
		registerButton.addActionListener(new ActionListener() {      //회원가입버튼

			@SuppressWarnings("unlikely-arg-type")
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Pattern passPattern1 = Pattern.compile("^(?=.*[a-zA-Z])(?=.*\\d)(?=.*\\W).{8,20}$"); //8자 영문+특문+숫자
				Pattern emailPattern1 = Pattern.compile("^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$");  //8자 영문+특문+숫자
				Matcher passMatcher = passPattern1.matcher(pass);
				Matcher emailMatcher = emailPattern1.matcher(email);
				if (nameTf.getText().isEmpty() == false && 
						idTf.getText().isEmpty() == false &&
						passTf.getText().isEmpty() == false && 
						emailTf.getText().isEmpty() == false) {
					id = idTf.getText();
					pass = new String(passTf.getPassword());
					name = nameTf.getText();
					email = emailTf.getText();
				} else if (nameTf.getText().isEmpty() == true && 
						idTf.getText().isEmpty() == true &&
						passTf.getText().isEmpty() == true && 
						emailTf.getText().isEmpty() == true) {
					JOptionPane.showMessageDialog(null, "회원정보를 모두 입력해주세요.");
				}
				if (!passMatcher.find()) {
					JOptionPane.showMessageDialog(null, "비밀번호는 영문+특수문자+숫자 8자로 구성되어야 합니다", "비밀번호 오류", 1);
				} 
				if (!emailMatcher.find()) {
					JOptionPane.showMessageDialog(null, "회원 가입 완료!", "회원가입", 1);
				} else {
					JOptionPane.showMessageDialog(null, "이메일 양식에 맞지 않습니다");
					
				}
					
				}
			
		});

	}
}