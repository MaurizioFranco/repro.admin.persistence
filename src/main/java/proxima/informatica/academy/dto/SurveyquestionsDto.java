package proxima.informatica.academy.dto;

public class SurveyquestionsDto {

	private Integer id;
	private Integer surveyId;
	private Integer questionId;
	private Integer position;
	
	public SurveyquestionsDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SurveyquestionsDto(Integer id, Integer surveyId, Integer questionId, Integer position) {
		super();
		this.id = id;
		this.surveyId = surveyId;
		this.questionId = questionId;
		this.position = position;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getSurveyId() {
		return surveyId;
	}
	public void setSurveyId(Integer surveyId) {
		this.surveyId = surveyId;
	}
	public Integer getQuestionId() {
		return questionId;
	}
	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}
	public Integer getPosition() {
		return position;
	}
	public void setPosition(Integer position) {
		this.position = position;
	}
	@Override
	public String toString() {
		return "SurveyquestionsDto [id=" + id + ", surveyId=" + surveyId + ", questionId=" + questionId + ", position="
				+ position + "]";
	}

}
