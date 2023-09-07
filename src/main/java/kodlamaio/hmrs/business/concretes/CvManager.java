package kodlamaio.hmrs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.CandidateCVService;
import kodlamaio.hmrs.business.abstracts.CandidateForeignLanguageService;
import kodlamaio.hmrs.business.abstracts.CandidateJobExperienceService;
import kodlamaio.hmrs.business.abstracts.CandidateSchoolService;
import kodlamaio.hmrs.business.abstracts.CvService;
import kodlamaio.hmrs.business.requestes.candidateschool.EducationInformationResponse;
import kodlamaio.hmrs.business.responses.GetByCandidateIdCvResponse;
import kodlamaio.hmrs.business.responses.candidateforeignlanguage.GetByCandidateForeignLanguageResponse;
import kodlamaio.hmrs.business.responses.candidatejobexperience.GetByCandidateIdJobExperience;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.ErrorDataResult;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.entities.concrete.candidatecv.CandidateCV;

@Service
public class CvManager implements CvService {
    private CandidateCVService candidateCVService;
    private CandidateJobExperienceService jobExperienceService;
    private CandidateSchoolService schoolService;
    private CandidateForeignLanguageService foreignLanguageService;

    public CvManager(CandidateCVService candidateCVService, CandidateJobExperienceService jobExperienceService,
            CandidateSchoolService schoolService, CandidateForeignLanguageService foreignLanguageService) {
        this.candidateCVService = candidateCVService;
        this.jobExperienceService = jobExperienceService;
        this.schoolService = schoolService;
        this.foreignLanguageService = foreignLanguageService;
    }
    
    @Override
    public DataResult<GetByCandidateIdCvResponse> getByCandidateId(int id) {
        GetByCandidateIdCvResponse cvResponse = new GetByCandidateIdCvResponse();
        List<EducationInformationResponse> informationResponses = new ArrayList<EducationInformationResponse>();
        List<GetByCandidateIdJobExperience> jobExperiences = new ArrayList<GetByCandidateIdJobExperience>();
        List<GetByCandidateForeignLanguageResponse> languageResponses = new ArrayList<GetByCandidateForeignLanguageResponse>();

        CandidateCV candidateCV= this.candidateCVService.getByCandidateId(id);
        if (candidateCV == null){
            return new  ErrorDataResult<>("Boyle bir "+id+" id nolu uyemiz yok");
        }else{
            cvResponse.setFirstName(candidateCV.getCandidate().getFirstname());
            cvResponse.setLastName(candidateCV.getCandidate().getLastname());
            cvResponse.setGithubUrl(candidateCV.getGithubUrl());
            cvResponse.setLinkedinUrl(candidateCV.getLinkedinUrl());
            cvResponse.setCoverLetter(candidateCV.getCoverLetter());
        }

        informationResponses=this.schoolService.getCandidateId(id).getData().getEducationInformations();
        cvResponse.setEducationInformations(informationResponses);

        jobExperiences=this.jobExperienceService.getByCandidateId(id).getData().getExperiences();
        cvResponse.setExperiences(jobExperiences);

        languageResponses=this.foreignLanguageService.getByCandidateId(id).getData();
        cvResponse.setLanguageResponses(languageResponses);

        return new SuccessDataResult<GetByCandidateIdCvResponse>("Basariyla listelendi",cvResponse);
    }
    
}
