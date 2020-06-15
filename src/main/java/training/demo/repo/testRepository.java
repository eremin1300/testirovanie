package training.demo.repo;

import org.springframework.data.repository.CrudRepository;
import training.demo.models.test;

public interface testRepository extends CrudRepository<test, Long> {
}
