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
import proxima.informatica.academy.dto.SurveyrepliesDto;
import proxima.informatica.academy.dto.UserDto;

/**
 * 
 * Provides all db operation for users table
 * 
 * @author maurizio.franco@ymail.com
 *
 */
public class SurveyrepliesManager {
	
	private final static Logger logger = LoggerFactory.getLogger(SurveyrepliesManager.class);
	
	public static int insert (SurveyrepliesDto item) {
		logger.debug("SurveyrepliesDto.insert - START - item: " + item);
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
		logger.debug("SurveyrepliesDto.insert - END - id_inserted_value: " + id_inserted_value);
        return id_inserted_value ;
	}
	
	public static void delete (SurveyrepliesDto item) {
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
		logger.debug("SurveyrepliesDto.delete - END");        
	}
	
	public static SurveyrepliesDto selectById (int id) {
		logger.debug("SurveyrepliesDto.selectById - START - id: " + id);
		SurveyrepliesDto item = null ;
		try {
			Session session = DBManager.getSessionFactory().openSession();
            item = session.get(SurveyrepliesDto.class, id);
			session.close();			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		logger.debug("SurveyrepliesDto.selectById - END - item: " + item);
		return item ;
	}
	
	public static boolean deleteAll () {
		logger.debug("SurveyrepliesDto.deleteAll - START");
		boolean returnFalse = false ;
		try {
			Session session = DBManager.getSessionFactory().openSession();
			session.beginTransaction();
		    Query<SurveyrepliesDto> query = session.createQuery("delete from " + SurveyrepliesDto.class.getSimpleName());
		    query.executeUpdate();
			session.getTransaction().commit();
			session.close();	
			returnFalse = true ;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			returnFalse = false ;
		}
		logger.debug("SurveyrepliesDto.deleteAll - END");   
		return returnFalse ;
	}
	
	public static List<SurveyrepliesDto> selectAll () {
		logger.debug("SurveyrepliesDto.selectAll - START");
		List<SurveyrepliesDto> list = new ArrayList<SurveyrepliesDto> () ;
		try {
			Session session = DBManager.getSessionFactory().openSession();
			Query<SurveyrepliesDto> query = session.createQuery("SELECT qst FROM " + SurveyrepliesDto.class.getSimpleName() + " qst");
			list = query.getResultList();
			session.close();			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		logger.debug("SurveyrepliesDto.selectAll - END - items.size(): " + list.size());
		return list ;
	}

}
