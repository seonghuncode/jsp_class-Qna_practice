package qna.dao;

import qna.vo.Question;


//자바 인터페이스
public interface QuestionDao {


	void save(Question question);
	
//	DAO
//	개념
//	데이터 접근을 목적하는 객체입니다. 커넥션 같은 것을 하나만 두고 여러 사용자가 DAO의 인터페이스를 사용하여 필요한 자료에 접근 하도록 하는 것이 DAO의 개념입니다.
//	사용자는 자신이 필요한 Interface를 DAO에게 던지고 DAO는 이 인터페이스를 구현한 객체를 사용자에게 편리하게 사용 할수 있도록 반환해줍니다.

}
