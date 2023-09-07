package kodlamaio.hmrs.business.abstracts;

import kodlamaio.hmrs.business.requestes.candidateschool.CreateCandidateSchoolRequest;
import kodlamaio.hmrs.business.requestes.candidateschool.GetByCandidateIdResponse;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;

public interface CandidateSchoolService {
    Result add(CreateCandidateSchoolRequest candidateSchoolRequest);
    DataResult<GetByCandidateIdResponse> getCandidateId(int id);
}
