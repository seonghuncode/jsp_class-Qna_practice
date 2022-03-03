package qna.config;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class SessionFactory {
	
	static SqlSessionFactory sqlSessionFactory = null; // 필드(정적필드) 일반적으로 선언하고 동시에 초기값을 준다

	
	static {// -> static을 초기화 시켜준 것이다(static SqlSessionFactory sqlSessionFactory = null; --> 초기화 시키는 과정)
		
		String path = "mybatis.config.xml"; //이걸 사용하는 이유는 mybatis에서 필요하다고 한거기 때문에 약속이다
		InputStream inputStream = null; 
		
		//String path가 주소 이름만 알려준 상태인데 myconfig.xml차일을 자바가 일기 위해 inpustream안에 있는 소스가 Srtring으로 바꿔준다.
		
		//inputstream = Resources.getResourceAsStream(path);
		try {
			inputStream = Resources.getResourceAsStream(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		
	}
	
	
	public static SqlSession getSession() {
		
		SqlSession session = sqlSessionFactory.openSession();
	
		
		return session;//getSession을 사용할때 마다 세션을 열어준다.
	}
	
	
}
