package tiikeri.kyselyapp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import tiikeri.kyselyapp.domain.Option;
import tiikeri.kyselyapp.domain.OptionRepository;
import tiikeri.kyselyapp.domain.QuestionRepository;

@CrossOrigin
@Controller
public class OptionController {

	@Autowired
	private QuestionRepository questionRepository;

	@Autowired
	private OptionRepository optionRepository;

	@PostMapping("/saveoption")
	public String saveOption(Option option) {
		optionRepository.save(option);
		return "redirect:../newquestion";
	}

	@GetMapping("/newoption")
	public String newOption(Model model) {
		model.addAttribute("option", new Option());
		return "newquestion";
	}

}
