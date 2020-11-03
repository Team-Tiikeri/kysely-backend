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
public class QuestionnaireController {
	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private QuestionnaireRepository questionnaireRepository;
	
	@GetMapping("/questionnaires")
	public String indexPage(Model model) {
		model.addAttribute("questionnaires", questionnaireRepository.findAll());
		return "questionnaireList";
	}
	
	@GetMapping("/questionnaires/{id}")
	public String findById(@PathVariable("id") Long questionnaireId, Model model) {
		model.addAttribute("questions", questionRepository.findAll());
		return "questionnaire";
	}
	
	@RequestMapping("/newQuestionnaire")
	public String newQuestionnaire(Model model) {
		model.addAttribute("questionnaire", new Questionnaire());
		return "newquestionnaire";
		
	}
	
	@RequestMapping("/save")
	public String save(Questionnaire questionnaire, Question question) {
		questionnaireRepository.save(questionnaire);
		return "questionnaires";
	}
	
}
