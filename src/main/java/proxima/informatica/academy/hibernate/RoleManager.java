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

import proxima.informatica.academy.dto.RoleDto;
import proxima.informatica.academy.dto.SurveyDto;

/**
 * 
 * Provides all db operation for roles table
 * 
 * @author maurizio.franco@ymail.com
 *
 */
public class RoleManager extends AbstractDBManager {
	
	private final static Logger logger = LoggerFactory.getLogger(RoleManager.class);	
	
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
	
	public static List<RoleDto> selectAll () {
		logger.debug("RoleManager.selectAll - START");
		List<RoleDto> list = new ArrayList<RoleDto> () ;
		try {
			Session session = DBManager.getSessionFactory().openSession();
//			session.beginTransaction();
			Query<RoleDto> query = session.createQuery("SELECT qst FROM " + RoleDto.class.getSimpleName() + " qst");
			list = query.getResultList();
//			session.getTransaction().commit();
			session.close();			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		logger.debug("RoleManager.selectAll - END - items.size(): " + list.size());
		return list ;
	}
	
	public static boolean deleteAll () {		
		return deleteAll(RoleDto.class) ;		
	}
	
	

}
