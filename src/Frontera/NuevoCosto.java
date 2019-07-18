package Frontera;

import Control.ValidarCosto;
import DAO.CostoDAO;
import Entidad.Costo;

public class NuevoCosto extends javax.swing.JPanel {

    private final CostoDAO daoCos = new CostoDAO();
    private final Costo costo = new Costo();
    private final ValidarCosto validar = new ValidarCosto();
    private final DialogoOK dialogoOk = new DialogoOK(null, true);

    private int filaU = 0;

    public NuevoCosto() {
        initComponents();
    }

    public boolean validarCampos() {
        return (costoTF.getText().isEmpty());
    }

    public void vaciarCampos() {
        comPer.setSelectedIndex(0);
        costoTF.setText("");
    }

    public void guardarDatos() {

        String respuesta;

        if ("Ninguna".equals(comPer.getSelectedItem().toString())) {
            costo.setPersona(0);

            respuesta = validar.validarCosto(costo);

            dialogoOk.textoLabel(respuesta);
            dialogoOk.visible();
        } else {
            costo.setPersona(Integer.parseInt(Character.toString(comPer.getSelectedItem().toString().charAt(0))));
            costo.setEstado(radEstado.isSelected());
            costo.setCostoAdi(costoAdiLabel.getText());
            costo.setCosto(Integer.parseInt(costoTF.getText()));

            respuesta = validar.validarCosto(costo);

            if ("Longitud mesa incorrecta".equals(respuesta)) {
                dialogoOk.textoLabel(respuesta);
                dialogoOk.visible();
            } else {
                if (!validarCampos()) {
                    if ("Longitud persona incorrecta".equals(respuesta)) {
                        dialogoOk.textoLabel(respuesta);
                        dialogoOk.visible();
                    } else if ("Longitud mesa incorrecta".equals(respuesta)) {
                        dialogoOk.textoLabel(respuesta);
                        dialogoOk.visible();
                    } else if ("Longitud turno incorrecta".equals(respuesta)) {
                        dialogoOk.textoLabel(respuesta);
                        dialogoOk.visible();
                    } else if ("Longitud entrada incorrecta".equals(respuesta)) {
                        dialogoOk.textoLabel(respuesta);
                        dialogoOk.visible();
                    } else if ("Longitud plato fuerte incorrecta".equals(respuesta)) {
                        dialogoOk.textoLabel(respuesta);
                        dialogoOk.visible();
                    } else if ("Longitud postre incorrecta".equals(respuesta)) {
                        dialogoOk.textoLabel(respuesta);
                        dialogoOk.visible();
                    } else if ("Longitud costo adicional incorrecta".equals(respuesta)) {
                        dialogoOk.textoLabel(respuesta);
                        dialogoOk.visible();
                    } else {
                        daoCos.crear(costo.getPersona(), costo.isEstado(), costo.getCostoAdi(), costo.getCosto());
                        vaciarCampos();
                        dialogoOk.textoLabel(respuesta);
                        dialogoOk.visible();
                    }
                } else {
                    dialogoOk.textoLabel("Por favor ingrese una comida");
                    dialogoOk.visible();
                }
            }
        }
    }

    public void editar(Costo cos, int fila) {

        comPer.setModel(daoCos.comboPer());
        radEstado.setSelected(cos.isEstado());
        costoAdiLabel.setText(cos.getCostoAdi());
        costoTF.setText(String.valueOf(cos.getCosto()));

        filaU = fila;
    }

