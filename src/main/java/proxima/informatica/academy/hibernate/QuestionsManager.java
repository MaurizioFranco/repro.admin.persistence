package proxima.informatica.academy.hibernate;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import proxima.informatica.academy.dto.QuestionsDto;

public class QuestionsManager {

	private final static Logger logger = LoggerFactory.getLogger(RoleManager.class);

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
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
//		logger.debug("QuestionsDto.insert - END - id_inserted_value: " + id_inserted_value);
		System.out.println("ID ritornato: " + id_inserted_value);
		return id_inserted_value;
	}
}
