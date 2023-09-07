package kodlamaio.hmrs.business.rules.abstracts;

import kodlamaio.hmrs.core.utilities.verifiations.abstracts.Verification;

public interface CandidateRuleService extends UserRuleService {
    boolean checkIfExistIdentity(String idendity);
    boolean verifyByMernis(Verification verification, String indentityNumber );
}
