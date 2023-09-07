package kodlamaio.hmrs.business.abstracts;

import kodlamaio.hmrs.business.requestes.candidatejobexperience.CreateCandidateJobExperienceRequest;
import kodlamaio.hmrs.business.responses.candidatejobexperience.GetByCandidateIdJobExperienceResponse;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;

public interface CandidateJobExperienceService {
    Result add(CreateCandidateJobExperienceRequest requeste, int candidateId);
    DataResult<GetByCandidateIdJobExperienceResponse> getByCandidateId(int id);
}
