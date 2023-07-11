package 단위평가.단위2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapList {

	public static void main(String[] args) {
		List<Map<String, Object>> customers = new ArrayList<Map<String, Object>>();
		Map<String, Object> c1 = new HashMap<>();
		Map<String, Object> c2 = new HashMap<>();
		
		c1.put("name", "홍길동");
		c1.put("rating", "vip");
		c1.put("age", 35);
		
		c2.put("name", "김기영");
		c2.put("rating", "gold");
		c2.put("age", 35);
		
		customers.add(c1);
		customers.add(c2);
		
		for (Map<String, Object> customer : customers) {
//			//map의 name, rating, age
//			System.out.println("name = " + customer.get("name"));
//			System.out.println("rating = " + customer.get("rating"));
//			System.out.println("age = " + customer.get("age"));
			
			for(Map.Entry<String, Object> entry : customer.entrySet()) { //map의 key value를 entry로
				System.out.println(entry);
			}
			
		}
	}

}
