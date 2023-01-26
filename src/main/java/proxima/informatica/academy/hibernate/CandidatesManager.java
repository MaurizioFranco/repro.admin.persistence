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

import proxima.informatica.academy.dto.CandidatesDto;
import proxima.informatica.academy.dto.SurveyDto;

/**
 * 
 * Provides all db operation for roles table
 * 
 * @author AntoIannaccone
 *
 */
public class CandidatesManager extends AbstractDBManager {
	
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
	
	public static void delete (CandidatesDto item) {
		logger.debug("CandidatesManager.delete - START - item: " + item);
		try {
			Session session = DBManager.getSessionFactory().openSession();
			session.beginTransaction();
			session.delete(item);			
			session.getTransaction().commit();
			session.close();			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		logger.debug("CandidatesManager.delete - END");        
	}
	
	public static List<CandidatesDto> selectAll () {
		logger.debug("CandidatesManager.selectAll - START");
		List<CandidatesDto> list = new ArrayList<CandidatesDto> () ;
		try {
			Session session = DBManager.getSessionFactory().openSession();
			session.beginTransaction();
			Query<CandidatesDto> query = session.createQuery("SELECT qst FROM " + CandidatesDto.class.getSimpleName() + " qst");
			list = query.getResultList();
			session.getTransaction().commit();
			session.close();			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		logger.debug("CandidatesManager.selectAll - END - items.size(): " + list.size());
		return list ;
	}
	
	public static boolean deleteAll () {		
		return deleteAll(CandidatesDto.class) ;		
	}
    
    public static CandidatesDto selectById (int id) {
    	return (CandidatesDto)selectById (id, CandidatesDto.class);
    }

}
