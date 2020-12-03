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
			
			// Test data for answer to question 1
			Answer answer1 = new Answer("Paris", question1);
			answerRepository.save(answer1);
			
			//Test data for options in questions
			Option option1 = new Option("kinkkukiusaus", question1);
			Option option2 = new Option("makaronilaatikko", question1);
			Option option3 = new Option("lasagne", question1);
			
			optionRepository.save(option1);
			optionRepository.save(option2);
			optionRepository.save(option3);
			
			// Test data for questions
			Question question6 = new Question(QuestionType.RADIOBUTTON, "Milloin Haaga-Helia aloitti toimintansa?", true,  newQuestionnaire3);
			Question question7 = new Question(QuestionType.RADIOBUTTON, "Mikä on Haaga-Helian motto?", true,  newQuestionnaire3);
			Question question8 = new Question(QuestionType.CHECKBOX,"Mitä Haaga-Heliassa voi opiskella? (Anna vähitään kaksi eri koulutusvaihtoehtoa)", true,  newQuestionnaire3);
			Question question9 = new Question(QuestionType.TEXT, "Mikä on Haaga-Helian opiskelijakunnan nimi?", true,  newQuestionnaire3);
			Question question10 = new Question(QuestionType.TEXT, "Kuka on Haaga-Helian rehtori?", true,  newQuestionnaire3);
			questionRepository.save(question6);
			questionRepository.save(question7);
			questionRepository.save(question8);
			questionRepository.save(question9);
			questionRepository.save(question10);
			
			//Test data for options in questions in Haaga-helia questionnaire, question 1
			Option option4 = new Option("2007", question6);
			Option option5 = new Option("2009", question6);
			Option option6 = new Option("1990", question6);
			
			optionRepository.save(option4);
			optionRepository.save(option5);
			optionRepository.save(option6);
			
			
			
			//Test data for answers in question: Mikä on Haaga-Helian motto?
			Option option7 = new Option("Just do it!", question7);
			Option option8 = new Option("Avaa ovet työelämään", question7);
			Option option9 = new Option("Haaga-Helia, Reilusti luonnetta!", question7);
			Option option10 = new Option("Taste the feeling!", question7);
			
			
			Answer answer18 = new Answer("Haaga-Helia, Reilusti luonnetta!", question7);
			Answer answer19 = new Answer("Avaa ovet työelämään", question7);
			Answer answer20 = new Answer("Haaga-Helia, Reilusti luonnetta!", question7);
			Answer answer21 = new Answer("Avaa ovet työelämään", question7);
			Answer answer22 = new Answer("Avaa ovet työelämään", question7);
			Answer answer23 = new Answer("Avaa ovet työelämään", question7);
			Answer answer24 = new Answer("Avaa ovet työelämään", question7);
			Answer answer25 = new Answer("Taste the feeling!", question7);
			Answer answer26 = new Answer("Just do it!", question7);
			
			answerRepository.save(answer18);
			answerRepository.save(answer19);
			answerRepository.save(answer20);
			answerRepository.save(answer21);
			answerRepository.save(answer22);
			answerRepository.save(answer23);
			answerRepository.save(answer24);
			answerRepository.save(answer25);
			answerRepository.save(answer26);
			
			optionRepository.save(option7);
			optionRepository.save(option8);
			optionRepository.save(option9);
			optionRepository.save(option10);
			
			//Test data for options in questions in Haaga-helia questionnaire, question 3
			Option option11 = new Option("Puutarhatalous", question8);
			Option option12 = new Option("Liiketalous", question8);
			Option option13 = new Option("Tietojenkäsittely", question8);
			Option option14 = new Option("Metsätalous", question8);
			Option option15 = new Option("Sosionomi", question8);
			
			optionRepository.save(option11);
			optionRepository.save(option12);
			optionRepository.save(option13);
			optionRepository.save(option14);
			optionRepository.save(option15);

			//Test data for answers in question: Milloin Haaga-Helia aloitti toimintansa?
			Answer answer66 = new Answer("2007", question6);
			Answer answer7 = new Answer("2007", question6);
			Answer answer8 = new Answer("2009", question6);
			Answer answer9 = new Answer("1990", question6);
			Answer answer10 = new Answer("1990", question6);
			Answer answer11 = new Answer("2009", question6);
			Answer answer12 = new Answer("2007", question6);
			Answer answer13 = new Answer("2007", question6);
			Answer answer14 = new Answer("2009", question6);
			Answer answer15 = new Answer("1990", question6);
			Answer answer16 = new Answer("1990", question6);
			Answer answer17 = new Answer("2009", question6);
			
			answerRepository.save(answer66);
			answerRepository.save(answer7);
			answerRepository.save(answer8);
			answerRepository.save(answer9);
			answerRepository.save(answer10);
			answerRepository.save(answer11);
			answerRepository.save(answer12);
			answerRepository.save(answer13);
			answerRepository.save(answer14);
			answerRepository.save(answer15);
			answerRepository.save(answer16);
			answerRepository.save(answer17);
		
			
			//Test data for answers in question: Mitä Haaga-Heliassa voi opiskella? (Anna vähitään kaksi eri koulutusvaihtoehtoa?
			Answer answer31 = new Answer("Tietojenkäsittely", question8);
			Answer answer32 = new Answer("Tietojenkäsittely", question8);
			Answer answer33 = new Answer("Tietojenkäsittely", question8);
			Answer answer34 = new Answer("Tietojenkäsittely", question8);
			Answer answer35 = new Answer("Liiketalous", question8);
			Answer answer36 = new Answer("Liiketalous", question8);
			Answer answer37 = new Answer("Liiketalous", question8);
			Answer answer38 = new Answer("Metsätalous", question8);
			Answer answer39 = new Answer("Sosionomi", question8);
			Answer answer40 = new Answer("Puutarhatalous", question8);
			
			answerRepository.save(answer31);
			answerRepository.save(answer32);
			answerRepository.save(answer33);
			answerRepository.save(answer34);
			answerRepository.save(answer35);
			answerRepository.save(answer36);
			answerRepository.save(answer37);
			answerRepository.save(answer38);
			answerRepository.save(answer39);
			answerRepository.save(answer40);

			
			
			//Test data for answers in question: Mikä on Haaga-Helian opiskelijakunnan nimi?
			Answer answer50 = new Answer("Helga", question9);
			Answer answer51 = new Answer("Helga", question9);
			Answer answer53 = new Answer("Atkins", question9);
			Answer answer54 = new Answer("Sture", question9);
			
			answerRepository.save(answer50);
			answerRepository.save(answer51);
			answerRepository.save(answer53);
			answerRepository.save(answer54);
			
			
			//Test data for answers in question: Kuka on Haaga-Helian rehtori?
			Answer answer61 = new Answer("Teemu Kokko", question10);
			Answer answer62 = new Answer("Aku Ankka", question10);
			Answer answer63 = new Answer("Pablo Maas Lopez", question10);
			Answer answer64 = new Answer("Sauli Niinistö", question10);

			answerRepository.save(answer61);
			answerRepository.save(answer62);
			answerRepository.save(answer63);
			answerRepository.save(answer64);
			
			

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
