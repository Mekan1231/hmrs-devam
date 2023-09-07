package kodlamaio.hmrs.business.abstracts;

import java.util.List;

import kodlamaio.hmrs.business.requestes.candidateforeignlanguage.CreateCandidateForeiegnLanguageRequest;
import kodlamaio.hmrs.business.responses.candidateforeignlanguage.GetByCandidateForeignLanguageResponse;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;

public interface CandidateForeignLanguageService {
    Result add(CreateCandidateForeiegnLanguageRequest request);
    DataResult<List<GetByCandidateForeignLanguageResponse>> getByCandidateId(int id);
}
