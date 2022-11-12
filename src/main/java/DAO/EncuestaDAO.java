package DAO;

import Interfaces.iEncuesta;
import Model.DatosDeportes;
import Model.DatosGenero;
import Model.Encuesta;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static DB.PostgresDriver.getConnection;
import static DB.PostgresDriver.printSQLException;
import static DB.Queries.qEncuesta.*;

public class EncuestaDAO implements iEncuesta {

    @Override
    public Encuesta select(int id) {
        Encuesta encuesta = null;
        //Establishing a connection
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ENCUESTAS)) {
            //Create statement
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            //Execute query
            ResultSet rs = preparedStatement.executeQuery();
            //Process ResultSet
            while (rs.next()) {
                int idencuesta= rs.getInt("idencuesta");
                int idusuario = rs.getInt("idusuario");
                String nombre = rs.getString("nombre");
                String sexo = rs.getString("sexo");
                String deporte = rs.getString("deporte");
                String temafavorito = rs.getString("temafavorito");
                String nivelestudio = rs.getString("nivelestudio");
                Date fecha = rs.getDate("fecha");
                Time hora = rs.getTime("hora");
                //We create the object
                encuesta = new Encuesta(idencuesta, idusuario, nombre, sexo, deporte, temafavorito, nivelestudio, fecha, hora);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return encuesta;
    }
    public Encuesta selectUser(int id) {
        Encuesta encuesta = null;
        //Establishing a connection
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ENCUESTAS_USER)) {
            //Create statement
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            //Execute query
            ResultSet rs = preparedStatement.executeQuery();
            //Process ResultSet
            while (rs.next()) {
                int idencuesta= rs.getInt("idencuesta");
                int idusuario = rs.getInt("idusuario");
                String nombre = rs.getString("nombre");
                String sexo = rs.getString("sexo");
                String deporte = rs.getString("deporte");
                String temafavorito = rs.getString("temafavorito");
                String nivelestudio = rs.getString("nivelestudio");
                Date fecha = rs.getDate("fecha");
                Time hora = rs.getTime("hora");
                //We create the object
                encuesta = new Encuesta(idencuesta, idusuario, nombre, sexo, deporte, temafavorito, nivelestudio, fecha, hora);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return encuesta;
    }

    @Override
    public List<Encuesta> selectAll() {
        List<Encuesta> encuesta = new ArrayList<>();
        //Establishing a connection
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ENCUESTAS)) {
            //Create statement
            System.out.println(preparedStatement);
            //Execute query
            ResultSet rs = preparedStatement.executeQuery();
            //Process ResultSet
            while (rs.next()) {
                int idencuesta= rs.getInt("idencuesta");
                int idusuario = rs.getInt("idusuario");
                String nombre = rs.getString("nombre");
                String sexo = rs.getString("sexo");
                String deporte = rs.getString("deporte");
                String temafavorito = rs.getString("temafavorito");
                String nivelestudio = rs.getString("nivelestudio");
                Date fecha = rs.getDate("fecha");
                Time hora = rs.getTime("hora");
                //We create the object
                encuesta.add(new Encuesta(idencuesta, idusuario, nombre, sexo, deporte, temafavorito, nivelestudio, fecha, hora));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return encuesta;
    }

    @Override
    public List<Encuesta> selectAllFecha(Date fechaRequested) {
        List<Encuesta> encuesta = new ArrayList<>();
        //Establishing a connection
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ENCUESTAS_FECHA)) {
            //Create statement
            preparedStatement.setDate(1, fechaRequested);
            System.out.println(preparedStatement);
            //Execute query
            ResultSet rs = preparedStatement.executeQuery();
            //Process ResultSet
            while (rs.next()) {
                int idencuesta= rs.getInt("idencuesta");
                int idusuario = rs.getInt("idusuario");
                String nombre = rs.getString("nombre");
                String sexo = rs.getString("sexo");
                String deporte = rs.getString("deporte");
                String temafavorito = rs.getString("temafavorito");
                String nivelestudio = rs.getString("nivelestudio");
                Date fecha = rs.getDate("fecha");
                Time hora = rs.getTime("hora");
                //We create the object
                encuesta.add(new Encuesta(idencuesta, idusuario, nombre, sexo, deporte, temafavorito, nivelestudio, fecha, hora));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return encuesta;
    }

    @Override
    public DatosGenero selectAllDatosGenero() throws SQLException {
        DatosGenero datos = null;
        //Establishing a connection
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ENCUESTAS_DATOS)) {
            //Create statement
            System.out.println(preparedStatement);
            //Execute query
            ResultSet rs = preparedStatement.executeQuery();
            //Process ResultSet
            while (rs.next()) {
                int femenino= rs.getInt("femenino");
                int masculino = rs.getInt("masculino");
                //We create the object
                datos = new DatosGenero(femenino, masculino);
            }
            System.out.println(datos.getFemenino() + " " + datos.getMasculino());
        } catch (SQLException e) {
            printSQLException(e);
        }
        return datos;
    }
    @Override
    public DatosDeportes selectAllDatosDeportes() throws SQLException {
        DatosDeportes datos = null;
        //Establishing a connection
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ENCUESTAS_DATOS_DEPORTES)) {
            //Create statement
            System.out.println(preparedStatement);
            //Execute query
            ResultSet rs = preparedStatement.executeQuery();
            //Process ResultSet
            while (rs.next()) {
                int futbol= rs.getInt("Futbol");
                int basketball = rs.getInt("Basketball");
                int jockey = rs.getInt("Jockey");
                int baseball = rs.getInt("Baseball");
                int golf = rs.getInt("Golf");
                //We create the object
                datos = new DatosDeportes(futbol, basketball, jockey, baseball, golf);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return datos;
    }

    @Override
    public void insert(Encuesta encuesta) throws SQLException{
        System.out.println(INSERT_ENCUESTAS);
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ENCUESTAS);){
            //Preparing the query
            preparedStatement.setInt(1, encuesta.getIdusuario());
            preparedStatement.setString(2, encuesta.getNombre());
            preparedStatement.setString(3, encuesta.getSexo());
            preparedStatement.setString(4, encuesta.getDeporte());
            preparedStatement.setString(5, encuesta.getTemafavorito());
            preparedStatement.setString(6, encuesta.getNivelestudio());
            preparedStatement.setDate(7, encuesta.getFecha());
            preparedStatement.setTime(8, encuesta.getHora());
            //Execute statement
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public boolean edit(Encuesta encuesta) throws SQLException{
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ENCUESTAS);){
            System.out.println("Updated Categoria: " + preparedStatement);
            //Prepare query
            //Preparing the query
            preparedStatement.setString(1, encuesta.getNombre());
            preparedStatement.setString(2, encuesta.getSexo());
            preparedStatement.setString(3, encuesta.getDeporte());
            preparedStatement.setString(4, encuesta.getTemafavorito());
            preparedStatement.setString(5, encuesta.getNivelestudio());
            preparedStatement.setDate(6, encuesta.getFecha());
            preparedStatement.setTime(7, encuesta.getHora());
            //id
            preparedStatement.setInt(8, encuesta.getIdencuesta());
            //Check is there is any changes
            rowUpdated = preparedStatement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    @Override
    public boolean delete(int id) throws SQLException{
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ENCUESTAS);){
            //Prepare query
            preparedStatement.setInt(1, id);
            //Check is there is any changes
            rowDeleted = preparedStatement.executeUpdate() > 0;
        }
        return rowDeleted;
    }
}
