package ch26_socket.server;

import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ServerApplication {
	public static ServerSocket serverSocket; // static으로 정의
	public static int port;
	
	public static void main(String[] args) { //main도 스레드

		Thread connectionThread = null; //새로운 스레드를 선언
		System.out.println("[ 서버 프로그램 실행 ]");

		while (true) { //메인 스레드에서 계속 반복하여 스캐너가 생성됨
			Scanner scanner = new Scanner(System.in); // 스캐너 객체 선언문을 밖에서 선언하면 inputMismatchException이 scanner 객체를 죽임

			int selectedMenu;
			System.out.println("1. 서버 켜기");
			System.out.println("2. 서버 끄기");
			System.out.print("선택>> ");
//
			try { //1차 입력
				selectedMenu = scanner.nextInt(); //while 돌리면서 계속 입력
			} catch (InputMismatchException e) {
				System.out.println("숫자만 입력 가능합니다.");
				continue; //다른 값이 들어왔을 때 다시 while문이 돌아서 입력 받게 함
			}
			//아래는 숫자 입력만 들어왔을때만 돌아감
			switch (selectedMenu) {
				case 1: //서버 켜기
					if (serverSocket != null) { //1.소켓(static) 생성이 됐는지 확인 -> 서버가 열린 건지 확인
						System.out.println("이미 서버가 실행중입니다.");
						break; //switch를 나감-> while 시작으로
					}
					System.out.print("서버의 포트번호를 입력하세요 >> ");
					
					try { //1차 입력에서 1번 선택 시-> 포트번호 2차 입력
						port = scanner.nextInt();
					} catch(InputMismatchException e) {
						System.out.println("숫자만 입력 가능합니다."); //포트번호는 int형식임
						continue; //while 시작으로
					}
					
					
					// 스레드 정의문. 정의했다고 실행되는 것은 아님.
					// 입력받은 포트번호로 소켓객체(=서버) 생성하고, 다른 클라이언트의 접속을 기다리는 스레드
					//while문 안에 thread가 있기 떄문에 계속 스레드가 생성됨
					//client의 접속을 받는 스레드
					connectionThread = new Thread(() -> { // 매개변수 타입: 러너블 -> 람다식
					// 람다식은 새로운 클래스를 만들고 메소드를 정의하는 것이므로 람다식 밖의 변수 사용 불가.
						try {//소켓 생성
							serverSocket = new ServerSocket(port); // 스캐너로 입력한 포트번호로 이동
							
							while (!Thread.interrupted()) { //스레드가 종료되지 않았을 때 시동 //다음 클라이언트 접속을 계속 받아야 하므로 while문 안에 socket생성문이 있음
								//만약 서버를 꺼서 interrupt()를 호출했을 경우 interrupted()의 반환값이 true
								//조건이 false가 되므로 아래 문장 수행 안됨 = 접속 대기를 하지 않음
								Socket socket = serverSocket.accept(); // client의 접속을 기다림 //클라이언트의 socket과 연결
								//접속된 client로부터 요청받는스레드가 각각 생성됨(리스트형태로)
								ConnectedSocket connectedSocket = new ConnectedSocket(socket); //접속 될때마다 스레드객체를 새로 생성하여 그 소캣을 스레드에 담음
								connectedSocket.start(); //스레드 시작
								//C.client.Ctrler는 리스트 객체 하나만을 생성하여 그 리스트 안에 계속 스레드와 소켓을? 담는다.
								ConnectedClientController.getInstance().getConnectedSockets().add(connectedSocket); //리스트에 접속된 스레드들을 add 
								
								System.out.println("접속!!");
								System.out.println(socket.getInetAddress().getHostAddress());
							}
						
						} catch (BindException e) { //다른 client가 포트를 쓰고 있을 경우()
							System.out.println("이미 사용중인 포트번호입니다.");
						} catch (SocketException e) { 
							System.out.println("서버의 연결이 종료되었습니다."); //소켓 강제종료가 돼서 
						} catch (IOException e) { //그 밖의 예외
							e.printStackTrace();
						}
					
					}, "connectionThread");
					// 스레드 정의 끝
					//정의만 되고 실행은 start() 호출 되어야 스레드 시작됨 (runnable의 run() 호출 됨)
					
					connectionThread.start(); // 스레드 시작
					break;
	
				case 2: // 서버 끄기: 서버 즉, 스레드를 멈춰야됨!
					
					if (serverSocket == null) {
						System.out.println("서버가 실행중이지 않습니다.");
						break;
					}
					
					try {
						serverSocket.close(); //소켓 (=서버)을 죽임 -> 소켓 객체 소멸
					} catch (IOException e) {}
					
					//스레드 안에 소켓
					connectionThread.interrupt(); //스레드 안에 소켓을 닫음->소켓 밖에 있는 스레드도 강제종료 
					//interrupted() 값이 true -> 위의 if문 조건에서 false임->안의 문장이 실행이 안됨 -> 스레드가 자연스럽게 소멸된다.
					
					try {
						connectionThread.join(); //이 스레드가 종료될 때까지 메인 스레드가 대기중임
						/*
						 * 스레드 종료..->"서버의 연결이 종료되었습니다."
						 * 그 다음 
						 * 프로그램 종료
						 */
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					System.out.println("프로그램 종료");
					return; //그리고 메인 종료
	
				default: //숫자 입력이 들어왔으나 1, 2번 외의 숫자를 입력했을 경우
					System.out.println("다시 선택하세요.");
				}
			//스레드 다 끝나고 다시 while 시작으로 돌아갈 때 스레드 내부에서 출력할 게 남았을 수 있으니까 출력할 거 다 출력하고 메인(while문) 대기 시킴
			if(serverSocket == null) { //서버가 닫혀있어도 스레드는 메모리에 남아있음 ->스레드도 종료
				try {
					connectionThread.join(500); //main에서 입력받기 전에 스레드가 실행이 끝날 때까지 메인을 대기시킴
					//다른 스레드가 있을 경우 출력할 게 있을 수 있으니까? 0.5초만 대기함
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}
