package tiikeri.kyselyapp.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface QuestionnaireRepository extends CrudRepository<Questionnaire, Long>{
	
	public List<Questionnaire> findByTitle(String title);
}
