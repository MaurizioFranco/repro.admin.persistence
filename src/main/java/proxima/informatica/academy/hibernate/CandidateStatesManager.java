package proxima.informatica.academy.hibernate;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import proxima.informatica.academy.dto.CandidateStatesDto;
import proxima.informatica.academy.dto.UserDto;

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

	}
