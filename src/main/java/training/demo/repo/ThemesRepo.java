package training.demo.repo;

import org.springframework.data.repository.CrudRepository;
import training.demo.models.test;

public interface ThemesRepo extends CrudRepository<test, Long> {
}
