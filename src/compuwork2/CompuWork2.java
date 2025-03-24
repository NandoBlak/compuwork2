package compuwork2;

/**
 *
 * @author Hernando
 */
import java.util.Scanner;

public class CompuWork2 {
    public static void main(String[] args) {
        SistemaGestion sistema = new SistemaGestion();
        Scanner lee = new Scanner(System.in);
        char opcion;

        do {
            System.out.println("Menú: \n"
                    + "1 -------> Empleados\n"
                    + "2 -------> Departamentos\n"
                    + "3 -------> Reportes de Desempeño\n"
                    + "4 -------> Imprimir empleados y departamentos\n"
                    + "5 -------> Salir");
            opcion = lee.nextLine().charAt(0);

            switch (opcion) {
                case '1': {
                    System.out.println("Menu/Empleados\n"
                            + "1 -------> Agregar empleado\n"
                            + "2 -------> Actualizar empleado\n"
                            + "3 -------> Eliminar empleado");
                    opcion = lee.nextLine().charAt(0);
                    switch (opcion) {
                        case '1': {
                            try {
                                System.out.println("Ingrese los siguientes datos:");
                                System.out.print("ID: ");
                                String id = lee.nextLine();
                                System.out.print("Nombre: ");
                                String nombre = lee.nextLine();
                                System.out.print("Departamento ID: ");
                                String departamentoId = lee.nextLine();
                                System.out.print("Tipo (Permanente o Temporal): ");
                                String tipo = lee.nextLine();
                                Empleado empleado = new Empleado(id, nombre, departamentoId, tipo);
                                sistema.agregarEmpleado(empleado);
                                System.out.println("Empleado agregado exitosamente.");
                            } catch (Exception e) {
                                System.out.println("Error al agregar empleado: " + e.getMessage());
                            }
                            break;
                        }
                        case '2': {
                            try {
                                System.out.println("Ingrese el ID del empleado a actualizar:");
                                String id = lee.nextLine();
                                System.out.print("Nuevo Nombre: ");
                                String nombre = lee.nextLine();
                                System.out.print("Nuevo Departamento ID: ");
                                String departamentoId = lee.nextLine();
                                System.out.print("Nuevo Tipo (Permanente o Temporal): ");
                                String tipo = lee.nextLine();
                                sistema.actualizarEmpleado(id, nombre, departamentoId, tipo);
                                System.out.println("Empleado actualizado exitosamente.");
                            } catch (Exception e) {
                                System.out.println("Error al actualizar empleado: " + e.getMessage());
                            }
                            break;
                        }
                        case '3': {
                            try {
                                System.out.println("Ingrese el ID del empleado a eliminar:");
                                String id = lee.nextLine();
                                sistema.eliminarEmpleado(id);
                                System.out.println("Empleado eliminado exitosamente.");
                            } catch (Exception e) {
                                System.out.println("Error al eliminar empleado: " + e.getMessage());
                            }
                            break;
                        }
                    }
                    break;
                }
                case '2': {
                    System.out.println("Menu/Departamentos\n"
                            + "1 -------> Agregar departamento\n"
                            + "2 -------> Eliminar departamento\n"
                            + "3 -------> Ver empleados por departamento");
                    opcion = lee.nextLine().charAt(0);
                    switch (opcion) {
                        case '1': {
                            try {
                                System.out.println("Ingrese los siguientes datos:");
                                System.out.print("ID: ");
                                String id = lee.nextLine();
                                System.out.print("Nombre: ");
                                String nombre = lee.nextLine();
                                System.out.print("Nombre del Jefe: ");
                                String nombreJefe = lee.nextLine();
                                Departamento departamento = new Departamento(id, nombre, nombreJefe);
                                sistema.agregarDepartamento(departamento);
                                System.out.println("Departamento agregado exitosamente.");
                            } catch (Exception e) {
                                System.out.println("Error al agregar departamento: " + e.getMessage());
                            }
                            break;
                        }
                        case '2': {
                            try {
                                System.out.println("Ingrese el ID del departamento a eliminar:");
                                String id = lee.nextLine();
                                sistema.eliminarDepartamento(id);
                                System.out.println("Departamento eliminado exitosamente.");
                            } catch (Exception e) {
                                System.out.println("Error al eliminar departamento: " + e.getMessage());
                            }
                            break;
                        }
                        case '3': {
                            try {
                                System.out.println("Ingrese el ID del departamento:");
                                String id = lee.nextLine();
                                Departamento departamento = sistema.getDepartamento(id);
                                if (departamento != null) {
                                    System.out.println("Empleados en el departamento " + departamento.getNombre() + ":");
                                    for (Empleado empleado : departamento.getEmpleados()) {
                                        System.out.println(empleado.getNombre());
                                    }
                                } else {
                                    System.out.println("Departamento no encontrado.");
                                }
                            } catch (Exception e) {
                                System.out.println("Error al obtener empleados del departamento: " + e.getMessage());
                            }
                            break;
                        }
                    }
                    break;
                }
                case '3': {
                    System.out.println("Menu/Reportes de Desempeño\n"
                            + "1 -------> Calificar empleado\n"
                            + "2 -------> Calificar departamento");
                    opcion = lee.nextLine().charAt(0);
                    switch (opcion) {
                        case '1': {
                            try {
                                System.out.println("Ingrese los siguientes datos:");
                                System.out.print("Código del reporte: ");
                                int codigo = lee.nextInt();
                                System.out.print("Calificación: ");
                                float calificacion = lee.nextFloat();
                                lee.nextLine(); // Consumir el salto de línea
                                System.out.print("Fecha: ");
                                String fecha = lee.nextLine();
                                System.out.print("ID del empleado: ");
                                String empleadoId = lee.nextLine();
                                Empleado empleado = sistema.getEmpleado(empleadoId);
                                if (empleado != null) {
                                    ReporteDesempeño reporte = new ReporteDesempeño(codigo, calificacion, fecha, true);
                                    sistema.generarReporteDesempeño(reporte);
                                    System.out.println("Reporte de desempeño generado exitosamente.");
                                } else {
                                    System.out.println("Empleado no encontrado.");
                                }
                            } catch (Exception e) {
                                System.out.println("Error al calificar empleado: " + e.getMessage());
                            }
                            break;
                        }
                        case '2': {
                            try {
                                System.out.println("Ingrese los siguientes datos:");
                                System.out.print("Código del reporte: ");
                                int codigo = lee.nextInt();
                                System.out.print("Calificación: ");
                                float calificacion = lee.nextFloat();
                                lee.nextLine(); // Consumir el salto de línea
                                System.out.print("Fecha: ");
                                String fecha = lee.nextLine();
                                System.out.print("ID del departamento: ");
                                String departamentoId = lee.nextLine();
                                Departamento departamento = sistema.getDepartamento(departamentoId);
                                if (departamento != null) {
                                    ReporteDesempeño reporte = new ReporteDesempeño(codigo, calificacion, fecha, false);
                                    sistema.generarReporteDesempeño(reporte);
                                    System.out.println("Reporte de desempeño generado exitosamente.");
                                } else {
                                    System.out.println("Departamento no encontrado.");
                                }
                            } catch (Exception e) {
                                System.out.println("Error al calificar departamento: " + e.getMessage());
                            }
                            break;
                        }
                    }
                    break;
                }
                case '4': {
                    try {
                        System.out.println("Empleados y sus respectivos departamentos:");
                        for (Empleado empleado : sistema.getEmpleados().values()) {
                            Departamento departamento = sistema.getDepartamento(empleado.getDepartamentoId());
                            String nombreDepartamento = (departamento != null) ? departamento.getNombre() : "Sin departamento";
                            System.out.println("Empleado: " + empleado.getNombre() + ", Departamento: " + nombreDepartamento);
                        }
                    } catch (Exception e) {
                        System.out.println("Error al imprimir empleados y departamentos: " + e.getMessage());
                    }
                    break;
                }
                case '5': {
                    System.out.println("Saliendo del sistema...");
                    break;
                }
                default: {
                    System.out.println("Opción no válida. Intente de nuevo.");
                }
            }
        } while (opcion != '5');
    }
}