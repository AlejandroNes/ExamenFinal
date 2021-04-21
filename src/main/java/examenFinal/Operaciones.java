package examenFinal;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AlejandroNes
 */
public class Operaciones {

    private Producto prod;
    private Proveedor prov;
    private List<Proveedor> lista_prov;
    private List<Proveedor> lista_prov_oferta;
    Scanner lee = new Scanner(System.in);

    public Operaciones() {
        crearDir();
        crearArch();
        lista_prov = new ArrayList<>();
    }

    public void registro_prov() {
        prov = new Proveedor();
        boolean y = true;
        System.out.println("Razon Social: ");
        String rs = lee.nextLine();
        prov.setRazon_social(rs);
        System.out.println("Dirección: ");
        String di = lee.nextLine();
        prov.setDireccion(di);
        System.out.println("Telefono: ");
        int te = lee.nextInt();
        prov.setNumero_tel(te);
        lee.nextLine();
        do {
            prod = new Producto();
            System.out.println("Producto: ");
            String n = lee.nextLine();
            prod.setNombre_producto(n);;
            System.out.println("Costo unitario: ");
            float cu = lee.nextFloat();
            prod.setCosto_unitario(cu);
            System.out.println("Stock: ");
            int st = lee.nextInt();
            prod.setStock(st);
            lee.nextLine();

            //añadiendo producto a proveedor
            prov.add_product(prod);
            guardar_datos();

            //seguir agregando productos
            System.out.println("desea seguir agregando productos?s/n");
            String resp = lee.nextLine();
            if (resp.equalsIgnoreCase("n")) {
                y = false;
            }
        } while (y);
        
            //añado el provedor a un lista
            lista_prov.add(prov);
            guardar_datos();
             }

    public void productos_prov(String nom) {
        lee_datos();
        for (Proveedor pv : lista_prov) {
            if (pv.getRazon_social().equalsIgnoreCase(nom)) {
                for (Producto pr : pv.getLista_productos()) {
                    pr.mortrar_producto();
                    break;
                }
            }
        }
    }

    public void prov_prod_disp(String p) {
        lee_datos();
        System.out.println("lista de proveedores con el producto");
        for (Proveedor pv : lista_prov) {
            for (Producto pr : pv.getLista_productos()) {
                if (pr.getNombre_producto().equalsIgnoreCase(p)) {
                    pv.mostrar_prov();
                }
            }
        }
        System.out.println("escriba nombre de provedor al que comprara producto");
        String com = lee.nextLine();
        comprar_prod(com, p);
    }

    public void comprar_prod(String prov, String prod) {
        for (Proveedor pv : lista_prov) {
            if (pv.getRazon_social().equalsIgnoreCase(prov)) {
                for (Producto pr : pv.getLista_productos()) {
                    if (pr.getNombre_producto().equalsIgnoreCase(prod)) {
                        pv.mostrar_prov();
                        pr.mortrar_producto();
                        System.out.println("cuantos comprara?");
                        int cant = lee.nextInt();
                        if (pr.getStock() > cant) {
                            int n_stock = pr.getStock() - cant;
                            pr.setStock(n_stock);
                        } else {
                            System.out.println("cantidad insufiente de deposito");
                        }
                    }
                }
            }
        }
        guardar_datos();
    }

/*
    operaciones de archivo, crear directorio,crear archivo.txt y guardar datos serializables que significa que 
    para el guardado de transformaran en binario y cuando se recuperaran se lo hara tamienen binario que luego 
    sera convertido a formato de programa
*/
    public void crearDir() {
        Path path;
        path = Paths.get("C:\\ProgramacionIII");
        try {
            if (!Files.exists(path)) {
                Files.createDirectory(path);
                System.out.println("directorio creado");
            } else {
                System.out.println("ya existe el directorio");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void crearArch() {
        Path path;
        path = Paths.get("C:\\ProgramacionIII\\Proveedor.txt");
        try {
            if (!Files.exists(path)) {
                Files.createFile(path);
                System.out.println("Archivo creado");
            } else {
                System.out.println("ya existe el Archivo");
                Files.write(path, "".getBytes(), StandardOpenOption.APPEND);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //guardadod e datos a binario

    public void guardar_datos() {
        String ruta = "C:\\ProgramacionIII\\Proveedor.txt";
        try {
            FileOutputStream arch = new FileOutputStream(ruta);
            ObjectOutputStream o = new ObjectOutputStream(arch);
            o.writeObject(lista_prov);
            o.close();
            arch.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //ctrl+chift+c comentar lineas
    //lectura de datos de archivo

    public void lee_datos() {
        String ruta = "C:\\ProgramacionIII\\Proveedor.txt";
        try {
            FileInputStream archivos = new FileInputStream(ruta);
            ObjectInputStream op = new ObjectInputStream(archivos);
            if (op != null) {
                lista_prov = (List<Proveedor>) op.readObject();
            } else {
                System.out.println("no hay ningun registro");
            }
        } catch (FileNotFoundException e) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, e);
        } catch (IOException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
