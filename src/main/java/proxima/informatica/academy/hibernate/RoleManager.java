/**
 *
 */
package proxima.informatica.academy.hibernate;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import proxima.informatica.academy.dto.RoleDto;

/**
 * 
 * Provides all db operation for roles table
 * 
 * @author maurizio.franco@ymail.com
 *
 */
public class RoleManager {
	
	private final static Logger logger = LoggerFactory.getLogger(RoleManager.class);
	
	public static int insert (RoleDto item) {
		logger.debug("RoleManager.insert - START - item: " + item);
		int id_inserted_value = 0 ;
		try {
			Session session = DBManager.getSessionFactory().openSession();
			session.beginTransaction();
			Object generatedIdentifier = session.save(item);
			id_inserted_value = ((Integer)generatedIdentifier).intValue();
			session.getTransaction().commit();
			session.close();			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		logger.debug("RoleManager.insert - END - id_inserted_value: " + id_inserted_value);
        return id_inserted_value ;
	}
	
	public static void delete (RoleDto item) {
		logger.debug("RoleManager.delete - START - item: " + item);
		try {
			Session session = DBManager.getSessionFactory().openSession();
			session.beginTransaction();
			session.delete(item);			
			session.getTransaction().commit();
			session.close();			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		logger.debug("RoleManager.delete - END");        
	}
	
	public static RoleDto selectById (int id) {
		logger.debug("RoleManager.selectById - START - id: " + id);
		RoleDto item = null ;
		try {
			Session session = DBManager.getSessionFactory().openSession();
//			session.beginTransaction();
            item = session.get(RoleDto.class, id);
//			session.getTransaction().commit();
			session.close();			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		logger.debug("RoleManager.selectById - END - item: " + item);
		return item ;
	}
	
	public static boolean deleteAll () {
		logger.debug("RoleManager.deleteAll - START");
		boolean returnFalse = false ;
		try {
			Session session = DBManager.getSessionFactory().openSession();
			session.beginTransaction();
		    Query query = session.createQuery("delete from " + RoleDto.class.getSimpleName());
		    query.executeUpdate();
			session.getTransaction().commit();
			session.close();	
			returnFalse = true ;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			returnFalse = false ;
		}
		logger.debug("RoleManager.deleteAll - END");   
		return returnFalse ;
	}
	
	

}
