package kodlamaio.hmrs.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.hmrs.entities.concrete.candidatecv.CandidateJobExperience;

@Repository
public interface CandidateJobExperienceRepository extends JpaRepository<CandidateJobExperience,Integer> {
    List<CandidateJobExperience> findByCandidateCVIdOrderByFinishDateDesc(int id);
}
