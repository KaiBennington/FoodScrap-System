package view;

import CAD.CargarCAD;
import CAD.CierreSucursalesCAD;
import CAD.TablasCAD;
import Config.Bandera;
import Config.Configuraciones;
import Config.Validaciones;
import Model.CierreSucursal;
import Model.Gastos;
import Model.Platos;
import Model.PlatosVendidos;
import Model.Sucursales;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.sql.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author USUARIO
 */
public class vCierreSucursal extends javax.swing.JInternalFrame {

    /**
     * Creates new form vCierreSucursal
     */
    public Map fritos = new HashMap();
    Map mapGastos = new HashMap();
    Map MapRelease = new HashMap();
    List QuitarGastos = new ArrayList();

    public vCierreSucursal() {
        initComponents();
        TxtTotalBruto.setEditable(false);
        TxtTotalNeto.setEditable(false);

        cargarCombos();
        LblFecha.setText("");
        botonesInicio(false, false, true, false, false, false, false);
        mostrarDatos("");
        llenarFritos();

        MapRelease.put("lblTotal", this.Lbl_ValorFritos);
        MapRelease.put("lblCant", this.Lbl_ItemFritos);
        MapRelease.put("TxtBruto", this.TxtTotalBruto);
        MapRelease.put("TxtNeto", this.TxtTotalNeto);
        MapRelease.put("lblGastos", this.Lbl_ValorGastos);
        MapRelease.put("mapFritos", fritos);
    }

