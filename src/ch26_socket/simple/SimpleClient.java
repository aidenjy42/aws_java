package ch26_socket.simple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class SimpleClient {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		try {
			Socket socket = new Socket("127.0.0.1", 8000);
			
			//inputThread: 외부에서 전달된 데이터를 즉각 입력받기 위해 스레드로 묶어 따로 작동
			Thread inputThread = new Thread(()-> {
//					InputStream inputStream = socket.getInputStream();
//					InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
//					BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
				//== bufferedReader2 = ...
				try {
					while(true) {
						BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(socket.getInputStream()));
						//서버 -> 클라이언트 방향으로 output하면 이쪽(client)에서 input함
						String requestBody = bufferedReader2.readLine();
						System.out.println("내용: " + requestBody);
					}
				} catch(IOException e) {
					e.printStackTrace();
				}
				
			});
			inputThread.start();
			
			//client-> server로 output
			while(true) {
				PrintWriter printWriter = new PrintWriter(socket.getOutputStream(),true);
				//printWriter: Server-Client 간에 통로를 열어줌
				System.out.print("입력: ");
				String input = scanner.nextLine();
				
				printWriter.println(input); //println을 통해 출력(서버에서의 output)
				//printWriter가 입력 받은 값을 서버프로그램의 inputStreamReader로 readLine()이 입력값을 받음
			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
