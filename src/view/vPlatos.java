/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import CAD.CargarCAD;
import CAD.IngredientesCAD;
import CAD.PlatosCAD;
import CAD.TablasCAD;
import Config.Bandera;
import Config.Validaciones;
import Model.Ingredientes;
import Model.Platos;
import Model.Productos;
import Model.Secciones;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.text.TableView;

/**
 *
 * @author USUARIO
 */
public class vPlatos extends javax.swing.JInternalFrame {

    /**
     * Creates new form vPlatos
     */
    Map mapIngredientes = new HashMap();
    List QuitarIngredientes = new ArrayList();

    public vPlatos() {
        initComponents();
        botonesInicio(false, false, false, true, false, false, false, false);
        cargarId();
        mostrarDatos("");
    }

    //<editor-fold desc="CARGAR COMBOS" defaultstate="collapsed">       
    void cargarId() {
        //Cargar ID
        CargarCAD oCargarCAD = new CargarCAD();
        Bandera B = new Bandera("Platos", "IdPlato");
        String P = oCargarCAD.cargarIds(B);
        LblIdPlato.setText(P);

        //Cargar Ingredientes
        List ListaComboI = oCargarCAD.CargarIngrediente();
        CbxIngrediente.removeAllItems();
        for (int i = 0; i < ListaComboI.size(); i++) {
            Productos Pr = (Productos) ListaComboI.get(i);
            CbxIngrediente.addItem(Pr.getNombre());
        }

        //Cargar Secciones
        List ListaComboS = oCargarCAD.CargarSeccion();
        CbxSeccion.removeAllItems();
        for (int i = 0; i < ListaComboS.size(); i++) {
            Secciones Sc = (Secciones) ListaComboS.get(i);
            CbxSeccion.addItem(Sc.getNombre());
        }
    }
    //</editor-fold>

    //<editor-fold desc="BOTONES INICIO" defaultstate="collapsed">
    void botonesInicio(boolean Ok, boolean datos, boolean agregar, boolean nuevo, boolean guardar, boolean modificar, boolean eliminar, boolean cancelar) {
        BtnNuevo.requestFocus();
        LblOk.setVisible(Ok);
        /////
        LblIdPlato.setEnabled(datos);
        TxtCodigo.setEnabled(datos);
        CbxSeccion.setEnabled(datos);
        TxtNombre.setEnabled(datos);
        TxtValor.setEnabled(datos);
        /////
        CbxIngrediente.setEnabled(datos);
        TxtCantidad.setEnabled(datos);
        BtnAgregar.setEnabled(agregar);
        /////
        BtnNuevo.setVisible(nuevo);
        /////
        BtnGuardar.setVisible(guardar);
        BtnModificar.setVisible(modificar);
        BtnEliminar.setVisible(eliminar);
        BtnCancelar.setVisible(cancelar);
    }

    void IngredientesInicio() {
        CbxIngrediente.setSelectedIndex(0);
        TxtCantidad.setText("");
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

    //<editor-fold desc="lIMPIAR CAMPOS" defaultstate="collapsed">
    public void limpiarCampos() {
        LblOk.setVisible(false);
        ////
        LblIdPlato.setText("");
        TxtCodigo.setText("");
        TxtNombre.setText("");
        TxtValor.setText("");
        ////
        TxtCantidad.setText("");
        ////
        limpiarTablaIngredientes();
        cargarId();
    }
    //</editor-fold>

    //<editor-fold desc="LIMPIAR TABLA INGREDIENTES" defaultstate="collapsed">
    public void limpiarTablaIngredientes() {
        DefaultTableModel tb = (DefaultTableModel) TblIngredientes.getModel();
        int a = TblIngredientes.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            tb.removeRow(tb.getRowCount() - 1);
        }
    }
    //</editor-fold>

