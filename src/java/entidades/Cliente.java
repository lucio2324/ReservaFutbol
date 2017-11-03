package entidades;

public class Cliente {
    private String nombre_cliente;
    private String fechaNacimiento_cliente;
    private String telefono_cliente;
    private String mail_cliente;
    private String id_usuario;


    public String getNombre_cliente() {
        return nombre_cliente;
    }


    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }


    public String getFechaNacimiento_cliente() {
        return fechaNacimiento_cliente;
    }


    public void setFechaNacimiento_cliente(String fechaNacimiento_cliente) {
        this.fechaNacimiento_cliente = fechaNacimiento_cliente;
    }


    public String getTelefono_cliente() {
        return telefono_cliente;
    }


    public void setTelefono_cliente(String telefono_cliente) {
        this.telefono_cliente = telefono_cliente;
    }


    public String getMail_cliente() {
        return mail_cliente;
    }

    
    public void setMail_cliente(String mail_cliente) {
        this.mail_cliente = mail_cliente;
    }


    public String getId_usuario() {
        return id_usuario;
    }


    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }
     
}
