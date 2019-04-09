/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tusalud.interfacesEmpleado;

import com.mycompany.tusalud.controllerEmpleado.PacientesHabilitarDerivacionController;
import com.mycompany.tusalud.excepciones.BDException;
import com.mycompany.tusalud.excepciones.LoginException;
import com.mycompany.tusalud.interfaces.MiDialogo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Alumno
 */
public class VistaPacientesHabilitarDerivacion extends javax.swing.JFrame {

    PacientesHabilitarDerivacionController pacientesHabilitarDerivacionController;
    private Map<Integer, Integer> tablaBotonIdPaciente = new HashMap<>();
    private List<Object[]> lista;
    
    /**
     * Creates new form VistaPacientesHabilitarDerivacion
     * @param pacientesHabilitarDerivacionController
     * @param lista
     */
    public VistaPacientesHabilitarDerivacion(PacientesHabilitarDerivacionController pacientesHabilitarDerivacionController, List<Object[]> lista) {
        this.pacientesHabilitarDerivacionController = pacientesHabilitarDerivacionController;
        this.lista = lista;
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextFieldIndice = new javax.swing.JTextField();
        jButtonBuscar = new javax.swing.JButton();
        jButtonSeleccionarPaciente = new javax.swing.JButton();
        jButtonVolverAMenu = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            getMatrizObject(getArregloString().length),
            getArregloString()
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 430, 320));
        getContentPane().add(jTextFieldIndice, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 150, 120, -1));

        jButtonBuscar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonBuscar.setText("Buscar");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 180, 120, -1));

        jButtonSeleccionarPaciente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonSeleccionarPaciente.setText("Seleccionar Paciente");
        jButtonSeleccionarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSeleccionarPacienteActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSeleccionarPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 520, -1, -1));

        jButtonVolverAMenu.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonVolverAMenu.setText("Volver a menu");
        jButtonVolverAMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVolverAMenuActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonVolverAMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 670, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Habilitar Derivacion");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesL2/FondoNotificacion.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 750));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        pacientesHabilitarDerivacionController.buscarPacientePorIndice(jTextFieldIndice.getText()+"%", this);
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jButtonSeleccionarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSeleccionarPacienteActionPerformed
        Integer id = tablaBotonIdPaciente.get(jTable1.getSelectedRow());
        if(id != null){
            try {
                pacientesHabilitarDerivacionController.idPacienteSeleccionado(id, this);
            } catch (BDException ex) {
                MiDialogo.mostrar(ex, "Error al seleccionar paciente");
            } catch (LoginException ex) {
                MiDialogo.mostrar(ex, "Error");
            }
        }
        else{
            System.out.println("No ha seleccionado paciente");
        }
    }//GEN-LAST:event_jButtonSeleccionarPacienteActionPerformed

    private void jButtonVolverAMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVolverAMenuActionPerformed
        pacientesHabilitarDerivacionController.volverAMenu(this);
    }//GEN-LAST:event_jButtonVolverAMenuActionPerformed

    public Object[][] getMatrizObject(int tamaño){
        Object[][] matriz = new Object[lista.size()][tamaño];
        
        for(int fila=0; fila<lista.size(); fila++){
            
            matriz[fila][0] = lista.get(fila)[1];
            matriz[fila][1] = lista.get(fila)[2];
            matriz[fila][2] = lista.get(fila)[3];
            matriz[fila][3] = lista.get(fila)[4];
            
            tablaBotonIdPaciente.put(fila, (Integer) lista.get(fila)[0]);
        }
        
        return matriz;
    }
    
    public String[] getArregloString(){
        String[] arreglo = {"Apellido", "Nombre", "Historia Clinica", "Telefono"};
        
        return arreglo;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonSeleccionarPaciente;
    private javax.swing.JButton jButtonVolverAMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldIndice;
    // End of variables declaration//GEN-END:variables
}