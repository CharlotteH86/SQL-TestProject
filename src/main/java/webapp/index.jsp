<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@page import="beans.Bean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Collections"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SEARCH</title>
</head>
<body>



	<form action="<%=request.getContextPath()%>/SearchServlet"
		method="post">
		Search in database:<input type="text" name="searchString"><br>
		<input type="submit" value="SEARCH">
	</form>

	<%
	// get the results

	ArrayList<Bean> databaseList = (ArrayList<Bean>) request.getAttribute("searchResult");

	


	if (!(databaseList == null)) {

		out.print("<ul>");
		for (int i = 0; i < databaseList.size(); i++) {

			
			
			//KOMMENTAR TILL MARCUS! Nedan printas info om min sökning. Problemet är att jag får null när sökningen inte hittar något i databasen. Du rekommenderade att jag loopade igenom för att se om stringen innehåller null, och isf inte printar ut den. Min fråga är om du har ytterligare tips till hur jag gör detta? Det känns rent spontant att jag fastnat lite här. 
			
			out.print("<li>");

			out.print("Name " + databaseList.get(i).getIkeaName() + "<br>");
			out.print("Name " + databaseList.get(i).getBearName() + "<br>");
			out.println("Origin: " + databaseList.get(i).getOrigin() + "<br>");
			out.print("Notes: " + databaseList.get(i).getNotes() + "<br>");
			out.print("Creator: " + databaseList.get(i).getCreator() + "<br>");
			out.print("</li>");

		}

		out.print("</ul>");

	}
	;

	//out.print(databaseList);
	%>

	<%
	if (!(databaseList == null)) {
		out.print("<ul>");
		for (int i = 0; i < databaseList.size(); i++) {

			out.print("<li>");

			out.print("Name " + databaseList.get(i).getIkeaName() + "<br>");
			out.print("Name " + databaseList.get(i).getBearName() + "<br>");
			out.println("Origin: " + databaseList.get(i).getOrigin() + "<br>");
			out.print("Notes: " + databaseList.get(i).getNotes() + "<br>");
			out.print("Creator: " + databaseList.get(i).getCreator() + "<br>");
			out.print("</li>");

		}

		out.print("</ul>");
	}
	;
	%>











</body>
</html>