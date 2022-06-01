/*
 * Examen Entornos de desarrollo - Enunciado
 */

package Cheese;
/**
 * Imports del paquete
 */

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 
 * @author CES
 */
public class ListaProductos {

    /**
     * Estructura HashMap para almacenar los productos de la lista de productos
     * @see "HashMap java doc"
     */
    private HashMap<String, Producto> listaP = new HashMap();
    
    /**
     * Cuenta calculada con el número de productos contenidos en la lista
     */
    private static int n = 0;


    
    private int getN() {
        return n;
    }

    private void setN(int n) {
        this.n = n;
    }
    /**
     * Comprueba si la cadena pasada es valida ( no está vacía)
     * @param campo cadena a analizar
     * @return True: Cadena vacía, False: Cadena correcta
     */
    private boolean check_null(String campo){
    
        if (campo.replace(" ","") == "")  return true; else return false;
    }
    
    /**
     * 
     * @param prod Producto que queremos añadir
     * @return producto añadido
     */
    public Producto addProducto(Producto prod) {
        if (prod == null){
            return null;
        }
        if (listaP.containsKey(prod.getcode())) {
            // System.out.println("Producto con código duplicado");
            return null;
        }
        n++;
        this.setN(n);
        listaP.put(prod.getcode(), prod);
        return prod;
    }
    /**
     * 
     * @param codigo Codigo del producto que queremos elminiar
     * @return producto eliminado
     */

    public Producto eliminarProducto(String codigo) { 
       if( check_null(codigo)){
           return null;
       }
        Producto prod = buscarProducto(codigo);
        if (prod != null) {
        listaP.remove(codigo);
        n--;
        this.setN(n);
        }
        return prod;
    }
    /**
     * 
     * @param codigo código del producto que queremos buscar
     * @return código del producto buscado
     */

    public Producto buscarProducto(String codigo) { 
        if( check_null(codigo)){
           return null;
       }
        Producto prod = null;
      
        if (!listaP.containsKey(codigo)) {
            return prod;
        }
        else{
            return listaP.get(codigo);
        }
    }

    /**
     * 
     * @return listado de prodcutos
     */
    public ArrayList<Producto> getProductos() {
        ArrayList<Producto> prodsList = new ArrayList<>();
        prodsList.addAll(listaP.values());
        return prodsList;
    }
    
    /**
     * 
     * @return número total de productos
     */
    public int totalProductos(){
            return this.getN();
    }
}
