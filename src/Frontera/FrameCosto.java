package Frontera;

public class FrameCosto extends javax.swing.JPanel {

    private final NuevoCosto nuevo = new NuevoCosto();
    private final VerCosto ver = new VerCosto();
    private final Dialogo dialogo = new Dialogo(null, true);
    private final DialogoOK dialogoOk = new DialogoOK(null, true);

    public FrameCosto() {
        initComponents();
        inicioCosto();
    }

    public void inicioCosto() {
        principalCosto.setVisible(false);
        principalCosto.removeAll();
        principalCosto.add(inicioCosto);
        principalCosto.setVisible(true);
        back.setVisible(false);
        editar.setVisible(false);
    }

    public void validarInicioCosto() {
        if (!nuevo.validarCampos()) {
            dialogo.textoLabel("¿Desea guardar los datos?");
            int selCon = dialogo.visible();
            if (selCon == 0) {
                principalCosto.setVisible(false);
                principalCosto.removeAll();
                principalCosto.add(inicioCosto);
                principalCosto.setVisible(true);
                back.setVisible(false);
                editar.setVisible(false);
                nuevo.vaciarCampos();
            }
        }
        if (nuevo.validarCampos()) {
            principalCosto.setVisible(false);
            principalCosto.removeAll();
            principalCosto.add(inicioCosto);
            principalCosto.setVisible(true);
            back.setVisible(false);
            editar.setVisible(false);
        }
    }

    public void nuevoCosto() {
        principalCosto.setVisible(false);
        principalCosto.removeAll();
        principalCosto.add(nuevo);
        principalCosto.setVisible(true);
        nuevo.comboPer();
        nuevo.vaciarCampos();
        back.setVisible(true);
        editar.setVisible(false);
        nuevo.nuevoVisible();
    }

    public void verCosto() {
        principalCosto.setVisible(false);
        principalCosto.removeAll();
        principalCosto.add(ver);
        principalCosto.setVisible(true);
        nuevo.comboPer();
        ver.verCosto();
        back.setVisible(true);
        editar.setVisible(true);
        nuevo.editarVisible();
    }

    public void editarCosto() {
        int temInt = ver.fila();
        if (temInt >= 1) {
            principalCosto.setVisible(false);
            principalCosto.removeAll();
            principalCosto.add(nuevo);
            principalCosto.setVisible(true);
            editar.setVisible(false);
            nuevo.editar(ver.editarCosto(), temInt);
        } else {
            dialogoOk.textoLabel("Por favor seleccione una fila");
            dialogoOk.visible();
        }
    }

    public void inicioPrincipal() {
        principalCosto.setVisible(false);
        principalCosto.removeAll();
        principalCosto.add(inicioCosto);
        principalCosto.setVisible(true);
        back.setVisible(false);
        editar.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tituloCosto = new javax.swing.JPanel();
        pedido = new javax.swing.JLabel();
        back = new javax.swing.JLabel();
        editar = new javax.swing.JLabel();
        principalCosto = new javax.swing.JPanel();
        inicioCosto = new javax.swing.JPanel();
        costoVerIcon = new javax.swing.JLabel();
        costoVerLabel = new javax.swing.JLabel();
        costoNuevaLabel = new javax.swing.JLabel();
        costoNuevaIcon = new javax.swing.JLabel();

        tituloCosto.setBackground(new java.awt.Color(68, 85, 89));
        tituloCosto.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pedido.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        pedido.setForeground(new java.awt.Color(164, 186, 191));
        pedido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pedido.setText("COSTO ADICIONAL");
        tituloCosto.add(pedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(71, 9, 940, 40));

        back.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/log-out.png"))); // NOI18N
        back.setToolTipText("Atrás");
        back.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backMouseClicked(evt);
            }
        });
        tituloCosto.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 40, 40));

        editar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/note.png"))); // NOI18N
        editar.setToolTipText("Editar");
        editar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editarMouseClicked(evt);
            }
        });
        tituloCosto.add(editar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1024, 10, 40, 40));

        principalCosto.setBackground(new java.awt.Color(19, 38, 35));
        principalCosto.setLayout(new java.awt.BorderLayout());

        inicioCosto.setBackground(new java.awt.Color(164, 186, 191));

        costoVerIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        costoVerIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/phone-bookB.png"))); // NOI18N
        costoVerIcon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        costoVerIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                costoVerIconMouseClicked(evt);
            }
        });

        costoVerLabel.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        costoVerLabel.setForeground(new java.awt.Color(36, 56, 63));
        costoVerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        costoVerLabel.setText("VER");
        costoVerLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        costoVerLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                costoVerLabelMouseClicked(evt);
            }
        });

        costoNuevaLabel.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        costoNuevaLabel.setForeground(new java.awt.Color(36, 56, 63));
        costoNuevaLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        costoNuevaLabel.setText("CREAR");
        costoNuevaLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        costoNuevaLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                costoNuevaLabelMouseClicked(evt);
            }
        });

        costoNuevaIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        costoNuevaIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/support-ticketB.png"))); // NOI18N
        costoNuevaIcon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        costoNuevaIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                costoNuevaIconMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout inicioCostoLayout = new javax.swing.GroupLayout(inicioCosto);
        inicioCosto.setLayout(inicioCostoLayout);
        inicioCostoLayout.setHorizontalGroup(
            inicioCostoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inicioCostoLayout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addGroup(inicioCostoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(inicioCostoLayout.createSequentialGroup()
                        .addComponent(costoNuevaIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(190, 190, 190)
                        .addComponent(costoVerIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(inicioCostoLayout.createSequentialGroup()
                        .addComponent(costoNuevaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(190, 190, 190)
                        .addComponent(costoVerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        inicioCostoLayout.setVerticalGroup(
            inicioCostoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inicioCostoLayout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addGroup(inicioCostoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(costoNuevaIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(costoVerIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(inicioCostoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(costoNuevaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(costoVerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        principalCosto.add(inicioCosto, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tituloCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 1080, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(principalCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 1080, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tituloCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(principalCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked
        validarInicioCosto();
    }//GEN-LAST:event_backMouseClicked

    private void editarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editarMouseClicked
        editarCosto();
    }//GEN-LAST:event_editarMouseClicked

    private void costoVerIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_costoVerIconMouseClicked
        verCosto();
    }//GEN-LAST:event_costoVerIconMouseClicked

    private void costoVerLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_costoVerLabelMouseClicked
        verCosto();
    }//GEN-LAST:event_costoVerLabelMouseClicked

    private void costoNuevaLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_costoNuevaLabelMouseClicked
        nuevoCosto();
    }//GEN-LAST:event_costoNuevaLabelMouseClicked

    private void costoNuevaIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_costoNuevaIconMouseClicked
        nuevoCosto();
    }//GEN-LAST:event_costoNuevaIconMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel back;
    private javax.swing.JLabel costoNuevaIcon;
    private javax.swing.JLabel costoNuevaLabel;
    private javax.swing.JLabel costoVerIcon;
    private javax.swing.JLabel costoVerLabel;
    private javax.swing.JLabel editar;
    private javax.swing.JPanel inicioCosto;
    private javax.swing.JLabel pedido;
    private javax.swing.JPanel principalCosto;
    private javax.swing.JPanel tituloCosto;
    // End of variables declaration//GEN-END:variables
}