package DAO;

import Interfaces.iLogin;
import Model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static DB.PostgresDriver.getConnection;
import static DB.PostgresDriver.printSQLException;
import static DB.Queries.qUsuario.SELECT_USUARIOS_LOGIN;

public class LoginDAO implements iLogin {
    @Override
    public Usuario logIn(String nicknameRequested, String claveRequested) {
        Usuario usuarioSession = null;
        //Establishing a connection
        try (Connection connection = getConnection();
             //Create statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USUARIOS_LOGIN);) {
            preparedStatement.setString(1, nicknameRequested.strip());//strip() to remove white-spaces at the beginning and end
            preparedStatement.setString(2, claveRequested);
            //Execute query
            ResultSet rs = preparedStatement.executeQuery();
            System.out.println(preparedStatement);
            //Proccess the ResultSet object
            while (rs.next()){
                int idusuario= rs.getInt("idusuario");
                String nickname = rs.getString("nickname");
                String clave = rs.getString("clave");
                boolean admin = rs.getBoolean("admin");
                //We create the object
                usuarioSession = new Usuario(idusuario, nickname, clave, admin);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return usuarioSession;
    }
}
