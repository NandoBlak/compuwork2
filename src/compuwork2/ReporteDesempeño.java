package compuwork2;
/**
 *
 * @author Hernando
 */
public class ReporteDesempeño {
    private int codigo;
    private float calificacion;
    private String fecha;
    private boolean reporteIndividual;

    public ReporteDesempeño(int codigo, float calificacion, String fecha, boolean reporteIndividual) {
        this.codigo = codigo;
        this.calificacion = calificacion;
        this.fecha = fecha;
        this.reporteIndividual = reporteIndividual;
    }

    public int getCodigo() {
        return codigo;
    }

    public float getCalificacion() {
        return calificacion;
    }

    public String getFecha() {
        return fecha;
    }

    public boolean isReporteIndividual() {
        return reporteIndividual;
    }

    @Override
    public String toString() {
        return "ReporteDesempeño{" +
                "codigo=" + codigo +
                ", calificacion=" + calificacion +
                ", fecha='" + fecha + '\'' +
                ", reporteIndividual=" + reporteIndividual +
                '}';
    }
}