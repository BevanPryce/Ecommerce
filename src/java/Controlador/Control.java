package Controlador;

import Modelo.Producto;
import Modelo.Cliente;
import Modelo.Administrador;
import Modelo.Carrito;
import ModeloDAO.ProductoDAO;
import ModeloDAO.AdministradorDAO;
import ModeloDAO.CarritoDAO;
import ModeloDAO.ClienteDAO;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

@MultipartConfig
public class Control extends HttpServlet {

    // Instancia de cliente
    Cliente cli = new Cliente();
    ClienteDAO cliDAO = new ClienteDAO();

    // Instancia de Administrador 
    Administrador admin = new Administrador();
    AdministradorDAO adminDAO = new AdministradorDAO();

    // Instancia  de los Articulos
    ArrayList<Producto> productos = new ArrayList<>();
    ArrayList<Carrito> carrito = new ArrayList<>();
    ProductoDAO pDAO = new ProductoDAO();
    Producto p = new Producto();
    ArrayList<Carrito> listaCarrito = new ArrayList<>();
    ArrayList<Carrito> listarCar = new ArrayList<>();
    CarritoDAO cDAO = new CarritoDAO();
    Carrito c = new Carrito();

    String admi;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        String email;
        String pass;
        String paginaLogin = "Login.jsp";
        String paginaPrincipal = "Principal.jsp";
        String paginaRegistrarCliente = "RegistroCliente.jsp";
        String paginaAdministrador = "Administracion.jsp";
        String paginaCarrito = "Carrito.jsp";
        String acceso = null;
        //int item;
        double subtotal;
        int cantidad = 1;

        String action = request.getParameter("accion");
        String codigo = request.getParameter("codigo");
        //String codcat= request.getParameter("cod_cat");

        productos = pDAO.listar();

        if (action.equalsIgnoreCase("registrarse")) {
            acceso = paginaRegistrarCliente;
        }

        if (accion.equalsIgnoreCase("registrarProducto")) {
            String codpro = request.getParameter("txtCod_Pro");
            System.out.println("Codigo Producto: " + codpro);
            String desc = request.getParameter("txtDesc_Pro");
            System.out.println("Descripcion: " + desc);
            Double punit = Double.parseDouble(request.getParameter("txtPunit"));
            System.out.println("Precio unitario: " + punit);
            int cant = Integer.parseInt(request.getParameter("txtCantidad"));
            System.out.println("Cantidad: " + cant);
            int categ = Integer.parseInt(request.getParameter("categoria"));
            System.out.println("Cod.Categoria: " + categ);
            Part part = request.getPart("filefoto");
            System.out.println("Foto: " + part);
            InputStream inputstream = part.getInputStream();
            System.out.println("Foto: " + inputstream);
            p = new Producto();
            p.setPro_codigo(codpro);
            p.setPro_descripcion(desc);
            p.setPro_precio_unitario(punit);
            p.setPro_stock(cant);
            p.setCat_codigo(categ);
            p.setPro_img(inputstream);
            pDAO = new ProductoDAO();
            pDAO.agregar(p);
            request.getRequestDispatcher("Producto.jsp").forward(request, response);
        }

        String menu = request.getParameter("menu");

        if (action.equals("Administracion")) {
            request.getRequestDispatcher("Administracion.jsp").forward(request, response);
        }
        
        if(accion.equals("Producto")){
            request.getRequestDispatcher("Producto.jsp").forward(request, response);
        }

        if (accion.equals("Cliente")) {
            switch (menu) {
                case "Listar":
                    ArrayList<Cliente> lista = cliDAO.listarTodoCliente();
                    request.setAttribute("Cliente", lista);
                    break;
                case "Editar":
                    break;
            }
            request.getRequestDispatcher("Cliente.jsp").forward(request, response);
        }

        if (accion.equals("Administrador")) {
            switch (menu) {
                case "Listar":
                    ArrayList<Administrador> listaAdmi = adminDAO.listarTodoAdministrador();
                    request.setAttribute("Administrador", listaAdmi);
                    break;
                case "Agregar":
                    String codigo_cli = request.getParameter("txtCod_Admi");
                    String nombre_cli = request.getParameter("txtNom_Admi");
                    String apellido_pat_cli = request.getParameter("txtApe_Pat_Admi");
                    String apellido_mat_cli = request.getParameter("txtApe_Mat_Admi");
                    String fechaIngreso = request.getParameter("txtFechaIngreso");
                    String loc = request.getParameter("txtLoc");
                    String contrasena = request.getParameter("txtpass");
                    String estado = request.getParameter("txtEstado");

                    admin.setAdmin_cod(codigo_cli);
                    admin.setAdmin_nombre(nombre_cli);
                    admin.setAdmin_apepat(apellido_pat_cli);
                    admin.setAdmin_apemat(apellido_mat_cli);
                    admin.setAdmin_fec_ing(fechaIngreso);
                    admin.setLOC(loc);
                    admin.setAdmin_password(contrasena);
                    admin.setAdmin_estado(estado);
                    adminDAO.agregar(admin);

                    /*request.getRequestDispatcher("Control?accion=Administrador&menu=Listar").forward(request, response);*/

                    break;
                case "Editar":
                    admi = String.valueOf(request.getParameter("admin_cod")) ;
                    Administrador ad = adminDAO.listaCodAdmi(admi);
                    request.setAttribute("administrador", ad);
                    request.getRequestDispatcher("Control?accion=Administrador&menu=Listar").forward(request, response);
                    break;
            }
            request.getRequestDispatcher("Administrador.jsp").forward(request, response);
        }
        
        

