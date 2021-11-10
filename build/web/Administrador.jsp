
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous"> 
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css" integrity="sha512-YWzhKL2whUzgiheMoBFwW8CKV4qpHQAEuvilg9FAn5VJUDwKZZxkJNuGM4XkWuk94WCrrwslk8yWNGmY1EduTA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">


        <!-- <link rel="stylesheet" type="text/css" href="Estilos/estilos.css"/>-->
        <link rel="stylesheet" type="text/css" href="Estilos/estilosindex.css"/>
        <script type="text/javascript" src="Js/codigo.js"></script> 
        <title>Technology Networks</title>
    </head>
    <body>
        <div>
            <div class="d-flex">
                <div class="card col-sm-2">
                    <form action="Control?accion=Administrador" method="POST">
                        <div class="form-group">
                            <label>Codigo</label>
                            <input type="text"  name="txtCod_Admi" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Nombre</label>
                            <input type="text" name="txtNom_Admi" class="form-control">
                        </div>

                        <div class="form-group">
                            <label>Paterno</label>
                            <input type="text" name="txtApe_Pat_Admi" class="form-control">
                        </div>

                        <div class="form-group">
                            <label>Materno</label>
                            <input type="text" name="txtApe_Mat_Admi" class="form-control">
                        </div>

                        <div class="form-group">
                            <label>Fecha de Ingreso</label>
                            <input type="text" name="txtFechaIngreso" class="form-control">
                        </div>

                        <div class="form-group">
                            <label>LOC</label>
                            <input type="text" name="txtLoc" class="form-control">
                        </div>

                        <div class="form-group">
                            <label>Contraseña</label>
                            <input type="text" name="txtpass" class="form-control">
                        </div>

                        <div class="form-group">
                            <label>Estado</label>
                            <input type="text" name="txtEstado" class="form-control">
                        </div>

                        <input type="submit" name="menu" value="Agregar"  class="btn btn-info">

                    </form>
                </div>

                <div class="col-sm-10">
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th>CODIGO</th>
                                <th>NOMBRE</th>
                                <th>PATERNO</th>
                                <th>MATERNO</th>
                                <th>FECHA INGRESO</th>
                                <th>LOC</th>
                                <th>CONTRASEÑA</th>
                                <th>ESTADO</th>

                            </tr>
                        </thead>
                        <tbody>

                            <c:forEach var="admi" items="${Administrador}">
                                <tr>
                                    <td>${admi.getAdmin_cod()}</td>
                                    <td>${admi.getAdmin_nombre()}</td>
                                    <td>${admi.getAdmin_apepat()}</td>
                                    <td>${admi.getAdmin_apemat()}</td>
                                    <td>${admi.getAdmin_fec_ing()}</td>
                                    <td>${admi.getLOC()}</td>
                                    <td>${admi.getAdmin_password()}</td>
                                    <td>${admi.getAdmin_estado()}</td>

                                    <td>
                                        <a class="btn btn-warning" href="Control&accion=Administrador&menu=Editar&admin_cod=${admi.getAdmin_cod()}">Editar</a>
                                        <a class="btn btn-danger">Eliminar</a>
                                    </td>
                                </tr>
                            </c:forEach>  

                        </tbody>
                    </table>

                </div>
            </div>


        </div>

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
