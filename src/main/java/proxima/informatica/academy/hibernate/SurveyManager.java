package proxima.informatica.academy.hibernate;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import proxima.informatica.academy.dto.SurveyDto;

/**
 * 
 * Provides all db operation for survey table
 * 
 * @author matteo.peruzza@gmail.com
 *
 */

public class SurveyManager {

	private final static Logger logger = LoggerFactory.getLogger(SurveyManager.class);
	
	@SuppressWarnings("deprecation")
	public static int insert (SurveyDto survey) {
		
		logger.debug("SurveyManager.insert - START - survey: " + survey);
		int id_inserted_value = 0;
		try {
			Session session = DBManager.getSessionFactory().openSession();
			session.beginTransaction();
			Object generatedIdentifier = session.save(survey);
			id_inserted_value = ((Integer)generatedIdentifier).intValue();
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {	
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}
		logger.debug("SurveyManager.insert - END - id_inserte_value: " + id_inserted_value);
		return id_inserted_value;
		
	}
	
}
