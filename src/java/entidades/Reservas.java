package entidades;

/**
 * 
 *
 * @author Vitalia Miranda
 */
public class Reservas {
    private String id_cliente;
    private String id_club;
    private String id_cancha;
    private String hora_hora;
    private String disponible_hora;
    private String diaSemana;
    private String dia_fecha;
    private String mes_fecha;
    private String ano_fecha;


    public String getId_cliente() {
        return id_cliente;
    }


    public void setId_cliente(String id_cliente) {
        this.id_cliente = id_cliente;
    }


    public String getId_club() {
        return id_club;
    }


    public void setId_club(String id_club) {
        this.id_club = id_club;
    }


    public String getId_cancha() {
        return id_cancha;
    }


    public void setId_cancha(String id_cancha) {
        this.id_cancha = id_cancha;
    }


    public String getHora_hora() {
        return hora_hora;
    }


    public void setHora_hora(String hora_hora) {
        this.hora_hora = hora_hora;
    }

 
    public String getDisponible_hora() {
        return disponible_hora;
    }


    public void setDisponible_hora(String disponible_hora) {
        this.disponible_hora = disponible_hora;
    }


    public String getDiaSemana() {
        return diaSemana;
    }


    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }


    public String getDia_fecha() {
        return dia_fecha;
    }


    public void setDia_fecha(String dia_fecha) {
        this.dia_fecha = dia_fecha;
    }

 
    public String getMes_fecha() {
        return mes_fecha;
    }


    public void setMes_fecha(String mes_fecha) {
        this.mes_fecha = mes_fecha;
    }


    public String getAno_fecha() {
        return ano_fecha;
    }


    public void setAno_fecha(String ano_fecha) {
        this.ano_fecha = ano_fecha;
    }
    
}
