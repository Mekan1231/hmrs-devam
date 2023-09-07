package kodlamaio.hmrs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hmrs.entities.concrete.candidatecv.CandidateCVImage;

public interface CandidateCVImageRepository extends JpaRepository<CandidateCVImage,Integer> {
    
}