    //<editor-fold desc="MOSTRAR DATOS" defaultstate="collapsed">
    void mostrarDatos(String Valor) {
        TablasCAD ModelTable = new TablasCAD();
        TblConsultarPlatos.setModel(ModelTable.getTablaPlatos(Valor));
        TableColumnModel columnModel = TblConsultarPlatos.getColumnModel();
        for (int i = 0; i < columnModel.getColumnCount(); i++) {
            columnModel.getColumn(i).setPreferredWidth(100);
            ocultarFilas(0);
            ocultarFilas(4);
        }
    }

    void mostrarIngredientes(String Valor) {
        TablasCAD ModelTable = new TablasCAD();
        TblIngredientes.setModel(ModelTable.getTablaIngredientes(Valor));
        TableColumnModel columnModel = TblIngredientes.getColumnModel();
        int j = TblIngredientes.getRowCount();
        for (int i = 0; i < columnModel.getColumnCount(); i++) {
            columnModel.getColumn(i).setPreferredWidth(100);
//            ocultarFilas(0);
//            ocultarFilas(4);    
            verificarMapIngredientes();
        }

    }
    //</editor-fold>

    //<editor-fold desc="VALIDAR MAP INGREDIENTES" defaultstate="collapsed">
    void verificarMapIngredientes() {
        mapIngredientes.clear();
        int j = TblIngredientes.getRowCount();

        for (int k = 0; k < j; k++) {
            mapIngredientes.put(TblIngredientes.getValueAt(k, 0).toString(),
                    TblIngredientes.getValueAt(k, 0).toString());
        }
    }
    //</editor-fold>  

    //<editor-fold desc="LLENAR PLATO E INGREDIENTE" defaultstate="collapsed">
    void llenarPlato(Platos P) {
        P.setIdPlato(LblIdPlato.getText());
        P.setCodigoPlato(TxtCodigo.getText());
        P.setSeccion(CbxSeccion.getSelectedItem().toString());
        P.setNombre(TxtNombre.getText());
        if (TxtValor.getText() == null || TxtValor.getText().equalsIgnoreCase("")) {
            double c = 0;
            P.setValor(c);
        } else {
            P.setValor(Double.parseDouble(TxtValor.getText()));
        }
    }

    void llenarIngrediente(Ingredientes I) {
        I.setIdPlato(LblIdPlato.getText());
        I.setIngrediente(CbxIngrediente.getSelectedItem().toString());
        I.setCantidad(TxtCantidad.getText());
    }
    //</editor-fold>

    //<editor-fold desc="HABILITAR CAMPOS" defaultstate="collapsed">
    void habilitarCampos(boolean id, boolean datos, boolean agregar, boolean nuevo, boolean guardar, boolean modificar, boolean eliminar, boolean cancelar) {
        LblIdPlato.setEnabled(id);
        //
        TxtCodigo.setEnabled(datos);
        CbxSeccion.setEnabled(datos);
        TxtNombre.setEnabled(datos);
        TxtValor.setEnabled(datos);
        ////
        TxtCantidad.setEnabled(datos);
        CbxIngrediente.setEnabled(datos);
        ////
        BtnAgregar.setEnabled(agregar);
        ///   
        BtnNuevo.setVisible(nuevo);
        BtnGuardar.setVisible(guardar);
        BtnModificar.setVisible(modificar);
        BtnEliminar.setVisible(eliminar);
        BtnCancelar.setVisible(cancelar);

        buscarNo();
    }

    //</editor-fold>
    
    //<editor-fold desc="Ocultar Filas" defaultstate="collapsed">
    void ocultarFilas(int index) {
        TblConsultarPlatos.getColumnModel().getColumn(index).setMaxWidth(0);
        TblConsultarPlatos.getColumnModel().getColumn(index).setMinWidth(0);
        TblConsultarPlatos.getColumnModel().getColumn(index).setPreferredWidth(0);

    }

    //</editor-fold>
    
