/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VENTANAS;

import BASE_DE_DATOS.ConexionMysql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;

/**
 *
 * @author Paula
 */
public class Informacion_cliente extends javax.swing.JDialog {

    private DefaultTableModel modelo;

    /**
     * Creates new form Informacion_cliente
     */
    public Informacion_cliente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        cargartabla();
        cargartabla2();

    }

    void Eliminar(String valor) {

        String sql = "DELETE Nombres WHERE CONCAT(Nombres, ' ' from clientes where id= (" + valor + ")";
        ConexionMysql mysql = new ConexionMysql();
        Connection coneccion = (Connection) mysql.Conectar();
        try {

            com.mysql.jdbc.Statement instruccion = (com.mysql.jdbc.Statement) coneccion.createStatement();
            boolean borrado = instruccion.execute(sql);
            cargartabla();
            if (borrado = true) {
                JOptionPane.showMessageDialog(null, "Se Ha Eliminado Exitosamente");
            } else {
                JOptionPane.showMessageDialog(null, "El ID Ingresado no Existe");
            }
        } catch (SQLException ex) {
        }
    }

    void Busqueda(String valor) {
        String[] titulos = {"ID", "Nombre", "ApellidoP", "ApellidoM", "Calle", "#", "Col", "Del", "CP", "TEL"};
        String[] registro = new String[10];
        String sSQL = "";
        modelo = new DefaultTableModel(null, titulos);

        ConexionMysql mysql = new ConexionMysql();
        com.mysql.jdbc.Connection cn = (com.mysql.jdbc.Connection) mysql.Conectar();

        sSQL = "SELECT IDCliente,Nombres,ApellidoPaterno,ApellidoMaterno,Calle,Numero,Colonia,Delegacion,CP,Telefono FROM cliente "
                + "WHERE CONCAT(Nombres, ' ',ApellidoPaterno) LIKE '%" + valor + "%'";
        try {
            com.mysql.jdbc.Statement st = (com.mysql.jdbc.Statement) cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("IDCliente");
                registro[1] = rs.getString("Nombres");
                registro[2] = rs.getString("ApellidoPaterno");
                registro[3] = rs.getString("ApellidoMaterno");
                registro[4] = rs.getString("Calle");
                registro[5] = rs.getString("Numero");
                registro[6] = rs.getString("Colonia");
                registro[7] = rs.getString("Delegacion");
                registro[8] = rs.getString("CP");
                registro[9] = rs.getString("Telefono");
                modelo.addRow(registro);
            }
            tblDatos.setModel(modelo);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }

    void cargartabla() {
        String[] titulos = {"ID", "Nombre", "ApellidoP", "ApellidoM", "Calle", "#", "Col", "Del", "CP", "TEL"};
        String[] registro = new String[10];
        DefaultTableModel modelo;
        modelo = new DefaultTableModel(null, titulos);
        ConexionMysql mysql = new ConexionMysql();
        Connection cn = mysql.Conectar();
        try {

            PreparedStatement pst = (PreparedStatement) cn.prepareStatement("SELECT IDCliente,Nombres,ApellidoPaterno,ApellidoMaterno,Calle,Numero,Colonia,Delegacion,CP,Telefono FROM cliente");
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                registro[0] = res.getString("IDCliente");
                registro[1] = res.getString("Nombres");
                registro[2] = res.getString("ApellidoPaterno");
                registro[3] = res.getString("ApellidoMaterno");
                registro[4] = res.getString("Calle");
                registro[5] = res.getString("Numero");
                registro[6] = res.getString("Colonia");
                registro[7] = res.getString("Delegacion");
                registro[8] = res.getString("CP");
                registro[9] = res.getString("Telefono");

                modelo.addRow(registro);
            }
            tblDatos.setModel(modelo);
        } catch (SQLException ex) {
            System.out.print(ex.getMessage());
        }
    }

    void cargartabla2() {
        String[] titulos = {"CLAVE", "Edad", "Sexo", "Talla", "Estatura", "Frec", "Peso", "NSS", "Ins", "TelEmerg", "Contacto"};
        String[] registro = new String[11];
        DefaultTableModel modelo;
        modelo = new DefaultTableModel(null, titulos);
        ConexionMysql mysql = new ConexionMysql();
        Connection cn = mysql.Conectar();
        try {

            PreparedStatement pst = (PreparedStatement) cn.prepareStatement("SELECT Clave_expediente,Edad,Sexo,Talla,Estatura,Frec_Car,Peso,NumSS,Institucion,TelEmerg,NomFamiliar FROM expediente_cliente");
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                registro[0] = res.getString("Clave_expediente");
                registro[1] = res.getString("Edad");
                registro[2] = res.getString("Sexo");
                registro[3] = res.getString("Talla");
                registro[4] = res.getString("Estatura");
                registro[5] = res.getString("Frec_Car");
                registro[6] = res.getString("Peso");
                registro[7] = res.getString("NumSS");
                registro[8] = res.getString("Institucion");
                registro[9] = res.getString("TelEmerg");
                registro[10] = res.getString("NomFamiliar");

                modelo.addRow(registro);
            }
            tblDatos2.setModel(modelo);
        } catch (SQLException ex) {
            System.out.print(ex.getMessage());
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

        panel1 = new org.edisoncor.gui.panel.Panel();
        jButton1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        textBUSCAR1 = new org.edisoncor.gui.textField.TextField();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        panelImage1 = new org.edisoncor.gui.panel.PanelImage();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDatos2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panel1.setColorPrimario(new java.awt.Color(50, 119, 255));
        panel1.setColorSecundario(new java.awt.Color(200, 216, 252));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES_REDISEÑO/CERRAR-NORM.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES_REDISEÑO/CERRAR-PRESS.png"))); // NOI18N
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES_REDISEÑO/CERRAR-ROLL.png"))); // NOI18N
        jButton1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES_REDISEÑO/BUSCAR-NORM.png"))); // NOI18N
        jButton5.setBorder(null);
        jButton5.setBorderPainted(false);
        jButton5.setContentAreaFilled(false);
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES_REDISEÑO/BUSCAR-PRESS.png"))); // NOI18N
        jButton5.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES_REDISEÑO/BUSCAR-ROLL.png"))); // NOI18N
        jButton5.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/BOTONES/MOSTRAR-NORM.png"))); // NOI18N
        jButton6.setBorder(null);
        jButton6.setBorderPainted(false);
        jButton6.setContentAreaFilled(false);
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/BOTONES/MOSTRAR-PRESS.png"))); // NOI18N
        jButton6.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/BOTONES/MOSTRAR-ROLL.png"))); // NOI18N
        jButton6.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/BOTONES/ELIMINAR-NORM.png"))); // NOI18N
        jButton7.setBorder(null);
        jButton7.setBorderPainted(false);
        jButton7.setContentAreaFilled(false);
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.setDefaultCapable(false);
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton7.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/BOTONES/ELIMINAR-PRESS.png"))); // NOI18N
        jButton7.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/BOTONES/ELIMINAR-ROLL.png"))); // NOI18N
        jButton7.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jButton7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES_REDISEÑO/MOD-NORM.png"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES_REDISEÑO/MOD-PRESS.png"))); // NOI18N
        jButton2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES_REDISEÑO/MOD-ROLL.png"))); // NOI18N
        jButton2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        panelImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES_REDISEÑO/LETRERO-CLIENTES.png"))); // NOI18N

        javax.swing.GroupLayout panelImage1Layout = new javax.swing.GroupLayout(panelImage1);
        panelImage1.setLayout(panelImage1Layout);
        panelImage1Layout.setHorizontalGroup(
            panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 394, Short.MAX_VALUE)
        );
        panelImage1Layout.setVerticalGroup(
            panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        tblDatos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblDatos);

        tblDatos2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblDatos2);

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(206, 206, 206)
                        .addComponent(panelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jButton5)
                        .addGap(18, 18, 18)
                        .addComponent(textBUSCAR1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(jButton7)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(177, 177, 177)
                                .addComponent(jButton1))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(jButton6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2)))))
                .addGap(0, 828, Short.MAX_VALUE))
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 238, Short.MAX_VALUE)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton6)
                    .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(textBUSCAR1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton7)
                    .addComponent(jButton2))
                .addGap(39, 39, 39)
                .addComponent(jButton1)
                .addGap(57, 57, 57))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        cerrar();
        Clientes dialog = new Clientes(new javax.swing.JFrame(), true);
        dialog.setTitle("CLIENTES");
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }
//TU QUE OPINAS DAFNE, CODIGO O DOCUMENTACION? ps yo digo q con que quede el codigo y 
    //      ya aunque cambiemos la documentacion porq lo q nos preocupa ahorita es el 
    //            ch,,,, prototipo y es el mas dificil no?
    //          TERMINA yo digo q ps asi como vamos no cambia la documentacion lo q cambia son 
    //                los diagramas de secuencia no?
    //              SI LO UNICO QUE ME PREOCUPA SON LOS DIAGRAMAS DE SECUENCIA
    //                    PERO ASI COMO LO TENEMOS YA SE CAMBIO TODO
    //                          ASI QUE MEJOR QUE LA DOCUMENTACION SE AJUSTE AL PROGRAMA
    //                                TaTa!!! si mejor nos quedamos con el programa y ya ajustamos la documenta
    //                                      cion
    //                                            VALE MAÑANA TERMINAMOS CON LO DE ELIMINAR Y MODIFICAR PERO EN BASE AL DE DIRECTORIO
    //                                                 si yo opino lo mismo q como el de directorio VALE... DECLARO FINALIZADA LA SESION JAJAJA :P:P:P
    //                                                       vale
    //                                                     -MOSTRAR(BOTON)-
    //                                                   -EDITAR-EN LA NUEVA PANTALLA
    //                                                 

                                 //                                               -ELIMINAR-EN LA PANTALLA 
    //                                             BASE DE DIRECTORIO
    private void cerrar() {
        this.setVisible(false);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        String valor = textBUSCAR1.getText();
        Eliminar(valor);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        String valor = textBUSCAR1.getText();
        Busqueda(valor);

    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(Informacion_cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Informacion_cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Informacion_cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Informacion_cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Informacion_cliente dialog = new Informacion_cliente(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private org.edisoncor.gui.panel.Panel panel1;
    private org.edisoncor.gui.panel.PanelImage panelImage1;
    private javax.swing.JTable tblDatos;
    private javax.swing.JTable tblDatos2;
    private org.edisoncor.gui.textField.TextField textBUSCAR1;
    // End of variables declaration//GEN-END:variables
}
