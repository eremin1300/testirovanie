package training.demo.repo;

import org.springframework.data.repository.CrudRepository;
import training.demo.models.video;

public interface videoRepository extends CrudRepository<video, Long> {
}