package Frontera;

public class FramePedido extends javax.swing.JPanel {

    private final NuevoPedido nuevo = new NuevoPedido();
    private final VerPedido ver = new VerPedido();
    private final Dialogo dialogo = new Dialogo(null, true);
    private final DialogoOK dialogoOk = new DialogoOK(null, true);

    public FramePedido() {
        initComponents();
        inicioPedido();
    }

    public void inicioPedido() {
        principalPedido.setVisible(false);
        principalPedido.removeAll();
        principalPedido.add(inicioPedido);
        principalPedido.setVisible(true);
        back.setVisible(false);
        editar.setVisible(false);
    }

    public void validarInicioPedido() {
        if (!nuevo.validarCampos()) {
            dialogo.textoLabel("¿Desea guardar los datos?");
            int selCon = dialogo.visible();
            if (selCon == 0) {
                principalPedido.setVisible(false);
                principalPedido.removeAll();
                principalPedido.add(inicioPedido);
                principalPedido.setVisible(true);
                back.setVisible(false);
                editar.setVisible(false);
                nuevo.vaciarCampos();
            }
        }
        if (nuevo.validarCampos()) {
            principalPedido.setVisible(false);
            principalPedido.removeAll();
            principalPedido.add(inicioPedido);
            principalPedido.setVisible(true);
            back.setVisible(false);
            editar.setVisible(false);
        }
    }

    public void nuevoPedido() {
        principalPedido.setVisible(false);
        principalPedido.removeAll();
        principalPedido.add(nuevo);
        principalPedido.setVisible(true);
        nuevo.timeLabel();
        nuevo.comboPer();
        nuevo.comboRes();
        nuevo.inhabilitarCom();
        nuevo.vaciarCampos();
        back.setVisible(true);
        editar.setVisible(false);
        nuevo.nuevoVisible();
    }

    public void verMenu() {
        principalPedido.setVisible(false);
        principalPedido.removeAll();
        principalPedido.add(ver);
        principalPedido.setVisible(true);
        ver.verMenu();
        nuevo.inhabilitarCom();
        nuevo.vaciarCom();
        back.setVisible(true);
        editar.setVisible(true);
        nuevo.editarVisible();
    }

    public void editarPedido() {
        int temInt = ver.fila();
        if (temInt >= 1) {
            principalPedido.setVisible(false);
            principalPedido.removeAll();
            principalPedido.add(nuevo);
            principalPedido.setVisible(true);
            editar.setVisible(false);
            nuevo.editar(ver.editarMenu(), temInt);
            nuevo.comboRes();
        } else {
            dialogoOk.textoLabel("Por favor seleccione una fila");
            dialogoOk.visible();
        }
    }

    public void inicioPrincipal() {
        principalPedido.setVisible(false);
        principalPedido.removeAll();
        principalPedido.add(inicioPedido);
        principalPedido.setVisible(true);
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

        tituloPedido = new javax.swing.JPanel();
        pedido = new javax.swing.JLabel();
        back = new javax.swing.JLabel();
        editar = new javax.swing.JLabel();
        principalPedido = new javax.swing.JPanel();
        inicioPedido = new javax.swing.JPanel();
        pedidoVerIcon = new javax.swing.JLabel();
        pedidoVerLabel = new javax.swing.JLabel();
        pedidoNuevaLabel = new javax.swing.JLabel();
        pedidoNuevaIcon = new javax.swing.JLabel();

        tituloPedido.setBackground(new java.awt.Color(68, 85, 89));
        tituloPedido.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pedido.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        pedido.setForeground(new java.awt.Color(164, 186, 191));
        pedido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pedido.setText("PEDIDOS");
        tituloPedido.add(pedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(71, 9, 940, 40));

        back.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/log-out.png"))); // NOI18N
        back.setToolTipText("Atrás");
        back.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backMouseClicked(evt);
            }
        });
        tituloPedido.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 40, 40));

        editar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/note.png"))); // NOI18N
        editar.setToolTipText("Editar");
        editar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editarMouseClicked(evt);
            }
        });
        tituloPedido.add(editar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1024, 10, 40, 40));

        principalPedido.setBackground(new java.awt.Color(19, 38, 35));
        principalPedido.setLayout(new java.awt.BorderLayout());

        inicioPedido.setBackground(new java.awt.Color(164, 186, 191));

        pedidoVerIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pedidoVerIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/phone-bookB.png"))); // NOI18N
        pedidoVerIcon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pedidoVerIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pedidoVerIconMouseClicked(evt);
            }
        });

        pedidoVerLabel.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        pedidoVerLabel.setForeground(new java.awt.Color(36, 56, 63));
        pedidoVerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pedidoVerLabel.setText("VER");
        pedidoVerLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pedidoVerLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pedidoVerLabelMouseClicked(evt);
            }
        });

        pedidoNuevaLabel.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        pedidoNuevaLabel.setForeground(new java.awt.Color(36, 56, 63));
        pedidoNuevaLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pedidoNuevaLabel.setText("CREAR");
        pedidoNuevaLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pedidoNuevaLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pedidoNuevaLabelMouseClicked(evt);
            }
        });

        pedidoNuevaIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pedidoNuevaIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/support-ticketB.png"))); // NOI18N
        pedidoNuevaIcon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pedidoNuevaIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pedidoNuevaIconMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout inicioPedidoLayout = new javax.swing.GroupLayout(inicioPedido);
        inicioPedido.setLayout(inicioPedidoLayout);
        inicioPedidoLayout.setHorizontalGroup(
            inicioPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inicioPedidoLayout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addGroup(inicioPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(inicioPedidoLayout.createSequentialGroup()
                        .addComponent(pedidoNuevaIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(190, 190, 190)
                        .addComponent(pedidoVerIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(inicioPedidoLayout.createSequentialGroup()
                        .addComponent(pedidoNuevaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(190, 190, 190)
                        .addComponent(pedidoVerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        inicioPedidoLayout.setVerticalGroup(
            inicioPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inicioPedidoLayout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addGroup(inicioPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pedidoNuevaIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pedidoVerIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(inicioPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pedidoNuevaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pedidoVerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        principalPedido.add(inicioPedido, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tituloPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 1080, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(principalPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 1080, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tituloPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(principalPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked
        validarInicioPedido();
    }//GEN-LAST:event_backMouseClicked

    private void editarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editarMouseClicked
        editarPedido();
    }//GEN-LAST:event_editarMouseClicked

    private void pedidoVerIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pedidoVerIconMouseClicked
        verMenu();
    }//GEN-LAST:event_pedidoVerIconMouseClicked

    private void pedidoVerLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pedidoVerLabelMouseClicked
        verMenu();
    }//GEN-LAST:event_pedidoVerLabelMouseClicked

    private void pedidoNuevaLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pedidoNuevaLabelMouseClicked
        nuevoPedido();
    }//GEN-LAST:event_pedidoNuevaLabelMouseClicked

    private void pedidoNuevaIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pedidoNuevaIconMouseClicked
        nuevoPedido();
    }//GEN-LAST:event_pedidoNuevaIconMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel back;
    private javax.swing.JLabel editar;
    private javax.swing.JPanel inicioPedido;
    private javax.swing.JLabel pedido;
    private javax.swing.JLabel pedidoNuevaIcon;
    private javax.swing.JLabel pedidoNuevaLabel;
    private javax.swing.JLabel pedidoVerIcon;
    private javax.swing.JLabel pedidoVerLabel;
    private javax.swing.JPanel principalPedido;
    private javax.swing.JPanel tituloPedido;
    // End of variables declaration//GEN-END:variables
}
