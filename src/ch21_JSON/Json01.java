package ch21_JSON;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

public class Json01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gson gson = new Gson();
		Map<String, Object> dataMap = new HashMap<>();
		dataMap.put("porductCode", "P20230704");
		dataMap.put("productName", "아이폰15");
		
		System.out.println(dataMap);
		
		JsonObject jsonObject = new JsonObject(); //JSON 형태
		jsonObject.addProperty("productCode","P20230704");
		jsonObject.addProperty("productName", "아이폰15");
		
		//gson을 통해 객체를 json으로 바꿔줌 : toJson
		System.out.println(gson.toJson(dataMap));
		
		//json -> 객체 : fromJson
		Map<String, Object> jsonMap = gson.fromJson(jsonObject, Map.class);		
		System.out.println(jsonMap); //Map 형태로
		System.out.println(jsonMap.get("productCode")); //단 이것의 반환형은 Object
		
	}

}
