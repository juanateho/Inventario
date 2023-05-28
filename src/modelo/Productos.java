package modelo;

/**
 *
 * @author juana
 */
public class Productos {

    private String nombre;
    private String descripcion;
    private String precio;
    private String proveedor;
    private String tipo;
    private String unidades;


   /*public String toCSV() {
        return this.nombre + "," + this.descripcion + "," + this.precio + "," + this.proveedor + "," + this.tipo + "," + this.unidades;
    }*/

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

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getUnidades() {
        return unidades;
    }

    public void setUnidades(String unidades) {
        this.unidades = unidades;
    }

}
