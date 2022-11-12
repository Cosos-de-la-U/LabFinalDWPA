package Model;

import java.sql.Date;
import java.sql.Time;

public class Encuesta {
    private int idencuesta;
    private int idusuario;
    private String nombre;
    private String sexo;
    private String deporte;
    private String temafavorito;
    private String nivelestudio;
    private Date fecha;
    private Time hora;

    public Encuesta(int idencuesta, int idusuario, String nombre, String sexo, String deporte, String temafavorito, String nivelestudio, Date fecha, Time hora) {
        this.idencuesta = idencuesta;
        this.idusuario = idusuario;
        this.nombre = nombre;
        this.sexo = sexo;
        this.deporte = deporte;
        this.temafavorito = temafavorito;
        this.nivelestudio = nivelestudio;
        this.fecha = fecha;
        this.hora = hora;
    }

    public Encuesta(int idusuario, String nombre, String sexo, String deporte, String temafavorito, String nivelestudio, Date fecha, Time hora) {
        this.idusuario = idusuario;
        this.nombre = nombre;
        this.sexo = sexo;
        this.deporte = deporte;
        this.temafavorito = temafavorito;
        this.nivelestudio = nivelestudio;
        this.fecha = fecha;
        this.hora = hora;
    }

    public int getIdencuesta() {
        return idencuesta;
    }

    public void setIdencuesta(int idencuesta) {
        this.idencuesta = idencuesta;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDeporte() {
        return deporte;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }

    public String getTemafavorito() {
        return temafavorito;
    }

    public void setTemafavorito(String temafavorito) {
        this.temafavorito = temafavorito;
    }

    public String getNivelestudio() {
        return nivelestudio;
    }

    public void setNivelestudio(String nivelestudio) {
        this.nivelestudio = nivelestudio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }
}
