package kodlamaio.hmrs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.hmrs.entities.concrete.candidatecv.ForeignLanguage;

@Repository
public interface ForeignLanguageRepository extends JpaRepository<ForeignLanguage,Integer> {
    
}
