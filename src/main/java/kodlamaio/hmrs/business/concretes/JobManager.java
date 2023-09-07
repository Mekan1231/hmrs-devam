package kodlamaio.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.JobService;
import kodlamaio.hmrs.business.requestes.job.CreateJobRequest;
import kodlamaio.hmrs.business.responses.job.GetAllActiveJobs;
import kodlamaio.hmrs.business.rules.abstracts.JobRuleService;
import kodlamaio.hmrs.core.utilities.mappers.ModelMapperService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.ErrorResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.dataAccess.abstracts.JobRepository;
import kodlamaio.hmrs.entities.concrete.Job;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class JobManager implements JobService {
    @Autowired
    private JobRepository jobRepository;
    private ModelMapperService mapper;
    private JobRuleService ruleService;

    @Override
    public DataResult<List<GetAllActiveJobs>> getAllActiveJobs() {

        List<Job> jobs=jobRepository.getByIsActive(true);
        List<GetAllActiveJobs> allJobResponses=jobs.stream().map(job->mapper.forResponse()
        .map(job, GetAllActiveJobs.class)).toList();
        return new SuccessDataResult<List<GetAllActiveJobs>>("Başarıyla Listelendi",allJobResponses);
    }

    @Override
    public Result add(CreateJobRequest request) {
        if (ruleService.checkIfExistPosition(request.getPosition())) {
            return new ErrorResult("Aynı iş posisyonu tekrar edemez");
        }

        Job job=mapper.forRequest().map(request,Job.class);
        jobRepository.save(job);

        return  new SuccessResult("Yeni iş posisyonu başarıyla eklendi");
    }

    @Override
    public DataResult<List<GetAllActiveJobs>> getAllActiveJobsDeadline() {
        List<Job> jobs=jobRepository.getByIsActiveOrderByDeadlineAsc(true);
        List<GetAllActiveJobs> allJobResponses=jobs.stream().map(job->mapper.forResponse()
        .map(job, GetAllActiveJobs.class)).toList();
        return new SuccessDataResult<List<GetAllActiveJobs>>("Başarıyla Listelendi",allJobResponses);
    }


    @Override
    public DataResult<List<GetAllActiveJobs>> getByCompanyNameAndIsActive(String companyName){
        List<Job> jobs=jobRepository.getByEmployerCompanyNameAndIsActive(companyName, true);
        List<GetAllActiveJobs> allJobResponses=jobs.stream().map(job->mapper.forResponse()
        .map(job, GetAllActiveJobs.class)).toList();
        return new SuccessDataResult<List<GetAllActiveJobs>>("Başarıyla Listelendi",allJobResponses);
    }

    @Override
    public Result inactiveJob(int jobId) {
        try {
            Job job= this.jobRepository.findById(jobId).get();
            job.setActive(false);
            this.jobRepository.save(job);
            return new SuccessResult("Başarıyla güncellendi");
        } catch (Exception e) {
            return new ErrorResult(e.getMessage());
        }
    }
}
