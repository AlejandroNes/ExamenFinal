package examenFinal;

import java.io.Serializable;

/**
 *
 * @author AlejandroNes
 */
public class Producto implements Serializable{
    private static final long serialVersionUID=50L; 
    private String nombre_producto;
    private float costo_unitario;
    private int stock;
    
    public void mortrar_producto(){
        System.out.println("......................................................");
        System.out.println("Producto:"+this.nombre_producto);
        System.out.println("Costo unitario:"+this.costo_unitario);
        System.out.println("Stock:"+this.stock);
        System.out.println(".......................................................");
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public float getCosto_unitario() {
        return costo_unitario;
    }

    public void setCosto_unitario(float costo_unitario) {
        this.costo_unitario = costo_unitario;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
}
