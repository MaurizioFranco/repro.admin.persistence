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

import proxima.informatica.academy.dto.CoursePageDto;

/**
 * 
 * Provides all db operation for course_page table
 * 
 * @author maurizio.franco@ymail.com
 *
 */
public class CoursePageManager {
	
	private final static Logger logger = LoggerFactory.getLogger(CoursePageManager.class);
	
	public static int insert (CoursePageDto item) {
		logger.debug("CoursePageManager.insert - START - item: " + item);
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
		logger.debug("CoursePageManager.insert - END - id_inserted_value: " + id_inserted_value);
        return id_inserted_value ;
	}
	
	public static void delete (CoursePageDto item) {
		logger.debug("CoursePageManager.delete - START - item: " + item);
		try {
			Session session = DBManager.getSessionFactory().openSession();
			session.beginTransaction();
			session.delete(item);			
			session.getTransaction().commit();
			session.close();			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		logger.debug("CoursePageManager.delete - END");        
	}
	
	public static CoursePageDto selectById (int id) {
		logger.debug("CoursePageManager.selectById - START - id: " + id);
		CoursePageDto item = null ;
		try {
			Session session = DBManager.getSessionFactory().openSession();
//			session.beginTransaction();
            item = session.get(CoursePageDto.class, id);
//			session.getTransaction().commit();
			session.close();			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		logger.debug("CoursePageManager.selectById - END - item: " + item);
		return item ;
	}
	
	public static boolean deleteAll () {
		logger.debug("CoursePageManager.deleteAll - START");
		boolean returnFalse = false ;
		try {
			Session session = DBManager.getSessionFactory().openSession();
			session.beginTransaction();
		    Query<CoursePageDto> query = session.createQuery("delete from " + CoursePageDto.class.getSimpleName());
		    query.executeUpdate();
			session.getTransaction().commit();
			session.close();	
			returnFalse = true ;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			returnFalse = false ;
		}
		logger.debug("CoursePageManager.deleteAll - END");   
		return returnFalse ;
	}
	
	public static List<CoursePageDto> selectAll () {
		logger.debug("CoursePageManager.selectAll - START");
		List<CoursePageDto> list = new ArrayList<CoursePageDto> () ;
		try {
			Session session = DBManager.getSessionFactory().openSession();
//			session.beginTransaction();
			Query<CoursePageDto> query = session.createQuery("SELECT qst FROM " + CoursePageDto.class.getSimpleName() + " qst");
			list = query.getResultList();
//			session.getTransaction().commit();
			session.close();			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		logger.debug("CoursePageManager.selectAll - END - items.size(): " + list.size());
		return list ;
	}
	
	

}
