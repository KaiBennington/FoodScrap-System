/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author USUARIO
 */
public class vProveedores extends javax.swing.JInternalFrame {

    /**
     * Creates new form vProveedores
     */
    public vProveedores() {
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
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        TxtBuscar = new javax.swing.JTextField();
        LblBuscar = new javax.swing.JLabel();
        LblOk1 = new javax.swing.JLabel();
        BtnModificar = new javax.swing.JButton();
        BtnEliminar = new javax.swing.JButton();
        BtnCancelar1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TblConsultarUsuario = new javax.swing.JTable();
        BtnAgregar = new javax.swing.JButton();
        BtnNuevo = new javax.swing.JButton();

        setClosable(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Titles/GProveedores.png"))); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Id Proveedor :");

        jLabel3.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("...");

        jLabel4.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Nit :");

        jTextField1.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 0, 0));
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel5.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Nombre :");

        jTextField2.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(255, 0, 0));
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jTextField3.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(255, 0, 0));
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField3.setToolTipText("Razón Social");

        jLabel6.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Dirección :");

        jTextField4.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jTextField4.setForeground(new java.awt.Color(255, 0, 0));
        jTextField4.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel7.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Correo Electronico :");

        jTextField5.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jTextField5.setForeground(new java.awt.Color(255, 0, 0));
        jTextField5.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel8.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Telefono :");

        jTextField6.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jTextField6.setForeground(new java.awt.Color(255, 0, 0));
        jTextField6.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel9.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel9.setText("Fax :");

        jTextField7.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jTextField7.setForeground(new java.awt.Color(255, 0, 0));
        jTextField7.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(221, 221, 221))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jTextField2)
                                    .addComponent(jTextField4)
                                    .addComponent(jTextField5)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextField7)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TxtBuscar.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        TxtBuscar.setForeground(new java.awt.Color(0, 128, 255));
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

        LblOk1.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        LblOk1.setForeground(new java.awt.Color(0, 153, 51));
        LblOk1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Titles/Ok.png"))); // NOI18N

        BtnModificar.setBackground(new java.awt.Color(255, 153, 0));
        BtnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Modificar.png"))); // NOI18N
        BtnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnModificarActionPerformed(evt);
            }
        });

        BtnEliminar.setBackground(new java.awt.Color(255, 153, 0));
        BtnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Eliminar.png"))); // NOI18N
        BtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarActionPerformed(evt);
            }
        });

        BtnCancelar1.setBackground(new java.awt.Color(255, 153, 0));
        BtnCancelar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Cancelar.png"))); // NOI18N
        BtnCancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCancelar1ActionPerformed(evt);
            }
        });

        TblConsultarUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TblConsultarUsuario.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        TblConsultarUsuario.setSelectionBackground(new java.awt.Color(255, 0, 0));
        jScrollPane2.setViewportView(TblConsultarUsuario);

        BtnAgregar.setBackground(new java.awt.Color(255, 153, 0));
        BtnAgregar.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        BtnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Guardar.png"))); // NOI18N
        BtnAgregar.setToolTipText("Guardar");
        BtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgregarActionPerformed(evt);
            }
        });

        BtnNuevo.setBackground(new java.awt.Color(255, 153, 0));
        BtnNuevo.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        BtnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Nuevo.png"))); // NOI18N
        BtnNuevo.setToolTipText("Nuevo");
        BtnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnNuevoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(LblBuscar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(TxtBuscar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(BtnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(BtnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(BtnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(BtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(BtnCancelar1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator1)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(LblOk1))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnCancelar1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LblBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LblOk1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 436, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 566, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TxtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtBuscarKeyPressed
        if(evt.getKeyCode()==10){
            mostrarDatos(TxtBuscar.getText());
        }
    }//GEN-LAST:event_TxtBuscarKeyPressed

    private void TxtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtBuscarKeyReleased
        mostrarDatos(TxtBuscar.getText());
    }//GEN-LAST:event_TxtBuscarKeyReleased

    private void BtnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnModificarActionPerformed
        //<editor-fold desc="MODIFICAR" defaultstate="collapsed">
        // Btn Modificar
        Map rsp = new HashMap();
        Usuarios U = new Usuarios();
        llenarUsuario(U);
        rsp.put("User",U);

        Validaciones AU = new Validaciones();
        AU.validarCampos(rsp);

        if (rsp.containsKey("Mensaje")) {
            JOptionPane.showMessageDialog(null,rsp.get("Mensaje"));
            //            rsp.get("campo");
            //            String Focus = (String)rsp.get("campo");
            //            System.out.println(""+Focus);
        }else{

            if (!TxtConfirmar.getText().equals(TxtContrasena.getText())) {
                JOptionPane.showMessageDialog(null,"Las Contraseñas no Coinciden\nVerificar por favor...");
                TxtContrasena.setText("");
                TxtConfirmar.setText("");
                TxtContrasena.requestFocus();
            } else {
                boolean Modificar = UsuariosCAD.modificar(U);

                if(!Modificar){
                    JOptionPane.showMessageDialog(null,Bandera.getRespuesta());
                    limpiarCampos();
                    mostrarDatos("");
                    botonesInicio();
                }else{
                    limpiarCampos();
                    botonesInicio();
                    mostrarDatos(U.getNombres());
                    LblOk.setText(Bandera.getRespuesta());
                    LblOk.setVisible(true);
                }
            }
        }
        //</editor-fold>
    }//GEN-LAST:event_BtnModificarActionPerformed

    private void BtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarActionPerformed
        //<editor-fold desc="ELIMINAR" defaultstate="collapsed">
        if (TxtDocumento.getText().equalsIgnoreCase("") || CbxTipoDoc.getSelectedIndex() < 0) {
            JOptionPane.showMessageDialog(null, "No se puede Eliminar el Usuario\nEl Campo 'Documento' se encuentra vacio\nVerifique que tenga conexion con la BD");
            TxtDocumento.requestFocus();
        }else{
            // Btn Eliminar
            int TipoD = CbxTipoDoc.getSelectedIndex();
            String Documento = TxtDocumento.getText();

            Usuarios Us = new Usuarios();
            Us.setTipoDocumento(TipoD);
            Us.setDocumento(Documento);

            boolean Eliminar = UsuariosCAD.eliminar(Us);

            if(!Eliminar){
                JOptionPane.showMessageDialog(null,Bandera.getRespuesta());
                limpiarCampos();
                mostrarDatos("");
                botonesInicio();
            }else{
                limpiarCampos();
                botonesInicio();
                LblOk.setText(Bandera.getRespuesta());
                LblOk.setVisible(true);
            }
        }
        //</editor-fold>
    }//GEN-LAST:event_BtnEliminarActionPerformed

    private void BtnCancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelar1ActionPerformed
        //<editor-fold desc="CANCELAR" defaultstate="collapsed">
        limpiarCampos();
        buscarSi();
        botonesInicio();
        //</editor-fold>
    }//GEN-LAST:event_BtnCancelar1ActionPerformed

    private void BtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgregarActionPerformed
        //<editor-fold desc="GUARDAR" defaultstate="collapsed">
        // Btn Guardar
        Map rsp = new HashMap();
        Usuarios U = new Usuarios();
        String Fecha = "";
        U.setTipoDocumento(CbxTipoDoc.getSelectedIndex());
        U.setDocumento(TxtDocumento.getText());
        U.setNombres(TxtNombre.getText());
        U.setApellidos(TxtApellido.getText());
        U.setTelefono(TxtTelefono.getText());
        if (DCFechaNac.getDate() != null) {
            int Año = DCFechaNac.getCalendar().get(Calendar.YEAR);
            int Mes = DCFechaNac.getCalendar().get(Calendar.MONTH)+1;
            int Dia = DCFechaNac.getCalendar().get(Calendar.DAY_OF_MONTH);
            Fecha = Año+"-"+Mes+"-"+Dia;
        }else{
            JOptionPane.showMessageDialog(null," El campo de Fecha se encuentra Vacio");
            DCFechaNac.requestFocusInWindow();
            return;
        }
        U.setFechaNacimiento(Fecha);
        U.setDireccion(TxtDireccion.getText());
        U.setEmail(TxtCorreo.getText());
        U.setRoll(CbxRoles.getSelectedIndex());
        U.setUsuario(TxtUsuario.getText());
        U.setContrasena(TxtContrasena.getText());
        U.setPregunta(CbxPregunta.getSelectedIndex());
        U.setRespuesta(TxtRespuesta.getText());

        rsp.put("User",U);

        Validaciones V = new Validaciones();
        V.validarCampos(rsp);

        if (rsp.containsKey("Mensaje")) {
            JOptionPane.showMessageDialog(null,rsp.get("Mensaje"));
            //            rsp.get("campo");
            //            String Focus = (String)rsp.get("campo");
            //            System.out.println(""+Focus);
        }else{

            if (!TxtConfirmar.getText().equals(TxtContrasena.getText())) {
                JOptionPane.showMessageDialog(null,"Las Contraseñas no Coinciden\nVerificar por favor...");
                TxtContrasena.setText("");
                TxtConfirmar.setText("");
                TxtContrasena.requestFocus();
            } else {
                boolean guardar = UsuariosCAD.guardar(U);

                if(!guardar){
                    TxtUsuario.setText("");
                    JOptionPane.showMessageDialog(null,Bandera.getRespuesta());
                    TxtDocumento.requestFocus();
                }else{
                    limpiarCampos();
                    //botonesInicio();
                    LblOk.setText(Bandera.getRespuesta());
                    LblOk.setVisible(true);
                }
            }
        }
        //</editor-fold>
    }//GEN-LAST:event_BtnAgregarActionPerformed

    private void BtnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnNuevoActionPerformed
        //<editor-fold desc="NUEVO" defaultstate="collapsed">
        botonesInicio(false,true,false,true,true);
        //</editor-fold>
    }//GEN-LAST:event_BtnNuevoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAgregar;
    private javax.swing.JButton BtnCancelar1;
    private javax.swing.JButton BtnEliminar;
    private javax.swing.JButton BtnModificar;
    private javax.swing.JButton BtnNuevo;
    private javax.swing.JLabel LblBuscar;
    private javax.swing.JLabel LblOk1;
    public javax.swing.JTable TblConsultarUsuario;
    private javax.swing.JTextField TxtBuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables
}
