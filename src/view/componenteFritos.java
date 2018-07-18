package view;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.JLabel;

public class componenteFritos extends javax.swing.JPanel {

    /**
     * Creates new form jpComponente
     */    
    Map MapRelease = new HashMap();
    
    public componenteFritos(int index,Map MapRelease) {
        initComponents();
        //JPanel
        setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
//        this.setSize(230, 30);
        this.setVisible(true);
        txtValorUnitario.setVisible(false);
        LblSeccion.setVisible(false);
        this.MapRelease = MapRelease;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNombre = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        lblValor = new javax.swing.JLabel();
        txtValorUnitario = new javax.swing.JLabel();
        LblCodigo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        LblSeccion = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblNombre.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        lblNombre.setText("Nom :");

        txtCantidad.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        txtCantidad.setForeground(new java.awt.Color(255, 0, 0));
        txtCantidad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCantidad.setText("0");
        txtCantidad.setToolTipText("Cantidad");
        txtCantidad.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtCantidad.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCantidadFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCantidadFocusLost(evt);
            }
        });
        txtCantidad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtCantidadMouseClicked(evt);
            }
        });
        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCantidadKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadKeyTyped(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("$");

        lblValor.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        lblValor.setForeground(new java.awt.Color(255, 0, 0));
        lblValor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblValor.setText("0000");

        txtValorUnitario.setText("1500");

        LblCodigo.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        LblCodigo.setForeground(new java.awt.Color(204, 204, 204));
        LblCodigo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblCodigo.setText("Cod :");
        LblCodigo.setToolTipText("Codigo");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        LblSeccion.setText("Sec :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LblCodigo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtValorUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblValor, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LblSeccion)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LblCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(txtValorUnitario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblValor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LblSeccion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtCantidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyReleased
        if (txtCantidad.getText() == null  || txtCantidad.getText().equalsIgnoreCase("")) {
            lblValor.setText(""+0);
        }else{
            Suma();
        }        
    }//GEN-LAST:event_txtCantidadKeyReleased

    private void txtCantidadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCantidadMouseClicked
        if (txtCantidad.getText() == null  || txtCantidad.getText().equalsIgnoreCase("0")) {
            txtCantidad.setText("");
        }
    }//GEN-LAST:event_txtCantidadMouseClicked

    private void txtCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyTyped
        char car = evt.getKeyChar();
        if ((car < '0' || car > '9')) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCantidadKeyTyped

    private void txtCantidadFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCantidadFocusLost
        if (txtCantidad.getText() == null || txtCantidad.getText().equalsIgnoreCase("") || txtCantidad.getText().equalsIgnoreCase("0")) {
            int c = 0;
            txtCantidad.setText("" + c);
            Suma();
        }else{
            Suma();
        }        
    }//GEN-LAST:event_txtCantidadFocusLost

    private void txtCantidadFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCantidadFocusGained
        if (txtCantidad.getText() == null || txtCantidad.getText().equalsIgnoreCase("0")) {
            txtCantidad.setText("");
        }
    }//GEN-LAST:event_txtCantidadFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel LblCodigo;
    public javax.swing.JLabel LblSeccion;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JSeparator jSeparator1;
    public javax.swing.JLabel lblNombre;
    public javax.swing.JLabel lblValor;
    public javax.swing.JTextField txtCantidad;
    public javax.swing.JLabel txtValorUnitario;
    // End of variables declaration//GEN-END:variables


    //<editor-fold desc="SUMA" defaultstate="collapsed"> 
    void Suma(){
        //Suma
        Double cantidad = Double.parseDouble(txtCantidad.getText());
        double valorUnitario = Double.parseDouble(txtValorUnitario.getText());
        double totalUnitario = (valorUnitario * cantidad);
        lblValor.setText(totalUnitario + "");       
        
        //MapRelease casteado en un objeto tipo label
        JLabel lblTotal = (JLabel) MapRelease.get("lblTotal");
        JLabel lblCant = (JLabel) MapRelease.get("lblCant");
        //Variables Del total de los valores
        double valorFritos = 0; int CantFritos = 0;
        lblTotal.setText(""+valorFritos);
        
        //MapRelease casteado en un objeto tipo Map
        Map fritos = (Map) MapRelease.get("mapFritos");
        Iterator it = fritos.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            //se recupera el componente
            componenteFritos oComponenteFritos = ((componenteFritos) entry.getValue());
            //Guardamos el resultado de los componentes en sus respectivas variables
            CantFritos = CantFritos + (Integer.parseInt(oComponenteFritos.txtCantidad.getText()));
            valorFritos = valorFritos + (Double.parseDouble(oComponenteFritos.lblValor.getText()));
        }
        lblCant.setText(""+CantFritos);
        lblTotal.setText(""+valorFritos);
    }
    //</editor-fold>
}
