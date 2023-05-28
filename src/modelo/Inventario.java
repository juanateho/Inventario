package modelo;

/**
 *
 * @author juana
 */
public class Inventario {

    private int id;
    private String nombre;
    private String descripcion;
    private String proveedor;
    private int unidades;

    public Inventario(int id, String nombre, String descripcion, String proveedor, int unidades) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.proveedor = proveedor;
        this.unidades = unidades;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    
}
