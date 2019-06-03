package com.siira.alpha;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame{
	private DbService DbManager;
	
	public Login (DbService DbManager) {
		this.DbManager=DbManager;
		initialize ();
	}
	
	public void initialize () {
        this.setAlwaysOnTop(true);
		this.setBounds(300, 100, 400, 600);
		this.setLayout(null);
		
		JLabel labelMail= new JLabel("Ingreses Email");
		 labelMail.setBounds(150, 100, 220, 74);
		this.add(labelMail);
		
		final JTextField tMail=new JTextField();
		tMail.setBounds(100, 150, 200, 30);
		this.add(tMail);
		// Checkear si el email es valido.
		
		//
		
		JLabel labelContrasena= new JLabel("Ingrese Contrase\u00f1a");
		labelContrasena.setBounds(150, 200, 220, 74);
		this.add(labelContrasena);
		
		final JPasswordField tContrasena=new JPasswordField();
		tContrasena.setBounds(100, 250, 200, 30);
		this.add(tContrasena);
		final JFrame panel=this;
		JButton botonSiguiente= new JButton("siguiente");
		botonSiguiente.setBounds(125, 500, 150, 30);
		this.add(botonSiguiente);
		botonSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String myPass=String.valueOf(tContrasena.getPassword());
				DbManager.getUsuario(tMail.getText(),myPass);
                                Usuario usuario = DbManager.getUsuario(tMail.getText(),myPass);
                                if (usuario==null) {
                                    JOptionPane.showMessageDialog(panel,"Email o password incorrecto.");                                    
                                } else {
                                    JOptionPane.showMessageDialog(panel,"Usuario validado.");
                                    panel.setVisible(false);
                                    Admin adm=new Admin(DbManager);
                                    adm.setVisible(true);
                                }
			}
		});
	}
	


}
