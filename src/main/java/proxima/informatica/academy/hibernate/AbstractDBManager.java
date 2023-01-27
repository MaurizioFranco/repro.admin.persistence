/**
 *
 */
package proxima.informatica.academy.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import proxima.informatica.academy.dto.AbstractCommonDto;

/**
 * @author maurizio.franco@ymail.com
 *
 */
public class AbstractDBManager {
	
	private final static Logger logger = LoggerFactory.getLogger(AbstractDBManager.class);
	
    public static boolean deleteAll (Class entityClass) {		
		logger.debug("AbstractDBManager.deleteAll - START");
		boolean returnFalse = false ;
		try {
			Session session = DBManager.getSessionFactory().openSession();
			session.beginTransaction();
			Query<AbstractCommonDto> query = session.createQuery("delete from " + entityClass.getSimpleName());
			query.executeUpdate();
			session.getTransaction().commit();
			session.close();	
			returnFalse = true ;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			returnFalse = false ;
		}
		logger.debug("AbstractDBManager.deleteAll - END");   
		return returnFalse ;
		
	}
    
    public static int insert (AbstractCommonDto itemToInsert) {
		
		logger.debug("AbstractDBManager.insert - START - itemToInsert: " + itemToInsert);
		int id_inserted_value = 0;
		try {
			Session session = DBManager.getSessionFactory().openSession();
			session.beginTransaction();
			Object generatedIdentifier = session.save(itemToInsert);
			id_inserted_value = ((Integer)generatedIdentifier).intValue();
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {	
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}
		logger.debug("AbstractDBManager.insert - END - id_inserte_value: " + id_inserted_value);
		return id_inserted_value;
		
	}
    
    public static AbstractCommonDto selectById (int id, Class entityClass) {
		
		logger.debug("AbstractDBManager.selectById - START id: " + id);
		AbstractCommonDto itemToReturn = null;
		try {
			Session session = DBManager.getSessionFactory().openSession();
			session.beginTransaction();
			itemToReturn = (AbstractCommonDto)session.get(entityClass, id);
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}
		logger.debug("AbstractDBManager.selectById -END itemToReturn: " + itemToReturn);
		return itemToReturn;
	}
    
    public static List<AbstractCommonDto> selectAll (Class entityClass) {
		logger.debug("AbstractDBManager.selectAll - START");
		List<AbstractCommonDto> list = new ArrayList<AbstractCommonDto> () ;
		try {
			Session session = DBManager.getSessionFactory().openSession();
			session.beginTransaction();
			Query<AbstractCommonDto> query = session.createQuery("SELECT qst FROM " + entityClass.getSimpleName() + " qst");
			list = query.getResultList();
			session.getTransaction().commit();
			session.close();			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		logger.debug("AbstractDBManager.selectAll - END - items.size(): " + list.size());
		return list;
	}

    public static boolean delete(AbstractCommonDto toDelete) {
    	logger.debug("AbstractDBManager.delete - START");
		boolean returnFalse = false ;
		try {
			Session session = DBManager.getSessionFactory().openSession();
			session.beginTransaction();
			session.delete(toDelete);
			session.getTransaction().commit();
			session.close();	
			returnFalse = true ;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			returnFalse = false ;
		}
		logger.debug("AbstractDBManager.delete - END");   
		return returnFalse ;
    }

    public static void deleteById (int id, Class entityClass) {
    	logger.debug("AbstractDBManager.deleteById - START id: " + id);
    	AbstractCommonDto item = selectById(id, entityClass);
    	try {
			Session session = DBManager.getSessionFactory().openSession();
			session.beginTransaction();
			session.delete(item);
			session.getTransaction().commit();
			session.close();	
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
    	logger.debug("AbstractDBManager.deleteById - END");
    }
    	
}
