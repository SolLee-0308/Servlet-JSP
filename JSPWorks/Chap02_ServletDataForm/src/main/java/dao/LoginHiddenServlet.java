package dao;
/*
  	form_exe.html 
 */
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginhiddenservlet")
public class LoginHiddenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGetPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGetPost(request, response);
	}
	
	protected void doGetPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한글 처리
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		
		// 데이터 받기
		String id = request.getParameter("user_id");
		String pw = request.getParameter("user_pw");
		
		// hidden 값 받기
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String tel = request.getParameter("tel");

		
		// 브라우저 출력
		PrintWriter out = response.getWriter();
		String data = "안녕하세요 <br> 로그인하셨네요!! <br><br>";
		data += "<html><body>";
		data += "아이디 : " + id + "<br>";
		data += "패스워드 : " + pw + "<br>";
		data += "사는 곳 : : " + address + "<br>";
		data += "이메일 주소 : " + email + "<br>";
		data += "전화번호 : " + tel + "<br>";
		data += "</body></html>";
		
		out.println(data);
		
		out.close();
		
		

	}

}
