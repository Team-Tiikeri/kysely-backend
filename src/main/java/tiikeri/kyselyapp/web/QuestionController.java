package tiikeri.kyselyapp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import tiikeri.kyselyapp.domain.Question;
import tiikeri.kyselyapp.domain.QuestionRepository;
import tiikeri.kyselyapp.domain.Questionnaire;
import tiikeri.kyselyapp.domain.QuestionnaireRepository;

@Controller
public class QuestionController {
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired 
	private QuestionnaireRepository questionnaireRepository;
	
	
	@GetMapping("/question/{id}/")
	public String findById(@PathVariable("id") Long questionnaireId, Model model) {
		model.addAttribute("question", questionRepository.findById(questionnaireId));
		return  null;
	}
	
	@RequestMapping("/questionnairelist/{id}/newquestion")
	public String addQuestion(@PathVariable("id") Long id, Model model) {
		model.addAttribute("questions", questionRepository.findAll());
		model.addAttribute("question", new Question());
		model.addAttribute("questionnaire", questionnaireRepository.findById(id));
		return "newquestion";
	}
	@RequestMapping("/savequestion")
	public String save(Questionnaire questionnaire, Question question, Model model) {
		questionRepository.save(question);
		model.addAttribute("questions", questionRepository.findAll());
		model.addAttribute("question", new Question());
		model.addAttribute("questionnaire", questionnaireRepository.findById(questionnaire.getQuestionnaireId()));
		return "redirect:/questionnairelist/"+ questionnaire.getQuestionnaireId() + "/newquestion";
	}
}
