package training.demo.repo;
import org.springframework.data.repository.CrudRepository;
import training.demo.models.lesson;

public interface lessonRepository extends CrudRepository <lesson, Long> {
}