    //<editor-fold desc="LIMPIAR TABLA GASTOS" defaultstate="collapsed">
    public void limpiarTablaGastos() {
        DefaultTableModel tb = (DefaultTableModel) TblGastos.getModel();
        int a = TblGastos.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            tb.removeRow(tb.getRowCount() - 1);
        }
    }
    //</editor-fold>

    //<editor-fold desc="CARGAR FECHA" defaultstate="collapsed">    
    void cargarFecha() {
        java.util.Date d = new java.util.Date();
        LblFecha.setText(d.getDate() + "/" + (d.getMonth() + 1) + "/" + (d.getYear() + 1900));//                         
    }
    //</editor-fold>

    //<editor-fold desc="CARGAR COMBOS" defaultstate="collapsed">    
    void cargarCombos() {
        CargarCAD oCargarCAD = new CargarCAD();
        Bandera B = new Bandera("Cierre_Sucursal", "Num_Factura");
        String P = oCargarCAD.cargarIds(B);
        LblNumFactura.setText(P);

        //Combo Sucursal
        List ListaComboS = oCargarCAD.CargarSucursal();
        CbxSucursal.removeAllItems();
        for (int i = 0; i < ListaComboS.size(); i++) {
            Sucursales Sc = (Sucursales) ListaComboS.get(i);
            CbxSucursal.addItem(Sc.getNombre());
        }
        //                         
    }
    //</editor-fold>

    //<editor-fold desc="BOTONES INICIO" defaultstate="collapsed">
    void botonesInicio(boolean Ok, boolean datos, boolean nuevo, boolean Agregar, boolean modificar, boolean eliminar, boolean cancelar) {
        CbxSucursal.requestFocus();
        LblOk.setVisible(Ok);
        /////
        LblNumFactura.setEnabled(datos);
        CbxSucursal.setEnabled(datos);
        TabPrincipal.setVisible(datos);
        ///
        TxtPapaSale.setEnabled(datos);
        TxtPapaDevuelve.setEnabled(datos);
        TxtBaseInicial.setEnabled(datos);
        ///
        TxtTotalNeto.setEnabled(datos);
        TxtTotalBruto.setEnabled(datos);
        TxtNetoExistente.setEnabled(datos);
        TxtAlcancia.setEnabled(datos);
        Lbl_Resta.setEnabled(datos);

        /////
        BtnNuevo.setVisible(nuevo);
        /////
        BtnAgregar.setVisible(Agregar);
        BtnModificar.setVisible(modificar);
        BtnEliminar.setVisible(eliminar);
        BtnCancelar.setVisible(cancelar);
    }

    void gastosInicio() {
        TxtDescripcionGasto.setText("");
        TxtValorGasto.setText("");
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

    //<editor-fold desc="MOSTRAR DATOS" defaultstate="collapsed">
    void mostrarDatos(String Valor) {
        TablasCAD ModelTable = new TablasCAD();
        TblCierreSucursales.setModel(ModelTable.getTablaCierreSucursal(Valor));
        TableColumnModel columnModel = TblCierreSucursales.getColumnModel();
        for (int i = 0; i < columnModel.getColumnCount(); i++) {
            columnModel.getColumn(i).setPreferredWidth(100);
//            ocultarFilas(0);
        }
    }

    void mostrarGastos(String Valor) {
        TablasCAD ModelTable = new TablasCAD();
        TblGastos.setModel(ModelTable.getTablaGastos(Valor));
        TableColumnModel columnModel = TblGastos.getColumnModel();
//        int j = TblGastos.getRowCount();
        for (int i = 0; i < columnModel.getColumnCount(); i++) {
            columnModel.getColumn(i).setPreferredWidth(100);
//            ocultarFilas(0);
//            ocultarFilas(4);    
//            verificarMapIngredientes();
        }
    }

    void mostrarPlatosVendidos(String Valor) {
        //Cargar Platos Vendidos        
        CargarCAD oCargarCAD = new CargarCAD();
        List ListaComboPv = oCargarCAD.CargarPlatosVendidos(Valor);

        Iterator it = ((Map) MapRelease.get("mapFritos")).entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();

            componenteFritos oComponenteFritos = ((componenteFritos) entry.getValue());
            oComponenteFritos.txtCantidad.setText("0");
            
            for (int i = 0; i < ListaComboPv.size(); i++) {
                PlatosVendidos Pv = (PlatosVendidos) ListaComboPv.get(i);

                if (oComponenteFritos.LblCodigo.getText().equals(Pv.getCodigoPlato())) {
                    oComponenteFritos.txtCantidad.setText(Pv.getCantidad());
                    break;
                }
            }// Fin For            
            oComponenteFritos.Suma();
        }// Fin While
    }
    //</editor-fold>

    //<editor-fold desc="LLENAR FRITOS" defaultstate="collapsed">    
    private void llenarFritos() {
        int index = 0, y = 0;

        CargarCAD oCargarCAD = new CargarCAD();
        List ListaPlatos = oCargarCAD.CargarPlatos();

        while (index < ListaPlatos.size()) {
            componenteFritos jpc = new componenteFritos(index, this.MapRelease);
            Platos oPlatoDetalle = (Platos) ListaPlatos.get(index);

            jpc.LblCodigo.setText(oPlatoDetalle.getCodigoPlato());
            jpc.lblNombre.setText(oPlatoDetalle.getNombre() + "");
            jpc.lblValor.setText("" + (oPlatoDetalle.getValor() * Double.parseDouble(jpc.txtCantidad.getText())));
            jpc.txtValorUnitario.setText("" + oPlatoDetalle.getValor());
            jpc.LblSeccion.setText(oPlatoDetalle.getSeccion());
            //
            jpc.txtCantidad.getText();
            // damos valores a X,Y,Ancho,Alto
            jpc.setBounds(0, y, 265, 35);

            jPanel5.add(jpc);//se añade al jpanel
            jPanel5.updateUI();// Se actualiza el panel para refrescar los elementos
            //se añade al MAP
            this.fritos.put(oPlatoDetalle.getCodigoPlato(), jpc);
            index++;
            y = y + 35;
        }
    }
    //</editor-fold>

    //<editor-fold desc="lIMPIAR CAMPOS" defaultstate="collapsed">
    public void limpiarCampos() {
        LblOk.setVisible(false);
        //-- JP_Gastos
        TxtDescripcionGasto.setText("");
        TxtValorGasto.setText("");
        Lbl_ItemGastos.setText("0");
        Lbl_ValorGastos.setText("0");
        //-- JP_Platos Vendidos        
        Lbl_ItemFritos.setText("0");
        Lbl_ValorFritos.setText("0");
        ///    
        TxtPapaSale.setText("");
        TxtPapaDevuelve.setText("");
        //-
        TxtBaseInicial.setText("");
        //-
        TxtTotalNeto.setText("");
        TxtTotalBruto.setText("");
        TxtNetoExistente.setText("");
        TxtAlcancia.setText("");
        Lbl_Resta.setText("0");
        //---
        limpiarTablaGastos();
        //
        TxtBuscar.setText("");
//        cargarId();
    }

    void limpiarComponentes() {
        Iterator it = ((Map) MapRelease.get("mapFritos")).entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            //se recupera el componente
            componenteFritos oComponenteFritos = ((componenteFritos) entry.getValue());
            oComponenteFritos.txtCantidad.setText("0");
            oComponenteFritos.lblValor.setText("0.0");
        }
    }
    //</editor-fold>

    //<editor-fold desc="LLENAR GASTOS" defaultstate="collapsed">
    void llenarGasto(Gastos G) {
        G.setIdFactura(Integer.parseInt(LblNumFactura.getText()));
        G.setDescripcion(TxtDescripcionGasto.getText().toUpperCase());
        if (TxtValorGasto.getText() == null || TxtValorGasto.getText().equalsIgnoreCase("")) {
            double c = 0;
            G.setValor(c);
        } else {
            G.setValor(Double.parseDouble(TxtValorGasto.getText()));
        }
    }
    //</editor-fold>

    //<editor-fold desc="PARSEOS" defaultstate="collapsed">
    double decimal(JTextField JT) {

        if ("".equals(JT.getText()) || JT.getText() == null) {
            return 0;
        }

        return Double.parseDouble(JT.getText());
    }
    //</editor-fold>

    //<editor-fold desc="LLENAR CIERRE SUCURSAL" defaultstate="collapsed">
    void llenarCierreSucursal(CierreSucursal Cs) {
        Cs.setNumFactura(Integer.parseInt(LblNumFactura.getText()));
        Date fechaF = new Date(new java.util.Date(LblFecha.getText()).getTime());
        Cs.setFechaFactura(fechaF);
        Cs.setSucursal(CbxSucursal.getSelectedItem().toString());
        Cs.setP_Sale(decimal(TxtPapaSale));
        Cs.setP_Devuelve(decimal(TxtPapaDevuelve));
        Cs.setBaseInicial(decimal(TxtBaseInicial));
        Cs.setAlcancia(decimal(TxtAlcancia));
        Cs.setNetoExistente(decimal(TxtNetoExistente));
        Cs.setTotalNeto(decimal(TxtTotalNeto));
        Cs.setTotalBruto(decimal(TxtTotalBruto));
        Cs.setResta(Double.parseDouble((Lbl_Resta.getText())));
    }
    //</editor-fold>

    //<editor-fold desc="VALIDAR TABLA GASTOS" defaultstate="collapsed">
    public boolean validarTablaGastos(DefaultTableModel Gastos) {
        return Gastos.getRowCount() != 0;
    }
    //</editor-fold>

    //<editor-fold desc="VALIDAR PLATOS VENDIDOS" defaultstate="collapsed">
    public ArrayList validarPlatosVendidos(Map PlatoVendido) {

        ArrayList ListaPlatosVendidos = new ArrayList();
        int NFactura;
        String CodigoPlato, CantidadPlato;

        Iterator it = ((Map) PlatoVendido.get("mapFritos")).entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();

            componenteFritos oComponenteFritos = ((componenteFritos) entry.getValue());

            if (!oComponenteFritos.txtCantidad.getText().equals("0")) {
                CodigoPlato = oComponenteFritos.LblCodigo.getText();
                NFactura = Integer.parseInt(LblNumFactura.getText());
                CantidadPlato = oComponenteFritos.txtCantidad.getText();

                PlatosVendidos Pv = new PlatosVendidos(CodigoPlato, NFactura, CantidadPlato);
                ListaPlatosVendidos.add(Pv);
            }
        }
        return ListaPlatosVendidos;
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

        PopM_Gastos = new javax.swing.JPopupMenu();
        MnModificar_Gasto = new javax.swing.JMenuItem();
        MnEliminar_Gasto = new javax.swing.JMenuItem();
        PopM_Tabla = new javax.swing.JPopupMenu();
        MnModificar = new javax.swing.JMenuItem();
        MnEliminar = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        LblNumFactura = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        LblFecha = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        CbxSucursal = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        TabPrincipal = new javax.swing.JTabbedPane();
        JP_Gastos = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        TxtDescripcionGasto = new javax.swing.JTextField();
        TxtValorGasto = new javax.swing.JTextField();
        BtnAgregarGasto = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblGastos = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        Lbl_ItemGastos = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        Lbl_ValorGastos = new javax.swing.JLabel();
        JP_Platos = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel5 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        Lbl_ValorFritos = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        Lbl_ItemFritos = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        TxtPapaDevuelve = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        TxtPapaSale = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        TxtTotalBruto = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        TxtTotalNeto = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        TxtNetoExistente = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        Lbl_Resta = new javax.swing.JLabel();
        TxtBaseInicial = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        TxtAlcancia = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        LblBuscar = new javax.swing.JLabel();
        TxtBuscar = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        TblCierreSucursales = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        BtnNuevo = new javax.swing.JButton();
        BtnAgregar = new javax.swing.JButton();
        BtnModificar = new javax.swing.JButton();
        BtnEliminar = new javax.swing.JButton();
        BtnCancelar = new javax.swing.JButton();
        LblOk = new javax.swing.JLabel();

        MnModificar_Gasto.setText("Modificar Ingrediente");
        MnModificar_Gasto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnModificar_GastoActionPerformed(evt);
            }
        });
        PopM_Gastos.add(MnModificar_Gasto);

        MnEliminar_Gasto.setText("Quitar Ingrediente");
        MnEliminar_Gasto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnEliminar_GastoActionPerformed(evt);
            }
        });
        PopM_Gastos.add(MnEliminar_Gasto);

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

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Titles/CierreSucursales.png"))); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel2.setText("N° Factura :");

        LblNumFactura.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        LblNumFactura.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblNumFactura.setText("00001");

        jLabel4.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Fecha :");

        LblFecha.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        LblFecha.setForeground(new java.awt.Color(255, 0, 0));
        LblFecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        CbxSucursal.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        CbxSucursal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CbxSucursal.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CbxSucursalItemStateChanged(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel6.setText("Negocio/Sucursal :");

        TabPrincipal.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N

        JP_Gastos.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        TxtDescripcionGasto.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        TxtDescripcionGasto.setForeground(new java.awt.Color(255, 0, 0));
        TxtDescripcionGasto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TxtDescripcionGasto.setToolTipText("Descripción");
        TxtDescripcionGasto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtDescripcionGastoKeyReleased(evt);
            }
        });

        TxtValorGasto.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        TxtValorGasto.setForeground(new java.awt.Color(255, 0, 0));
        TxtValorGasto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TxtValorGasto.setToolTipText("Valor");
        TxtValorGasto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtValorGastoActionPerformed(evt);
            }
        });
        TxtValorGasto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtValorGastoKeyTyped(evt);
            }
        });

        BtnAgregarGasto.setBackground(new java.awt.Color(255, 153, 0));
        BtnAgregarGasto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Agregar.png"))); // NOI18N
        BtnAgregarGasto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgregarGastoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TxtDescripcionGasto, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TxtValorGasto, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnAgregarGasto, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TxtDescripcionGasto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(BtnAgregarGasto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(TxtValorGasto, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TblGastos.setBackground(new java.awt.Color(255, 255, 255));
        TblGastos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Descripcón", "Valor"
            }
        ));
        TblGastos.setComponentPopupMenu(PopM_Gastos);
        TblGastos.setSelectionBackground(new java.awt.Color(255, 0, 0));
        jScrollPane1.setViewportView(TblGastos);

        jLabel8.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel8.setText("Cant Items :");

        Lbl_ItemGastos.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        Lbl_ItemGastos.setForeground(new java.awt.Color(255, 0, 0));
        Lbl_ItemGastos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Lbl_ItemGastos.setText("0");

        jLabel10.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel10.setText("Valor Total :");

        Lbl_ValorGastos.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        Lbl_ValorGastos.setForeground(new java.awt.Color(255, 0, 0));
        Lbl_ValorGastos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Lbl_ValorGastos.setText("0.0");

        javax.swing.GroupLayout JP_GastosLayout = new javax.swing.GroupLayout(JP_Gastos);
        JP_Gastos.setLayout(JP_GastosLayout);
        JP_GastosLayout.setHorizontalGroup(
            JP_GastosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_GastosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JP_GastosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(JP_GastosLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Lbl_ItemGastos, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Lbl_ValorGastos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        JP_GastosLayout.setVerticalGroup(
            JP_GastosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_GastosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JP_GastosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Lbl_ItemGastos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Lbl_ValorGastos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TabPrincipal.addTab("Gastos", JP_Gastos);

        JP_Platos.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane3.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jScrollPane3.setToolTipText("");

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 268, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 371, Short.MAX_VALUE)
        );

        jScrollPane3.setViewportView(jPanel5);

        jLabel15.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel15.setText("Valor Total :");

        Lbl_ValorFritos.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        Lbl_ValorFritos.setForeground(new java.awt.Color(255, 0, 0));
        Lbl_ValorFritos.setText("0.00");
        Lbl_ValorFritos.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                Lbl_ValorFritosInputMethodTextChanged(evt);
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
        });

        jLabel13.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel13.setText("CPV");
        jLabel13.setToolTipText("Cantidad Platos Vendidos");

        Lbl_ItemFritos.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        Lbl_ItemFritos.setForeground(new java.awt.Color(255, 0, 0));
        Lbl_ItemFritos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Lbl_ItemFritos.setText("0");

        javax.swing.GroupLayout JP_PlatosLayout = new javax.swing.GroupLayout(JP_Platos);
        JP_Platos.setLayout(JP_PlatosLayout);
        JP_PlatosLayout.setHorizontalGroup(
            JP_PlatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_PlatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JP_PlatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(JP_PlatosLayout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Lbl_ItemFritos, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Lbl_ValorFritos, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        JP_PlatosLayout.setVerticalGroup(
            JP_PlatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_PlatosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JP_PlatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Lbl_ValorFritos, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Lbl_ItemFritos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        TabPrincipal.addTab("Platos Vendidos", JP_Platos);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "PAPA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Agency FB", 1, 14))); // NOI18N

        TxtPapaDevuelve.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        TxtPapaDevuelve.setForeground(new java.awt.Color(255, 0, 0));
        TxtPapaDevuelve.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TxtPapaDevuelve.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TxtPapaDevuelveFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                TxtPapaDevuelveFocusLost(evt);
            }
        });
        TxtPapaDevuelve.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtPapaDevuelveKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtPapaDevuelveKeyTyped(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("Devuelve :");

        jLabel7.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Sale :");

        TxtPapaSale.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        TxtPapaSale.setForeground(new java.awt.Color(255, 0, 0));
        TxtPapaSale.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TxtPapaSale.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TxtPapaSaleFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                TxtPapaSaleFocusLost(evt);
            }
        });
        TxtPapaSale.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtPapaSaleKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtPapaSaleKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel16))
                .addGap(12, 12, 12)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TxtPapaSale, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                    .addComponent(TxtPapaDevuelve))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(TxtPapaSale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(TxtPapaDevuelve, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jLabel5.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Total Neto ");

        TxtTotalBruto.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        TxtTotalBruto.setForeground(new java.awt.Color(153, 153, 153));
        TxtTotalBruto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TxtTotalBruto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtTotalBrutoKeyTyped(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel19.setText("Total Bruto :");

        TxtTotalNeto.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        TxtTotalNeto.setForeground(new java.awt.Color(153, 153, 153));
        TxtTotalNeto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TxtTotalNeto.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                TxtTotalNetoInputMethodTextChanged(evt);
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        TxtTotalNeto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtTotalNetoKeyTyped(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel20.setText("Neto Existente :");

        TxtNetoExistente.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        TxtNetoExistente.setForeground(new java.awt.Color(51, 51, 255));
        TxtNetoExistente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TxtNetoExistente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtNetoExistenteKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtNetoExistenteKeyTyped(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel21.setText("Resta :");

        Lbl_Resta.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        Lbl_Resta.setForeground(new java.awt.Color(255, 0, 0));
        Lbl_Resta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Lbl_Resta.setText("0");

        TxtBaseInicial.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        TxtBaseInicial.setForeground(new java.awt.Color(255, 0, 0));
        TxtBaseInicial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TxtBaseInicial.setText("0");
        TxtBaseInicial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                TxtBaseInicialFocusLost(evt);
            }
        });
        TxtBaseInicial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                TxtBaseInicialMouseExited(evt);
            }
        });
        TxtBaseInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtBaseInicialKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtBaseInicialKeyTyped(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel18.setText("Base :");

        TxtAlcancia.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        TxtAlcancia.setForeground(new java.awt.Color(255, 0, 0));
        TxtAlcancia.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TxtAlcancia.setText("0");
        TxtAlcancia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtAlcanciaKeyTyped(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel23.setText("Alcancia :");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jSeparator5))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TxtAlcancia, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                            .addComponent(TxtNetoExistente)
                            .addComponent(TxtBaseInicial))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(TxtTotalBruto, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                                .addComponent(Lbl_Resta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(TxtTotalNeto, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(92, 92, 92)))
                .addGap(15, 15, 15))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(TxtBaseInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(TxtAlcancia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(TxtNetoExistente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(TxtTotalNeto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(TxtTotalBruto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Lbl_Resta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);

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

        TblCierreSucursales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TblCierreSucursales.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        TblCierreSucursales.setComponentPopupMenu(PopM_Tabla);
        TblCierreSucursales.setSelectionBackground(new java.awt.Color(255, 0, 0));
        jScrollPane4.setViewportView(TblCierreSucursales);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        BtnNuevo.setBackground(new java.awt.Color(255, 153, 0));
        BtnNuevo.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        BtnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Nuevo.png"))); // NOI18N
        BtnNuevo.setToolTipText("Nuevo");
        BtnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnNuevoActionPerformed(evt);
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

        BtnModificar.setBackground(new java.awt.Color(255, 153, 0));
        BtnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Modificar.png"))); // NOI18N
        BtnModificar.setToolTipText("Modificar");
        BtnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnModificarActionPerformed(evt);
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

        BtnCancelar.setBackground(new java.awt.Color(255, 153, 0));
        BtnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Cancelar.png"))); // NOI18N
        BtnCancelar.setToolTipText("Cancelar");
        BtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(BtnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        LblOk.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        LblOk.setForeground(new java.awt.Color(0, 153, 51));
        LblOk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Titles/Ok.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TabPrincipal, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(LblNumFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(LblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(CbxSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(LblOk)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(LblBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TxtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LblBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(LblNumFactura, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(LblFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(CbxSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TabPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(LblOk, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        TabPrincipal.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        vPrincipal.ventana = "";
    }//GEN-LAST:event_formInternalFrameClosing

    private void TxtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtBuscarKeyPressed
        if (evt.getKeyCode() == 10) {
            LblOk.setVisible(false);
            mostrarDatos(TxtBuscar.getText());
        }
    }//GEN-LAST:event_TxtBuscarKeyPressed

    private void TxtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtBuscarKeyReleased
        LblOk.setVisible(false);
        mostrarDatos(TxtBuscar.getText());
    }//GEN-LAST:event_TxtBuscarKeyReleased

    private void BtnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnNuevoActionPerformed
        //<editor-fold desc="NUEVO" defaultstate="collapsed">    
        cargarCombos();
        botonesInicio(false, false, false, false, false, false, true);
        CbxSucursal.setEnabled(true);
        CbxSucursal.requestFocus();
        TxtBuscar.setText("");
        //</editor-fold>
    }//GEN-LAST:event_BtnNuevoActionPerformed

    private void BtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgregarActionPerformed
        //<editor-fold desc="GUARDAR" defaultstate="collapsed">
        // Btn Guardar
        calcularResta();
        Map rsp = new HashMap();
        CierreSucursal Cs = new CierreSucursal();
        llenarCierreSucursal(Cs);

        rsp.put("CierreSucursal", Cs);

        Validaciones V = new Validaciones();
        V.validarCamposCierreSucursal(rsp);

        if (rsp.containsKey("Mensaje")) {
            JOptionPane.showMessageDialog(null, rsp.get("Mensaje"));
        } else {

            boolean tabGastos = validarTablaGastos((DefaultTableModel) TblGastos.getModel());

            List ListaGastos = new ArrayList();
            if (tabGastos) {

                int filas = TblGastos.getRowCount();
                for (int i = 0; i < filas; i++) {
                    int NumFact;
                    String Descripcion;
                    double Valor;

                    NumFact = Integer.parseInt(LblNumFactura.getText());
                    Descripcion = TblGastos.getValueAt(i, 0).toString();
                    Valor = Double.parseDouble(TblGastos.getValueAt(i, 1).toString());

                    Gastos Gs = new Gastos(NumFact, Descripcion, Valor);
                    ListaGastos.add(Gs);
                }// Fin For
            }// Fin IF (tabGastos)

            ArrayList ListaPlatosVendidos = validarPlatosVendidos(MapRelease);

            if (ListaPlatosVendidos.isEmpty()) {

                JOptionPane.showMessageDialog(null, "No se vendieron platos");
                return;
            }// Fin IF (tabPlatosVendidos)

            boolean guardar = CierreSucursalesCAD.guardar(Cs, ListaPlatosVendidos, ListaGastos);

            if (!guardar) {
                ListaPlatosVendidos.clear();
                ListaGastos.clear();
                limpiarCampos();
                botonesInicio(true, false, true, false, false, false, false);
                buscarSi();
                mostrarDatos("");
                JOptionPane.showMessageDialog(null, Bandera.getRespuesta());
                BtnNuevo.requestFocus();
                Bandera.setRespuesta("");
            } else {
                ListaPlatosVendidos.clear();
                ListaGastos.clear();
                limpiarCampos();
                botonesInicio(true, false, true, false, false, false, false);
                cargarCombos();
                buscarSi();
                mostrarDatos("");
                LblOk.setText(Bandera.getRespuesta());
                LblOk.setVisible(true);
                Bandera.setRespuesta("");
            }
        }
        //</editor-fold>
    }//GEN-LAST:event_BtnAgregarActionPerformed

    private void BtnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnModificarActionPerformed
        //<editor-fold desc="MODIFICAR" defaultstate="collapsed">
        // Btn Modificar
        calcularResta();
        Map rsp = new HashMap();
        CierreSucursal Cs = new CierreSucursal();
        llenarCierreSucursal(Cs);

        rsp.put("CierreSucursal", Cs);

        Validaciones V = new Validaciones();
        V.validarCamposCierreSucursal(rsp);

        if (rsp.containsKey("Mensaje")) {
            JOptionPane.showMessageDialog(null, rsp.get("Mensaje"));
        } else {

            boolean tabGastos = validarTablaGastos((DefaultTableModel) TblGastos.getModel());

            List ListaGastos = new ArrayList();
            if (tabGastos) {

                int filas = TblGastos.getRowCount();
                for (int i = 0; i < filas; i++) {
                    int NumFact;
                    String Descripcion;
                    double Valor;

                    NumFact = Integer.parseInt(LblNumFactura.getText());
                    Descripcion = TblGastos.getValueAt(i, 0).toString();
                    Valor = Double.parseDouble(TblGastos.getValueAt(i, 1).toString());

                    Gastos Gs = new Gastos(NumFact, Descripcion, Valor);
                    ListaGastos.add(Gs);
                }// Fin For
            }// Fin IF (tabGastos)

            ArrayList ListaPlatosVendidos = validarPlatosVendidos(MapRelease);

            if (ListaPlatosVendidos.isEmpty()) {

                JOptionPane.showMessageDialog(null, "No se vendieron platos");
                return;
            }// Fin IF (tabPlatosVendidos)

            boolean guardar = CierreSucursalesCAD.modificar(Cs, ListaPlatosVendidos, ListaGastos);

            if (!guardar) {
                ListaPlatosVendidos.clear();
                ListaGastos.clear();
                limpiarCampos();
                botonesInicio(true, false, true, false, false, false, false);
                buscarSi();
                mostrarDatos("");
                JOptionPane.showMessageDialog(null, Bandera.getRespuesta());
                BtnNuevo.requestFocus();
                Bandera.setRespuesta("");
            } else {
                ListaPlatosVendidos.clear();
                ListaGastos.clear();
                limpiarCampos();
                botonesInicio(true, false, true, false, false, false, false);
                cargarCombos();
                buscarSi();
                mostrarDatos("");
                LblOk.setText(Bandera.getRespuesta());
                LblOk.setVisible(true);
                Bandera.setRespuesta("");
            }
        }
        //</editor-fold>
    }//GEN-LAST:event_BtnModificarActionPerformed

    private void BtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarActionPerformed
        //<editor-fold desc="ELIMINAR" defaultstate="collapsed">
        if (Lbl_IdProveedor.getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "No se puede Eliminar el Proveedor\nNo se encuentra el Codigo\nVerifique que tenga conexion con la BD");
        } else {
            // Btn Eliminar
            String Codigo = Lbl_IdProveedor.getText();

            Proveedores Pr = new Proveedores();
            Pr.setCodigo(Codigo);

            boolean Eliminar = ProveedoresCAD.eliminar(Pr);

            if (!Eliminar) {
                JOptionPane.showMessageDialog(null, Bandera.getRespuesta());
                limpiarCampos();
                mostrarDatos("");
                botonesInicio(false, false, true, false, false, false, false);
            } else {
                limpiarCampos();
                botonesInicio(false, false, true, false, false, false, false);
                mostrarDatos("");
                LblOk.setText(Bandera.getRespuesta());
                LblOk.setVisible(true);
                buscarSi();
                Bandera.setRespuesta("");
            }
        }
        //</editor-fold>
    }//GEN-LAST:event_BtnEliminarActionPerformed

    private void BtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelarActionPerformed
        //<editor-fold desc="CANCELAR" defaultstate="collapsed">
        botonesInicio(false, false, true, false, false, false, false);
        mostrarDatos("");
        limpiarCampos();
        limpiarComponentes();
        CbxSucursal.setSelectedIndex(0);
        buscarSi();
        LblFecha.setText("");
        BtnNuevo.requestFocus();
        //</editor-fold>
    }//GEN-LAST:event_BtnCancelarActionPerformed

    private void CbxSucursalItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CbxSucursalItemStateChanged
        if (CbxSucursal.getSelectedIndex() <= 0) {
            botonesInicio(false, false, true, false, false, false, false);
            mostrarDatos("");
            buscarSi();
            LblFecha.setText("");
            BtnNuevo.requestFocus();
            limpiarCampos();
        } else {
            botonesInicio(false, true, false, true, false, false, true);
            limpiarCampos();
            limpiarComponentes();
            mostrarDatos("");
            cargarFecha();
            buscarNo();
        }
    }//GEN-LAST:event_CbxSucursalItemStateChanged

    private void BtnAgregarGastoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgregarGastoActionPerformed
        //<editor-fold desc="AGREGAR" defaultstate="collapsed">
        int g = 0;
        Map rsp = new HashMap();
        Gastos G = new Gastos();
        llenarGasto(G);

        rsp.put("Gasto", G);

        Validaciones V = new Validaciones();
        V.validarCamposGastos(rsp);

        if (rsp.containsKey("Mensaje")) {
            JOptionPane.showMessageDialog(null, rsp.get("Mensaje"));
            //            rsp.get("campo");
            //            String Focus = (String)rsp.get("campo");
            //            System.out.println(""+Focus);
        } else {

            DefaultTableModel modelo = (DefaultTableModel) TblGastos.getModel();

            Object[] fila = new Object[2];
            fila[0] = TxtDescripcionGasto.getText().toUpperCase();
            fila[1] = TxtValorGasto.getText();

            int Seleccion = TblGastos.getSelectedRow();

            if (mapGastos.containsKey(fila[0]) && Seleccion < 0) {
                JOptionPane.showMessageDialog(null, "El Gasto: " + fila[0] + " ya existe en la tabla.");
                gastosInicio();
                calcularResta();
                return;
            } else if ("".equals(fila[0])) {
                JOptionPane.showMessageDialog(null, "El Gasto necesita una descripcion.");
                gastosInicio();
                calcularResta();
                return;
            } else if (mapGastos.containsKey(fila[0]) && Seleccion >= 0) {
                String W = TblGastos.getValueAt(Seleccion, 0).toString();
                if (W.equals(fila[0])) {
                    modelo.removeRow(Seleccion);
                    JOptionPane.showMessageDialog(null, "Se ha modificado el Gasto");
                    mapGastos.put(fila[0], fila[0]);
                    gastosInicio();
                    calcularResta();
                } else {
                    JOptionPane.showMessageDialog(null, "El Gasto: " + fila[0] + " ya existe en la tabla.");
                    gastosInicio();
                    calcularResta();
                    return;
                }
            } ////
            else {
                mapGastos.put(fila[0], fila[0]);
                calcularResta();
            }

            modelo.addRow(fila);
            TblGastos.setModel(modelo);
            g = 1;

        }
        if (g == 1) {
            LblOk.setText("Se agrego el Gasto");
            LblOk.setVisible(true);
            gastosInicio();
            calcularResta();
            g = 0;
        } else {
            JOptionPane.showMessageDialog(null, "El Gasto no se puedo agregar");
            calcularResta();
        }
        gastos();
        calcularResta();
        TxtDescripcionGasto.setEnabled(true);
        //</editor-fold>
    }//GEN-LAST:event_BtnAgregarGastoActionPerformed

    private void TxtValorGastoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtValorGastoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtValorGastoActionPerformed

    private void TxtValorGastoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtValorGastoKeyTyped
        Configuraciones.soloNumeros(evt, TxtValorGasto);
    }//GEN-LAST:event_TxtValorGastoKeyTyped

    private void Lbl_ValorFritosInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_Lbl_ValorFritosInputMethodTextChanged

    }//GEN-LAST:event_Lbl_ValorFritosInputMethodTextChanged

    private void TxtPapaSaleKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtPapaSaleKeyTyped
        Configuraciones.soloNumeros(evt, TxtPapaSale);
    }//GEN-LAST:event_TxtPapaSaleKeyTyped

    private void TxtPapaDevuelveKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtPapaDevuelveKeyTyped
        Configuraciones.soloNumeros(evt, TxtPapaDevuelve);
    }//GEN-LAST:event_TxtPapaDevuelveKeyTyped

    private void TxtBaseInicialKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtBaseInicialKeyTyped
        Configuraciones.soloNumeros(evt, TxtBaseInicial);
    }//GEN-LAST:event_TxtBaseInicialKeyTyped

    private void TxtAlcanciaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtAlcanciaKeyTyped
        Configuraciones.soloNumeros(evt, TxtAlcancia);
    }//GEN-LAST:event_TxtAlcanciaKeyTyped

    private void TxtNetoExistenteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtNetoExistenteKeyTyped
        Configuraciones.soloNumeros(evt, TxtNetoExistente);
    }//GEN-LAST:event_TxtNetoExistenteKeyTyped

    private void TxtTotalNetoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtTotalNetoKeyTyped
        Configuraciones.soloNumeros(evt, TxtTotalNeto);
    }//GEN-LAST:event_TxtTotalNetoKeyTyped

    private void TxtTotalBrutoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtTotalBrutoKeyTyped
        Configuraciones.soloNumeros(evt, TxtTotalBruto);
    }//GEN-LAST:event_TxtTotalBrutoKeyTyped

    private void MnModificar_GastoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnModificar_GastoActionPerformed
        //<editor-fold desc="MENU MODIFICAR GASTO" defaultstate="collapsed">
        //Seleccion fila modificar
