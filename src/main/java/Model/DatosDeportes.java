package Model;

public class DatosDeportes {
    private int Futbol;
    private int Basketball;
    private int Jockey;
    private int Baseball;
    private int Golf;

    public DatosDeportes(int futbol, int basketball, int jockey, int baseball, int golf) {
        Futbol = futbol;
        Basketball = basketball;
        Jockey = jockey;
        Baseball = baseball;
        Golf = golf;
    }

    public int getFutbol() {
        return Futbol;
    }

    public void setFutbol(int futbol) {
        Futbol = futbol;
    }

    public int getBasketball() {
        return Basketball;
    }

    public void setBasketball(int basketball) {
        Basketball = basketball;
    }

    public int getJockey() {
        return Jockey;
    }

    public void setJockey(int jockey) {
        Jockey = jockey;
    }

    public int getBaseball() {
        return Baseball;
    }

    public void setBaseball(int baseball) {
        Baseball = baseball;
    }

    public int getGolf() {
        return Golf;
    }

    public void setGolf(int golf) {
        Golf = golf;
    }
}
