package com.mycompany.monkey;
import javax.swing.JOptionPane;
/**
 *
 * @author manuel
 */
public class MenuInicialJFrame extends javax.swing.JFrame {
    public MenuInicialJFrame() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("MENÚ INICIAL MONKEY"); 
    }
    public boolean esNumTiempo(String cadena){
            int cadenaNum=0;
            cadenaNum=Integer.parseInt(cadena);
            if(cadenaNum>1){
                return true;
            }else{
                return false;
            }  
    }
    public boolean esNumEntero(String cadena){
            int cadenaNum=0;
            cadenaNum=Integer.parseInt(cadena);
            if(cadenaNum>0){
                return true;
            }else{
                return false;
            }  
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        inventarioTiempoTXT = new javax.swing.JTextField();
        produccionTiempoTXT = new javax.swing.JTextField();
        empaquetadoTiempoTXT = new javax.swing.JTextField();
        salidaTiempoTXT = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        inventarioCostoTXT = new javax.swing.JTextField();
        produccionCostoTXT = new javax.swing.JTextField();
        empaquetadoCostoTXT = new javax.swing.JTextField();
        salidaCostoTXT = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(32, 36, 48));
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("BIENVENIDO A MONKEY");

        inventarioTiempoTXT.setBackground(new java.awt.Color(255, 255, 255));
        inventarioTiempoTXT.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        inventarioTiempoTXT.setForeground(new java.awt.Color(0, 0, 0));

        produccionTiempoTXT.setBackground(new java.awt.Color(255, 255, 255));
        produccionTiempoTXT.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        produccionTiempoTXT.setForeground(new java.awt.Color(0, 0, 0));

        empaquetadoTiempoTXT.setBackground(new java.awt.Color(255, 255, 255));
        empaquetadoTiempoTXT.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        empaquetadoTiempoTXT.setForeground(new java.awt.Color(0, 0, 0));

        salidaTiempoTXT.setBackground(new java.awt.Color(255, 255, 255));
        salidaTiempoTXT.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        salidaTiempoTXT.setForeground(new java.awt.Color(0, 0, 0));

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("INVENTARIO");

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("PRODUCCIÓN");

        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("EMPAQUETADO");

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("SALIDA ");

        jButton1.setBackground(new java.awt.Color(254, 65, 87));
        jButton1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("INICIAR SIMULACIÓN");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        inventarioCostoTXT.setBackground(new java.awt.Color(255, 255, 255));
        inventarioCostoTXT.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        inventarioCostoTXT.setForeground(new java.awt.Color(0, 0, 0));

        produccionCostoTXT.setBackground(new java.awt.Color(255, 255, 255));
        produccionCostoTXT.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        produccionCostoTXT.setForeground(new java.awt.Color(0, 0, 0));

        empaquetadoCostoTXT.setBackground(new java.awt.Color(255, 255, 255));
        empaquetadoCostoTXT.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        empaquetadoCostoTXT.setForeground(new java.awt.Color(0, 0, 0));

        salidaCostoTXT.setBackground(new java.awt.Color(255, 255, 255));
        salidaCostoTXT.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        salidaCostoTXT.setForeground(new java.awt.Color(0, 0, 0));

        jLabel6.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 10)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Tiempo (Segundos)");

        jLabel7.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 10)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Costo (Quetzal/Segundo)");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(112, 112, 112))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(inventarioTiempoTXT, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                                .addComponent(produccionTiempoTXT)
                                .addComponent(empaquetadoTiempoTXT)
                                .addComponent(salidaTiempoTXT))
                            .addComponent(jLabel6))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(inventarioCostoTXT, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                                .addComponent(produccionCostoTXT)
                                .addComponent(empaquetadoCostoTXT)
                                .addComponent(salidaCostoTXT)))))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel1)
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(inventarioTiempoTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(55, 55, 55)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(produccionTiempoTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(55, 55, 55)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(empaquetadoTiempoTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(55, 55, 55)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(salidaTiempoTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(inventarioCostoTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(produccionCostoTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(empaquetadoCostoTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(salidaCostoTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(inventarioTiempoTXT.getText().isEmpty()||produccionTiempoTXT.getText().isEmpty()||empaquetadoTiempoTXT.getText().isEmpty()||salidaTiempoTXT.getText().isEmpty()||inventarioCostoTXT.getText().isEmpty()||produccionCostoTXT.getText().isEmpty()||empaquetadoCostoTXT.getText().isEmpty()||salidaCostoTXT.getText().isEmpty()){
             JOptionPane.showMessageDialog(null, "Campos Vacíos. Debe completar los campos para iniciar la simulación.", "MONKEY", JOptionPane.ERROR_MESSAGE); 
        }else if(esNumTiempo(inventarioTiempoTXT.getText().trim())&&esNumTiempo(produccionTiempoTXT.getText().trim())&&esNumTiempo(empaquetadoTiempoTXT.getText().trim())&&esNumTiempo(salidaTiempoTXT.getText().trim())&& esNumEntero(inventarioCostoTXT.getText().trim())&&esNumEntero(produccionCostoTXT.getText().trim())&&esNumEntero(empaquetadoCostoTXT.getText().trim())&&esNumEntero(salidaCostoTXT.getText().trim())){ 
            TiempoSegundos nuevoTiempo = new TiempoSegundos();
            nuevoTiempo.setInventario(Integer.parseInt(inventarioTiempoTXT.getText()));
            nuevoTiempo.setProduccion(Integer.parseInt(produccionTiempoTXT.getText()));
            nuevoTiempo.setEmpaquetado(Integer.parseInt(empaquetadoTiempoTXT.getText()));
            nuevoTiempo.setSalida(Integer.parseInt(salidaTiempoTXT.getText()));
            AppState.listaTiempo.add(nuevoTiempo);
            for(int i = 0; i<AppState.listaTiempo.size(); i++){
                System.out.println(AppState.listaTiempo.get(i).getInventario()+" - "+AppState.listaTiempo.get(i).getProduccion()+" - "+AppState.listaTiempo.get(i).getEmpaquetado()+" - "+AppState.listaTiempo.get(i).getSalida());
            }
            System.out.println("--------------------------------------------------------------------");
            
            CostoQuetzales nuevoCosto = new CostoQuetzales();
            nuevoCosto.setInventario(Integer.parseInt(inventarioCostoTXT.getText()));
            nuevoCosto.setProduccion(Integer.parseInt(produccionCostoTXT.getText()));
            nuevoCosto.setEmpaquetado(Integer.parseInt(empaquetadoCostoTXT.getText()));
            nuevoCosto.setSalida(Integer.parseInt(salidaCostoTXT.getText()));
            AppState.listaCosto.add(nuevoCosto);
            
            for(int i = 0; i<AppState.listaCosto.size(); i++){
                    System.out.println(AppState.listaCosto.get(i).getInventario()+" - "+AppState.listaCosto.get(i).getProduccion()+" - "+AppState.listaCosto.get(i).getEmpaquetado()+" - "+AppState.listaCosto.get(i).getSalida());
                }
            System.out.println("--------------------------------------------------------------------");
            JOptionPane.showMessageDialog(null, "Simulación Iniciada.", "MONKEY", JOptionPane.INFORMATION_MESSAGE);
            SimulacionJFrame menuSimulacion = new SimulacionJFrame();
            menuSimulacion.setVisible(true);
            dispose();
        }else{
            JOptionPane.showMessageDialog(null, "Verificar contenido de los campos.\n" +"El Tiempo de Simulación debe ser mayor a 1.\n" +"El Costo de Simulación debe ser Mayor a 0.\n" +"Inténtalo de nuevo. ", "MONKEY", JOptionPane.ERROR_MESSAGE); 
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuInicialJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuInicialJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuInicialJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuInicialJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuInicialJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField empaquetadoCostoTXT;
    private javax.swing.JTextField empaquetadoTiempoTXT;
    private javax.swing.JTextField inventarioCostoTXT;
    private javax.swing.JTextField inventarioTiempoTXT;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField produccionCostoTXT;
    private javax.swing.JTextField produccionTiempoTXT;
    private javax.swing.JTextField salidaCostoTXT;
    private javax.swing.JTextField salidaTiempoTXT;
    // End of variables declaration//GEN-END:variables
}
