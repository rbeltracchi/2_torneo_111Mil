package com.siira.alpha;
//1martrod comentario
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="noticia")
public class Noticia {
	
	private int noticia_id;
	private Date fecha;
	private String seccion;
	private String nombre;
	private String foto;
	private String volanta;
	private String titulo;
	private String copete;
	private String cuerpo;
	
	@Id
	@Column(name="noticia_id")
	public int getNoticia_id() {
		return noticia_id;
	}
	public void setNoticia_id(int noticia_id) {
		this.noticia_id = noticia_id;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getSeccion() {
		return seccion;
	}
	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public String getVolanta() {
		return volanta;
	}
	public void setVolanta(String volanta) {
		this.volanta = volanta;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getCopete() {
		return copete;
	}
	public void setCopete(String copete) {
		this.copete = copete;
	}
	public String getCuerpo() {
		return cuerpo;
	}
	public void setCuerpo(String cuerpo) {
		this.cuerpo = cuerpo;
	}	
}
