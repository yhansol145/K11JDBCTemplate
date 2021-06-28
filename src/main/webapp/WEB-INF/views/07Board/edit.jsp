<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../resources/css/bootstrap.css" />
<script src="../resources/jquery/jquery-3.6.0.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="container">
	<h2>비회원제 게시판 - 글수정 폼</h2>
	
	<form name="writeFrm" method="post" 
		action="./editAction.do" 
		onsubmit="return checkValidate(this);">
		
	<!-- 
	패스워드 검증 후 수정페이지로 진입하므로 패스워드를 두번 입력하는 것은
	의미가 없다. 따라서 hidden상자로 처리한다.
	-->
	
	<input type="hid den" name="idx" value="${viewRow.idx }" >
	<input type="hid den" name="nowPage" value="${param.nowPage }" >
	<input type="hid den" name="pass" value="${viewRow.pass }" />
	
	<table border=1 width=800>
	<colgroup>
		<col width="25%"/>
		<col width="*"/>
	</colgroup>
	<tr>
		<td>작성자</td>
		<td>
			<input type="text" name="name" style="width:50%;" 
				value="${viewRow.name }" />
		</td>
	</tr>
<!-- 	<tr> -->
<!-- 		<td>패스워드</td> -->
<!-- 		<td> -->
<!-- 			<input type="password" name="pass" style="width:30%;" /> -->
<!-- 		</td> -->
<!-- 	</tr> -->
	<tr>
		<td>제목</td>
		<td>
			<input type="text" name="title" style="width:90%;" 
				value="${viewRow.title }" />
		</td>
	</tr>
	<tr>
		<td>내용</td>
		<td>
			<textarea name="contents" 
				style="width:90%;height:200px;">${viewRow.contents }</textarea>
		</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<button type="submit">작성완료</button>
			<button type="reset">RESET</button>
			<button type="button" onclick="location.href='./list.do';">
				리스트바로가기
			</button>
		</td>
	</tr>
	</table>	
	</form>
</div>
</body>
</html>