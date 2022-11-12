package Model;

public class Usuario {
    private int idusuario;
    private String nickname;
    private String clave;
    private boolean admin;

    public Usuario(int idusuario, String nickname, String clave, boolean admin) {
        this.idusuario = idusuario;
        this.nickname = nickname;
        this.clave = clave;
        this.admin = admin;
    }
    public Usuario(int idusuario, String nickname, String clave) {
        this.idusuario = idusuario;
        this.nickname = nickname;
        this.clave = clave;
    }

    public Usuario(String nickname, String clave, boolean admin) {
        this.nickname = nickname;
        this.clave = clave;
        this.admin = admin;
    }

    public Usuario(String nickname, String clave) {
        this.nickname = nickname;
        this.clave = clave;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
