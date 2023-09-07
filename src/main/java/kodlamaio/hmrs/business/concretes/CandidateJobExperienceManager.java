package kodlamaio.hmrs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.CandidateJobExperienceService;
import kodlamaio.hmrs.business.requestes.candidatejobexperience.CreateCandidateJobExperienceRequest;
import kodlamaio.hmrs.business.responses.candidatejobexperience.GetByCandidateIdJobExperience;
import kodlamaio.hmrs.business.responses.candidatejobexperience.GetByCandidateIdJobExperienceResponse;
import kodlamaio.hmrs.business.responses.candidatejobexperience.GetByCandidateIdJobExperienceTemp;
import kodlamaio.hmrs.core.utilities.mappers.ModelMapperService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.dataAccess.abstracts.CandidateCVRepository;
import kodlamaio.hmrs.dataAccess.abstracts.CandidateJobExperienceRepository;
import kodlamaio.hmrs.entities.concrete.candidatecv.CandidateCV;
import kodlamaio.hmrs.entities.concrete.candidatecv.CandidateJobExperience;

@Service
public class CandidateJobExperienceManager implements CandidateJobExperienceService {
    private CandidateJobExperienceRepository jobExperienceRepository;
    private ModelMapperService mapperService;
    private CandidateCVRepository candidateRepository;

    @Autowired
    public CandidateJobExperienceManager(CandidateJobExperienceRepository jobExperienceRepository,
            ModelMapperService mapperService, CandidateCVRepository candidateRepository) {
        this.jobExperienceRepository = jobExperienceRepository;
        this.mapperService = mapperService;
        this.candidateRepository = candidateRepository;
    }

    @Override
    public Result add(CreateCandidateJobExperienceRequest request, int candidateId) {
        CandidateCV candidateCV=candidateRepository.findByCandidateId(candidateId);
        CandidateJobExperience jobExperience=mapperService.forRequest().map(request, CandidateJobExperience.class);
        jobExperience.setCandidateCV(candidateCV);
        jobExperienceRepository.save(jobExperience);
        return new SuccessResult("Basariyla eklendi");
        
    }

    @Override
    public DataResult<GetByCandidateIdJobExperienceResponse> getByCandidateId(int id) {
        CandidateCV candidateCV = candidateRepository.findByCandidateId(id);
        GetByCandidateIdJobExperienceResponse experienceResponse = new GetByCandidateIdJobExperienceResponse();
        experienceResponse.setFirstName(candidateCV.getCandidate().getFirstname());
        experienceResponse.setSecondName(candidateCV.getCandidate().getLastname());
        List<CandidateJobExperience> jobExperiences =this.jobExperienceRepository.findByCandidateCVIdOrderByFinishDateDesc(candidateCV.getId());
        List<GetByCandidateIdJobExperienceTemp> experienceTemps=jobExperiences.stream().map(
            jobExperience->this.mapperService.forResponse().map(jobExperience, GetByCandidateIdJobExperienceTemp.class)
        ).toList();

        List<GetByCandidateIdJobExperience> jobExperiences2 = new ArrayList<GetByCandidateIdJobExperience>();
        for (GetByCandidateIdJobExperienceTemp temp : experienceTemps) {
            GetByCandidateIdJobExperience experience=new GetByCandidateIdJobExperience();
            experience.setCompanyName(temp.getCompanyName());
            experience.setPosition(temp.getPosition());
            experience.setStartDate(temp.getStartDate().toString());

            if(temp.getFinishDate()==null){
                experience.setFinishDate("Devam Ediyor");
            }else{
                experience.setFinishDate(temp.getFinishDate().toString());
            }

            jobExperiences2.add(experience); 
        }
        experienceResponse.setExperiences(jobExperiences2);
        return new SuccessDataResult<GetByCandidateIdJobExperienceResponse>("Basariyla siralandi", experienceResponse);
        
    }
    
}
