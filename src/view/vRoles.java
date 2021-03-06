/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import CAD.CargarCAD;
import CAD.PermisosCAD;
import CAD.RolesCAD;
import CAD.TablasCAD;
import Config.Bandera;
import Config.Configuraciones;
import Config.Validaciones;
import Model.Roles;
import java.awt.Dimension;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumnModel;
import static view.vPrincipal.Escritorio;

/**
 *
 * @author USUARIO
 */
public class vRoles extends javax.swing.JInternalFrame {

    /**
     * Creates new form vRoles
     */
    
    Map infoCampos = new HashMap();
    Map PermisosOtorgados = new HashMap();
    Map PermisosOtorgados2 = new HashMap();

    String Estado = "";

    public vRoles() {
        initComponents();
        CambiarEstado(Estado);
        mostrarDatos("");

    }

    //<editor-fold desc="CAMBIAR ESTADO" defaultstate="collapsed">
    public void CambiarEstado(String Estado) {
        switch (Estado) {
            case "Guardar":
                botonesInicio(false, true, true, true, false, true, false, false, true, true);
                break;
            case "Modificar":
                botonesInicio(false, false, true, true, false, false, true, false, true, true);
                break;
            case "Eliminar":
                botonesInicio(false, false, false, false, false, false, false, true, true, false);
                break;
            default:
                botonesInicio(false, false, false, false, true, false, false, false, false, false);
        }
    }
    //</editor-fold>

    //<editor-fold desc="MOSTRAR DATOS" defaultstate="collapsed">
    void mostrarDatos(String Valor) {
        TablasCAD ModelTable = new TablasCAD();
        TblTipoRoll.setModel(ModelTable.getTablaRoles(Valor));
        TableColumnModel columnModel = TblTipoRoll.getColumnModel();
        for (int i = 0; i < columnModel.getColumnCount(); i++) {
            columnModel.getColumn(i).setPreferredWidth(100);
        }

    }
    //</editor-fold>

    //<editor-fold desc="BOTONES INICIO" defaultstate="collapsed">
    void botonesInicio(boolean Ok, boolean id, boolean nombre, boolean siglas, boolean nuevo, boolean agregar, boolean modificar, boolean eliminar, boolean cancelar, boolean privilegios) {

        BtnNuevo.requestFocus();
        LblOk.setVisible(Ok);
        /////
        Lbl_Id.setEnabled(id);
        TxtNombre.setEnabled(nombre);
        TxtSiglas.setEnabled(siglas);
        LblPermisos.setEnabled(privilegios);
        BtnPrivilegios.setEnabled(privilegios);
        /////
        BtnNuevo.setVisible(nuevo);
        BtnEliminar.setVisible(eliminar);
        /////
        BtnAgregar.setVisible(agregar);
        BtnModificar.setVisible(modificar);
        BtnCancelar.setVisible(cancelar);
        buscarSi();

    }
    //</editor-fold>

    //<editor-fold desc="BUSCAR" defaultstate="collapsed">
    void buscarSi() {
        TxtBuscar.setVisible(true);
        LblBuscar.setVisible(true);
    }

    void buscarNo() {
        TxtBuscar.setVisible(false);
        LblBuscar.setVisible(false);
    }
    //</editor-fold>

    //<editor-fold desc="LIMPIAR CAMPOS" defaultstate="collapsed">
    public void limpiarCampos() {
        TxtNombre.setText("");
        TxtSiglas.setText("");
        TxtBuscar.setText("");
        LblPermisos.setText(iterateUsingEntrySet(PermisosOtorgados) + "");
        LblPermisos.setVisible(true);
        mostrarDatos("");
    }
    //</editor-fold>

    //<editor-fold desc="CARGAR ID" defaultstate="collapsed">
    void cargarId() {
        //Cargar ID
        CargarCAD oCargarCAD = new CargarCAD();
        Bandera B = new Bandera("Roles", "Id_Roll");
        String R = oCargarCAD.cargarIds(B);
        Lbl_Id.setText(R);
    }
    //</editor-fold>

    //<editor-fold desc="CARGAR LISTA PERMISOS" defaultstate="collapsed">
    void cargarListaPermisos(int IdRoll, String Estado) {
        //Cargar Lista Permisos
        PermisosCAD oPermisosCAD = new PermisosCAD();
        Map listaPermisosRoll = oPermisosCAD.CargarPermisos(IdRoll, Estado);
        PermisosOtorgados = listaPermisosRoll;
        LblPermisos.setText(iterateUsingEntrySet(PermisosOtorgados) + "");
        LblPermisos.setVisible(true);
    }
    //</editor-fold>

