package kodlamaio.hmrs.business.rules.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.rules.abstracts.CandidateRuleService;
import kodlamaio.hmrs.core.utilities.verifiations.abstracts.Verification;
import kodlamaio.hmrs.dataAccess.abstracts.CandidateRepository;
import kodlamaio.hmrs.entities.concrete.Candidates;
import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class CandidateRuleManager implements CandidateRuleService {
    
    
    private List<Candidates> candidates;

    @Autowired
    private CandidateRepository repository;
    
    

    @Override
    public boolean comparePassword(String password, String confirmedPassword) {
        return password.equals(confirmedPassword);
    }

    @Override
    public boolean checkIfExistEmail(String email) {
        this.candidates = this.repository.findAll();
        if (this.candidates==null) {
          return false;  
        }
        for (Candidates candidate : candidates) {
            if (email.equals(candidate.getEmail())) {
                return true;
            }
        }
        return false;
        
    }
    public boolean checkIfExistIdentity(String idendity){
        this.candidates = this.repository.findAll();
        if (this.candidates==null) {
            return false;
        }
        for (Candidates candidate : candidates) {
            if (idendity.equals(candidate.getIdentityNo())) {
                return true;
            }
        }
        return false;
    }

    

    @Override
    public boolean verifyByEmail(Verification verification, String email) {
        return verification.verify();
    }

    public boolean verifyByMernis(Verification verification, String indentityNumber ) {
        return verification.verify();
    }
    
}
