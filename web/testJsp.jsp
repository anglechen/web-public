<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*"%>
<%
	int flag = 3000;
	session.setAttribute("salary", 3000);
	List lis = new ArrayList();
	lis.add("li1");
	lis.add("li2");
	lis.add("li3");
	session.setAttribute("lists", lis);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- <c:set var="salary" scope="session" value="${2000*2}"/> --%>
<c:if test="${salary > 2000}">
   <p>测试: <c:out value="${salary}"/><p>
</c:if>

<c:forEach var="i" begin="1" end="5">
   Item <c:out value="${i}"/><p>
</c:forEach>


<c:forEach  var= "li"   items= "${lists}" >
	${li} 

</c:forEach>

<!-- 自动重定向 -->
<%-- <c:redirect url="http://www.baidu.com"/> --%>

	<%
	   // 重定向到新地址
	   String site = new String("http://www.baidu.com");
	   response.setStatus(response.SC_MOVED_TEMPORARILY);
	   response.setHeader("Location", site); 
	%>

	<%
	pageContext.setAttribute("info","111");
	request.setAttribute("info","22");
	session.setAttribute("info","33");
	application.setAttribute("info","44");
	%>
	 
	<h1>page属性内容:${pageScope.info}</h1>
	<h2>request属性内容：${requestScope.inof}</h2>
	<h3>session属性内容：${sessionScope.info}</h3>
	<h4>application属性内容：${applicationScope.info}</h4>

</body>
</html>