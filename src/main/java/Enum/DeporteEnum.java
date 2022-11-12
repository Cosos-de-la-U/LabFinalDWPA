package Enum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public enum DeporteEnum {
    FUTBOL("Futbol"),
    BASKETBALL("Basketball"),
    JOCKEY("Jockey"),
    BASEBALL("Baseball"),
    GOLF("Golf");


    private final String deporte;
    private static final List<String> listDeporte;

    DeporteEnum(String deporte){
        this.deporte = deporte;
    }

    static {
        listDeporte = new ArrayList<>();
        for (DeporteEnum deporteEnum : DeporteEnum.values()) {
            listDeporte.add(deporteEnum.getDeporte());
        }
    }

    public String getDeporte(){
        return deporte;
    }

    public static List<String> getListDeporte(){
        return Collections.unmodifiableList(listDeporte);
    }
}