    //<editor-fold desc="VALIDAR TABLA INGREDIENTES" defaultstate="collapsed">
    public boolean validarTablaIngredientes(DefaultTableModel Ingredientes) {
        return Ingredientes.getRowCount() != 0;
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
        PopM_Ingredientes = new javax.swing.JPopupMenu();
        MnModificar_Ingre = new javax.swing.JMenuItem();
        MnEliminar_Ingre = new javax.swing.JMenuItem();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        LblIdPlato = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        TxtCodigo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        TxtNombre = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        TxtValor = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        CbxIngrediente = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        TxtCantidad = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        TblIngredientes = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        BtnAgregar = new javax.swing.JButton();
        LblOk = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TblConsultarPlatos = new javax.swing.JTable();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        LblBuscar = new javax.swing.JLabel();
        TxtBuscar = new javax.swing.JTextField();
        BtnCancelar = new javax.swing.JButton();
        BtnEliminar = new javax.swing.JButton();
        BtnModificar = new javax.swing.JButton();
        BtnGuardar = new javax.swing.JButton();
        BtnNuevo = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        CbxSeccion = new javax.swing.JComboBox<>();

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

        MnModificar_Ingre.setText("Modificar Ingrediente");
        MnModificar_Ingre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnModificar_IngreActionPerformed(evt);
            }
        });
        PopM_Ingredientes.add(MnModificar_Ingre);

        MnEliminar_Ingre.setText("Quitar Ingrediente");
        MnEliminar_Ingre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnEliminar_IngreActionPerformed(evt);
            }
        });
        PopM_Ingredientes.add(MnEliminar_Ingre);

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

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Id Plato :");

        LblIdPlato.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        LblIdPlato.setForeground(new java.awt.Color(255, 0, 0));
        LblIdPlato.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblIdPlato.setText("0001");

        jLabel4.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Codigo Plato :");

        TxtCodigo.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        TxtCodigo.setForeground(new java.awt.Color(255, 0, 0));

        jLabel5.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Nombre :");

        TxtNombre.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        TxtNombre.setForeground(new java.awt.Color(255, 0, 0));

        jLabel6.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Valor :");

        TxtValor.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        TxtValor.setForeground(new java.awt.Color(255, 0, 0));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ingredientes", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Agency FB", 1, 14))); // NOI18N

        CbxIngrediente.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        CbxIngrediente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione...", " " }));

        jLabel8.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Cantidad :");

        TxtCantidad.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        TxtCantidad.setForeground(new java.awt.Color(255, 0, 0));

        TblIngredientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ingrediente", "Cantidad"
            }
        ));
        TblIngredientes.setComponentPopupMenu(PopM_Ingredientes);
        TblIngredientes.setSelectionBackground(new java.awt.Color(255, 0, 0));
        jScrollPane2.setViewportView(TblIngredientes);

        jLabel9.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Ingrediente :");

        BtnAgregar.setBackground(new java.awt.Color(255, 153, 0));
        BtnAgregar.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        BtnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Agregar.png"))); // NOI18N
        BtnAgregar.setToolTipText("Agregar");
        BtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CbxIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TxtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CbxIngrediente)
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TxtCantidad))
                    .addComponent(BtnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        LblOk.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        LblOk.setForeground(new java.awt.Color(0, 153, 51));
        LblOk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Titles/Ok.png"))); // NOI18N
        LblOk.setToolTipText("Operación Exitosa");

        TblConsultarPlatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TblConsultarPlatos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        TblConsultarPlatos.setComponentPopupMenu(PopM_Tabla);
        TblConsultarPlatos.setSelectionBackground(new java.awt.Color(255, 0, 0));
        jScrollPane3.setViewportView(TblConsultarPlatos);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Titles/GestionPlatos.png"))); // NOI18N

        LblBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Buscar.png"))); // NOI18N

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
        BtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarActionPerformed(evt);
            }
        });

        BtnModificar.setBackground(new java.awt.Color(255, 153, 0));
        BtnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Modificar.png"))); // NOI18N
        BtnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnModificarActionPerformed(evt);
            }
        });

        BtnGuardar.setBackground(new java.awt.Color(255, 153, 0));
        BtnGuardar.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        BtnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Guardar.png"))); // NOI18N
        BtnGuardar.setToolTipText("Guardar");
        BtnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGuardarActionPerformed(evt);
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

        jLabel7.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Seccion :");
        jLabel7.setToolTipText("Seccion de Preparación");

        CbxSeccion.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        CbxSeccion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione...", " " }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(LblBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TxtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(LblIdPlato, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(TxtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(CbxSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(TxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(TxtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(LblOk))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(LblIdPlato))
                .addGap(6, 6, 6)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel4))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TxtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)
                        .addComponent(CbxSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel5))
                    .addComponent(TxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel6))
                    .addComponent(TxtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(LblBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(BtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LblOk, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        vPrincipal.ventana = "";
    }//GEN-LAST:event_formInternalFrameClosing

    private void MnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnModificarActionPerformed
        //<editor-fold desc="MENU MODIFICAR" defaultstate="collapsed">
        //Seleccion fila modificar
        if (Seleccion()) {
            TblIngredientes.setEnabled(true);
            habilitarCampos(false, true, true, false, false, true, false, true);
        }
        // BtnModificar.setVisible(oPermisos.validarPermiso("Guardar","Usuarios"));
        //</editor-fold>
    }//GEN-LAST:event_MnModificarActionPerformed

    private void MnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnEliminarActionPerformed
        //<editor-fold desc="MENU ELIMINAR" defaultstate="collapsed">
        //Seleccion fila Eliminar
        if (Seleccion()) {
            TblIngredientes.setEnabled(false);
            habilitarCampos(false, false, false, false, false, false, true, true);
        }
        //</editor-fold>
    }//GEN-LAST:event_MnEliminarActionPerformed

    private void BtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarActionPerformed
        //<editor-fold desc="ELIMINAR" defaultstate="collapsed">
        if (LblIdPlato.getText().equalsIgnoreCase("") || TxtCodigo.getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "No se puede Eliminar el Plato\nVerifique que tenga conexion con la BD");
        } else {
            // Btn Eliminar
            String id = LblIdPlato.getText();
            String Codigo = TxtCodigo.getText();

            Platos Pl = new Platos(id, Codigo);

            boolean Eliminar = PlatosCAD.eliminar(Pl);

            if (!Eliminar) {
                JOptionPane.showMessageDialog(null, Bandera.getRespuesta());
                limpiarCampos();
                mostrarDatos("");
                botonesInicio(false, false, false, true, false, false, false, false);
            } else {
                limpiarCampos();
                botonesInicio(false, false, false, true, false, false, false, false);
                buscarSi();
                LblOk.setText(Bandera.getRespuesta());
                LblOk.setVisible(true);
                Bandera.setRespuesta("");
                mapIngredientes.clear();
            }
        }
        //</editor-fold>
    }//GEN-LAST:event_BtnEliminarActionPerformed

    private void BtnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnModificarActionPerformed
        //<editor-fold desc="MODIFICAR" defaultstate="collapsed">
        // Btn Modificar       
        Map rsp = new HashMap();
        Platos P = new Platos();
        llenarPlato(P);

        rsp.put("Plato", P);

        Validaciones V = new Validaciones();
        V.validarCamposPlatos(rsp);

        if (rsp.containsKey("Mensaje")) {
            JOptionPane.showMessageDialog(null, rsp.get("Mensaje"));
            //            rsp.get("campo");
            //            String Focus = (String)rsp.get("campo");
            //            System.out.println(""+Focus);
        } else {

            boolean tab = validarTablaIngredientes((DefaultTableModel) TblIngredientes.getModel());

            if (!tab) {
                JOptionPane.showMessageDialog(null, "El Plato debe contener como minimo un Ingrediente");
                CbxIngrediente.requestFocus();
                return;
            }

            List ListaIngredientes = new ArrayList();
            int filas = TblIngredientes.getRowCount();
            for (int i = 0; i < filas; i++) {
                String Codigo, Ingrediente, Cantidad;

                Codigo = LblIdPlato.getText();
                Ingrediente = TblIngredientes.getValueAt(i, 0).toString();
                Cantidad = TblIngredientes.getValueAt(i, 1).toString();

                Ingredientes In = new Ingredientes(Codigo, Ingrediente, Cantidad);
                ListaIngredientes.add(In);
            }
            verificarMapIngredientes();
            
            boolean Eliminar = false;
            if (!QuitarIngredientes.isEmpty())Eliminar = IngredientesCAD.eliminar(QuitarIngredientes);
            
            
                boolean Modificar = PlatosCAD.modificar(P, ListaIngredientes);

                if (!Modificar) {
                    JOptionPane.showMessageDialog(null, Bandera.getRespuesta());
                    limpiarCampos();
                    mostrarDatos("");
                    botonesInicio(false, false, false, true, false, false, false, false);
                    mapIngredientes.clear();
                } else {
                    limpiarCampos();
                    botonesInicio(false, false, false, true, false, false, false, false);
                    mostrarDatos("");
                    buscarSi();
                    LblOk.setText(Bandera.getRespuesta());
                    LblOk.setVisible(true);
                    Bandera.setRespuesta("");
                    mapIngredientes.clear();
                }/// Fin if Modificar
                
                QuitarIngredientes.clear();
            

        }
        //</editor-fold>
    }//GEN-LAST:event_BtnModificarActionPerformed

    private void BtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelarActionPerformed
        //<editor-fold desc="CANCELAR" defaultstate="collapsed">
        mostrarDatos("");
        limpiarCampos();
        buscarSi();
        botonesInicio(false, false, false, true, false, false, false, false);
        mapIngredientes.clear();
        //</editor-fold>
    }//GEN-LAST:event_BtnCancelarActionPerformed

    private void BtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGuardarActionPerformed
        //<editor-fold desc="GUARDAR" defaultstate="collapsed">
        // Btn Guardar
        Map rsp = new HashMap();
        Platos P = new Platos();

        llenarPlato(P);

        rsp.put("Plato", P);

        Validaciones V = new Validaciones();
        V.validarCamposPlatos(rsp);

        if (rsp.containsKey("Mensaje")) {
            JOptionPane.showMessageDialog(null, rsp.get("Mensaje"));
            //            rsp.get("campo");
            //            String Focus = (String)rsp.get("campo");
            //            System.out.println(""+Focus);
        } else {

            boolean tab = validarTablaIngredientes((DefaultTableModel) TblIngredientes.getModel());

            if (!tab) {
                JOptionPane.showMessageDialog(null, "El Plato debe contener como minimo un Ingrediente");
                CbxIngrediente.requestFocus();
                return;
            }

            List ListaIngredientes = new ArrayList();
            int filas = TblIngredientes.getRowCount();
            for (int i = 0; i < filas; i++) {
                String Codigo, Ingrediente, Cantidad;

                Codigo = LblIdPlato.getText();
                Ingrediente = TblIngredientes.getValueAt(i, 0).toString();
                Cantidad = TblIngredientes.getValueAt(i, 1).toString();

                Ingredientes In = new Ingredientes(Codigo, Ingrediente, Cantidad);
                ListaIngredientes.add(In);
            }

            boolean guardar = PlatosCAD.guardar(P, ListaIngredientes);

            if (!guardar) {
//                limpiarCampos();
                JOptionPane.showMessageDialog(null, Bandera.getRespuesta());
                TxtNombre.requestFocus();
            } else {
                limpiarCampos();
                LblOk.setText(Bandera.getRespuesta());
                mostrarDatos("");
                botonesInicio(true, false, false, true, false, false, false, false);
                buscarSi();
                LblOk.setVisible(true);
                Bandera.setRespuesta("");
                mapIngredientes.clear();
            }
        }
        //</editor-fold>
    }//GEN-LAST:event_BtnGuardarActionPerformed

    private void BtnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnNuevoActionPerformed
        //<editor-fold desc="NUEVO" defaultstate="collapsed">
        limpiarCampos();
        mostrarDatos("");
        botonesInicio(false, true, true, false, true, false, false, true);
        buscarNo();
        mapIngredientes.clear();
        //</editor-fold>
    }//GEN-LAST:event_BtnNuevoActionPerformed

    private void TxtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtBuscarKeyReleased
        mostrarDatos(TxtBuscar.getText());
    }//GEN-LAST:event_TxtBuscarKeyReleased

    private void TxtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtBuscarKeyPressed
        if (evt.getKeyCode() == 10) {
            mostrarDatos(TxtBuscar.getText());
        }
    }//GEN-LAST:event_TxtBuscarKeyPressed

    private void BtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgregarActionPerformed
        //<editor-fold desc="AGREGAR" defaultstate="collapsed">
        int g = 0;
        Map rsp = new HashMap();
        Ingredientes I = new Ingredientes();
        llenarIngrediente(I);

        rsp.put("Ingrediente", I);

        Validaciones V = new Validaciones();
        V.validarCamposIngredientes(rsp);

        if (rsp.containsKey("Mensaje")) {
            JOptionPane.showMessageDialog(null, rsp.get("Mensaje"));
            //            rsp.get("campo");
            //            String Focus = (String)rsp.get("campo");
            //            System.out.println(""+Focus);
        } else {

            DefaultTableModel modelo = (DefaultTableModel) TblIngredientes.getModel();

            Object[] fila = new Object[2];
            fila[0] = CbxIngrediente.getSelectedItem();
            fila[1] = TxtCantidad.getText();

            int Seleccion = TblIngredientes.getSelectedRow();

            if (mapIngredientes.containsKey(fila[0]) && Seleccion < 0) {
                JOptionPane.showMessageDialog(null, "El ingrediente: " + fila[0] + " ya existe en la tabla.");
                IngredientesInicio();
                return;
            } else if ("Seleccione...".equals(fila[0])) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar un ingrediente.");
                IngredientesInicio();
                return;
            } else if (mapIngredientes.containsKey(fila[0]) && Seleccion >= 0) {
                String W = TblIngredientes.getValueAt(Seleccion, 0).toString();
                if (W.equals(fila[0])) {
                    modelo.removeRow(Seleccion);
                    JOptionPane.showMessageDialog(null, "Se ha modificado el Ingrediente");
                    mapIngredientes.put(fila[0], fila[0]);
                    IngredientesInicio();
                } else {
                    JOptionPane.showMessageDialog(null, "El ingrediente: " + fila[0] + " ya existe en la tabla.");
                    IngredientesInicio();
                    return;
                }
            } ////
            else {
                mapIngredientes.put(fila[0], fila[0]);
            }

            modelo.addRow(fila);
            TblIngredientes.setModel(modelo);
            g = 1;

        }
        if (g == 1) {
            LblOk.setText("Se agrego el ingrediente");
            LblOk.setVisible(true);
            IngredientesInicio();
            g = 0;
        } else {
            JOptionPane.showMessageDialog(null, "El ingrediente no se puedo agregar");
        }

        //</editor-fold>
    }//GEN-LAST:event_BtnAgregarActionPerformed

    private void MnModificar_IngreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnModificar_IngreActionPerformed
        //<editor-fold desc="MENU MODIFICAR INGREDIENTE" defaultstate="collapsed">
        //Seleccion fila modificar
        DefaultTableModel tb = (DefaultTableModel) TblIngredientes.getModel();
        int fila = TblIngredientes.getSelectedRow();
        if (fila >= 0) {
            CbxIngrediente.setSelectedItem(TblIngredientes.getValueAt(fila, 0).toString());
            TxtCantidad.setText(TblIngredientes.getValueAt(fila, 1).toString());

            BtnAgregar.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un ingrediente.");
        }
        //</editor-fold>
    }//GEN-LAST:event_MnModificar_IngreActionPerformed

    private void MnEliminar_IngreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnEliminar_IngreActionPerformed
        //<editor-fold desc="MENU ELIMINAR INGREDIENTE" defaultstate="collapsed">
        //Seleccion fila Eliminar                    
        String Codigo, Ingrediente, Cantidad;

        DefaultTableModel tb = (DefaultTableModel) TblIngredientes.getModel();
        int fila = TblIngredientes.getSelectedRow();
        if (fila >= 0) {
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int opc = JOptionPane.showConfirmDialog(null, "Desea quitar el Ingrediente del plato?", "Advertencia", dialogButton, JOptionPane.WARNING_MESSAGE);
            if (opc == 0) {
                Codigo = LblIdPlato.getText();
                Ingrediente = TblIngredientes.getValueAt(fila, 0).toString();
                Cantidad = TblIngredientes.getValueAt(fila, 1).toString();

                Ingredientes Ing = new Ingredientes(Codigo, Ingrediente, Cantidad);
                QuitarIngredientes.add(Ing);

                mapIngredientes.remove(TblIngredientes.getValueAt(fila, 0).toString());
                tb.removeRow(TblIngredientes.getSelectedRow());

            } else {
                return;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un ingrediente.");
        }
        //</editor-fold>
    }//GEN-LAST:event_MnEliminar_IngreActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAgregar;
    private javax.swing.JButton BtnCancelar;
    private javax.swing.JButton BtnEliminar;
    private javax.swing.JButton BtnGuardar;
    private javax.swing.JButton BtnModificar;
    private javax.swing.JButton BtnNuevo;
    private javax.swing.JComboBox<String> CbxIngrediente;
    private javax.swing.JComboBox<String> CbxSeccion;
    private javax.swing.JLabel LblBuscar;
    private javax.swing.JLabel LblIdPlato;
    private javax.swing.JLabel LblOk;
    private javax.swing.JMenuItem MnEliminar;
    private javax.swing.JMenuItem MnEliminar_Ingre;
    private javax.swing.JMenuItem MnModificar;
    private javax.swing.JMenuItem MnModificar_Ingre;
    private javax.swing.JPopupMenu PopM_Ingredientes;
    private javax.swing.JPopupMenu PopM_Tabla;
    public javax.swing.JTable TblConsultarPlatos;
    private javax.swing.JTable TblIngredientes;
    private javax.swing.JTextField TxtBuscar;
    private javax.swing.JTextField TxtCantidad;
    private javax.swing.JTextField TxtCodigo;
    private javax.swing.JTextField TxtNombre;
    private javax.swing.JTextField TxtValor;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    // End of variables declaration//GEN-END:variables

    public boolean Seleccion() {

        int fila = TblConsultarPlatos.getSelectedRow();
        if (fila >= 0) {

            LblIdPlato.setText(TblConsultarPlatos.getValueAt(fila, 0).toString());
            TxtCodigo.setText(TblConsultarPlatos.getValueAt(fila, 1).toString());
            TxtNombre.setText(TblConsultarPlatos.getValueAt(fila, 2).toString());
            TxtValor.setText(TblConsultarPlatos.getValueAt(fila, 3).toString());
            CbxSeccion.setSelectedIndex(Integer.parseInt(TblConsultarPlatos.getValueAt(fila, 4).toString()));

            mostrarIngredientes(TblConsultarPlatos.getValueAt(fila, 0).toString());

            return true;
        } else {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ningun Plato de la tabla");
            buscarSi();
            return false;

        }
    }
}
