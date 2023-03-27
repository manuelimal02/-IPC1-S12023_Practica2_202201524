package com.mycompany.monkey;
import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
/**
 *
 * @author manuel
 */
public class SimulacionJFrame extends javax.swing.JFrame {
    
    public int ContadorIncial;
    static int ContadorInventario=0, ContadorProduccion=0, ContadorEmpaquetado=0, ContadorSalida=0, ContadorFinal=0;

    public int TiempoProduccion;
    public int TiempoEmpaquetado;
    public int TiempoSalida;
    public int TiempoFinal;
    
    public HiloTemporizador hiloTemporizador;
    public Thread HiloTemporizador;
    
    public HiloIncial hiloInicial;
    public Thread HiloInicial;
    
    public HiloInventario hiloInventario;
    public Thread HiloInventario;
    
    public HiloProduccion hiloProduccion;
    public Thread HiloProduccion;
    
    public HiloEmpaquetado hiloEmpaquetado;
    public Thread HiloEmpaquetado;
    
    public HiloSalida hiloSalida;
    public Thread HiloSalida;
    
    public HiloFinal hiloFinal;
    public Thread HiloFinal;
    
    //FUNCIONES PARA LOS CONTADORES
    public static synchronized void incInventario(){
       ContadorInventario++;
    }
    public static synchronized void decInventario(){
        ContadorInventario--;
    }
    public static synchronized void incProduccion(){
       ContadorProduccion++;
    }
    public static synchronized void decProduccion(){
        ContadorProduccion--;
    }
    public static synchronized void incEmpaquetado(){
       ContadorEmpaquetado++;
    }
    public static synchronized void decEmpaquetado(){
        ContadorEmpaquetado--;
    }
    public static synchronized void incSalida(){
       ContadorSalida++;
    }
    public static synchronized void decSalida(){
        ContadorSalida--;
    }
    public static synchronized void incFinal(){
       ContadorFinal++;
    }
    //FUNCIONES PARA PINTAR EL CIRCULO
    public class PintarCiculoInventario{
        public PintarCiculoInventario(Graphics g, int x, int y) {
            Color Inventario = new Color(110, 77, 252);
            g.setColor(Inventario);
            g.fillOval(x, y, 20, 20);
        }
    }
    public class DespintarCiculo{
        public DespintarCiculo(Graphics g, int x, int y) {
            g.setColor(Color.WHITE);
            g.fillOval(x, y, 20, 20);
        }
    }
    public class PintarCiculoProduccion{
        public PintarCiculoProduccion(Graphics g, int x, int y) {
            Color Produccion = new Color(254, 65, 87);
            g.setColor(Produccion);
            g.fillOval(x, y, 20, 20);
        }
    }
    public class PintarCiculoEmpaquetado{
        public PintarCiculoEmpaquetado(Graphics g, int x, int y) {
            Color Produccion = new Color(117,232,250);
            g.setColor(Produccion);
            g.fillOval(x, y, 20, 20);
        }
    }
    public class PintarCiculoSalida{
        public PintarCiculoSalida(Graphics g, int x, int y) {
            Color Produccion = new Color(255, 217, 79);
            g.setColor(Produccion);
            g.fillOval(x, y, 20, 20);
        }
    }
    //FUNCIONES PARA CAMBIAR DE TIEMPO
    
