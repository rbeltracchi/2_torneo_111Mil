package com.siira.alpha;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;


public class Admin extends JFrame {
	
private DbService DbManager;
private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
private final JPanel all_panel = new JPanel();
private int EjeX_menu = 50;
private int EjeY_menu = 50;
	
	public Admin (DbService DbManager) {
		this.DbManager=DbManager;
		initialize ();
	}
	
	public void initialize () {
        this.setAlwaysOnTop(true);
		this.setBounds(0, 0,(int) Math.round(screenSize.getWidth()),700);
		this.setLayout(null);
		
		all_panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		all_panel.setBounds(300, 50, 1000, 600);
		all_panel.setBackground(SystemColor.menu);
		all_panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		//-----------MENU
		JButton btnNoticias = new JButton("Noticias");
		JButton btnRecorridos = new JButton("Recorridos");
		JButton btnPromotoras = new JButton("Promotoras");
		JButton btnConsejos = new JButton("Consejos");
		
		btnNoticias.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 11));
		btnRecorridos.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 11));
		btnPromotoras.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 11));
		btnConsejos.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 11));
		
		
		btnNoticias.setBounds(EjeX_menu, EjeY_menu, 200, 30);
		EjeY_menu += 50;
		btnRecorridos.setBounds(EjeX_menu, EjeY_menu, 200, 30);
		EjeY_menu += 50;
		btnPromotoras.setBounds(EjeX_menu, EjeY_menu, 200, 30);
		EjeY_menu += 50;
		btnConsejos.setBounds(EjeX_menu, EjeY_menu, 200, 30);
		EjeY_menu += 50;
		
		
		// LISTENER/ACTIONS
		btnNoticias.addActionListener(new ActionListener() { 
		    public void actionPerformed(ActionEvent e) { 
		        getNoticias();
		    } 
		});	
		
		this.add(btnNoticias);
		this.add(btnRecorridos);
		this.add(btnPromotoras);
		this.add(btnConsejos);
		btnRecorridos.setEnabled(false);
		btnPromotoras.setEnabled(false);
		btnConsejos.setEnabled(false);
		this.add(all_panel);
		
	}
	
	private void getNoticias() {
		all_panel.removeAll();
		all_panel.setVisible(true);
		List response = DbManager.getNoticias();
		final JList listanoticias = new JList();
		
		for (Iterator iterator = response.iterator(); iterator.hasNext();){
            Noticias item = (Noticias) iterator.next();
            JLabel tituloitem = new JLabel(item.getTitulo());
            listanoticias.add(tituloitem);
         }
		all_panel.add(listanoticias);
	};
	
	
}
