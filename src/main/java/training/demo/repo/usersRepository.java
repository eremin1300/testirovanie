package training.demo.repo;

import org.springframework.data.repository.CrudRepository;
import training.demo.models.allUsers;

public interface usersRepository extends CrudRepository<allUsers, Long>{
}
