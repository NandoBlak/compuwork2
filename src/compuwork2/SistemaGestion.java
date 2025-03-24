package compuwork2;
/**
 *
 * @author Hernando
 */
import java.util.HashMap;
import java.util.Map;

public class SistemaGestion {
    private Map<String, Empleado> empleados;
    private Map<String, Departamento> departamentos;

    public SistemaGestion() {
        empleados = new HashMap<>();
        departamentos = new HashMap<>();
    }

    public void agregarEmpleado(Empleado empleado) {
        empleados.put(empleado.getId(), empleado);
        Departamento depto = departamentos.get(empleado.getDepartamentoId());
        if (depto != null) {
            depto.agregarEmpleado(empleado);
        }
    }

    public void eliminarEmpleado(String empleadoId) {
        Empleado empleado = empleados.remove(empleadoId);
        if (empleado != null) {
            Departamento depto = departamentos.get(empleado.getDepartamentoId());
            if (depto != null) {
                depto.eliminarEmpleado(empleado);
            }
        }
    }

    public void agregarDepartamento(Departamento departamento) {
        departamentos.put(departamento.getId(), departamento);
    }

    public void eliminarDepartamento(String departamentoId) {
        departamentos.remove(departamentoId);
    }

    public void actualizarEmpleado(String id, String nombre, String departamentoId, String tipo) {
        Empleado empleado = empleados.get(id);
        if (empleado != null) {
            empleado.setNombre(nombre);
            empleado.setDepartamentoId(departamentoId);
            empleado.setTipo(tipo);
        }
    }

    public Empleado getEmpleado(String id) {
        return empleados.get(id);
    }

    public Departamento getDepartamento(String id) {
        return departamentos.get(id);
    }

    public Map<String, Empleado> getEmpleados() {
        return empleados;
    }

    public void generarReporteDesempeño(ReporteDesempeño reporte) {
        System.out.println(reporte);
    }
}
