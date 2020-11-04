package tiikeri.kyselyapp.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	//RESTful to get all questionnaires
	@GetMapping("/questionnaires")
	public @ResponseBody List<Questionnaire> questionnairesListRest() {
		return (List<Questionnaire>)questionnaireRepository.findAll();
	}
	
	//RESTful to get questionnaire with id
	@GetMapping("/questionnaire/{id}")
	public @ResponseBody Optional<Questionnaire> findQuestionnaireRest(@PathVariable("id") Long questionnaireId) {
		return questionnaireRepository.findById(questionnaireId);
	}
	
	@GetMapping("/questionnaire/{id}/questions")
	public @ResponseBody List<Question> findQuestionnaireQuestionsRest(@PathVariable("id") Long questionnaireId) {
		Questionnaire questionnaire = questionnaireRepository.findById(questionnaireId).orElse(null);
		return questionRepository.findByQuestionnaire(questionnaire);
	}
	
	@GetMapping("/questionnairelist")
	public String indexPage(Model model) {
		model.addAttribute("questionnaires", questionnaireRepository.findAll());
		return "questionnairelist";
	}
	
	@GetMapping("/questionnaires/{id}")
	public String findById(@PathVariable("id") Long questionnaireId, Model model) {
		model.addAttribute("questions", questionRepository.findAll());
		return "questionnaire";
	}
	
	@GetMapping("/newquestionnaire")
	public String newQuestionnaire(Model model) {
		model.addAttribute("questionnaire", new Questionnaire());
		return "newquestionnaire";
	}
	
	@PostMapping("/save")
	public String saveQuestionnaire(Questionnaire questionnaire) {
		questionnaireRepository.save(questionnaire);
		return "redirect:/questionnairelist";
	}
	
	// Documentation for the REST API
	@GetMapping("/resthome")
	public String restHomePage() {
		return "resthome";
	}
	
}
