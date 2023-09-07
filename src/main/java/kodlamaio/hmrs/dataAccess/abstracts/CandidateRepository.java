package kodlamaio.hmrs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.hmrs.entities.abstracts.User;
import kodlamaio.hmrs.entities.concrete.Candidates;

@Repository
public interface CandidateRepository extends JpaRepository<Candidates,Integer> {
    User findTopByOrderByIdDesc();
}
