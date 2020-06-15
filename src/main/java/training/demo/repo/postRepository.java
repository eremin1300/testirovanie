package training.demo.repo;

import org.springframework.data.repository.CrudRepository;
import training.demo.models.lesson;
import training.demo.models.video;
import training.demo.models.test;

public interface postRepository extends CrudRepository <lesson, Long> {
}
