package training.demo.repo;

import org.springframework.data.repository.CrudRepository;
import training.demo.models.posts;

public interface postRepository extends CrudRepository <posts, Long> {
}
public interface videoRepository extends CrudRepository <video, Long> {
}
public interface testRepository extends CrudRepository <test, Long> {
}
