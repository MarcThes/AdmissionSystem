<!--/**
 * This is a JSP (Java Server Pages) file.
 *
 * The page is set to use UTF-8 encoding and outputs HTML content.
 *
 * The HTML structure includes a head and a body. The head contains meta information and the title of the page.
 * The body contains a simple arithmetic operation where two integers, x and y, are added together. The result is stored in integer z.
 * The value of z is then outputted to the page.
 *
 * The body also contains a heading with the text "Hello World".
 * 
 * @author MarcT
 * @version 1.0
 * @since 2023-06-01
 */ -->

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <% 
          // Declare and initialize variables
          int x = 12;
          int y = 14;

          // Perform arithmetic operation
          int z = x+y;
       %>

       <%-- Output the result of the arithmetic operation --%>
       <%=z %>

       <%-- Output a heading --%>
       <h1>Hello World</h1>
    </body>
</html>

