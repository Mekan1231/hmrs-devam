package kodlamaio.hmrs.business.concretes;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.CandidateSchoolService;
import kodlamaio.hmrs.business.requestes.candidateschool.CreateCandidateSchoolRequest;
import kodlamaio.hmrs.business.requestes.candidateschool.EducationInformation;
import kodlamaio.hmrs.business.requestes.candidateschool.EducationInformationResponse;
import kodlamaio.hmrs.business.requestes.candidateschool.GetByCandidateIdResponse;
import kodlamaio.hmrs.core.utilities.mappers.ModelMapperService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.dataAccess.abstracts.CandidateCVRepository;
import kodlamaio.hmrs.dataAccess.abstracts.CandidateSchoolRepository;
import kodlamaio.hmrs.entities.concrete.candidatecv.CandidateCV;
import kodlamaio.hmrs.entities.concrete.candidatecv.CandidateSchool;

@Service
public class CandidateSchoolManager implements CandidateSchoolService {
    private CandidateSchoolRepository schoolRepository;
    private CandidateCVRepository candidateCVRepository;
    private ModelMapperService mapperService;

    @Autowired
    public CandidateSchoolManager
    (CandidateSchoolRepository schoolRepository, 
     ModelMapperService mapperService,
     CandidateCVRepository candidateCVRepository
    ) 
    {
        this.schoolRepository = schoolRepository;
        this.mapperService=mapperService;
        this.candidateCVRepository=candidateCVRepository;
    }

    @Override
    public Result add(CreateCandidateSchoolRequest candidateSchoolRequest) {
        CandidateSchool candidateSchool =mapperService.forRequest().map(candidateSchoolRequest,CandidateSchool.class);
        schoolRepository.save(candidateSchool);
        return new SuccessResult("Basariyla eklendi");
    }

    @Override
    public DataResult<GetByCandidateIdResponse> getCandidateId(int id) {
        GetByCandidateIdResponse response = new GetByCandidateIdResponse();
        CandidateCV candidateCV = candidateCVRepository.findByCandidateId(id);
        response.setName(candidateCV.getCandidate().getFirstname());
        response.setSurename(candidateCV.getCandidate().getLastname());
        List<CandidateSchool> schools = schoolRepository.findByCandidateCVIdOrderByFinishDateDesc(candidateCV.getId());
        List<EducationInformation> educationInformations = schools.stream().map(
            school->mapperService.forResponse().map(school, EducationInformation.class)
        ).toList();
        List<EducationInformationResponse> informationResponses = new ArrayList<EducationInformationResponse>();
        for (EducationInformation educationInformation : educationInformations) {
            EducationInformationResponse informationResponse = new EducationInformationResponse();
            System.out.println(educationInformation.getSchoolName());
            informationResponse.setSchoolName(educationInformation.getSchoolName());

            System.out.println(educationInformation.getDepartmentName());
            informationResponse.setDepartmentName(educationInformation.getDepartmentName());
            
            System.out.println(educationInformation.getFinishDate());
            if(educationInformation.getFinishDate()==null){
                informationResponse.setFinishDate("Hala Devam Ediyor");
            }else{
                informationResponse.setFinishDate(educationInformation.getFinishDate().toString());
            }
            
            informationResponses.add(informationResponse);
        }

        for (EducationInformationResponse informationResponse2  : informationResponses) {
            System.out.println(informationResponse2.getSchoolName());
            System.out.println(informationResponse2.getDepartmentName());
            System.out.println(informationResponse2.getFinishDate());
        }
        response.setEducationInformations(informationResponses);
        return new SuccessDataResult<GetByCandidateIdResponse>("Basariyla listelendi", response);
    }
    
    
}
