package training.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import training.demo.models.allUsers;

public interface usersRepository extends JpaRepository<allUsers, Long> {
    allUsers findByUsername(String username);
}
