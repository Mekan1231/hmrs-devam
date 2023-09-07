package kodlamaio.hmrs.webApi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hmrs.business.abstracts.CandidateJobExperienceService;
import kodlamaio.hmrs.business.requestes.candidatejobexperience.CreateCandidateJobExperienceRequest;
import kodlamaio.hmrs.business.responses.candidatejobexperience.GetByCandidateIdJobExperienceResponse;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;

@RestController
@RequestMapping("api/candidateexperience")
public class CandidateJobExperiencesController {
    private CandidateJobExperienceService jobExperienceService;

    @Autowired
    public CandidateJobExperiencesController(CandidateJobExperienceService jobExperienceService) {
        this.jobExperienceService = jobExperienceService;
    }

    @PostMapping("/add")
    public Result add( CreateCandidateJobExperienceRequest request,int candidateId){
        return this.jobExperienceService.add(request, candidateId);
    }

    @GetMapping("/getbycandidateid")
    public DataResult<GetByCandidateIdJobExperienceResponse> getByCandidateId(@RequestParam int id ){
        return this.jobExperienceService.getByCandidateId(id);
    }
}
