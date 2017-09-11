package entidades;

public class Club {
    private int id_club;
    private String nombre_club;
    private String clave;
    private String direccion;
    private String telefono;
    private String nombreAdministracion;
   

    /**
     * @return the nombre_club
     */
    public String getNombre_club() {
        return nombre_club;
    }

    /**
     * @param nombre_club the nombre_club to set
     */
    public void setNombre_club(String nombre_club) {
        this.nombre_club = nombre_club;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the nombreAdministracion
     */
    public String getNombreAdministracion() {
        return nombreAdministracion;
    }

    /**
     * @param nombreAdministracion the nombreAdministracion to set
     */
    public void setNombreAdministracion(String nombreAdministracion) {
        this.nombreAdministracion = nombreAdministracion;
    }

    /**
     * @return the clave
     */
    public String getClave() {
        return clave;
    }

    /**
     * @param clave the clave to set
     */
    public void setClave(String clave) {
        this.clave = clave;
    }

    /**
     * @return the id_club
     */
    public int getId_club() {
        return id_club;
    }

    /**
     * @param id_club the id_club to set
     */
    public void setId_club(int id_club) {
        this.id_club = id_club;
    }

}
