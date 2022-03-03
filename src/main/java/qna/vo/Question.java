package qna.vo;

import java.time.LocalDateTime;

public class Question {
	
	
	//vo의 역할
//	개념
//	Value Object는 DTO와 동일한 개념이나 차이 점은 read only 속성을 갖습니다.
//
//	Value Object는 관계데이터베이스의 레코드에 대응되는 자바클래스입니다. 형태는 db레코드를 구성하는 필드들을 Value Object의 Attribute로 하고 해당 변수에 접근 할 수 있는 Getter Setter메소드의 조합으로 클래스를 형성되어진 클래스입니다. 특성은 대체로 불변성이고 equals()로 비교할 때 객체의 모든 값을 비교해야 합니다.



	
	
	private int id;  //디비에서 오토인크리먼트로 증가 시켜준다
	
	private String title;
	private String body;
	
	private LocalDateTime regDate;
	private LocalDateTime updataDate;
	
	public Question(String title, String body) {
		
		this.title = title;
		this.body = body;
		
		regDate = LocalDateTime.now();
		updataDate = LocalDateTime.now();
		
	}
	
}
