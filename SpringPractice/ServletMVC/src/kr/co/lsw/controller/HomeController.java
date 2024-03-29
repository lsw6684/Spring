package kr.co.lsw.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.lsw.model.Test2Service;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("*.mvc")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HomeController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 컨트롤러 역할 - url에 따라 분기로 처리
		// TODO Auto-generated method stub
		// 요청한 주소 가져오기
		String url = request.getRequestURI();

		// View로 사용할 JSP
		String viewName = null;

		if (url.contains("main.mvc")) {
			//System.out.println("main 요청");
			viewName = "main.jsp";
		} else if (url.contains("test1.mvc")) {
			//System.out.println("test1 요청");
			// 파라미터 데이터 추출
			// Model, 컨트롤러에 임시 구현
			String str1 = request.getParameter("data1");
			String str2 = request.getParameter("data2");
			
			int number1 = Integer.parseInt(str1);
			int number2 = Integer.parseInt(str2);
			
			int result = number1 + number2;
			
			request.setAttribute("result", result);
			
			viewName = "test1.jsp";
		} else if (url.contains("test2.mvc")) {
			//System.out.println("test2 요청");
			
			//모델 요청
			int result = Test2Service.minus(request);

			request.setAttribute("result", result);
			
			viewName = "test2.jsp";
		}
		
		RequestDispatcher dis = request.getRequestDispatcher(viewName);
		dis.forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
