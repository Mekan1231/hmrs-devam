package kodlamaio.hmrs.business.abstracts;

import java.util.List;

import kodlamaio.hmrs.business.requestes.candidate.CreateCandidateRequest;
import kodlamaio.hmrs.business.responses.cadidate.GetAllCandidateResponse;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;

public interface CandidateService {
    Result add(CreateCandidateRequest request);
    DataResult<List<GetAllCandidateResponse>> getAll();
}
