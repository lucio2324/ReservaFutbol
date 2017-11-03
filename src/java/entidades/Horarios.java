package entidades;

import java.util.List;


public class Horarios {
    private String cancha_id;
    private String descripcion;
    private List<String> horario_id;


    public String getCancha_id() {
        return cancha_id;
    }


    public void setCancha_id(String cancha_id) {
        this.cancha_id = cancha_id;
    }


    public String getDescripcion() {
        return descripcion;
    }


    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public List<String> getHorario_id() {
        return horario_id;
    }


    public void setHorario_id(List<String> horario_id) {
        this.horario_id = horario_id;
    }
    
    
    
}
