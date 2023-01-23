package proxima.informatica.academy;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import proxima.informatica.academy.dto.RoleDto;
import proxima.informatica.academy.dto.UserDto;

/**
 * @author Giammarco Lucchetti
 */
public class DatabaseManagerSingleton {

	private static DatabaseManagerSingleton instance;
	private final static Logger logger = LoggerFactory.getLogger(DatabaseManagerSingleton.class);

	private DatabaseManagerSingleton() {
		// logger.debug("Instanziato Costruttore Privato Database Manager Singleton");
	}

	public static DatabaseManagerSingleton getInstance() {
		if (instance == null) {
			instance = new DatabaseManagerSingleton();
		}
		return instance;
	}

	public int insertUser(UserDto messageToInsert) {
		int rowsUpdate = 0;
		try {
			Connection con = getConnection();
			String query = "insert into users(email,firstname,lastname,dateofbirth,regdate,role)"
					+ " values(?,?,?,?,?,?);";
			PreparedStatement pStatement = con.prepareStatement(query);
			pStatement.setString(1, messageToInsert.getEmail());
			pStatement.setString(2, messageToInsert.getFirstName());
			pStatement.setString(3, messageToInsert.getLastName());
			pStatement.setDate(4, messageToInsert.getDateOfBirth());
			pStatement.setTimestamp(5, messageToInsert.getRegDate());
			pStatement.setInt(6, messageToInsert.getRole());
			rowsUpdate = pStatement.executeUpdate();
			con.close();
		} catch (Exception e) {
			//e.printStackTrace();
			logger.error(e.getMessage(),e);
		}
		return rowsUpdate;
	}
	
	public int insertRole(RoleDto messageToInsert) {
		RoleDto user = new RoleDto();
		int rowsUpdate = 0;
		try {
			Connection con = getConnection();
			String query = "insert into roles(label,description,level)"
					+ " values(?,?,?);";
			PreparedStatement pStatement = con.prepareStatement(query);
			pStatement.setString(1, messageToInsert.getLabel());
			pStatement.setString(2, messageToInsert.getDescription());
			pStatement.setInt(3, messageToInsert.getLevel());
			rowsUpdate = pStatement.executeUpdate();
			con.close();
		} catch (Exception e) {
			//e.printStackTrace();
			logger.error(e.getMessage(),e);
		}
		return rowsUpdate;
	}

	public int deleteAllUsers() {
		int row= 0;
		try {
		Connection con = getConnection();
		String query = "DELETE FROM users";
		PreparedStatement pStatement = con.prepareStatement(query);
		row = pStatement.executeUpdate();
		con.close();
		}catch (Exception e) {
			//e.printStackTrace();
			logger.error(e.getMessage(),e);
		}
		return row;
	}
	
	public int deleteAllRoles() {
		int row= 0;
		try {
		Connection con = getConnection();
		String query = "DELETE FROM roles";
		PreparedStatement pStatement = con.prepareStatement(query);
		row = pStatement.executeUpdate();
		con.close();
		}catch (Exception e) {
			//e.printStackTrace();
			logger.error(e.getMessage(),e);
		}
		return row;
	}

	public ArrayList<UserDto> selectAllUsers() {
		ArrayList<UserDto> users = new ArrayList<UserDto>();
		try {
		Connection con = getConnection();
		String query = "SELECT * FROM users";
		PreparedStatement pStatement = con.prepareStatement(query);
		ResultSet res = pStatement.executeQuery();

		while (res.next()) {
			UserDto getUser = new UserDto();
			getUser.setId(res.getInt("id"));
			getUser.setEmail(res.getString("email"));
			getUser.setPassword(res.getString("password"));
			getUser.setFirstName(res.getString("firstname"));
			getUser.setLastName(res.getString("lastname"));
			getUser.setDateOfBirth(res.getDate("dateofbirth"));
			getUser.setRegDate(res.getTimestamp("regdate"));
			getUser.setRole(res.getInt("role"));
			getUser.setImgPath(res.getString("imgpath"));
			getUser.setNote(res.getString("note"));
			getUser.setEnabled(res.getBoolean("enabled"));
			users.add(getUser);
		}
		}catch (Exception e) {
			//e.printStackTrace();
			logger.error(e.getMessage(),e);
		}
		return users;
	}
	
