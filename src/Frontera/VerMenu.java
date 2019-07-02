package Frontera;

import DAO.MenuDAO;
import Entidad.Menu;

public class VerMenu extends javax.swing.JPanel {

    private final MenuDAO daoMen = new MenuDAO();

    public VerMenu() {
        initComponents();
    }

    public void verMenu() {
        tableMen.setModel(daoMen.ver());
    }

    public Menu editarMenu(){
        Menu menu = new Menu();

        int rowSel = tableMen.getSelectedRow();
        if (rowSel >= 0) {
            menu.setRestaurante(tableMen.getValueAt(rowSel, 1).toString());
            menu.setDescripcion(tableMen.getValueAt(rowSel, 2).toString());
            menu.setComida1(tableMen.getValueAt(rowSel, 3).toString());
            menu.setComida2(tableMen.getValueAt(rowSel, 4).toString());
            menu.setComida3(tableMen.getValueAt(rowSel, 5).toString());
            menu.setComida4(tableMen.getValueAt(rowSel, 6).toString());
            menu.setComida5(tableMen.getValueAt(rowSel, 7).toString());
            menu.setComida6(tableMen.getValueAt(rowSel, 8).toString());
            menu.setComida7(tableMen.getValueAt(rowSel, 9).toString());
        }
        return menu;
    }
    
    public int fila() {
        int rowSel = tableMen.getSelectedRow();
        if (rowSel >= 0) {
            return Integer.parseInt(tableMen.getValueAt(rowSel, 0).toString());
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
        tableMen = new javax.swing.JTable();

        setBackground(new java.awt.Color(164, 186, 191));

        tableMen.setBackground(new java.awt.Color(36, 56, 63));
        tableMen.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 0, 14)); // NOI18N
        tableMen.setForeground(new java.awt.Color(192, 212, 216));
        tableMen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tableMen.setGridColor(new java.awt.Color(36, 56, 63));
        tableMen.setSelectionBackground(new java.awt.Color(164, 186, 191));
        tableMen.setSelectionForeground(new java.awt.Color(36, 56, 63));
        jScrollPane1.setViewportView(tableMen);

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
    private javax.swing.JTable tableMen;
    // End of variables declaration//GEN-END:variables
}