    //FUNCIONES PARA LOS HILOS
    //Hilo Temporizador
    public class HiloTemporizador implements Runnable{
        JLabel tiempoTranscurrido;
        boolean Temp=true;
        int horas, minutos, segundos;
        public HiloTemporizador(JLabel tiempoTranscurrido) {
            this.tiempoTranscurrido = tiempoTranscurrido;
        }
        public String toString(int numero) {
            if (numero < 10) {
                return "0" + Integer.toString(numero);
            }
            return Integer.toString(numero);
        }
        @Override
        public void run() {
            while (Temp) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(SimulacionJFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                segundos++;
                if (segundos == 60) {minutos++;segundos = 0;}
                if (minutos == 60) {horas++;minutos = 0;}
                tiempoTranscurrido.setText(toString(horas) + ":" + toString(minutos) + ":" + toString(segundos));
                if(ContadorFinal==30){
                    jButton1.setVisible(true);
                    jButton2.setVisible(true);
                    JOptionPane.showMessageDialog(null, "Procesamiento Terminado. Elija una de las opciones.", "COTIZACIÓN DE PAQUETES Y COMPRA", JOptionPane.INFORMATION_MESSAGE); 
                    Temp=false;
                }
            }
        }
    }
    //Hilo Inicial
    public class HiloIncial implements Runnable{
        public boolean ValidarHilo=true;
        JLabel contadorIncioLBL;
        public HiloIncial(JLabel contadorIncioLBL){
            this.contadorIncioLBL = contadorIncioLBL;
        }
        @Override
        public void run() {
            while(ValidarHilo){ 
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(SimulacionJFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("Trabaja Hilo Inicial");
                ContadorIncial--; 
                contadorIncioLBL.setText(String.valueOf(ContadorIncial));
                if(ContadorIncial==0){
                    ValidarHilo=false;
                    HiloInicial.stop();
                }
            }
        }
    }
    //Hilo Inventario
    public class HiloInventario implements Runnable{       
        public boolean ValidarHilo1=true;
        JPanel Panel;
        JLabel contadorInventarioLBL;
        boolean direccionDercha = true;
        public HiloInventario(JLabel contadorInventarioLBL, JPanel Panel){
            this.contadorInventarioLBL = contadorInventarioLBL;
            this.Panel=Panel;
        }
        @Override
        public void run() {
            int x=6;
            int y=40;
            while(ValidarHilo1){ 
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(SimulacionJFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("Trabaja Hilo Inventario");
                if(x>=300){
                    y=y+30;
                    x=6;
                }
                incInventario();
                PintarCiculoInventario CirculoInventario = new PintarCiculoInventario(Panel.getGraphics(),x,y); 
                contadorInventarioLBL.setText(String.valueOf(ContadorInventario));  
                if(ContadorIncial==0){
                    ValidarHilo1=false;
                    HiloInventario.stop();
                }
                x=x+50;   
            }
        }
    }
    //Hilo Produccion
    public class HiloProduccion implements Runnable{       
        public boolean ValidarHilo2=true;
        JLabel contadorInventarioLBL, contadorProduccionLBL; JPanel Panel1, Panel2;
        public HiloProduccion(JLabel contadorInventarioLBL, JLabel contadorProduccionLBL, JPanel Panel1, JPanel Panel2){
            this.contadorInventarioLBL = contadorInventarioLBL;
            this.contadorProduccionLBL = contadorProduccionLBL;
            this.Panel1=Panel1;
            this.Panel2=Panel2;
        }
        @Override
        public void run() {
            int x=6; int y=40;
            while(ValidarHilo2){ 
                try {
                    Thread.sleep(TiempoProduccion*1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(SimulacionJFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("Trabaja Hilo Produccion");
                if(x>=300){y=y+30;x=6;}
                incProduccion();
                PintarCiculoProduccion CirculoProduccion = new PintarCiculoProduccion(Panel1.getGraphics(),x,y);
                contadorProduccionLBL.setText(String.valueOf(ContadorProduccion));
                DespintarCiculo Circulo = new DespintarCiculo(Panel2.getGraphics(),x,y);
                decInventario();
                contadorInventarioLBL.setText(String.valueOf(ContadorInventario));
                if(ContadorInventario==0&&ContadorIncial==0){
                    ValidarHilo2=false;
                    HiloProduccion.stop();
                }
                x=x+50;
            }
        }
    }
    //Hilo Empaquetado
    public class HiloEmpaquetado implements Runnable{     
        public boolean ValidarHilo3=true;
        JLabel contadorProduccionLBL,contadorEmpaquetadoLBL;
        JPanel Panel1, Panel2;
        public HiloEmpaquetado(JLabel contadorProduccionLBL, JLabel contadorEmpaquetadoLBL, JPanel Panel1, JPanel Panel2){
            this.contadorProduccionLBL = contadorProduccionLBL;
            this.contadorEmpaquetadoLBL = contadorEmpaquetadoLBL;
            this.Panel1=Panel1;
            this.Panel2=Panel2;
        }
        @Override
        public void run() {
            int x=6;
            int y=40;
            while(ValidarHilo3){ 
                try {
                    Thread.sleep(TiempoEmpaquetado*1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(SimulacionJFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("Trabaja Hilo Empaquetado");
                if(x>=300){
                    y=y+30;
                    x=6;
                }
                incEmpaquetado();
                PintarCiculoEmpaquetado CirculoEmpaquetado = new PintarCiculoEmpaquetado(Panel1.getGraphics(),x,y);
                contadorEmpaquetadoLBL.setText(String.valueOf(ContadorEmpaquetado));     
                decProduccion();
                DespintarCiculo Circulo = new DespintarCiculo(Panel2.getGraphics(),x,y);
                contadorProduccionLBL.setText(String.valueOf(ContadorProduccion));
                CambioTiempoEmpaquetado();
                if(ContadorInventario==0&&ContadorProduccion==0&&ContadorIncial==0){
                    ValidarHilo3=false;
                    HiloEmpaquetado.stop();
                }
                x=x+50;
            }
        }
    }
    //Hilo Salida
    public class HiloSalida implements Runnable{
        public boolean ValidarHilo4=true;
        JLabel contadorEmpaquetadoLBL, contadorSalidaLBL;
        JPanel Panel1, Panel2;
        public HiloSalida(JLabel contadorEmpaquetadoLBL, JLabel contadorSalidaLBL, JPanel Panel1, JPanel Panel2){
            this.contadorEmpaquetadoLBL = contadorEmpaquetadoLBL;
            this.contadorSalidaLBL = contadorSalidaLBL;
            this.Panel1=Panel1;
            this.Panel2=Panel2;
        }
        @Override
        public void run() {
            int x=6;
            int y=40;
            while(ValidarHilo4){ 
                try {
                    Thread.sleep(TiempoSalida*1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(SimulacionJFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("Trabaja Hilo Salida");
                if(x>=300){
                    y=y+30;
                    x=6;
                }
                PintarCiculoSalida CirculoSalida = new PintarCiculoSalida(Panel1.getGraphics(),x,y);
                incSalida();
                contadorSalidaLBL.setText(String.valueOf(ContadorSalida));     
                decEmpaquetado();
                DespintarCiculo Circulo = new DespintarCiculo(Panel2.getGraphics(),x,y);
                contadorEmpaquetadoLBL.setText(String.valueOf(ContadorEmpaquetado));
                CambioTiempoSalida();
                if(ContadorInventario==0&&ContadorProduccion==0&&ContadorEmpaquetado==0&&ContadorIncial==0){
                    ValidarHilo4=false;
                    HiloSalida.stop();
                }
                x=x+50;
            }
        }
    }
    //Hilo Final
    public class HiloFinal implements Runnable{
        public boolean ValidarHilo5=true;
        JLabel contadorSalidaLBL,contadorFinalLBL;
        JPanel Panel2;
        public HiloFinal(JLabel contadorSalidaLBL, JLabel contadorFinalLBL, JPanel Panel2){
            this.contadorSalidaLBL = contadorSalidaLBL;
            this.contadorFinalLBL = contadorFinalLBL;
            this.Panel2=Panel2;
        }
        @Override
        public void run() {
            int x=6;
            int y=40;
            while(ValidarHilo5){ 
                try {
                    Thread.sleep(TiempoFinal*1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(SimulacionJFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("Trabaja Hilo Salida");
                incFinal();
                contadorFinalLBL.setText(String.valueOf(ContadorFinal));
                if(x>=300){
                    y=y+30;
                    x=6;
                }
                decSalida();
                DespintarCiculo Circulo = new DespintarCiculo(Panel2.getGraphics(),x,y);
                contadorSalidaLBL.setText(String.valueOf(ContadorSalida));
                CambioTiempoFinal();
                if(ContadorInventario==0&&ContadorProduccion==0&&ContadorEmpaquetado==0&&ContadorSalida==0&&ContadorIncial==0){
                    ValidarHilo5=false;
                    HiloFinal.stop();
                }
                x=x+50;
            }
        }
    }
    //INICIAR COMPONENTES
    public static String generarCodigo(){
        //LETRAS ALEATORIAS
        final String cadena="QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm";
        final int longi=3;
        StringBuilder sb1 = new StringBuilder();
        for (int i = 0;i<longi; i++) {
            double aleatorio1=Math.random()*cadena.length();
            int posicion1=(int)aleatorio1;
            char letra1 =cadena.charAt(posicion1);
            sb1.append(letra1);
        }
        //NUMEROS ALEATORIOS
        int aleatorio1=0; 
        Random codigoRandom = new Random();
        aleatorio1=(int)(codigoRandom.nextDouble()*10);
        //CODIGO
        String codigo="Reporte_"+sb1.toString()+aleatorio1;
        //RETORNO
        return codigo;
    }
    public synchronized void CambioTiempoEmpaquetado(){
        if (TiempoEmpaquetado==AppState.listaTiempo.get(0).getInventario()+AppState.listaTiempo.get(0).getProduccion()){
            TiempoEmpaquetado=AppState.listaTiempo.get(0).getInventario();
        }
    }
    public synchronized void CambioTiempoSalida(){
        if (TiempoSalida==AppState.listaTiempo.get(0).getInventario()+AppState.listaTiempo.get(0).getProduccion()+AppState.listaTiempo.get(0).getEmpaquetado()){
            TiempoSalida=AppState.listaTiempo.get(0).getInventario();
        }
    }
    public synchronized void CambioTiempoFinal(){
        if (TiempoFinal==AppState.listaTiempo.get(0).getInventario()+AppState.listaTiempo.get(0).getProduccion()+AppState.listaTiempo.get(0).getEmpaquetado()+AppState.listaTiempo.get(0).getSalida()){
            TiempoFinal=AppState.listaTiempo.get(0).getInventario();
        }
    }
    public SimulacionJFrame() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("SIMULACIÓN");
        
        TiempoProduccion=0;
        TiempoEmpaquetado=0;
        TiempoSalida=0;
        TiempoFinal=0;
        ContadorIncial=30;
        
        TiempoProduccion=(AppState.listaTiempo.get(0).getInventario());
        TiempoEmpaquetado=((AppState.listaTiempo.get(0).getInventario()+AppState.listaTiempo.get(0).getProduccion()));
        TiempoSalida=((AppState.listaTiempo.get(0).getInventario()+AppState.listaTiempo.get(0).getProduccion()+AppState.listaTiempo.get(0).getEmpaquetado()));
        TiempoFinal=((AppState.listaTiempo.get(0).getInventario()+AppState.listaTiempo.get(0).getProduccion()+AppState.listaTiempo.get(0).getEmpaquetado()+AppState.listaTiempo.get(0).getSalida()));
        
        jButton1.setVisible(false);
        jButton2.setVisible(false);
        
        hiloTemporizador= new HiloTemporizador(jLabel15);
        HiloTemporizador = new Thread(hiloTemporizador);
        HiloTemporizador.start(); 

        hiloInicial= new HiloIncial(contadorIncioLBL);
        HiloInicial = new Thread(hiloInicial);
        HiloInicial.start();
        
        hiloInventario= new HiloInventario(contadorInventarioLBL, jPanel5);
        HiloInventario = new Thread(hiloInventario);
        HiloInventario.start();
        
        hiloProduccion= new HiloProduccion(contadorInventarioLBL,contadorProduccionLBL,jPanel2, jPanel5);
        HiloProduccion = new Thread(hiloProduccion);
        HiloProduccion.start();
        
        hiloEmpaquetado= new HiloEmpaquetado(contadorProduccionLBL,contadorEmpaquetadoLBL, jPanel3, jPanel2);
        HiloEmpaquetado = new Thread(hiloEmpaquetado);
        HiloEmpaquetado.start();
        
        hiloSalida= new HiloSalida(contadorEmpaquetadoLBL, contadorSalidaLBL, jPanel4, jPanel3);
        HiloSalida = new Thread(hiloSalida);
        HiloSalida.start();
        
        hiloFinal= new HiloFinal(contadorSalidaLBL, contadorFinalLBL, jPanel4);
        HiloFinal = new Thread(hiloFinal);
        HiloFinal.start();

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        contadorEmpaquetadoLBL = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        contadorSalidaLBL = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        contadorProduccionLBL = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        contadorInventarioLBL = new javax.swing.JLabel();
        contadorIncioLBL = new javax.swing.JLabel();
        contadorFinalLBL = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(32, 36, 48));

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText(" SIMULACIÓN");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("EMPAQUETADO:");

        contadorEmpaquetadoLBL.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        contadorEmpaquetadoLBL.setForeground(new java.awt.Color(0, 0, 0));
        contadorEmpaquetadoLBL.setText("0");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contadorEmpaquetadoLBL, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(84, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(contadorEmpaquetadoLBL))
                .addContainerGap(170, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("SALIDA:");

        contadorSalidaLBL.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        contadorSalidaLBL.setForeground(new java.awt.Color(0, 0, 0));
        contadorSalidaLBL.setText("0");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contadorSalidaLBL, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(84, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(contadorSalidaLBL))
                .addContainerGap(170, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("PRODUCCIÓN:");

        contadorProduccionLBL.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        contadorProduccionLBL.setForeground(new java.awt.Color(0, 0, 0));
        contadorProduccionLBL.setText("0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contadorProduccionLBL, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(84, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(contadorProduccionLBL))
                .addContainerGap(170, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("INVENTARIO:");

        contadorInventarioLBL.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        contadorInventarioLBL.setForeground(new java.awt.Color(0, 0, 0));
        contadorInventarioLBL.setText("0");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contadorInventarioLBL, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(84, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(contadorInventarioLBL))
                .addContainerGap(170, Short.MAX_VALUE))
        );

        contadorIncioLBL.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        contadorIncioLBL.setForeground(new java.awt.Color(255, 255, 255));
        contadorIncioLBL.setText("30");

        contadorFinalLBL.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        contadorFinalLBL.setForeground(new java.awt.Color(255, 255, 255));
        contadorFinalLBL.setText("0");

        jLabel14.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("TIEMPO TRANSCURRIDO:");

        jLabel15.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("00:00:00");

        jLabel16.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("INICIO:");

        jLabel17.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("FINAL:");

        jButton1.setBackground(new java.awt.Color(242, 76, 60));
        jButton1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("REGRESAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(242, 150, 39));
        jButton2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("REPORTE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(200, 200, 200))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(62, 62, 62))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(contadorFinalLBL, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(26, 26, 26)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(contadorIncioLBL, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(50, 50, 50))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15))
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(contadorFinalLBL)
                            .addComponent(jLabel17)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(contadorIncioLBL)
                        .addComponent(jLabel16)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        HiloTemporizador.stop();
        HiloInicial.stop();
        HiloInventario.stop();
        HiloProduccion.stop();
        HiloEmpaquetado.stop();
        HiloFinal.stop();
        ContadorFinal=0;
        AppState.listaCosto.remove(0);
        AppState.listaTiempo.remove(0);
        
        for(int i = 0; i<AppState.listaTiempo.size(); i++){
            System.out.println(AppState.listaTiempo.get(i).getInventario()+" - "+AppState.listaTiempo.get(i).getProduccion()+" - "+AppState.listaTiempo.get(i).getEmpaquetado()+" - "+AppState.listaTiempo.get(i).getSalida());
            System.out.println("Tiempo");
        }
        System.out.println("--------------------------------------------------------------------");
        for(int i = 0; i<AppState.listaCosto.size(); i++){
            System.out.println(AppState.listaCosto.get(i).getInventario()+" - "+AppState.listaCosto.get(i).getProduccion()+" - "+AppState.listaCosto.get(i).getEmpaquetado()+" - "+AppState.listaCosto.get(i).getSalida());
            System.out.println("Costo");
        }
        System.out.println("--------------------------------------------------------------------");
        
        MenuInicialJFrame menuInicio = new MenuInicialJFrame();
        menuInicio.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int costoinventario=AppState.listaCosto.get(0).getInventario()*AppState.listaTiempo.get(0).getInventario()*30;
        int costoproduccion=AppState.listaCosto.get(0).getProduccion()*AppState.listaTiempo.get(0).getProduccion()*30;
        int costoempaquetado=AppState.listaCosto.get(0).getEmpaquetado()*AppState.listaTiempo.get(0).getEmpaquetado()*30;
        int costosalida=AppState.listaCosto.get(0).getSalida()*AppState.listaTiempo.get(0).getSalida()*30;
        int costototal=costoinventario+costoproduccion+costoempaquetado+costosalida;
        String tablaHtml = generarReporte(costoinventario, costoproduccion, costoempaquetado, costosalida, costototal);
        // Crea la carpeta de reportes si no esiste
        File carpeta = new File("C:/Users/manue/Downloads/");
        if (!carpeta.exists()) {
            carpeta.mkdirs();
        }
        // Escribe el archivo .html dentro de la carpeta
        try {
            FileWriter fileWriter = new FileWriter("C:/Users/manue/Downloads/"+generarCodigo()+".html");
            fileWriter.write(tablaHtml);
            JOptionPane.showMessageDialog(null, "Reporte Descargado.", "COTIZACIÓN DE PAQUETES Y COMPRA", JOptionPane.INFORMATION_MESSAGE); 
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_jButton2ActionPerformed
    public static String generarReporte(int costoInventario,int costoProduccion,int costoEmpaquetado, int costoSalida, int Total) {
        StringBuilder sb = new StringBuilder();
        sb.append("<font font face=\"Verdana\">");
        sb.append("<h2>").append("Reporte Costo De Simulación").append("</h2>");
        //DATOS
        sb.append("<table border=\"1\">\n");
        sb.append("<tr>");
        sb.append("<td>").append("Costo Inventario").append("</td>");
        sb.append("<td>").append("Q. "+costoInventario+".00").append("</td>");
        sb.append("</tr>");
        sb.append("<tr>");
        sb.append("<td>").append("Costo Producción").append("</td>");
        sb.append("<td>").append("Q. "+costoProduccion+".00").append("</td>");
        sb.append("</tr>");  
        sb.append("<tr>");
        sb.append("<td>").append("Costo Empaquetado").append("</td>");
        sb.append("<td>").append("Q. "+costoEmpaquetado+".00").append("</td>");
        sb.append("</tr>");     
        sb.append("<tr>");
        sb.append("<td>").append("Costo Salida").append("</td>");
        sb.append("<td>").append("Q. "+costoSalida+".00").append("</td>");
        sb.append("</tr>"); 
        sb.append("<tr>");
        sb.append("<td>").append("Costo Total").append("</td>");
        sb.append("<td>").append("Q. "+Total+".00").append("</td>");
        sb.append("</tr>"); 
        sb.append("</table>");
        sb.append("<h4>").append("Carlos Manuel Lima y Lima – 202201524").append("</h4>");
        sb.append("</font>");
        //SE CIERRA
        return sb.toString();
    }
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
            java.util.logging.Logger.getLogger(SimulacionJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SimulacionJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SimulacionJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SimulacionJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SimulacionJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel contadorEmpaquetadoLBL;
    private javax.swing.JLabel contadorFinalLBL;
    private javax.swing.JLabel contadorIncioLBL;
    private javax.swing.JLabel contadorInventarioLBL;
    private javax.swing.JLabel contadorProduccionLBL;
    private javax.swing.JLabel contadorSalidaLBL;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}