package DAO;

import Interfaces.iUsuario;
import Model.Usuario;
import org.apache.commons.lang3.StringUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static DB.PostgresDriver.getConnection;
import static DB.PostgresDriver.printSQLException;
import static DB.Queries.qUsuario.*;

public class UsuarioDAO implements iUsuario {

    @Override
    public Usuario select(int id) {
        Usuario usuario = null;
        //Establishing a connection
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USUARIOS)) {
            //Create statement
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            //Execute query
            ResultSet rs = preparedStatement.executeQuery();
            //Process ResultSet
            while (rs.next()) {
                int idusuario= rs.getInt("idusuario");
                String nickname = rs.getString("nickname");
                String clave = rs.getString("clave");
                boolean admin = rs.getBoolean("admin");
                //We create the object
                usuario = new Usuario(idusuario, nickname, clave, admin);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return usuario;
    }

    @Override
    public List<Usuario> selectAll() {
        List<Usuario> usuario = new ArrayList<>();
        //Establishing a connection
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USUARIOS)) {
            //Create statement
            System.out.println(preparedStatement);
            //Execute query
            ResultSet rs = preparedStatement.executeQuery();
            //Process ResultSet
            while (rs.next()) {
                int idusuario= rs.getInt("idusuario");
                String nickname = rs.getString("nickname");
                String clave = rs.getString("clave");
                boolean admin = rs.getBoolean("admin");
                //We create the object
                usuario.add(new Usuario(idusuario, nickname, clave, admin));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return usuario;
    }

    @Override
    public void insert(Usuario usuario) throws SQLException{
        System.out.println(INSERT_USUARIOS);
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USUARIOS);){

            //Preparing the query
            preparedStatement.setString(1, StringUtils.lowerCase(usuario.getNickname().strip()));
            preparedStatement.setString(2, usuario.getClave().strip());
            preparedStatement.setBoolean(3, false);
            //Execute statement
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public boolean edit(Usuario usuario) throws SQLException{
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USUARIOS);){
            System.out.println("Updated Categoria: " + preparedStatement);
            //Prepare query
            //Preparing the query
            preparedStatement.setString(1, StringUtils.lowerCase(usuario.getNickname().strip()));
            preparedStatement.setString(2, usuario.getClave().strip());
            preparedStatement.setBoolean(3, usuario.isAdmin());
            preparedStatement.setInt(4, usuario.getIdusuario());
            //Check is there is any changes
            rowUpdated = preparedStatement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    @Override
    public boolean delete(int id) throws SQLException{
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USUARIOS);){
            //Prepare query
            preparedStatement.setInt(1, id);
            //Check is there is any changes
            rowDeleted = preparedStatement.executeUpdate() > 0;
        }
        return rowDeleted;
    }
}
