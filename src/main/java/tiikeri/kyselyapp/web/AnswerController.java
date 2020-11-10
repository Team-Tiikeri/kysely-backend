package tiikeri.kyselyapp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
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
import tiikeri.kyselyapp.domain.QuestionnaireRepository;

@CrossOrigin
@RestController
public class AnswerController {

	@Autowired
	private QuestionRepository questionRepository;

	@Autowired
	private AnswerRepository answerRepository;

	@GetMapping("/api/questions/{id}/answers")
	public @ResponseBody List<Answer> findAnswersByQuestion(@PathVariable("id") Long questionId) {
		Question question = questionRepository.findById(questionId).orElse(null);
		return answerRepository.findByQuestion(question);
	}

	@GetMapping("/api/answers")
	public @ResponseBody List<Answer> findAllAnswers() {
		return (List<Answer>) answerRepository.findAll();
	}

	@PostMapping(value = "/api/questions/{id}")
	public Answer saveAnswer(@PathVariable("id") Long questionId, @RequestBody Answer answer) {
		System.out.println(answer);
		Question question = questionRepository.findById(questionId).orElse(null);
		answer.setQuestion(question);
		return answerRepository.save(answer);
	}
}
