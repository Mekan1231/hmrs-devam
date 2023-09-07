package kodlamaio.hmrs.business.rules.abstracts;

import kodlamaio.hmrs.core.utilities.verifiations.abstracts.Verification;

public interface UserRuleService extends RuleService {
    boolean comparePassword(String password, String confirmedPassword);
    boolean checkIfExistEmail(String email);
    boolean verifyByEmail(Verification verification, String email);

}
