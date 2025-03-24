package compuwork2;
/**
 *
 * @author Hernando
 */
public class Empleado {
    private String id;
    private String nombre;
    private String departamentoId;
    private String tipo; // "Permanente" o "Temporal"

    public Empleado(String id, String nombre, String departamentoId, String tipo) {
        this.id = id;
        this.nombre = nombre;
        this.departamentoId = departamentoId;
        this.tipo = tipo;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDepartamentoId() {
        return departamentoId;
    }

    public void setDepartamentoId(String departamentoId) {
        this.departamentoId = departamentoId;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}