<%@page import="mvc_mock.StudentDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="1px">
<tr>
<th>Stuid</th>
<th>StuName</th>
<th>Stuemail</th>
<th>StuPwd</th>
<th>EmpGender</th>

</tr>
<%List<StudentDto>list=(List<StudentDto>)request.getAttribute("key"); %>
<% for(StudentDto dto:list){ %>
<tr>
<td><%=dto.getId() %></td>
<td><%=dto.getName() %></td>
<td><%=dto.getEmail() %></td>
<td><%=dto.getPwd() %></td>
<td><%=dto.getGender() %></td>

</tr>
<%} %>

</table>
</body>
</html>