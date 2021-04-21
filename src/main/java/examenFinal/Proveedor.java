package examenFinal;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AlejandroNes
 */
public class Proveedor implements Serializable{
private static final long serialVersionUID=51L;
    private String razon_social;
    private String direccion;
    private int numero_tel;
    private List<Producto> lista_productos;
    
    public Proveedor() {
        lista_productos=new ArrayList<>();
    }
    public void mostrar_prov(){
        System.out.println("Razon social:"+this.razon_social);
        System.out.println("Direccion:"+this.direccion);
        System.out.println("Telefono:"+this.numero_tel);        
    }
    public void add_product(Producto p){
    if(p!=null){
    lista_productos.add(p);
    }
    else
            System.out.println("el producto es nulo");
    }

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getNumero_tel() {
        return numero_tel;
    }

    public void setNumero_tel(int numero_tel) {
        this.numero_tel = numero_tel;
    }

    public List<Producto> getLista_productos() {
        return lista_productos;
    }

    public void setLista_productos(List<Producto> lista_productos) {
        this.lista_productos = lista_productos;
    }
    
}
