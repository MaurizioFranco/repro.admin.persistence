/**
 *
 */
package proxima.informatica.academy.hibernate;

import org.hibernate.Session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import proxima.informatica.academy.dto.CandidatesDto;

/**
 * 
 * Provides all db operation for roles table
 * 
 * @author AntoIannaccone
 *
 */
public class CandidatesManager {
	
	private final static Logger logger = LoggerFactory.getLogger(CandidatesManager.class);
	
	public static int insert (CandidatesDto item) {
		logger.debug("CandidatesManager.insert - START - item: " + item);
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
		logger.debug("CandidatesManager.insert - END - id_inserted_value: " + id_inserted_value);
        return id_inserted_value ;
	}

}
