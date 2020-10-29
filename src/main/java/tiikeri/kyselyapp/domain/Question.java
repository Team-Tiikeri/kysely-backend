package tiikeri.kyselyapp.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String type;
	private String content;
	private String compulsion;

	@ManyToOne
	@JoinColumn(name = "questionnaire")
	private Questionnaire questionnaire;

	public Question(String type, String content, String compulsion, Questionnaire questionnaire) {
		super();
		this.type = type;
		this.content = content;
		this.compulsion = compulsion;
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

	public String getCompulsion() {
		return compulsion;
	}

	public void setCompulsion(String compulsion) {
		this.compulsion = compulsion;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", type=" + type + ", content=" + content + ", compulsion=" + compulsion + "]";
	}

}
