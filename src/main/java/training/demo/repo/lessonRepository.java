package training.demo.repo;
import org.springframework.data.repository.CrudRepository;
import training.demo.models.lesson;

public interface lessonRepository extends CrudRepository <lesson, Long> {
    Iterable<lesson> findByName(String name);
    Iterable<lesson> findByNameAndId(String name, Long id);
}