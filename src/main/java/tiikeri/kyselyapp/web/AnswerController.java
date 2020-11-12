package tiikeri.kyselyapp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tiikeri.kyselyapp.domain.Answer;
import tiikeri.kyselyapp.domain.AnswerRepository;
import tiikeri.kyselyapp.domain.Question;
import tiikeri.kyselyapp.domain.QuestionRepository;

@CrossOrigin
@RestController
public class AnswerController {

	@Autowired
	private QuestionRepository questionRepository;

	@Autowired
	private AnswerRepository answerRepository;

	@GetMapping("/api/questions/{id}/answers")
	public List<Answer> findAnswersByQuestion(@PathVariable("id") Long questionId) {
		Question question = questionRepository.findById(questionId).orElse(null);
		return answerRepository.findByQuestion(question);
	}

	@GetMapping("/api/answers")
	public List<Answer> findAllAnswers() {
		return (List<Answer>) answerRepository.findAll();
	}

	@PostMapping(value = "/api/answers")
	public Answer saveAnswer(@RequestBody Answer request) {
		return answerRepository.save(request);
	}
}
