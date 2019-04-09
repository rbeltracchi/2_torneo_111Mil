/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tusalud.interfaces;

import com.mycompany.tusalud.controller.MenuController;
import com.mycompany.tusalud.data.Paciente;
import com.mycompany.tusalud.excepciones.BDException;
import com.mycompany.tusalud.excepciones.LoginException;
import java.time.LocalDate;

/**
 *
 * @author User
 */
public class VistaMenu extends javax.swing.JFrame {

    MenuController menuController;

    /**
     * Creates new form Menu
     * @param menuService
     */
    public VistaMenu(MenuController menuController) {
        this.menuController = menuController;
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        jButtonCerrarSesion = new javax.swing.JButton();
        jButtonNotificaciones = new javax.swing.JButton();
        jButtonTurnosAdquiridos = new javax.swing.JButton();
        jButtonSacarTurno = new javax.swing.JButton();
        jLabelNombreUsuario = new javax.swing.JLabel();
        jLabelFecha = new javax.swing.JLabel();
        Fondo = new javax.swing.JLabel();

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(238, 112, 82));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonCerrarSesion.setBackground(new java.awt.Color(255, 255, 255));
        jButtonCerrarSesion.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonCerrarSesion.setText("Cerrar Sesion");
        jButtonCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCerrarSesionActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 690, 160, -1));

        jButtonNotificaciones.setBackground(new java.awt.Color(255, 255, 255));
        jButtonNotificaciones.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButtonNotificaciones.setText("Notificaciones");
        jButtonNotificaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNotificacionesActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonNotificaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 310, 250, 60));

        jButtonTurnosAdquiridos.setBackground(new java.awt.Color(255, 255, 255));
        jButtonTurnosAdquiridos.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButtonTurnosAdquiridos.setText("Turnos Adquiridos");
        jButtonTurnosAdquiridos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTurnosAdquiridosActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonTurnosAdquiridos, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 450, -1, 60));

        jButtonSacarTurno.setBackground(new java.awt.Color(255, 255, 255));
        jButtonSacarTurno.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButtonSacarTurno.setText("Sacar Turno");
        jButtonSacarTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSacarTurnoActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSacarTurno, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 170, 250, 60));

        jLabelNombreUsuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelNombreUsuario.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNombreUsuario.setText(getNombreDeUsuario());
        getContentPane().add(jLabelNombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 10, 130, 20));

        jLabelFecha.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelFecha.setForeground(new java.awt.Color(255, 255, 255));
        jLabelFecha.setText(getFechaDeHoy());
        getContentPane().add(jLabelFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 10, 100, 20));

        Fondo.setForeground(new java.awt.Color(255, 255, 255));
        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesL2/FondoTuSaslud.png"))); // NOI18N
        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSacarTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSacarTurnoActionPerformed
        try {
            menuController.crearSeleccionEspecialidad();
        } catch (BDException ex) {
            MiDialogo.mostrar(ex, "Error");
        } catch (LoginException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButtonSacarTurnoActionPerformed

    private void jButtonTurnosAdquiridosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTurnosAdquiridosActionPerformed
        // TODO add your handling code here:
        try {
            menuController.crearCancelarTurnos(this);
        } catch (BDException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButtonTurnosAdquiridosActionPerformed

    private void jButtonNotificacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNotificacionesActionPerformed
        menuController.crearNotificaciones();
    }//GEN-LAST:event_jButtonNotificacionesActionPerformed

    private void jButtonCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCerrarSesionActionPerformed
        menuController.cerrarSesion();
    }//GEN-LAST:event_jButtonCerrarSesionActionPerformed

    public String getFechaDeHoy(){
        LocalDate fechaDeHoy = LocalDate.now();
        return fechaDeHoy.toString();
    }
    
    public String getNombreDeUsuario(){
        Paciente paciente = menuController.getUsuario();
        return paciente.getNombre() + " " + paciente.getApellido();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Fondo;
    private javax.swing.JButton jButtonCerrarSesion;
    private javax.swing.JButton jButtonNotificaciones;
    private javax.swing.JButton jButtonSacarTurno;
    private javax.swing.JButton jButtonTurnosAdquiridos;
    private javax.swing.JLabel jLabelFecha;
    private javax.swing.JLabel jLabelNombreUsuario;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}