//        DefaultTableModel tb = (DefaultTableModel) TblGastos.getModel();
        int fila = TblGastos.getSelectedRow();
        if (fila >= 0) {
            TxtDescripcionGasto.setText(TblGastos.getValueAt(fila, 0).toString());
            TxtValorGasto.setText(TblGastos.getValueAt(fila, 1).toString());

            TxtDescripcionGasto.setEnabled(false);
            TxtValorGasto.requestFocus();
            BtnAgregar.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un Gasto.");
        }
        //</editor-fold>
    }//GEN-LAST:event_MnModificar_GastoActionPerformed

    private void MnEliminar_GastoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnEliminar_GastoActionPerformed
        //<editor-fold desc="MENU ELIMINAR GASTO" defaultstate="collapsed">
        //Seleccion fila Eliminar
        String Descripcion;
        int Codigo;
        double Valor;

        DefaultTableModel tb = (DefaultTableModel) TblGastos.getModel();
        int fila = TblGastos.getSelectedRow();
        if (fila >= 0) {
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int opc = JOptionPane.showConfirmDialog(null, "Desea quitar este gasto del cierre?", "Advertencia", dialogButton, JOptionPane.WARNING_MESSAGE);
            if (opc == 0) {
                Codigo = Integer.parseInt(LblNumFactura.getText());
                Descripcion = TblGastos.getValueAt(fila, 0).toString();
                Valor = Double.parseDouble(TblGastos.getValueAt(fila, 1).toString());

                Gastos oGas = new Gastos(Codigo, Descripcion, Valor);
                QuitarGastos.add(oGas);

                mapGastos.remove(TblGastos.getValueAt(fila, 0).toString());
                tb.removeRow(fila);
                gastos();

            } else {
                return;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un Gasto.");
        }
        //</editor-fold>
    }//GEN-LAST:event_MnEliminar_GastoActionPerformed

    private void TxtPapaSaleKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtPapaSaleKeyReleased
