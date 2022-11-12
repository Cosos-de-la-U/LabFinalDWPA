package Controller;

import DAO.EncuestaDAO;
import Model.DatosDeportes;
import Model.DatosGenero;
import Model.Encuesta;
import Enum.*;
import Model.Usuario;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@WebServlet(name = "encuesta", urlPatterns = {
        "/encuesta/nuevoEncuesta", "/encuesta/verEncuesta","/encuesta/insertarEncuesta","/encuesta/borrarEncuesta","/encuesta/editarEncuesta","/encuesta/actualizarEncuesta","/encuesta/listarEncuesta","/encuesta/graficarEncuesta"})
public class EncuestaController extends HttpServlet {
    private EncuestaDAO encuestaDao;

    public void init() {
        encuestaDao = new EncuestaDAO();
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
                case "/encuesta/nuevoEncuesta":
                    showNewFormEncuesta(request, response);
                    break;
                case "/encuesta/insertarEncuesta":
                    insertEncuesta(request, response);
                    break;
                case "/encuesta/borrarEncuesta":
                    deleteEncuesta(request, response);
                    break;
                case "/encuesta/editarEncuesta":
                    showEditFormEncuesta(request, response);
                    break;
                case "/encuesta/verEncuesta":
                    verEditFormEncuesta(request, response);
                    break;
                case "/encuesta/actualizarEncuesta":
                    updateEncuesta(request, response);
                    break;
                case "/encuesta/listarEncuesta":
                    listEncuesta(request, response);
                    break;
                case "/encuesta/graficarEncuesta":
                    graficarEncuesta(request, response);
                    break;

            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listEncuesta(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        //Date
        String fechaGet = request.getParameter("fecha");
        if (fechaGet == null){
            List<Encuesta> listEncuesta = encuestaDao.selectAll();
            request.setAttribute("listaEncuesta", listEncuesta);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/View/Encuesta/encuesta.jsp");
            dispatcher.forward(request, response);
        }else {
            Date fecha = Date.valueOf(fechaGet);
            List<Encuesta> listEncuesta = encuestaDao.selectAllFecha(fecha);
            request.setAttribute("listaEncuesta", listEncuesta);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/View/Encuesta/encuesta.jsp");
            dispatcher.forward(request, response);
        }
    }

    private void graficarEncuesta(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        //Genero
        DatosGenero datosGenero = encuestaDao.selectAllDatosGenero();
        request.setAttribute("datosGenero", datosGenero);
        //Deportes
        DatosDeportes datosDeportes = encuestaDao.selectAllDatosDeportes();
        request.setAttribute("datosDeportes", datosDeportes);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/View/Encuesta/encuestaGrafico.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewFormEncuesta(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Lisat
        List<String> listaDeporte = DeporteEnum.getListDeporte();
        List<String> listaNivel = NivelEnum.getListNivel();
        List<String> listaGeneros = SexoEnum.getListSexo();
        List<String> listaTemas = TemasEnum.getListTemas();
        //Set Lists
        request.setAttribute("deportes", listaDeporte);
        request.setAttribute("niveles", listaNivel);
        request.setAttribute("generos", listaGeneros);
        request.setAttribute("temas", listaTemas);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/View/Encuesta/encuestaForm.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditFormEncuesta(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        //get encuesta
        int id = Integer.parseInt(request.getParameter("idencuesta"));
        Encuesta existingEncuesta = encuestaDao.select(id);
        //Lista
        List<String> listaDeporte = DeporteEnum.getListDeporte();
        List<String> listaNivel = NivelEnum.getListNivel();
        List<String> listaGeneros = SexoEnum.getListSexo();
        List<String> listaTemas = TemasEnum.getListTemas();
        //Set object
        request.setAttribute("encuesta", existingEncuesta);
        //Set Lists
        request.setAttribute("deportes", listaDeporte);
        request.setAttribute("niveles", listaNivel);
        request.setAttribute("generos", listaGeneros);
        request.setAttribute("temas", listaTemas);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/View/Encuesta/encuestaForm.jsp");
        dispatcher.forward(request, response);

    }

    private void verEditFormEncuesta(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        //get session data
        HttpSession session = request.getSession();
        Usuario usuario = (Usuario) session.getAttribute("usuarioSession");
        int idusuario = usuario.getIdusuario();
        Encuesta existingEncuesta = encuestaDao.selectUser(idusuario);
        //Lista
        List<String> listaDeporte = DeporteEnum.getListDeporte();
        List<String> listaNivel = NivelEnum.getListNivel();
        List<String> listaGeneros = SexoEnum.getListSexo();
        List<String> listaTemas = TemasEnum.getListTemas();
        //Set object
        request.setAttribute("encuesta", existingEncuesta);
        //Set Lists
        request.setAttribute("deportes", listaDeporte);
        request.setAttribute("niveles", listaNivel);
        request.setAttribute("generos", listaGeneros);
        request.setAttribute("temas", listaTemas);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/View/Encuesta/encuestaForm.jsp");
        dispatcher.forward(request, response);
    }

    private void insertEncuesta(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        //Date
        Date fecha = Date.valueOf(LocalDate.now());
        //Time
        LocalTime horaNow = LocalTime.now();
        Time hora = Time.valueOf((horaNow.format(DateTimeFormatter.ofPattern("HH:mm:ss"))));
        //get session data
        HttpSession session = request.getSession();
        Usuario usuario = (Usuario) session.getAttribute("usuarioSession");
        int idusuario = usuario.getIdusuario();
        //get parameters
        String nombre = request.getParameter("nombre");
        String genero = request.getParameter("genero");
        String deporte = request.getParameter("deporte");
        String tema = request.getParameter("tema");
        String nivel = request.getParameter("nivel");

        Encuesta newEncuesta = new Encuesta(idusuario, nombre, genero, deporte, tema, nivel, fecha, hora);
        encuestaDao.insert(newEncuesta);
        //get session data
        boolean isAdmin = usuario.isAdmin();
        if (isAdmin){
            response.sendRedirect("listarEncuesta");
        }else {
            response.sendRedirect("verEncuesta");
        }
    }

    private void updateEncuesta(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        //Date
        Date fecha = Date.valueOf(LocalDate.now());
        //Time
        LocalTime horaNow = LocalTime.now();
        Time hora = Time.valueOf((horaNow.format(DateTimeFormatter.ofPattern("HH:mm:ss"))));
        //get session data
        HttpSession session = request.getSession();
        Usuario usuario = (Usuario) session.getAttribute("usuarioSession");
        int idusuario = usuario.getIdusuario();
        //get parameters
        int idencuesta = Integer.parseInt(request.getParameter("idencuesta"));
        String nombre = request.getParameter("nombre");
        String genero = request.getParameter("genero");
        String deporte = request.getParameter("deporte");
        String tema = request.getParameter("tema");
        String nivel = request.getParameter("nivel");

        Encuesta newEncuesta = new Encuesta(idencuesta, idusuario, nombre, genero, deporte, tema, nivel, fecha, hora);
        encuestaDao.edit(newEncuesta);
        response.sendRedirect("listarEncuesta");
    }

    private void deleteEncuesta(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int idencuesta = Integer.parseInt(request.getParameter("idencuesta"));
        encuestaDao.delete(idencuesta);
        response.sendRedirect("listarEncuesta");
    }
}
