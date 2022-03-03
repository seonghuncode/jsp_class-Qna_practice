package qna.service;



import org.apache.ibatis.session.SqlSession;

import qna.config.SessionFactory;
import qna.dao.QuestionDao;
import qna.vo.Question;

//MVC패턴의 m의 역할
//DATA, 정보들의 가공을 책임지는 컴포넌트를 말합니다.
//
//모델(Model)은 어플리케이션의 정보, 데이터를 나타냅니다. 데이타베이스, 처음의 정의하는 상수, 초기화 값, 변수 등을 뜻합니다. 비즈니스 로직을 처리한 후 모델의 변경사항을 컨트롤러와 뷰에 전달합니다.
//
//모델은 다음과 같은 규칙을 가지고 있습니다.
//
//사용자가 편집하길 원하는 모든 데이터를 가지고 있어야 합니다.
//뷰나 컨트롤러에 대해서 어떤 정보도 알지 말아야 합니다.
//변경이 일어나면, 변경 통지에 대한 처리 방법을 구현해야만 합니다.

public class QuestionService {

	private QuestionDao questionDao;
	private SqlSession sqlSession;
	
	public QuestionService(){
		
		SqlSession session = SessionFactory.getSession(); //세션이 열린다.
		questionDao = session.getMapper(QuestionDao.class); //QuestionDao의 정보를 모두 가지고 온다.
		
	}
	
	public void save(String title, String body) {
		
		Question question = new Question(title, body); //여기에 title, body를 넣어 준다.
		questionDao.save(question); //questionDao로 넘긴다.
		
		sqlSession.commit();
		sqlSession.close();
	}
	
	
}
