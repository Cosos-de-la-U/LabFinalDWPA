package DB.Queries;

public class qUsuario {
    //BASIC
    public static final String SELECT_USUARIOS = "SELECT * FROM usuario WHERE idusuario = ?;";
    public static final String SELECT_ALL_USUARIOS = "SELECT * FROM usuario;";
    public static final String INSERT_USUARIOS = "INSERT INTO usuario(nickname, clave, admin) VALUES (?, ?, ?);";
    public static final String UPDATE_USUARIOS = "UPDATE  usuario SET nickname = ?, clave = ?, admin = ? WHERE idusuario = ?;";
    public static final String DELETE_USUARIOS = "DELETE FROM usuario WHERE idusuario = ?;";

    //VIEW


    //EXTRA
    public static final String SELECT_USUARIOS_LOGIN = "SELECT * FROM usuario WHERE nickname = ? AND clave = ?;";
}
