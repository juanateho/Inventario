package modelo;

/**
 *
 * @author juana
 */
public class HistorialProductos {
    private int id;
    private String fecha;
    private int unidades;
    private String motivo;

    public HistorialProductos(int id, String fecha, int unidades, String motivo) {
        this.id = id;
        this.fecha = fecha;
        this.unidades = unidades;
        this.motivo = motivo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
}
