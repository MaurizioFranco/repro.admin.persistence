package proxima.informatica.academy.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "coursepage")
public class CoursePageDto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String title;
	private String code;
	private String body_text;
	
	@Column(name="file_name")
	private String file_name;

	public CoursePageDto() {
		super();
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
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the body_text
	 */
	public String getBody_text() {
		return body_text;
	}

	/**
	 * @param body_text the body_text to set
	 */
	public void setBody_text(String body_text) {
		this.body_text = body_text;
	}

	/**
	 * @return the file_name
	 */
	public String getFile_name() {
		return file_name;
	}

	/**
	 * @param file_name the file_name to set
	 */
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}

	@Override
	public String toString() {
		return "CoursePageDto [id=" + id + ", title=" + title + ", code=" + code + ", body_text=" + body_text
				+ ", file_name=" + file_name + "]";
	}

}
