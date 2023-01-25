/**
 *
 */
package proxima.informatica.academy.hibernate;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
	
	public int insert (SurveyrepliesDto item) {
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

}
