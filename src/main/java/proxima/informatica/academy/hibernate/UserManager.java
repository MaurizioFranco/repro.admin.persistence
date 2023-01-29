/**
 *
 */
package proxima.informatica.academy.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import proxima.informatica.academy.dto.RoleDto;
import proxima.informatica.academy.dto.SurveyDto;
import proxima.informatica.academy.dto.SurveyrepliesDto;
import proxima.informatica.academy.dto.UserDto;

/**
 * 
 * Provides all db operation for users table
 * 
 * @author maurizio.franco@ymail.com
 *
 */
public class UserManager extends AbstractDBManager {

	private final static Logger logger = LoggerFactory.getLogger(UserManager.class);
	private static final int ROLE_ADMIN_NUMBER = 0;

	public static void delete(UserDto survey) {

		logger.debug("UserDto.insert - START - survey: " + survey);
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
		logger.debug("UserDto.delete - END");

	}

	public static List<UserDto> selectAll() {
		logger.debug("UserDto.selectAll - START");
		List<UserDto> list = new ArrayList<UserDto>();
		try {
			Session session = DBManager.getSessionFactory().openSession();
			Query<UserDto> query = session.createQuery("SELECT qst FROM " + UserDto.class.getSimpleName() + " qst");
			list = query.getResultList();
			session.close();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		logger.debug("UserDto.selectAll - END - items.size(): " + list.size());
		return list;
	}

	public static boolean deleteAll() {
		return deleteAll(UserDto.class);
	}

	public static UserDto selectById(int id) {
		return (UserDto) selectById(id, UserDto.class);
	}

	public static boolean update(UserDto userToUpdate) {
		boolean result = false;
		UserDto updateUser = (UserDto) AbstractDBManager.update(userToUpdate);
		if (updateUser != null)
			result = true;
		return result;
	}

	public static UserDto findByEmail(String email) {
		logger.info("findByEmail - START - with email: " + email);
		Session session = DBManager.getSessionFactory().openSession();
		UserDto entity = null;
		try {
			String hql = "SELECT obj FROM " + UserDto.class.getSimpleName() + " obj WHERE email = '" + email + "'";
			Query<UserDto> query = session.createQuery(hql);
			List results = query.list();
			logger.info("findByEmail - DEBUG - results.size(): " + results.size());
			if (results.size() > 0) {
				entity = (UserDto) results.get(0);
			} else {
				entity = null;
			}
			logger.info("findByEmail - DEBUG - entity: " + entity);
		} catch (Exception e) {
			e.printStackTrace();
			entity = null;
			logger.error("Error: " + e, e);
		} finally {
			try {
				session.close();
			} catch (Exception e) {
				e.printStackTrace();
				logger.error("Error: " + e, e);
			}
		}
		return entity;
	}
	
	public static List<UserDto> findByRole() {
		logger.info("findByRole - START - with role: " + ROLE_ADMIN_NUMBER);
		Session session = DBManager.getSessionFactory().openSession();
		List<UserDto> entityList = null;
		try {
			String hql = "SELECT obj FROM " + UserDto.class.getSimpleName() + " obj WHERE role = '" + ROLE_ADMIN_NUMBER + "'";
			Query<UserDto> query = session.createQuery(hql);
			entityList = query.list();
			logger.info("findByRole - DEBUG - results.size(): " + entityList.size());
		} catch (Exception e) {
			e.printStackTrace();
			entityList = null;
			logger.error("Error: " + e, e);
		} finally {
			try {
				session.close();
			} catch (Exception e) {
				e.printStackTrace();
				logger.error("Error: " + e, e);
			}
		}
		return entityList;
	}

}
