/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Dimension;
import javax.swing.JOptionPane;
import static view.vPrincipal.Escritorio;

/**
 *
 * @author USUARIO
 */
public class vRoles extends javax.swing.JInternalFrame {

    /**
     * Creates new form vRoles
     */
    public vRoles() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Lbl_Id = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        TxtNomRoll = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        TxtSiglasRoll = new javax.swing.JTextField();
        BtnPrivilegios = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        BtnAgregar = new javax.swing.JButton();
        BtnEliminar = new javax.swing.JButton();
        BtnCancelar = new javax.swing.JButton();
        BtnNuevo = new javax.swing.JButton();
        BtnModificar = new javax.swing.JButton();
        LblOk = new javax.swing.JLabel();
        TxtBuscar = new javax.swing.JTextField();
        LblBuscar = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblTipoDocu = new javax.swing.JTable();

        setClosable(true);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Agency FB", 1, 16))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Agency FB", 1, 16)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel1.setText("Id Tipo :");

        Lbl_Id.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        Lbl_Id.setForeground(new java.awt.Color(255, 0, 0));
        Lbl_Id.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Lbl_Id.setText("...");

        jLabel3.setFont(new java.awt.Font("Agency FB", 1, 16)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel3.setText("Nombre del Roll :");

        TxtNomRoll.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        TxtNomRoll.setForeground(new java.awt.Color(255, 0, 0));
        TxtNomRoll.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel4.setFont(new java.awt.Font("Agency FB", 1, 16)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel4.setText("Siglas del Roll :");

        TxtSiglasRoll.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        TxtSiglasRoll.setForeground(new java.awt.Color(255, 0, 0));
        TxtSiglasRoll.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        BtnPrivilegios.setBackground(new java.awt.Color(255, 153, 0));
        BtnPrivilegios.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        BtnPrivilegios.setText("Permisos...");
        BtnPrivilegios.setToolTipText("Asignar...");
        BtnPrivilegios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPrivilegiosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BtnPrivilegios, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Lbl_Id, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtNomRoll, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtSiglasRoll, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(39, 39, 39))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(Lbl_Id))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TxtNomRoll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(TxtSiglasRoll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addComponent(BtnPrivilegios)
                .addGap(15, 15, 15))
        );

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Titles/TipoRoles.png"))); // NOI18N

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BtnAgregar.setBackground(new java.awt.Color(255, 153, 0));
        BtnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Guardar.png"))); // NOI18N
        BtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgregarActionPerformed(evt);
            }
        });
        jPanel5.add(BtnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 11, 32, -1));

        BtnEliminar.setBackground(new java.awt.Color(255, 153, 0));
        BtnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Eliminar.png"))); // NOI18N
        BtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarActionPerformed(evt);
            }
        });
        jPanel5.add(BtnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 11, 32, -1));

        BtnCancelar.setBackground(new java.awt.Color(255, 153, 0));
        BtnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Cancelar.png"))); // NOI18N
        BtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCancelarActionPerformed(evt);
            }
        });
        jPanel5.add(BtnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 11, 32, -1));

        BtnNuevo.setBackground(new java.awt.Color(255, 153, 0));
        BtnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Nuevo.png"))); // NOI18N
        BtnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnNuevoActionPerformed(evt);
            }
        });
        jPanel5.add(BtnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 11, 32, -1));

        BtnModificar.setBackground(new java.awt.Color(255, 153, 0));
        BtnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Modificar.png"))); // NOI18N
        BtnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnModificarActionPerformed(evt);
            }
        });
        jPanel5.add(BtnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 11, 32, -1));

        LblOk.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        LblOk.setForeground(new java.awt.Color(0, 153, 51));
        LblOk.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblOk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Titles/Ok.png"))); // NOI18N
        LblOk.setToolTipText("Operacion Exitosa");

        TxtBuscar.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        TxtBuscar.setForeground(new java.awt.Color(255, 0, 0));
        TxtBuscar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TxtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TxtBuscarKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtBuscarKeyReleased(evt);
            }
        });

        LblBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Buscar.png"))); // NOI18N

        TblTipoDocu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(TblTipoDocu);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(LblBuscar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TxtBuscar)))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LblOk))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TxtBuscar)
                    .addComponent(LblBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LblOk)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgregarActionPerformed
        //<editor-fold desc="GUARDAR" defaultstate="collapsed">
        if (Lbl_Id.getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "No se puede Guardar el Tipo de Documento\nEl Campo 'ID' se encuentra vacio\nVerifique que tenga conexion con la BD");

        }else{
            // Btn Guardar
//            String Id_Tipo = Lbl_Id.getText();
//            String NomDocumento = TxtNomRoll.getText();
//            String SiglasDoc = TxtSiglasRoll.getText();
//
//            TDocumento TD = new TDocumento();
//            TD.setIdTipo(Id_Tipo);
//            TD.setNombreDocumento(NomDocumento);
//            TD.setSiglasDocumento(SiglasDoc);
//
//            if (TDocumentoCAD.guardar(TD)) {
//                mostrarDatos("");
//                limpiarCampos();
//                cargarId(Lbl_Id.getText());
//                botonesInicio();
//                LblOk.setVisible(true);
//
//            }else{
//                JOptionPane.showMessageDialog(null, "El Nuevo Tipo no se pudo guardar");
//                TxtNomRoll.requestFocus();
//            }
        }
        //</editor-fold>
    }//GEN-LAST:event_BtnAgregarActionPerformed

    private void BtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarActionPerformed
        //<editor-fold desc="ELIMINAR" defaultstate="collapsed">
        if (Lbl_Id.getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "No se puede Eliminar el Tipo Documento\nEl Campo 'ID' se encuentra vacio\nVerifique que tenga conexion con la BD");
        }else{
            // Btn Eliminar
            String Id_Tipo = Lbl_Id.getText();

//            TDocumento TD = new TDocumento();
//            TD.setIdTipo(Id_Tipo);
//
//            if (TDocumentoCAD.eliminar(TD)) {
//
//                mostrarDatos("");
//                limpiarCampos();
//                cargarId(Lbl_Id.getText());
//                botonesInicio();
//                LblOk.setVisible(true);
//            }else{
//                JOptionPane.showMessageDialog(null, "El Tipo Documento no se pudo eliminar");
//            }
        }
        //</editor-fold>
    }//GEN-LAST:event_BtnEliminarActionPerformed

    private void BtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelarActionPerformed
        //<editor-fold desc="CANCELAR" defaultstate="collapsed">
