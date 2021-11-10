
package Interfaces;

import Modelo.Producto;
import java.util.ArrayList;

public interface metodoProducto {
    public void agregar(Producto producto);
    public boolean editar(String pro_codigo);
    public boolean eliminar(String pro_codigo);
    public ArrayList<Producto>listar();
    public Producto listarProducto(String pro_codigo);
    public ArrayList<Producto>listarProductosporCategoria(int cat_codigo);
    
}
