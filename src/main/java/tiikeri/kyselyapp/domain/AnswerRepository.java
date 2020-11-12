package tiikeri.kyselyapp.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface AnswerRepository extends CrudRepository<Answer, Long> {

	public List<Answer> findByQuestion(Question question);

}
