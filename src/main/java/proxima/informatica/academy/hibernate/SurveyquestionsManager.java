package proxima.informatica.academy.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import proxima.informatica.academy.dto.SurveyquestionsDto;


public class SurveyquestionsManager {
	
	private final static Logger logger = LoggerFactory.getLogger(SurveyquestionsManager.class);
	
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
	
	public static boolean deleteAll () {
		logger.debug("SurveyquestionsManager.deleteAll - START");
		boolean returnFalse = false ;
		try {
			Session session = DBManager.getSessionFactory().openSession();
			session.beginTransaction();
		    Query<SurveyquestionsDto> query = session.createQuery("delete from " + SurveyquestionsDto.class.getSimpleName());
		    query.executeUpdate();
			session.getTransaction().commit();
			session.close();	
			returnFalse = true ;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			returnFalse = false ;
		}
		logger.debug("SurveyquestionsManager.deleteAll - END");   
		return returnFalse ;
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
	
	public static SurveyquestionsDto selectById (int id) {
		logger.debug("SurveyquestionsManager.selectById - START - id: " + id);
		SurveyquestionsDto item = null ;
		try {
			Session session = DBManager.getSessionFactory().openSession();
			session.beginTransaction();
            item = session.get(SurveyquestionsDto.class, id);
			session.getTransaction().commit();
			session.close();			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		logger.debug("SurveyquestionsManager.selectById - END - item: " + item);
		return item ;
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