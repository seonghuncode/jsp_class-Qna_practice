package qna.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import qna.service.QuestionService;
import qna.util.RequestFactory;


//모델(Model)과 뷰(View) 사이를 이어주는 브릿지(Bridge) 역할을 의미합니다.
//
//모델이나 뷰는 서로의 존재를 모르고 있습니다. 변경 사항을 외부로 알리고 수신하는 방법만 있습니다. 컨트롤러(Controller)는 이를 중재하기 위해 모델과 뷰에 대해 알고 있어야 합니다. 모델이나 뷰로부터 변경 내용을 통지 받으면 이를 각 구성 요소에게 통지해야 합니다. 사용자가 어플리케이션을 조작하여 발생하는 변경 이벤트들을 처리하는 역할을 수행합니다.
//
//컨트롤러는 다음과 같은 규칙을 가지고 있습니다.
//
//모델이나 뷰에 대해서 알고 있어야 합니다.
//모델이나 뷰의 변경을 모니터링 해야 합니다.


@WebServlet("/question/add")
public class questionController extends HttpServlet {
  
	private QuestionService questionService = new QuestionService(); //사용을 위해 만들어 준다
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestFactory factory = new RequestFactory(request, response);
		factory.forwardToJsp("usr/question/add");
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestFactory factory = new RequestFactory(request, response);
		HttpServletRequest req = factory.getReq();
		
		String title = req.getParameter("title").toString();
		String body = req.getParameter("body").toString();
		
		questionService.save(title, body); //save에게 넘겨준다.
		
	}

}
