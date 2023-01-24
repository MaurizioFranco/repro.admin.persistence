package proxima.informatica.academy.integration;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.Test;

import proxima.informatica.academy.DatabaseManagerSingleton;
import proxima.informatica.academy.dto.UserDto;

/**
 * @author Giammarco Lucchetti
 * @author Giacomo 
 * @author maurizio.franco@ymail.com
 */
public class DatabaseManagerSingletonTest 
{ 
//    @Test
//    public void selectAllFromDatabase() throws ClassNotFoundException, ParseException, IOException, SQLException
//    {
//        assertTrue(DatabaseManagerSingleton.getInstance().selectAll().size() == 2 );
//    
//    }
    @Test
    public void testGetUserOk() throws ClassNotFoundException, IOException, SQLException
    {
    	assertTrue(DatabaseManagerSingleton.getInstance().selectByEmail("1@2.3","abc") != null);
    }
    
    @Test
    public void testGetUserKo() throws ClassNotFoundException, IOException, SQLException
    {
    	assertTrue(DatabaseManagerSingleton.getInstance().selectByEmail("a@ciao","aaa") == null);
    }
    
    /**
     * Test the user insert
     * @author Giammarco Lucchetti
     */
    @Test
    public void insertOk() throws ClassNotFoundException, SQLException, IOException
    {
    	DatabaseManagerSingleton.getInstance().deleteAllUsers();
    	UserDto user = new UserDto();
    	user.setEmail("giammarco.lucchetti@hotmail.it");
    	user.setPassword("ciao");
    	user.setFirstName("Giammarco");
    	user.setLastName("Lucchetti");
    	user.setDateOfBirth(Date.valueOf(LocalDate.now()));
    	user.setRegDate(Timestamp.valueOf(LocalDateTime.now()));
    	user.setRole(10);
        assertTrue(DatabaseManagerSingleton.getInstance().insertUser(user)>0);
        assertTrue(DatabaseManagerSingleton.getInstance().selectAllUsers().size()>0);
    }
    
    /**
     * Test the user insert
     * @author Giammarco Lucchetti
     */
    @Test
    public void insertKoByEmailDuplicate()
    {
    	String email = "giammarco.lucchetti@hotmail.it";
    	DatabaseManagerSingleton.getInstance().deleteAllUsers();
    	UserDto user = getUserByTest();
    	assertTrue(DatabaseManagerSingleton.getInstance().insertUser(user)>0);
    	UserDto user2 = new UserDto();
    	user2.setEmail(email);
    	assertTrue(DatabaseManagerSingleton.getInstance().insertUser(user2) == 0);
    }
    
    /**
     * @author Giacomo Della Luna
     * 
     * test deleteAll 
     * check that the database is empty, insert a new user and then delete all
     */
    @Test
    public void deleteAllOk()
    {
    	DatabaseManagerSingleton.getInstance().deleteAllUsers();
    	assertTrue(DatabaseManagerSingleton.getInstance().selectAllUsers().isEmpty());
    	UserDto user = new UserDto();
    	user.setEmail("prova@prova.p");
    	user.setPassword("p");;
    	user.setFirstName("P");
    	user.setLastName("P");
    	user.setDateOfBirth(Date.valueOf(LocalDate.now()));
    	user.setRegDate(Timestamp.valueOf(LocalDateTime.now()));
    	user.setRole(10);
    	assertTrue(DatabaseManagerSingleton.getInstance().insertUser(user) > 0);
    	assertTrue(DatabaseManagerSingleton.getInstance().deleteAllUsers() > 0 );
    	assertTrue(DatabaseManagerSingleton.getInstance().selectAllUsers().isEmpty());

    }
    
    /**
     * @author Giacomo Della Luna
     * 
     * test deleteAll 
     * check that the database is empty, insert a new user then retrive the user id with a select
     * and delete the user
     * 
     */
    @Test
    public void deleteRowUsersOk() {
    	DatabaseManagerSingleton.getInstance().deleteAllUsers();
    	assertTrue(DatabaseManagerSingleton.getInstance().selectAllUsers().isEmpty());
    	UserDto user = new UserDto();
    	user.setEmail("prova@prova.p");
    	user.setPassword("p");;
    	user.setFirstName("P");
    	user.setLastName("P");
    	user.setDateOfBirth(Date.valueOf(LocalDate.now()));
    	user.setRegDate(Timestamp.valueOf(LocalDateTime.now()));
    	user.setRole(10);
    	assertTrue(DatabaseManagerSingleton.getInstance().insertUser(user) > 0);
    	int id = DatabaseManagerSingleton.getInstance().selectByEmail(user.getEmail()).getId();
    	assertTrue(DatabaseManagerSingleton.getInstance().deleteRowUsers(id));
    	assertTrue(DatabaseManagerSingleton.getInstance().selectByUserId(id) == null);    	
    }
    
    @Test
    public void deleteAllKo()
    {
    	//assertTrue(DatabaseManagerSingleton.getInstance().deleteAll() == 0 );
    }
    
    @Test
    public void selectAllOk()
    {
    	assertTrue(DatabaseManagerSingleton.getInstance().selectAllUsers().size() == 0 );
    }
    
    @Test
    public void selectAllKo()
    {
    	//assertFalse(DatabaseManagerSingleton.getInstance().selectAll().size() !=2);
    }
    
    @Test
    public void selectByIdOk()
    {
    	//assertTrue(DatabaseManagerSingleton.getInstance().selectById(1) != null);
    }
    
    @Test
    public void selectByIdKo()
    {
    	//assertFalse(DatabaseManagerSingleton.getInstance().selectById(1) == null);
    }
    
    @Test
    public void selectByEmailOk()
    {
    	//assertTrue(DatabaseManagerSingleton.getInstance().selectByEmail("giammarco.lucchetti@hotmail.it") != null);
    }
    
    @Test
    public void selectByEmailKo()
    {
    	//assertFalse(DatabaseManagerSingleton.getInstance().selectByEmail("giammarco.lucchetti@hotmail.it") == null);
    }
    
    public UserDto getUserByTest(){
    	UserDto user = new UserDto();
    	user.setEmail("giammarco.lucchetti@hotmail.it");
    	user.setPassword("ciao");
    	user.setFirstName("Giammarco");
    	user.setLastName("Lucchetti");
    	user.setDateOfBirth(Date.valueOf(LocalDate.now()));
    	user.setRegDate(Timestamp.valueOf(LocalDateTime.now()));
    	user.setRole(10);
    	return user;
    }
}
