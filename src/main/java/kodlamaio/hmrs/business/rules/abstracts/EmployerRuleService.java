package kodlamaio.hmrs.business.rules.abstracts;

import kodlamaio.hmrs.core.utilities.verifiations.abstracts.Verification;

public interface EmployerRuleService extends UserRuleService {
    public boolean verifyByPersonnel(Verification verification);
    public boolean checkIfDomainSame(String website, String emailDomain);
}
