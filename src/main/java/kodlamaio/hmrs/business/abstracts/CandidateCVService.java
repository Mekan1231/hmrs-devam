package kodlamaio.hmrs.business.abstracts;

import kodlamaio.hmrs.business.requestes.candidatecv.CreateCandidateCvRequest;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.concrete.candidatecv.CandidateCV;

public interface CandidateCVService {
    Result add(CreateCandidateCvRequest candidateCvRequest);
    CandidateCV getByCandidateId(int id);
}
