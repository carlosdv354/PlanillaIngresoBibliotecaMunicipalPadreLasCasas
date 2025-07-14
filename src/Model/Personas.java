package Model;

public class Personas {
    private int id;
    private String nombre;
    private String rut;
    private String telefono;
    private String id_programa;
    private String nombre_progama;
    private String fecha;
 

    public Personas() {
    }

    public Personas(int id, String nombre, String rut, String telefono, String id_programa, String nombre_progama, String fecha) {
        this.id = id;
        this.nombre = nombre;
        this.rut = rut;
        this.telefono = telefono;
        this.id_programa = id_programa;
        this.nombre_progama = nombre_progama;
        this.fecha = fecha;
    }
    
    public  Personas(String nombre, String rut, String telefono, String id_programa) {
        this.nombre = nombre;
        this.rut = rut;
        this.telefono = telefono;
        this.id_programa = id_programa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getId_programa() {
        return id_programa;
    }

    public void setId_programa(String id_programa) {
        this.id_programa = id_programa;
    }

    public String getNombre_progama() {
        return nombre_progama;
    }

    public void setNombre_progama(String nombre_progama) {
        this.nombre_progama = nombre_progama;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

}
