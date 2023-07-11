package ch22_익명클래스;

import java.util.ArrayList;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class TestFunctionMain {
//람다식 
	public static void main(String[] args) {
//		TestFunction1 function1 = () -> { //TestFunction1의 test()를 재정의한 거임 
//			System.out.println("매개변수 x, 리턴 x");
//		}; 
		
		//(1) 명령문이 하나인 경우에는 {}를 생략할 수 있다.
		TestFunction1 function1 = () -> System.out.println("매개변수 x, 리턴 x") ; //<- 이 세미콜론은 sysout() 뒤에 붙는 ;가 아닌 전체 문장에 대한 ;임. 중괄호가 생략돼서 그럼
		
		function1.test(); //주소 참조가 가능하다 = 객체임을 의미
		
		
//		TestFunction2 function2 = (int num) -> {
//			System.out.println("매개변수 1개, 리턴 x");
//			System.out.println("num: " + num);
//		};
		
		//(2) 매개변수는 타입 생략 가능. 그리고 인자가 하나인 경우에는 괄호도 생략 가능
		TestFunction2 function2 = num -> {
			System.out.println("매개변수 1개, 리턴 x");
			System.out.println("num: " + num);
		};
		function2.test(100);
		
		//(3) 매개변수가 없거나 2개 이상일 경우에는 매개변수 괄호를 생략할 수 없다.
		TestFunction3 function3 = (age, name) -> { //오버라이딩할 때 매개변수명을 바꿀 수 있음
			System.out.println("매개변수 2개, 리턴 x");
			System.out.println("나이: " + age);
			System.out.println("이름: " + name);
		};
		
		function3.test(30, "김준일");
		
		//(4) 리턴이 있는 메소드는 재정의 시 return문을 반드시 써야 함
//		TestFunction4 function4 = (age,name) -> {
//			System.out.println("매개변수 2개, 리턴 o");
//			return "나이: " + age + ", 이름: " + name;
//		};
		
		//(5) 명령이 한 줄인 경우 중괄호를 생략할 수 있으며, 중괄호를 생략한 경우 그 즉시 리턴값이 된다. return을 쓰고 싶으면 중괄호를 써야 한다.
		TestFunction4 function4 = (age,name) -> "나이: " + age + ", 이름: " + name;  //return "나이: " + age + ", 이름: " + name;
		String result1 = function4.test(30, "김준일");
		System.out.println(result1);
		
		//<위의 작성된 기능과 똑같이 제공되는 인터페이스>
		//1) 매개변수x, 리턴x
		Runnable runnable = () -> {
			System.out.println("매개변수 x, 리턴 x");
		};
		runnable.run();
		
		//2) 매개변수 1, 리턴 x
		Consumer<String> consumerStr = name -> { //<> 에 들어간 타입이 매개변수 name의 타입이 된다. // (String name) -> { }; 와 같음
			System.out.println(name);
		};
		consumerStr.accept("김준일");
		//매개변수 2,리턴x
		BiConsumer<String, Integer> biConsumer = (name, age) -> {
			System.out.println("이름: " + name);
			System.out.println("나이: " + age);
		};
		biConsumer.accept("김준일", 30);
		
		//매개변수 x, 리턴 o
		Supplier<Integer> supplier = () -> 100; //return이 생략됨  //get()를 재정의
		System.out.println(supplier.get());
		
		//매개변수 o, 리턴 o
		Function<Integer, String> function = year -> "생일: " + year; //apply를 재정의
		System.out.println(function.apply(1994));
		
		//Predicate은 보통 필터링할 때 씀
		ArrayList<Integer> numbers = new ArrayList<>();
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		numbers.add(4);
		numbers.add(5);
		numbers.add(6);
		numbers.add(7);
		numbers.removeIf(num -> num % 2 == 0); //짝수는 거르기
		//removeIf() 매개변수: Predicate<>
		//Predicate<> predicate = num -> num % 2 == 0
		//removeIf() 매개변수의 filter대신 predicate가 들어가서 내부에서 논리 구동
		
//		predicate안에 메소드 는 num -> num % 2 == 0 인지 확인하고 참 거짓을 반환
		System.out.println(numbers);
		
		//forEach() : 매개변수가 Consumer./ consumer는 매개변수 있고 반환은 없음 
//		void forEach(Consumer<? super E> action) { // 여기서 E가 Integer가 됨
		numbers.forEach(num -> System.out.println("출력: " + num));
		//forEach의 매개변수 타입: Consumer
		//Consumer<> consumer = num -> System.out.println("출력: " + num);
	}

}
