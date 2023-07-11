package ch20_컬렉션;

//ArrayList에서 제공하는 메소드를 직접 작성해보기
public class CustomArrayList {
	private String[] array;

	public CustomArrayList() {
		array = new String[0]; // 객체 생성될 때 크기가 0인 배열 생성
	}
	
	//배열에 새로운 값을 추가
	public void add(String str) { 
		String[] newArray = new String[array.length + 1];
		for(int i = 0; i < array.length; i++) {
			newArray[i] = array[i];
		}
		newArray[array.length] = str;
		array = newArray;
	}
	
	//오버로딩: index 인덱스에 str를 삽입
	/*
	 * 1) 기존의 배열크기 +1인 새로운 배열 생성
	 * 2) newArray에 index 인덱스 전까지 기존 인덱스에 고대로 넣기
	 * 3) newArray의 index 인덱스에는 str를 넣는다.
	 * 3) newArray index+1 부터는 기존 배열의 index
	 */
	public void add(int index, String str) {
		String[] newArray = new String[array.length + 1]; //새로운 배열 생성 
		//index 자리에 str
			//index + 1자리에 array [i + 1]
		
		// a,b,c,d,e -> add(1, "f")
		for(int i = 0; i < index; i++) {
			newArray[i] = array[i];
		}
		newArray[index] = str;
		//newArray[2]에 array[1==index] 인덱스값
		//newArray[3]에 
		
		//기존 배열에서 index부터 끝까지의 데이터를 새로운 배열의 index 다음부터 옮긴다.
		for(int i = index; i < array.length; i++) {
			newArray[i + 1] = array[i];
		}
		array = newArray;
	}
	
	//remove() 호출하면 제일 끝에 있는 요소 지우고 배열 크기 줄임. 그리고 내가 지운 값을 반환
	public String remove() {
		String value = array[array.length - 1]; 
		String[] newArray = new String[array.length - 1];
		
		for(int i = 0; i < newArray.length; i++) {
			newArray[i] = array[i];
		}
		array = newArray;
		return value;
	}
	
	public String remove(int index) { //index에 해당하는 요소 지우고 앞으로 땡기고 지운 값을 반환
		String[] newArray = new String[array.length - 1];
		String value = array[index];
		
		//강사님 첫번째 풀이
//		for(int i = 0; i < array.length; i++) {
//			
//			int tempIndex = i - 1; //
//			if(i == index) {
//				continue; //인덱스가 index면 거르기
//			}
//			if(i < index) {
//				tempIndex = i; //index
//			}
//			
//			//index 인덱스 뒤에 요소 
//			newArray[tempIndex] = array[i];
// 		}
		
		for(int i = 0; i < index; i++) {
			newArray[i] = array[i];
		}
		//newArray[0] array[0]
		//array[index] 생략
		//ary[index + 1] 부터 넣기
		//newArray[index] 에 array[index +1]
		for(int i = index; i < newArray.length; i++) {
			newArray[i] = array[i + 1];
		}
		
		array = newArray;
		return value;
	}
	
	//set: 특정 인덱스의 요소 값을 바꾸는 것
	public void set(int index, String str) {
		array[index] = str;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		
		//for each(향상된 for문)
		for(String str: array) { //array의 처음 인덱스부터 끝까지 순회하여 str에 대입해서 사용
			builder.append(str + ",");
		}
//		for(int i = 0; i < array.length; i++) { 위와 같음
//			builder.append(array[i] + ",");
//		} 
		
		//delete(): 마지막 ,는 지우기
		builder.delete(builder.lastIndexOf(","), builder.length()); //a, -> a
		builder.append("]");
		
		return builder.toString();
	}
}
