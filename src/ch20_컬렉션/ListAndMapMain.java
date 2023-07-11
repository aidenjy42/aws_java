package ch20_컬렉션;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListAndMapMain {
//다시 보기
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<TestUser> testUsers = new ArrayList<>();
		
		testUsers.add(TestUser.builder().username("aaa").password("1234").build());
		testUsers.add(TestUser.builder().username("bbb").password("1234").build());
		testUsers.add(TestUser.builder().username("ccc").password("1234").build());
		testUsers.add(TestUser.builder().username("ddd").password("1234").build());
		testUsers.add(TestUser.builder().username("eee").password("1234").build());
		
		System.out.println(testUsers);
		
		//
		Map<String, Object> responseData = new HashMap<>();
		responseData.put("testUserList", testUsers);
		responseData.put("statusCode", "OK");
		
		System.out.println(responseData);
		
		for(TestUser testUser :(List<TestUser>) responseData.get("testUserList")) { 
//			responseData.get("testUserList") 자체는 지금 Object로 업캐스팅 된 상태 -> 다운캣 해줘야함
			System.out.println(testUser);
		}
		
		//List 안에 Map도 넣을 수 있음-> Json
	}

}
