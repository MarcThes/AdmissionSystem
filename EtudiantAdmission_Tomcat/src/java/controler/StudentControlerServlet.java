package controler;

import DaoImp.EtudiantsDaoImplementation;
import interfaceDao.EtudiantDao;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Etudiant;

/**
 * This servlet class handles the CRUD operations for the Etudiant model.
 *
 * <p>
 * The servlet uses an EtudiantDao object to interact with the database. The
 * EtudiantDao object is initialized in the init() method.
 * </p>
 *
 * <p>
 * The servlet provides the following methods:
 * <ul>
 * <li>init(): Initializes the EtudiantDao object.</li>
 * <li>processRequest(HttpServletRequest request, HttpServletResponse response):
 * Processes the POST requests. It creates a new Etudiant, retrieves all
 * Etudiants from the database, and forwards the request to the
 * "listeEtudiants.jsp" page.</li>
 * <li>doGet(HttpServletRequest request, HttpServletResponse response):
 * Processes the GET requests. It performs different actions based on the "act"
 * parameter in the request: "delete" deletes an Etudiant, "update" retrieves an
 * Etudiant for updating, and "find" retrieves an Etudiant based on the provided
 * ID. After performing the action, it forwards the request to the appropriate
 * JSP page.</li>
 * <li>doPost(HttpServletRequest request, HttpServletResponse response): Calls
 * the processRequest() method to process the POST requests.</li>
 * <li>getServletInfo(): Returns a short description of the servlet.</li>
 * </ul>
 * </p>
 *
 * @author MarcT
 * @version 1.0
 * @since 2023-06-01
 */
@WebServlet(name = "StudentControlerServlet", urlPatterns = {"/StudentControlerServlet"})

public class StudentControlerServlet extends HttpServlet {

    EtudiantDao dao;
    // Initialize the EtudiantDao object

    public void init() throws ServletException {

        dao = new EtudiantsDaoImplementation();
    }
    // Process POST requests
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    // Parse request parameters
        int id = Integer.parseInt(request.getParameter("id1"));
        String name = request.getParameter("name1");
        String name2 = request.getParameter("name2");
        Etudiant etud1 = new Etudiant(id, name, name2);

        dao.create(etud1);

        List<Etudiant> listeEtudiants = dao.findAll();
        request.setAttribute("lstEtudiants", listeEtudiants);
        getServletContext().getRequestDispatcher("/listeEtudiants.jsp").
                forward(request, response);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("act");
        if (action.equals("delete")) {
            int id = Integer.parseInt(request.getParameter("id"));
            dao.delete(id);

            List<Etudiant> listeEtudiants = dao.findAll();
            request.setAttribute("lstEtudiants", listeEtudiants);
            getServletContext().getRequestDispatcher("/listeEtudiants.jsp").
                    forward(request, response);

        } else if (action.equals("update")) {
            int id = Integer.parseInt(request.getParameter("id"));
            Etudiant etu = dao.findById(id);
            request.setAttribute("up", etu);
            getServletContext().getRequestDispatcher("/UpdatelisteEtudiant.jsp").
                    forward(request, response);
        } else if (action.equals("find")) {
            int id = Integer.parseInt(request.getParameter("id"));
            Etudiant etu = dao.findById(id);
            request.setAttribute("etudiant", etu);
            getServletContext().getRequestDispatcher("/FindEtudiant.jsp").
                    forward(request, response);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
