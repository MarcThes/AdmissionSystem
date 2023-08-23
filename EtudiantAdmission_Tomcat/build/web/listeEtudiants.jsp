<!--/**
 * This is a JSP (Java Server Pages) file for displaying a list of students.
 * 
 * The page is set to use UTF-8 encoding and outputs HTML content. It also uses the JSTL (JSP Standard Tag Library) core library.
 *
 * The HTML structure includes a head and a body. The head contains meta information and the title of the page.
 * The body contains a heading and a table that lists the students.
 * 
 * The table is populated by iterating over the "lstEtudiants" attribute using the JSTL "forEach" tag. Each row in the table represents a student and includes the student's ID, name, and first name. Each row also includes "Delete" and "Update" links that send a request to "StudentControlerServlet" with the student's ID and the action to perform.
 * 
 * @author MarcT
 * @version 1.0
 * @since 2023-06-01
 */ -->

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP LISTE DES ETUDIANTS</title>
    </head>
    <body>
        <h1>Liste des Etudiants</h1>
        <c:forEach var="etudiant" items="${lstEtudiants}" >
         
            <table>      
                <tr>
                    <td>  ${etudiant.id} </td>
                    <td>   ${etudiant.nom} </td>
                    <td>   ${etudiant.prenom} </td>
                      <td>  <a href="<c:url value='/StudentControlerServlet?id=${etudiant.id}&act=delete' />" >Delete</a> </td>
                      <td>  <a href="<c:url value='/StudentControlerServlet?id=${etudiant.id}&act=update' />" >Update</a> </td>
                </tr>
            </table>    
        </c:forEach>
    
    <br>
    </body>
</html>
