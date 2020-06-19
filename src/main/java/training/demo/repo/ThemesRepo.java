package training.demo.repo;

import org.springframework.data.repository.CrudRepository;
import training.demo.models.themes;

public interface ThemesRepo extends CrudRepository<themes, Long> {
}
