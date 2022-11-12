package Enum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public enum NivelEnum {
    BASICO("Basico"),
    INTERMEDIO("Intermedio"),
    SUPERIOR("Superior");


    private final String nivel;
    private static final List<String> listNivel;

    NivelEnum(String nivel){
        this.nivel = nivel;
    }

    static {
        listNivel = new ArrayList<>();
        for (NivelEnum nivelEnum : NivelEnum.values()) {
            listNivel.add(nivelEnum.getNivel());
        }
    }

    public String getNivel(){
        return nivel;
    }

    public static List<String> getListNivel(){
        return Collections.unmodifiableList(listNivel);
    }
}
