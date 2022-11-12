package Interfaces;

import Model.Usuario;

import java.sql.SQLException;
import java.util.List;

public interface iUsuario {
    public Usuario select(int id);
    public List<Usuario> selectAll();
    public void insert(Usuario usuario) throws SQLException;
    public boolean edit(Usuario usuario) throws SQLException;
    public boolean delete(int id) throws SQLException;
}
