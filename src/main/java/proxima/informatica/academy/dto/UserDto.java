package proxima.informatica.academy.dto;

import java.sql.Date;
import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


/**
 * @author Giammarco Lucchetti
 */
@Entity
@Table(name = "users")

	public class UserDto extends AbstractCommonDto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	
	private Integer id;
	private String email;
	private String password;
	private String firstname;
	private String lastname;
	private Date dateofbirth;
	private Timestamp regdate;
	private Integer role;
	private String imgpath;
	private String note;
	private Boolean enabled;
	/**
	 * @param id
	 * @param email
	 * @param password
	 * @param firstname
	 * @param lastname
	 * @param dateofbirth
	 * @param regDate
	 * @param role
	 * @param imgPath
	 * @param note
	 * @param enabled
	 */
	public UserDto(Integer id, String email, String password, String firstname, String lastname, Date dateofbirth,
			Timestamp regDate, Integer role, String imgPath, String note, Boolean enabled) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.dateofbirth = dateofbirth;
		this.regdate = regDate;
		this.role = role;
		this.imgpath = imgPath;
		this.note = note;
		this.enabled = enabled;
	}
	/**
	 * 
	 */
	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}
	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}
	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	/**
	 * @return the dateofbirth
	 */
	public Date getDateofbirth() {
		return dateofbirth;
	}
	/**
	 * @param dateofbirth the dateofbirth to set
	 */
	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}
	/**
	 * @return the regDate
	 */
	public Timestamp getRegdate() {
		return regdate;
	}
	/**
	 * @param regDate the regDate to set
	 */
	public void setRegdate(Timestamp regDate) {
		this.regdate = regDate;
	}
	/**
	 * @return the role
	 */
	public Integer getRole() {
		return role;
	}
	/**
	 * @param role the role to set
	 */
	public void setRole(Integer role) {
		this.role = role;
	}
	/**
	 * @return the imgPath
	 */
	public String getImgpath() {
		return imgpath;
	}
	/**
	 * @param imgPath the imgPath to set
	 */
	public void setImgpath(String imgPath) {
		this.imgpath = imgPath;
	}
	/**
	 * @return the note
	 */
	public String getNote() {
		return note;
	}
	/**
	 * @param note the note to set
	 */
	public void setNote(String note) {
		this.note = note;
	}
	/**
	 * @return the enabled
	 */
	public Boolean getEnabled() {
		return enabled;
	}
	/**
	 * @param enabled the enabled to set
	 */
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	@Override
	public String toString() {
		return "UserDto [id=" + id + ", email=" + email + ", password=" + password + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", dateofbirth=" + dateofbirth + ", regDate=" + regdate + ", role=" + role
				+ ", imgPath=" + imgpath + ", note=" + note + ", enabled=" + enabled + "]";
	}
	


}
