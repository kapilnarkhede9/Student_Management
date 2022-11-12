<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ page import="com.example.demo.modules.Students"%>
<%@ page import="java.util.*"%>

<link href="css/tables.css" rel="stylesheet" type="text/css">
</head>
<body>
	<table style="width: 100vw">
		<thead>
			<th>ID</th>
			<th>Name</th>
			<th>Email ID</th>
			<th>Password</th>
			<th>Address</th>
			<th>Role</th>
		</thead>
		<tbody>
			<%
			ArrayList<Students> list = (ArrayList<Students>) request.getAttribute("list");
			if(list.size()>0)
			for (Students s : list) {
			%>
			<tr style="background-color: Yellow">
				<td><%=s.getName()%></td>
				<td><%=s.getBranch()%></td>
				<td><%=s.getGender()%></td>
				<td><%=s.getDOB()%></td>
				<td><%=s.getPnr()%></td>
				<td><%=s.getRoll_no()%></td>
			</tr>
			<%
			}
			%>
		</tbody>

	</table>


</body>
</html>