package es.redmetro.dam2.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;

import org.hibernate.HibernateException;

import es.redmetro.dam2.dao.IBaseGeneralDao;
import es.redmetro.dam2.dao.ILineaDao;
import es.redmetro.dam2.excepciones.RedMetroException;
import es.redmetro.dam2.utilidades.GestorEntityManagerJPA;
import es.redmetro.dam2.vo.Linea;

public class LineaDaoJPA implements ILineaDao {

	private EntityManager entityManager;
	
	
	public void crear(Linea entidad) throws RedMetroException {
		EntityTransaction transaccion=null;
		try {
			entityManager=GestorEntityManagerJPA.getEntityManager();
			transaccion=entityManager.getTransaction();
			transaccion.begin();
			
			entityManager.persist(entidad);
            
            transaccion.commit();
        } catch (RollbackException err) {
        }
        catch (PersistenceException e) {
            if(transaccion != null)
            	transaccion.rollback();
            throw new  RedMetroException(RedMetroException.ERROR_ALTA, e);            
        } finally {
        	if (entityManager!=null)
        		entityManager.close();
        }				
		
		
	}

	
	public void borrar(Linea entidad) throws RedMetroException {
		EntityTransaction transaccion=null;
		try {
			entityManager=GestorEntityManagerJPA.getEntityManager();
			transaccion=entityManager.getTransaction();
			transaccion.begin();
			
			if (!entityManager.contains(entidad))
				entidad=entityManager.merge(entidad);

			entityManager.remove(entidad);
            
            transaccion.commit();
        } catch (PersistenceException e) {
            if(transaccion != null)
            	transaccion.rollback();
            throw new  RedMetroException(RedMetroException.ERROR_BORRAR, e);            
        } finally {
        	if (entityManager!=null)
        		entityManager.close();
        }	
		
	}

	
	public void actualizar(Linea entidad) throws RedMetroException {
		EntityTransaction transaccion=null;
		try {
			entityManager=GestorEntityManagerJPA.getEntityManager();
			transaccion=entityManager.getTransaction();
			transaccion.begin();
			
			if (!entityManager.contains(entidad))
				entidad=entityManager.merge(entidad);
			
//			Se actualizará cualquier cambio existente entre el objeto que está en la base de datos y el que 
//			se maneja como entidad, siempre que esté entre el comienzo y la confirmación de una transacción. 

            
            transaccion.commit();
        } catch (PersistenceException e) {
            if(transaccion != null)
            	transaccion.rollback();
            throw new  RedMetroException(RedMetroException.ERROR_MODIFICAR, e);            
        } finally {
        	if (entityManager!=null)
        		entityManager.close();
        }	
		
	}

	
	public Linea getEntirdadPorID(int idEntidad) throws RedMetroException {
		Linea linea = null;
		try {
			entityManager=GestorEntityManagerJPA.getEntityManager();
			
			linea = entityManager.find(Linea.class, idEntidad);
			
		}catch (NoResultException e) {
			linea = null;
		}catch(PersistenceException e){
			throw new RedMetroException(RedMetroException.ERROR_CONSULTA, e);
		}finally {
			if (entityManager!=null)
        		entityManager.close();
		}
		
		return linea;
	}

	
	public List<Linea> getListaEntidades() throws RedMetroException {
		List<Linea> linea = null;
		try {
			entityManager=GestorEntityManagerJPA.getEntityManager();
			
			String sentenciaJPQL="SELECT linea FROM Linea linea";
			
			TypedQuery<Linea> query =entityManager.createQuery(sentenciaJPQL, Linea.class);
			
		}catch (NoResultException e) {
			linea = null;
		}catch(HibernateException e){
			throw new RedMetroException(RedMetroException.ERROR_CONSULTA, e);
		}finally {
        	if (entityManager!=null)
        		entityManager.close();
		}
		
		return linea;
	}

}
