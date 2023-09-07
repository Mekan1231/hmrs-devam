package kodlamaio.hmrs.core.utilities.verifiations;

import org.springframework.stereotype.Service;

import kodlamaio.hmrs.core.utilities.verifiations.abstracts.Verification;

@Service
public class MernisVerification implements Verification {

   

    @Override
    public boolean verify() {
        return true;
    }
    
}
