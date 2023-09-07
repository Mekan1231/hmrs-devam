package kodlamaio.hmrs.business.abstracts;

import java.util.List;

import kodlamaio.hmrs.business.requestes.employer.CreateEmployerRequest;
import kodlamaio.hmrs.business.responses.employer.GetAllEmployerResponse;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;

public interface EmployerService {
    Result add(CreateEmployerRequest request);
    DataResult<List<GetAllEmployerResponse>> getAll();
}
