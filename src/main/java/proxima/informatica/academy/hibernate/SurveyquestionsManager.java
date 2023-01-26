package proxima.informatica.academy.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import proxima.informatica.academy.dto.SurveyquestionsDto;

/**
 * 
 * @author Giacomo Della Luna
 *
 */
public class SurveyquestionsManager extends AbstractDBManager{
	
	private final static Logger logger = LoggerFactory.getLogger(SurveyquestionsManager.class);
	
	public static boolean deleteAll () {
		return deleteAll(SurveyquestionsManager.class);
	}
	
    public static SurveyquestionsDto selectById (int id) {
    	return (SurveyquestionsDto) selectById (id, SurveyquestionsDto.class);
    }
	

	public static int insert (SurveyquestionsDto item) {
		logger.debug("SurveyquestionsManager.insert - START - item: " + item);
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
		logger.debug("SurveyquestionsManager.insert - END - id_inserted_value: " + id_inserted_value);
        return id_inserted_value ;
	}
	
	
	
	public static void delete(SurveyquestionsDto item) {
		logger.debug("SurveyquestionsManager.delete - START - item: " + item);
		try {
			Session session = DBManager.getSessionFactory().openSession();
			session.beginTransaction();
			session.delete(item);
			session.getTransaction().commit();
			session.close();
		} catch(Exception e) {
			logger.error(e.getMessage(), e);
		}
		logger.debug("SurveyquestionsManager.delete - END");
	}
	
	public static List<SurveyquestionsDto> selectAll () {
		logger.debug("SurveyquestionsManager.selectAll - START");
		List<SurveyquestionsDto> list = new ArrayList<SurveyquestionsDto> () ;
		try {
			Session session = DBManager.getSessionFactory().openSession();
//			session.beginTransaction();
			Query<SurveyquestionsDto> query = session.createQuery("SELECT qst FROM " + SurveyquestionsDto.class.getSimpleName() + " qst");
			list = query.getResultList();
//			session.getTransaction().commit();
			session.close();			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		logger.debug("SurveyquestionsManager.selectAll - END - items.size(): " + list.size());
		return list ;
	}

}