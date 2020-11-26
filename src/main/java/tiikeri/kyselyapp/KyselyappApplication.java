package tiikeri.kyselyapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import tiikeri.kyselyapp.domain.Answer;
import tiikeri.kyselyapp.domain.AnswerRepository;
import tiikeri.kyselyapp.domain.Option;
import tiikeri.kyselyapp.domain.OptionRepository;
import tiikeri.kyselyapp.domain.Question;
import tiikeri.kyselyapp.domain.QuestionRepository;
import tiikeri.kyselyapp.domain.QuestionType;
import tiikeri.kyselyapp.domain.Questionnaire;

import tiikeri.kyselyapp.domain.QuestionnaireRepository;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class KyselyappApplication {

	private static final Logger log = LoggerFactory.getLogger(KyselyappApplication.class);

	
	public static void main(String[] args) {
		SpringApplication.run(KyselyappApplication.class, args);
	}

	@Bean
	public static CommandLineRunner demo(QuestionRepository questionRepository,
			QuestionnaireRepository questionnaireRepository, AnswerRepository answerRepository, OptionRepository optionRepository) {
		return (args) -> {
			
			
			// Test data for questionnaires
			Questionnaire newQuestionnaire = new Questionnaire("Trivia", "kinkkinen kysely");
			Questionnaire newQuestionnaire2 = new Questionnaire("Health", "Are you sick?");
			Questionnaire newQuestionnaire3 = new Questionnaire("Haaga-Helia",
			"Kysymyksiä liittyen Haaga-Helian ammattikorkeakouluun. Haluamme selvittää olemassa olevaa tietämystä Haaga-Heliasta ja oppia uusia näkökulmia.");
			questionnaireRepository.save(newQuestionnaire);
			questionnaireRepository.save(newQuestionnaire2);
			questionnaireRepository.save(newQuestionnaire3);
			
		
			// Test data for questions
			Question question1 = new Question(QuestionType.RADIOBUTTON, "What is the capital of France?", true, newQuestionnaire);
			Question question2 = new Question(QuestionType.TEXT, "How long do bears hibernate?", true, newQuestionnaire);
			Question question3 = new Question(QuestionType.TEXT, "Which country invented tea?", true, newQuestionnaire);
			Question question4 = new Question(QuestionType.TEXT, "Which organ has four chambers?", true, newQuestionnaire);
			Question question5 = new Question(QuestionType.TEXT, "Which country did AC/DC originate in?", true, newQuestionnaire);
			
			questionRepository.save(question1);
			questionRepository.save(question2);
			questionRepository.save(question3);
			questionRepository.save(question4);
			questionRepository.save(question5);
			
			//Test data for options in questions
			Option option1 = new Option("kinkkukiusaus", question1);
			Option option2 = new Option("makaronilaatikko", question1);
			Option option3 = new Option("lasagne", question1);
			
			optionRepository.save(option1);
			optionRepository.save(option2);
			optionRepository.save(option3);
			
			// Test data for questions
			Question question6 = new Question(QuestionType.RADIOBUTTON, "Milloin Haaga-Helia aloitti toimintansa?", true,  newQuestionnaire3);
			Question question7 = new Question(QuestionType.CHECKBOX, "Mikä on Haaga-Helian motto?", true,  newQuestionnaire3);
			Question question8 = new Question(QuestionType.TEXT,"Mitä Haaga-Heliassa voi opiskella? (Anna vähitään kaksi eri koulutusvaihtoehtoa)", true,  newQuestionnaire3);
			Question question9 = new Question(QuestionType.TEXT, "Mikä on Haaga-Helian opiskelijakunnan nimi?", true,  newQuestionnaire3);
			Question question10 = new Question(QuestionType.TEXT, "Kuka on Haaga-Helian rehtori?", true,  newQuestionnaire3);
			questionRepository.save(question6);
			questionRepository.save(question7);
			questionRepository.save(question8);
			questionRepository.save(question9);
			questionRepository.save(question10);

			
			// Test data for answers
			Answer answer1 = new Answer("Paris", question1);
			answerRepository.save(answer1);

			Answer answer2 = new Answer("2007", question6);
			answerRepository.save(answer2);
			Answer answer3 = new Answer("Haaga-Helia avaa ovat työelämään.", question7);
			answerRepository.save(answer3);
			Answer answer4 = new Answer("Liikunta-ala sekä tietotekniikka.", question8);
			answerRepository.save(answer4);
			Answer answer5 = new Answer("Helga", question9);
			answerRepository.save(answer5);
			Answer answer6 = new Answer("Teemu Kokko", question10);
			answerRepository.save(answer6);

			
			// Listing questions in questionnaires
			List<Question> questions1 = questionRepository.findByType(QuestionType.TEXT);
			newQuestionnaire.setQuestions(questions1);

			List<Question> questions2 = questionRepository.findByType(QuestionType.TEXT);
			newQuestionnaire2.setQuestions(questions2);

			List<Question> questions3 = questionRepository.findByType(QuestionType.TEXT);
			newQuestionnaire3.setQuestions(questions3);
			System.out.println(newQuestionnaire.toString());

			log.info("Fetch all questions");
			for (Question question : questionRepository.findAll()) {
				log.info(question.toString());
			}

			log.info("Fetch all questionnaires");
			for (Questionnaire questionnaire : questionnaireRepository.findAll()) {
				log.info(questionnaire.toString());
			}

		};
	}
}
