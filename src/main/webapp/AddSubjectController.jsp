<%@page import="com.simpli.entity.Student"%>
<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@page import="java.text.SimpleDateFormat"%>

<%@page import="com.simpli.dao.SubjectDao"%>

<%@page import="com.simpli.entity.Subject"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	SubjectDao dao = new SubjectDao();
		Subject subject = new Subject();
		subject.setName(request.getParameter("name"));
		
		
		int row = dao.addSubject(subject);
		if (row > 0) {
			response.sendRedirect("successAddSubject.jsp");
		} else {
			response.sendRedirect("fail.jsp");
		}
	%>
</body>
</html>
