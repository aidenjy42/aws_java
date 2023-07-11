package ch19_제네릭;

public class ResponseMain {
//제네릭: 자료형을 유동적으로 사용할 수 있음
	public static void main(String[] args) {
		Response<String> response1 = new Response<String>(200, "회원가입 성공!!"); //"객체가 생성될 때" 제네릭 타입이 결정
//		System.out.println(response1);
		
		SignupUser signupUser = SignupUser.builder()
							.username("aaa")
							.password("1234")
							.name("김준일")
							.email("aaa@gmail.com")
							.build();
		
		Response<SignupUser> response2 = new Response<SignupUser>(400, signupUser); //같은 기능인데 자료형만 다른 클래스를 만들면 코드 중복이 발생 -> 제네릭으로 해결
//		System.out.println(response2);
		
		AccountUser accountUser = AccountUser.builder()
				.username("aaa")
				.password("1234")
				.build();
		
		//<?> : wildCard. new 뒤에 오는 <타입>을 선언하면 <?> 자리에는 그 타입이 따라서 들어감
		Response<AccountUser> response3 = new Response<AccountUser>(200, accountUser);
//		response3 = response2; //<?>으로 선언되어있어서 복사가 가능함
		printResponse(response3);
		
		UpdateUser updateUser = UpdateUser.builder().username("aaa").password("1234").address("부산").phone("010-0000-0000").build();
		//(주의)여기서는 printResponse()에 제네릭 타입이 extends AccountUser로 되어있기 때문에 ?로만 선언하면 안됨 -> UpdateUser 또는 ? extends AccountUser로 선언해야 됨
		Response<UpdateUser> response4 = new Response<UpdateUser>(300, updateUser);
		
//		printResponse(response4); //? extends AccountUser에는 가능
		
	}
	//<?>으로 선언되어있어서 매개변수도 복사가 가능함!! 알아서 <?>제네릭에 타입이 정해짐
	public static Response<?> printResponse(Response<? super SignupUser> response){ 
		//? extends AccountUser : AccountUser만 상속 받은 클래스 타입만 가능
		//? super SignupUser : SignupUser와 그 부모 클래스만 가능
		System.out.println(response);
		return response;
	}

	
}
