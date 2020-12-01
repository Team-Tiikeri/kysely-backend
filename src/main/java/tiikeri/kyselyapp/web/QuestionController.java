package tiikeri.kyselyapp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import tiikeri.kyselyapp.domain.Question;
import tiikeri.kyselyapp.domain.QuestionRepository;
import tiikeri.kyselyapp.domain.QuestionType;
import tiikeri.kyselyapp.domain.Questionnaire;
import tiikeri.kyselyapp.domain.QuestionnaireRepository;

@CrossOrigin
@Controller
public class QuestionController {

	@Autowired
	private QuestionRepository questionRepository;

	@Autowired
	private QuestionnaireRepository questionnaireRepository;

	@GetMapping("/question/{id}")
	public String findById(@PathVariable("id") Long questionnaireId, Model model) {
		model.addAttribute("question", questionRepository.findById(questionnaireId));
		return null;
	}

	
	@RequestMapping("/questionnairelist/{id}/questionlist/newquestion")
	public String addQuestion(@PathVariable("id") Long id, Model model) {
		Question question = new Question();
		
		Questionnaire questionnaire = questionnaireRepository.findById(id).orElse(null);
		question.setQuestionnaire(questionnaire);
		model.addAttribute("questions", questionRepository.findByQuestionnaire(questionnaire));
		model.addAttribute("question", question);
		model.addAttribute("types", QuestionType.values());
		return "newquestion";
	}

	@RequestMapping("/savequestion")
	public String save(Question question) {
		questionRepository.save(question);
		return "redirect:/questionnairelist/" + question.getQuestionnaire().getQuestionnaireId() + "/questionlist";
	}

	// Delete question
	@GetMapping("/deletequestion/{id}")
	public String deleteQuestion(@PathVariable("id") Long questionId) {
		// Create a new question so that we can use questionnaireid in redirect
		Question question = questionRepository.findById(questionId).orElse(null);
		questionRepository.deleteById(questionId);
		return "redirect:../questionnairelist/" + question.getQuestionnaire().getQuestionnaireId() + "/questionlist";
	}
	
	@GetMapping("/addoptions/{id}")
	public String addOptions(@PathVariable("id") Long questionId, Model model) {
		model.addAttribute("question", questionRepository.findById(questionId).orElse(null));
		model.addAttribute("id", questionId);
		return "addoptions";
	}

	// REST Endpoints

	@GetMapping("/api/questions")
	public @ResponseBody List<Question> getQuestions() {
		return (List<Question>) questionRepository.findAll();
	}

	@GetMapping("/api/questions/{id}")
	public @ResponseBody Question getQuestionsById(@PathVariable("id") long questionId) {
		return questionRepository.findById(questionId).orElse(null);
	}

}
