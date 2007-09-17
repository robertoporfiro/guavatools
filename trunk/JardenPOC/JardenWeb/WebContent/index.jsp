<%@ page language="java" contentType="text/html;charset=UTF-8"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>WSDL and XSD index</title>
</head>
    <body>
	<h1>WSDL and XSD index</h1>
    <%
    java.util.Set resourcePaths = application.getResourcePaths("/");
    java.util.TreeSet<String> sortedPaths = new java.util.TreeSet<String>(resourcePaths);
    java.util.Iterator<String> iterator = sortedPaths.iterator();
    while (iterator.hasNext()) {
    	String path = iterator.next();
    	if (path.endsWith("/") && !path.equals("/WEB-INF/")
    			&& !path.equals("/META-INF/") && !path.equals("/resources/")) {
    		printPath(path, out, application);
    	}
    }
    %>
    
		<a href="productionNotes.html">WSDL Production Notes</a>    
    </body>
</html>

<%!
private void printPath(String path, JspWriter out, ServletContext application) throws java.io.IOException {
    java.util.Set resourcePaths = application.getResourcePaths(path);
    java.util.TreeSet<String> sortedPaths = new java.util.TreeSet<String>(resourcePaths);
    java.util.Iterator<String> iterator = sortedPaths.iterator();
    if (!iterator.hasNext()) return;
    String pathName = path.substring(1, path.length() - 1);
	out.println("<h2>" + pathName + "</h2>");
	out.println("<ul>");
    while (iterator.hasNext()) {
    	String file = iterator.next().substring(1);
    	String fileName = file.substring((path.length() - 1));
    	out.println("<li><a href='" + file + "'>" + fileName + "</a></li>");
    }
	out.println("</ul>");
	
}
%>
