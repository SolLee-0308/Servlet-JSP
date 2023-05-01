package dao;
/*
  	02_login.html 데이터 처리 servlet
*/
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한글 처리
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		
		// form에서 데이터 받아오기
		String id = request.getParameter("user_id");
		String pw = request.getParameter("user_pw");
		
		
		// 데이터 출력 = printWriter 객체
		PrintWriter out = response.getWriter(); // HttpServletResponse의 getWriter() 이용하여 문자열을 가져옴
		// HTML폼을 출력하려면 이러한 과정을 거친다 정도만 알아두면 됨
		// 출력할 폼 HTML 형식으로 만듦
		String data = "<html>";
		data += "<body>";
		data += "아이디 : " + id;
		data += "<br>";
		data += "비밀번호 : " + pw;
		data += "</body>";
		data += "</html>";
		// 브라우저 출력
		out.print(data);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
