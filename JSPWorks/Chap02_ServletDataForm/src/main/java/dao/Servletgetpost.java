package dao;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/servletgetpost")
public class Servletgetpost extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// doGet()
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// doGet(), doPost() 두 개 동시 처리 메서드 호출
		doGetPost(request, response);
		System.out.println("doGet 메서드 호출");
	}
	
	// doPost()
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// doGet(), doPost() 두 개 동시 처리 메서드 호출
		doGetPost(request, response);
		System.out.println("doPost 메서드 호출");

	}
	
	// doGet() doPost() 선택 처리 메서드
	protected void doGetPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한글 처리
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		
		// parameter값 받기
		String id = request.getParameter("user_id");
		String pw = request.getParameter("user_pw");
		
		
		// 데이터 콘솔 확인
		System.out.println("아이디 : " + id);
		System.out.println("비밀번호 : " + pw);
		
		
		// 브라우저 출력
		PrintWriter out = response.getWriter();
		System.out.println("doGetPost 메서드 호출");
		// 데이터 브라우저 확인
		String data = "<html>";
		data += "<body>";
		data += "아이디 : " + id;
		data += "<br>";
		data += "비밀번호 : " + pw;
		data += "</body>";
		data += "</html>";

		out.print(data);
		
		out.close();

	}
	

}
