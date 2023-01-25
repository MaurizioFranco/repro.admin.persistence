/**
 * 
 */
package proxima.informatica.academy.hibernate;

import static org.junit.Assert.assertTrue;

import org.hibernate.Session;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import proxima.informatica.academy.dto.RoleDto;

/**
 * @author maurizio
 *
 */
public class RoleDBManagerTest {
	
	private final static Logger logger = LoggerFactory.getLogger(RoleDBManagerTest.class);
	
	@Test
	public void testInsertOk() {
		System.out.println("#########");
		System.out.println("TEST INSERT");
		System.out.println("#########");
		RoleDto role = new RoleDto();
		role.setLabel("testLabel");
		role.setLevel(10001);
		role.setDescription("TEST DESCRIPTION");
    	
    	
    	int id_inserted_value = RoleManager.insert(role);
		logger.debug("@Test --> inserted: " + id_inserted_value);
        assertTrue( id_inserted_value>0 );
        System.out.println("#########");
		System.out.println("TEST INSERT");
		System.out.println("#########");
	}
	
	@Test
	public void testDeleteAll() {
		System.out.println("#########");
		System.out.println("TEST DELETE ALL - START");
		System.out.println("#########");
		boolean returnValue = RoleManager.deleteAll();
		logger.debug("@Test --> returnValue: " + returnValue);
        assertTrue( returnValue );
        System.out.println("#########");
		System.out.println("TEST DELETE ALL - END");
		System.out.println("#########");
	}
	
	@Test
	public void testSelectAllEmpty() {
		System.out.println("#########");
		System.out.println("TEST SELECT ALL EMPTY- START");
		System.out.println("#########");
		boolean returnValue = RoleManager.deleteAll();
		logger.debug("@Test --> returnValue: " + returnValue);
        assertTrue( returnValue );
        int selectAllSize = RoleManager.selectAll().size();
		logger.debug("@Test --> selectAllSize: " + selectAllSize);
        assertTrue( selectAllSize==0 );
        System.out.println("#########");
        System.out.println("TEST SELECT ALL EMPTY- END");
		System.out.println("#########");
	}
	
	@Test
	public void testSelectAllForOne() {
		System.out.println("#########");
		System.out.println("TEST SELECT ALL FOR ONE - START");
		System.out.println("#########");
		boolean returnValue = RoleManager.deleteAll();
		logger.debug("@Test --> returnValue: " + returnValue);
        assertTrue( returnValue );
        int selectAllSize = RoleManager.selectAll().size();
		logger.debug("@Test --> selectAllSize: " + selectAllSize);
        assertTrue( selectAllSize==0 );
        RoleDto role = new RoleDto();
		role.setLabel("testLabel");
		role.setLevel(10001);
		role.setDescription("TEST DESCRIPTION");
    	int id_inserted_value = RoleManager.insert(role);
		logger.debug("@Test --> inserted: " + id_inserted_value);
        assertTrue( id_inserted_value>0 );        
        selectAllSize = RoleManager.selectAll().size();
		logger.debug("@Test --> selectAllSize: " + selectAllSize);
        assertTrue( selectAllSize==1 );
        System.out.println("#########");
        System.out.println("TEST SELECT ALL FOR ONE - END");
		System.out.println("#########");
	}
	
}
