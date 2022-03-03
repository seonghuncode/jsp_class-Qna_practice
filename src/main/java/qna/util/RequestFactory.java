package qna.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RequestFactory {
	
	HttpServletRequest req;
	HttpServletResponse resp;
	
	public RequestFactory(HttpServletRequest req, HttpServletResponse resp) {
	
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		
		this.req = req;
		this.resp = resp;
		
	}

		
		public void forwardToJsp(String path) {
			
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/" + path + ".jsp");
			try {
				requestDispatcher.forward(req, resp);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		
		public HttpServletRequest getReq() {
			return this.req;
		}
		
		public HttpServletResponse getResp() {
			return this.resp;
		}
	
		
	}
		
		
