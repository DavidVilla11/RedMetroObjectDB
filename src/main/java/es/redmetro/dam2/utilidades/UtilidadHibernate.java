package es.redmetro.dam2.utilidades;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.Session;

public class UtilidadHibernate {
	private final static String UNIDADPERSISTENCIA_REDMETRO_HIBERNATE="UP_REDMETRO_HBT";
	private static EntityManagerFactory entityManagerFactory=null;

	public static Session getSession() {
		Session sesionHibernate=null;
		EntityManager gestorEntidades=null;

		if(entityManagerFactory==null)	
			entityManagerFactory= Persistence.createEntityManagerFactory(UNIDADPERSISTENCIA_REDMETRO_HIBERNATE);

		gestorEntidades = entityManagerFactory.createEntityManager();
		sesionHibernate=(Session)gestorEntidades.getDelegate();
		
		return sesionHibernate;
	}


    public static void shutdown() {
    	entityManagerFactory.close();
    }
}
