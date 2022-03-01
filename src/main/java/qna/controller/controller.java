package qna.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import qna.util.RequestFactory;

@WebServlet("/question/add")
public class controller extends HttpServlet {
  
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestFactory factory = new RequestFactory(request, response); //RequestFactory class사용하여 request,response받는다
		factory.forwardToJsp("usr/question/add"); // -> usr/question/add를 path에 넣어준다
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestFactory factory = new RequestFactory(request, response); //RequestFactory class를 사용하기 위해 틀을 만든다
		
		HttpServletRequest req = factory.getReq(); //req = req의 값을 받아 넣어준다
		
		String title = req.getParameter("title").toString(); //
		String body = req.getParameter("body").toString();
		
		System.out.println(title);
		System.out.println(body);
		
	}

}
