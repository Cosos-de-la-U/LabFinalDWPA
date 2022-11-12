package Enum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public enum SexoEnum {
    FEMALE("Femenino"),
    MALE("Masculino");


    private final String sexo;
    private static final List<String> listSexo;

    SexoEnum(String sexo){
        this.sexo = sexo;
    }

    static {
        listSexo = new ArrayList<>();
        for (SexoEnum sexoEnum : SexoEnum.values()) {
            listSexo.add(sexoEnum.getSexo());
        }
    }

    public String getSexo(){
        return sexo;
    }

    public static List<String> getListSexo(){
        return Collections.unmodifiableList(listSexo);
    }
}
