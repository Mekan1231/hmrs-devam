package kodlamaio.hmrs.business.abstracts;

import java.util.List;

import kodlamaio.hmrs.business.requestes.job.CreateJobRequest;
import kodlamaio.hmrs.business.responses.job.GetAllActiveJobs;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;

public interface JobService {
    DataResult<List<GetAllActiveJobs>> getAllActiveJobs();
    DataResult<List<GetAllActiveJobs>> getAllActiveJobsDeadline();
    DataResult<List<GetAllActiveJobs>> getByCompanyNameAndIsActive(String companyName);
    Result add(CreateJobRequest request);
    Result inactiveJob(int jobId);
}