        if (action.equalsIgnoreCase("home")) {
            int inicio = -1;
            //CarritoDAO cDAO = new CarritoDAO();
            //listarCar=cDAO.listarCarrito();
            //request.setAttribute("contador", listaCarrito.size());
            request.getRequestDispatcher("Control?accion=" +/*p.getCat_codigo()*/ inicio + "&contador=" + listaCarrito.size()).forward(request, response);
            acceso = paginaPrincipal;
        }

        if (action.equalsIgnoreCase("carrito")) {
            HttpSession sesion = request.getSession();
            if (sesion.getAttribute("cliente") == null) {
                acceso = paginaLogin;
            } else {
                acceso = paginaCarrito;
            }
        }

        if (action.equalsIgnoreCase("agregarCarrito")) {
            String codcat = request.getParameter("cod_cat");
            System.out.println("Codigo categoria.-." + codcat);
            int contador;
            int item = c.getItem();
            p = pDAO.listarProducto(codigo);
            //CarritoDAO cDAO=new CarritoDAO();
            if (cDAO.buscarProducto(p.getPro_descripcion()) == true) {
                c = cDAO.listarCarritoporDescripcion(p.getPro_descripcion());
                System.out.println("Cantidad: " + c.getCantidad());
                cantidad = cantidad + 1;
                subtotal = cantidad * p.getPro_precio_unitario();
                cDAO.actualizarCantidad(p.getPro_descripcion(), cantidad, subtotal);
                request.getRequestDispatcher("Control?accion=" +/*p.getCat_codigo()*/ codcat + "&contador=" + listaCarrito.size()).forward(request, response);
            } else {
                item = item + 1;
                c.setItem(item);
                c.setFoto(p.getPro_img());
                c.setCodigo_producto(codigo);
                c.setDescripcion_producto(p.getPro_descripcion());
                c.setCantidad(cantidad);
                c.setPrecio_unitario_producto(p.getPro_precio_unitario());
                subtotal = cantidad * p.getPro_precio_unitario();
                c.setSubtotal(subtotal);
                listaCarrito.add(c);
                cDAO.agregarCarrito(c);
                if (listaCarrito.isEmpty()) {
                    contador = 0;
                } else {
                    contador = listaCarrito.size();
                }
                request.getRequestDispatcher("Control?accion=" +/*p.getCat_codigo()*/ codcat + "&contador=" + contador).forward(request, response);
            }
        }

        if (action.equals("-1") || action.equals("1") || action.equals("2") || action.equals("3") || action.equals("4") || action.equals("5") || action.equals("6") || action.equals("7") || action.equals("8") || action.equals("9") || action.equals("10") || action.equals("11")) {
            request.setAttribute("cod_categoria", action);
            request.setAttribute("contador", listaCarrito.size());
            acceso = paginaPrincipal;
        }

        if (action.equalsIgnoreCase("login")) {
            try {

                email = (String) request.getParameter("email");
                pass = (String) request.getParameter("pass");

                cliDAO = new ClienteDAO();
                cli = cliDAO.listar(email, pass);

                adminDAO = new AdministradorDAO();
                admin = adminDAO.listar(email, pass);

                HttpSession sesion = request.getSession();

                if (cli == null && admin == null) {
                    acceso = paginaLogin;
                } else if (cli != null && sesion.getAttribute("cliente") == null) {
                    String nomcat = cli.getCli_nombre() + " " + cli.getCli_apepat() + " " + cli.getCli_apemat();
                    sesion.setAttribute("cliente", nomcat);
                    int cat = -1;
                    request.getRequestDispatcher("Control?accion=" + cat + "&contador=" + listaCarrito.size()).forward(request, response);
                } else if (admin != null && sesion.getAttribute("administrador") == null) {
                    String nomcat = admin.getAdmin_nombre() + " " + admin.getAdmin_apepat() + " " + admin.getAdmin_apemat();
                    String codadmin = admin.getAdmin_cod();
                    //String cargo = admin.getAdmin_cargo();

                    sesion.setAttribute("administrador", nomcat);
                    sesion.setAttribute("codigo_admin", codadmin);
                    //sesion.setAttribute("cargo", cargo);
                    acceso = paginaAdministrador;
                }

            } catch (Exception e) {
            }
        }

        if (action.equalsIgnoreCase("logout")) {
            try {
                System.out.println("Sesion iniciada: " + request.getSession());
                if (request.getSession() != null) {
                    request.getSession().invalidate();
                    acceso = paginaPrincipal;
                }
            } catch (Exception e) {
            }
        }

        RequestDispatcher rd = request.getRequestDispatcher(acceso);
        rd.forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
