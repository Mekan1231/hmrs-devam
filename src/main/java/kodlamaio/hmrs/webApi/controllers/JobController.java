package kodlamaio.hmrs.webApi.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hmrs.business.abstracts.JobService;
import kodlamaio.hmrs.business.requestes.job.CreateJobRequest;
import kodlamaio.hmrs.business.responses.job.GetAllActiveJobs;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/Job")
@AllArgsConstructor
public class JobController {
    @Autowired
    private JobService jobService;

    @GetMapping("/getallactivejobs")
    public DataResult<List<GetAllActiveJobs>> getAll(){
        return jobService.getAllActiveJobs();
    }
    @GetMapping("/getallactivejobsdea")
    public DataResult<List<GetAllActiveJobs>> getAllActiveJobsDeadline(){
        return jobService.getAllActiveJobsDeadline();
    }

    @PostMapping("/add")
    public Result add(@RequestBody CreateJobRequest request) {
        return  jobService.add(request);
    }

    @GetMapping("/getbycompanynameandisactive")
    public DataResult<List<GetAllActiveJobs>> getByCompanyAndIsActive(String companyName){
        return this.jobService.getByCompanyNameAndIsActive(companyName);
    }

    @PutMapping("/inactiveJob/{jobId}")
    public Result inactiveJob(@PathVariable int jobId) {
        return this.jobService.inactiveJob(jobId);
    }

    
    
}
