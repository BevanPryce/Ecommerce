/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import Configuracion.Conexion;
import Interfaces.metodoCliente;
import Modelo.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mrang
 */
public class ClienteDAO implements metodoCliente{
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Cliente cli;
    
    
    @Override
    public void agregar(Cliente cli) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try{
            String sql="insert into clientes(cli_codigo, cli_nombre, cli_apepat, cli_apemat, cli_doi, cli_direccion, cli_distrito, cli_telefono, cli_email, cli_password) "
            + "values('"+cli.getCli_codigo()+"', '"+cli.getCli_nombre()+"', '"+cli.getCli_apepat()+"', '"+cli.getCli_apemat()+"', '"+cli.getCli_doi()+"','"+cli.getCli_direccion()+"','"+cli.getCli_distrito()+"','"+cli.getCli_telefono()+"','"+cli.getCli_email()+"','"+cli.getCli_password()+"')";
        con=cn.getConnection();
        ps=con.prepareStatement(sql);
        ps.executeUpdate();
        }
        catch(SQLException ex){ 
        }
    }

    @Override
    public boolean editar(String cli_codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(String cli_codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cliente listar(String email, String passw) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try{
            String sql ="Select * From clientes where cli_email='"+email+"' and cli_password='"+passw+"'" ;
            con = cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                cli =new Cliente();
                cli.setCli_codigo(rs.getString("cli_codigo"));
                cli.setCli_nombre(rs.getString("cli_nombre"));
                cli.setCli_apepat(rs.getString("cli_apepat"));
                cli.setCli_apemat(rs.getString("cli_apemat"));
                cli.setCli_doi(rs.getString("cli_doi"));
                cli.setCli_direccion(rs.getString("cli_direccion"));
                cli.setCli_distrito(rs.getString("cli_distrito"));
                cli.setCli_telefono(rs.getString("cli_telefono"));
                cli.setCli_email(rs.getString("cli_email"));
                cli.setCli_password(rs.getString("cli_password"));
            }
        }
        catch(SQLException ex){
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cli;
    }

    @Override
    public Cliente recuperarClave(String email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int recuperarId(String email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Cliente> listarTodoCliente() {
       
        ArrayList<Cliente> lista = new ArrayList<>();
        try {
            String sql = "select * from clientes";
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cliente cli = new Cliente();
                cli.setCli_codigo(rs.getString(1));
                cli.setCli_nombre(rs.getString(2));
                cli.setCli_apepat(rs.getString(3));
                cli.setCli_apemat(rs.getString(4));
                cli.setCli_doi(rs.getString(5));
                cli.setCli_direccion(rs.getString(6));
                cli.setCli_distrito(rs.getString(7));
                cli.setCli_telefono(rs.getString(8));
                cli.setCli_email(rs.getString(9));
                cli.setCli_password(rs.getString(10));
                lista.add(cli);

            }
        } catch (SQLException e) {
        }

        return lista;
    }

    @Override
    public int nuevoCliente() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Cliente> listarClientes() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        ArrayList<Cliente> lista = new ArrayList<>();
        try {
            String sql = "select * from clientes";
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cliente cli = new Cliente();
                cli.setCli_codigo(rs.getString(1));
                cli.setCli_nombre(rs.getString(2));
                cli.setCli_apepat(rs.getString(3));
                cli.setCli_apemat(rs.getString(4));
                cli.setCli_doi(rs.getString(5));
                cli.setCli_direccion(rs.getString(6));
                cli.setCli_distrito(rs.getString(7));
                cli.setCli_telefono(rs.getString(8));
                cli.setCli_email(rs.getString(9));
                cli.setCli_password(rs.getString(10));
                lista.add(cli);

            }
        } catch (SQLException e) {
        }

        return lista;
    }
    
}
