package Controller;

import DAO.LoginDAO;
import Model.Usuario;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "login", urlPatterns = {"/login"})
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private LoginDAO loginDAO;

    public void init() {
        loginDAO = new LoginDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        //Get paramethers
        String nickname = request.getParameter("nickname");
        String clave = request.getParameter("clave");
        //Check if user exist
        try {
            Usuario usuarioSession = loginDAO.logIn(nickname, clave);
            System.out.println(nickname + " " + clave + " " + usuarioSession.isAdmin());
            System.out.println(usuarioSession);
            //Validate and redirect
            session.setAttribute("usuarioSession", usuarioSession);
            if (usuarioSession.isAdmin()) {
                System.out.println("Soy admin");
                response.sendRedirect("usuarios/listarUsuario");
            } else if (!usuarioSession.isAdmin()){
                response.sendRedirect("encuesta/nuevoEncuesta");
            }else {
                System.out.println("hola salu2");
            }
        }catch (Exception e){
            boolean error = true;
            request.setAttribute("error", error);
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        }

    }

}
