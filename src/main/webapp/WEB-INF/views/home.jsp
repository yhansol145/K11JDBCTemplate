<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
   <h2>게시판 리스트 출력</h2>
   <ul>
      <li>
         <a href="./board/list.do" target="_blank">
            JDBCTemplate을 이용한 게시판 리스트
         </a>
      </li> 
   </ul>
</body>
</html>
