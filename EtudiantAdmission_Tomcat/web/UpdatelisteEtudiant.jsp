<!-- /**
 * This is an HTML file for updating student information.
 * 
 * <p>
 * The HTML structure includes a head and a body. The head contains the title of the page.
 * The body contains a form.
 * </p>
 * 
 * <p>
 * The form is a POST form that sends a request to "StudentControlerServlet". This form contains a table with input fields for the user to update an ID, a name, and a first name. The ID field is read-only and is populated with the current ID value. The name and first name fields are populated with the current values but can be edited by the user. The form is submitted by clicking the "save" button.
 * </p>
 * 
 * @author MarcT
 * @version 1.0
 * @since 2023-06-01
 */ -->

<!DOCTYPE html>
<html>
    <head>
        <title>Update Student Information</title>
    </head>
    <body>
        <form action="StudentControlerServlet" method="POST">
            <table>
                <tr>
                    <td> Id: </td>
                    <td><input type="text" name="id1" value="${up.id}" readonly> </td>
                </tr>
                <tr>
                    <td> Name: </td>
                    <td><input type="text" name="name1" value="${up.nom}"> </td>
                </tr>
                 <tr>
                    <td> First Name: </td>
                    <td><input type="text" name="name2" value="${up.prenom}"> </td>
                </tr>
                <tr>
                    <td><input type="submit" name="save"> </td>
                </tr>
            </table>
            
        </form>
    </body>
</html>
