package tiikeri.kyselyapp.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import tiikeri.kyselyapp.domain.Question;
import tiikeri.kyselyapp.domain.QuestionRepository;
import tiikeri.kyselyapp.domain.Questionnaire;
import tiikeri.kyselyapp.domain.QuestionnaireRepository;

@CrossOrigin
@Controller
public class QuestionnaireController {
	@Autowired
	private QuestionRepository questionRepository;

	@Autowired
	private QuestionnaireRepository questionnaireRepository;

	// RESTful to get all questionnaires
	@GetMapping("api/questionnaires")
	public @ResponseBody List<Questionnaire> questionnairesListRest() {
		return (List<Questionnaire>) questionnaireRepository.findAll();
	}

	// RESTful to get questionnaire by id
	@GetMapping("api/questionnaires/{id}")
	public @ResponseBody Optional<Questionnaire> findQuestionnaireRest(@PathVariable("id") Long questionnaireId) {
		return questionnaireRepository.findById(questionnaireId);
	}

	// RESTful to get questionnaires questions by id
	@GetMapping("api/questionnaires/{id}/questions")
	public @ResponseBody List<Question> findQuestionnaireQuestionsRest(@PathVariable("id") Long questionnaireId) {
		Questionnaire questionnaire = questionnaireRepository.findById(questionnaireId).orElse(null);
		return questionRepository.findByQuestionnaire(questionnaire);
	}
	
	//lists all questionnaires
	@RequestMapping(value = { "/", "/questionnairelist" })
	public String indexPage(Model model) {
		model.addAttribute("questionnaires", questionnaireRepository.findAll());
		return "questionnairelist";
	}
	
	//lists all questions by questionnaire
	@RequestMapping("/questionnairelist/{id}/questionlist")
	public String listQuestions(@PathVariable("id") Long id, Model model) {
		Questionnaire questionnaire = questionnaireRepository.findById(id).orElse(null);
		model.addAttribute("questionnaire", questionnaire);
		model.addAttribute("questions", questionRepository.findByQuestionnaire(questionnaire));
		return "questionlist";
		
	}

	//opens new questionnaire form
	@GetMapping("/newquestionnaire")
	public String newQuestionnaire(Model model) {
		model.addAttribute("questionnaire", new Questionnaire());
		return "newquestionnaire";
	}

	//save questionnaire
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

	// Delete questionnaire
	@GetMapping("/deletequestionnaire/{id}")
	public String deleteQuestionnaire(@PathVariable("id") Long questionnaireId) {
		questionnaireRepository.deleteById(questionnaireId);
		return "redirect:../questionnairelist";
	}

}
