<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.simpli.dao.ClassDao"%>
<%@page import="java.util.*"%>
<%@page import="com.simpli.entity.Class"%>
<%@page import="com.simpli.entity.Teacher"%>
<%@page import="com.simpli.entity.Subject"%>
<%@page import="com.simpli.dao.TeacherDao"%>
<%@page import="com.simpli.dao.SubjectDao"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%
	List<Teacher> teachers = new TeacherDao().display();
	List<Subject> subjects = new SubjectDao().display();
	%>
	<div class="center">
		<h1>Assign Teacher and Subject</h1>


		<form action="AssignController.jsp">
		<input type="Hidden" name="id" value=<%=request.getParameter("id") %>>
			 <br>
			 <label>Select Teacher:</label><br> <select
				name="teacher">
				<%
				for (Teacher t : teachers) {
				%><option value="<%=t.getId()%>">
					<%out.println(t.getName());%>
				</option>
				<%}%>
			</select><br> 
				<label>Select Subject:</label><br> <select
				name="subject">
				<%
				for (Subject s : subjects) {
				%><option value="<%=s.getId()%>">
					<%out.println(s.getName());%>
				</option>
				<%}%>
			</select><br> <input type="submit" value="OK">
		</form>
	</div>
	
	<table border="1" class="table">
			<tr>
				<th>ID</th>
				<th>Class Name</th>
				<th>Subject Name</th>
				<th>Teacher Name</th>
				<th>Action</th>
				
			</tr>
			<%
		     ClassDao classeDAO = new ClassDao();
		Class classe =	classeDAO.retrieve(Integer.parseInt(request.getParameter("id")));
		String classeName = classe.getName();
		Set<Subject> subjectsClasse = classe.getSubjects();

			
			for (Subject s : subjectsClasse) {
			%>
			<tr>
				<td><%=s.getId()%></td>
				<td><%=classeName%></td>
				<td><%=s.getName()%></td>
				<td><%=s.getTeacher().getName()%></td>
				

				
				<td><a href="deleteSubjectClasse.jsp?subjectId=<%=s.getId()%>
				&classeId=<%=classe.getId()%>">Delete</a></td>

			</tr>
			<%
			}
			%>
		</table>
</body>
</html>
