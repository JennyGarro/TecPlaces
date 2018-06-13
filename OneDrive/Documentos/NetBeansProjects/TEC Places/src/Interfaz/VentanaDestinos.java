/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Estructuras.Destino;
import static Interfaz.MapsJava_EjemploFacil.error;
//import PruebaBD4O;
import com.db4o.ObjectSet;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import maps.java.*;
/**
 *
 * @author nenis
 */
public class VentanaDestinos extends javax.swing.JFrame {
    public ObjectSet PruebaBD4O;
    PruebaBD4O BD=new PruebaBD4O();
    
    DefaultTableModel modelo = new DefaultTableModel();
    
    
    

    
    
    
    
    public VentanaDestinos() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Gestionar Lugares Destino");
        
        modelo.addColumn("Id");
        modelo.addColumn("Dirección");
        modelo.addColumn("Latitud");
        modelo.addColumn("Longitud");
        modelo.addColumn("Desplazamiento");
        TablaDestino.setModel(modelo);
        ConsultarTabla();
        
//        ObjectSet resultado=BD.Consultar();
//		while(resultado.hasNext()) {
//                    String Dato[] = new String [5];
//                    Destino Objeto = (Destino) resultado.next();
//                    
//                    Dato[0] = Objeto.getID();
//                    Dato[1] = Objeto.getDirecExacta();
//                    Dato[2] = Objeto.getLatitud();
//                    Dato[3] = Objeto.getLongitud();
//                    Dato[4] = Objeto.getDesplazamiento();
//                    modelo.addRow(Dato);
                    //System.out.println(Objeto.getID());
                    //System.out.println(resultado.next().toString());
		//}
//        
    }
    
    private void ConsultarTabla(){
        
        ObjectSet resultado=BD.Consultar();
		while(resultado.hasNext()) {
                    String Dato[] = new String [5];
                    Destino Objeto = (Destino) resultado.next();
                    
                    Dato[0] = Objeto.getID();
                    Dato[1] = Objeto.getDirecExacta();
                    Dato[2] = Objeto.getLatitud();
                    Dato[3] = Objeto.getLongitud();
                    Dato[4] = Objeto.getDesplazamiento();
                    modelo.addRow(Dato);
                    //System.out.println(Objeto.getID());
                    //System.out.println(resultado.next().toString());
		}
    
    
    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        BtnConvertirDirec = new javax.swing.JButton();
        BtnConvertirCoorde = new javax.swing.JButton();
        TxtDireccion = new javax.swing.JTextField();
        ComboDesp = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaDestino = new javax.swing.JTable();
        BtnGenerar = new javax.swing.JButton();
        txtLongitud = new javax.swing.JTextField();
        txtLatitud = new javax.swing.JTextField();
        BtnModificarDes = new javax.swing.JButton();
        BtnEliminarDes = new javax.swing.JButton();
        BtnAtras = new javax.swing.JButton();
        BtnRegistrarViaje = new javax.swing.JButton();
        txtID = new javax.swing.JTextField();
        LbIDDes = new javax.swing.JLabel();
        LbVisita = new javax.swing.JLabel();
        LbMeTrans = new javax.swing.JLabel();
        LbDirecExa = new javax.swing.JLabel();
        LbLongitud = new javax.swing.JLabel();
        LbLatitud = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        LbLongitud2 = new javax.swing.JLabel();
        LbDest = new javax.swing.JLabel();
        LbDirex = new javax.swing.JLabel();
        LbLA = new javax.swing.JLabel();
        LbLon = new javax.swing.JLabel();
        LbDes1 = new javax.swing.JLabel();
        LbDespla = new javax.swing.JLabel();
        LbLongi = new javax.swing.JLabel();
        LbLati = new javax.swing.JLabel();
        LbDirExac = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1399, 610));
        getContentPane().setLayout(null);
        getContentPane().add(jDateChooser1);
        jDateChooser1.setBounds(570, 210, 130, 30);

        BtnConvertirDirec.setBackground(new java.awt.Color(255, 255, 255));
        BtnConvertirDirec.setText("Convertir Dirección");
        BtnConvertirDirec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnConvertirDirecActionPerformed(evt);
            }
        });
        getContentPane().add(BtnConvertirDirec);
        BtnConvertirDirec.setBounds(560, 100, 150, 23);

        BtnConvertirCoorde.setBackground(new java.awt.Color(255, 255, 255));
        BtnConvertirCoorde.setText("Convertir Coordenadas");
        BtnConvertirCoorde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnConvertirCoordeActionPerformed(evt);
            }
        });
        getContentPane().add(BtnConvertirCoorde);
        BtnConvertirCoorde.setBounds(560, 160, 160, 23);
        getContentPane().add(TxtDireccion);
        TxtDireccion.setBounds(200, 100, 330, 30);

        ComboDesp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Carro", "Transporte Público", "A pie", "Bicicleta", "Avión" }));
        getContentPane().add(ComboDesp);
        ComboDesp.setBounds(180, 220, 150, 20);

        TablaDestino.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(TablaDestino);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(790, 20, 540, 402);

        BtnGenerar.setBackground(new java.awt.Color(255, 255, 255));
        BtnGenerar.setText("Generar Destino");
        BtnGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGenerarActionPerformed(evt);
            }
        });
        getContentPane().add(BtnGenerar);
        BtnGenerar.setBounds(20, 270, 130, 23);

        txtLongitud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLongitudActionPerformed(evt);
            }
        });
        getContentPane().add(txtLongitud);
        txtLongitud.setBounds(360, 160, 150, 30);
        getContentPane().add(txtLatitud);
        txtLatitud.setBounds(100, 160, 150, 30);

        BtnModificarDes.setText("Modificar Destino");
        BtnModificarDes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnModificarDesActionPerformed(evt);
            }
        });
        getContentPane().add(BtnModificarDes);
        BtnModificarDes.setBounds(850, 440, 130, 23);

        BtnEliminarDes.setText("Eliminar Destino");
        BtnEliminarDes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarDesActionPerformed(evt);
            }
        });
        getContentPane().add(BtnEliminarDes);
        BtnEliminarDes.setBounds(1100, 440, 120, 23);

        BtnAtras.setBackground(new java.awt.Color(255, 255, 255));
        BtnAtras.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        BtnAtras.setText("Atras");
        BtnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAtrasActionPerformed(evt);
            }
        });
        getContentPane().add(BtnAtras);
        BtnAtras.setBounds(1290, 520, 70, 30);

        BtnRegistrarViaje.setBackground(new java.awt.Color(255, 255, 255));
        BtnRegistrarViaje.setText("Registrar Viaje");
        BtnRegistrarViaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRegistrarViajeActionPerformed(evt);
            }
        });
        getContentPane().add(BtnRegistrarViaje);
        BtnRegistrarViaje.setBounds(20, 490, 120, 23);
        getContentPane().add(txtID);
        txtID.setBounds(150, 50, 150, 30);

        LbIDDes.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        LbIDDes.setForeground(new java.awt.Color(255, 255, 255));
        LbIDDes.setText("-");
        getContentPane().add(LbIDDes);
        LbIDDes.setBounds(170, 320, 120, 30);

        LbVisita.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        LbVisita.setForeground(new java.awt.Color(255, 255, 255));
        LbVisita.setText("Fecha tentativa de visita");
        getContentPane().add(LbVisita);
        LbVisita.setBounds(340, 210, 240, 30);

        LbMeTrans.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        LbMeTrans.setForeground(new java.awt.Color(255, 255, 255));
        LbMeTrans.setText("Desplazamiento");
        getContentPane().add(LbMeTrans);
        LbMeTrans.setBounds(20, 210, 160, 30);

        LbDirecExa.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        LbDirecExa.setForeground(new java.awt.Color(255, 255, 255));
        LbDirecExa.setText("Dirección exacta");
        getContentPane().add(LbDirecExa);
        LbDirecExa.setBounds(20, 100, 170, 30);

        LbLongitud.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        LbLongitud.setForeground(new java.awt.Color(255, 255, 255));
        LbLongitud.setText("Longitud");
        getContentPane().add(LbLongitud);
        LbLongitud.setBounds(280, 160, 80, 30);

        LbLatitud.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        LbLatitud.setForeground(new java.awt.Color(255, 255, 255));
        LbLatitud.setText("Latitud");
        getContentPane().add(LbLatitud);
        LbLatitud.setBounds(30, 160, 70, 20);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Gestionar Lugares de Destino");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 0, 310, 50);

        LbLongitud2.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        LbLongitud2.setForeground(new java.awt.Color(255, 255, 255));
        LbLongitud2.setText("ID del Destino");
        getContentPane().add(LbLongitud2);
        LbLongitud2.setBounds(20, 50, 130, 30);

        LbDest.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        LbDest.setForeground(new java.awt.Color(255, 255, 255));
        LbDest.setText("ID del Destino");
        getContentPane().add(LbDest);
        LbDest.setBounds(20, 320, 100, 30);

        LbDirex.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        LbDirex.setForeground(new java.awt.Color(255, 255, 255));
        LbDirex.setText("Dirección Exacta");
        getContentPane().add(LbDirex);
        LbDirex.setBounds(20, 350, 130, 30);

        LbLA.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        LbLA.setForeground(new java.awt.Color(255, 255, 255));
        LbLA.setText("Latitud");
        getContentPane().add(LbLA);
        LbLA.setBounds(20, 380, 60, 30);

        LbLon.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        LbLon.setForeground(new java.awt.Color(255, 255, 255));
        LbLon.setText("Longitud");
        getContentPane().add(LbLon);
        LbLon.setBounds(20, 410, 60, 30);

        LbDes1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        LbDes1.setForeground(new java.awt.Color(255, 255, 255));
        LbDes1.setText("Desplazamiento");
        getContentPane().add(LbDes1);
        LbDes1.setBounds(20, 440, 120, 30);

        LbDespla.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        LbDespla.setForeground(new java.awt.Color(255, 255, 255));
        LbDespla.setText("-");
        getContentPane().add(LbDespla);
        LbDespla.setBounds(170, 440, 190, 30);

        LbLongi.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        LbLongi.setForeground(new java.awt.Color(255, 255, 255));
        LbLongi.setText("-");
        getContentPane().add(LbLongi);
        LbLongi.setBounds(170, 410, 200, 30);

        LbLati.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        LbLati.setForeground(new java.awt.Color(255, 255, 255));
        LbLati.setText("-");
        getContentPane().add(LbLati);
        LbLati.setBounds(170, 380, 160, 30);

        LbDirExac.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        LbDirExac.setForeground(new java.awt.Color(255, 255, 255));
        LbDirExac.setText("-");
        getContentPane().add(LbDirExac);
        LbDirExac.setBounds(170, 350, 270, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\nenis\\Desktop\\7o1B528.jpg")); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, -20, 1400, 610);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAtrasActionPerformed
       InterfazInicio obj = new InterfazInicio();
       obj.setVisible(true);
       dispose();
    }//GEN-LAST:event_BtnAtrasActionPerformed

    private void BtnConvertirDirecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnConvertirDirecActionPerformed
       Geocoding ObjGeocod=new Geocoding();
       try {
            String Direccion = TxtDireccion.getText();
            Point2D.Double resultadoCD=ObjGeocod.getCoordinates(Direccion);
            double lat = resultadoCD.x;
            String Latitud = Double.toString(lat);
            txtLatitud.setText(Latitud);
            double lon = resultadoCD.y;
            String Longitud = Double.toString(lon);
            txtLongitud.setText(Longitud);
            
            System.out.println("Las coordenadas de" + Direccion+ " son: " +
                    resultadoCD.x + "," + resultadoCD.y);
            

            
        } catch (Exception e) {
            error("CodificaciÃ³n geogrÃ¡fica");
}
    }//GEN-LAST:event_BtnConvertirDirecActionPerformed

    private void BtnConvertirCoordeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnConvertirCoordeActionPerformed
        Geocoding ObjGeocod=new Geocoding();
        try{
            //String Coordenadas = txtLatitud.getText()+","+txtLongitud.getText();
            double lat = Double.parseDouble(txtLatitud.getText());
            double lon = Double.parseDouble(txtLongitud.getText());
            ArrayList<String> resultadoCI=ObjGeocod.getAddress(lat, lon);
            System.out.println(resultadoCI.get(0)); 
            TxtDireccion.setText(resultadoCI.get(0));
        } catch (Exception e) {
           error("CodificaciÃ³n geogrÃ¡fica");
        
        }
    }//GEN-LAST:event_BtnConvertirCoordeActionPerformed

    private void BtnGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGenerarActionPerformed

        
        String ID = txtID.getText();
        String Direc = TxtDireccion.getText();
        String Lati = txtLatitud.getText();
        String Longi = txtLongitud.getText();
        String Desplaz = (String) ComboDesp.getSelectedItem();
        
        ObjectSet resultado=BD.Consultar();
		while(resultado.hasNext()) {
                    Destino Objeto = (Destino) resultado.next();
                    String id2 = Objeto.getID();
                    if(id2.equals(ID)){
                        JOptionPane.showMessageDialog(null, "No puede ingresar dos destinos con el mismo ID. Por favor ingrese otro destino");
                        return;
                    }else{
                        LbIDDes.setText(ID);
                        LbDirExac.setText(Direc);
                        LbLati.setText(Lati);
                        LbLongi.setText(Longi);
                        LbDespla.setText(Desplaz);
                    } 
		}
        
        
        
              
    }//GEN-LAST:event_BtnGenerarActionPerformed

    private void txtLongitudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLongitudActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLongitudActionPerformed

    private void BtnRegistrarViajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRegistrarViajeActionPerformed
        
        String ID = LbIDDes.getText();
        String Direc = LbDirExac.getText();
        String Lati = LbLati.getText();
        String Longi = LbLongi.getText();
        String Desplaz = LbDespla.getText();
        
        Destino destino = new Destino(ID,Direc,Lati,Longi,Desplaz);
        
        BD.Insertar(destino);
        
        modelo.setRowCount(0);
        ConsultarTabla();
        
        JOptionPane.showMessageDialog(null, "El Destino ha sido registrado");
    }//GEN-LAST:event_BtnRegistrarViajeActionPerformed

    private void BtnModificarDesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnModificarDesActionPerformed
        
        int FilaSelec =  TablaDestino.getSelectedRow();
        if (FilaSelec >= 0 ){
            txtID.setText(TablaDestino.getValueAt(FilaSelec, 0).toString());
            TxtDireccion.setText(TablaDestino.getValueAt(FilaSelec, 1).toString());
            txtLatitud.setText(TablaDestino.getValueAt(FilaSelec, 2).toString());
            txtLongitud.setText(TablaDestino.getValueAt(FilaSelec, 3).toString());
            
            String datoid = TablaDestino.getValueAt(FilaSelec, 0).toString();
            BD.Borrar(new Destino(datoid,null,null,null,null));
            
            modelo.removeRow(FilaSelec);
        
        }else{
            JOptionPane.showMessageDialog(null, "Debe seleccionar un destino");
        
        }
    }//GEN-LAST:event_BtnModificarDesActionPerformed

    private void BtnEliminarDesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarDesActionPerformed
        
         int FilaSelec =  TablaDestino.getSelectedRow();
         if (FilaSelec >= 0 ){
            String datoid = TablaDestino.getValueAt(FilaSelec, 0).toString();
            BD.Borrar(new Destino(datoid,null,null,null,null));
            modelo.removeRow(FilaSelec);
         }else{
             JOptionPane.showMessageDialog(null, "Debe seleccionar un destino");         
         }
    }//GEN-LAST:event_BtnEliminarDesActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaDestinos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaDestinos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaDestinos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaDestinos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaDestinos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAtras;
    private javax.swing.JButton BtnConvertirCoorde;
    private javax.swing.JButton BtnConvertirDirec;
    private javax.swing.JButton BtnEliminarDes;
    private javax.swing.JButton BtnGenerar;
    private javax.swing.JButton BtnModificarDes;
    private javax.swing.JButton BtnRegistrarViaje;
    private javax.swing.JComboBox<String> ComboDesp;
    private javax.swing.JLabel LbDes1;
    private javax.swing.JLabel LbDespla;
    private javax.swing.JLabel LbDest;
    private javax.swing.JLabel LbDirExac;
    private javax.swing.JLabel LbDirecExa;
    private javax.swing.JLabel LbDirex;
    private javax.swing.JLabel LbIDDes;
    private javax.swing.JLabel LbLA;
    private javax.swing.JLabel LbLati;
    private javax.swing.JLabel LbLatitud;
    private javax.swing.JLabel LbLon;
    private javax.swing.JLabel LbLongi;
    private javax.swing.JLabel LbLongitud;
    private javax.swing.JLabel LbLongitud2;
    private javax.swing.JLabel LbMeTrans;
    private javax.swing.JLabel LbVisita;
    private javax.swing.JTable TablaDestino;
    private javax.swing.JTextField TxtDireccion;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtLatitud;
    private javax.swing.JTextField txtLongitud;
    // End of variables declaration//GEN-END:variables
}
