package kodlamaio.hmrs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.hmrs.entities.concrete.EmailVerificationCandidate;

@Repository
public interface EmailCandidateVerificationRepository extends JpaRepository<EmailVerificationCandidate,Integer> {
    
}
