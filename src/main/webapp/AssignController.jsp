<%@page import="com.simpli.entity.Teacher"%>
<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@page import="java.text.SimpleDateFormat"%>

<%@page import="com.simpli.dao.TeacherDao"%>
<%@page import="com.simpli.dao.ClassDao"%>
<%@page import="com.simpli.dao.SubjectDao"%>
<%@page import="com.simpli.entity.Subject"%>
<%@page import="com.simpli.entity.Class"%>
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
	String classeId = request.getParameter("id");
	ClassDao classeDAO = new ClassDao();
	SubjectDao subjectDAO = new SubjectDao();
	TeacherDao teacherDAO = new TeacherDao();
	Class classe = classeDAO.retrieve(Integer.parseInt(request.getParameter("id")));
	Subject subject = subjectDAO.retrieve(Integer.parseInt(request.getParameter("subject")));
	Teacher teacher = teacherDAO.retrieve(Integer.parseInt(request.getParameter("teacher")));
	subject.setTeacher(teacher);
	//subjectDAO.editSubject(subject);

	Set<Subject> subjects = classe.getSubjects();
	
	
	subjects.add(subject);
	
	String result = classeDAO.editClass(classe);
	if (result.equals("updated")) {
		response.sendRedirect("assigndata.jsp?id=" + classeId);
	} else {
		response.sendRedirect("fail.jsp");
	}
	%>
</body>
</html>
