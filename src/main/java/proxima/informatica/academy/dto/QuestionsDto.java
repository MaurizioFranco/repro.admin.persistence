package proxima.informatica.academy.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "questions")
public class QuestionsDto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String label;
	private String description;
	
	private String ansa;
	private String ansb;
	private String ansc;
	private String ansd;
	private String anse;
	private String ansf;
	private String ansg;
	private String ansh;
	
	private Boolean cansa;
	private Boolean cansb;
	private Boolean cansc;
	private Boolean cansd;
	private Boolean canse;
	private Boolean cansf;
	private Boolean cansg;
	private Boolean cansh;
	
	private String full_answer;
	

	
	public QuestionsDto(Integer id, String label, String description, String ansa, String ansb, String ansc,
			String ansd, String anse, String ansf, String ansg, String ansh, Boolean cansa, Boolean cansb,
			Boolean cansc, Boolean cansd, Boolean canse, Boolean cansf, Boolean cansg, Boolean cansh,
			String full_answer) {
		super();
		this.id = id;
		this.label = label;
		this.description = description;
		this.ansa = ansa;
		this.ansb = ansb;
		this.ansc = ansc;
		this.ansd = ansd;
		this.anse = anse;
		this.ansf = ansf;
		this.ansg = ansg;
		this.ansh = ansh;
		this.cansa = cansa;
		this.cansb = cansb;
		this.cansc = cansc;
		this.cansd = cansd;
		this.canse = canse;
		this.cansf = cansf;
		this.cansg = cansg;
		this.cansh = cansh;
		this.full_answer = full_answer;
	}



	public QuestionsDto() {
		super();
		// TODO Auto-generated constructor stub
	}



	@Override
	public String toString() {
		return "QuestionsDto [id=" + id + ", label=" + label + ", description=" + description + ", ansa=" + ansa
				+ ", ansb=" + ansb + ", ansc=" + ansc + ", ansd=" + ansd + ", anse=" + anse + ", ansf=" + ansf
				+ ", ansg=" + ansg + ", ansh=" + ansh + ", cansa=" + cansa + ", cansb=" + cansb + ", cansc=" + cansc
				+ ", cansd=" + cansd + ", canse=" + canse + ", cansf=" + cansf + ", cansg=" + cansg + ", cansh=" + cansh
				+ ", full_answer=" + full_answer + "]";
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
	 * @return the ansa
	 */
	public String getAnsa() {
		return ansa;
	}



	/**
	 * @param ansa the ansa to set
	 */
	public void setAnsa(String ansa) {
		this.ansa = ansa;
	}



	/**
	 * @return the ansb
	 */
	public String getAnsb() {
		return ansb;
	}



	/**
	 * @param ansb the ansb to set
	 */
	public void setAnsb(String ansb) {
		this.ansb = ansb;
	}



	/**
	 * @return the ansc
	 */
	public String getAnsc() {
		return ansc;
	}



	/**
	 * @param ansc the ansc to set
	 */
	public void setAnsc(String ansc) {
		this.ansc = ansc;
	}



	/**
	 * @return the ansd
	 */
	public String getAnsd() {
		return ansd;
	}



	/**
	 * @param ansd the ansd to set
	 */
	public void setAnsd(String ansd) {
		this.ansd = ansd;
	}



	/**
	 * @return the anse
	 */
	public String getAnse() {
		return anse;
	}



	/**
	 * @param anse the anse to set
	 */
	public void setAnse(String anse) {
		this.anse = anse;
	}



	/**
	 * @return the ansf
	 */
	public String getAnsf() {
		return ansf;
	}



	/**
	 * @param ansf the ansf to set
	 */
	public void setAnsf(String ansf) {
		this.ansf = ansf;
	}



	/**
	 * @return the ansg
	 */
	public String getAnsg() {
		return ansg;
	}



	/**
	 * @param ansg the ansg to set
	 */
	public void setAnsg(String ansg) {
		this.ansg = ansg;
	}



	/**
	 * @return the ansh
	 */
	public String getAnsh() {
		return ansh;
	}



	/**
	 * @param ansh the ansh to set
	 */
	public void setAnsh(String ansh) {
		this.ansh = ansh;
	}



	/**
	 * @return the cansa
	 */
	public Boolean getCansa() {
		return cansa;
	}



	/**
	 * @param cansa the cansa to set
	 */
	public void setCansa(Boolean cansa) {
		this.cansa = cansa;
	}



	/**
	 * @return the cansb
	 */
	public Boolean getCansb() {
		return cansb;
	}



	/**
	 * @param cansb the cansb to set
	 */
	public void setCansb(Boolean cansb) {
		this.cansb = cansb;
	}



	/**
	 * @return the cansc
	 */
	public Boolean getCansc() {
		return cansc;
	}



	/**
	 * @param cansc the cansc to set
	 */
	public void setCansc(Boolean cansc) {
		this.cansc = cansc;
	}



	/**
	 * @return the cansd
	 */
	public Boolean getCansd() {
		return cansd;
	}



	/**
	 * @param cansd the cansd to set
	 */
	public void setCansd(Boolean cansd) {
		this.cansd = cansd;
	}



	/**
	 * @return the canse
	 */
	public Boolean getCanse() {
		return canse;
	}



	/**
	 * @param canse the canse to set
	 */
	public void setCanse(Boolean canse) {
		this.canse = canse;
	}



	/**
	 * @return the cansf
	 */
	public Boolean getCansf() {
		return cansf;
	}



	/**
	 * @param cansf the cansf to set
	 */
	public void setCansf(Boolean cansf) {
		this.cansf = cansf;
	}



	/**
	 * @return the cansg
	 */
	public Boolean getCansg() {
		return cansg;
	}



	/**
	 * @param cansg the cansg to set
	 */
	public void setCansg(Boolean cansg) {
		this.cansg = cansg;
	}



	/**
	 * @return the cansh
	 */
	public Boolean getCansh() {
		return cansh;
	}



	/**
	 * @param cansh the cansh to set
	 */
	public void setCansh(Boolean cansh) {
		this.cansh = cansh;
	}



	/**
	 * @return the full_answer
	 */
	public String getFull_answer() {
		return full_answer;
	}



	/**
	 * @param full_answer the full_answer to set
	 */
	public void setFull_answer(String full_answer) {
		this.full_answer = full_answer;
	}

	

}
