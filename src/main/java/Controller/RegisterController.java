package Controller;

import DAO.UsuarioDAO;
import Model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "register", urlPatterns = {"/register"})
public class RegisterController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UsuarioDAO usuarioDAO;

    public void init() {
        usuarioDAO = new UsuarioDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Get paramethers
        String nickname = request.getParameter("nickname");
        String clave = request.getParameter("clave");
        //Check if user exist
        Usuario usuarioRegistro = new Usuario(nickname,clave);
        try {
            usuarioDAO.insert(usuarioRegistro);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println(usuarioRegistro.getClave() + " " + usuarioRegistro.getNickname());
        //Validate and redirect
        response.sendRedirect("http://localhost:8080/laboratorioFinal_war_exploded/index.jsp");
    }

}
