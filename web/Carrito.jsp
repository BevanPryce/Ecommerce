<%-- 
    Document   : Carrito
    Created on : 01/11/2021, 08:20:28 PM
    Author     : mrang
--%>

<%@page import="ModeloDAO.CarritoDAO"%>
<%@page import="Modelo.Carrito"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous"> 
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css" integrity="sha512-YWzhKL2whUzgiheMoBFwW8CKV4qpHQAEuvilg9FAn5VJUDwKZZxkJNuGM4XkWuk94WCrrwslk8yWNGmY1EduTA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">


        <!-- <link rel="stylesheet" type="text/css" href="Estilos/estilos.css"/>-->
        <link rel="stylesheet" type="text/css" href="Estilos/estilosindex.css"/>
        <script type="text/javascript" src="Js/codigo.js"></script> 
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Carrito de compras</h1>
        <table>
        <div>
            <tr>
            <td>Item</td> 
            <td>Producto</td> 
            <td>Descripcion</td> 
            <td>Cantidad</td> 
            <td>Precio unitario</td> 
            <td>Subtotal</td> 
            <td>Opcion</td> 
            </tr>
        </div>
        <div>
            <%
                
                CarritoDAO cDAO = new CarritoDAO();
                ArrayList<Carrito>listaCarrito= cDAO.listarCarrito();
                Carrito c;
                for(int i=0;i<listaCarrito.size();i++){
                    c= new Carrito();
                    c=listaCarrito.get(i);
                    %>
                    <tr>
                        <td>
                            <%= c.getItem() %>
                        </td>
                        <td>
                            <img src="ControladorImg?parametro=<%= c.getDescripcion_producto() %> " width="50" height="50">
                        </td>
                        <td>
                            <%= c.getDescripcion_producto() %>
                        </td>
                        <td>
                            <%= c.getCantidad() %>
                        </td>
                        <td>
                            <%= c.getPrecio_unitario_producto() %>
                        </td>
                        <td>
                            <%= c.getSubtotal() %>
                        </td>
                        <td>
                            <a href="#">Quitar</a>
                        </td>
                    </tr>
                <%}
            %>
        </div> 
        </table>
        <div>
            <a href="#>" class="btn btn-outline-info">Realizar Pago</a>
            <a href="Control?accion=home" class="btn btn-primary">Seguir Comprando</a>
        </div>
    </body>
</html>
