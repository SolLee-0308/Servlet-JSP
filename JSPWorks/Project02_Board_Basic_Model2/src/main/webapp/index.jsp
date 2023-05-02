<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- JSTL 사용하려면 lib 폴더에 꼭 jstl-1.2.jar 파일 넣어주기!! -->
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Project01_Board_Basic | index</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://unpkg.com/bootstrap@3.3.7/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="./css/reset.css">
    <link rel="stylesheet" href="./css/font.css">
    <link rel="stylesheet" href="./css/css.css">
</head>
<body>
    <div id="wrap" class="card-body">
        <header>
            <h1>기초 게시판 제작 연습 | 모델2</h1>
            <!-- 세션에 할당 JSTL로 변수 선언 -->
			<c:set var="name" value="${name }" scope="session"/>
            <!-- 세션이 있으면 하단 출력 -->
            <c:if test="${empty name }">
	            <div>
		            <a href="./login.jsp">로그인</a> |
		            <a href="GetBoardListCtrl">글목록</a> |
		            <a href="./addBoard.jsp">글쓰기</a>
	        	</div>
            </c:if>

            <!-- 세션이 없으면 아래 출력 -->
            <c:if test="${not empty name }">
	            <div>
		            <a href="LogoutCtrl">로그아웃</a> |
		            <a href="GetBoardListCtrl">글목록</a> |
		            <a href="./addBoard.jsp">글쓰기</a>
	        	</div>
            </c:if>

        </header>
	</div>
</body>
</html>