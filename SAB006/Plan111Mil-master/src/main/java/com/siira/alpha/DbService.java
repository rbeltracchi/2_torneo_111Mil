package com.siira.alpha;


import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DbService {
	
	private Configuration configuration;
	private SessionFactory sessionFactory;
	private Session session; 
	
	public DbService() {
		this.configuration = new Configuration().configure();
	    this.sessionFactory = configuration.buildSessionFactory();
	    this.session = sessionFactory.openSession();
	}
	
	
	
	public List getNoticias() {		
		Transaction tx= this.session.beginTransaction();
		String query = "From Noticias";
        List response = session.createQuery(query).list();
        tx.commit();
        return response;
	}
	
	public List getUsuarios(){
		Transaction tx= this.session.beginTransaction();
		String query = "From Usuario";
        List response = session.createQuery(query).list();
        tx.commit();
        return response;
	}
	
	public Usuario getUsuario(String Mail, String contrasena){
		Transaction tx= this.session.beginTransaction();
		String query = "From Usuario where email='"+Mail+"' and contrasena='"+contrasena+"'";
        List<Usuario> response = session.createQuery(query).list();
        tx.commit();
        if (response.isEmpty()) return null;
        return response.get(0);
	}
}
