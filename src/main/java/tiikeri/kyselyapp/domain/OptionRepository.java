package tiikeri.kyselyapp.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface OptionRepository extends CrudRepository<Option, Long> {
	public List<Option> findByQuestion(Question question);
	
}
