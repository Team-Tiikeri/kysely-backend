package tiikeri.kyselyapp.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import tiikeri.kyselyapp.domain.Question;
import tiikeri.kyselyapp.domain.QuestionRepository;
import tiikeri.kyselyapp.domain.Questionnaire;
import tiikeri.kyselyapp.domain.QuestionnaireRepository;

@CrossOrigin
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
		Question question = new Question();
		Questionnaire questionnaire = questionnaireRepository.findById(id).orElse(null);
		question.setQuestionnaire(questionnaire);
		model.addAttribute("questions", questionRepository.findByQuestionnaire(questionnaire));
		model.addAttribute("question", question);
		return "newquestion";
	}
	@RequestMapping("/savequestion")
	public String save(Question question) {
		questionRepository.save(question);
		return "redirect:/questionnairelist/"+ question.getQuestionnaire().getQuestionnaireId() + "/newquestion";
	}
}
