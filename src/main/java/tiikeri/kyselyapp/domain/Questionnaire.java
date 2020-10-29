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
	private String title;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "questionnaire")
	private List<Question> questions;

	public Questionnaire(String title) {
		super();
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

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	@Override
	public String toString() {
		return "Questionnaire [questionnaireId=" + questionnaireId + ", title=" + title
				+ ", questions=" + questions + "]";
	}

}
