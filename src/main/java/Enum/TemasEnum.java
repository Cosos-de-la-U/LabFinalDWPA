package Enum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public enum TemasEnum {
    TV("Television"),
    COCINA("Cocina"),
    TECH("Tecnologia"),
    MUSIC("Musica"),
    SPORTS("Deportes");

    private final String temas;
    private static final List<String> listTemas;

    TemasEnum(String temas){
        this.temas = temas;
    }

    static {
        listTemas = new ArrayList<>();
        for (TemasEnum temasEnum : TemasEnum.values()) {
            listTemas.add(temasEnum.getTemas());
        }
    }

    public String getTemas(){
        return temas;
    }

    public static List<String> getListTemas(){
        return Collections.unmodifiableList(listTemas);
    }
}
