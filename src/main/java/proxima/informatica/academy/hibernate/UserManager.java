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
public class UserManager extends AbstractDBManager{
	
	private final static Logger logger = LoggerFactory.getLogger(UserManager.class);
	
	public static void delete (UserDto survey) {
		
		logger.debug("UserDto.insert - START - survey: " + survey);
		try {
			Session session = DBManager.getSessionFactory().openSession();
			session.beginTransaction();
			session.delete(survey);
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {	
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}
		logger.debug("UserDto.delete - END");
		
	}
	
	public static List<UserDto> selectAll () {
		logger.debug("UserDto.selectAll - START");
		List<UserDto> list = new ArrayList<UserDto> () ;
		try {
			Session session = DBManager.getSessionFactory().openSession();
			Query<UserDto> query = session.createQuery("SELECT qst FROM " + UserDto.class.getSimpleName() + " qst");
			list = query.getResultList();
			session.close();			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		logger.debug("UserDto.selectAll - END - items.size(): " + list.size());
		return list ;
	}
	
    public static boolean deleteAll () {		
		return deleteAll(UserDto.class) ;		
	}
    
    public static UserDto selectById (int id) {
    	return (UserDto)selectById (id, UserDto.class);
    }

}
