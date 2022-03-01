package qna.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RequestFactory {

	
	private HttpServletRequest req; //이름이 길기 때문에 이름을 줄여준다
	private HttpServletResponse resp;
	
		//받아서 사용하기 때문에 생성자를 만들어 준다
		public RequestFactory(HttpServletRequest req, HttpServletResponse resp) {
											//메서드로 받아줄 것들	
			
			//req.setCharacterEncoding("UTF-8"); --> 아래처럼 try/catch로 잡아주어야 오류 해결
			try {
				req.setCharacterEncoding("UTF-8"); //요청 받을때 한글을 사용한다
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			
			resp.setCharacterEncoding("UTF-8"); //요청이 욌을때 응답할때도 한글 사용
			resp.setContentType("text/html; charset=UTF-8"); //응답할때 html사용과 한글사용
			
			this.req = req;  //받아준 것을 req로 받아서 맨위의 값에 넣어주는 역할
			this.resp = resp;
			
		}
		
		
		// JSP로 보내주는 로직
		public void forwardToJsp(String path) {

			RequestDispatcher requestdispatcher = req.getRequestDispatcher("/WEB-INF/" + path + ".jsp");
			// 앞으로 path만 입력하면 자동으로 만들어 지게 해준다
			// -> path를 받아 바로 jsp로 이동 시킨다.

			// requestdispatcher.forward(req,resp); -> 오류 해결을 위해 ctrl + 1로 try/catch를 해준다.
			try {
				requestdispatcher.forward(req, resp);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
		
		