    //<editor-fold desc="VALIDAR PERMISOS OTORGADOS" defaultstate="collapsed">
    public int iterateUsingEntrySet(Map map) {
        //<String, Integer>
        PermisosOtorgados2.clear();
        for (Iterator it = map.entrySet().iterator(); it.hasNext();) {
            Map.Entry<String, String> entry = (Map.Entry<String, String>) it.next();
            if (entry.getValue().equals("S")) {
                PermisosOtorgados2.put(entry.getKey(), entry.getValue());
//                System.out.println(entry.getKey() + ":" + entry.getValue());
            }
        }
        return PermisosOtorgados2.size();
    }
    //</editor-fold>

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PopM_Tabla = new javax.swing.JPopupMenu();
        MnModificar = new javax.swing.JMenuItem();
        MnEliminar = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Lbl_Id = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        TxtNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        TxtSiglas = new javax.swing.JTextField();
        BtnPrivilegios = new javax.swing.JButton();
        LblPermisos = new javax.swing.JLabel();
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
        TblTipoRoll = new javax.swing.JTable();

        MnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Modificar.png"))); // NOI18N
        MnModificar.setText("Modificar");
        MnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnModificarActionPerformed(evt);
            }
        });
        PopM_Tabla.add(MnModificar);

        MnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Eliminar.png"))); // NOI18N
        MnEliminar.setText("Eliminar");
        MnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnEliminarActionPerformed(evt);
            }
        });
        PopM_Tabla.add(MnEliminar);

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
        jLabel1.setText("Id Roll :");

        Lbl_Id.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        Lbl_Id.setForeground(new java.awt.Color(255, 0, 0));
        Lbl_Id.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel3.setFont(new java.awt.Font("Agency FB", 1, 16)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel3.setText("Nombre del Roll :");

        TxtNombre.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        TxtNombre.setForeground(new java.awt.Color(255, 0, 0));
        TxtNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TxtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtNombreKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Agency FB", 1, 16)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel4.setText("Siglas del Roll :");

        TxtSiglas.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        TxtSiglas.setForeground(new java.awt.Color(255, 0, 0));
        TxtSiglas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TxtSiglas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtSiglasKeyTyped(evt);
            }
        });

        BtnPrivilegios.setBackground(new java.awt.Color(255, 153, 0));
        BtnPrivilegios.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        BtnPrivilegios.setText("Permisos...");
        BtnPrivilegios.setToolTipText("Asignar...");
        BtnPrivilegios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPrivilegiosActionPerformed(evt);
            }
        });

        LblPermisos.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        LblPermisos.setForeground(new java.awt.Color(255, 0, 0));
        LblPermisos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblPermisos.setToolTipText("Cantidad de permisos Otorgados");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(LblPermisos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnPrivilegios, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Lbl_Id, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TxtSiglas, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(Lbl_Id, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(TxtSiglas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LblPermisos, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnPrivilegios))
                .addGap(15, 15, 15))
        );

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

        TblTipoRoll.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TblTipoRoll.setComponentPopupMenu(PopM_Tabla);
        TblTipoRoll.setSelectionBackground(new java.awt.Color(255, 0, 0));
        jScrollPane1.setViewportView(TblTipoRoll);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(LblOk)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(LblBuscar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TxtBuscar))
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addContainerGap(12, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgregarActionPerformed
        //<editor-fold desc="GUARDAR" defaultstate="collapsed">
        // Btn Guardar
        Map rsp = new HashMap();
        Roles Rl = new Roles();

        Rl.setIdRol(Integer.parseInt(Lbl_Id.getText()));
        Rl.setNombre(TxtNombre.getText());
        Rl.setSiglas(TxtSiglas.getText());
        Rl.setPermisosMod(Integer.parseInt(LblPermisos.getText()));

        rsp.put("Roles", Rl);

        Validaciones V = new Validaciones();
        V.validarCamposRoles(rsp);

        if (rsp.containsKey("Mensaje")) {
            JOptionPane.showMessageDialog(null, rsp.get("Mensaje"));
//            rsp.get("campo");
//            String Focus = (String)rsp.get("campo");
//            System.out.println(""+Focus);
        } else {

            if (Lbl_Id.getText().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "No se puede Guardar el Roll\nVerifique que tenga conexion con la BD");

            } else {
                //
                Map permisosRol = PermisosOtorgados;
                boolean guardar = RolesCAD.guardar(Rl, permisosRol);

                if (!guardar) {
                    PermisosOtorgados.clear();
                    limpiarCampos();
//                    mostrarDatos("");
                    cargarId();
                    JOptionPane.showMessageDialog(null, Bandera.getRespuesta());
                    TxtNombre.requestFocus();
                    LblPermisos.setVisible(false);
                } else {
                    PermisosOtorgados.clear();
                    limpiarCampos();
                    botonesInicio(true, false, false, false, true, false, false, false, false, false);
                    LblOk.setText(Bandera.getRespuesta());
                    LblPermisos.setVisible(false);
                }
            }
        }
        //</editor-fold>
    }//GEN-LAST:event_BtnAgregarActionPerformed

    private void BtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarActionPerformed
        //<editor-fold desc="ELIMINAR" defaultstate="collapsed">
        if (Lbl_Id.getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "No se puede Eliminar el Roll\nEl   Campo 'ID' se encuentra vacio\nVerifique que tenga conexion con la BD");
            TxtNombre.requestFocus();
        } else {
            // Btn Eliminar
            int IdRol = Integer.parseInt(Lbl_Id.getText());

            Roles Rl = new Roles();
            Rl.setIdRol(IdRol);

            boolean Eliminar = RolesCAD.eliminar(Rl);

            if (!Eliminar) {
                PermisosOtorgados.clear();
                limpiarCampos();
                mostrarDatos("");
                botonesInicio(false, false, false, false, true, false, false, false, false, false);
                cargarId();
                JOptionPane.showMessageDialog(null, Bandera.getRespuesta());
            } else {
                PermisosOtorgados.clear();
                limpiarCampos();
                LblOk.setText(Bandera.getRespuesta());
                botonesInicio(true, false, false, false, true, false, false, false, false, false);
                Lbl_Id.setText("");
                LblPermisos.setVisible(false);
                mostrarDatos("");
            }
        }
        //</editor-fold>
    }//GEN-LAST:event_BtnEliminarActionPerformed

    private void BtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelarActionPerformed
        //<editor-fold desc="CANCELAR" defaultstate="collapsed">
        Estado = "";
        limpiarCampos();
        PermisosOtorgados.clear();
        PermisosOtorgados2.clear();
        CambiarEstado(Estado);
        mostrarDatos("");
        Lbl_Id.setText("");
        LblPermisos.setText(PermisosOtorgados2.size() + "");
        LblPermisos.setVisible(false);
        //</editor-fold>
    }//GEN-LAST:event_BtnCancelarActionPerformed

    private void BtnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnNuevoActionPerformed
        //<editor-fold desc="NUEVO" defaultstate="collapsed">
        Estado = "Guardar";
        PermisosOtorgados.clear();
        PermisosOtorgados2.clear();
        CambiarEstado(Estado);
        cargarId();
        buscarNo();
        limpiarCampos();
        LblPermisos.setText(PermisosOtorgados2.size() + "");
        LblPermisos.setVisible(true);
        TxtNombre.requestFocus();
        //</editor-fold>
    }//GEN-LAST:event_BtnNuevoActionPerformed

    private void BtnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnModificarActionPerformed
        //<editor-fold desc="MODIFICAR" defaultstate="collapsed">
        //Boton Modificar
        Map rsp = new HashMap();
        Roles Rl = new Roles();

        Rl.setIdRol(Integer.parseInt(Lbl_Id.getText()));
        Rl.setNombre(TxtNombre.getText());
        Rl.setSiglas(TxtSiglas.getText());

        rsp.put("Roles", Rl);

        Validaciones V = new Validaciones();
        V.validarCamposRoles(rsp);

        if (rsp.containsKey("Mensaje")) {
            JOptionPane.showMessageDialog(null, rsp.get("Mensaje"));
//            rsp.get("campo");
//            String Focus = (String)rsp.get("campo");
//            System.out.println(""+Focus);
        } else {

            if (Lbl_Id.getText().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "No se encuentra el ID '" + Lbl_Id.getText() + "' en la BD");
            } else {
                boolean Modificar = RolesCAD.modificar(Rl);

                if (!Modificar) {
                    JOptionPane.showMessageDialog(null, Bandera.getRespuesta());
                    limpiarCampos();
                    mostrarDatos("");
                    botonesInicio(false, false, false, false, true, false, false, false, false, false);
                    cargarId();
                } else {
                    limpiarCampos();
                    botonesInicio(true, false, false, false, true, false, false, false, false, false);
                    mostrarDatos(Rl.getNombre());
                    cargarId();
                    LblOk.setText(Bandera.getRespuesta());
                    LblOk.setVisible(true);
                }
            }
        }
        //</editor-fold>
    }//GEN-LAST:event_BtnModificarActionPerformed

    private void TxtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtBuscarKeyPressed
        if (evt.getKeyCode() == 10) {
            mostrarDatos(TxtBuscar.getText());
        }
    }//GEN-LAST:event_TxtBuscarKeyPressed

    private void TxtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtBuscarKeyReleased
        mostrarDatos(TxtBuscar.getText());
    }//GEN-LAST:event_TxtBuscarKeyReleased

    private void BtnPrivilegiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPrivilegiosActionPerformed

        infoCampos.put("Id", this.Lbl_Id.getText());
        infoCampos.put("Nombre", this.TxtNombre.getText());
        infoCampos.put("Siglas", this.TxtSiglas.getText());

        vPermisos vP = new vPermisos(infoCampos, PermisosOtorgados, Estado);
        if (!vPrincipal.ventana.equalsIgnoreCase("Permisos")) {
            vPrincipal.ventana = "Permisos";

            Escritorio.add(vP);
            Dimension desktopSize = Escritorio.getSize();
            Dimension FrameSize = vP.getSize();
            vP.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
            vP.show();
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "LA VENTANA 'Permisos' YA SE ENCUENTRA ABIERTA");

        }
