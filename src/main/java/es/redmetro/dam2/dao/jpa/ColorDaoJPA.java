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
import es.redmetro.dam2.dao.IColorDao;
import es.redmetro.dam2.excepciones.RedMetroException;
import es.redmetro.dam2.utilidades.GestorEntityManagerJPA;
import es.redmetro.dam2.vo.Color;

public class ColorDaoJPA implements IColorDao {

	private EntityManager entityManager;
	
	
	public void crear(Color entidad) throws RedMetroException {
		
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

	
	public void borrar(Color entidad) throws RedMetroException {
		
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

	
	public void actualizar(Color entidad) throws RedMetroException {
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

	
	public Color getEntirdadPorID(int idEntidad) throws RedMetroException {
		Color color = null;
		try {
			entityManager=GestorEntityManagerJPA.getEntityManager();
			
			color = entityManager.find(Color.class, idEntidad);
			
		}catch (NoResultException e) {
			color = null;
		}catch(PersistenceException e){
			throw new RedMetroException(RedMetroException.ERROR_CONSULTA, e);
		}finally {
			if (entityManager!=null)
        		entityManager.close();
		}
		
		return color;
	}

	
	public List<Color> getListaEntidades() throws RedMetroException {
		
		List<Color> color = null;
		try {
			entityManager=GestorEntityManagerJPA.getEntityManager();
			
			String sentenciaJPQL="SELECT color FROM Color color";
			
			TypedQuery<Color> query =entityManager.createQuery(sentenciaJPQL, Color.class);
			
		}catch (NoResultException e) {
			color = null;
		}catch(HibernateException e){
			throw new RedMetroException(RedMetroException.ERROR_CONSULTA, e);
		}finally {
        	if (entityManager!=null)
        		entityManager.close();
		}
		
		return color;
	}

}
