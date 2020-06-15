package training.demo.repo;

import org.springframework.data.repository.CrudRepository;
import training.demo.models.users;

public interface usersRepository extends CrudRepository<users, Long>{
}
