package kodlamaio.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlamaio.hmrs.business.abstracts.CandidateForeignLanguageService;
import kodlamaio.hmrs.business.requestes.candidateforeignlanguage.CreateCandidateForeiegnLanguageRequest;
import kodlamaio.hmrs.business.responses.candidateforeignlanguage.GetByCandidateForeignLanguageResponse;
import kodlamaio.hmrs.core.utilities.mappers.ModelMapperService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.dataAccess.abstracts.CandidateCVRepository;
import kodlamaio.hmrs.dataAccess.abstracts.CandidateForeignLanguageRepository;
import kodlamaio.hmrs.dataAccess.abstracts.ForeignLanguageRepository;
import kodlamaio.hmrs.entities.concrete.candidatecv.CandidateCV;
import kodlamaio.hmrs.entities.concrete.candidatecv.CandidateForeignLanguage;
import kodlamaio.hmrs.entities.concrete.candidatecv.ForeignLanguage;

@Service
public class CandidateForeignLanguageManager implements CandidateForeignLanguageService {
    private CandidateForeignLanguageRepository foreignLanguageRepository;
    private CandidateCVRepository cvRepository;
    private ModelMapperService mapperService;
    @Autowired
    private ForeignLanguageRepository languageRepository;



    
    @Autowired
    public CandidateForeignLanguageManager(CandidateForeignLanguageRepository foreignLanguageRepository,
            ModelMapperService mapperService, CandidateCVRepository cvRepository) {
        this.foreignLanguageRepository = foreignLanguageRepository;
        this.cvRepository=cvRepository;
        this.mapperService=mapperService;

    }



    @Override
    public Result add(CreateCandidateForeiegnLanguageRequest request) {
        //CandidateForeignLanguage foreignLanguage= this.mapperService.forRequest().map(request, CandidateForeignLanguage.class);
        CandidateCV candidateCV=this.cvRepository.findById(request.getCvId()).get();
        ForeignLanguage foreignLanguage= new ForeignLanguage();
        foreignLanguage.setName(request.getLanguage());
        foreignLanguage.setLevel(request.getLevel());
        this.languageRepository.save(foreignLanguage);
        CandidateForeignLanguage foreignLanguageEntity=new  CandidateForeignLanguage();
        foreignLanguageEntity.setCandidateCV(candidateCV);
        foreignLanguageEntity.setForeignLanguage(foreignLanguage);
        this.foreignLanguageRepository.save(foreignLanguageEntity);
        return new SuccessResult("Basariyla Eklendi");

    }



    @Override
    public DataResult<List<GetByCandidateForeignLanguageResponse>> getByCandidateId(int id) {
        CandidateCV candidateCV =this.cvRepository.findByCandidateId(id);
        List<CandidateForeignLanguage> languages=this.foreignLanguageRepository.findByCandidateCVId(candidateCV.getId());
        List<GetByCandidateForeignLanguageResponse> candidateForeignLanguageResponses=languages.stream().map(
            language->this.mapperService.forResponse().map(language, GetByCandidateForeignLanguageResponse.class)
        ).toList();

        return new SuccessDataResult<List<GetByCandidateForeignLanguageResponse>>("Basariyla getirildi", candidateForeignLanguageResponses);
    }
    
}
