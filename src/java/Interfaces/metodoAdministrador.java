
package Interfaces;

import Modelo.Administrador;
import java.util.ArrayList;


public interface metodoAdministrador {
    public void agregar(Administrador admi); //public boolean agregar(Producto idProducto);
    public boolean editar(String admin_cod);
    public boolean eliminar(String admin_cod);
    public Administrador listar(String admin_cod, String admin_pass);
    public Administrador recuperarClave(String email);
    public int recuperarId(String email);
    public ArrayList<Administrador>listarTodoAdministrador();
    public int nuevoAdministrador();
}
