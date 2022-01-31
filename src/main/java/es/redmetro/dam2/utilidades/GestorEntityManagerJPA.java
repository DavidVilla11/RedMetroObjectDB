package es.redmetro.dam2.utilidades;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GestorEntityManagerJPA {
	private final static String UNIDADPERSISTENCIA_REDMETRO_OBJECTDB="UP_REDMETRO_ODB";
	
	private static EntityManagerFactory emf_ODB; 
	//EntityManager para JPA 	
	public static EntityManager getEntityManager() {
		EntityManager gestorEntidades=null;
		
		// Se apoya en el fichero persistence.xml
		if(emf_ODB==null)
			emf_ODB= Persistence.createEntityManagerFactory(UNIDADPERSISTENCIA_REDMETRO_OBJECTDB);

		gestorEntidades = emf_ODB.createEntityManager();
		return gestorEntidades;
	}
}
