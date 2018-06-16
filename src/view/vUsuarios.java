/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import CAD.CargarCAD;
import CAD.TablasCAD;
import CAD.UsuariosCAD;
import Config.Validaciones;
import Config.Bandera;
import Model.PreguntaSecreta;
import Model.Roles;
import Model.TipoDocumento;
import Model.Usuarios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author USUARIO
 */
public class vUsuarios extends javax.swing.JInternalFrame {

    /**
     * Creates new form vUsuarios
     */
    public vUsuarios() {
        initComponents();
        botonesInicio(false, false, true, false, false, false, false);
        buscarSi();
        cargarCombos();
        mostrarDatos("");
        /////        
    }

    //<editor-fold desc="Llenar Usuario" defaultstate="collapsed">
    void llenarUsuario(Usuarios U) {
        U.setTipoDocumento(CbxTipoDoc.getSelectedIndex());
        U.setDocumento(TxtDocumento.getText());
        U.setNombres(TxtNombre.getText());
        U.setApellidos(TxtApellido.getText());
        U.setTelefono(TxtTelefono.getText());
        String Fecha = "";
        if (DCFechaNac.getDate() != null) {
            int Año = DCFechaNac.getCalendar().get(Calendar.YEAR);
            int Mes = DCFechaNac.getCalendar().get(Calendar.MONTH) + 1;
            int Dia = DCFechaNac.getCalendar().get(Calendar.DAY_OF_MONTH);
            Fecha = Año + "-" + Mes + "-" + Dia;
        } else {
            JOptionPane.showMessageDialog(null, " El campo de Fecha se encuentra Vacio");
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

    }
    //</editor-fold>

    //<editor-fold desc="CARGAR COMBOS" defaultstate="collapsed">    
    void cargarCombos() {
        //Combo Tipo Documento
        CargarCAD oCargarCAD = new CargarCAD();
        List ListaComboT = oCargarCAD.CargarTipoDoc();
        List ListaComboP = oCargarCAD.CargarPregunta();
        List ListaComboR = oCargarCAD.CargarRoles();

        CbxTipoDoc.removeAllItems();
        for (int i = 0; i < ListaComboT.size(); i++) {
            TipoDocumento Tp = (TipoDocumento) ListaComboT.get(i);
            CbxTipoDoc.addItem(Tp.getNombre());
        }
//        
        CbxPregunta.removeAllItems();
        for (int i = 0; i < ListaComboP.size(); i++) {
            PreguntaSecreta Ps = (PreguntaSecreta) ListaComboP.get(i);
            CbxPregunta.addItem(Ps.getNombre());
        }
//        
        CbxRoles.removeAllItems();
        for (int i = 0; i < ListaComboR.size(); i++) {
            Roles Rl = (Roles) ListaComboR.get(i);
            CbxRoles.addItem(Rl.getNombre());
        }
    }
    //</editor-fold>

    //<editor-fold desc="BOTONES INICIO" defaultstate="collapsed">
    void botonesInicio(boolean ok, boolean datos, boolean nuevo, boolean agregar, boolean modificar, boolean eliminar, boolean cancelar) {
        BtnNuevo.requestFocus();
        LblOk.setVisible(ok);
        /////
        TxtDocumento.setEnabled(datos);
        TxtNombre.setEnabled(datos);
        TxtApellido.setEnabled(datos);
        CbxTipoDoc.setEnabled(datos);
        DCFechaNac.setEnabled(datos);
        TxtTelefono.setEnabled(datos);
        TxtDireccion.setEnabled(datos);
        TxtCorreo.setEnabled(datos);
        TxtUsuario.setEnabled(datos);
        TxtContrasena.setEnabled(datos);
        TxtConfirmar.setEnabled(datos);
        CbxPregunta.setEnabled(datos);
        TxtRespuesta.setEnabled(datos);
        CbxRoles.setEnabled(datos);
        /////
        BtnNuevo.setVisible(nuevo);
        /////
        BtnAgregar.setVisible(agregar);
        BtnModificar.setVisible(modificar);
        BtnEliminar.setVisible(eliminar);
        BtnCancelar.setVisible(cancelar);
        /////
    }
    //</editor-fold>

    //<editor-fold desc="lIMPIAR CAMPOS" defaultstate="collapsed">
    public void limpiarCampos() {
        //LblOk.setVisible(false);
        ////
        CbxTipoDoc.setSelectedIndex(0);
        TxtDocumento.setText("");
        CbxPregunta.setSelectedIndex(0);
        TxtRespuesta.setText("");
        ///
        TxtNombre.setText("");
        TxtApellido.setText("");
        DCFechaNac.setCalendar(null);
        TxtTelefono.setText("");
        TxtDireccion.setText("");
        TxtCorreo.setText("");
        TxtUsuario.setText("");
        TxtContrasena.setText("");
        TxtConfirmar.setText("");
        CbxRoles.setSelectedIndex(0);
    }
    //</editor-fold>

    //<editor-fold desc="Ocultar Filas" defaultstate="collapsed">
    void ocultarFilas(int index) {
        TblConsultarUsuario.getColumnModel().getColumn(index).setMaxWidth(0);
        TblConsultarUsuario.getColumnModel().getColumn(index).setMinWidth(0);
        TblConsultarUsuario.getColumnModel().getColumn(index).setPreferredWidth(0);

    }
    //</editor-fold>

    //<editor-fold desc="MOSTRAR DATOS" defaultstate="collapsed">
    void mostrarDatos(String Valor) {
        TablasCAD ModelTable = new TablasCAD();
        TblConsultarUsuario.setModel(ModelTable.getTablaUsuarios(Valor));
        TableColumnModel columnModel = TblConsultarUsuario.getColumnModel();
        for (int i = 0; i < columnModel.getColumnCount(); i++) {
            columnModel.getColumn(i).setPreferredWidth(100);
            ocultarFilas(13);
            ocultarFilas(14);
            ocultarFilas(15);
        }

    }
    //</editor-fold>

    //<editor-fold desc="HABILITAR CAMPOS" defaultstate="collapsed">
    void habilitarCampos(boolean TipoDoc, boolean Textos, boolean nuevo, boolean guardar, boolean modificar, boolean eliminar, boolean cancelar) {
        CbxTipoDoc.setEnabled(TipoDoc);
        TxtDocumento.setEnabled(TipoDoc);
        //
        TxtNombre.setEnabled(Textos);
        TxtApellido.setEnabled(Textos);
        TxtTelefono.setEnabled(Textos);
        TxtDireccion.setEnabled(Textos);
        DCFechaNac.setEnabled(Textos);
        TxtCorreo.setEnabled(Textos);
        CbxRoles.setEnabled(Textos);
        TxtUsuario.setEnabled(Textos);
        TxtContrasena.setEnabled(Textos);
        TxtConfirmar.setEnabled(Textos);
        CbxPregunta.setEnabled(Textos);
        TxtRespuesta.setEnabled(Textos);
        ///   
        BtnNuevo.setVisible(nuevo);
        BtnAgregar.setVisible(guardar);
        BtnModificar.setVisible(modificar);
        BtnEliminar.setVisible(eliminar);
        BtnCancelar.setVisible(cancelar);

        buscarNo();
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
        jLabel3 = new javax.swing.JLabel();
        TxtNombre = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        TxtApellido = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        TxtDireccion = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        TxtCorreo = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        TxtTelefono = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        TxtDocumento = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        CbxTipoDoc = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        TxtUsuario = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        TxtContrasena = new javax.swing.JPasswordField();
        TxtConfirmar = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        CbxPregunta = new javax.swing.JComboBox<>();
        TxtRespuesta = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        DCFechaNac = new com.toedter.calendar.JDateChooser();
        CbxRoles = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        TblConsultarUsuario = new javax.swing.JTable();
        LblBuscar = new javax.swing.JLabel();
        TxtBuscar = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        BtnCancelar = new javax.swing.JButton();
        BtnEliminar = new javax.swing.JButton();
        BtnModificar = new javax.swing.JButton();
        BtnAgregar = new javax.swing.JButton();
        BtnNuevo = new javax.swing.JButton();
        LblOk = new javax.swing.JLabel();

        MnModificar.setText("Modificar");
        MnModificar.setName(""); // NOI18N
        MnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnModificarActionPerformed(evt);
            }
        });
        PopM_Tabla.add(MnModificar);

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
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Tahoma", 1, 12)), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(204, 204, 204))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel3.setText("* Nombre :");

        TxtNombre.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        TxtNombre.setForeground(new java.awt.Color(255, 0, 0));
        TxtNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TxtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtNombreActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel8.setText("* Apellido :");

        TxtApellido.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        TxtApellido.setForeground(new java.awt.Color(255, 0, 0));
        TxtApellido.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TxtApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtApellidoActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel14.setText("* Fecha de Nacimiento:");

        jLabel12.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel12.setText("Direccion:");

        TxtDireccion.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        TxtDireccion.setForeground(new java.awt.Color(255, 0, 0));
        TxtDireccion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TxtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtDireccionActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel13.setText("Correo Electronico:");

        TxtCorreo.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        TxtCorreo.setForeground(new java.awt.Color(255, 0, 0));
        TxtCorreo.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel11.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel11.setText("* Telefono:");

        TxtTelefono.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        TxtTelefono.setForeground(new java.awt.Color(255, 0, 0));
        TxtTelefono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TxtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtTelefonoActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel15.setText("* Numero de Documento:");

        TxtDocumento.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        TxtDocumento.setForeground(new java.awt.Color(255, 0, 0));
        TxtDocumento.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel1.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel1.setText("Tipo de Documento :");

        CbxTipoDoc.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        CbxTipoDoc.setForeground(new java.awt.Color(255, 0, 0));
        CbxTipoDoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione..." }));
        CbxTipoDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbxTipoDocActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel3.setForeground(new java.awt.Color(204, 204, 204));

        jLabel4.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel4.setText("* Nombre de Usuario:");

        TxtUsuario.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        TxtUsuario.setForeground(new java.awt.Color(255, 0, 0));
        TxtUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel5.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel5.setText("* Contraseña:");

        TxtContrasena.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TxtContrasena.setForeground(new java.awt.Color(255, 0, 0));
        TxtContrasena.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        TxtConfirmar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TxtConfirmar.setForeground(new java.awt.Color(255, 0, 0));
        TxtConfirmar.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel6.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel6.setText("* Confirmar Contraseña:");

        jLabel9.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel9.setText("* Pregunta Seguridad:");

        jLabel16.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel16.setText("* Respuesta Secreta:");

        CbxPregunta.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        CbxPregunta.setForeground(new java.awt.Color(255, 0, 0));
        CbxPregunta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione..." }));

        TxtRespuesta.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        TxtRespuesta.setForeground(new java.awt.Color(255, 0, 0));
        TxtRespuesta.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TxtUsuario)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TxtContrasena)
                    .addComponent(TxtConfirmar)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CbxPregunta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(TxtRespuesta))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TxtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TxtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TxtConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addGap(9, 9, 9)
                .addComponent(CbxPregunta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TxtRespuesta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel7.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel7.setText("Roll de Usuario:");

        DCFechaNac.setBackground(new java.awt.Color(255, 255, 255));
        DCFechaNac.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N

        CbxRoles.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        CbxRoles.setForeground(new java.awt.Color(255, 0, 0));
        CbxRoles.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione..." }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(CbxTipoDoc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(DCFechaNac, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(TxtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(TxtTelefono, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 14, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(18, 18, 18)
                                .addComponent(TxtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(CbxRoles, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(125, 125, 125))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(18, 18, 18)
                                .addComponent(TxtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TxtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CbxTipoDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(4, 4, 4)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(TxtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DCFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(TxtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(CbxRoles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

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
        TblConsultarUsuario.setComponentPopupMenu(PopM_Tabla);
        TblConsultarUsuario.setSelectionBackground(new java.awt.Color(255, 0, 0));
        jScrollPane2.setViewportView(TblConsultarUsuario);

        LblBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Buscar.png"))); // NOI18N
        LblBuscar.setToolTipText("Buscar");
        LblBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LblBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LblBuscarMouseClicked(evt);
            }
        });

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

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Titles/GUsuarios.png"))); // NOI18N

        BtnCancelar.setBackground(new java.awt.Color(255, 153, 0));
        BtnCancelar.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        BtnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Cancelar.png"))); // NOI18N
        BtnCancelar.setToolTipText("Cancelar");
        BtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCancelarActionPerformed(evt);
            }
        });

        BtnEliminar.setBackground(new java.awt.Color(255, 153, 0));
        BtnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Eliminar.png"))); // NOI18N
        BtnEliminar.setToolTipText("Eliminar");
        BtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarActionPerformed(evt);
            }
        });

        BtnModificar.setBackground(new java.awt.Color(255, 153, 0));
        BtnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Modificar.png"))); // NOI18N
        BtnModificar.setToolTipText("Modificar");
        BtnModificar.setName(""); // NOI18N
        BtnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnModificarActionPerformed(evt);
            }
        });

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

        LblOk.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        LblOk.setForeground(new java.awt.Color(0, 153, 51));
        LblOk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Titles/Ok.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(LblBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(BtnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(BtnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(BtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(BtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(LblOk)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BtnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtBuscar)
                    .addComponent(LblBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LblOk, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TxtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtNombreActionPerformed

    }//GEN-LAST:event_TxtNombreActionPerformed

    private void TxtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtDireccionActionPerformed

    }//GEN-LAST:event_TxtDireccionActionPerformed

    private void TxtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtTelefonoActionPerformed

    }//GEN-LAST:event_TxtTelefonoActionPerformed

    private void CbxTipoDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbxTipoDocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CbxTipoDocActionPerformed

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
            int Mes = DCFechaNac.getCalendar().get(Calendar.MONTH) + 1;
            int Dia = DCFechaNac.getCalendar().get(Calendar.DAY_OF_MONTH);
            Fecha = Año + "-" + Mes + "-" + Dia;
        } else {
            JOptionPane.showMessageDialog(null, " El campo de Fecha se encuentra Vacio");
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

        rsp.put("User", U);

        Validaciones V = new Validaciones();
        V.validarCampos(rsp);

        if (rsp.containsKey("Mensaje")) {
            JOptionPane.showMessageDialog(null, rsp.get("Mensaje"));
//            rsp.get("campo");
//            String Focus = (String)rsp.get("campo");
//            System.out.println(""+Focus);
        } else {

            if (!TxtConfirmar.getText().equals(TxtContrasena.getText())) {
                JOptionPane.showMessageDialog(null, "Las Contraseñas no Coinciden\nVerificar por favor...");
                TxtContrasena.setText("");
                TxtConfirmar.setText("");
                TxtContrasena.requestFocus();
            } else {
                boolean guardar = UsuariosCAD.guardar(U);

                if (!guardar) {
                    TxtUsuario.setText("");
                    JOptionPane.showMessageDialog(null, Bandera.getRespuesta());
                    TxtDocumento.requestFocus();
                } else {
                    limpiarCampos();
                    botonesInicio(true, false, true, false, false, false, false);
                    buscarSi();
                    LblOk.setText(Bandera.getRespuesta());
                    LblOk.setVisible(true);
                }
            }
        }
        //</editor-fold>
    }//GEN-LAST:event_BtnAgregarActionPerformed

    private void BtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelarActionPerformed
        //<editor-fold desc="CANCELAR" defaultstate="collapsed">
        limpiarCampos();
        botonesInicio(false, false, true, false, false, false, false);
        buscarSi();
        TxtBuscar.requestFocus();
        //</editor-fold>
    }//GEN-LAST:event_BtnCancelarActionPerformed

    private void BtnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnNuevoActionPerformed
        //<editor-fold desc="NUEVO" defaultstate="collapsed">
        botonesInicio(false, true, false, true, false, false, true);
        buscarNo();
        //</editor-fold>
    }//GEN-LAST:event_BtnNuevoActionPerformed

    private void TxtApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtApellidoActionPerformed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        vPrincipal.ventana = "";
    }//GEN-LAST:event_formInternalFrameClosing

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        LblOk.setVisible(false);
        mostrarDatos("");
    }//GEN-LAST:event_jPanel1MousePressed

    private void TxtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtBuscarKeyPressed
        if (evt.getKeyCode() == 10) {
            mostrarDatos(TxtBuscar.getText());
        }
    }//GEN-LAST:event_TxtBuscarKeyPressed

    private void TxtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtBuscarKeyReleased
        mostrarDatos(TxtBuscar.getText());
    }//GEN-LAST:event_TxtBuscarKeyReleased

    private void BtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarActionPerformed
        //<editor-fold desc="ELIMINAR" defaultstate="collapsed">
        if (TxtDocumento.getText().equalsIgnoreCase("") || CbxTipoDoc.getSelectedIndex() < 0) {
            JOptionPane.showMessageDialog(null, "No se puede Eliminar el Usuario\nEl Campo 'Documento' se encuentra vacio\nVerifique que tenga conexion con la BD");
            TxtDocumento.requestFocus();
        } else {
            // Btn Eliminar
            int TipoD = CbxTipoDoc.getSelectedIndex();
            String Documento = TxtDocumento.getText();

            Usuarios Us = new Usuarios();
            Us.setTipoDocumento(TipoD);
            Us.setDocumento(Documento);

            boolean Eliminar = UsuariosCAD.eliminar(Us);

            if (!Eliminar) {
                JOptionPane.showMessageDialog(null, Bandera.getRespuesta());
                limpiarCampos();
                mostrarDatos("");
                //botonesInicio();
            } else {
                limpiarCampos();                
                buscarSi();
                LblOk.setText(Bandera.getRespuesta());
                LblOk.setVisible(true);
                botonesInicio(true, false, true, false, false, false, false);
            }
        }
        //</editor-fold>
    }//GEN-LAST:event_BtnEliminarActionPerformed

    private void BtnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnModificarActionPerformed
        //<editor-fold desc="MODIFICAR" defaultstate="collapsed">
        // Btn Modificar
        Map rsp = new HashMap();
        Usuarios U = new Usuarios();
        llenarUsuario(U);
        rsp.put("User", U);

        Validaciones AU = new Validaciones();
        AU.validarCampos(rsp);

        if (rsp.containsKey("Mensaje")) {
            JOptionPane.showMessageDialog(null, rsp.get("Mensaje"));
            //            rsp.get("campo");
            //            String Focus = (String)rsp.get("campo");
            //            System.out.println(""+Focus);
        } else {

            if (!TxtConfirmar.getText().equals(TxtContrasena.getText())) {
                JOptionPane.showMessageDialog(null, "Las Contraseñas no Coinciden\nVerificar por favor...");
                TxtContrasena.setText("");
                TxtConfirmar.setText("");
                TxtContrasena.requestFocus();
            } else {
                boolean Modificar = UsuariosCAD.modificar(U);

                if (!Modificar) {
                    JOptionPane.showMessageDialog(null, Bandera.getRespuesta());
                    limpiarCampos();
                    mostrarDatos("");
                    // botonesInicio();
                } else {
                    limpiarCampos();
                    botonesInicio(true, false, true, false, false, false, false);
                    buscarSi();
                    mostrarDatos(U.getNombres());
                    LblOk.setText(Bandera.getRespuesta());
                    LblOk.setVisible(true);
                }
            }
        }
        //</editor-fold>
    }//GEN-LAST:event_BtnModificarActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        
    }//GEN-LAST:event_formMouseClicked

    private void LblBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LblBuscarMouseClicked

    }//GEN-LAST:event_LblBuscarMouseClicked

    private void MnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnModificarActionPerformed
        //<editor-fold desc="MENU MODIFICAR" defaultstate="collapsed">
        //habilitarCampos(false, true, false, true, false, true);
        //Seleccion fila modificar
        if(Seleccion()){
            habilitarCampos(false, true, false,false, true, false, true);
        }
        // BtnModificar.setVisible(oPermisos.validarPermiso("Guardar","Usuarios"));
        //</editor-fold>
    }//GEN-LAST:event_MnModificarActionPerformed

    private void MnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnEliminarActionPerformed
        //<editor-fold desc="MENU ELIMINAR" defaultstate="collapsed">
        //habilitarCampos(false, false, false, false, true, true);
        //Seleccion fila Eliminar
        if(Seleccion()){
            habilitarCampos(false, false, false,false, false, true, true);
        }
        //</editor-fold>
    }//GEN-LAST:event_MnEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAgregar;
    private javax.swing.JButton BtnCancelar;
    private javax.swing.JButton BtnEliminar;
    private javax.swing.JButton BtnModificar;
    private javax.swing.JButton BtnNuevo;
    private javax.swing.JComboBox<String> CbxPregunta;
    private javax.swing.JComboBox<String> CbxRoles;
    private javax.swing.JComboBox<String> CbxTipoDoc;
    private com.toedter.calendar.JDateChooser DCFechaNac;
    private javax.swing.JLabel LblBuscar;
    private javax.swing.JLabel LblOk;
    private javax.swing.JMenuItem MnEliminar;
    private javax.swing.JMenuItem MnModificar;
    private javax.swing.JPopupMenu PopM_Tabla;
    public javax.swing.JTable TblConsultarUsuario;
    private javax.swing.JTextField TxtApellido;
    private javax.swing.JTextField TxtBuscar;
    private javax.swing.JPasswordField TxtConfirmar;
    private javax.swing.JPasswordField TxtContrasena;
    private javax.swing.JTextField TxtCorreo;
    private javax.swing.JTextField TxtDireccion;
    private javax.swing.JTextField TxtDocumento;
    private javax.swing.JTextField TxtNombre;
    private javax.swing.JTextField TxtRespuesta;
    private javax.swing.JTextField TxtTelefono;
    private javax.swing.JTextField TxtUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables

    public boolean Seleccion() {

        int fila = TblConsultarUsuario.getSelectedRow();
        if (fila >= 0) {

            CbxTipoDoc.setSelectedIndex(Integer.parseInt(TblConsultarUsuario.getValueAt(fila, 13).toString()));
            TxtDocumento.setText(TblConsultarUsuario.getValueAt(fila, 1).toString());
            TxtNombre.setText(TblConsultarUsuario.getValueAt(fila, 2).toString());
            TxtApellido.setText(TblConsultarUsuario.getValueAt(fila, 3).toString());
            TxtTelefono.setText(TblConsultarUsuario.getValueAt(fila, 4).toString());
            TxtDireccion.setText(TblConsultarUsuario.getValueAt(fila, 5).toString());
            try {
                Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String) TblConsultarUsuario.getValueAt(fila, 6));
                DCFechaNac.setDate(date);
            } catch (ParseException ex) {
                Logger.getLogger(vUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            }
            TxtCorreo.setText(TblConsultarUsuario.getValueAt(fila, 7).toString());
            CbxRoles.setSelectedIndex(Integer.parseInt(TblConsultarUsuario.getValueAt(fila, 14).toString()));
            TxtUsuario.setText(TblConsultarUsuario.getValueAt(fila, 9).toString());
            TxtContrasena.setText(TblConsultarUsuario.getValueAt(fila, 10).toString());
            TxtConfirmar.setText(TblConsultarUsuario.getValueAt(fila, 10).toString());
            CbxPregunta.setSelectedIndex(Integer.parseInt(TblConsultarUsuario.getValueAt(fila, 15).toString()));
            TxtRespuesta.setText(TblConsultarUsuario.getValueAt(fila, 12).toString());
            
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ningun Usuario de la tabla");            
            buscarSi();
            return false;
            
        }
    }

}
