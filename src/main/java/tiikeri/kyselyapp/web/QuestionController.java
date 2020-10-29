package tiikeri.kyselyapp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import tiikeri.kyselyapp.domain.QuestionRepository;
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
	
}
