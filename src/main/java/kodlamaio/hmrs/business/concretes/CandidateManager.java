package kodlamaio.hmrs.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.CandidateService;
import kodlamaio.hmrs.business.requestes.candidate.CreateCandidateRequest;
import kodlamaio.hmrs.business.responses.cadidate.GetAllCandidateResponse;
import kodlamaio.hmrs.business.rules.abstracts.CandidateRuleService;
import kodlamaio.hmrs.dataAccess.abstracts.CandidateRepository;
import kodlamaio.hmrs.dataAccess.abstracts.EmailCandidateVerificationRepository;
import kodlamaio.hmrs.dataAccess.abstracts.UserRepository;
import kodlamaio.hmrs.entities.concrete.Candidates;
import kodlamaio.hmrs.entities.concrete.EmailVerificationCandidate;
import lombok.AllArgsConstructor;
import kodlamaio.hmrs.core.utilities.mappers.ModelMapperService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.ErrorResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.core.utilities.verifiations.MernisVerification;

@Service
@AllArgsConstructor
public class CandidateManager implements CandidateService {
    private CandidateRepository candidateRepository;
    private UserRepository userRepository;
    private EmailCandidateVerificationRepository verificationRepository;
    private CandidateRuleService ruleService;
    private MernisVerification verification;
    private ModelMapperService mapper;

    @Override
    public Result add(CreateCandidateRequest request) {
        if(!ruleService.verifyByMernis(verification,request.getIdentityNo())){
            return new ErrorResult("Bu tc no gerçek bir kişiye ait değildir");
        }
        if(!ruleService.comparePassword(request.getPassword(),request.getConfirmedPassword())){
            return new ErrorResult("Şifre tekrarı yalnıştır");
        }
        if(ruleService.checkIfExistEmail(request.getEmail())){
            return new ErrorResult("Bu"+request.getEmail()+" adresi ile daha kayıt bulunmaktadır");
        }
        if(ruleService.checkIfExistIdentity(request.getIdentityNo())){
            return new ErrorResult("Bu"+request.getIdentityNo()+" tc no ile daha kayıt bulunmaktadır");
        }
        if(!ruleService.verifyByEmail(verification,request.getEmail())){
            return new ErrorResult("Email dogrulaması yapılamamıştır");
        }
        
    
        Candidates candidate= this.mapper.forRequest().map(request,Candidates.class);
        //userRepository.save(candidate);
        candidateRepository.save(candidate);
        EmailVerificationCandidate verifiedCandidate = new EmailVerificationCandidate();
        verifiedCandidate.setUser(userRepository.findTopByOrderByIdDesc());
        verificationRepository.save(verifiedCandidate);
        
        return new SuccessResult("Kayıt Başarılı");


    }

    @Override
    public DataResult<List<GetAllCandidateResponse>> getAll() {
        List<Candidates> candidates=this.candidateRepository.findAll();
        List<GetAllCandidateResponse> candidatesResponse=candidates.stream().map(
            candidate->mapper.forResponse().map(candidate,GetAllCandidateResponse.class)
        ).toList();

        return new SuccessDataResult<List<GetAllCandidateResponse>>("Başarıyla listelendi",candidatesResponse);
        
    }
    
}
