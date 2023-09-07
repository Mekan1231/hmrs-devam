package kodlamaio.hmrs.business.rules.abstracts;

public interface JobRuleService extends RuleService {
    boolean checkIfExistPosition(String newPosition);
}
