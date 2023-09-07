package kodlamaio.hmrs.business.abstracts;

import kodlamaio.hmrs.business.responses.GetByCandidateIdCvResponse;
import kodlamaio.hmrs.core.utilities.results.DataResult;

public interface CvService {
    DataResult<GetByCandidateIdCvResponse> getByCandidateId(int id);
}
