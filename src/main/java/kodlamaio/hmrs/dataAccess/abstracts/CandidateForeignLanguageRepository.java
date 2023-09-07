package kodlamaio.hmrs.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.hmrs.entities.concrete.candidatecv.CandidateForeignLanguage;

@Repository
public interface CandidateForeignLanguageRepository extends JpaRepository<CandidateForeignLanguage,Integer> {
    List<CandidateForeignLanguage> findByCandidateCVId(int id);
}
