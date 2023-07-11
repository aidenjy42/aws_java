package ch26_socket.client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ClientApplication extends JFrame {

	private Socket socket; //전역으로 선언
	private JPanel mainPanel;
	private JTextField ipTextField;
	private JTextField portTextField;
	private JTextField messageTextField;
	JButton messageSendButton;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientApplication frame = new ClientApplication();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ClientApplication() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 466, 473);
		mainPanel = new JPanel();
		mainPanel.setBackground(new Color(162, 173, 253));
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(mainPanel);
		mainPanel.setLayout(null);
		
		
		// <<< 채팅 내용>>>
		JScrollPane chatTextAreaScrollPane = new JScrollPane();
		chatTextAreaScrollPane.setBounds(12, 10, 252, 352);
		mainPanel.add(chatTextAreaScrollPane);
		
		JTextArea chatTextArea = new JTextArea();
		chatTextArea.setEditable(false); //채팅에 올라온 내용은 수정 못하게
		chatTextAreaScrollPane.setViewportView(chatTextArea);
		
		// <<< 채팅 연결 >>>
		ipTextField = new JTextField();
		ipTextField.setBounds(276, 10, 159, 29);
		mainPanel.add(ipTextField);
		ipTextField.setColumns(10);
		
		portTextField = new JTextField();
		portTextField.setBounds(276, 46, 159, 29);
		mainPanel.add(portTextField);
		portTextField.setColumns(10);
		
		JButton connectionButton = new JButton("접속");
		connectionButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String serverIp = ipTextField.getText();
				String serverPort = portTextField.getText();
				
				if(serverIp.isBlank() || serverPort.isBlank()) { //둘중 하나라도 공백이면
					JOptionPane.showMessageDialog(
							mainPanel,
							"IP와 PORT 번호를 입력해주세요",
							"접속 오류", JOptionPane.ERROR_MESSAGE );
					return;
				}
				
				//접속 성공
				try {
					//정상 접속일 경우
					socket = new Socket(serverIp,Integer.parseInt(serverPort)); //client에서 socket객체 생성
					//port번호는 int형으로 바꿔넣어줘야함
					JOptionPane.showMessageDialog(
							mainPanel,
							"서버와의 연결에 성공하였습니다.",
							"접속 완료",
							JOptionPane.PLAIN_MESSAGE);
					//접속됐을 때 입력불가능한 걸 가능하게 풀어주고 버튼클릭이 가능하게 함
					messageTextField.setEditable(true); 
					messageSendButton.setEnabled(true);
					
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (UnknownHostException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		
		connectionButton.setBackground(new Color(255, 255, 255));
		connectionButton.setForeground(new Color(0, 0, 0));
		connectionButton.setBounds(276, 85, 159, 29);
		mainPanel.add(connectionButton);
		
		
		// <<< 접속자 >>>
		JScrollPane connectedUserListScrollPane = new JScrollPane();
		connectedUserListScrollPane.setBounds(276, 135, 159, 227);
		mainPanel.add(connectedUserListScrollPane);
		
		
		JList connectedUserList = new JList();
		connectedUserListScrollPane.setViewportView(connectedUserList);

		// <<< 메세지 입력 및 전송 >>>
		messageTextField = new JTextField();
		messageTextField.addKeyListener(new KeyAdapter() { //키보드 입력
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) { //VK_ENTER: 엔터키(\n)를 int형으로 반환 == 10
					System.out.println("전송"); //엔터키 치면 전송되게끔
				}
				
				
			}
		});
		
		messageTextField.setBounds(12, 372, 346, 52);
		messageTextField.setEditable(false); //접속한 상태일때만 입력 가능하게 false로 초기 설정
		mainPanel.add(messageTextField);
		messageTextField.setColumns(10);
		
		messageSendButton = new JButton("전송");
		messageSendButton.setBounds(370, 372, 65, 52);
		messageSendButton.setEnabled(false); //전송 버튼도 비활성화
		mainPanel.add(messageSendButton);
	}
}
