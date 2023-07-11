package ch16_lombok;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Data //toString, getter, setter, equals and hashcode

public class Slave {
	
	private final String name;
	
	@Getter //특정변수에만 getter 만들고 싶으면 그 변수 위에 @getter 표시
	private int age;
	
	
}
