package kodlamaio.hmrs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.hmrs.entities.concrete.EmailVerificationEmployer;

@Repository
public interface EmailVerificationEmployerRepository extends JpaRepository<EmailVerificationEmployer,Integer> {
    
}
