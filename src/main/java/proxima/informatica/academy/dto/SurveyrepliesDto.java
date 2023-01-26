package proxima.informatica.academy.dto;

import java.math.BigInteger;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


/**
 * @author Giammarco Lucchetti
 */

@Entity
@Table(name = "surveyreplies")
public class SurveyrepliesDto extends AbstractCommonDto{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private BigInteger survey_id;
	private BigInteger user_id;
	private Timestamp starttime;
	private Timestamp endtime;
	private String answers;
	private String pdffilename;
	private String points;
	
	
	public SurveyrepliesDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public SurveyrepliesDto(Integer id, BigInteger survey_id, BigInteger user_id, Timestamp starttime, Timestamp endtime,
			String answers, String pdffilename, String points) {
		super();
		this.id = id;
		this.survey_id = survey_id;
		this.user_id = user_id;
		this.starttime = starttime;
		this.endtime = endtime;
		this.answers = answers;
		this.pdffilename = pdffilename;
		this.points = points;
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
	 * @return the survey_id
	 */
	public BigInteger getSurvey_id() {
		return survey_id;
	}


	/**
	 * @param survey_id the survey_id to set
	 */
	public void setSurvey_id(BigInteger survey_id) {
		this.survey_id = survey_id;
	}


	/**
	 * @return the user_id
	 */
	public BigInteger getUser_id() {
		return user_id;
	}


	/**
	 * @param user_id the user_id to set
	 */
	public void setUser_id(BigInteger user_id) {
		this.user_id = user_id;
	}


	/**
	 * @return the starttime
	 */
	public Timestamp getStarttime() {
		return starttime;
	}


	/**
	 * @param starttime the starttime to set
	 */
	public void setStarttime(Timestamp starttime) {
		this.starttime = starttime;
	}


	/**
	 * @return the endtime
	 */
	public Timestamp getEndtime() {
		return endtime;
	}


	/**
	 * @param endtime the endtime to set
	 */
	public void setEndtime(Timestamp endtime) {
		this.endtime = endtime;
	}


	/**
	 * @return the answers
	 */
	public String getAnswers() {
		return answers;
	}


	/**
	 * @param answers the answers to set
	 */
	public void setAnswers(String answers) {
		this.answers = answers;
	}


	/**
	 * @return the pdffilename
	 */
	public String getPdffilename() {
		return pdffilename;
	}


	/**
	 * @param pdffilename the pdffilename to set
	 */
	public void setPdffilename(String pdffilename) {
		this.pdffilename = pdffilename;
	}


	/**
	 * @return the points
	 */
	public String getPoints() {
		return points;
	}


	/**
	 * @param points the points to set
	 */
	public void setPoints(String points) {
		this.points = points;
	}


	@Override
	public String toString() {
		return "SurveyrepliesDto [id=" + id + ", survey_id=" + survey_id + ", user_id=" + user_id + ", starttime="
				+ starttime + ", endtime=" + endtime + ", answers=" + answers + ", pdffilename=" + pdffilename
				+ ", points=" + points + "]";
	}
	
}
