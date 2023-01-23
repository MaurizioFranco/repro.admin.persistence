package proxima.informatica.academy.dto;

/**
 * @author Giammarco Lucchetti
 */
public class RoleDto {
	private Integer id;
	private String label;
	private String description;
	private Integer level;
	
	public RoleDto(Integer id, String label, String description, Integer level) {
		super();
		this.id = id;
		this.label = label;
		this.description = description;
		this.level = level;
	}

	public RoleDto() {
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the level
	 */
	public Integer getLevel() {
		return level;
	}

	/**
	 * @param level the level to set
	 */
	public void setLevel(Integer level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "RoleDto [id=" + id + ", label=" + label + ", description=" + description + ", level=" + level + "]";
	}
	
	
	
}
