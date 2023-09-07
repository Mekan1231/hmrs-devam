package kodlamaio.hmrs.core.utilities.verifiations;

import org.springframework.stereotype.Service;

import kodlamaio.hmrs.core.utilities.verifiations.abstracts.Verification;

@Service
public class PersonnelVerification implements Verification {

    @Override
    public boolean verify() {
        return true;
    }
    
}
