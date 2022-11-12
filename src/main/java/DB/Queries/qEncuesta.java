package DB.Queries;

public class qEncuesta {
    //BASIC
    public static final String SELECT_ENCUESTAS = "SELECT * FROM encuesta WHERE idencuesta = ?;";
    public static final String SELECT_ALL_ENCUESTAS = "SELECT * FROM encuesta;";
    public static final String SELECT_ALL_ENCUESTAS_FECHA = "SELECT * FROM encuesta where fecha = ?;";
    public static final String INSERT_ENCUESTAS = "INSERT INTO encuesta(idusuario, nombre, sexo, deporte, temafavorito, nivelestudio, fecha, hora) VALUES (? ,?, ?, ?, ?, ?, ?, ?);";
    public static final String UPDATE_ENCUESTAS = "UPDATE encuesta SET nombre = ?, sexo = ?, deporte = ?, temafavorito = ?, nivelestudio = ?, fecha = ?, hora = ? WHERE idencuesta = ?;";
    public static final String DELETE_ENCUESTAS = "DELETE FROM encuesta WHERE idencuesta = ?;";

    //VIEW


    //EXTRA
    public static final String SELECT_ENCUESTAS_DATOS = "SELECT * FROM select_datos;";
    public static final String SELECT_ENCUESTAS_DATOS_DEPORTES = "SELECT * FROM select_datos_deportes;";

    public static final String SELECT_ENCUESTAS_USER = "SELECT * FROM encuesta WHERE idusuario = ?;";
}