    public void actualizar() {

        String respuesta;

        if ("Ninguna".equals(comPer.getSelectedItem().toString())) {
            costo.setPersona(0);

            respuesta = validar.validarCosto(costo);

            dialogoOk.textoLabel(respuesta);
            dialogoOk.visible();
        } else {
            costo.setPersona(Integer.parseInt(Character.toString(comPer.getSelectedItem().toString().charAt(0))));
            costo.setEstado(radEstado.isSelected());
            costo.setCostoAdi(costoAdiLabel.getText());
            costo.setCosto(Integer.parseInt(costoTF.getText()));

            respuesta = validar.validarCosto(costo);

            if ("Longitud mesa incorrecta".equals(respuesta)) {
                dialogoOk.textoLabel(respuesta);
                dialogoOk.visible();
            } else {
                if (!validarCampos()) {
                    if ("Longitud persona incorrecta".equals(respuesta)) {
                        dialogoOk.textoLabel(respuesta);
                        dialogoOk.visible();
                    } else if ("Longitud mesa incorrecta".equals(respuesta)) {
                        dialogoOk.textoLabel(respuesta);
                        dialogoOk.visible();
                    } else if ("Longitud turno incorrecta".equals(respuesta)) {
                        dialogoOk.textoLabel(respuesta);
                        dialogoOk.visible();
                    } else if ("Longitud entrada incorrecta".equals(respuesta)) {
                        dialogoOk.textoLabel(respuesta);
                        dialogoOk.visible();
                    } else if ("Longitud plato fuerte incorrecta".equals(respuesta)) {
                        dialogoOk.textoLabel(respuesta);
                        dialogoOk.visible();
                    } else if ("Longitud postre incorrecta".equals(respuesta)) {
                        dialogoOk.textoLabel(respuesta);
                        dialogoOk.visible();
                    } else if ("Longitud costo adicional incorrecta".equals(respuesta)) {
                        dialogoOk.textoLabel(respuesta);
                        dialogoOk.visible();
                    } else {
                        daoCos.editar(costo.getPersona(), costo.isEstado(), costo.getCostoAdi(), costo.getCosto(),filaU);
                        vaciarCampos();
                        dialogoOk.textoLabel(respuesta);
                        dialogoOk.visible();
                    }
                } else {
                    dialogoOk.textoLabel("Por favor ingrese una comida");
                    dialogoOk.visible();
                }
            }
        }
    }

    public void comboPer() {
        comPer.setVisible(false);
        comPer.removeAll();
        comPer.setModel(daoCos.comboPer());
        comPer.setVisible(true);
    }

    public void comboCos() {
        if ("Ninguna".equals(comPer.getSelectedItem().toString())) {
            costoAdiLabel.setText("");
        } else {
            String[] datos = daoCos.costo(Integer.parseInt(Character.toString(comPer.getSelectedItem().toString().charAt(0))));
            costoAdiLabel.setText(datos[0]);
        }
    }

    public void nuevoVisible() {
        guardar.setVisible(true);
        editarNuevo.setVisible(false);
    }

    public void editarVisible() {
        guardar.setVisible(false);
        editarNuevo.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        radEstado = new javax.swing.JRadioButton();
        costoTF = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        comPer = new javax.swing.JComboBox<>();
        editarNuevo = new javax.swing.JLabel();
        guardar = new javax.swing.JLabel();
        costoAdiLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(164, 186, 191));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(36, 56, 63));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Persona");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 200, 30));

        jLabel3.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(36, 56, 63));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Costo");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 200, 30));

        jLabel4.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(36, 56, 63));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Cancelado");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 200, 30));

        radEstado.setBackground(new java.awt.Color(164, 186, 191));
        add(radEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 113, 240, 30));

        costoTF.setBackground(new java.awt.Color(164, 186, 191));
        costoTF.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        costoTF.setForeground(new java.awt.Color(36, 56, 63));
        costoTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        costoTF.setBorder(null);
        add(costoTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 160, 240, 30));

        jSeparator4.setBackground(new java.awt.Color(36, 56, 63));
        add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 190, 240, 10));

        comPer.setBackground(new java.awt.Color(164, 186, 191));
        comPer.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        comPer.setForeground(new java.awt.Color(36, 56, 63));
        comPer.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comPerItemStateChanged(evt);
            }
        });
        add(comPer, new org.netbeans.lib.awtextra.AbsoluteConstraints(388, 60, 240, 30));

        editarNuevo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        editarNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/test.png"))); // NOI18N
        editarNuevo.setToolTipText("Actualizar");
        editarNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editarNuevo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editarNuevoMouseClicked(evt);
            }
        });
        add(editarNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 30, 70, 70));

        guardar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/clipboardM.png"))); // NOI18N
        guardar.setToolTipText("Guardar");
        guardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        guardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                guardarMouseClicked(evt);
            }
        });
        add(guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 470, 70, 70));

        costoAdiLabel.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        costoAdiLabel.setForeground(new java.awt.Color(36, 56, 63));
        costoAdiLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(costoAdiLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 210, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void comPerItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comPerItemStateChanged
        comboCos();
    }//GEN-LAST:event_comPerItemStateChanged

    private void editarNuevoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editarNuevoMouseClicked
        actualizar();
    }//GEN-LAST:event_editarNuevoMouseClicked

    private void guardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guardarMouseClicked
        guardarDatos();
    }//GEN-LAST:event_guardarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comPer;
    private javax.swing.JLabel costoAdiLabel;
    private javax.swing.JTextField costoTF;
    private javax.swing.JLabel editarNuevo;
    private javax.swing.JLabel guardar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JRadioButton radEstado;
    // End of variables declaration//GEN-END:variables
}
