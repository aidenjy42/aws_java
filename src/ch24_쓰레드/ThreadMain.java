package ch24_쓰레드;

public class ThreadMain {

	public static void main(String[] args) { // main도 하나의 쓰레드임. main이 하나 -> 싱글 스레드
		
		Thread thread = new Thread();
		Thread thread1 = new Thread(() -> {
//			System.out.println("1번 스레드 실행")); //Runnable타입의 start()메소드
			System.out.println("스레드 이름: " + Thread.currentThread().getName());

			for (int i = 0; i < 50; i++) {
				System.out.print(Thread.currentThread().getName() + ": ");  //Thread.currentThread() : 스태틱메소드/현재 실행중인 스레드
				System.out.println(i);
				// for문 안의 모든 문장도 따로 놂.
				
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} //sleep(): 스레드를 잠시 중단시킴
				//sleep() 메소드에 throws 예외 있어서 예외 처리해줘야됨
			}

		}, "1번 스레드"); // name: 스레드의 이름 지정

		Thread thread2 = new Thread(() -> {
			// System.out.println("2번 스레드 실행")
			System.out.println("스레드 이름: " + Thread.currentThread().getName());

			for (int i = 0; i < 50; i++) {
				System.out.print(Thread.currentThread().getName() + ": ");
				System.out.println(i);
				// for문 안의 모든 문장도 따로 놂.
			}

		}, "2번 스레드");

		thread1.start(); // 이걸 써줘야 스레드가 실행
//		try {
//			thread1.join(); //join() 작성 후 surround with try/catch 클릭
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}//join(): 스레드1번이 끝날때까지 대기 걸어주는 함수

		// 스레드는 순서가 없음 먼저 메모리에 올라온 스레드가 실행

		// ?
		Thread thread3 = new Thread(new ThreadTest(), "3번 스레드"); // thread() 생성자 타입이 Runnable
		//Runnable인터페이스 구현한 ThreadTest클래스를 매개변수로

		Thread thread4 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("스레드 이름: " + Thread.currentThread().getName());
				System.out.println("4번 스레드 실행");

			}
		}, "4번 스레드");

		thread2.start(); //
//		thread3.start();
//		thread4.start(); //run()메소드를 호출한다
	}

}
