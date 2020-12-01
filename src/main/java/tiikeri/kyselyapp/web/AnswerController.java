package tiikeri.kyselyapp.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tiikeri.kyselyapp.domain.Answer;
import tiikeri.kyselyapp.domain.AnswerRepository;
import tiikeri.kyselyapp.domain.Option;
import tiikeri.kyselyapp.domain.OptionRepository;
import tiikeri.kyselyapp.domain.Question;
import tiikeri.kyselyapp.domain.QuestionRepository;
import tiikeri.kyselyapp.domain.QuestionType;

@CrossOrigin
@RestController
public class AnswerController {

	@Autowired
	private QuestionRepository questionRepository;

	@Autowired
	private AnswerRepository answerRepository;

	@Autowired
	private OptionRepository optionRepository;

	//REST list answers by questions
	@GetMapping("/api/questions/{id}/answers")
	public List<Answer> findAnswersByQuestion(@PathVariable("id") Long questionId) {
		Question question = questionRepository.findById(questionId).orElse(null);
		return answerRepository.findByQuestion(question);
	}

	//REST list all answers
	@GetMapping("/api/answers")
	public List<Answer> findAllAnswers() {
		return (List<Answer>) answerRepository.findAll();
	}

	//REST save answer, validation for radiobutton and checkbox answers 
	@PostMapping(value = "/api/answers")
	public List<Answer> saveAnswer(@RequestBody List<Answer> answers) throws Exception {
		List<Answer> savedAnswers = new ArrayList<Answer>();
		for (int i = 0; i < answers.size(); i++) {
			Question question = questionRepository.findById(answers.get(i).getQuestion().getQuestionId()).orElse(null);
			Answer answer = new Answer(answers.get(i).getContent(), question);
			List<Option> options = optionRepository.findByQuestion(question);

			if (!answer.getQuestion().getType().equals(QuestionType.TEXT)) {
				if (options.stream().anyMatch(o -> o.getContent().equals(answer.getContent()))) {
					answerRepository.save(answer);
					savedAnswers.add(answer);
				} else {
					throw new Exception("Answer did not match an option");
				}

			} else {
				answerRepository.save(answer);
				savedAnswers.add(answer);
			}

		}
		return savedAnswers;
	}
}
