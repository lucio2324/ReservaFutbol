package entidades;

public class Cancha {
    private String tamanio;
    private String superficie;
    private String foto;
    private String id_club;
    

    /**
     * @return the tamaño
     */
    public String getTamanio() {
        return tamanio;
    }

    /**
     * @param tamanio the tamaño to set
     */
    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }

    /**
     * @return the id_club
     */
    public String getId_club() {
        return id_club;
    }

    /**
     * @param id_club the id_club to set
     */
    public void setId_club(String id_club) {
        this.id_club = id_club;
    }

    /**
     * @return the superficie
     */
    public String getSuperficie() {
        return superficie;
    }

    /**
     * @param superficie the superficie to set
     */
    public void setSuperficie(String superficie) {
        this.superficie = superficie;
    }

    /**
     * @return the foto
     */
    public String getFoto() {
        return foto;
    }

    /**
     * @param foto the foto to set
     */
    public void setFoto(String foto) {
        this.foto = foto;
    }

 
}
