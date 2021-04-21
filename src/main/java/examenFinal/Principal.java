package examenFinal;
import java.util.Scanner;

/**
 *
 * @author AlejandroNes
 */
public class Principal {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int opc = 0;
        boolean continuar = true;
        //instanciamos la clase OperacionesClienteTarjeta
        Operaciones obj = new Operaciones();
        
        do {
            System.out.println("----------------------------------------------");
            System.out.println("1.- Registrar proveedor y productos");
            System.out.println("2.- Listar productos de proveedor");
            System.out.println("3.- Comprar Producto");
            System.out.println("4.- Salir");
            System.out.println("");
            System.out.println("Digite una opción");
            System.out.println("----------------------------------------------");
            opc = leer.nextInt();
            switch (opc) {
                case 1:
                    obj.registro_prov();
                    break;                    
                case 2:
                    leer.nextLine();
                    System.out.println("ingrese nombre de PROVEEDOR");
                    String prov=leer.nextLine();
                    obj.productos_prov(prov);
                    break;                    
                case 3:
                    leer.nextLine();
                    System.out.println("que producto desea comprar?");
                    String prod=leer.nextLine();
                    obj.prov_prod_disp(prod);
                    break;                    
                default:
                    continuar = false;
                    break;
            }
        } while (continuar);
    }
    }

