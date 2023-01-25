package proxima.informatica.academy.dto;

/**
 * @author matteo.peruzza@gmail.com
 */

public class SurveyDto {

	private Integer id;					//auto-increment / primary-key / not null
	private String label;				//not null
	private Long time;
	private String description;
	
	//Constructors -----------------------------------------------------------
	
	public SurveyDto () {
		
		//Empty constructor
		
	}
	
	//Constructor with fields
	public SurveyDto (String label, Long time, String description){
		
		this.label=label;
		this.time=time;
		this.description=description;
		
	}
	
	//Getters and setters -----------------------------------------------------

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Long getTime() {
		return time;
	}

	public void setTime(Long time) {
		this.time = time;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	//ToString ----------------------------------------------------------------
	@Override
	public String toString() {
		return "SurveyDto [id=" + id + ", label=" + label + ", time=" + time + ", description=" + description + "]";
	}
	
}
