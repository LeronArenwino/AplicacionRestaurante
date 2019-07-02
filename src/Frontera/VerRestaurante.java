package Frontera;

import DAO.RestauranteDAO;
import Entidad.Restaurante;

public class VerRestaurante extends javax.swing.JPanel {

    private RestauranteDAO daoRes = new RestauranteDAO();

    public VerRestaurante() {
        initComponents();
    }

    public void verRestaurante() {
        tableRes.setModel(daoRes.ver());
    }

    public Restaurante editarRestaurante() {

        Restaurante restaurante = new Restaurante();

        int rowSel = tableRes.getSelectedRow();
        if (rowSel >= 0) {
            restaurante.setNombre(tableRes.getValueAt(rowSel, 1).toString());
            restaurante.setUbicacion(tableRes.getValueAt(rowSel, 2).toString());
            restaurante.setTipo(tableRes.getValueAt(rowSel, 3).toString());
            restaurante.setHorario(tableRes.getValueAt(rowSel, 4).toString());
        }
        return restaurante;
    }

    public int fila() {
        int rowSel = tableRes.getSelectedRow();
        if (rowSel >= 0) {
            return Integer.parseInt(tableRes.getValueAt(rowSel, 0).toString());
        }
        return 0;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableRes = new javax.swing.JTable();

        setBackground(new java.awt.Color(164, 186, 191));

        tableRes.setBackground(new java.awt.Color(36, 56, 63));
        tableRes.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 0, 14)); // NOI18N
        tableRes.setForeground(new java.awt.Color(192, 212, 216));
        tableRes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tableRes.setGridColor(new java.awt.Color(36, 56, 63));
        tableRes.setSelectionBackground(new java.awt.Color(164, 186, 191));
        tableRes.setSelectionForeground(new java.awt.Color(36, 56, 63));
        jScrollPane1.setViewportView(tableRes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(112, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 863, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(105, 105, 105))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(109, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableRes;
    // End of variables declaration//GEN-END:variables
}
