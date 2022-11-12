package Interfaces;

import Model.DatosDeportes;
import Model.DatosGenero;
import Model.Encuesta;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public interface iEncuesta {
    public Encuesta select(int id);
    public List<Encuesta> selectAll();
    public List<Encuesta> selectAllFecha(Date fecha);
    public DatosGenero selectAllDatosGenero() throws SQLException;
    public DatosDeportes selectAllDatosDeportes() throws SQLException;
    public void insert(Encuesta encuesta) throws SQLException;
    public boolean edit(Encuesta encuesta) throws SQLException;
    public boolean delete(int id) throws SQLException;
}
