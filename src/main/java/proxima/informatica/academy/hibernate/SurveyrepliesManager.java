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
import proxima.informatica.academy.dto.SurveyrepliesDto;
import proxima.informatica.academy.dto.UserDto;

/**
 * 
 * Provides all db operation for users table
 * 
 * @author maurizio.franco@ymail.com
 *
 */
public class SurveyrepliesManager extends AbstractDBManager{
	
	private final static Logger logger = LoggerFactory.getLogger(SurveyrepliesManager.class);
	
	public static void delete (SurveyrepliesDto item) {
		logger.debug("SurveyrepliesDto.delete - START - item: " + item);
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
	
    public static boolean deleteAll () {		
		return deleteAll(SurveyrepliesDto.class) ;		
	}
    
    public static SurveyrepliesDto selectById (int id) {
    	return (SurveyrepliesDto)selectById (id, SurveyrepliesDto.class);
    }
}
