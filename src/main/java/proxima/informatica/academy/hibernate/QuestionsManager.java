package proxima.informatica.academy.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import proxima.informatica.academy.dto.AbstractCommonDto;
import proxima.informatica.academy.dto.QuestionsDto;
import proxima.informatica.academy.dto.RoleDto;

public class QuestionsManager extends AbstractDBManager{

	private final static Logger logger = LoggerFactory.getLogger(QuestionsManager.class);
	
	public static QuestionsDto selectById(int id) {
		return (QuestionsDto) selectById(id, QuestionsDto.class);
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
		return deleteAll(QuestionsDto.class);
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
