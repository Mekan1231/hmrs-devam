package kodlamaio.hmrs.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.EmployerService;
import kodlamaio.hmrs.business.requestes.employer.CreateEmployerRequest;
import kodlamaio.hmrs.business.responses.employer.GetAllEmployerResponse;
import kodlamaio.hmrs.business.rules.abstracts.EmployerRuleService;
import kodlamaio.hmrs.core.utilities.mappers.ModelMapperService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.ErrorResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.core.utilities.verifiations.PersonnelVerification;
import kodlamaio.hmrs.dataAccess.abstracts.EmailVerificationEmployerRepository;
import kodlamaio.hmrs.dataAccess.abstracts.EmployerRepository;
import kodlamaio.hmrs.entities.concrete.EmailVerificationEmployer;
import kodlamaio.hmrs.entities.concrete.Employer;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployerManager implements EmployerService {
    private EmployerRepository repository;
    private EmployerRuleService ruleService;
    private PersonnelVerification verification;
    private ModelMapperService mapper;
    private EmailVerificationEmployerRepository verificationEmployerRepository;
    


    public Result add(CreateEmployerRequest request){

        if(!ruleService.comparePassword(request.getPassword(), request.getConfirmedPassword())){
            return new ErrorResult("Şifrenin tekrarı yalnıştır");
        }
        if (ruleService.checkIfExistEmail(request.getEmail())) {
            return new ErrorResult("Bu "+request.getEmail()+" daha önce kayıt yapılmıştır");
        }
        if (!ruleService.checkIfDomainSame(request.getWebSite(), request.getEmail())) {
            return new ErrorResult("Domain ile email domaini aynı olmalıdır");
        }
        if (!ruleService.verifyByEmail(verification, request.getEmail())) {
            return new ErrorResult("Email doğrulaması bekleniyor");
        }
        if (!ruleService.verifyByPersonnel(verification)) {
            return new ErrorResult("Hmrs çalışanı onaylamsı bekleniyor");
        }

        Employer employer =mapper.forRequest().map(request, Employer.class);
        repository.save(employer);

        
        EmailVerificationEmployer emailVerificationEmployer= new EmailVerificationEmployer();
        emailVerificationEmployer.setEmployer(employer);
        verificationEmployerRepository.save(emailVerificationEmployer);

        return new SuccessResult("Kayıt Başarıyla eklendi");

    }

    @Override
    public DataResult<List<GetAllEmployerResponse>> getAll() {
        List<Employer> employers=repository.findAll();
        List<GetAllEmployerResponse> allEmployerResponses=employers.stream()
        .map(employer->mapper.forResponse().map(employer,GetAllEmployerResponse.class)).toList();

        return new SuccessDataResult<List<GetAllEmployerResponse>>("Başarıyla listelendi", allEmployerResponses);
    }
}
