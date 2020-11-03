package tiikeri.kyselyapp.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String type;
	private String content;
	private boolean isRequired;

	@ManyToOne
	@JsonManagedReference
	@JoinColumn(name = "questionnaireId")
	private Questionnaire questionnaire;

	public Question(String type, String content, boolean isRequired, Questionnaire questionnaire) {
		super();
		this.type = type;
		this.content = content;
		this.isRequired = isRequired;
		this.questionnaire = questionnaire;
	}

	public Question() {

	}

	public Questionnaire getQuestionnaire() {
		return questionnaire;
	}

	public void setQuestionnaire(Questionnaire questionnaire) {
		this.questionnaire = questionnaire;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public boolean isRequired() {
		return isRequired;
	}

	public void setRequired(boolean isRequired) {
		this.isRequired = isRequired;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", type=" + type + ", content=" + content + ", isRequired=" + isRequired + "]";
	}

}
