<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@page import="javax.sql.DataSource"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	
	weblogic.jndi.Environment environment = new weblogic.jndi.Environment();
	environment.setInitialContextFactory(
	  weblogic.jndi.Environment.DEFAULT_INITIAL_CONTEXT_FACTORY);
	
	environment.setProviderURL("t3://localhost:7001");
	environment.setSecurityPrincipal("weblogic");
	environment.setSecurityCredentials("weblogic@123");
	Context ctx = environment.getInitialContext();
	System.out.println("Context : "+ctx);
	
	DataSource dataSource = (DataSource) ctx.lookup("jdbc/MyDataSource");
	System.out.println("DataSource :  "+dataSource);
	
	Connection conn = dataSource.getConnection();
	Statement st = conn.createStatement();
	ResultSet rs = st.executeQuery("Select * from dept3");
	
	out.println("<table border=5 cellspacing=10 cellpadding=10>");

	while(rs.next()) {
		out.println("<tr>");
			out.println("<td>"+rs.getInt(1)+"</td>");
			out.println("<td>"+rs.getString(2)+"</td>");
			out.println("<td>"+rs.getString(3)+"</td>");
		out.println("<tr>");
	}
	out.println("</table>");

	
		
	%>
</body>
</html>