//        limpiarCampos();
//        buscarSi();
//        cargarId("");
//        botonesInicio();
        //        BtnNuevo.setVisible(true);
        //        BtnEliminar.setVisible(false);
        //        /////////////////////
        //        BtnAgregar.setVisible(false);
        //        BtnModificar.setVisible(false);
        //        BtnCancelar.setVisible(false);
        //</editor-fold>
    }//GEN-LAST:event_BtnCancelarActionPerformed

    private void BtnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnNuevoActionPerformed
        //<editor-fold desc="NUEVO" defaultstate="collapsed">
        LblOk.setVisible(false);
        Lbl_Id.setVisible(true);
//        buscarNo();
        TxtNomRoll.setEnabled(true);
        TxtNomRoll.requestFocus();
        TxtSiglasRoll.setEnabled(true);
        /////
        BtnEliminar.setVisible(false);
        BtnNuevo.setVisible(false);
        BtnModificar.setVisible(false);
        /////
        BtnAgregar.setVisible(true);
        BtnCancelar.setVisible(true);
        //</editor-fold>
    }//GEN-LAST:event_BtnNuevoActionPerformed

    private void BtnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnModificarActionPerformed
        //<editor-fold desc="MODIFICAR" defaultstate="collapsed">
        if (Lbl_Id.getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null,"No se encuentra el ID '"+Lbl_Id.getText()+"' en la BD");
        }else{
            String Id_Tipo = Lbl_Id.getText();
            String NomDocumento = TxtNomRoll.getText();
            String SiglasDoc = TxtSiglasRoll.getText();

//            TDocumento TD = new TDocumento();
//            TD.setIdTipo(Id_Tipo);
//            TD.setNombreDocumento(NomDocumento);
//            TD.setSiglasDocumento(SiglasDoc);
//
//            if (TDocumentoCAD.modificar(TD)) {
//                mostrarDatos("");
//                limpiarCampos();
//                cargarId(Lbl_Id.getText());
//                botonesInicio();
//                LblOk.setVisible(true);
//            }else{
//                JOptionPane.showMessageDialog(null, "El Tipo Documento no se pudo modificar");
//            }
        }
        //</editor-fold>
    }//GEN-LAST:event_BtnModificarActionPerformed

    private void TxtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtBuscarKeyPressed
        if(evt.getKeyCode()==10){
//            mostrarDatos(TxtBuscar.getText());
        }
    }//GEN-LAST:event_TxtBuscarKeyPressed

    private void TxtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtBuscarKeyReleased
//        mostrarDatos(TxtBuscar.getText());
    }//GEN-LAST:event_TxtBuscarKeyReleased

    private void BtnPrivilegiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPrivilegiosActionPerformed
        //Item Permisos;
        vPermisos vP = new vPermisos();
        if (!vPrincipal.ventana.equalsIgnoreCase("Permisos")) {
            vPrincipal.ventana="Permisos";

            Escritorio.add(vP);
            Dimension desktopSize = Escritorio.getSize();
            Dimension FrameSize = vP.getSize();
            vP.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
            vP.show();
        }
        else
        {
            JOptionPane.showMessageDialog(null,"LA VENTANA 'Permisos' YA SE ENCUENTRA ABIERTA");

        }
//         vPrivilegios vp = new vPrivilegios();
//         vp.setVisible(true);

//         this.dispose();
    }//GEN-LAST:event_BtnPrivilegiosActionPerformed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        vPrincipal.ventana = "";
    }//GEN-LAST:event_formInternalFrameClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAgregar;
    private javax.swing.JButton BtnCancelar;
    private javax.swing.JButton BtnEliminar;
    private javax.swing.JButton BtnModificar;
    private javax.swing.JButton BtnNuevo;
    private javax.swing.JButton BtnPrivilegios;
    private javax.swing.JLabel LblBuscar;
    private javax.swing.JLabel LblOk;
    private javax.swing.JLabel Lbl_Id;
    public javax.swing.JTable TblTipoDocu;
    private javax.swing.JTextField TxtBuscar;
    private javax.swing.JTextField TxtNomRoll;
    private javax.swing.JTextField TxtSiglasRoll;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
