package tiikeri.kyselyapp.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tiikeri.kyselyapp.domain.AnswerRepository;
import tiikeri.kyselyapp.domain.Option;
import tiikeri.kyselyapp.domain.OptionRepository;
import tiikeri.kyselyapp.domain.Question;
import tiikeri.kyselyapp.domain.QuestionRepository;

@CrossOrigin
@RestController
public class OptionController {

	@Autowired
	private QuestionRepository questionRepository;

	@Autowired
	private OptionRepository optionRepository;
	
	//list all options by question
	@GetMapping("/api/questions/{id}/options")
	public  @ResponseBody List<Option> findOptionsByQuestion(@PathVariable("id") Long questionId){
		Question question = questionRepository.findById(questionId).orElse(null);
		return (List<Option>) optionRepository.findByQuestion(question);
	}
	
	//list all options
	@GetMapping("/api/options")
	public @ResponseBody List<Option> findAllOptions(){
		return (List<Option>) optionRepository.findAll();
	}
	
	
	//save guestion
	//method returns list of options for each question that has radiobutton/multiple choice
	@PostMapping("/api/options")
	public List<Option> saveOption(@RequestBody List<Option> options) {
		List <Option> savedOptions = new ArrayList<Option>();
		for (int i = 0; i < options.size(); i++) {
			Question question = questionRepository.findById(options.get(i).getQuestion().getQuestionId()).orElse(null);
			Option option = new Option(options.get(i).getContent(), question);
			optionRepository.save(option);
			savedOptions.add(option);
		}
	return savedOptions;
		
	}



}
