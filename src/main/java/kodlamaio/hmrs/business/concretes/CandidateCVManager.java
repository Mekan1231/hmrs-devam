package kodlamaio.hmrs.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlamaio.hmrs.business.abstracts.CandidateCVService;
import kodlamaio.hmrs.business.requestes.candidatecv.CreateCandidateCvRequest;
import kodlamaio.hmrs.core.services.FileUploadService;
import kodlamaio.hmrs.core.utilities.mappers.ModelMapperService;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.dataAccess.abstracts.CandidateCVRepository;
import kodlamaio.hmrs.entities.concrete.candidatecv.CandidateCV;

@Service
public class CandidateCVManager implements CandidateCVService {

    private CandidateCVRepository cvRepository;
    private  ModelMapperService mapper;
    
    @Autowired
    public CandidateCVManager(CandidateCVRepository cvRepository, FileUploadService uploadService, ModelMapperService mapper) {
        this.cvRepository = cvRepository;
        this.mapper=mapper;
    }

    @Override
    public Result add(CreateCandidateCvRequest candidateCvRequest)  {
        CandidateCV candidateCV= this.mapper.forRequest().map(candidateCvRequest, CandidateCV.class);
        this.cvRepository.save(candidateCV);

        return new SuccessResult("Basarıyla eklendi");
    }

    @Override
    public CandidateCV getByCandidateId(int id) {
        
        return this.cvRepository.findByCandidateId(id);
    }

    
    
}