//         vPrivilegios vp = new vPrivilegios();
//         vp.setVisible(true);

//         this.dispose();
    }//GEN-LAST:event_BtnPrivilegiosActionPerformed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        vPrincipal.ventana = "";
    }//GEN-LAST:event_formInternalFrameClosing

    private void MnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnModificarActionPerformed
        //<editor-fold desc="MENU MODIFICAR" defaultstate="collapsed">
        //Seleccion fila modificar
        Estado = "Modificar";
        if (Seleccion()) {
            CambiarEstado(Estado);
            TxtNombre.requestFocus();
            buscarNo();
        }

        //</editor-fold>
    }//GEN-LAST:event_MnModificarActionPerformed

    private void MnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnEliminarActionPerformed
        //<editor-fold desc="MENU ELIMINAR" defaultstate="collapsed">
        //Seleccion fila Eliminar
        Estado = "Eliminar";
        if (Seleccion()) {
            CambiarEstado(Estado);
            BtnEliminar.requestFocus();
            buscarNo();
        }

        //</editor-fold>
    }//GEN-LAST:event_MnEliminarActionPerformed

    private void TxtSiglasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtSiglasKeyTyped
        Configuraciones.limiteCaracteres(TxtSiglas, 5, evt);
    }//GEN-LAST:event_TxtSiglasKeyTyped

    private void TxtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtNombreKeyTyped
        Configuraciones.limiteCaracteres(TxtNombre, 30, evt);
    }//GEN-LAST:event_TxtNombreKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAgregar;
    private javax.swing.JButton BtnCancelar;
    private javax.swing.JButton BtnEliminar;
    private javax.swing.JButton BtnModificar;
    private javax.swing.JButton BtnNuevo;
    private javax.swing.JButton BtnPrivilegios;
    private javax.swing.JLabel LblBuscar;
    private javax.swing.JLabel LblOk;
    public javax.swing.JLabel LblPermisos;
    public javax.swing.JLabel Lbl_Id;
    private javax.swing.JMenuItem MnEliminar;
    private javax.swing.JMenuItem MnModificar;
    private javax.swing.JPopupMenu PopM_Tabla;
    public javax.swing.JTable TblTipoRoll;
    private javax.swing.JTextField TxtBuscar;
    public javax.swing.JTextField TxtNombre;
    public javax.swing.JTextField TxtSiglas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    public boolean Seleccion() {
        int fila = TblTipoRoll.getSelectedRow();
        if (fila >= 0) {
            Lbl_Id.setText(TblTipoRoll.getValueAt(fila, 0).toString());
            TxtNombre.setText(TblTipoRoll.getValueAt(fila, 1).toString());
            TxtSiglas.setText(TblTipoRoll.getValueAt(fila, 2).toString());

            cargarListaPermisos(Integer.parseInt(TblTipoRoll.getValueAt(fila, 0).toString()), "S");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ningun Roll de la tabla");
            buscarSi();
            return false;
        }
    }

}
