package DAO;

import Conexion.Conexion;
import Frontera.FramePrincipal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class CostoDAO {

    Conexion con = new Conexion();
    Connection Conectado = con.conectar("root", "17111996");

    public void crear(int persona, boolean estado, String costoAdi, int costo) {
        String sqlAsi = "INSERT INTO COSTO(idPer, estado, costoAdi, valor) VALUES (?,?,?,?)";

        try {
            try (PreparedStatement ps = Conectado.prepareStatement(sqlAsi)) {
                ps.setInt(1, persona);
                ps.setBoolean(2, estado);
                ps.setString(3, costoAdi);
                ps.setInt(4, costo);
                ps.execute();
            }

        } catch (SQLException ex) {
            Logger.getLogger(FramePrincipal.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    public DefaultTableModel ver() {
        DefaultTableModel menTa = new DefaultTableModel();

        menTa.addColumn("ID");
        menTa.addColumn("Persona");
        menTa.addColumn("Estado");
        menTa.addColumn("Comida");
        menTa.addColumn("Valor");

        String sqlRes = "SELECT cosID, PERSONA.nombre, estado, costoAdi, valor FROM COSTO "
                + "INNER JOIN PERSONA ON aplicacionrestaurante.PERSONA.perID = aplicacionrestaurante.COSTO.idPer ";

        String[] dataRes = new String[5];

        try {
            Statement bcuSta = Conectado.createStatement();
            ResultSet bcuRts = bcuSta.executeQuery(sqlRes);
            while (bcuRts.next()) {
                dataRes[0] = bcuRts.getString(1);
                dataRes[1] = bcuRts.getString(2);
                dataRes[2] = bcuRts.getString(3);
                dataRes[3] = bcuRts.getString(4);
                dataRes[4] = bcuRts.getString(5);
                menTa.addRow(dataRes);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FramePrincipal.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return menTa;
    }

    public void editar(int persona, boolean estado, String costoAdi, int costo, int id) {

        String sqlAsi = "UPDATE COSTO SET idPer= ?, estado = ?, costoAdi = ?, valor = ? WHERE cosID = ?;";

        try {
            PreparedStatement ps = Conectado.prepareStatement(sqlAsi);
            ps.setInt(1, persona);
            ps.setBoolean(2, estado);
            ps.setString(3, costoAdi);
            ps.setInt(4, costo);
            ps.setInt(5, id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(FramePrincipal.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    public DefaultComboBoxModel comboPer() {
        DefaultComboBoxModel menpCo = new DefaultComboBoxModel();

        menpCo.addElement("Ninguna");

        String sqlBar = "SELECT menpID, PERSONA.nombre FROM MENUP "
                + "INNER JOIN PERSONA ON aplicacionrestaurante.PERSONA.perID = aplicacionrestaurante.MENUP.idPer WHERE costoAdi != ''";

        String[] dataBar = new String[2];

        try {
            Statement barSQL = Conectado.createStatement();
            ResultSet barRts = barSQL.executeQuery(sqlBar);
            while (barRts.next()) {
                dataBar[0] = barRts.getString(1);
                dataBar[1] = barRts.getString(2);
                menpCo.addElement(dataBar[0] + ". " + dataBar[1]);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FramePrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return menpCo;
    }

    public String[] costo(int id) {

        String sqlDatos = "SELECT costoAdi FROM MENUP WHERE menpID = " + id;

        String[] dataRes = new String[1];

        try {
            Statement bcuSta = Conectado.createStatement();
            ResultSet bcuRts = bcuSta.executeQuery(sqlDatos);
            while (bcuRts.next()) {
                dataRes[0] = bcuRts.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FramePrincipal.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return dataRes;
    }

}
