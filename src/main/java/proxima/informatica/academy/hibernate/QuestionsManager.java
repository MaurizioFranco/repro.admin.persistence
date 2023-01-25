package proxima.informatica.academy.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import proxima.informatica.academy.dto.QuestionsDto;
import proxima.informatica.academy.dto.RoleDto;

public class QuestionsManager {

	private final static Logger logger = LoggerFactory.getLogger(QuestionsManager.class);

	public static int insert(QuestionsDto item) {
		logger.debug("QuestionsDto.insert - START - item: " + item);
		int id_inserted_value = 0;
		try {
			System.out.println("all'interno del try");
			System.out.println("Item: " + item.toString());
			Session session = DBManager.getSessionFactory().openSession();
			System.out.println("aperta session");
			session.beginTransaction();
			System.out.println("inizializzata session");
			Object generatedIdentifier = session.save(item);
			System.out.println("Gen Id trovato");
			id_inserted_value = ((Integer) generatedIdentifier).intValue();
			System.out.println("ID ritornato: " + id_inserted_value);
			System.out.println("Questions: " + item.toString());
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
//		logger.debug("QuestionsDto.insert - END - id_inserted_value: " + id_inserted_value);
		System.out.println("ID ritornato: " + id_inserted_value);
		return id_inserted_value;
	}
	
	public static QuestionsDto selectById(int id) {
		logger.debug("QuestionsManager.delete - START - id: " + id);
		QuestionsDto item = null ;
		try {
			Session session = DBManager.getSessionFactory().openSession();
//			session.beginTransaction();
            item = session.get(QuestionsDto.class, id);
//			session.getTransaction().commit();
			session.close();			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		logger.debug("QuestionsDto.selectById - END - item: " + item);
		return item ;
	}
	
	public static boolean deleteById(int id) {
		logger.debug("QuestionsDto.delete - START - id: " + id);
		boolean val = false;
		QuestionsDto question = null;
		try {
			question = QuestionsManager.selectById(id);
			Session session = DBManager.getSessionFactory().openSession();
			session.beginTransaction();
			session.delete(question);			
			session.getTransaction().commit();
			session.close();	
			val = true;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		logger.debug("QuestionsDto.delete - END");        
		return val;
	}
	
	public static boolean deleteAll () {
		logger.debug("RoleManager.deleteAll - START");
		boolean returnValue = false ;
		try {
			Session session = DBManager.getSessionFactory().openSession();
			session.beginTransaction();
		    Query query = session.createQuery("delete from " + QuestionsDto.class.getSimpleName());
		    query.executeUpdate();
			session.getTransaction().commit();
			session.close();	
			returnValue = true ;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			returnValue = false ;
		}
		logger.debug("RoleManager.deleteAll - END");   
		return returnValue ;
	}
	
	public static List<QuestionsDto> selectAll () {
		logger.debug("QuestionsDto.selectAll - START");
		List<QuestionsDto> list = new ArrayList<QuestionsDto> () ;
		try {
			Session session = DBManager.getSessionFactory().openSession();
//			session.beginTransaction();
			Query<QuestionsDto> query = session.createQuery("SELECT qst FROM " + QuestionsDto.class.getSimpleName() + " qst");
			list = query.getResultList();
//			session.getTransaction().commit();
			session.close();			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		logger.debug("QuestionsDto.selectAll - END - items.size(): " + list.size());
		return list ;
	}
}
