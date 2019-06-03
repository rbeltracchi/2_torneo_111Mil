package com.siira.alpha;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

public class Home {

	private JFrame frame;
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
            
		final DbService DbManager = new DbService();
		frame = new JFrame();
		frame.setBounds(0, 0, (int) Math.round(screenSize.getWidth()), 713);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1366, 150);
		panel.setBackground(new Color(0, 128, 0));
		frame.getContentPane().add(panel);
		
		JLabel labelIcon = new JLabel();
		URL cl= this.getClass().getResource("/icon.jpg");
		ImageIcon icon = new ImageIcon(cl);
		labelIcon.setIcon(icon);
		labelIcon.setPreferredSize(new Dimension(1366, 150));
		panel.add(labelIcon);
		
		// -------------------- CONSEJOS ---------------------
		JButton btnConsejos = new JButton("Consejos");
		btnConsejos.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 11));
		btnConsejos.setBounds(32, 253, 110, 33);
		btnConsejos.setEnabled(false);
		frame.getContentPane().add(btnConsejos);
		
		
		//--------------- RECORRIDOS ------------------
		JButton btnRecorridos = new JButton("Recorridos");
		btnRecorridos.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 11));
		btnRecorridos.setBounds(32, 297, 110, 33);
		btnRecorridos.setEnabled(false);
		frame.getContentPane().add(btnRecorridos);
		
		//------------- LOGIN-----------------
		JButton btnLogin = new JButton("Ingresar");
		btnLogin.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 11));
		btnLogin.setEnabled(true);
		btnLogin.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Login login=new Login(DbManager);
				login.setVisible(true);				
		}});
		
		btnLogin.setBounds(32, 341, 110, 33);
		frame.getContentPane().add(btnLogin);
		
		
		
		// ------------------- PANELS
		final JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(152, 161, 1172, 502);
		panel_2.setBackground(SystemColor.menu);
		panel_2.setVisible(false);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		final JPanel panel_1 = new JPanel();
		panel_1.setBorder(UIManager.getBorder("InternalFrame.border"));
		panel_1.setBounds(152, 161, 1172, 502);
		panel_1.setBackground(SystemColor.menu);
		frame.getContentPane().add(panel_1);
		
		JLabel TituloRegistro = new JLabel("\u00A1Bienvenido!\r\n");
		TituloRegistro.setBounds(507, 44, 218, 50);
		TituloRegistro.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.setLayout(null);
		Dimension titlesize = new Dimension(200,50);
		TituloRegistro.setSize(titlesize);
		TituloRegistro.setFont(new Font("Agency FB", Font.BOLD, 40));
		panel_1.add(TituloRegistro);
		
		JLabel lblNewLabel = new JLabel("<html>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</html>");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setBounds(62, 152, 1026, 126);
		panel_1.add(lblNewLabel);
		
		
		//----NOTICIAS
		JButton btnNewButton = new JButton("Noticias");
		btnNewButton.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 11));
		btnNewButton.setBounds(32, 209, 110, 33);
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				panel_1.setVisible(false);
				panel_2.setVisible(true);
				List response = DbManager.getNoticias();
	            panel_2.removeAll();
				for (Iterator iterator = response.iterator(); iterator.hasNext();){
		            Noticias item = (Noticias) iterator.next();
		            JEditorPane editor = new JEditorPane();
		            editor.setPreferredSize(new Dimension(400,160));
		            editor.setEditable(false);
		            editor.setContentType("text/html");
		            editor.setText("<p><b>"+item.getTitulo()+"</b></p>"+item.getCuerpo());
		            editor.setMargin(new Insets(5,5,5,5));
		    		panel_2.add(editor);
		         }
			}});
		
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Inicio");
		btnNewButton_2.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 11));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel_1.setVisible(true);
				panel_2.setVisible(false);
			}
		});
		btnNewButton_2.setBounds(32, 161, 110, 37);
		frame.getContentPane().add(btnNewButton_2);
		
	}
	
}
