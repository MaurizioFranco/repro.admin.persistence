package proxima.informatica.academy.hibernate;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import proxima.informatica.academy.dto.SurveyquestionsDto;


public class SurveyquestionsManager {
	
	private final static Logger logger = LoggerFactory.getLogger(SurveyquestionsManager.class);
	
	public static int insert (SurveyquestionsDto item) {
		logger.debug("RoleManager.insert - START - item: " + item);
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
		logger.debug("RoleManager.insert - END - id_inserted_value: " + id_inserted_value);
        return id_inserted_value ;
	}

}