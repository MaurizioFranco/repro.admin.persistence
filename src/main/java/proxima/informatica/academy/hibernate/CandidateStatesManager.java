package proxima.informatica.academy.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import proxima.informatica.academy.dto.CandidateStatesDto;

public class CandidateStatesManager {
		
		private final static Logger logger = LoggerFactory.getLogger(CandidateStatesManager.class);
		
		public static int insert (CandidateStatesDto item) {
			logger.debug("UserManager.insert - START - item: " + item);
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
			logger.debug("UserManager.insert - END - id_inserted_value: " + id_inserted_value);
	        return id_inserted_value ;
		}
		
		public static List<CandidateStatesDto> selectAll () {
			logger.debug("CandaidateStatesManager.selectAll - START");
			List<CandidateStatesDto> list = new ArrayList<CandidateStatesDto> () ;
			try {
				Session session = DBManager.getSessionFactory().openSession();
//				session.beginTransaction();
				Query<CandidateStatesDto> query = session.createQuery("SELECT qst FROM " + CandidateStatesDto.class.getSimpleName() + " qst");
				list = query.getResultList();
//				session.getTransaction().commit();
				session.close();			
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
			logger.debug("CandidateStatesManager.selectAll - END - items.size(): " + list.size());
			return list ;
		}
		
		public static CandidateStatesDto selectById (int id) {
			logger.debug("CandidateStatesManager.selectById - START - id: " + id);
			CandidateStatesDto item = null ;
			try {
				Session session = DBManager.getSessionFactory().openSession();
//				session.beginTransaction();
	            item = session.get(CandidateStatesDto.class, id);
//				session.getTransaction().commit();
				session.close();			
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
			logger.debug("CandidateStatesManager.selectById - END - item: " + item);
			return item ;
		}
		
		public static boolean deleteAll () {
			logger.debug("CandidateStatesManager.deleteAll - START");
			boolean returnFalse = false ;
			try {
				Session session = DBManager.getSessionFactory().openSession();
				session.beginTransaction();
			    Query<CandidateStatesDto> query = session.createQuery("delete from " + CandidateStatesDto.class.getSimpleName());
			    query.executeUpdate();
				session.getTransaction().commit();
				session.close();	
				returnFalse = true ;
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				returnFalse = false ;
			}
			logger.debug("CandidateStatesManager.deleteAll - END");   
			return returnFalse ;
		}
		
		public static void delete (CandidateStatesDto item) {
			logger.debug("CandidateStatesManager.delete - START - item: " + item);
			try {
				Session session = DBManager.getSessionFactory().openSession();
				session.beginTransaction();
				session.delete(item);			
				session.getTransaction().commit();
				session.close();			
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
			logger.debug("CandidateStatesManager.delete - END");        
		}

	}
