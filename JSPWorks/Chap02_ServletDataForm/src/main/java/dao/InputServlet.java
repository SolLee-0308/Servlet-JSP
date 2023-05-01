package dao;
/*
  	Request(요청)와 Response(응답)
  	: 브라우저에서 정보 전달 요청을 위해 사용하는 방법
  	  a. GET방식 = 주소창에 직접 원하는 데이터 쓰거나 링크 클릭시 호출 | doGet()에서 처리
  	     Context/매핑명?속성명1 = 속성값1&속성명2=속성값2...
  	     특정 정보 이용시 사용
  	  b. POST방식 = 폼에서 입력한 데이터를 submit버튼 클릭시 호출 | doGet()에서 처리
  	     주소와 데이터를 따로 보내는 방식
  	     웹 화면을 통해 실제 처리가 필요한 작업을 하기 위해 사용
  	     
  	HTTP규약(=프로토콜 => 데이터 교환에 대한 규칙과 약속) // req, res 생각하면 됨
  	: HyperTextTransferProtocol
  	
  	HTTP메세지 구성
  	: header, body로 구성
  	  request header / request body
  	  response header / response body
  	
  	Servlet
  	: JavaEE 기술, 개발자 = 서버에서 처리되어야 하는 기능의 일부분만 작성하는 것임 // 밑에 보면 이미 자동으로 상속 코딩돼 있음
  	  => 위임, 생성 등의 것은 톰캣이 알아서 해줌
  	  아파치톰캣 WAS서버에 존재하여 톰캣에서 실행됨
  	  
  	서블릿 프로그래밍이 기존 웹서버 프로그래밍과 다른점
  	: a. 객체를 생성하거나 호출하는 주체 = 서블릿 컨테이너 (=톰캣) => 사용자가 사용하는 것이 아님
  	     즉, 자바의 main()을 이용하여 프로그램 실행하지 않음
  	  b. 서블릿 클래스에서 생성하는 객체의 관리 = 서블릿 컨테이너(톰캣)가 관리
  	     (예) 서블릿 생명주기메서드
  	  c. 서블릿/JSP 코드 = 기본적인 자바 API와 동일하게 사용됨 + 서블릿 API도 동시 사용
  	                    단, 서블릿 API는 관련 라이브러리(플러그인 파일) 필요
  	                    
  	JSP 언어 = JavaServerPages
  	: 서블릿 기술과 동일하게 (동적)으로 서버에서 데이터를 다루는 기술
  	  Servlet JSP 모두 동적으로 데이터를 생성해 전송하는 것은 같음
  	  => 단, 구현 방식은 다름
  	  a. Servlet = Java코드 + HTML
  	  a. JSP = HTML + Java코드
  	  ›
  	JSP 언어에서는 GET/POST 처리 방식의 구분이 없음
  	: 쿼리스트링 처리 = Servlet에서 함
  	  화면구성 = JSP로 함
  	  
  	
  	
*/
/*  HttpServletRequest를 이용한 서블릿의 데이터 수  */
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/input")
public class InputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// doGet : 데이터 get방식 처리 // 어딘가에 추상메서드를 구현한 것
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한글 처리
		request.setCharacterEncoding("utf-8");
		// input 데이터 받기
		String id = request.getParameter("user_id");
		String pw = request.getParameter("user_pw");
		
		System.out.println(id + "\n" + pw);
		// 배열 처리
		String[] subject = request.getParameterValues("subject");
		for(String str : subject) {
			System.out.println("선택한 과목 : " + str);
		}

	}


	// doPost : 데이터 post방식 처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}



