package dao;
/*
	03_formdata.html 데이터 처리 servlet	
*/
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/formdata")
public class ServletFormData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 사용자가 폼으로 전달한(request)로 값을 받기 전에 전달된 인코딩 값을 설정해야 함!!!
		// 한글 처리
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		
		// 폼데이터
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		// 주문 수량 => 정수형으로 바꿔야 연산 가능!
		int qty = Integer.parseInt(request.getParameter("qty")); // 수량이라는 점 주의!
		String email = request.getParameter("email");
		String url = request.getParameter("url");
		String date = request.getParameter("date");
		String comment = request.getParameter("comment");
		
		// 폼 타입 라디오 = 단일 데이터
		String baseball = request.getParameter("baseball");
		
		// 폼 타입 체크박스 = 여러 데이터
		String[] fav = request.getParameterValues("favorite");
		
		// 폼 타입 select 박스 = 단일 데이터
		String base = request.getParameter("base");
		// 폼 타입 다중 select 박스 = 여러 데이터
		String[] base2 = request.getParameterValues("base2");
		// 파일 업로드 = 단일 데이터
		String upload = request.getParameter("upload");
		
		
		// 브라우저 출력
		PrintWriter out = response.getWriter();
		// 폼 데이터 브라우저에 출력하기
		out.println("<h1>Form Data Value</h1>");
		out.println("NAME : " + name + "<br>");
		out.println("ID : " + id + "<br>");
		out.println("PASSWORD : " + password + "<br>");
		out.println("ADDRESS : " + address + "<br>");
		out.println("QYY : " + qty + "<br>");
		out.println("E-MAIL : " + email + "<br>");
		out.println("URL : " + url + "<br>");
		out.println("DATE : " + date + "<br>");
		out.println("COMMENT : " + comment + "<br>");
		out.println("회사명 : " + baseball + "<br>");
		// 선호회사 배열 요소 추출
		for(String favorite:fav) {
			out.println("선호회사 : " + favorite + "<br>");
		}
		
		out.println("최고선호회사 : " + base + "<br>");
		
		for(String base22:base2) {
			out.println("선호회사 : " + base22 + "<br>");			
		}
		
		out.println("File Upload : " + upload + "<br>");
		
		// io객체 사용 후 닫기
		out.close();
		
	}

}
