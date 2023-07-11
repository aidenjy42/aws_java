package ch20_컬렉션;

import java.util.ArrayList;
import java.util.LinkedList;

public class StringArrayListMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CustomArrayList list = new CustomArrayList();
		
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("e");
		list.add(1,"f");
		System.out.println(list); //list.toString()
		
		System.out.println(list.remove()); //출력은 e [a,f,b,c,d,e] -> a,f,b,c,d
		System.out.println(list);
		System.out.println(list.remove(2)); //출력: b, [a,f,c,d]
		System.out.println(list);
		System.out.println();
		
		ArrayList<String> arrayList = new ArrayList<String>();
		//add
		arrayList.add("a");
		arrayList.add("b");
		arrayList.add("c");
		arrayList.add("d");
		arrayList.add("e");
		arrayList.add(1, "f"); //set에는 인덱스가 없으므로 이 오버로딩 함수는 없음
		
		System.out.println(arrayList);
		//remove
		System.out.println(arrayList.remove(3));
		System.out.println(arrayList);
		//set
		arrayList.set(3, "h"); //set은 list<>에만 있음
		System.out.println(arrayList);
		
		LinkedList<String> linkedList = new LinkedList<>(); //변수에 할당 시 앞에 제네릭 타입이 선언되어있으면 뒤에 제네릭은 생략 가능
		linkedList.add(null); //addLast와 같음
		linkedList.addLast(null); 
		
	}

	
	
}
