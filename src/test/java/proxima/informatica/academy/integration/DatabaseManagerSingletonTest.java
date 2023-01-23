package proxima.informatica.academy.integration;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.Test;

import proxima.informatica.academy.DatabaseManagerSingleton;
import proxima.informatica.academy.dto.RoleDto;
import proxima.informatica.academy.dto.UserDto;

/**
 * @author Giammarco Lucchetti
 */
public class DatabaseManagerSingletonTest 
{ 
//    @Test
//    public void selectAllFromDatabase() throws ClassNotFoundException, ParseException, IOException, SQLException
//    {
//        assertTrue(DatabaseManagerSingleton.getInstance().selectAll().size() == 2 );
//    
//    }
//    @Test
//    public void testGetUserOk() throws ClassNotFoundException, IOException, SQLException
//    {
//    	assertTrue(DatabaseManagerSingleton.getInstance().selectByIdEmail("1@2.3","abc") != null);
//    }
//    
//    @Test
//    public void testGetUserKo() throws ClassNotFoundException, IOException, SQLException
//    {
//    	assertTrue(DatabaseManagerSingleton.getInstance().selectByIdEmail("a@ciao","aaa") == null);
//    }
    
    @Test
    public void insertOk() throws ClassNotFoundException, SQLException, IOException
    {
//    	UserDto user = new UserDto();
//    	user.setEmail("giammarco.lucchetti@hotmail.it");
//    	user.setPassword("ciao");;
//    	user.setFirstName("Giammarco");
//    	user.setLastName("Lucchetti");
//    	user.setDateOfBirth(Date.valueOf(LocalDate.now()));
//    	user.setRegDate(Timestamp.valueOf(LocalDateTime.now()));
//    	user.setRole(10);
//        assertTrue(DatabaseManagerSingleton.getInstance().insert(user)>0);
    }
    
    @Test
    public void insertKo()
    {
    	//UserDto user = new UserDto();
    	//assertTrue(DatabaseManagerSingleton.getInstance().insert(user) == 0);
    }
    
    @Test
    public void deleteAllOk()
    {
    	//assertTrue(DatabaseManagerSingleton.getInstance().deleteAll() > 0 );
    }
    
    @Test
    public void deleteAllKo()
    {
    	//assertTrue(DatabaseManagerSingleton.getInstance().deleteAll() == 0 );
    }
    
    @Test
    public void selectAllOk()
    {
    	//assertTrue(DatabaseManagerSingleton.getInstance().selectAll().size() == 2 );
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
    
    @Test
    public void updateOk()
    {
    	UserDto user = new UserDto();
    	user.setEmail("giammarco21@hotmail.it");
    	user.setPassword("eccolo22");
    	user.setFirstName("Giammarcomodificato22");
    	user.setLastName("Lucchettimodificato22");
    	user.setDateOfBirth(Date.valueOf(LocalDate.now()));
    	user.setRegDate(Timestamp.valueOf(LocalDateTime.now()));
    	user.setRole(10);
    	user.setImgPath("imgpath");
    	user.setNote("note");
    	user.setEnabled(false);
    	DatabaseManagerSingleton.getInstance().updateUser(7,user);
    	assertTrue(DatabaseManagerSingleton.getInstance().selectByEmail("giammarco21@hotmail.it") != null);
    }
    
//    @Test
//    public void updateKo()
//    {
//    	UserDto user = new UserDto();
//    	user.setEmail("giammarco21@hotmail.it");
//    	user.setPassword("eccolo22");
//    	user.setFirstName("Giammarcomodificato22");
//    	user.setLastName("Lucchettimodificato22");
//    	user.setDateOfBirth(Date.valueOf(LocalDate.now()));
//    	user.setRegDate(Timestamp.valueOf(LocalDateTime.now()));
//    	user.setRole(1);
//    	user.setImgPath("imgpath");
//    	user.setNote("note");
//    	user.setEnabled(false);
//    	assertFalse(DatabaseManagerSingleton.getInstance().update(7,user)>0 );
//    }
    
//    @Test
//    public void insertRole() {
//    	RoleDto role = new RoleDto();
//    	role.setLabel("label1");
//    	role.setDescription("description1");
//    	role.setLevel(1);
//        assertTrue(DatabaseManagerSingleton.getInstance().insertRole(role)>0);
//    }
}
