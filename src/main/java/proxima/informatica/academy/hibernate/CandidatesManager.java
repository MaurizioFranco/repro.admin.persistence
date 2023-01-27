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

import proxima.informatica.academy.dto.AbstractCommonDto;
import proxima.informatica.academy.dto.CandidatesDto;

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
	
	public static CandidatesDto selectById (int id) {
		logger.debug("CandidatesManager.selectById - START - id: " + id);
		CandidatesDto item = null ;
		try {
			Session session = DBManager.getSessionFactory().openSession();
			session.beginTransaction();
            item = session.get(CandidatesDto.class, id);
			session.getTransaction().commit();
			session.close();			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		logger.debug("CandidatesManager.selectById - END - item: " + item);
		return item ;
	}
	
	public static boolean deleteAll () {
		logger.debug("CandidatesManager.deleteAll - START");
		boolean returnFalse = false ;
		try {
			Session session = DBManager.getSessionFactory().openSession();
			session.beginTransaction();
		    Query<CandidatesDto> query = session.createQuery("delete from " + CandidatesDto.class.getSimpleName());
		    query.executeUpdate();
			session.getTransaction().commit();
			session.close();	
			returnFalse = true ;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			returnFalse = false ;
		}
		logger.debug("CandidatesManager.deleteAll - END");   
		return returnFalse ;
	}
	
	public static List<AbstractCommonDto> selectAll () {
		
		return selectAll(CandidatesDto.class);
	}

}
