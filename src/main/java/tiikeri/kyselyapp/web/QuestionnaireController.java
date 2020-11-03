package tiikeri.kyselyapp.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.RequestMapping;
||||||| 7d94890
=======
import org.springframework.web.bind.annotation.ResponseBody;
>>>>>>> 7570ee0c96cc52bfb9c0d76dcb3d3795fa1aa314

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
