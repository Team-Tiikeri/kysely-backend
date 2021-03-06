package tiikeri.kyselyapp.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long questionId;
	private QuestionType type;
	private String content;
	private boolean isRequired;
	

	/* @JsonManagedReference */
	@ManyToOne
	@JsonIgnoreProperties("questions")
	@JoinColumn(name = "questionnaireId")
	private Questionnaire questionnaire;

	/* @JsonBackReference */
	@JsonIgnoreProperties("question")
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "question")
	private List<Answer> answers;
	@JsonIgnoreProperties("question")
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "question")
	private List<Option> options;

	
	//constructor with parameters
	public Question(QuestionType type, String content, boolean isRequired, Questionnaire questionnaire) {
		super();
		this.type = type;
		this.content = content;
		this.isRequired = isRequired;
		this.questionnaire = questionnaire;
	}

	//constructor without parameters
	public Question() {
	}
	
	//getters and setters
	public List<Option> getOptions() {
		return options;
	}

	public void setOptions(List<Option> options) {
		this.options = options;
	}

	


	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public QuestionType getType() {
		return type;
	}

	public void setType(QuestionType type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public boolean getIsRequired() {
		return isRequired;
	}

	public void setIsRequired(boolean isRequired) {
		this.isRequired = isRequired;
	}

	public Questionnaire getQuestionnaire() {
		return questionnaire;
	}

	public void setQuestionnaire(Questionnaire questionnaire) {
		this.questionnaire = questionnaire;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	

}
