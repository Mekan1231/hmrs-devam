package kodlamaio.hmrs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.hmrs.entities.abstracts.User;
import kodlamaio.hmrs.entities.concrete.Employer;

@Repository
public interface EmployerRepository extends JpaRepository<Employer,Integer> {
    User findTopByOrderByIdDesc();
}
