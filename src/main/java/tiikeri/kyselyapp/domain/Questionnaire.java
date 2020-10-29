package tiikeri.kyselyapp.domain;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Questionnaire {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long questionnaireId;
	private String question;
	private String title;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "questionnaire")
	private List<Question> questions;

	public Questionnaire(String question, String title) {
		super();
		this.question = question;
		this.title = title;
	}

	public Questionnaire() {

	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getQuestionnaireId() {
		return questionnaireId;
	}

	public void setQuestionnaireId(Long questionnaireId) {
		this.questionnaireId = questionnaireId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	@Override
	public String toString() {
		return "Questionnaire [questionnaireId=" + questionnaireId + ", question=" + question + ", title=" + title
				+ ", questions=" + questions + "]";
	}

}
