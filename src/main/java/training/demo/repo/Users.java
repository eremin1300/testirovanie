package training.demo.repo;

import org.springframework.data.repository.CrudRepository;
import training.demo.models.users;


public interface Users extends CrudRepository<users, Long> {
}
