/**
 *
 */
package proxima.informatica.academy.hibernate;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import proxima.informatica.academy.dto.RoleDto;
import proxima.informatica.academy.dto.UserDto;

/**
 * 
 * Provides all db operation for users table
 * 
 * @author maurizio.franco@ymail.com
 *
 */
public class UserManager {
	
	private final static Logger logger = LoggerFactory.getLogger(UserManager.class);
	
	public int insert (UserDto item) {
		logger.debug("UserManager.insert - START - item: " + item);
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
		logger.debug("UserManager.insert - END - id_inserted_value: " + id_inserted_value);
        return id_inserted_value ;
	}
	
	public static boolean deleteAll () {
		logger.debug("UserManager.deleteAll - START");
		boolean returnFalse = false ;
		try {
			Session session = DBManager.getSessionFactory().openSession();
			session.beginTransaction();
		    Query<UserDto> query = session.createQuery("delete from " + UserDto.class.getSimpleName());
		    query.executeUpdate();
			session.getTransaction().commit();
			session.close();	
			returnFalse = true ;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			returnFalse = false ;
		}
		logger.debug("UserManager.deleteAll - END");   
		return returnFalse ;
	}

}
