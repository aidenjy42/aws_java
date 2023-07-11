package ch24_쓰레드;

public class 분신만들기 {

	public static void main(String[] args) {
		분신 분신1 = new 분신();
		분신 분신2 = new 분신();
		분신 분신3 = new 분신();
		분신 분신4 = new 분신();
		
//		Thread thread1 = new Thread();
		//Thread 객체 생성 시 Runnable 객체인 target이 생성되면 그 이후에 그 안에 있는 run()메소드를 실행할 수 있음
		
		//1. 익명클래스로 생성
		Runnable runnable = new Runnable() { 
			
			@Override
			public void run() {
				
				while(true) {
					System.out.println("Runnable");
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				}
			}
		};
		
		Thread thread2 = new Thread(runnable);
		//thread2 안의 run() runnable의 run()을 호출 -> 왜?어떻게?
		
		//2. 위 코드를 람다식으로
		Runnable runnable2 = () -> { 
				
				while(true) {
					System.out.println("Runnable");
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
			}
		};
		Thread thread3 = new Thread(runnable2);
		
		//4.바로 Runnable 객체를 람다식으로 생성 후 스레드 생성
		Thread thread4 = new Thread(() -> {
			while(true) {
				System.out.println("스레드4");
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		}
			
		});
		분신1.start();
		분신2.start();
		분신3.start();
		분신4.start();
		thread2.start();
		thread3.start();
	}

}
