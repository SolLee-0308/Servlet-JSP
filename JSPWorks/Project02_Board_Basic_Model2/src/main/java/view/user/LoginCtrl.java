package view.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import biz.user.UserDAO;
import biz.user.UserVO;


@WebServlet("/LoginCtrl")
public class LoginCtrl extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGetPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGetPost(request, response);
	}
	
	protected void doGetPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한글 처리
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		// 폼 파라미터 값 받기
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
//		System.out.println(id);
//		System.out.println(password);
		
		// DAO 클래스 사용
		UserDAO udao = new UserDAO();
		// DAO 클래스 메서드 호출
		UserVO user = udao.getUser(id, password);

		// 로그인 로직 구현
		// DB에서 값을 할당 받았으면 세션에 name값 할당 후 index.jsp에 이동
		// 값이 없으면 login.jsp
		if(user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("name", user.getName());
			response.sendRedirect("./index.jsp");
		}else {
			response.sendRedirect("./login.jsp");
		}
		
	}

}
