package kodlamaio.hmrs.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.hmrs.entities.concrete.candidatecv.CandidateSchool;

@Repository
public interface CandidateSchoolRepository extends JpaRepository<CandidateSchool,Integer> {
    List<CandidateSchool> findByCandidateCVIdOrderByFinishDateDesc(int id);
}