	public ArrayList<UserDto> selectAllAdminByRole(int role) {
		ArrayList<UserDto> users = new ArrayList<UserDto>();
		try {
		Connection con = getConnection();
		String query = "SELECT email from users WHERE role=?";
		PreparedStatement pStatement = con.prepareStatement(query);
		pStatement.setInt(1, role);
		ResultSet res = pStatement.executeQuery();

		while (res.next()) {
			UserDto getUser = new UserDto();
			getUser.setEmail(res.getString("email"));
			users.add(getUser);
		}
		}catch (Exception e) {
			//e.printStackTrace();
			logger.error(e.getMessage(),e);
		}
		return users;
	}
	
	public ArrayList<RoleDto> selectAllRoles() {
		ArrayList<RoleDto> roles = new ArrayList<RoleDto>();
		try {
		Connection con = getConnection();
		String query = "SELECT * FROM roles";
		PreparedStatement pStatement = con.prepareStatement(query);
		ResultSet res = pStatement.executeQuery();

		while (res.next()) {
			RoleDto getRole = new RoleDto();
			getRole.setId(res.getInt("id"));
			getRole.setLabel(res.getString("label"));
			getRole.setDescription(res.getString("description"));
			getRole.setLevel(res.getInt("level"));
			roles.add(getRole);
		}
		}catch (Exception e) {
			//e.printStackTrace();
			logger.error(e.getMessage(),e);
		}
		return roles;
	}

	public UserDto selectByIdEmail(String emailLog, String passwordLog)
			throws IOException, ClassNotFoundException, SQLException {
		UserDto userToReturn = null;
		try {
			Connection con = getConnection();
			String query = "SELECT * FROM users where email =? AND password=?;";
			PreparedStatement pStatement = con.prepareStatement(query);
			pStatement.setString(1, emailLog);
			pStatement.setString(2, passwordLog);
			ResultSet res = pStatement.executeQuery();
			if (res.next() == true) {
				userToReturn = new UserDto();
				userToReturn.setId(res.getInt("id"));
				userToReturn.setEmail(res.getString("email"));
				userToReturn.setPassword(res.getString("password"));
				userToReturn.setFirstName(res.getString("firstname"));
				userToReturn.setLastName(res.getString("lastname"));
				userToReturn.setDateOfBirth(res.getDate("dateofbirth"));
				userToReturn.setRegDate(res.getTimestamp("regdate"));
				userToReturn.setRole(res.getInt("role"));
				userToReturn.setImgPath(res.getString("imgpath"));
				userToReturn.setNote(res.getString("note"));
				userToReturn.setEnabled(res.getBoolean("enabled"));
				con.close();
				return userToReturn;
			}
		} catch (Exception e) {
			//e.printStackTrace();
			logger.error(e.getMessage(),e);
		}
		return userToReturn;
	}

	public UserDto selectByUserId(int id){
		UserDto userToReturn = null;
		try {
			Connection con = getConnection();
			String query = "SELECT * FROM users where id =?;";
			PreparedStatement pStatement = con.prepareStatement(query);
			pStatement.setInt(1, id);
			ResultSet res = pStatement.executeQuery();
			if (res.next() == true) {
				userToReturn = new UserDto();
				userToReturn.setId(res.getInt("id"));
				userToReturn.setEmail(res.getString("email"));
				userToReturn.setPassword(res.getString("password"));
				userToReturn.setFirstName(res.getString("firstname"));
				userToReturn.setLastName(res.getString("lastname"));
				userToReturn.setDateOfBirth(res.getDate("dateofbirth"));
				userToReturn.setRegDate(res.getTimestamp("regdate"));
				userToReturn.setRole(res.getInt("role"));
				userToReturn.setImgPath(res.getString("imgpath"));
				userToReturn.setNote(res.getString("note"));
				userToReturn.setEnabled(res.getBoolean("enabled"));
				con.close();
				return userToReturn;
			}
		} catch (Exception e) {
			//e.printStackTrace();
			logger.error(e.getMessage(),e);
		}
		return userToReturn;
	}
	
//	public UserDto selectByUserLastId(int id){
//		UserDto userToReturn = null;
//		try {
//			Connection con = getConnection();
//			String query = "SELECT id from users where id =1;";
//			PreparedStatement pStatement = con.prepareStatement(query);
//			ResultSet res = pStatement.executeQuery();
//			if (res.next() == true) {
//				userToReturn = new UserDto();
//				userToReturn.setId(res.getInt("id"));
//				userToReturn.setEmail(res.getString("email"));
//				userToReturn.setPassword(res.getString("password"));
//				userToReturn.setFirstName(res.getString("firstname"));
//				userToReturn.setLastName(res.getString("lastname"));
//				userToReturn.setDateOfBirth(res.getDate("dateofbirth"));
//				userToReturn.setRegDate(res.getTimestamp("regdate"));
//				userToReturn.setRole(res.getInt("role"));
//				userToReturn.setImgPath(res.getString("imgpath"));
//				userToReturn.setNote(res.getString("note"));
//				userToReturn.setEnabled(res.getBoolean("enabled"));
//				con.close();
//				return userToReturn;
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return userToReturn;
//	}
	
