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

			Questionnaire newQuestionnaire = new Questionnaire("Trivia", "kinkkinen kysely");
			Questionnaire newQuestionnaire2 = new Questionnaire("Health", "Are you sick?");
			questionnaireRepository.save(newQuestionnaire);
			questionnaireRepository.save(newQuestionnaire2);
			
			Question question1 = new Question("text", "What is the capital of France?",true, newQuestionnaire);
			Question question2 = new Question("text", "How long do bears hibernate?", true, newQuestionnaire);
			Question question3 = new Question("text", "Which country invented tea?", true, newQuestionnaire);
			Question question4 = new Question("text", "Which organ has four chambers?", true, newQuestionnaire);
			Question question5 = new Question("text", "Which country did AC/DC originate in?", true, newQuestionnaire);
			questionRepository.save(question1);
			questionRepository.save(question2);
			questionRepository.save(question3);
			questionRepository.save(question4);
			questionRepository.save(question5);

			List<Question> questions = questionRepository.findByType("text");
			newQuestionnaire.setQuestions(questions);
//			System.out.println(newQuestionnaire.toString());
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
