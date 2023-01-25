package proxima.informatica.academy.dto;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class CandidatesDto {
	
	private Integer id;
	private Integer user_id;
	private String domicile_city;
	private String study_qualification;
	private Byte graduate;
	private Byte high_graduate;
	private Byte still_high_study;
	private String mobile;
	private String cv_external_path;
	private String course_code;
	private LocalDateTime candidacy_date_time;
	private String label;
	private String firstname;
	private String lastname;
	private String email;
	private Long dateofbirth;
	private Timestamp regdate;
	private String technical_note;
	private String hr_note;
	private Integer inserted_by;
	private String imgpath;
	private Integer candidate_state_code;
	
	public CandidatesDto(Integer id, Integer user_id, String domicile_city, String study_qualification,
			Byte graduate, Byte high_graduate, Byte still_high_study, String mobile, String cv_external_path,
			String course_code, LocalDateTime candidacy_date_time, String label, String firstname, String lastname, String email,
			Long dateofbirth, Timestamp regdate, String technical_note, String hr_note, Integer inserted_by,
			String imgpath, Integer candidate_state_code) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.domicile_city = domicile_city;
		this.study_qualification = study_qualification;
		this.graduate = graduate;
		this.high_graduate = high_graduate;
		this.still_high_study = still_high_study;
		this.mobile = mobile;
		this.cv_external_path = cv_external_path;
		this.course_code = course_code;
		this.candidacy_date_time = candidacy_date_time;
		this.label = label;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.dateofbirth = dateofbirth;
		this.regdate = regdate;
		this.technical_note = technical_note;
		this.hr_note = hr_note;
		this.inserted_by = inserted_by;
		this.imgpath = imgpath;
		this.candidate_state_code = candidate_state_code;
	}
	public CandidatesDto() {
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
	 * @return the user_id
	 */
	public Integer getUser_id() {
		return user_id;
	}
	/**
	 * @param user_id the user_id to set
	 */
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	/**
	 * @return the domicile_city
	 */
	public String getDomicile_city() {
		return domicile_city;
	}
	/**
	 * @param domicile_city the domicile_city to set
	 */
	public void setDomicile_city(String domicile_city) {
		this.domicile_city = domicile_city;
	}
	/**
	 * @return the study_qualification
	 */
	public String getStudy_qualification() {
		return study_qualification;
	}
	/**
	 * @param study_qualification the study_qualification to set
	 */
	public void setStudy_qualification(String study_qualification) {
		this.study_qualification = study_qualification;
	}
	/**
	 * @return the graduate
	 */
	public Byte getGraduate() {
		return graduate;
	}
	/**
	 * @param graduate the graduate to set
	 */
	public void setGraduate(Byte graduate) {
		this.graduate = graduate;
	}
	/**
	 * @return the high_graduate
	 */
	public Byte getHigh_graduate() {
		return high_graduate;
	}
	/**
	 * @param high_graduate the high_graduate to set
	 */
	public void setHigh_graduate(Byte high_graduate) {
		this.high_graduate = high_graduate;
	}
	/**
	 * @return the still_high_study
	 */
	public Byte getStill_high_study() {
		return still_high_study;
	}
	/**
	 * @param still_high_study the still_high_study to set
	 */
	public void setStill_high_study(Byte still_high_study) {
		this.still_high_study = still_high_study;
	}
	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * @return the cv_external_path
	 */
	public String getCv_external_path() {
		return cv_external_path;
	}
	/**
	 * @param cv_external_path the cv_external_path to set
	 */
	public void setCv_external_path(String cv_external_path) {
		this.cv_external_path = cv_external_path;
	}
	/**
	 * @return the course_code
	 */
	public String getCourse_code() {
		return course_code;
	}
	/**
	 * @param course_code the course_code to set
	 */
	public void setCourse_code(String course_code) {
		this.course_code = course_code;
	}
	/**
	 * @return the candidacy_date_time
	 */
	public LocalDateTime getCandidacy_date_time() {
		return candidacy_date_time;
	}
	/**
	 * @param candidacy_date_time the candidacy_date_time to set
	 */
	public void setCandidacy_date_time(LocalDateTime candidacy_date_time) {
		this.candidacy_date_time = candidacy_date_time;
	}
	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}
	/**
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
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
	 * @return the dateofbirth
	 */
	public Long getDateofbirth() {
		return dateofbirth;
	}
	/**
	 * @param dateofbirth the dateofbirth to set
	 */
	public void setDateofbirth(Long dateofbirth) {
		this.dateofbirth = dateofbirth;
	}
	/**
	 * @return the regdate
	 */
	public Timestamp getRegdate() {
		return regdate;
	}
	/**
	 * @param regdate the regdate to set
	 */
	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}
	/**
	 * @return the technical_note
	 */
	public String getTechnical_note() {
		return technical_note;
	}
	/**
	 * @param technical_note the technical_note to set
	 */
	public void setTechnical_note(String technical_note) {
		this.technical_note = technical_note;
	}
	/**
	 * @return the hr_note
	 */
	public String getHr_note() {
		return hr_note;
	}
	/**
	 * @param hr_note the hr_note to set
	 */
	public void setHr_note(String hr_note) {
		this.hr_note = hr_note;
	}
	/**
	 * @return the inserted_by
	 */
	public Integer getInserted_by() {
		return inserted_by;
	}
	/**
	 * @param inserted_by the inserted_by to set
	 */
	public void setInserted_by(Integer inserted_by) {
		this.inserted_by = inserted_by;
	}
	/**
	 * @return the imgpath
	 */
	public String getImgpath() {
		return imgpath;
	}
	/**
	 * @param imgpath the imgpath to set
	 */
	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}
	/**
	 * @return the candidate_state_code
	 */
	public Integer getCandidate_state_code() {
		return candidate_state_code;
	}
	/**
	 * @param candidate_state_code the candidate_state_code to set
	 */
	public void setCandidate_state_code(Integer candidate_state_code) {
		this.candidate_state_code = candidate_state_code;
	}
	@Override
	public String toString() {
		return "CandidatesDto [id=" + id + ", user_id=" + user_id + ", domicile_city=" + domicile_city
				+ ", study_qualification=" + study_qualification + ", graduate=" + graduate + ", high_graduate="
				+ high_graduate + ", still_high_study=" + still_high_study + ", mobile=" + mobile
				+ ", cv_external_path=" + cv_external_path + ", course_code=" + course_code + ", candidacy_date_time="
				+ candidacy_date_time + ", label=" + label + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", email=" + email + ", dateofbirth=" + dateofbirth + ", regdate=" + regdate + ", technical_note="
				+ technical_note + ", hr_note=" + hr_note + ", inserted_by=" + inserted_by + ", imgpath=" + imgpath
				+ ", candidate_state_code=" + candidate_state_code + "]";
	}
	
	  /*`id` bigint(20) NOT NULL AUTO_INCREMENT,
	  `user_id` bigint(20) NOT NULL,
	  `domicile_city` varchar(100) DEFAULT NULL,
	  `study_qualification` varchar(300) DEFAULT NULL,
	  `graduate` tinyint(1) DEFAULT NULL,
	  `high_graduate` tinyint(1) DEFAULT NULL,
	  `still_high_study` tinyint(1) DEFAULT NULL,
	  `mobile` varchar(20) DEFAULT NULL,
	  `cv_external_path` varchar(1000) DEFAULT NULL,
	  `course_code` varchar(100) NOT NULL,
	  `candidacy_date_time` datetime NOT NULL,
	  `label` varchar(200) DEFAULT NULL,
	  `firstname` varchar(50) NOT NULL,
	  `lastname` varchar(50) NOT NULL,
	  `email` varchar(100) NOT NULL,
	  `dateofbirth` date DEFAULT NULL,
	  `regdate` datetime NOT NULL,
	  `technical_note` varchar(2000) DEFAULT NULL,
	  `hr_note` varchar(2000) DEFAULT NULL,
	  `inserted_by` bigint(20) NOT NULL,
	  `imgpath` varchar(255) DEFAULT NULL,
	  `candidate_state_code` int(11) NOT NULL,*/
	
}
