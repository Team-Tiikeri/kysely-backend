package tiikeri.kyselyapp.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Question, Long> {
	
	public List<Question> findByType(String type);

}
