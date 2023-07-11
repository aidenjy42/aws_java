package ch25_GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Signin extends JFrame {
	
	private final String ADMIN_USERNAME = "admin";
	private final String ADMIN_PASSWORD = "1234"; 
	
	private JPanel mainCardPane;
	private CardLayout mainCardLayout;
	private JTextField usernameTextField;;
	private JPasswordField passwordTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Signin frame = new Signin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Signin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		/* <<<mainCardPane>>> */
		mainCardPane = new JPanel();
		mainCardLayout = new CardLayout(0,0);
		
		mainCardPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(mainCardPane);
		mainCardPane.setLayout(mainCardLayout);
		
		
		/* <<<subPanel1>>> */
		JPanel subPanel1 = new JPanel();
		mainCardPane.add(subPanel1, "subPanel1");
		subPanel1.setLayout(null);
		
		usernameTextField = new JTextField();
		usernameTextField.setBounds(111, 70, 193, 28);
		subPanel1.add(usernameTextField);
		usernameTextField.setColumns(10);
		
		passwordTextField = new JPasswordField();
		passwordTextField.setBounds(111, 108, 193, 28);
		subPanel1.add(passwordTextField);
		
		//button
		JButton signinBtn = new JButton("Login");
		signinBtn.setBounds(153, 162, 97, 23);
		subPanel1.add(signinBtn);
		
		signinBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String username = usernameTextField.getText();
				String password = passwordTextField.getText();
				
				if(!username.equals(ADMIN_USERNAME) || !password.equals(ADMIN_PASSWORD)) { 
					JOptionPane.showMessageDialog(mainCardPane, "aaa", "bbb", JOptionPane.ERROR_MESSAGE);
					//유효성 검사는 참보다는 false 조건을 검사하기
					//true조건으로 만들면 중첩 조건문으로 써야 함
					System.out.println("사용자 정보가 일치하지 않습니다.");
					return; //메소드 종료
				}
				//조건이 아닌 경우가 default로
				
				JOptionPane.showMessageDialog(mainCardPane, "환영합니다", "로그인 성공", JOptionPane.PLAIN_MESSAGE);
				
				mainCardLayout.show(mainCardPane, "subPanel2");
			}
		});
		
		
		/* <<< subPanel2 >>> */
		JPanel subPanel2 = new JPanel();
		mainCardPane.add(subPanel2, "subPanel2");
		subPanel2.setLayout(null);
		
		
	}

}
