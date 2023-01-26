/**
 *
 */
package proxima.informatica.academy.dto;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @author maurizio.franco@ymail.com
 *
 */
@Entity
@Table(name = "usersurveytoken")
public class UserSurveyToken {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="userid")
	private Long userId ;
	@Column(name="surveyid")
	private Long surveyId;
	@Column(name="generatedtoken")
	private String generatedToken ;
	@Column(name="expirationdate")
	private Timestamp expirationDate;
	@Column(name="expired")
	private Boolean expired ;
	
	/**
	 * 
	 */
	public UserSurveyToken() {
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
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * @return the surveyId
	 */
	public Long getSurveyId() {
		return surveyId;
	}

	/**
	 * @param surveyId the surveyId to set
	 */
	public void setSurveyId(Long surveyId) {
		this.surveyId = surveyId;
	}

	/**
	 * @return the generatedToken
	 */
	public String getGeneratedToken() {
		return generatedToken;
	}

	/**
	 * @param generatedToken the generatedToken to set
	 */
	public void setGeneratedToken(String generatedToken) {
		this.generatedToken = generatedToken;
	}

	/**
	 * @return the expirationDate
	 */
	public Timestamp getExpirationDate() {
		return expirationDate;
	}

	/**
	 * @param expirationDate the expirationDate to set
	 */
	public void setExpirationDate(Timestamp expirationDate) {
		this.expirationDate = expirationDate;
	}

	/**
	 * @return the expired
	 */
	public Boolean getExpired() {
		return expired;
	}

	/**
	 * @param expired the expired to set
	 */
	public void setExpired(Boolean expired) {
		this.expired = expired;
	}

	@Override
	public String toString() {
		return "UserSurveyToken [id=" + id + ", userId=" + userId + ", surveyId=" + surveyId + ", generatedToken="
				+ generatedToken + ", expirationDate=" + expirationDate + ", expired=" + expired + "]";
	}
	
	
	

}
