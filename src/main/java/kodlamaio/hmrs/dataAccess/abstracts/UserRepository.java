package kodlamaio.hmrs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.hmrs.entities.abstracts.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findTopByOrderByIdDesc();
}
