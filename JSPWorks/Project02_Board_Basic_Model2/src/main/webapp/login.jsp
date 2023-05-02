<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 한글처리
	request.setCharacterEncoding("utf-8");
	response.setContentType("text/html; charset=utf-8");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Project01_Board_Basic_Model2 | index</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://unpkg.com/bootstrap@3.3.7/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="./css/reset.css">
    <link rel="stylesheet" href="./css/font.css">
    <link rel="stylesheet" href="./css/css.css">
</head>
<style>
	#wrap {
		width: 960px;
		margin: 40px auto;
		text-align: center;
		border: 1px solid #ccc;
		padding: 40px 0;
	}
</style>
<body>
	<div id="wrap" class="card-body">
		<header>
			<h1>로그인</h1>
		</header>
		<section>
			<form action="LoginCtrl" method="post">
				<table class="table table-bordered">
					<tr>
						<td>아이디</td>
						<td>
							<input type="text" name="id" id="id" />
						</td>
					</tr>
					<tr>
						<td>비밀번호</td>
						<td>
							<input type="password" name="password" id="password" />
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" value="로그인" class="btn btn-primary" />
							<input type="reset" value="취소" class="btn btn-secondary" />
						</td>
					</tr>
				</table>
			</form>
		</section>
	</div>
</body>
</html>