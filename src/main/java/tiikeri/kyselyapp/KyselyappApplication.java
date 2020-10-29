package tiikeri.kyselyapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import tiikeri.kyselyapp.domain.Question;
import tiikeri.kyselyapp.domain.QuestionRepository;
import tiikeri.kyselyapp.domain.Questionnaire;

import tiikeri.kyselyapp.domain.QuestionnaireRepository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class KyselyappApplication {

	private static final Logger log = LoggerFactory.getLogger(KyselyappApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(KyselyappApplication.class, args);
	}

	@Bean
	public static CommandLineRunner demo(QuestionRepository questionRepository,
			QuestionnaireRepository questionnaireRepository) {
		return (args) -> {

			Question question1 = new Question("text", "What is the capital of France?",true, null);
			Question question2 = new Question("text", "How long do bears hibernate?", true, null);

			questionRepository.save(question1);
			questionRepository.save(question2);

			Questionnaire newQuestionnaire = new Questionnaire("Trivia");
			List<Question> questions = questionRepository.findByType("text");
			newQuestionnaire.setQuestions(questions);

			questionnaireRepository.save(newQuestionnaire);

			log.info("Fetch all questions");
			for (Question question : questionRepository.findAll()) {
				log.info(question.toString());
			}
			
			log.info("Fetch all questionaires");
			for (Questionnaire questionnaire : questionnaireRepository.findAll()) {
				log.info(newQuestionnaire.toString());
			}
			
		};
	}
}