	public RoleDto selectByRoleId(int id){
		RoleDto roleToReturn = null;
		try {
			Connection con = getConnection();
			String query = "SELECT * FROM roles where id =?;";
			PreparedStatement pStatement = con.prepareStatement(query);
			pStatement.setInt(1, id);
			ResultSet res = pStatement.executeQuery();
			if (res.next() == true) {
				roleToReturn = new RoleDto();
				roleToReturn.setId(res.getInt("id"));
				roleToReturn.setLabel(res.getString("label"));
				roleToReturn.setDescription(res.getString("description"));
				roleToReturn.setLevel(res.getInt("level"));
				con.close();
				return roleToReturn;
			}
		} catch (Exception e) {
			//e.printStackTrace();
			logger.error(e.getMessage(),e);
		}
		return roleToReturn;
	}

	public UserDto selectByEmail(String email){
		UserDto userToReturn = null;
		try {
			Connection con = getConnection();
			String query = "SELECT * FROM users where email =?;";
			PreparedStatement pStatement = con.prepareStatement(query);
			pStatement.setString(1, email);
			ResultSet res = pStatement.executeQuery();
			if (res.next() == true) {
				userToReturn = new UserDto();
				userToReturn.setId(res.getInt("id"));
				userToReturn.setEmail(res.getString("email"));
				userToReturn.setPassword(res.getString("password"));
				userToReturn.setFirstName(res.getString("firstname"));
				userToReturn.setLastName(res.getString("lastname"));
				userToReturn.setDateOfBirth(res.getDate("dateofbirth"));
				userToReturn.setRegDate(res.getTimestamp("regdate"));
				userToReturn.setRole(res.getInt("role"));
				userToReturn.setImgPath(res.getString("imgpath"));
				userToReturn.setNote(res.getString("note"));
				userToReturn.setEnabled(res.getBoolean("enabled"));
				con.close();
				return userToReturn;
			}
		} catch (Exception e) {
			//e.printStackTrace();
			logger.error(e.getMessage(),e);
		}
		return userToReturn;
	}
	
	public UserDto getUser(String emailLog, String passwordLog) {
		UserDto userToReturn = new UserDto();
		try {
			Connection con = getConnection();
			String query = "SELECT * FROM users where email =? AND password=?;";
			PreparedStatement pStatement = con.prepareStatement(query);
			pStatement.setString(1, emailLog);
			pStatement.setString(2, passwordLog);
			ResultSet res = pStatement.executeQuery();
			if (res.next() == true) {
				userToReturn = new UserDto();
				userToReturn.setId(res.getInt("id"));
				userToReturn.setEmail(res.getString("email"));
				userToReturn.setPassword(res.getString("password"));
				userToReturn.setFirstName(res.getString("firstname"));
				userToReturn.setLastName(res.getString("lastname"));
				userToReturn.setDateOfBirth(res.getDate("dateofbirth"));
				userToReturn.setRegDate(res.getTimestamp("regdate"));
				userToReturn.setRole(res.getInt("role"));
				userToReturn.setImgPath(res.getString("imgpath"));
				userToReturn.setNote(res.getString("note"));
				userToReturn.setEnabled(res.getBoolean("enabled"));
				con.close();
				return userToReturn;
			}
		} catch (Exception e) {
			//e.printStackTrace();
			logger.error(e.getMessage(),e);
		}
		return userToReturn;
	}
	
