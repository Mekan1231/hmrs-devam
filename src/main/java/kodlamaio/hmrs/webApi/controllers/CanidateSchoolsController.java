package kodlamaio.hmrs.webApi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hmrs.business.abstracts.CandidateSchoolService;
import kodlamaio.hmrs.business.requestes.candidateschool.CreateCandidateSchoolRequest;
import kodlamaio.hmrs.business.requestes.candidateschool.GetByCandidateIdResponse;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;

@RestController
@RequestMapping("api/cadidateschool")
public class CanidateSchoolsController {
    private CandidateSchoolService schoolService;

    @Autowired
    public CanidateSchoolsController(CandidateSchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @PostMapping("/add")
    public Result add(CreateCandidateSchoolRequest request){
        return schoolService.add(request);
    }

    @GetMapping("/getbycandidateid")
    public DataResult<GetByCandidateIdResponse> getByCandidateId(int id){
        return  schoolService.getCandidateId(id);
    }
}
