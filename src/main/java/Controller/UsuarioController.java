package Controller;

import DAO.UsuarioDAO;
import Model.Usuario;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "usuarios", urlPatterns = {
        "/usuarios/nuevoUsuario","/usuarios/insertarUsuario","/usuarios/borrarUsuario","/usuarios/editarUsuario","/usuarios/actualizarUsuario","/usuarios/listarUsuario"})
public class UsuarioController extends HttpServlet {
    private UsuarioDAO usuariosDao;

    public void init() {
        usuariosDao = new UsuarioDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/usuarios/nuevoUsuario":
                    System.out.println("Not done");
                    showNewFormUsuario(request, response);
                    break;
                case "/usuarios/insertarUsuario":
                    insertUsuario(request, response);
                    break;
                case "/usuarios/borrarUsuario":
                    deleteUsuario(request, response);
                    break;
                case "/usuarios/editarUsuario":
                    showEditFormUsuario(request, response);
                    break;
                case "/usuarios/actualizarUsuario":
                    updateUsuario(request, response);
                    break;
                case "/usuarios/listarUsuario":
                    listUsuario(request, response);
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listUsuario(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Usuario> listUsuario = usuariosDao.selectAll();
        request.setAttribute("listaUsuario", listUsuario);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/View/Usuario/usuarios.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewFormUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/View/Usuario/usuariosForm.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditFormUsuario(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        //get session data
        HttpSession session = request.getSession();
        Usuario usuario = (Usuario) session.getAttribute("usuarioSession");
        int idusuario = usuario.getIdusuario();
        Usuario existingUsuario = usuariosDao.select(idusuario);
        //List
        request.setAttribute("usuarios", existingUsuario);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/View/Usuario/usuariosForm.jsp");
        dispatcher.forward(request, response);

    }

    private void insertUsuario(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String nickname = request.getParameter("nickname");
        String clave = request.getParameter("clave");

        Usuario newUsuario = new Usuario(nickname, clave);
        usuariosDao.insert(newUsuario);
        response.sendRedirect("listarUsuario");
    }

    private void updateUsuario(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        //get session data
        HttpSession session = request.getSession();
        Usuario usuario = (Usuario) session.getAttribute("usuarioSession");
        int idusuario = usuario.getIdusuario();
        boolean isadmin = usuario.isAdmin();
        String nickname = request.getParameter("nickname");
        String clave = request.getParameter("clave");

        Usuario newUsuario = new Usuario(idusuario, nickname, clave, isadmin);
        usuariosDao.edit(newUsuario);
        response.sendRedirect("listarUsuario");
    }

    private void deleteUsuario(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int idusuario = Integer.parseInt(request.getParameter("idusuario"));
        usuariosDao.delete(idusuario);
        response.sendRedirect("listarUsuario");
    }
}
