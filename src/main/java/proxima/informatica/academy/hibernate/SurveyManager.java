package proxima.informatica.academy.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import proxima.informatica.academy.dto.AbstractCommonDto;
import proxima.informatica.academy.dto.SurveyDto;

/**
 * 
 * Provides all db operation for survey table
 * 
 * @author matteo.peruzza@gmail.com
 *
 */

public class SurveyManager extends AbstractDBManager {

	private final static Logger logger = LoggerFactory.getLogger(SurveyManager.class);
	
	
	
	public static void delete (SurveyDto survey) {
		
		logger.debug("SurveyManager.insert - START - survey: " + survey);
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
		logger.debug("SurveyManager.delete - END");
		
	}
	
	public static List<SurveyDto> selectAll () {
	
		logger.debug("SurveyManager.selectAll - START");
		List<SurveyDto> surveys = new ArrayList<SurveyDto> ();
		try {
			Session session = DBManager.getSessionFactory().openSession();
			session.beginTransaction();
			Query<SurveyDto> query = session.createQuery("SELECT qst FROM " + SurveyDto.class.getSimpleName() + " qst");
			surveys = query.getResultList();
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		logger.debug("SurveyManager.selectAll - END surveys.size(): " + surveys.size());
		return surveys;
		
	}
	
    public static boolean deleteAll () {		
		return deleteAll(SurveyDto.class) ;		
	}
    
    public static SurveyDto selectById (int id) {
    	return (SurveyDto)selectById (id, SurveyDto.class);
    }
	
	public static SurveyDto update (SurveyDto survey) {
		logger.debug("SurveyManager.update - START - survey: " + survey);
		AbstractCommonDto returnValue = AbstractDBManager.update(survey);
		if (returnValue != null) {
			return (SurveyDto)returnValue;
		}
		return null ;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