//        if (TxtPapaSale.getText() == null || TxtPapaSale.getText().equalsIgnoreCase("")) {
//            TxtPapaSale.setText(""+0);
//        }
    }//GEN-LAST:event_TxtPapaSaleKeyReleased

    private void TxtPapaDevuelveKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtPapaDevuelveKeyReleased
//        double Sale, Devuelve, Vendida;
//        if (TxtPapaDevuelve.getText() == null || TxtPapaDevuelve.getText().equalsIgnoreCase("")) {
//            TxtPapaDevuelve.setText("0");
//        } else {
//            Sale = Double.parseDouble(TxtPapaSale.getText());
//            Devuelve = Double.parseDouble(TxtPapaDevuelve.getText());
//            Vendida = (Sale - Devuelve);
//
//            LblPapaVendida.setText(Double.toString(Vendida));
//        }

    }//GEN-LAST:event_TxtPapaDevuelveKeyReleased

    private void TxtPapaSaleFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TxtPapaSaleFocusGained
        vCamposPapa(TxtPapaSale, "");
    }//GEN-LAST:event_TxtPapaSaleFocusGained

    private void TxtPapaDevuelveFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TxtPapaDevuelveFocusGained
        vCamposPapa(TxtPapaDevuelve, "");
    }//GEN-LAST:event_TxtPapaDevuelveFocusGained

    private void TxtPapaSaleFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TxtPapaSaleFocusLost
