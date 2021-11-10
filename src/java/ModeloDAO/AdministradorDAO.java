package ModeloDAO;

import Configuracion.Conexion;
import Interfaces.metodoAdministrador;
import Modelo.Administrador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdministradorDAO implements metodoAdministrador {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Administrador admi;

    public Administrador validar(String admin_cod, String admin_pass) {

        Administrador admi = new Administrador();
        String sql = "select * from administrador where admin_cod=? and admin_password=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, admin_cod);
            ps.setString(2, admin_pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                admi.setAdmin_cod(rs.getString("admin_cod"));
                admi.setAdmin_nombre(rs.getString("admin_nombre"));
                admi.setAdmin_apepat(rs.getString("admin_apepat"));
                admi.setAdmin_apemat(rs.getString("admin_apemat"));
                admi.setAdmin_fec_ing(rs.getDate("admin_fec_ing").toString());
                admi.setAdmin_password(rs.getString("admin_password"));
                admi.setAdmin_estado(rs.getString("admin_estado"));
            }

        } catch (Exception e) {
        }
        return admi;
    }

    @Override
    public void agregar(Administrador admi) {
        try {
            String sql = "insert into administrador (admin_cod , admin_nombre , admin_apepat , admin_apemat , admin_fec_ing ,LOC, admin_password ,admin_estado ) values (?,?,?,?,?,?,?,?)";
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, admi.getAdmin_cod());
            ps.setString(2, admi.getAdmin_nombre());
            ps.setString(3, admi.getAdmin_apepat());
            ps.setString(4, admi.getAdmin_apemat());
            ps.setString(5, admi.getAdmin_fec_ing());
            ps.setString(6, admi.getLOC());
            ps.setString(7, admi.getAdmin_estado());
            ps.setString(8, admi.getAdmin_password());
            ps.executeUpdate();
        } catch (SQLException ex) {
        }
    }

    @Override
    public boolean editar(String admin_cod) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(String admin_cod) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Administrador listar(String admin_cod, String admin_pass) {
        try {
            String sql = "Select * From administrador where admin_cod='" + admin_cod + "' and admin_password='" + admin_pass + "'";
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                admi = new Administrador();
                admi.setAdmin_cod(rs.getString("admin_cod"));
                admi.setAdmin_nombre(rs.getString("admin_nombre"));
                admi.setAdmin_apepat(rs.getString("admin_apepat"));
                admi.setAdmin_apemat(rs.getString("admin_apemat"));
                admi.setAdmin_fec_ing(rs.getDate("admin_fec_ing").toString());
                admi.setAdmin_password(rs.getString("admin_password"));
                admi.setAdmin_estado(rs.getString("admin_estado"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdministradorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return admi;
    }

    @Override
    public Administrador recuperarClave(String email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int recuperarId(String email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Administrador> listarTodoAdministrador() {

        ArrayList<Administrador> lista = new ArrayList<>();
        try {
            String sql = "select * from administrador";
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Administrador admin = new Administrador();
                admin.setAdmin_cod(rs.getString(1));
                admin.setAdmin_nombre(rs.getString(2));
                admin.setAdmin_apepat(rs.getString(3));
                admin.setAdmin_apemat(rs.getString(4));
                admin.setAdmin_fec_ing(rs.getString(5));
                admin.setLOC(rs.getString(6));
                admin.setAdmin_password(rs.getString(7));
                admin.setAdmin_estado(rs.getString(8));
                lista.add(admin);
            }
        } catch (SQLException e) {
        }

        return lista;
    }

    @Override
    public int nuevoAdministrador() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Administrador listaCodAdmi(String codadmi) {
        Administrador adminis = new Administrador();
        String sql = "select * from administrador where admin_cod=" + codadmi;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                adminis.setAdmin_cod(rs.getString(1));
                adminis.setAdmin_nombre(rs.getString(2));
                adminis.setAdmin_apepat(rs.getString(3));
                adminis.setAdmin_apemat(rs.getString(4));
                adminis.setAdmin_fec_ing(rs.getString(5));
                adminis.setAdmin_estado(rs.getString(6));

            }
        } catch (Exception e) {
        }
        return adminis;

    }
}
