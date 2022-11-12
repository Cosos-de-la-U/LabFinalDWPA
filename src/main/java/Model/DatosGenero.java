package Model;

public class DatosGenero {
    private int femenino;
    private int masculino;

    public DatosGenero(int femenino, int masculino) {
        this.femenino = femenino;
        this.masculino = masculino;
    }

    public int getFemenino() {
        return femenino;
    }

    public void setFemenino(int femenino) {
        this.femenino = femenino;
    }

    public int getMasculino() {
        return masculino;
    }

    public void setMasculino(int masculino) {
        this.masculino = masculino;
    }
}
