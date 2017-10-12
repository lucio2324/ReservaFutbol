package entidades;


public class Usuario {
    private String id_usuario;
    private String nombre_usuario;
    private String clave_usuario;
    private String rol_usuario;
    private String email_usuario;

    /**
     * @return the nombre_usuario
     */
    public String getNombre_usuario() {
        return nombre_usuario;
    }

    /**
     * @param nombre_usuario the nombre_usuario to set
     */
    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    /**
     * @return the clave_usuario
     */
    public String getClave_usuario() {
        return clave_usuario;
    }

    /**
     * @param clave_usuario the clave_usuario to set
     */
    public void setClave_usuario(String clave_usuario) {
        this.clave_usuario = clave_usuario;
    }

    /**
     * @return the rol_usuario
     */
    public String getRol_usuario() {
        return rol_usuario;
    }

    /**
     * @param rol_usuario the rol_usuario to set
     */
    public void setRol_usuario(String rol_usuario) {
        this.rol_usuario = rol_usuario;
    }

 

    /**
     * @return the id_usuario
     */
    public String getId_usuario() {
        return id_usuario;
    }

    /**
     * @param id_usuario the id_usuario to set
     */
    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    /**
     * @return the email_usuario
     */
    public String getEmail_usuario() {
        return email_usuario;
    }

    /**
     * @param email_usuario the email_usuario to set
     */
    public void setEmail_usuario(String email_usuario) {
        this.email_usuario = email_usuario;
    }



}
