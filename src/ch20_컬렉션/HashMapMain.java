package ch20_컬렉션;
import java.util.HashMap;
import java.util.Map.Entry;

public class HashMapMain {

	public static void main(String[] args) {
		HashMap<String, String> strMap = new HashMap<>();
		strMap.put("username","aaa");
		strMap.put("password","1234");
		strMap.put("name","우주영");
		
		System.out.println(strMap);
		System.out.println(strMap.get("username"));
		
		
		//Map은 키가 순서가 없어서 반복을 돌릴 수 없음
		//entrySet()함수를 통해 Entry 객체를 생성하여 key value를 동시에 가져올 수 있음
		for(Entry<String, String> entry : strMap.entrySet()) { 
			System.out.println(entry.getKey()+ " : " + entry.getValue());
			System.out.println();
		}
		System.out.println();
		for(String key : strMap.keySet()) { //키만 반복 돌림
			System.out.println(key);
			System.out.println(strMap.get(key));
		}
		
	}

}
