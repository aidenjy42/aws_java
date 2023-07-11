package ch25_GUI;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GUIMain1 extends JFrame { //JFrame을 상속

	private final String ADMIN_USERNAME = "admin";
	private final String ADMIN_PASSWORD = "1234"; 
	//cardLayout은 따로 선언해준 뒤 생성
	private CardLayout mainCardLayout;
	
	private JPanel mainCardPanel;
	private JPanel loginPanel;
	private JPanel homePanel;//로그인 성공 후 전환될 패널
	private JTextField usernameTextField;
	private JPasswordField passwordTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//아래 코드만 봄
					GUIMain1 frame = new GUIMain1();
					frame.setVisible(true);
					//
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUIMain1() { //생성자
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //x버튼을 클릭하면 종료.
		setBounds(100, 100, 450, 300); //x좌표, y 좌표, 가로, 세로
		mainCardPanel = new JPanel(); //mainCard를 생성해서 가장 밑에 둠
		
		mainCardLayout = new CardLayout(); //CardLayout() 객체 생성해서
		mainCardPanel.setLayout(mainCardLayout); //카드레이아웃으로 설정
		setContentPane(mainCardPanel);
		
		//로그인 패널
		loginPanel = new JPanel();
		loginPanel.setBackground(new Color(0, 128, 192));
		loginPanel.setBorder(new EmptyBorder(5, 5, 5, 5)); //테두리
		loginPanel.setLayout(null);
		mainCardPanel.add(loginPanel, "loginPanel"); //mainpanel에 login
		 
		/* username */
		usernameTextField = new JTextField();
		usernameTextField.setBounds(136, 58, 151, 29); //패널 기준 좌표 x, y 축
		loginPanel.add(usernameTextField);
		usernameTextField.setColumns(10);
		
		/* password */
		passwordTextField = new JPasswordField();
		passwordTextField.setBounds(136, 97, 151, 29);
		loginPanel.add(passwordTextField);

		JButton signinBtn = new JButton("Login");
		signinBtn.addMouseListener(new MouseAdapter() { //익명 클래스 
			//addMouseListener: mouse 이벤트를 감지하는 메소드.
			//매개변수로 MouseListener(인터페이스)를 가짐
			//Abstract MouseAdapter implements MouseListener
			
			@Override
			public void mouseClicked(MouseEvent e) {
//				System.out.println("로그인 버튼을 클릭하였습니다.");
//				System.out.println(usernameTextField.getText());
//				System.out.println(passwordTextField.getText());
				
				String username = usernameTextField.getText();
				String password = passwordTextField.getText();
				
				if(!username.equals(ADMIN_USERNAME) || !password.equals(ADMIN_PASSWORD)) { 
					JOptionPane.showMessageDialog(loginPanel, "사용자 정보가 일치하지 않습니다.", "로그인 실패", JOptionPane.ERROR_MESSAGE);
					//유효성 검사는 참보다는 false 조건을 검사하기
					//true조건으로 만들면 중첩 조건문으로 써야 함
//					System.out.println("사용자 정보가 일치하지 않습니다.");
					return; //메소드 종료
				}
				//조건이 아닌 경우가 default로
				
				JOptionPane.showMessageDialog(loginPanel, "환영합니다", "로그인 성공", JOptionPane.PLAIN_MESSAGE);
				
				mainCardLayout.show(mainCardPanel, "homePanel");

//				System.out.println("로그인 성공");
				
			}
			
		});
		signinBtn.setBackground(new Color(255, 255, 255));
		signinBtn.setFont(new Font("Book Antiqua", Font.PLAIN, 12));
		signinBtn.setBounds(136, 167, 151, 23);
		loginPanel.add(signinBtn);
		
		homePanel = new JPanel(); 
		homePanel.setLayout(null); //absolute layout
		mainCardPanel.add(homePanel, "homePanel"); //카드 패널에 loginPanel과 같은 위치에 homePanel을 추가
		//super.setContentPane(contentPane);
		
	}
}
