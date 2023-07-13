package ch26_socket.simpleGUI.client;

import java.awt.CardLayout;
import java.awt.EventQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Objects;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

@Getter
public class SimpleGUIClient extends JFrame {

	// 싱글톤
	private static SimpleGUIClient instance;

	public static SimpleGUIClient getInstance() {
		if (instance == null) {
			instance = new SimpleGUIClient();
		}
		return instance;
	}

	// 전역변수
	private String username; // 채팅하는 사람 이름
	private Socket socket; //클라이언트 소켓
	
	//카드 레이아웃
	private CardLayout mainCardLayout;
	private JPanel mainCardPanel;

	private JPanel chattingRoomListPanel;
	private JScrollPane roomListScrollPanel;
	private DefaultListModel<String> roomListModel;
	private JList roomList;

	// 채팅방 안 쪽
	private JTextArea chattingTextArea;
	private JPanel chattingRoomPanel;
	private JTextField messageTextField;
	private JScrollPane userListScrollPane;
	private DefaultListModel<String> userListModel; // 얘를 Jlist 안에
	private JList userList;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// 여기서 클라이언트가 생성됨!!!- 그 이후로 어디든지 참조 가능
					SimpleGUIClient frame = SimpleGUIClient.getInstance(); // 여기서 클라이언트가 생성됨!!!
					frame.setVisible(true);
					// 서버측에서 데이터 입력받는 스레드
					ClientReceiver clientReceiver = new ClientReceiver();
					clientReceiver.start(); // 스레드 시작
					//
					// clientReceiver: 외부에서 전달된 데이터를 즉각 입력받기 위해 스레드로 묶어 따로 작동

					// RequestBodyDto client 거
					RequestBodyDto<String> requestBodyDto = new RequestBodyDto<String>("connection", frame.username);
					ClientSender.getInstance().send(requestBodyDto);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// 싱글톤: 생성자 private
	private SimpleGUIClient() {

		username = JOptionPane.showInputDialog(chattingRoomPanel, "아이디를 입력하세요");

		if (Objects.isNull(username)) { // 확인 눌러도 걍 종료
			System.exit(0);
		}
		if (username.isBlank()) {
			System.exit(0);
		}
		try {
			socket = new Socket("127.0.0.1", 8000); // 소켓이 정상적으로 연결될 때!

		} catch (IOException e) {
			e.printStackTrace();
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		mainCardLayout = new CardLayout();
		mainCardPanel = new JPanel();
		mainCardPanel.setLayout(mainCardLayout);
		setContentPane(mainCardPanel);

		//채팅방 리스트
		chattingRoomListPanel = new JPanel();
		chattingRoomListPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		chattingRoomListPanel.setLayout(null);
		mainCardPanel.add(chattingRoomListPanel, "chattingRoomListPanel");

		JButton createRoomButton = new JButton("방만들기");
		createRoomButton.setBounds(10, 10, 100, 30);
		createRoomButton.addMouseListener(new MouseAdapter() { //방만들기 버튼 클릭
			@Override
			public void mouseClicked(MouseEvent e) {
				//방제목 입력 창
				String roomName = JOptionPane.showInputDialog(chattingRoomListPanel, "방제목을 입력하세요"); 
				if(Objects.isNull(roomName)) {
					return;
				}
				if(roomName.isBlank()) { //공백일 경우
					JOptionPane.showMessageDialog(chattingRoomListPanel, "방제목을 입력하세요", "방만들기 실패", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				//방제목 중복 확인
				for(int i = 0; i< roomListModel.size(); i++) { //roomListModel 를 돌려야 됨
					if(roomListModel.get(i).equals(roomName)) {
						JOptionPane.showMessageDialog(chattingRoomListPanel, "이미 존재하는 방제목입니다.", "방만들기 실패", JOptionPane.ERROR_MESSAGE);
						return; //마우스 이벤트 전체를 빠져나옴
					}
				}
				//방 생성하고
				RequestBodyDto<String> requestBodyDto = new RequestBodyDto<String>("createRoom", roomName);
				ClientSender.getInstance().send(requestBodyDto);
			
				//생성하면 바로 채팅방 내부 화면으로 전환
				mainCardLayout.show(mainCardPanel, "chattingRoomPanel"); 
				//방에 들어감 
				requestBodyDto = new RequestBodyDto<String>("join", roomName);
				ClientSender.getInstance().send(requestBodyDto);
				
			}
		});
		chattingRoomListPanel.add(createRoomButton);
		
		roomListScrollPanel = new JScrollPane();
		roomListScrollPanel.setBounds(10, 50, 414, 201);
		chattingRoomListPanel.add(roomListScrollPanel);
		
		roomListModel = new DefaultListModel<String>();
		roomList = new JList(roomListModel);;
		roomList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2) { //더블 클릭
					//더블 클릭했을 때 선택되어있는 요소의 인덱스를 반환(getSelectedIndex())하여 그걸 get() 통해 가져옴
					String roomName = roomListModel.get(roomList.getSelectedIndex());
					
					//채팅방 내부 화면으로 전환
					mainCardLayout.show(mainCardPanel, "chattingRoomPanel"); 
					//방에 들어감 
					RequestBodyDto<String> requestBodyDto = new RequestBodyDto<String>("join", roomName);
					ClientSender.getInstance().send(requestBodyDto);
				}
			}
		});
		
		roomListScrollPanel.setViewportView(roomList);

		chattingRoomPanel = new JPanel();
		chattingRoomPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		chattingRoomPanel.setLayout(null);
		mainCardPanel.add(chattingRoomPanel, "chattingRoomPanel");

		JScrollPane chattingTextAreaScrollPanel = new JScrollPane();
		chattingTextAreaScrollPanel.setBounds(12, 10, 280, 205);
		chattingRoomPanel.add(chattingTextAreaScrollPanel);

		chattingTextArea = new JTextArea();
		chattingTextAreaScrollPanel.setViewportView(chattingTextArea);

		messageTextField = new JTextField();
		messageTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					SendMessage sendMessage = SendMessage.builder().
												fromUsername(username)
												.messageBody(messageTextField.getText())
												.build();
					RequestBodyDto<SendMessage> requestBodyDto = new RequestBodyDto<>("sendMessage", sendMessage); // json
					
					ClientSender.getInstance().send(requestBodyDto);
					messageTextField.setText(""); // 엔터 치면 입력창 비우기
				}
			}
		});

		messageTextField.setBounds(12, 225, 410, 26);
		chattingRoomPanel.add(messageTextField);
		messageTextField.setColumns(10);

		userListScrollPane = new JScrollPane();
		userListScrollPane.setBounds(300, 10, 122, 205);
		chattingRoomPanel.add(userListScrollPane);

		userListModel = new DefaultListModel<>(); // <String>
		userList = new JList(userListModel); // Jlist<userListModel>. JList를 쓰려면 모델이 필요함
		userListScrollPane.setViewportView(userList);
		
		
	}
}
