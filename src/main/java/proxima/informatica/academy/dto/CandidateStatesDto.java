package proxima.informatica.academy.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @author Marco Fabretti
 */

@Entity
@Table(name = "candidate_states")

public class CandidateStatesDto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	Integer role_id;
	Integer status_code;
	String status_label;
	String status_description;
	String status_color;
	
	public CandidateStatesDto() {
		super();
	}
	
	

	public CandidateStatesDto(Integer id, Integer role_id, Integer status_code, String status_label,
			String status_description, String status_color) {
		super();
		this.id = id;
		this.role_id = role_id;
		this.status_code = status_code;
		this.status_label = status_label;
		this.status_description = status_description;
		this.status_color = status_color;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRole_id() {
		return role_id;
	}

	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}

	public Integer getStatus_code() {
		return status_code;
	}

	public void setStatus_code(Integer status_code) {
		this.status_code = status_code;
	}

	public String getStatus_label() {
		return status_label;
	}

	public void setStatus_label(String status_label) {
		this.status_label = status_label;
	}

	public String getStatus_description() {
		return status_description;
	}

	public void setStatus_description(String status_description) {
		this.status_description = status_description;
	}

	public String getStatus_color() {
		return status_color;
	}

	public void setStatus_color(String status_color) {
		this.status_color = status_color;
	}



	@Override
	public String toString() {
		return "CandidateStatesDto [id=" + id + ", role_id=" + role_id + ", status_code=" + status_code
				+ ", status_label=" + status_label + ", status_description=" + status_description + ", status_color="
				+ status_color + "]";
	}



}