	public boolean deleteRowUsers(int id) throws ClassNotFoundException, SQLException, IOException {
		boolean value = false;
		Connection con = getConnection();
		String query = "DELETE FROM users where id=?";
		PreparedStatement pStatement = con.prepareStatement(query);
		pStatement.setInt(1, id);
		int row = pStatement.executeUpdate();
		if (row > 0) {
			value = true;
		}

		con.close();
		return value;
	}
	
	public boolean deleteRowRoles(int id) throws ClassNotFoundException, SQLException, IOException {
		boolean value = false;
		Connection con = getConnection();
		String query = "DELETE FROM roles where id=?";
		PreparedStatement pStatement = con.prepareStatement(query);
		pStatement.setInt(1, id);
		int row = pStatement.executeUpdate();
		if (row > 0) {
			value = true;
		}

		con.close();
		return value;
	}
	
	public int updateUser(int id,UserDto itemToInsert) {
		int returnValue = 0;
		try {
			Connection con = getConnection();
			String query = "UPDATE users SET email =? , password=? , firstname=? , lastname=?, "
					+ "dateOfBirth=?, regDate=? , role=?, "
					+ "imgPath=? , note=? ,enabled=? WHERE id =?";
			PreparedStatement pStatement = con.prepareStatement(query);
			pStatement.setString(1, itemToInsert.getEmail());
			pStatement.setString(2, itemToInsert.getPassword());
			pStatement.setString(3, itemToInsert.getFirstName());
			pStatement.setString(4, itemToInsert.getLastName());
			pStatement.setDate(5, itemToInsert.getDateOfBirth());
			pStatement.setTimestamp(6, itemToInsert.getRegDate());
			pStatement.setInt(7, itemToInsert.getRole());
			pStatement.setString(8, itemToInsert.getImgPath());
			pStatement.setString(9, itemToInsert.getNote());
			pStatement.setBoolean(10, itemToInsert.getEnabled());
			pStatement.setInt(11, id);
			returnValue = pStatement.executeUpdate();
			con.close();
			return returnValue;		
			} catch (Exception e) {
				//e.printStackTrace();
				logger.error(e.getMessage(),e);
			}
		return returnValue;
	}
	
	public int updateRole(int id,RoleDto itemToInsert) {
		int returnValue = 0;
		try {
			Connection con = getConnection();
			String query = "UPDATE roles SET label=?, description=?,level=? WHERE id =?";
			PreparedStatement pStatement = con.prepareStatement(query);
			pStatement.setString(1, itemToInsert.getLabel());
			pStatement.setString(2, itemToInsert.getDescription());
			pStatement.setInt(3, itemToInsert.getLevel());
			pStatement.setInt(4, id);
			returnValue = pStatement.executeUpdate();
			con.close();
			return returnValue;		
			} catch (Exception e) {
				//e.printStackTrace();
				logger.error(e.getMessage(),e);
			}
		return returnValue;
	}

	private Connection getConnection() throws IOException, ClassNotFoundException, SQLException {
		String driver = PropertiesManagerSingleton.getInstance().getProperty("database.mysql.driver");
		Class.forName(driver);
		String host = PropertiesManagerSingleton.getInstance().getProperty("database.mysql.host");
		String port = PropertiesManagerSingleton.getInstance().getProperty("database.mysql.port");
		String dbName = PropertiesManagerSingleton.getInstance().getProperty("database.mysql.db.name");
		String url = "jdbc:mariadb://" + host + ":" + port + "/" + dbName;
		String userName = PropertiesManagerSingleton.getInstance().getProperty("database.mysql.db.username");
		String password = PropertiesManagerSingleton.getInstance().getProperty("database.mysql.db.password");
		Connection con = DriverManager.getConnection(url, userName, password);
		return con;
	}
}