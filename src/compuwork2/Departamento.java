package compuwork2;
/**
 *
 * @author Hernando
 */
import java.util.ArrayList;
import java.util.List;

public class Departamento {
    private String id;
    private String nombre;
    private String nombreJefe;
    private List<Empleado> empleados;

    public Departamento(String id, String nombre, String nombreJefe) {
        this.id = id;
        this.nombre = nombre;
        this.nombreJefe = nombreJefe;
        this.empleados = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNombreJefe() {
        return nombreJefe;
    }

    public void setNombreJefe(String nombreJefe) {
        this.nombreJefe = nombreJefe;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    public void eliminarEmpleado(Empleado empleado) {
        empleados.remove(empleado);
    }
}