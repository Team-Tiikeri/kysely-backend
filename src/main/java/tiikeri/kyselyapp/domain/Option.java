package tiikeri.kyselyapp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Option {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long optionId;
	private String content;
	@ManyToOne
	@JoinColumn(name = "questionId")
	@JsonIgnoreProperties("option")
	private Question question;

	// getters and setters
	public Long getOptionId() {
		return optionId;
	}

	public void setOptionId(Long optionId) {
		this.optionId = optionId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	// constructor with parameters
	public Option(String content, Question question) {
		super();
		this.content = content;
		this.question = question;
	}

	// constuctor without parameters
	public Option() {

	}
}