//        vCamposPapa(TxtPapaSale, "0");
    }//GEN-LAST:event_TxtPapaSaleFocusLost

    private void TxtPapaDevuelveFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TxtPapaDevuelveFocusLost
        vCamposPapa(TxtPapaDevuelve, "0");
    }//GEN-LAST:event_TxtPapaDevuelveFocusLost

    private void TxtDescripcionGastoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtDescripcionGastoKeyReleased

    }//GEN-LAST:event_TxtDescripcionGastoKeyReleased

    private void TxtNetoExistenteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtNetoExistenteKeyReleased
        // TODO add your handling code here:
//        Lbl_Resta.setText("" + (decimal(TxtNetoExistente) - decimal(TxtTotalNeto)));        
        calcularResta();
    }//GEN-LAST:event_TxtNetoExistenteKeyReleased

    private void TxtBaseInicialKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtBaseInicialKeyReleased
        calcularResta();
    }//GEN-LAST:event_TxtBaseInicialKeyReleased

    private void TxtBaseInicialMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TxtBaseInicialMouseExited
        // TODO add your handling code here:        
    }//GEN-LAST:event_TxtBaseInicialMouseExited

    private void TxtBaseInicialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TxtBaseInicialFocusLost

    }//GEN-LAST:event_TxtBaseInicialFocusLost

    private void TxtTotalNetoInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_TxtTotalNetoInputMethodTextChanged

    }//GEN-LAST:event_TxtTotalNetoInputMethodTextChanged

    private void MnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnModificarActionPerformed
        //<editor-fold desc="MENU MODIFICAR" defaultstate="collapsed">
        //Seleccion fila modificar
        if (Seleccion()) {
            TblCierreSucursales.setEnabled(true);
            gastos();
//            habilitarCampos(false, true, true, false, false, true, false, true);
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAgregar;
    private javax.swing.JButton BtnAgregarGasto;
    private javax.swing.JButton BtnCancelar;
    private javax.swing.JButton BtnEliminar;
    private javax.swing.JButton BtnModificar;
    private javax.swing.JButton BtnNuevo;
    private javax.swing.JComboBox<String> CbxSucursal;
    private javax.swing.JPanel JP_Gastos;
    private javax.swing.JPanel JP_Platos;
    private javax.swing.JLabel LblBuscar;
    private javax.swing.JLabel LblFecha;
    private javax.swing.JLabel LblNumFactura;
    private javax.swing.JLabel LblOk;
    private javax.swing.JLabel Lbl_ItemFritos;
    public javax.swing.JLabel Lbl_ItemGastos;
    private javax.swing.JLabel Lbl_Resta;
    public javax.swing.JLabel Lbl_ValorFritos;
    public javax.swing.JLabel Lbl_ValorGastos;
    private javax.swing.JMenuItem MnEliminar;
    private javax.swing.JMenuItem MnEliminar_Gasto;
    private javax.swing.JMenuItem MnModificar;
    private javax.swing.JMenuItem MnModificar_Gasto;
    private javax.swing.JPopupMenu PopM_Gastos;
    private javax.swing.JPopupMenu PopM_Tabla;
    private javax.swing.JTabbedPane TabPrincipal;
    private javax.swing.JTable TblCierreSucursales;
    private javax.swing.JTable TblGastos;
    private javax.swing.JTextField TxtAlcancia;
    private javax.swing.JTextField TxtBaseInicial;
    private javax.swing.JTextField TxtBuscar;
    private javax.swing.JTextField TxtDescripcionGasto;
    private javax.swing.JTextField TxtNetoExistente;
    private javax.swing.JTextField TxtPapaDevuelve;
    private javax.swing.JTextField TxtPapaSale;
    private javax.swing.JTextField TxtTotalBruto;
    private javax.swing.JTextField TxtTotalNeto;
    private javax.swing.JTextField TxtValorGasto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    // End of variables declaration//GEN-END:variables

    //<editor-fold desc="GASTOS" defaultstate="collapsed">
    void gastos() {
        double totalGastos = 0;
        int Items = 0;

        int filas = TblGastos.getRowCount();
        for (int i = 0; i < filas; i++) {
            Items = filas;
            totalGastos = totalGastos + Integer.parseInt(TblGastos.getValueAt(i, 1).toString());
        }
        Lbl_ItemGastos.setText("" + Items);
        Lbl_ValorGastos.setText("" + totalGastos);
//        MapRelease.put("lblGastos", this.Lbl_ValorGastos);

        TxtTotalNeto.setText("" + (Double.parseDouble(Lbl_ValorFritos.getText()) - Double.parseDouble(Lbl_ValorGastos.getText())));
    }
    //</editor-fold>

    

    //<editor-fold desc="VERIFICAR CAMPOS PAPA" defaultstate="collapsed">
    void vCamposPapa(JTextField Text, String Valor) {
        if (Text.getText() == null || Text.getText().equalsIgnoreCase("0") || Text.getText().equals("")) {
            Text.setText(Valor);
        }
    }
    //</editor-fold>

    //<editor-fold desc="RECALCULAR RESTA" defaultstate="collapsed">
    void calcularResta() {

        double Bruto = decimal(TxtTotalBruto);
        double Base = decimal(TxtBaseInicial);
        double Gastos = Double.parseDouble(Lbl_ValorGastos.getText());
        double NetoEx = decimal(TxtNetoExistente);
        double Suma = (NetoEx - ((Bruto + Base) - Gastos));

        Lbl_Resta.setText("" + Suma);
        pintarResta();
    }

    void pintarResta() {
        if (Double.parseDouble(Lbl_Resta.getText()) < 0) {
            Lbl_Resta.setForeground(Color.RED);
        } else if (Double.parseDouble(Lbl_Resta.getText()) > 0) {
            Lbl_Resta.setForeground(new Color(0, 153, 51));
        } else {
            Lbl_Resta.setForeground(Color.BLUE);
        }
    }
    //</editor-fold>

    public boolean Seleccion() {

        int fila = TblCierreSucursales.getSelectedRow();
        if (fila >= 0) {

            CbxSucursal.setSelectedIndex(Integer.parseInt(TblCierreSucursales.getValueAt(fila, 2).toString()));
            LblNumFactura.setText(TblCierreSucursales.getValueAt(fila, 0).toString());

            String Fecha = TblCierreSucursales.getValueAt(fila, 1).toString();
            String[] Fch = Fecha.split("-", 3);
            LblFecha.setText(Fch[1] + "/" + Fch[2] + "/" + Fch[0]);

            TxtNetoExistente.setText(TblCierreSucursales.getValueAt(fila, 3).toString());
            TxtTotalNeto.setText(TblCierreSucursales.getValueAt(fila, 4).toString());
            TxtTotalBruto.setText(TblCierreSucursales.getValueAt(fila, 5).toString());
            Lbl_Resta.setText(TblCierreSucursales.getValueAt(fila, 6).toString());
            TxtPapaSale.setText(TblCierreSucursales.getValueAt(fila, 7).toString());
            TxtPapaDevuelve.setText(TblCierreSucursales.getValueAt(fila, 8).toString());
            TxtBaseInicial.setText(TblCierreSucursales.getValueAt(fila, 9).toString());
            TxtAlcancia.setText(TblCierreSucursales.getValueAt(fila, 10).toString());
            pintarResta();

            mostrarGastos(TblCierreSucursales.getValueAt(fila, 0).toString());
            mostrarPlatosVendidos(TblCierreSucursales.getValueAt(fila, 0).toString());

            return true;
        } else {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ningun Cierre de la tabla");
            buscarSi();
            return false;

        }
    }
}
