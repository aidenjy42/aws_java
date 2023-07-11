package ch26_socket.simpleGUI.client;

import java.awt.EventQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Objects;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ch26_socket.simpleGUI.client.dto.RequestBodyDto;
import ch26_socket.simpleGUI.client.dto.SendMessage;
import lombok.Getter;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@Getter
public class SimpleGUIClient extends JFrame {
	
	//싱글톤
	private static SimpleGUIClient instance;
	public static SimpleGUIClient getInstance() {
		if(instance == null) {
			instance = new SimpleGUIClient(); 
		}
		return instance;
	}
	//전역변수
	private String username; //채팅하는 사람 이름
	private Socket socket;

	private JTextArea textArea; 
	private JPanel contentPane;
	private JTextField textField;
	
	private JScrollPane userListScrollPane;
	private DefaultListModel<String> userListModel; //얘를 Jlist 안에
	private JList userList; 

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//여기서 클라이언트가 생성됨!!!- 그 이후로 어디든지 참조 가능
//					SimpleGUIClient frame = SimpleGUIClient();
					SimpleGUIClient frame = SimpleGUIClient.getInstance(); // 여기서 클라이언트가 생성됨!!!
					frame.setVisible(true);
					//서버측에서 데이터 입력받는 스레드
					ClientReceiver clientReceiver = new ClientReceiver();
					clientReceiver.start(); //스레드 시작
					//
					//clientReceiver: 외부에서 전달된 데이터를 즉각 입력받기 위해 스레드로 묶어 따로 작동
					
					//RequestBodyDto client 거
					RequestBodyDto<String> requestBodyDto = new RequestBodyDto<String>("join", frame.username);
					ClientSender.getInstance().send(requestBodyDto);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	//싱글톤: 생성자 private
	private SimpleGUIClient() {

		username = JOptionPane.showInputDialog(contentPane,"아이디를 입력하세요");

		if(Objects.isNull(username)) { //확인 눌러도 걍 종료
			System.exit(0);
		}
		if(username.isBlank()) {
			System.exit(0);
		}
		try {
			socket = new Socket("127.0.0.1", 8000); //소켓이 정상적으로 연결될 때!
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 10, 280, 205);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					SendMessage sendMessage = SendMessage.builder()
							.fromUsername(username)
							.messageBody(textField.getText())
							.build();
					RequestBodyDto<SendMessage> requestBodyDto = 
							new RequestBodyDto<>("sendMessage", sendMessage); //json
					//printwriter하는 기능을 메소드로 빼버림
					ClientSender.getInstance().send(requestBodyDto); 
					textField.setText(""); //엔터 치면 입력창 비우기
				}
			}
		});
		
		textField.setBounds(12, 225, 410, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		userListScrollPane = new JScrollPane();
		userListScrollPane.setBounds(300, 10, 122, 205);
		contentPane.add(userListScrollPane);
		
		userListModel = new DefaultListModel<>(); //<String>
		userList = new JList(userListModel); // Jlist<userListModel>. JList를 쓰려면 모델이 필요함
		userListScrollPane.setViewportView(userList);
		
	}
}
