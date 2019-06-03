package com.siira.alpha;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario {
	
	private int usuario_id;
	private String email;
	private String nombre;
	private String apellido;
	private String calle;
	private int numero;
	private String contrasena;
	
	public Usuario() {};
	public Usuario(String email, String nombre, String apellido, String calle, int numero, String contrasena) {
		this.email = email;
		this.nombre = nombre;
		this.apellido = apellido;
		this.calle = calle;
		this.numero = numero;
		this.contrasena=contrasena;
	};
	
	@Id
	@Column(name="usuario_id")
	public int getId() {
		return this.usuario_id;
	}
	public void setId(int usuario_id) {
		this.usuario_id = usuario_id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public  String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena=contrasena;
	}
	@Override
	public String toString() {
		return "Usuario [usuario_id=" + usuario_id + ", email=" + email + ", nombre=" + nombre + ", apellido="
				+ apellido + ", calle=" + calle + ", numero=" + numero + "]";
	}
	
}
