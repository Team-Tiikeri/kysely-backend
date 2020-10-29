package tiikeri.kyselyapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import tiikeri.kyselyapp.domain.Question;
import tiikeri.kyselyapp.domain.QuestionRepository;
import tiikeri.kyselyapp.domain.Questionnaire;

import tiikeri.kyselyapp.domain.QuestionnaireRepository;

import java.util.List;


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

			Questionnaire newQuestionnaire = new Questionnaire("Trivia");
			questionnaireRepository.save(newQuestionnaire);
//			
//			Question question1 = new Question("text", "What is the capital of France?",true, newQuestionnaire);
//			Question question2 = new Question("text", "How long do bears hibernate?", true, newQuestionnaire);
//			questionRepository.save(question1);
//			questionRepository.save(question2);
//
//			List<Question> questions = questionRepository.findByType("text");
//			newQuestionnaire.setQuestions(questions);
//
//			log.info("Fetch all questions");
//			for (Question question : questionRepository.findAll()) {
//				log.info(question.toString());
//			}
//			
//			log.info("Fetch all questionaires");
//			for (Questionnaire questionnaire : questionnaireRepository.findAll()) {
//				log.info(questionnaire.toString());
//			}
			
		};
	}
}
